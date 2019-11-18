package com.charlee.thread;

import lombok.Data;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
//　在谈到DelayQueue的使用和原理的时候，我们首先介绍一下DelayQueue，DelayQueue是一个无界阻塞队列，只有在延迟期满时才能从中提取元素。该队列的头部是延迟期满后保存时间最长的Delayed 元素

//DelayQueue中的所有元素必须实现Delayed接口
public class DelayQueueTest {


    final static DelayQueue queue = new DelayQueue();

    public static void main(String[] args) throws InterruptedException {
        queue.add(new delayed("123",3L, TimeUnit.SECONDS));

        delayed oo = (delayed) queue.peek();
        Thread.sleep(1400);
        System.out.println(oo.getDelay(TimeUnit.SECONDS));
        delayed o = (delayed) queue.take();

        System.out.println(o.getName());
    }

    @Data
    private static class delayed implements Delayed {
        /* 触发时间*/
        private long time;
        String name;


        public delayed(String name, long time, TimeUnit unit) {
            this.name = name;
            this.time = System.currentTimeMillis() + (time > 0? unit.toMillis(time): 0);
        }
        //这个接口返回到激活日期的--剩余时间，时间单位由单位参数指定。
        @Override
        public long getDelay(TimeUnit unit) {
            return time - System.currentTimeMillis();
        }
        //用于比较延时，队列里元素的排序依据，这个是Comparable接口的方法，因为Delay实现了Comparable接口，所以需要实现。
        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

}
