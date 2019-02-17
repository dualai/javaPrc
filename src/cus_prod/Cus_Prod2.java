package cus_prod;

import utils.Log;

/**
 *
 */
public class Cus_Prod2 {
    public static void main(String[] args) {

        Student s = new Student();

        SetRunnable setRunnable = new SetRunnable(s);
        GetRunnable getRunnable = new GetRunnable(s);

        Thread setThread = new Thread(setRunnable);
        Thread getThread = new Thread(getRunnable);

        setThread.start();
        getThread.start();
    }

    public static class SetRunnable implements Runnable {
        private final Student student;
        private int x = 0;

        public SetRunnable(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (student) {
                    Log.log("000");
                    if (student.flg) {
                        try {
                            student.wait();  //wait执行后，student上的锁立即被释放，并且等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (x % 2 == 0) {
                        student.name = "林青霞";
                        student.age = 27;
                    } else {
                        student.name = "徐路明";
                        student.age = 30;
                    }
                    x++;

                    //表示已经创建
                    student.flg = true;
                    student.notify(); //唤醒get
                    Log.log("111");
                }
            }
        }
    }

    public static class GetRunnable implements Runnable {
        private final Student student;

        public GetRunnable(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (student) {
                    if (!student.flg) {
                        Log.log("222");
                        try {
                            student.wait();//wait执行后，student上的锁立即被释放，并且等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.log("name:" + student.name + " age:" + student.age);

                    student.flg = false;
                    student.notify(); //唤醒set
                    Log.log("333");
                }
            }
        }
    }

    public static class Student {
        String name;
        int age;
        boolean flg; //表示student有没有被创建，flg = true，表示创建完毕，flg = false，表示被消费掉
    }
}

