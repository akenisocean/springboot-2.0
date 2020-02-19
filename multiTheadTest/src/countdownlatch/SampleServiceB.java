package countdownlatch;

import util.Tools;

import java.util.concurrent.CountDownLatch;

/**
 * @author jack chao
 * @create 2019-01-09 14:13
 * @desc 服务器B
 **/
public class SampleServiceB extends AbstractService {

    /**
     * 通过构造方法初始化CountDownLatch
     *
     * @param latch
     */
    public SampleServiceB(CountDownLatch latch) {
        super(latch);
    }

    @Override
    protected void doStart() throws Exception {
        Tools.randomPause(2000);

    }
}
