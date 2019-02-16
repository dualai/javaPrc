import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest5 {
    public static void main(String[] args) {
        new ThreadTest5().alternateTask();
    }

    private void alternateTask() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 65; i < 91; i++) {
                        System.out.println("----------thread1------- " + (char) i);
                        condition2.signal();
                        condition1.await();
                    }
                    condition2.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                    System.out.println("thread1 done...");
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 26; i++) {
                        System.out.println("----------thread2------- " + i);
                        condition1.signal();
                        condition2.await();
                    }
                    condition1.signal();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                    System.out.println("thread2 done...");
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}
