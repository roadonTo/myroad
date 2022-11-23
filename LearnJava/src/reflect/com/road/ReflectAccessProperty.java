package reflect.com.road;

import java.lang.reflect.Field;

/**
 * 通过反射访问属性
 *
 * 类似的，通过反射访问方法也是一样
 * 只是调用方法时 用的是 cry.invoke(o,"小猫哭"); // 方法名.invoke（对象实例，实参）；
 */
public class ReflectAccessProperty {

    public static void main(String[] args) throws Exception {

        Class<?> stuClass = Class.forName("reflect.com.road.Student");
        Object o = stuClass.newInstance();
        System.out.println(o);
        //使用反射得到age属性对象
        Field age = stuClass.getField("age");
        age.set(o,18);
        System.out.println(o);
        System.out.println(age.get(o));
        //使用反射得到私有的 name属性对象
        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"小黑");
        System.out.println(o);
        System.out.println(name.get(o));


    }

}


class Student {
    public int age;
    private static String name;

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + ",name= " + name +
                '}';
    }


}

