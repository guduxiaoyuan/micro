package com.charlee.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class TestMain {

    public static void main(String[] args) {

//       new Thread(new Runnable() {
//           @Override
//           public void run() {
////               System.out.println(Thread.currentThread().getName());
//               Runnable runnable = new Thread1();
//               runnable.run();
//               System.out.println("==");
//           }
//       }).start();

//        Arrays.asList( "a", "b", "d" ).forEach(
//                ( String e ) -> System.out.println( e  ) );

        List<String> cList = new ArrayList<String>();
        cList.add("aa");
        cList.add("bb");
        cList.forEach((String e) -> {

           if(e.equals("aa")){
               System.out.println("===");
           }
        });


    }

    public static class Thread1 implements  Runnable{
        @Override
        public void run() {
            System.out.println("线程是" + Thread.currentThread().getName());
        }
    }
}
