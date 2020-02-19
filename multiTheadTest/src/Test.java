import java.util.concurrent.TimeUnit;

/**
 * @author jack chao
 * @create 2019-01-11 16:03
 * @desc
 **/
public class Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean flag = true;
                    while (flag) {
                        Thread.currentThread().interrupt();
                        System.out.print(1);
//                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("xunhuan");
                        System.out.println(Thread.currentThread().isInterrupted());
                    }
                    System.out.println("laji");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("睡眠结束了");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("睡眠异常结束了");
                }
            }
        }).start();
        System.out.println("结束");

    }
}
