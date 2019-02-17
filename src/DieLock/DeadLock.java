package DieLock;

import utils.Log;

public class DeadLock {

    public static class Thread1 extends Thread {
        private final Resource resource1;
        private final Resource resource2;

        public Thread1(Resource resource1, Resource resource2) {
            this.resource1 = resource1;
            this.resource2 = resource2;
        }

        @Override
        public void run() {
            synchronized (resource1) {
                Log.log(Thread.currentThread().getName()+" 先处理:" + resource1.getName());
                synchronized (resource2) {
                    Log.log(Thread.currentThread().getName()+" 再处理:" + resource2.getName());
                }
            }
        }
    }

    public static class Thread2 extends Thread {
        private final Resource resource1;
        private final Resource resource2;

        public Thread2(Resource resource1, Resource resource2) {
            this.resource1 = resource1;
            this.resource2 = resource2;
        }

        @Override
        public void run() {
            synchronized (resource2) {
                Log.log(Thread.currentThread().getName()+" 先处理:" + resource2.getName());
                synchronized (resource1) {
                    Log.log(Thread.currentThread().getName()+" 再处理:" + resource1.getName());
                }
            }
        }
    }


    public static void main(String[] args) {
        new DeadLock().test();
    }

    public void test() {
        Resource resource1 = new Resource("资源1");
        Resource resource2 = new Resource("资源2");

        new Thread1(resource1, resource2).start();
        new Thread2(resource1, resource2).start();
    }

    public static class Resource {
        private String name;

        public String getName() {
            return name;
        }

        public Resource(String _name) {
            this.name = _name;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
