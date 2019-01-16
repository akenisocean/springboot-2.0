package semaphone;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @author jack chao
 * @create 2019-01-09 16:42
 * @desc 基于semaphone实现的支持流量控制的传输通道实现
 **/
public class SemaphoneBasedChannel<P> implements Channel<P> {
    private final BlockingQueue<P> queue;
    private final Semaphore semaphore;

    public SemaphoneBasedChannel(BlockingQueue<P> queue, int flowLimit) {
        this.queue = queue;
        this.semaphore = new Semaphore(flowLimit, false);
    }

    public SemaphoneBasedChannel(BlockingQueue<P> queue, int flowLimit, boolean isFair) {
        this.queue = queue;
        this.semaphore = new Semaphore(flowLimit, isFair);
    }

    @Override
    public void put(P product) throws InterruptedException {
        //申请一个配额
        semaphore.acquire();
        try {
            //访问虚拟资源
            queue.put(product);
        } finally {
            //返回一个配额
            semaphore.release();
        }

    }

    @Override
    public void take() throws InterruptedException {
        queue.take();
    }
}
