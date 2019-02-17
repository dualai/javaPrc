import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

public class TestByteBuffer extends Templet {
    public static void main(String[] args) {
        Log.log(new TestByteBuffer().test4());
    }

    public void test(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        byteBuffer.clear();
        byteBuffer.put((byte)6);
        byteBuffer.put((byte)7);
        byteBuffer.put((byte)8);
        byteBuffer.put((byte)9);
        byteBuffer.put((byte)8);

        Log.log(byteBuffer.toString());

        byteBuffer.flip();
        for (int i = 0; i < 5; i++) {
            Log.log(byteBuffer.get());
        }

        Log.log("------");

        byteBuffer.rewind();
        byteBuffer.put((byte)5);
        byteBuffer.put((byte)4);
        byteBuffer.put((byte)3);
        byteBuffer.put((byte)2);
        byteBuffer.flip();
        for (int i = 0; i < 4; i++) {
            Log.log(byteBuffer.get());
        }

    }

    public int test2(){
        final ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            Log.log("111");
            return 18918;
        } finally {
            Log.log("222");
            lock.unlock();
        }
    }

    public int test3(){
        try {
            Log.log("111");

            int a = 10;
            int b = 10;
            int c = 1000;

            float aaa = c / (b-a);

            return 11111;
        }catch (Exception ex){
            ex.printStackTrace();
            return 22222;
        }
        finally {
            Log.log("222");
        }
    }

    public int test4(){
        byte[] src = new byte[] {1,2,33,45,66};

        byte[] dest = new byte[3];

        System.arraycopy(src,0,dest,0,3);

        for(int i = 0;i<dest.length;i++){
            Log.log(dest[i]);
        }

        return 6;
    }
}
