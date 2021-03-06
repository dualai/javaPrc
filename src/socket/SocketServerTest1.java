package socket;

import utils.Log;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest1 {

    int port = 58987;

    public SocketServerTest1() {

    }

    public static void main(String[] args) {
        SocketServerTest1 socketServerTest = new SocketServerTest1();
        try {
            socketServerTest.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 读取输入流过程 1、先获取客户端的输入流 2、建立缓冲区
     * @throws Exception
     */
    public void startServer() throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        Log.log("server将一直等待连接的到来...");
        Socket socket = serverSocket.accept();
        Log.log("socket come," + socket+" clientPort:"+socket.getPort()+" address:"+socket.getRemoteSocketAddress().toString());
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        Log.log("inputStream come");
        byte[] bytes = new byte[1024]; //先保证单次读完，设的大一点
        int len;
        StringBuffer sb = new StringBuffer();
        while ((len = inputStream.read(bytes)) != -1) {
            String newString = new String(bytes, 0, len, "UTF-8");
            Log.log("read,length = "+len+" newString:"+newString);
            sb.append(newString);
        }
        Log.log("get message from client: " + sb);
        inputStream.close();
        socket.close();
        serverSocket.close();
        Log.log("server end...");
    }
}
