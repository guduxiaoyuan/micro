package com.charlee.thread;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapTest {


    private static ConcurrentSkipListMap map = new ConcurrentSkipListMap();

    public static void main(String[] args) throws IOException, InterruptedException {
//        for(int i=0;i<20;i++){
//            Thread t1 = new Thread(new ConcurrentSkipListMapTest().new Thread1(i));
//            t1.start();
//        }
//
//        for(int i=0;i<20;i++){
//            Thread t2 = new Thread(new ConcurrentSkipListMapTest().new Thread2(i));
//            t2.start();
//        }
//
//        Thread.sleep(20000);
//
//        for(Object o :map.keySet()){
//            System.out.println("key:" + o +" value:"+ map.get(o));
//        }
//
//        System.in.read();

//        ConcurrentSkipListMap<Integer, Integer> map = new ConcurrentSkipListMap<>();
//        for (int i = 0; i < 30; i++) {
//            map.put(i,i);
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//        }



        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            map2.put(i,i);
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey());
        }

        SortedMap samp  = Collections.synchronizedSortedMap(new TreeMap<>());

    }




    public class Thread1 implements Runnable{
        private int i;
        public Thread1(Integer i ){
            this.i=i;
        };
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.put("T1"+":"+ i,"Thread1插入的"+i);
        }
    }

    public class Thread2 implements Runnable{
        private int i;
        public Thread2(Integer i ){
            this.i=i;
        };
        @Override
        public void run() {
            try {
                Thread.sleep(200);
                map.put("T2:"+ i,"Thread2插入的"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
