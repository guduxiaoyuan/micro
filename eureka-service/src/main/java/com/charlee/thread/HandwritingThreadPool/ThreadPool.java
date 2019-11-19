package com.charlee.thread.HandwritingThreadPool;

public interface ThreadPool {

    /**
     * 执行提交的Runnable任务
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获得线程池初始化大小
     * @return initSize
     */
    int getInitSize();

    /**
     * 获得线程池最大线程数
     * @return maxSize
     */
    int getMaxSize();

    /**
     * 获取线程池核心线程数
     * @return coreSize
     */
    int getCoreSize();

    /**
     * 获取线程池中用于缓存任务队列的大小
     * @return queueSize
     */
    int getQueueSize();

    /**
     * 获取线程池中国活跃的线程数量
     * @return activeCount
     */
    int getActiveCount();

    /**
     * 查看线程池是否shutdown
     * @return boolan
     */
    boolean isShutdown();

}
