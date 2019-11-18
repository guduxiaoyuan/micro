package com.charlee.thread;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueTest {

    final static LinkedTransferQueue queue = new LinkedTransferQueue();


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread1 t1 = new Thread1();
            t1.start();
        }


        Thread2 t2 = new Thread2();
        t2.start();

        System.out.println("执行完毕");

    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("是否阻塞了");
                 queue.transfer("12");
//                Thread.sleep(3000);
//                 queue.tryTransfer("123111");
                System.out.println("是否阻塞了");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
//                Thread.sleep(3000);
             while(true){
                 Object o = queue.take();
                 System.out.println("取出来是" + o);
             }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
