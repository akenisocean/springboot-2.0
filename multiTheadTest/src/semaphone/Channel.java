package semaphone;

/**
 * @author jack chao
 * @create 2019-01-09 16:40
 * @desc 通道进行生产和消费
 **/
public interface Channel<P> {

    /**
     * 向传输通道中存入一个产品
     *
     * @param product
     * @throws InterruptedException
     */
    void put(P product) throws InterruptedException;

    /**
     * 从传输通道中去除一个产品
     *
     * @throws InterruptedException
     */
    void take() throws InterruptedException;
}
