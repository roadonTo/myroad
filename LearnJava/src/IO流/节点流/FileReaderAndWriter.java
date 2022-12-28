package IO流.节点流;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 对于内存和硬盘，站在内存的角度看
 * 字符输入流 FileReader
 * 字符输出流 FileWriter
 */
public class FileReaderAndWriter {

    public static void main(String[] args) {

        String path = "e:\\note.txt";
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        int read = 0;
        char[] chars = new char[8];
        try {
            fileWriter = new FileWriter(path, true);
            fileWriter.write("hello world, 你好世界！");
            fileWriter.write("一样的月光！".toCharArray(), 0, 3); //写入指定的长度
            System.out.println("写入成功~");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close(); //注意，必须关闭了FileWriter之后，内容才会被写入文件，否则内容还是在内存中 读取不到的

                fileReader = new FileReader(path);
                while ((read = fileReader.read(chars)) != -1) {
                    System.out.print(new String(chars, 0, read));
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
