package countdownlatch;

/**
 * @author jack chao
 * @create 2019-01-09 13:50
 * @desc 服务器启动代码
 **/
public class ServerStarter {
    public static void main(String[] args) {
        //启动所有服务
        ServerManager.startServices();

        //执行其他操作
        boolean allIsOk;
        //在所有其他操作执行结束之后，检测服务启动状态
        allIsOk = ServerManager.checkServiceStatus();
        if (allIsOk) {
            System.out.println("All Services were successfully started!");
        } else {
            //个别服务启动失败，推出JVM
            System.err.println("Some service(s) failed to start,exiting JVM...");
            System.exit(1);
        }

    }
}
