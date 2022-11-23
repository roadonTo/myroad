package 网络编程.网络下载文件;

import 网络编程.网络上传文件.StreamUtils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPFileDownloadClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 7777);
        //输入音乐名
        String musicName = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入音乐名：");
        musicName = scanner.next();

        //将音乐名发给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(musicName.getBytes());
        bos.flush();
        socket.shutdownOutput();
        System.out.println("等待接收文件中。。。");

        //接收服务端发送来的文件
        byte[] bytes = StreamUtils.streamToByteArray(socket.getInputStream());
        String toPath = "e:\\test\\" + musicName + ".mp3";
        BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(toPath));
        bos1.write(bytes);
        System.out.println("文件下载成功!");

        //关闭流
        bos1.close();
        bos.close();
        socket.close();

    }
}
