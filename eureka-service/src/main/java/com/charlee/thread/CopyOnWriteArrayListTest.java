package com.charlee.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

//CopyOnWrite容器即写时复制的容器。通俗的理解是当我们往一个容器添加元素的时候，
//        不直接往当前容器添加，而是先将当前容器进行Copy，复制出一个新的容器，
//        然后新的容器里添加元素，添加完元素之后，再将原容器的引用指向新的容器。
//        这样做的好处是我们可以对CopyOnWrite容器进行并发的读，而不需要加锁
//        ，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器
public class CopyOnWriteArrayListTest {

    static List<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();

        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(2);
        t3.start();
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println(11);
            for(int i=0;i<10;i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("aaa" + i);
            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("bbb" + i);
            }

            System.out.println(222);
        }
    }

    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while(list.size() > 0 ){
                System.out.println("出现结果是" + list.get(0));
                list.remove(0);
            }
        }
    }
}
