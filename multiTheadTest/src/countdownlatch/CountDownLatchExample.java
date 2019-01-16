package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author jack chao
 * @create 2019-01-09 14:50
 * @desc
 **/
public class CountDownLatchExample {
 private static final CountDownLatch latch = new CountDownLatch(4);
 private static int data;

    public static void main(String[] args) throws InterruptedException {
        Thread workerThead = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    data = i+1;
                    latch.countDown();
                    //随机睡一会儿
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.err.println("睡眠时间出错了");
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };
        workerThead.start();
        latch.await();
        System.out.printf("It's down,data=%d",data);

    }
}
