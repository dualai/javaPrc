package cus_prod;

import utils.Log;

public class Student {
    private String name;
    private int age;
    private boolean flg; //表示student有没有被创建，flg = true，表示创建完毕，flg = false，表示被消费掉

    public synchronized void set(String name, int age) {
        if (this.flg) {
            try {
                this.wait();  //wait执行后，student上的锁立即被释放，并且等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.name = name;
        this.age = age;
        //表示已经创建
        this.flg = true;
        this.notify(); //唤醒get，分两种情况，有可能被自己抢到执行权，继续走SetRunnable的while（true）循环,到了wait后释放锁；或者被GetRunnable抢到执行权
    }

    public synchronized void get() {
        if (!this.flg) {
            try {
                this.wait();//wait执行后，student上的锁立即被释放，并且等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.log("name:" + this.name + " age:" + this.age);
        this.flg = false;
        this.notify(); //唤醒set
    }
}
