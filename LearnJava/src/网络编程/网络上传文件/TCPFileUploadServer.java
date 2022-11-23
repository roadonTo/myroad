package 网络编程.网络上传文件;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收从客户端发过来的信息，
 * 然后返回给客户端 “已接收到” 的回应
 */
public class TCPFileUploadServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端已启动，等待连接...");
        Socket socket = serverSocket.accept();

        //接收客户端发过来的输入流
        byte[] bytes = StreamUtils.streamToByteArray(socket.getInputStream());
        //写入本地磁盘
//        String writePath = "e:\\serverWriteZJM.png";
        String writePath = "src\\ZJM.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(writePath));
        String str = null;
        bos.write(bytes);

        //写完后 返回消息 “已接收到”  给客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("已接收到".getBytes());
        outputStream.flush();//刷新
        socket.shutdownOutput();

        //关闭所有流
        outputStream.close();
        bos.close();
        socket.close();
        serverSocket.close();


    }
}
