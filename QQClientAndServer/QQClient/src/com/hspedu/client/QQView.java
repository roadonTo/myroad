package com.hspedu.client;


import com.hspedu.service.UserClientService;
import com.hspedu.utils.Utility;
import com.sun.xml.internal.ws.util.StreamUtils;

/**
 * 客户端登录界面
 */
public class QQView {
    private boolean loop = true; //用loop来控制循环
    private UserClientService userClientService = new UserClientService(); //对象是用于登录服务和注册
    String key; //接收用户的键盘输入

    public static void main(String[] args) {
        new QQView().MainMenu();

    }


    public void MainMenu() {

        while (loop) {
            System.out.println("===============多用户通信系统=============="); //一级菜单
            System.out.println("\t\t 1.登录系统");
            System.out.println("\t\t 2.退出系统");
            System.out.print("请输入：");
            key = Utility.getString();
            switch (key) {
                case "1":
                    System.out.print("please input name: ");
                    String name = Utility.getString();
                    System.out.print("please input password: ");
                    String pwd = Utility.getString();
                    if (userClientService.checkUser(name, pwd)) {
                        System.out.println("用户 " + name + "登录成功");
                        while (loop) {
                            System.out.println("=======网络通信系统 二级菜单 用户 " + name + "=========="); //二级菜单
                            System.out.println("\t\t 1.显示在线用户列表");
                            System.out.println("\t\t 2.群发消息");
                            System.out.println("\t\t 3.私聊消息");
                            System.out.println("\t\t 4.发送文件");
                            System.out.println("\t\t 9.退出系统");
                            System.out.print("请输入你的选择： ");
                            String number = Utility.getString();
                            switch (number) {
                                case "1":
                                    System.out.println("显示在线用户列表");
                                    userClientService.getOnlineUsers();
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    System.out.print("请输入私聊对象Id：");
                                    String userId = Utility.getString();
                                    System.out.print("请输入发送的消息：");
                                    String messageTo = Utility.getString();
                                    System.out.println(name + "给 " + userId + "发送：" + messageTo);
                                    userClientService.sendMessage(userId, messageTo);
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    System.out.println(name + " 退出系统");
                                    userClientService.exit();
//                                    loop = false;
                                    break;
                            }
                        }

                    } else {//登录服务器失败
                        System.out.println("=============登录失败!================");


                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }


        }

    }

}
