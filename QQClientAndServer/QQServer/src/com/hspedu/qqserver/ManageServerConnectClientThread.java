package com.hspedu.qqserver;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 管理 服务器连接客户端线程 的集合
 */
public class ManageServerConnectClientThread {

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static void addServerConnectClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    //判断HashMap集合中 是否含有 UserId
    public static boolean judgeUserId(String str) {
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            if (str.equals(iterator.next())) {
                return true;
            }

        }
        return false;
    }


    /*
    获取在线用户列表
     */
    public static String getUserId() {
        Iterator<String> iterator = hm.keySet().iterator();
        String str = "";
        while (iterator.hasNext()) {
            str += iterator.next() + ",";
        }
        return str;
    }


    /*
    用户退出，移除掉对应线程
     */
    public static void remove(String userId) {
        hm.remove(userId);
    }


}
