import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest1 {
    public static void main(String[] args) {

        Thread t1 = new Thread(){
            public void run(){
//                try {
//                    //睡眠时间长一些
//                    Thread.sleep(100000000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                while (!this.isInterrupted()){
                    System.out.println("sleep");
                }
            }
        };

        t1.start();

        //唤醒睡眠中的线程

        try {
            //睡眠时间长一些
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();

//        ThreadPoolExecutor
    }
}
