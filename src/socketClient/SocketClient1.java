package socketClient;

import utils.Log;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient1 {
    int port = 58987;

    public SocketClient1() {

    }

    public static void main(String[] args) {
        SocketClient1 socketClient = new SocketClient1();
        try {
            socketClient.startClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startClient() throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好  I am xiaoming 哈哈哈哈 abc...";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        socket.getOutputStream().flush();

        outputStream.close();
        socket.close();
        Log.log("end client...");
    }
}
