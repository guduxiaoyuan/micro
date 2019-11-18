package com.charlee.thread;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 双端队列
 */
public class LinkedBlockingDequeTest {
    final static LinkedBlockingDeque duque = new LinkedBlockingDeque();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    duque.addFirst("11");
                    duque.addFirst("22");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(duque.size() > 0){
                        System.out.println("删除第一个");
                        duque.removeFirst();
                    }
                    if(duque.size() > 0){
                        System.out.println("删除最后一个");
                        duque.removeLast();
                    }

                }
            }
        });


        t1.start();
        t2.start();

    }


}
