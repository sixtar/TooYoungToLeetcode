package providerAndComsumer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    private static boolean globalSwitch = true;

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            while (Test.globalSwitch) {
                Random r = new Random();
                int i = r.nextInt();
                try {
                    queue.put(i);
                    System.out.printf("生产了一个数: %d\n", i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        executorService.execute(() -> {
            while (Test.globalSwitch || queue.size() > 0) {
                Integer poll = queue.poll();
                if (poll != null) {
                    try {
                        System.out.printf("消费了一个数: %d\n", poll);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread.sleep(3000);
        Test.globalSwitch = false;
        System.out.println("即将运行完成");

    }


}
