package com.charlee.thread.HandwritingThreadPool;

public interface ThreadFactory {
    /**
     * 创建定制化线程
     * @param runnable
     * @return thread
     */
    Thread createThread(Runnable runnable);
}
