package com.hspedu.common;

import java.io.Serializable;

/**
 * 用户对象
 */
public class User implements Serializable { //因为要在流中传输，所以必须实现序列化

    private String name; //用户名
    private String pwd; //密码
    private static final long serialVersionUID = 1L;

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
