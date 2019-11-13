package com.charlee.zookeeperLock;

public class LockTest {

    public static void main(String[] args) {
        //模拟多个10个客户端
        Long c1 = System.currentTimeMillis();
        for (int i=0;i<10;i++) {
            Thread thread = new Thread(new HighLockRunnable());
            thread.start();
        }
        Long c2 = System.currentTimeMillis();
        System.out.println("==========================下一阶段是 惊群效应");
        System.out.println();
        System.out.println();
        for (int i=0;i<10;i++) {
            Thread thread = new Thread(new HighLockRunnable());
            thread.start();
        }
        Long c3 = System.currentTimeMillis();



    }

    static class HighLockRunnable implements Runnable{

        @Override
        public void run() {
            AbstractLock zkLock = new HighPerformanceZkLock();
            //AbstractLock zkLock = new HighPerformanceZkLock();
            zkLock.getLock();
            //模拟业务操作
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            zkLock.releaseLock();
        }

    }


    static class SimpleLockRunnable implements Runnable{

        @Override
        public void run() {
//            AbstractLock zkLock = new HighPerformanceZkLock();
            AbstractLock zkLock = new HighPerformanceZkLock();
            zkLock.getLock();
            //模拟业务操作
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            zkLock.releaseLock();
        }

    }

}
