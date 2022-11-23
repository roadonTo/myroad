package reflect.com.road;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 熟悉反射
 * 通过反射获取Cat类相关信息
 */
public class Reflect {

    public static void main(String[] args) throws Exception {

        //获取配置文件中的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classFullPath = properties.getProperty("className").toString(); //得到reflect.com.road.Cat ,但这个是字符串 不是对象，不能new
        String methodName = properties.getProperty("method").toString(); //得到hi方法名
        System.out.println(classFullPath);
        System.out.println(methodName);
        System.out.println("----------------------------------");

        /*
        使用反射
         */
        Class cls = Class.forName(classFullPath); //加载类，得到Class类型的对象 cls
        Object o = cls.newInstance(); //通过cls 得到你加载的类的 对象实例 o
        //获得成员变量
        Field age = cls.getField("age");
        System.out.println("age = " + age.get(o));
        //获得方法
        Method clsMethod = cls.getMethod(methodName);
        //这个clsMethod 在debug时 显示的就是 hi().invoke(o) ;  就是执行的hi()里面的输出内容
        clsMethod.invoke(o);
        //获得无参构造器、有参构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);
        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);


    }

}
