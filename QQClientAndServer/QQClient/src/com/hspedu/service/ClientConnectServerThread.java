package com.hspedu.service;

import com.hspedu.common.Message;
import com.hspedu.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 客户端连接服务端的 线程类
 */
public class ClientConnectServerThread extends Thread {

    private Socket socket;

    //构造器可以接受一个socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        //因为要保持和服务端通信，所以用while循环
        while (true) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，这个线程会一直保持堵塞
                Message msg = (Message) ois.readObject();

                //判断服务端返回的Message类型
                if (msg.getMsgType().equals(MessageType.MESSAGE_ONLINE_RETURN)) {
                    System.out.print("\n在线用户有：");
                    //用一个数组来接收 返回的在线用户们的名字
                    String[] split = msg.getContent().split(","); //这里表示规定 返回的名字格式 是用逗号分隔的
                    for (int i = 0; i < split.length; i++) {
                        System.out.print(split[i] + "\t");
                    }
                } else if (msg.getMsgType().equals(MessageType.MESSAGE_COMMON)) {
                    System.out.println("\n" + msg.getSender() + "给 " + msg.getGetter() + "发送：" + msg.getContent());
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
