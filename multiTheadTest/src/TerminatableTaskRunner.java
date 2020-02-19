import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jack chao
 * @create 2019-01-11 16:36
 * @desc 通用的线程优雅停止的方法实例
 **/
public class TerminatableTaskRunner implements TaskRunnerSpec {
    protected final BlockingQueue<Runnable> channel;
    //线程停止标记
    protected volatile boolean inUse = true;
    //带处理任务计数器
    public final AtomicInteger reservations = new AtomicInteger(0);
    private volatile Thread workerThread;

    public TerminatableTaskRunner(BlockingQueue<Runnable> channel) {
        this.channel = channel;
        this.workerThread = new WorkerThread();
    }

    public TerminatableTaskRunner() {
        this(new LinkedBlockingQueue<>());
    }

    @Override
    public void init() {
        final Thread t = workerThread;
        if (null != t) {
            t.start();
        }
    }

    @Override
    public void submit(Runnable task) throws InterruptedException {
        channel.put(task);
        reservations.incrementAndGet();
    }

    public void shutdown() {
        System.out.println("Shutting down service...");
        inUse = false;
        final Thread t = workerThread;
        if (null != t) {
            //线程停止操作
            t.interrupt();
        }
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {

        }
    }
}
