package com.charlee.thread;

import java.util.concurrent.*;

public class ThreadThrowsException {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i= 3/0;
                System.out.println(111);
            }
        });

//        t.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
        Thread.setDefaultUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
//        t.start();

        Future<Object> o = Executors.newFixedThreadPool(1) .submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                int i = 1/0;
                return "你是什么鬼";
            }
        });
        try {
            Object oo =  o.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("yichang");
            e.printStackTrace();
        }


    }



    public static class MyUnchecckedExceptionhandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("捕获异常处理方法：" + t.currentThread().getName() + ".异常原因是：" + e);
        }
    }
}



