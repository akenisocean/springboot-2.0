package task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author jack chao
 * @create 2019-01-11 15:37
 * @desc 通用任务执行器
 **/
public class TaskRunner {
    protected final BlockingQueue<Runnable> channel;
    protected volatile Thread workerThead;


    public TaskRunner(BlockingQueue<Runnable> channel) {
        this.channel = channel;
        this.workerThead = new WorkerThead();
    }

    public TaskRunner() {
        this(new LinkedBlockingDeque<>());
    }

    public void init() {
        final Thread t = workerThead;
        if (null != t) {
            t.start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        channel.put(task);
    }

    private class WorkerThead extends Thread {
        @Override
        public void run() {
            Runnable task = null;
            for (; ; ) {
                try {
                    task = channel.take();
                    task.run();
                } catch (Throwable e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
