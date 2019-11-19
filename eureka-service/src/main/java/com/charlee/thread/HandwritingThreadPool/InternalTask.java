package com.charlee.thread.HandwritingThreadPool;

public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;
    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue){
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //如果线程没有关闭, 就让该线程死循环, 处理每一个提交的任务
        while (running && !Thread.currentThread().isInterrupted()){
            try {
                System.out.println("线程即将执行");
                //处于中断时候的线程不做处理
                //获取RunnableQueue中任务, 然后执行
                Runnable take = runnableQueue.take();
                System.out.println("runnableQueue.take(): " + take.toString());
                take.run();
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    /**
     * 停止当前任务, 设置其running为false, 在shutdown中处理
     */
    public void stop(){
        this.running = false;
    }

}
