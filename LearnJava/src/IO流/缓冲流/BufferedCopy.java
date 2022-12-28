package IO流.缓冲流;

import java.io.*;

/**
 * 字符缓冲流的拷贝，处理字符文件（一般是指文本文件）
 */
public class BufferedCopy {

    public static void main(String[] args) {

        String srcFile = "e:\\a.txt";
        String toFile = "e:\\a2.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String line;

        try {
            bufferedReader = new BufferedReader(new FileReader(srcFile));
            bufferedWriter = new BufferedWriter(new FileWriter(toFile));

            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
