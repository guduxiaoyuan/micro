package com.charlee.thread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //合并结果
//        String result = CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Hello";
//        }).thenCombine(CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "world";
//        }),(s1,s2)->{return s1 + " " + s2;}).join();
//        System.out.println(result);

        //谁计算的快，结果就是什么
//        String result = CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Hi Boy";
//        }).applyToEither(CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Hi Girl";
//        }),(s)->{return s;}).join();
//        System.out.println(result);

//        运行时出现了异常，可以通过exceptionally进行补偿
//        String result = CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if(true) {
//                throw new RuntimeException("exception test!");
//            }
//
//            return "Hi Boy";
//        }).exceptionally(e->{
//            System.out.println(e.getMessage());
//            return "Hello world!";
//        }).join();
//        System.out.println(result);


//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//            }
//            System.out.println("run end ...");
//        });
//        System.out.println(123);
//        future.get();
//        System.out.println(456);


        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if (new Random().nextInt() % 2 >= 0) {
                int i = 12 / 0;
            }
            System.out.println("run end ...");
        });

        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void t, Throwable action) {
                System.out.println("执行完成！");
            }

        });
        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable t) {
                System.out.println("执行失败！" + t.getMessage());
                return null;
            }
        });
        TimeUnit.SECONDS.sleep(2);

    }
}
//3、 thenApply 方法
//        当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化。
//
//public<U> CompletableFuture<U> thenApply(Function<? super T,?extends U>fn)
//public<U> CompletableFuture<U> thenApplyAsync(Function<? super T,?extends U>fn)
//public<U> CompletableFuture<U> thenApplyAsync(Function<? super T,?extends U>fn,Executor executor)
//        Function<? super T,?extends U>
//        T：上一个任务返回结果的类型
//        U：当前任务的返回值类型
//
//        示例
//private static void thenApply()throws Exception{
//        CompletableFuture<Long> future=CompletableFuture.supplyAsync(new Supplier<Long>(){
//@Override
//public Long get(){
//        long result=new Random().nextInt(100);
//        System.out.println("result1="+result);
//        return result;
//        }
//        }).thenApply(new Function<Long, Long>(){
//@Override
//public Long apply(Long t){
//        long result=t*5;
//        System.out.println("result2="+result);
//        return result;
//        }
//        });
//
//        long result=future.get();
//        System.out.println(result);
//        }
//        第二个任务依赖第一个任务的结果。
//
//        4、 handle 方法
//        handle 是执行任务完成时对结果的处理。
//        handle 方法和 thenApply 方法处理方式基本一样。不同的是 handle 是在任务完成后再执行，还可以处理异常的任务。thenApply 只可以执行正常的任务，任务出现异常则不执行 thenApply 方法。
//
//public<U> CompletionStage<U> handle(BiFunction<? super T,Throwable,?extends U>fn);
//public<U> CompletionStage<U> handleAsync(BiFunction<? super T,Throwable,?extends U>fn);
//public<U> CompletionStage<U> handleAsync(BiFunction<? super T,Throwable,?extends U>fn,Executor executor);
//        示例
//public static void handle()throws Exception{
//        CompletableFuture<Integer> future=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//
//@Override
//public Integer get(){
//        int i=10/0;
//        return new Random().nextInt(10);
//        }
//        }).handle(new BiFunction<Integer, Throwable, Integer>(){
//@Override
//public Integer apply(Integer param,Throwable throwable){
//        int result=-1;
//        if(throwable==null){
//        result=param*2;
//        }else{
//        System.out.println(throwable.getMessage());
//        }
//        return result;
//        }
//        });
//        System.out.println(future.get());
//        }
//        从示例中可以看出，在 handle 中可以根据任务是否有异常来进行做相应的后续处理操作。而 thenApply 方法，如果上个任务出现错误，则不会执行 thenApply 方法。
//
//        5、 thenAccept 消费处理结果
//        接收任务的处理结果，并消费处理，无返回结果。
//
//public CompletionStage<Void> thenAccept(Consumer<? super T>action);
//public CompletionStage<Void> thenAcceptAsync(Consumer<? super T>action);
//public CompletionStage<Void> thenAcceptAsync(Consumer<? super T>action,Executor executor);
//        示例
//public static void thenAccept()throws Exception{
//        CompletableFuture<Void> future=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        return new Random().nextInt(10);
//        }
//        }).thenAccept(integer->{
//        System.out.println(integer);
//        });
//        future.get();
//        }
//        从示例代码中可以看出，该方法只是消费执行完成的任务，并可以根据上面的任务返回的结果进行处理。并没有后续的输错操作。
//
//        6、thenRun 方法
//        跟 thenAccept 方法不一样的是，不关心任务的处理结果。只要上面的任务执行完成，就开始执行 thenAccept 。
//
//public CompletionStage<Void> thenRun(Runnable action);
//public CompletionStage<Void> thenRunAsync(Runnable action);
//public CompletionStage<Void> thenRunAsync(Runnable action,Executor executor);
//        示例
//public static void thenRun()throws Exception{
//        CompletableFuture<Void> future=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        return new Random().nextInt(10);
//        }
//        }).thenRun(()->{
//        System.out.println("thenRun ...");
//        });
//        future.get();
//        }
//        该方法同 thenAccept 方法类似。不同的是上个任务处理完成后，并不会把计算的结果传给 thenRun 方法。只是处理玩任务后，执行 thenAccept 的后续操作。
//
//        7、thenCombine 合并任务
//        thenCombine 会把 两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理。
//
//public<U, V> CompletionStage<V> thenCombine(CompletionStage<?extends U> other,BiFunction<? super T,?super U,?extends V>fn);
//public<U, V> CompletionStage<V> thenCombineAsync(CompletionStage<?extends U> other,BiFunction<? super T,?super U,?extends V>fn);
//public<U, V> CompletionStage<V> thenCombineAsync(CompletionStage<?extends U> other,BiFunction<? super T,?super U,?extends V>fn,Executor executor);
//        示例
//private static void thenCombine()throws Exception{
//        CompletableFuture<String> future1=CompletableFuture.supplyAsync(new Supplier<String>(){
//@Override
//public String get(){
//        return"hello";
//        }
//        });
//        CompletableFuture<String> future2=CompletableFuture.supplyAsync(new Supplier<String>(){
//@Override
//public String get(){
//        return"hello";
//        }
//        });
//        CompletableFuture<String> result=future1.thenCombine(future2,new BiFunction<String, String, String>(){
//@Override
//public String apply(String t,String u){
//        return t+" "+u;
//        }
//        });
//        System.out.println(result.get());
//        }
//        8、thenAcceptBoth
//        当两个CompletionStage都执行完成后，把结果一块交给thenAcceptBoth来进行消耗
//
//public<U> CompletionStage<Void> thenAcceptBoth(CompletionStage<?extends U> other,BiConsumer<? super T,?super U>action);
//public<U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<?extends U> other,BiConsumer<? super T,?super U>action);
//public<U> CompletionStage<Void> thenAcceptBothAsync(CompletionStage<?extends U> other,BiConsumer<? super T,?super U>action,Executor executor);
//
//        示例
//private static void thenAcceptBoth()throws Exception{
//        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f1="+t);
//        return t;
//        }
//        });
//
//        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f2="+t);
//        return t;
//        }
//        });
//        f1.thenAcceptBoth(f2,new BiConsumer<Integer, Integer>(){
//@Override
//public void accept(Integer t,Integer u){
//        System.out.println("f1="+t+";f2="+u+";");
//        }
//        });
//        }
//        9、applyToEither 方法
//        两个CompletionStage，谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步的转化操作。
//
//public<U> CompletionStage<U> applyToEither(CompletionStage<?extends T> other,Function<? super T,U>fn);
//public<U> CompletionStage<U> applyToEitherAsync(CompletionStage<?extends T> other,Function<? super T,U>fn);
//public<U> CompletionStage<U> applyToEitherAsync(CompletionStage<?extends T> other,Function<? super T,U>fn,Executor executor);
//        示例
//private static void applyToEither()throws Exception{
//        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f1="+t);
//        return t;
//        }
//        });
//        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f2="+t);
//        return t;
//        }
//        });
//
//        CompletableFuture<Integer> result=f1.applyToEither(f2,new Function<Integer, Integer>(){
//@Override
//public Integer apply(Integer t){
//        System.out.println(t);
//        return t*2;
//        }
//        });
//
//        System.out.println(result.get());
//        }
//        10、acceptEither 方法
//        两个CompletionStage，谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步的消耗操作。
//
//public CompletionStage<Void> acceptEither(CompletionStage<?extends T> other,Consumer<? super T>action);
//public CompletionStage<Void> acceptEitherAsync(CompletionStage<?extends T> other,Consumer<? super T>action);
//public CompletionStage<Void> acceptEitherAsync(CompletionStage<?extends T> other,Consumer<? super T>action,Executor executor);
//        示例
//private static void acceptEither()throws Exception{
//        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f1="+t);
//        return t;
//        }
//        });
//
//        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f2="+t);
//        return t;
//        }
//        });
//        f1.acceptEither(f2,new Consumer<Integer>(){
//@Override
//public void accept(Integer t){
//        System.out.println(t);
//        }
//        });
//        }
//        11、runAfterEither 方法
//        两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable）
//
//public CompletionStage<Void> runAfterEither(CompletionStage<?> other,Runnable action);
//public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other,Runnable action);
//public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other,Runnable action,Executor executor);
//        示例
//private static void runAfterEither()throws Exception{
//        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f1="+t);
//        return t;
//        }
//        });
//
//        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f2="+t);
//        return t;
//        }
//        });
//        f1.runAfterEither(f2,new Runnable(){
//
//@Override
//public void run(){
//        System.out.println("上面有一个已经完成了。");
//        }
//        });
//        }
//        12、runAfterBoth
//        两个CompletionStage，都完成了计算才会执行下一步的操作（Runnable）
//
//public CompletionStage<Void> runAfterBoth(CompletionStage<?> other,Runnable action);
//public CompletionStage<Void> runAfterBothAsync(CompletionStage<?> other,Runnable action);
//public CompletionStage<Void> runAfterBothAsync(CompletionStage<?> other,Runnable action,Executor executor);
//        示例
//private static void runAfterBoth()throws Exception{
//        CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f1="+t);
//        return t;
//        }
//        });
//
//        CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        try{
//        TimeUnit.SECONDS.sleep(t);
//        }catch(InterruptedException e){
//        e.printStackTrace();
//        }
//        System.out.println("f2="+t);
//        return t;
//        }
//        });
//        f1.runAfterBoth(f2,new Runnable(){
//
//@Override
//public void run(){
//        System.out.println("上面两个任务都执行完成了。");
//        }
//        });
//        }
//        13、thenCompose 方法
//        thenCompose 方法允许你对两个 CompletionStage 进行流水线操作，第一个操作完成时，将其结果作为参数传递给第二个操作。
//
//public<U> CompletableFuture<U> thenCompose(Function<? super T,?extends CompletionStage<U>>fn);
//public<U> CompletableFuture<U> thenComposeAsync(Function<? super T,?extends CompletionStage<U>>fn);
//public<U> CompletableFuture<U> thenComposeAsync(Function<? super T,?extends CompletionStage<U>>fn,Executor executor);
//        示例
//private static void thenCompose()throws Exception{
//        CompletableFuture<Integer> f=CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=new Random().nextInt(3);
//        System.out.println("t1="+t);
//        return t;
//        }
//        }).thenCompose(new Function<Integer, CompletionStage<Integer>>(){
//@Override
//public CompletionStage<Integer> apply(Integer param){
//        return CompletableFuture.supplyAsync(new Supplier<Integer>(){
//@Override
//public Integer get(){
//        int t=param*2;
//        System.out.println("t2="+t);
//        return t;
//        }
//        });
//        }
//
//        });
//        System.out.println("thenCompose result : "+f.get());
//        }
//
//        作者：jijs
//        链接：https://www.jianshu.com/p/6bac52527ca4
//        来源：简书
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
