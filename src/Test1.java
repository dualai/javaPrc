import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Test1 {
    public static void main(String[] args) {
        String abc = "fjkdasjjf01";
        try {

            byte first = 300 >> 8;
            Log.log("first:" + first);

            byte second = (byte)300;
            Log.log("second:" + second);

            int length = (first << 8) + second;
            Log.log("length:" + length);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
