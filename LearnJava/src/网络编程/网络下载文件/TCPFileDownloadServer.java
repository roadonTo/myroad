package 网络编程.网络下载文件;

import 网络编程.网络上传文件.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPFileDownloadServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务端等待连接...");
        Socket socket = serverSocket.accept();

        //接收客户端发过来的 音乐名
        StringBuilder stringBuilder = new StringBuilder();
        int len = 0;
        byte[] bytes = new byte[1024];
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        while((len = bis.read(bytes)) != -1){
            stringBuilder.append(new String(bytes,0,len) );
        }
        String s = stringBuilder.toString();

        //把本地音乐名  放入一个数组，查找是否包含 客户端发送过来的 音乐名，如果没有，就发送一个默认的音乐文件
        //用一个数组来模拟 本地有的音乐
        String[] localMusics = {"南下", "一样的月光"};
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("南下");
        arrayList.add("一样的月光");
        arrayList.add("江湖之间");
        if (arrayList.contains(s)){ //如果为真，说明本地有这个文件
            String localMusicPath = "C:\\Users\\Administrator\\Music\\" + s +".mp3";
            //从硬盘输入到服务器
            BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(localMusicPath));
            byte[] bytes1 = StreamUtils.streamToByteArray(bis1);
            socket.getOutputStream().write(bytes1);
            socket.getOutputStream().flush();
            socket.shutdownOutput();
            bis1.close();
        } else { //否则，发送一个默认的音乐文件
            String localMusicPathDefine = "C:\\Users\\Administrator\\Music\\南下.mp3";
            //从硬盘输入到服务器
            BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(localMusicPathDefine));
            byte[] bytes1 = StreamUtils.streamToByteArray(bis1);
            socket.getOutputStream().write(bytes1);
            socket.getOutputStream().flush();
            socket.shutdownOutput();
            bis1.close();
        }

        //关闭流
        bis.close();
        socket.close();
        serverSocket.close();

    }
}
