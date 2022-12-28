package reflect.com.road;

import java.lang.reflect.Constructor;

/**
 * 通过反射创建对象实例
 */
public class ReflectCreateInstance {

    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class<?> userClass = Class.forName("reflect.com.road.User");
        //通过无参构造器 直接创建对象实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //有参构造器 需要先通过Class对象获取到public构造器对象，再用构造器对象创建实例
        Constructor<?> constructor = userClass.getConstructor(String.class);
        Object m = constructor.newInstance("com");
        System.out.println(m.getClass());
        //通过私有构造器创建实例
        //得到private的构造器对象
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);
        //爆破，因为私有构造器对象 我们不能用，但使用反射的 爆破后 我们就可以用了！
        declaredConstructor.setAccessible(true); //爆破
        Object instance = declaredConstructor.newInstance(10, "猫");
        System.out.println(instance);


    }

}


class User {
    private int age;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



