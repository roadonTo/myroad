package IO流.节点流;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 对于内存和硬盘，站在内存的角度看
 * 字节输入流 （将数据从硬盘、外部 输入/读取 到内存/程序）
 * 字节输出流 （将数据从程序 输出到硬盘/C盘，D盘，E盘，U盘）
 */
public class InputStream_ {

    public static void main(String[] args) {


    }

    @Test
    public void readObject(){
        String filePath = "e:\\a.txt";
        FileInputStream fileInputStream = null;
        int readData = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            //这是最基本的调用read()方法一个一个的读取字节，效率低且无法读取到汉字之类的，会乱码
            while((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void readObject2(){
        String filePath = "e:\\test3";
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[8];
        int readData = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            //这是调用read(byte[] b) 方法，一次读取多个字节，提高了效率
            while ((readData = fileInputStream.read(buf)) != -1){
                System.out.print(new String(buf,0,readData));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}









