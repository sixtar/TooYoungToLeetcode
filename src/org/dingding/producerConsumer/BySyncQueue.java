package org.dingding.producerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SynchronousQueue可以在线程之间交换数据，典型的生产者消费者代码
 * 使用ReentrantLock公平锁来保证两个消费者顺序轮流消费
 *
 * @author dzj
 */
public class BySyncQueue {

    boolean runFlag = true;

    // 公平锁
    private ReentrantLock lock = new ReentrantLock(true);


    public void useSynchronousQueue() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        // ！！注意，SynchronousQueue自己的公平锁模式只能确保【等待】线程以公平的方式去访问，不能保证轮流处理

        Runnable producer = () -> {

            while (runFlag) {
                // int product = new Random().nextInt(100);
                for (int i = 0; i < 1000; i++) {
                    int product = i;
                    try {
                        System.out.println("product" + product + "生产出来了");
                        // Thread.sleep(product * 30);
                        Thread.sleep(10 * 30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        synchronousQueue.put(product);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }


            }

        };

        /*Runnable consumer = () -> {
            while (runFlag) {
                try {
                    int product = synchronousQueue.take();
                    System.out.println("product" + product + "被消费了");
                    int restTime = new Random().nextInt(100);
                    Thread.sleep(restTime * 40);


                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        };*/
        Condition condition = lock.newCondition();
        PrdConsumer consumer1 = new PrdConsumer(synchronousQueue, lock, condition, "consumer 1");
        PrdConsumer consumer2 = new PrdConsumer(synchronousQueue, lock, condition, "consumer 2");

        executor.submit(producer);
        executor.submit(consumer1);
        executor.submit(consumer2);

        executor.awaitTermination(50000, TimeUnit.MILLISECONDS);
        runFlag = false;
        consumer1.setRunFlag(false);
        consumer2.setRunFlag(false);
        executor.shutdown();
    }

    public static void main(String[] args) throws Exception {
        new BySyncQueue().useSynchronousQueue();
    }
}
