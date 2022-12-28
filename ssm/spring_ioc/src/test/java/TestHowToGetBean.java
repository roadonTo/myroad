import com.sun.xml.internal.bind.v2.ContextFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import road.pojo.HelloWorld;
import road.pojo.Student;

/**
 * 1. 使用IOC容器创建对象
 * 2. 获取bean的三种方式：
 * 根据bean的唯一id获取(这种得到的是Object对象 需要强转类型)，
 * 根据对象类型获取（这种用的最多），
 * 根据对象id和对象类型获取
 */
public class TestHowToGetBean {

    /**
     * 根据ioc容器创建对象，
     * 根据bean的唯一id获取
     */
    @Test
    public void test1() {
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld hello = (HelloWorld) contextFactory.getBean("hello");
        hello.sayHello();

    }

    /**
     * 根据对象类型获取（这种用的最多）
     */
    @Test
    public void test2() {
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean(Student.class);
        System.out.println(bean);

    }

    /**
     * 根据对象id和对象类型获取
     */
    @Test
    public void test3() {
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student", Student.class);
        System.out.println(bean);

    }


}
