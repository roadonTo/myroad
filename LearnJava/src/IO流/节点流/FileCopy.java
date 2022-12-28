package IO流.节点流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件拷贝
 */
public class FileCopy {

    public static void main(String[] args) {

        String pathread = "e:\\zjm.png";
        String pathwrite = "e:\\zhaojinmai.png";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        byte[] buf = new byte[1024];
        int len = 0;

        try {
            fileInputStream = new FileInputStream(pathread);
            fileOutputStream = new FileOutputStream(pathwrite);

            while ((len = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
