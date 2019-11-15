package com.charlee.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockTest {

    private final static ReentrantLock lock = new ReentrantLock();

    private final static Condition c1 = lock.newCondition();

    private final static Condition c2 = lock.newCondition();

    private static List list = new ArrayList<>();


    private static int size = 10;

    public void put(Object o){
            try{
                lock.lock();
                while(list.size() == size){
                    System.out.println("等待取一个");
                    c1.await();
                }
                list.add(o);
                c2.signal();
            }catch (Exception e ){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    public Object take() {
        try {
            lock.lock();

            while (list.size() == 0) {
                System.out.println("等待放一个");
                c2.await();
            }
            Object o = list.get(0);
            list.remove(0);
            c1.signal();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new ReenTrantLockTest().new Thread1());
        Thread t2 = new Thread(new ReenTrantLockTest().new Thread2());

        t1.start();
        t2.start();

        boolean fff = lock.tryLock(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        lock.unlock();
        lock.lockInterruptibly();
        System.out.println(fff);

        System.in.read();



    }

    public class Thread1 implements Runnable{

        @Override
        public void run() {
            while(true){
                new ReenTrantLockTest().put(1);
                System.out.println("放一个");
                System.out.println("放的时候list size"  + list.size() );
            }
        }
    }

    public class Thread2 implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object o = new ReenTrantLockTest().take();
                System.out.println("取一个" + o);
                System.out.println("取的时候list size"  + list.size() );
            }
        }
    }




}
