package bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author fandongfeng
 * @date 2023/2/18 16:01
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9001);
        while (true) {
            System.out.println("等待连接");
            //阻塞等待
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了");
            handler(clientSocket);
        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read。。。");
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕");
        if (read != -1) {
            System.out.println("接收到客户端数据：" + new String(bytes, 0, read));
        }
    }

}
