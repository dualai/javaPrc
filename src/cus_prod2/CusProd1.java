package cus_prod2;

import utils.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class CusProd1 {
    private final static int QueueMaxCap = 5;
    private final Queue<Resource> queue = new LinkedList<Resource>();
    private final Object LOCK_OBJ = new Object();
    private AtomicInteger resourceNumber = new AtomicInteger(0);

    private final class CustomerRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (LOCK_OBJ) {
                    /** wait为什么放在while里头 https://blog.csdn.net/worldchinalee/article/details/83790790
                     * https://blog.csdn.net/yiifaa/article/details/76341707
                     */
                    while (queue.size() <= 0) { //一旦打破，会再次进去while循环判断一次条件还成不成功
                        try {
                            LOCK_OBJ.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Resource resource = queue.poll();
                    assert resource != null;
                    try {
                        Thread.sleep(50 + (long) (Math.random() * 50));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.log("--customer resource,id:" + resource.resourceId);
                    LOCK_OBJ.notifyAll();
                }
            }
        }
    }

    private final class ProductRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(50 + (long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (LOCK_OBJ) {
                    while (queue.size() >= QueueMaxCap) {
                        try {
                            LOCK_OBJ.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Resource resource = new Resource(resourceNumber.getAndIncrement());
                    Log.log("****product resource,id:" + resource.resourceId);
                    queue.offer(resource);
                    LOCK_OBJ.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        new CusProd1().test();
    }

    private void test() {
        for (int i = 0; i < 5; i++) {
            new Thread(new CusProd1.ProductRunnable()).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new CusProd1.CustomerRunnable()).start();
        }

        /**
         * 验证试试缓冲区容量
         */

//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                Log.log("count ---- " + queue.size());
//            }
//        };
//        timer.schedule(timerTask, 0, 100);
    }
}
