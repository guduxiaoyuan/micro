package com.charlee.thread.HandwritingThreadPool;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue{

    /**
     * limit: 限制当前runnableList中还能存放多少内容
     * denyPolicy: 拒绝策略
     * runnableList: 存放runnable的缓冲区
     * threadPool: 线程池
     */
    private final int limit;
    private  final RunnableDenyPolicy denyPolicy;
    private final LinkedList<Runnable> runnableList = new LinkedList<>();
    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, RunnableDenyPolicy denyPolicy, ThreadPool threadPool){
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                //用户提交的任务大于限制条件, 执行对应的拒绝策略
                System.out.println(runnableList.size() + " >= " + limit + " execute deny policy");
                denyPolicy.reject(runnable, threadPool);
            } else {
                //添加任务到任务队列尾部, 有任务存在, 唤醒刚才wait的线程
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException{
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    //从RunnableQueue中取出任务, 如果任务为空, 使当前线程wait
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            //移除任务缓冲区的第一个
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }

}
