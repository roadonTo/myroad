package com.hspedu.service;

import java.util.HashMap;

/**
 * 管理 客户端连接服务器线程 的集合
 */
public class ManageClientConnectServerThread {

    //把用户名当key，把线程当value
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //把线程添加进集合
    public static void addCcst(String userId, ClientConnectServerThread cCst){
        hm.put(userId, cCst);
    }

    //通过userId 得到对应线程
    public ClientConnectServerThread getCcst(String userId){
        return hm.get(userId);
    }

}
