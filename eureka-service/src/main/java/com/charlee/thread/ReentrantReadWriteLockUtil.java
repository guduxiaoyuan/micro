package com.charlee.thread;


import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReentrantReadWriteLockUtil {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        t1.start();
        t2.start();


    }
    static  ReentrantReadWriteLockUtil util = new ReentrantReadWriteLockUtil();

    public static class Thread1 implements  Runnable{

        @Override
        public void run() {
            util.processCachedData();
        }
    }

    public static class Thread2 implements  Runnable{
        @Override
        public void run() {
            util.processCachedData();
        }
    }



    Object data;
    volatile boolean cacheValid;
    final  ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                // Recheck state because another thread might have
                // acquired write lock and changed state before we did.
                if (!cacheValid) {
//                    data = ...
                    System.out.println("写数据中……………………………………………………" + Thread.currentThread().getName());
                    Thread.sleep(5000);
                    System.out.println("写数据完成……………………………………………………" + Thread.currentThread().getName());
                    cacheValid = true;
                }
                // Downgrade by acquiring read lock before releasing write lock
                rwl.readLock().lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock(); // Unlock write, still hold read
            }
        }

        try {
            System.out.println("使用数据" + Thread.currentThread().getName());

        } finally {
            rwl.readLock().unlock();
        }
    }


    class RWDictionary {
        private final Map<String, Object> m = new TreeMap<String, Object>();
        private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        private final Lock r = rwl.readLock();
        private final Lock w = rwl.writeLock();

        public Object get(String key) {
            r.lock();
            try { return m.get(key); }
            finally { r.unlock(); }
        }
        public String[] allKeys() {
            r.lock();
            try { return (String[]) m.keySet().toArray(); }
            finally { r.unlock(); }
        }
        public Object put(String key, Object value) {
            w.lock();
            try { return m.put(key, value); }
            finally { w.unlock(); }
        }
        public void clear() {
            w.lock();
            try { m.clear(); }
            finally { w.unlock(); }
        }
    }

}
