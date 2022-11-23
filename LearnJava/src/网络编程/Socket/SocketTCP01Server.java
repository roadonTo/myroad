package 网络编程.Socket;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {

    public static void main(String[] args) throws IOException {

        //1. 先给服务端设定一个端口，然后等待连接。 如果连接上就会返回一个socket对象
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器等待连接中......");
        Socket socket = serverSocket.accept();
        System.out.println("socket = " + socket.getClass());

        //2. 通过socket.getInputStream() 生成一个输入流，以便接收到信息
        InputStream inputStream = socket.getInputStream();
        byte[] bt = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bt)) != -1){
            System.out.println(new String(bt,0,len));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        socket.shutdownOutput();

        //3. 按顺序关闭所有流
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
