package com.charlee.thread;

import lombok.Data;

import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable myCallable = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                System.out.println("calld方法执行了");
                return "call方法返回值";
            }
        };

//        Future future = executor.submit(myCallable);
//        Object o = future.get();
//        System.out.println(o);
        Tt ttt = new Tt("aa","bb");
        Threadt th = new Threadt(new Tt("aa","bb"));
        ExecutorCompletionService<Tt> s = new ExecutorCompletionService(executor);
//        s.submit(th, ttt);
        System.out.println(ttt.getAa() +">>" + ttt.getBb());



    }

    private static class Threadt implements Runnable{
        Tt tt;
        public Threadt(Tt tt){
            this.tt = tt;
        }
        @Override
        public void run() {
            tt.setAa("aaaa");
            tt.setBb("bbbb");
            System.out.println("======");
        }
    }


    @Data
    public static class Tt {
        public Tt(String aa, String bb){
            this.aa = aa;
            this.bb = bb;
        };
        private String aa;
        private String bb;
    }


}
