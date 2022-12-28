package IO流.缓冲流;

import java.io.*;

/**
 * 字节缓冲流的拷贝，处理字节文件（视频，图片。。）
 */
public class BufferedCopy2 {

    public static void main(String[] args) {

        String srcFilePath = "C:\\Users\\Administrator\\Music\\李佳龙Jog - 南下（吉他弹唱）.mp3";
        String destFilePath = "e:\\南下.mp3";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        byte[] bytes = new byte[1024];
        int len = 0;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            while ((len = bis.read(bytes)) != -1) {
//                bos.write(bytes,0,len);
                bos.write(bytes);
            }
            System.out.println("拷贝完成！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis == null) {
                    bis.close();
                }
                if (bos == null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
