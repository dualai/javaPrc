package cus_prod2;

import utils.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class CusProd2 {
    private final static int QueueMaxCap = 5;
    private final Queue<Resource> queue = new LinkedList<Resource>();
    private final Object LOCK_OBJ = new Object();
    private AtomicInteger resourceNumber = new AtomicInteger(0);

    private final class CustomerRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {

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

                synchronized (queue) {

                }
            }
        }
    }

    public static void main(String[] args) {
        new CusProd2().test();
    }

    private void test() {
        for (int i = 0; i < 5; i++) {
            new Thread(new CusProd2.ProductRunnable()).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new CusProd2.CustomerRunnable()).start();
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
