package socketClient;

import utils.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient3 {
    int port = 58987;

    public SocketClient3() {

    }

    public static void main(String[] args) {
        SocketClient3 socketClient = new SocketClient3();
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
        socket.shutdownOutput(); ////通过shutdownOutput告诉服务器已经发送完数据，后续只能接受数据

        InputStream inputStream = socket.getInputStream();
        StringBuffer sb = new StringBuffer();
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes,0,length));
        }
        Log.log("收到服务器消息:"+sb.toString());

        outputStream.close();
        inputStream.close();
        socket.close();
        Log.log("end client...");
    }
}
