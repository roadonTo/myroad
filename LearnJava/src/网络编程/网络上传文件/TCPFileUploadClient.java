package 网络编程.网络上传文件;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 从本地磁盘上传一张图片到内存，
 * 然后发给服务端，
 * 最后能接收到服务端返回的 “已接收到” 的信息
 */
public class TCPFileUploadClient {

    public static void main(String[] args) throws IOException {

        //先从磁盘上 上传上来图片
        String filePath = "e:\\zjm.png";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //获取到图片 放入字节数组
        byte[] bytes = StreamUtils.streamToByteArray(fileInputStream);

        //创建socket 把图片发送给服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();

        //接收服务端返回的 “已接收到” 消息
        String s = StreamUtils.streamToString(socket.getInputStream());
        System.out.println(s);

        //关闭所有流
        bos.close();
        socket.close();
        fileInputStream.close();

    }
}
