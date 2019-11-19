package com.charlee.thread.HandwritingThreadPool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {
        //初始化线程数:2, 最大线程数:6, 核心线程数:4, 任务队列大小:1000
        final BasicThreadPool threadPool = new BasicThreadPool(2, 6, 4, 1000);
        //创建20个任务提交进行执行
        for (int i = 0; i < 1; ++i) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println(Thread.currentThread().getName() + " is running and done.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //此处用于测试线程池运行时基本信息状态
//        for (int j = 0; j < 1000; ++j) {
//            System.out.println("getActiveCount: " + threadPool.getActiveCount());
//            System.out.println("getQueueSize: " + threadPool.getQueueSize());
//            System.out.println("getCoreSize: " + threadPool.getCoreSize());
//            System.out.println("getMaxSize: " + threadPool.getMaxSize());
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            TimeUnit.SECONDS.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("shutdown");
        //测试线程池shutdown功能
        threadPool.shutdown();
    }

}
