package IO流.标准输入输出流;

import java.util.Scanner;

/**
 * 标准输入输出流
 */
public class InputAndOutput {

    public static void main(String[] args) {

        //System.in 编译类型 InputStream    运行类型 BufferedInputStream
        //System.out 编译类型 PrintStream    运行类型 PrintStream

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String next = scanner.next();
        System.out.println("next = " + next);
    }
}
