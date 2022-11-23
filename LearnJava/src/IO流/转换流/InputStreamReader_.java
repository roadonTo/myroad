package IO流.转换流;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * 转换流  可以将字节转成字符，并且指定编码格式
 * 可应用于： 解决乱码问题
 */
public class InputStreamReader_ {

    public static void main(String[] args) throws Exception {

        String filePath = "e:\\a.txt";
        String charset = "utf8";
        String s = null;

        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), charset);
        BufferedReader br = new BufferedReader(isr);

        while((s = br.readLine()) != null){
            System.out.println(s);
        }

        br.close();
    }
}
