package com.charlee.thread;

import java.io.IOException;

public class TestMain {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        t1.start();
        t2.start();

        System.in.read();

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
