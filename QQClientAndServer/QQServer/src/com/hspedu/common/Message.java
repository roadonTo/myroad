package com.hspedu.common;

import java.io.Serializable;

/**
 * 信息对象
 */
public class Message implements Serializable {

    private String sender; //发送者
    private String getter; //接收者
    private String content; //发送内容
    private String sendTime; //发送时间
    private String msgType; //消息类型 【在接口里面定义消息类型 】
    private static final long serialVersionUID = 1L;

    public Message() {
    }

    public Message(String sender, String getter, String content, String sendTime) {
        this.sender = sender;
        this.getter = getter;
        this.content = content;
        this.sendTime = sendTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
