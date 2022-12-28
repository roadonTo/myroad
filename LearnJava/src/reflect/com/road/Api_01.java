package reflect.com.road;

import java.lang.reflect.Field;

public class Api_01 {

    public static void main(String[] args) throws Exception {

        //得到Class对象
        Class<?> cat = Class.forName("reflect.com.road.Cat");
        System.out.println(cat.getName());
        System.out.println(cat.getSimpleName());
        //getFields() 获取所有的public属性，包含本类及父类的
        Field[] fields = cat.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类中的属性=" + field.getName());
        }

        //getDeclaredFields() 获取本类中所有属性
        Field[] declaredFields = cat.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println("本类中所有属性=" + f.getName());
        }

        //方法和构造器的获取也是一样的（但构造器 不能获取父类的构造器），还有获取父类信息，接口信息，注解信息。。。

        /*
        还可以获取修饰符（属性的，方法的）
        getModifiers  以int形式返回修饰符
        getType 以Class形式返回类型
        getName 返回属性名
        getParameterTypes 返回形参数组
        【默认修饰符是0，public是1，private是2，protected是4，static是8，final是16】
         */

    }
}
