package IO流.节点流;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流
 */
public class OutputStream_ {

    public static void main(String[] args) {


    }

    @Test
    public void writeFile(){
        String filePath = "e:\\a.txt";
        FileOutputStream fileOutputStream = null;
        String str = "hello";
        try {
//            fileOutputStream= new FileOutputStream(filePath); //这个构造器形成的流 是覆盖型写入
            fileOutputStream= new FileOutputStream(filePath,true); //这个构造器形成的流 是追加型写入

            fileOutputStream.write(str.getBytes()); //写入字节数组，字符串
            fileOutputStream.write('H'); //写入单个字节
//            fileOutputStream.write(str,0,3); //指定写入

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
