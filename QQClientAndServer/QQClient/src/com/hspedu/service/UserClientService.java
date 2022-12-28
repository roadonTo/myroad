package com.hspedu.service;

import com.hspedu.common.Message;
import com.hspedu.common.MessageType;
import com.hspedu.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 用于 用户登录或注册
 */
public class UserClientService {

    //因为 用户信息 和 流 会在别的地方被用到，所以写成属性方便调用
    private User user = new User();
    private Socket socket;

    /*
    登录或注册
     */
    public boolean checkUser(String name, String pwd) {
        boolean p = false;
        user.setName(name);
        user.setPwd(pwd);
        try {
            //连接到服务器，发送user对象
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            //读取从服务器返回的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message msg = (Message) ois.readObject();

            if (msg.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)) { //登录成功
                //创建一个和服务器端保持通信的线程，把socket放入线程中
                //这里我们用一个线程类 ClientConnectServerThread
                ClientConnectServerThread cCst = new ClientConnectServerThread(socket);
                //启动线程
                cCst.start();
                //为了客户端以后的扩展，把线程放入一个集合中，统一管理 ManageClientConnectServerThread
                ManageClientConnectServerThread.addCcst(name, cCst);
                p = true;
            } else {
                //如果登录失败，就不用开启线程， 关闭socket
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    /*
    拉取在线用户信息
     */
    public void getOnlineUsers() {
        //发送一条信息给服务端，表示我要拉取在线用户信息
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_ONLINE_FRIEND);
        message.setSender(user.getName());
        //获取到包含这个socket的线程
        ManageClientConnectServerThread manageClientConnectServerThread = new ManageClientConnectServerThread();
        Socket socket = manageClientConnectServerThread.getCcst(user.getName()).getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    退出系统
     */
    public void exit() {
        Message message = new Message();
        message.setSender(user.getName());
        message.setMsgType(MessageType.MESSAGE_EXIT);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new ManageClientConnectServerThread().getCcst(user.getName()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.exit(0); //让这个进程结束 ，里面的所有线程自然就结束了
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    发送文本消息
     */
    public void sendMessage(String userId, String content) {
        //构建Message对象
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_COMMON);
        message.setSender(user.getName());
        message.setGetter(userId);
        message.setContent(content);
        //获取输出流 发送信息到服务器
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new ManageClientConnectServerThread().getCcst(user.getName()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
