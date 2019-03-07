package cus_prod;

import DieLock.DeadLock;
import utils.Log;

public class Cus_Prod {
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
                    if (x++ % 2 == 0) {
                        student.name = "林青霞";
                        student.age = 27;
                    } else {
                        student.name = "徐路明";
                        student.age = 30;
                    }
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
                    Log.log("name:" + student.name + " age:" + student.age);
                }
            }
        }
    }

    public static class Student {
        String name;
        int age;
    }
}

