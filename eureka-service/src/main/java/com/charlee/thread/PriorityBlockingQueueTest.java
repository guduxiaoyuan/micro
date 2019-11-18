package com.charlee.thread;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {

    public static void main(String[] args) {

        PriorityBlockingQueue queue = new PriorityBlockingQueue();
        queue.add(new Person(3,"3同学"));
        queue.add(new Person(1,"1同学"));
        queue.add(new Person(4,"4同学"));
        queue.add(new Person(2,"2同学"));

        queue.add(new Person(13,"13同学"));
        queue.add(new Person(12,"12同学"));
        queue.add(new Person(11,"11同学"));
        queue.add(new Person(16,"16同学"));
        queue.add(new Person(15,"15同学"));
        queue.add(new Person(17,"17同学"));
        queue.add(new Person(11,"11同学"));
        queue.add(new Person(123,"123同学"));
        queue.add(new Person(12312,"12312同学"));
        queue.add(new Person(123123,"123123同学"));




        Thread tt = new Thread(() -> {
            while(true){
                try {
//                    Thread.sleep(1000);
                    Object o = queue.take();
                    System.out.println("取出来结果是" + o );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tt.start();
        Thread tt2 = new Thread(() -> {
            while(true){
                try {
//                    Thread.sleep(900);
                    Object o = queue.take();
                    System.out.println("取出来结果是是什么" + o );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tt2.start();;

    }



    public static class Person implements Comparable<Person> {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public Person() {
        }

        @Override
        public String toString() {
            return this.id + ":" + this.name;
        }

        @Override
        public int compareTo(Person person) {
            return this.id > person.getId() ? 1 : (this.id < person.getId() ? -1 : 0);
        }
    }

}
