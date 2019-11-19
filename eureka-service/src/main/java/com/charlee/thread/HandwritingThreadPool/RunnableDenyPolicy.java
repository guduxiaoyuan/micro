package com.charlee.thread.HandwritingThreadPool;

@FunctionalInterface
public interface RunnableDenyPolicy {

    /**
     * 对提交到threadPool的runnable是否执行reject
     *
     * @param runnable
     * @param threadPool
     */
    void reject(Runnable runnable, ThreadPool threadPool);

    /**
     * 该策略使用空方法直接丢弃任务
     */
    class DiscardDenyPolicy implements RunnableDenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            System.out.println(runnable + "不做处理");
        }
    }

    /**
     * 该策略抛出一个RunnableDenyException
     */
    class AbortDenyPolicy implements RunnableDenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("The" + runnable + "will be abort");
        }
    }

    /**
     * 该策略Runnable给提交者所在的线程中运行, 不加入到线程中
     */
    class RunnerDenyPolicy implements RunnableDenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }

}
