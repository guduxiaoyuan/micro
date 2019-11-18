package com.charlee.thread;

import java.io.IOException;
import java.util.concurrent.*;

public class TestMain {

    public static void main(String[] args) throws Exception {
//        Thread t1 = new Thread(new Thread1());
//        Thread t2 = new Thread(new Thread2());
//        t1.start();
//        t2.start();
//
//        System.in.read();



        ExecutorService ex = Executors.newScheduledThreadPool(10);
        String s = ex.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("1111");
                Thread.sleep(3000);
                return "123";
            }
        }).get();
        System.out.println(s);

    }
   static  ReentrantReadWriteLockUtil util = new ReentrantReadWriteLockUtil();

    public static class Thread1 implements  Runnable{

        @Override
        public void run() {
            util.processCachedData();
        }
    }

    public static class Thread2 implements  Runnable{
        @Override
        public void run() {
            util.processCachedData();
        }
    }

}
