package com.charlee.thread;

public class WaitNotify {

    private final static Object lock = new Object();
    //条件变量
    private static int now,need;

    private final static Object lock2 = new Object();


    public class Threddd implements Runnable{

        @Override
        public void run() {
            //同步
            synchronized (lock){
                //当前有的不满足需要，进行等待，直到满足条件
                while(now < need){
                    System.out.println(11);
//                    try {
//                        //等待阻塞
//                        System.out.println("我被阻塞了");
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("我被唤醒了！");
                }
                // 做其他的事情
                System.out.println("做其他的事");
            }
        }
    }

    public class Thredd222 implements Runnable {

        @Override
        public void run() {
            //同步
            synchronized (lock2) {
                //当前有的不满足需要，进行等待，直到满足条件
                while (now < need) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(">>>>>>>>>");
                    now++;
                    lock.notify();
                }
            }
        }
    }

        public static void main(String[] args) throws Exception {

            WaitNotify w = new WaitNotify();
            now = 3;
            need = 4;

            Thread thread = new Thread(w.new Threddd());
            thread.start();
            Thread.sleep(1000);

            thread.interrupt();
            System.out.println(thread.isInterrupted() +  "====================");
            System.out.println();
//            Thread tt2 = new Thread(w.new Thredd222());
//            tt2.start();

            System.in.read();
        }
}
