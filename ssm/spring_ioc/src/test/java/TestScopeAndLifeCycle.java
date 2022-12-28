import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import road.pojo.User;

public class TestScopeAndLifeCycle {


    /**
     * 测试 bean的作用域: scope=prototype 多例， 默认是scope=singleton
     */
    @Test
    public void test1() {
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = contextFactory.getBean("user", User.class);
        User user2 = contextFactory.getBean("user", User.class);
        System.out.println(user1.equals(user2)); //输出false ，说明多例情况下 输出的不是同一个对象

    }

    /**
     * 测试bean的生命周期：
     * 分四步：实例化，依赖注入，初始化，销毁
     * （单例情况下） 前三步 在获取ioc容器的时候 就执行了  ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
     * （多例情况下） 是在获取bean对象的时候 才执行依赖注入，初始化    User user1 = contextFactory.getBean("user1", User.class);
     */
    @Test
    public void test2() {
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = contextFactory.getBean("user1", User.class);
        System.out.println(user1);
        contextFactory.close();
    }


}
