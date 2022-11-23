package IO流.转换流;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_ {

    public static void main(String[] args) throws Exception{

        String filePath = "e:\\translate.txt";
        String charset = "gbk";

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charset);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("赵今麦！");
        bw.write("向往的生活");
        bw.write("today is a  good day ~");

        bw.close();
        System.out.println("写入成功");
    }
}
