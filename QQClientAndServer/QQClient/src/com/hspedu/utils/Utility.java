package com.hspedu.utils;

import java.util.Scanner;

/**
 * 获取输入信息的 工具类
 */
public class Utility {

    private static Scanner scanner = new Scanner(System.in);

    public static String getString() {
        String next = scanner.next();
        return next;
    }
}
