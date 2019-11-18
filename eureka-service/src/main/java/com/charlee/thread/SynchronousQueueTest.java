package com.charlee.thread;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        SynchronousQueue<String> s = new SynchronousQueue<String>();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.put("12");
                    System.out.println("已经被取走了 +  111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.put("3333");
                    System.out.println("已经被取走了 +  222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();




        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        String result = s.take();
                        System.out.println(result);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        t1.start();


        System.out.println("已经结束了");
        System.in.read();

    }
}
