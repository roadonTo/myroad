package IO流.对象处理流;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 对象处理流，
 * 反序列化（将文件还原成对象）
 */
public class ObjectInputStream_ {

    public static void main(String[] args) throws Exception {

        String filePath = "e:\\data.dat";
        ObjectInputStream ois = null;

        ois = new ObjectInputStream(new FileInputStream(filePath));

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());

        //dog的编译类型是 Object，dog 的运行类型是 Dog
        Object dog = ois.readObject();
        System.out.println("运行类型: " + dog.getClass());
        System.out.println(dog); // 底层是 Object -> Dog

        // 1.如果我们希望调用Dog的方法，需要向下转型
        // 2.需要我们将Dog类的定义，放到可以引用的位置
        Dog dog1 = (Dog)dog;
        System.out.println(dog1.getName());

        ois.close();


    }
}
