package com.hspedu.qqserver;

import com.hspedu.common.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveOutlineMsg implements Serializable {
    public static HashMap<String, ArrayList<Message>> hashMap = new HashMap<>();//用于存放离线消息
    public static ArrayList<Message> list = new ArrayList<>();



}
