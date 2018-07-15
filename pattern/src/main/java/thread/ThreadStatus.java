package thread;

/**
 * @author chenhao.ych
 * @date 2018-06-23
 */
public class ThreadStatus {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "-------- status: " + Thread.currentThread().getState());
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        });
        thread.start();
        while (true) {
            Thread.sleep(1000L);
            System.out.println("------status: " + thread.getState());
        }

    }


}
