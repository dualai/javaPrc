public class ThreadTest3 {

    public class SellTicket implements Runnable {
        private int count = 1000;

        @Override
        public void run() {
            while (true) {
                synchronized(this) {
                    if (count <= 0) {
                        break;
                    } else {
                        count--;
                        System.out.println(Thread.currentThread().getName() + " 卖出后还剩:" + count + "张");
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        new ThreadTest3().test();
    }

    private void test(){
        SellTicket sellTicket = new SellTicket();

        Thread thread1 = new Thread(sellTicket);
        thread1.setName("电影院1");

        Thread thread2 = new Thread(sellTicket);
        thread2.setName("电影院2");

        Thread thread3 = new Thread(sellTicket);
        thread3.setName("电影院3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
