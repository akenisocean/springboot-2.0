package countdownlatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author jack chao
 * @create 2019-01-09 13:51
 * @desc
 **/
public class ServerManager {

    static volatile CountDownLatch latch;
    static Set<Service> services;


    /**
     * 进行所有服务的启动
     */
    public static void startServices() {
        services = getServices();
        for (Service service : services) {
            service.start();
        }
    }

    /**
     * 检测服务是否都启动完毕
     * @return
     */
    public static boolean checkServiceStatus() {
        boolean allIsOK = true;

        // 等待服务启动结束
        try {
            latch.await(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return false;
        }
        for (Service service:services) {
            if (!service.isStarted()){
                allIsOK = false;
                break;
            }
        }
        return allIsOK;

    }

    private static Set<Service> getServices() {
        // 模拟实际代码
        latch = new CountDownLatch(3);
        HashSet<Service> servcies = new HashSet<>();
        servcies.add(new SampleServiceC(latch));
        servcies.add(new SampleServiceA(latch));
        servcies.add(new SampleServiceB(latch));
        return servcies;
    }
}
