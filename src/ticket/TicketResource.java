package ticket;

import utils.Log;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketResource implements Runnable {
    private int tickets = 1000;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets <= 0) {
                    break;
                } else {
                    //将电影票总数做自减运算
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张，剩余" + tickets + "张");
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
