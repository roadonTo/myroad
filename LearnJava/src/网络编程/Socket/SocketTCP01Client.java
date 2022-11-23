package 网络编程.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP01Client {

    public static void main(String[] args) throws IOException {

        //1. 客户端通过ip 和 端口号  创建一个Socket。如果连接成功会返回一个Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("socket = " + socket.getClass());

        //2. 通过socket.getOutputStream() 生成一个输出流，以便发出消息
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流 写入数据到 数据通道
        // 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道 例如 bufferedWriter.flush()；
        outputStream.write("hello,server".getBytes());
        socket.shutdownOutput(); // 表示信息输完了，相当于是个标志

        InputStream inputStream = socket.getInputStream();
        byte[] bt = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bt)) != -1){
            System.out.println(new String(bt,0,len));
        }

        //4. 按顺序关闭所有流
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
