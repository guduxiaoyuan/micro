package com.charlee.thread;

import java.util.concurrent.*;

/**
 *假设现在有一大批需要进行计算的任务，为了提高整批任务的执行效率，你可能会使用线程池，
 * 向线程池中不断submit异步计算任务，同时你需要保留与每个任务关联的Future，
 * 最后遍历这些Future，通过调用Future接口实现类的get方法获取整批计算任务的各个结果。
 *
 * 虽然使用了线程池提高了整体的执行效率，但遍历这些Future，调用Future接口实现类的get方法是阻塞的，
 * 也就是和当前这个Future关联的计算任务真正执行完成的时候，get方法才返回结果，如果当前计算任务没有执行完成，
 * 而有其它Future关联的计算任务已经执行完成了，就会白白浪费很多等待的时间，所以最好是遍历的时候谁先执行完成就先获取哪个结果，这样就节省了很多持续等待的时间。
 *
 * 而ExecutorCompletionService可以实现这样的效果，它的内部有一个先进先出的阻塞队列，用于保存已经执行完成的Future，
 * 通过调用它的take方法或poll方法可以获取到一个已经执行完成的Future，进而通过调用Future接口实现类的get方法获取最终的结果
 */
public class ExecutorCompletionServiceTest {

    public static void main(String[] args) throws Exception {
        ExecutorService ervice = Executors.newFixedThreadPool(2);
        ExecutorCompletionService eService = new ExecutorCompletionService(ervice);

        Callable c1 = new Callable() {
            @Override
            public Object call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                return "Thread1";
            }
        };
        Callable c2 = new Callable() {
            @Override
            public Object call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return "Thread2";
            }
        };

        eService.submit(c1);
        eService.submit(c2);

        while(true){
            Future<Object> s = eService.take();
            System.out.println(s.get());
        }


    }
}
