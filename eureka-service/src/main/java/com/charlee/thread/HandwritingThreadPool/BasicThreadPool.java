package com.charlee.thread.HandwritingThreadPool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicThreadPool extends Thread implements ThreadPool {

    /**
     * initSize: 初始化线程数
     * maxSize: 线程池最大线程数
     * coreSize: 线程核心数
     * activeCount: 当前活跃线程数
     * threadFactory: 线程工厂, 配置线程创建需要的参数
     * runnableQueue: 任务队列
     * isShutdown: 是否关闭线程池
     * threadQueue: 工作线程队列
     * DEFAULT_THREAD_FACTORY: 默认的线程工厂
     * keepAliveTime: 线程存活时间
     */
    private final int initSize;
    private final int maxSize;
    private final int coreSize;
    private int activeCount;
    private final ThreadFactory threadFactory;
    private final RunnableQueue runnableQueue;
    private volatile boolean isShutdown = false;
    private Queue<ThreadTask> threadQueue = new ArrayDeque<>();
    private final static RunnableDenyPolicy DEFAULT_DENY_POLICY = new RunnableDenyPolicy.DiscardDenyPolicy();
    private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();
    private final static long DEFAULT_KEEP_ALIVE_TIME = 10;
    private final long keepAliveTime;
    private final TimeUnit timeUnit;

    public BasicThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
        this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY, queueSize, DEFAULT_DENY_POLICY,
                DEFAULT_KEEP_ALIVE_TIME, TimeUnit.SECONDS);
    }

    public BasicThreadPool(int initSize, int maxSize, int coreSize, ThreadFactory threadFactory, int queueSize,
                           RunnableDenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    /**
     * 初始化线程池, 创建initThread
     */
    private void init() {
        start();
        for (int i = 0; i < initSize; ++i) {
            newThread();
        }
    }

    /**
     * 创建线程添加到线程队列, 然后用该线程执行ThreadTask任务(层层封装, 封装用户提交的任务)
     */
    private void newThread() {
        InternalTask internalTask = new InternalTask(runnableQueue);
        //使用自定义的线程工厂创建线程
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        System.out.println(threadTask.thread.getName() + "被添加");
        //添加到线程队列
        threadQueue.offer(threadTask);
        this.activeCount++;
        //被添加后的线程执行start
        thread.start();
    }

    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown) {
            throw new IllegalStateException("The thread pool id destroy");
        }
        //将用户提交的任务放到runnableQueue中, 等待线程队列中线程执行
        this.runnableQueue.offer(runnable);
    }

    private void removeThread() {
        //ArrayDeque的remove就是removeFirst
        ThreadTask threadTask = threadQueue.remove();
        //设置当前线程flag, 在InternalTask中跳出循环自动结束线程生命
        threadTask.internalTask.stop();
        this.activeCount--;
    }

    @Override
    public void run() {
        while (!isShutdown && !isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutdown = true;
                break;
            }
            synchronized (this) {
                if (isShutdown) {
                    break;
                }
                //当前队列中有任务还没有处理, 且activeCount < coreSize
                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    //此处i曾写做i=0,导致多创建了一个线程,在没有任务的时候该线程一直保持wait
                    //因为关闭pool,该线程没有add到threadQueue,导致Interrupt失败,最终导致线程一直运行中
                    for (int i = initSize; i < coreSize; ++i) {
                        newThread();
                    }
                    //防止后面的if判断创建线程数超过coreSize, 在coreSize还没有满的时候, 只执行当前的if
                    continue;
                }
                //当上面if中创建的线程数不足的时候, 就扩大线程池线程数, 直到maxSize
                if (runnableQueue.size() > 0 && activeCount < maxSize) {
                    for (int i = coreSize; i < maxSize; ++i) {
                        newThread();
                    }
                }
                //当没有任务, 但是activeCount线程数超出coreSize大小, 回收超出coreSize的线程
                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    for (int i = coreSize; i < activeCount; ++i) {
                        removeThread();
                    }
                }
            }
        }
    }

    @Override
    public void shutdown() {
        synchronized (this) {
            if (!isShutdown) {
                isShutdown = true;
                System.out.println("threadQueue size:" + threadQueue.size());
                threadQueue.forEach(threadTask -> {
                    //调用internalTask中stop, 设置当前线程运行标志为false
                    threadTask.internalTask.stop();
                    //设置线程中断状态
                    threadTask.thread.interrupt();
                    System.out.println(threadTask.thread.getName());
                });
                System.out.println("threadQueue中线程已经关闭");
                //当前线程池自己也要关闭
                this.interrupt();
            }
        }
    }

    @Override
    public int getInitSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.coreSize;
    }

    @Override
    public int getQueueSize() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.runnableQueue.size();
    }

    @Override
    public int getActiveCount() {
        if (isShutdown) {
            throw new IllegalStateException("The thread pool is destroy");
        }
        return this.activeCount;
    }

    @Override
    public boolean isShutdown() {
        return this.isShutdown;
    }

    /**
     * 内部类, 定义自己默认的线程工厂
     */
    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
        //设置线程组
        private static final ThreadGroup GROUP = new ThreadGroup("MyThreadPool-" + GROUP_COUNTER.getAndDecrement());
        private static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread createThread(Runnable runnable) {
            //创建定制化的线程
            return new Thread(GROUP, runnable, " thread-pool-" + COUNTER.getAndDecrement());
        }
    }

    /**
     * 封装InternalTask, 与每次创建的线程绑定在一起
     */
    private class ThreadTask {
        Thread thread;
        InternalTask internalTask;

        ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }
    }

}