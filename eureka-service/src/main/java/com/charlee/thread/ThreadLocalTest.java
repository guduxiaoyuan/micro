package com.charlee.thread;

import java.io.IOException;

public class ThreadLocalTest {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    public static ThreadLocal<User> threadLocalUser = new ThreadLocal<User>();

    public static void main(String args[]) throws IOException {
        threadLocal.set(100);	// 保存值
//        System.out.println(threadLocal.get());	// 获取值
//
//        User user = new User();
//        user.setName("JoonWhee");
//        user.setAge(25);
//        threadLocalUser.set(user);	// 保存值
//        System.out.println(threadLocalUser.get());	// 获取值

        Thread t1 = new Thread(new ThreadLocalTest().new Thread1());
        Thread t2 = new Thread(new ThreadLocalTest().new Thread2());

        System.out.println("线程名称" + Thread.currentThread().getName() + ";value:" + threadLocal.get());
        t1.start();
        t2.start();

        System.in.read();
    }

    public class Thread1 implements Runnable{

        @Override
        public void run() {
            threadLocal.set(11111111);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程名称" + Thread.currentThread().getName() + ";value:" + threadLocal.get());


            threadLocal.remove();
        }
    }

    public class Thread2 implements Runnable{

        @Override
        public void run() {
            threadLocal.set(22222222);

            System.out.println("线程名称" + Thread.currentThread().getName() + ";value:" + threadLocal.get());
        }
    }
    static class User {
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User [name=" + name + ", age=" + age + "]";
        }
    }

}
