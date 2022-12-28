package IO流.对象处理流;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 对象处理流，
 * 序列化 （将对象以文件【既有值又有数据类型】的形式保存下来）
 */
public class ObjectOutputStream_ {

    public static void main(String[] args) throws Exception {

        String filePath = "e:\\data.dat";
        ObjectOutputStream oos = null;

        oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(100);
        oos.writeBoolean(true);
        oos.writeChar('c');
        oos.writeObject(new Dog("小黄", 18));

        oos.close();
        System.out.println("序列化完成~");

    }
}
