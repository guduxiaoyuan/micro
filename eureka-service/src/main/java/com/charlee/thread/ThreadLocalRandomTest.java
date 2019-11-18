package com.charlee.thread;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {




    public static void main(String[] args) {



        for(int i=0;i <100;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(ThreadLocalRandom.current().nextInt(100));
                }
            });
            t.start();
        }

    }

}
