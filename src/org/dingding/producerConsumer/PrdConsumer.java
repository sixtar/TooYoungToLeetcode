package org.dingding.producerConsumer;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dzj
 */
public class PrdConsumer implements Runnable{

    private SynchronousQueue<Integer> synchronousQueue;

    private ReentrantLock lock;

    private Condition condition;

    private String tag;

    private boolean runFlag = true;

    // 处理中标志，防止可重入锁重入
    private boolean handling;

    public void setRunFlag(boolean rf){
        this.runFlag = rf;
    }

    public PrdConsumer(SynchronousQueue<Integer> queue,ReentrantLock lock,Condition condition, String tag){
        this.lock = lock;
        this.condition = condition;
        this.synchronousQueue = queue;
        this.tag = tag;
    }



    @Override
    public void run() {

            while (runFlag) {
                lock.lock();

                try {
                    /*if(handling){
                        condition.await();
                    }
                    handling = true;
                    */
                    int product = synchronousQueue.take();
                    System.out.println("product" + product + "被"+tag+"消费了");
                    int restTime = new Random().nextInt(100);
                    Thread.sleep(restTime * 20);
                    // handling = false;
                    // condition.signal();


                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }

    }
}
