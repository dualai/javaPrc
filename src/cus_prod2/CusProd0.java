package cus_prod2;

import utils.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CusProd0 {

    private AtomicInteger resourceNumber = new AtomicInteger(0);

    /**
     * 用链表是因为插入和删除比较快
     * ArrayBlockingQueue 查找和修改快
     */
    /**
     * 最多五个资源在有序链表中
     */
    private BlockingQueue<Resource> queue = new LinkedBlockingQueue<>(5);

    private final class ProductRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                //TODO 生产资源
                // 不定期生产，模拟随机的用户请求
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    Resource resource = new Resource(resourceNumber.getAndIncrement());
                    Log.log("product resource,id = " + resource.resourceId);
                    queue.put(resource);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private final class CustomerRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                //TODO 消耗资源
                try {
                    Resource resource = queue.take();
                    // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                    Thread.sleep(500 + (long) (Math.random() * 500));
                    Log.log("------custom,resource,id = " + resource.resourceId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new CusProd0().test();
    }

    private void test() {
        for (int i = 0; i < 5; i++) {
            new Thread(new ProductRunnable()).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new CustomerRunnable()).start();
        }


        /**
         * 验证试试缓冲区容量
         */
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                Log.log("count ---- "+queue.size());
//            }
//        };
//        timer.schedule(timerTask,0,100);
    }
}
