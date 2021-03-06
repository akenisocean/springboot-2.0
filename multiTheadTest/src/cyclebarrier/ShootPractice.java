package cyclebarrier;

import util.Tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jack chao
 * @create 2019-01-09 15:07
 * @desc 射击训练
 **/
public class ShootPractice {
    // 参与打靶训练的全部士兵
    final Soldier[][] rank;
    //靶的个数，即每排中士兵的个数
    final int N;
    //打靶持续时间（单位： 秒）
    final int lasting;
    //标识是否继续打靶
    volatile boolean done = false;
    //用来指示进行下一轮打靶的那一排的士兵
    volatile int nextLine = 0;
    final CyclicBarrier shiftBarrier;
    final CyclicBarrier startBarrier;


    public ShootPractice(int N, final int lineCount, int lasting) {
        this.N = N;
        this.lasting = lasting;
        this.rank = new Soldier[lineCount][N];
        for (int i = 0; i < lineCount; i++) {
            for (int j = 0; j < N; j++) {
                rank[i][j] = new Soldier(i * N + j);
            }
        }
        shiftBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                // 更新下一轮打靶的排
                nextLine = (nextLine + 1) % lineCount;// 语句①
                System.out.printf("Next turn is :%d \n", nextLine);
            }
        });
        // 语句②
        startBarrier = new CyclicBarrier(N);
    }


    public static void main(String[] args) throws InterruptedException {
        ShootPractice sp = new ShootPractice(4, 5, 24);
        sp.start();
    }

    private void start() throws InterruptedException {
        Thread[] threads = new Thread[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Shooting(i);
            threads[i].start();
        }
        //指定事件后停止打靶
        Thread.sleep(lasting * 1000);
        stop();
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Practice finished");


    }

    private void stop() {

        done = true;
    }

    class Shooting extends Thread {
        final int index;

        public Shooting(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            Soldier soldier;
            try {
                while (!done) {
                    soldier = rank[nextLine][index];
                    // 一排中的士兵必须同时开始射击
                    startBarrier.await();// 语句③
                    // 该士兵开始射击
                    soldier.fire();
                    // 一排中的士兵必须等待该排中的所有其他士兵射击完毕才能够离开射击点
                    shiftBarrier.await();// 语句④
                }
            } catch (InterruptedException e) {
                // 什么也不做
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }// run方法结束
    }// 类Shooting定义结束

    // 参与打靶训练的士兵
    static class Soldier {
        private final int seqNo;

        public Soldier(int seqNo) {
            this.seqNo = seqNo;
        }

        public void fire() {
            System.out.println(this + " start firing...");
            Tools.randomPause(5000);
            System.out.println(this + " fired.");
        }

        @Override
        public String toString() {
            return "Soldier-" + seqNo;
        }

    }// 类Soldier定义结束


}
