package com.hspedu.common;

/**
 * 消息类型
 */
public interface MessageType {

    //在接口中定义一些常量，不同常量的值代表不同的消息类型
    String MESSAGE_LOGIN_SUCCESS = "1"; //登录成功
    String MESSAGE_LOGIN_FAIL = "2"; //登录失败
    String MESSAGE_ONLINE_FRIEND = "3"; //拉取在线用户
    String MESSAGE_ONLINE_RETURN = "4"; //返回在线用户
    String MESSAGE_EXIT = "5"; //退出
    String MESSAGE_COMMON = "6"; //发送的是普通聊天信息
}
