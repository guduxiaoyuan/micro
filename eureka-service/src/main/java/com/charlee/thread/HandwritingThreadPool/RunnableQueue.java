package com.charlee.thread.HandwritingThreadPool;

public interface RunnableQueue {
    /**
     * 缓存提交到线程池中的任务
     * @param runnable
     */
    void offer(Runnable runnable);

    /**
     * 从缓存中获取Runnable任务
     * 如果没有任务, 调用者线程挂起, 在某些特定的时候抛出中断异常
     * @throws InterruptedException
     * @return runnable
     */
    Runnable take() throws InterruptedException;

    /**
     * 缓冲区大小
     * @return size
     */
    int size();

}
