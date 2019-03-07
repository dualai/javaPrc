package cus_prod;

import utils.Log;

/**
 *
 */
public class Cus_Prod3 {
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
                if (x % 2 == 0) {
                    student.set("林青霞", 27);
                } else {
                    student.set("徐路明", 39);
                }
                x++;
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
                student.get();
            }
        }
    }
}



