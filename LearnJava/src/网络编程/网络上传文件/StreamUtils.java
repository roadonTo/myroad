package 网络编程.网络上传文件;

import java.io.*;

public class StreamUtils {
    /**
     * 将输入流转换成byte[]
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        //这里用一个字节数组输出流来接收
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = is.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        byte[] byteArray = bos.toByteArray();
        bos.close();//返回之前需要先关闭流

        return byteArray;
    }

    /**
     * 将输入流转换成String
     */
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String str;
        while ((str = bufferedReader.readLine()) != null){
            builder.append(str + "\r\n");
        }
        String s = builder.toString();
        return s;
    }

}
