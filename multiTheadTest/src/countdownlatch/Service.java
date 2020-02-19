package countdownlatch;

/**
 * @author jack chao
 * @create 2019-01-09 13:58
 * @desc
 **/
public interface Service {
    /**
     * 启动服务
     */
    void start();

    /**
     * 关闭服务
     */
    void stop();

    /**
     * 服务是否启动
     *
     * @return
     */
    boolean isStarted();
}
