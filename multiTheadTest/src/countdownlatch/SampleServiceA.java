package countdownlatch;

import util.Tools;

import java.util.concurrent.CountDownLatch;

/**
 * @author jack chao
 * @create 2019-01-09 14:08
 * @desc 服务器A
 **/

public class SampleServiceA extends AbstractService {
    /**
     * 通过构造方法初始化CountDownLatch
     *
     * @param latch
     */
    public SampleServiceA(CountDownLatch latch) {
        super(latch);
    }

    @Override
    protected void doStart() throws Exception {
        // 模拟实际操作耗时
        Tools.randomPause(1000);
        // 省略其他代码
    }

}
