package com.charlee.thread;

import java.util.concurrent.ConcurrentLinkedDeque;
//ConcurrentLinkedDeque 是双向链表结构的无界并发队列。从JDK 7开始加入到J.U.C的行列中。
// 使用CAS实现并发安全，与 ConcurrentLinkedQueue 的区别是该阻塞队列同时支持FIFO和FILO两种操作方式，
// 即可以从队列的头和尾同时操作(插入/删除)。适合“多生产，多消费”的场景。
// 内存一致性遵循对 ConcurrentLinkedDeque 的插入操作先行发生于(happen-before)访问或移除操作。
// 相较于 ConcurrentLinkedQueue，ConcurrentLinkedDeque 由于是双端队列，所以在操作和概念上会更加复杂，来一起看下。


public class ConcurrentLinkedDequeTest {

    public static void main(String[] args) {
        ConcurrentLinkedDeque deque = new ConcurrentLinkedDeque();
        deque.addFirst("aa");
        deque.addLast("zz");

        while (deque.size() > 0 ) {
            Object o = deque.pollFirst();
            System.out.println(o);
        }


    }
}
