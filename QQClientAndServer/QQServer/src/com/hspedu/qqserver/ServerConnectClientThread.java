package com.hspedu.qqserver;

import com.hspedu.common.Message;
import com.hspedu.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId;// 用于确定是哪个客户端


    public ServerConnectClientThread(Socket socket, String userId){
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {

        while (true){ //该线程一直开着，等着接收客户端发过来的信息
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message msg = (Message) ois.readObject();
                //后面会使用message
                if (msg.getMsgType().equals(MessageType.MESSAGE_ONLINE_FRIEND)){
                    //调用获取在线用户的方法
                    String userIds = ManageServerConnectClientThread.getUserId();
                    Message message = new Message();
                    message.setMsgType(MessageType.MESSAGE_ONLINE_RETURN);
                    message.setContent(userIds);
                    message.setGetter(msg.getSender());
                    //获取对应线程 用其中的socket 发送message给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(msg.getSender()).getSocket().getOutputStream());
                    oos.writeObject(message);
                } else if (msg.getMsgType().equals(MessageType.MESSAGE_EXIT)){
                    System.out.println("用户" + msg.getSender() + "退出了");
                    //将集合中的线程移除掉
                    ManageServerConnectClientThread.remove(msg.getSender());
                    //退出while循环
                    break;
                } else if (msg.getMsgType().equals(MessageType.MESSAGE_COMMON)){
                    //先判断 接收者是否在线
                    boolean b = ManageServerConnectClientThread.judgeUserId(msg.getGetter());
                    if (b){ //如果b为true，说明在线
                        //获取接收对象的userId 的线程 用其中的socket 发送message给接收对象
                        ObjectOutputStream oos =
                                new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(msg.getGetter()).getSocket().getOutputStream());
                        oos.writeObject(msg);
                    } else { //不在线，把信息保存下来 等上线了 再发给他
                        SaveOutlineMsg.list.add(msg);
                        SaveOutlineMsg.hashMap.put(msg.getGetter(),SaveOutlineMsg.list);


//                        list.add(msg);
//                        hashMap.put(msg.getGetter(),list);
                        System.out.println("用户还没上线，我先把信息保存下来了");
                    }



                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }


    //判断是否有离线消息
    public  void outLineMessage(String getter){
        //先判断是否有离线消息未接收到
        Iterator<String> iterator = SaveOutlineMsg.hashMap.keySet().iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(getter)){
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(getter).getSocket().getOutputStream());
                    ArrayList<Message> messages = SaveOutlineMsg.hashMap.get(getter);
                    for (int i = 0; i < messages.size(); i++) {
                        objectOutputStream.writeObject(messages.get(i));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
