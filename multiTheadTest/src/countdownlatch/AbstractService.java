package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author jack chao
 * @create 2019-01-09 13:59
 * @desc 服务抽象类
 **/

public  abstract class AbstractService implements Service {
    protected boolean started = false;
    protected final CountDownLatch latch;

    /**
     * 通过构造方法初始化CountDownLatch
     * @param latch
     */
    public AbstractService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void start() {
        new ServiceStart().start();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return started;
    }


    // 留给子类实现的抽象方法，用于实现服务器的启动逻辑
    protected abstract void doStart() throws Exception;


    private class ServiceStart extends Thread {

        @Override
        public void run() {
            final String serviceName = AbstractService.this.getClass()
                    .getSimpleName();
            System.out.printf("Starting %s \n", serviceName);
            try {
                doStart();
                started = true;
            } catch (Exception e) {
            } finally {
                latch.countDown();
                System.out.printf("Done Starting %s \n", serviceName);
            }
        }
    }
}
