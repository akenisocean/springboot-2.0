package 并发编程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author chao
 * @version 1.0
 * @desc 第一个demo测试
 * @date 2019年08月10日 10:43
 */
public class Demo1Test {
    private static int threadTotal = 100;
    private static int clientTotal = 5000;

    private static long count = 0;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    System.err.println("Exception:"+e);
                }

            });
        }
        exec.shutdown();
        System.out.println("count:"+count);

    }

    private static void add() {
        count++;
    }
}
