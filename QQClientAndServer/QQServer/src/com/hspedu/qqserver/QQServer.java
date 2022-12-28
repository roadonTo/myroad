package com.hspedu.qqserver;

import com.hspedu.common.Message;
import com.hspedu.common.MessageType;
import com.hspedu.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class QQServer {

    private ServerSocket serverSocket = null;

    //用hashMap集合模拟可以登录的用户
    private static HashMap<String, User> validUser = new HashMap<>();

    static {
        validUser.put("111", new User("111", "222"));
        validUser.put("222", new User("222", "222"));
        validUser.put("333", new User("333", "222"));
        validUser.put("444", new User("444", "222"));
    }

    public static boolean checkUser(String user, String pwd) {
        User user1 = validUser.get(user);
        if (user1 == null) {
            System.out.println("该用户不存在");
            return false;
        } else {
            if (!user1.getPwd().equals(pwd)) {
                System.out.println("密码输入错误");
                return false;
            } else {
                return true;
            }
        }

    }

    public QQServer() {
        System.out.println("服务端在9999端口监听。。。");
        try {
            serverSocket = new ServerSocket(9999);
            //当和某个客户端连接后，还会继续监听，所以用个while
            while (true) {
                /*
                这里一直在监听着，每当有一个客户端连接过来
                就新生成一个socket，新生成一个线程 跟这个对应的客户端连接
                 */
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();
                //创建一个Message对象，准备回复客户端
                Message message = new Message();
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                //验证登录
                if (checkUser(user.getName(), user.getPwd())) {
                    message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCESS);
                    oos.writeObject(message);
                    System.out.println("用户 " + user.getName() + "登录成功");
                    //创建一个线程 ServerConnectClientThread ，把socket放入线程中
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getName());
                    serverConnectClientThread.start();
                    //把该线程对象放到一个集合中进行管理
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getName(), serverConnectClientThread);
                    serverConnectClientThread.outLineMessage(user.getName());//传入登录的用户


                } else { //登录失败
                    System.out.println("用户名 " + user.getName() + ", 密码 " + user.getPwd() + "登录失败");
                    message.setMsgType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果退出了while循环，说明服务器不再监听了，因此需要关闭资源
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
