public class ThreadTest2 {

    public static class Task {

        //成员变量存储在堆内存里面，多个线程访问同一个堆内存，
        //即多个线程可以同时修改num的值，这样会导致线程安全问题
        private int num=0;

        public void changeNum(boolean flag){
            if(flag){
                num = 88;
                System.out.println(Thread.currentThread().getName() + "=====" + "begin");
                System.out.println(Thread.currentThread().getName() + "=====" + num);
                System.out.println(Thread.currentThread().getName() + "=====" + "over");
            }else{
                num = 66;
                System.out.println(Thread.currentThread().getName() + "=====" + "begin");
                System.out.println(Thread.currentThread().getName() + "=====" + num);
                System.out.println(Thread.currentThread().getName() + "=====" + "over");
            }
        }

    }

    public static void main(String[] args) {
        Task task = new Task();

        Thread t1 = new Thread(){
            public void run(){
                task.changeNum(true);
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                task.changeNum(false);
            }
        };

        t1.start();
        t2.start();
    }
}


