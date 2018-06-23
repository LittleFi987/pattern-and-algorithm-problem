package jut;

import java.util.concurrent.CountDownLatch;

/**
 * @Author yechenhao
 * @Date 01/05/2018
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            System.out.println("son Thread: " + Thread.currentThread().getName() + "正在执行");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
            }
            System.out.println("son Thread: " + Thread.currentThread().getName() + "执行完毕");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("son Thread: " + Thread.currentThread().getName() + "正在执行");
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
            }
            System.out.println("son Thread: " + Thread.currentThread().getName() + "执行完毕");
            latch.countDown();
        }).start();

        try {
            System.out.println("wait two Thread end....");
            latch.await();
            System.out.println("two Thread Already process end");
            System.out.println("continue process main Thread");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
