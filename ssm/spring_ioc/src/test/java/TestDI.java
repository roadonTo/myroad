import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import road.pojo.Student;

/**
 * 依赖注入：
 * setter注入，构造器注入，null值注入，
 * 为类类型、数组类型、list集合类型、map集合类型的属性赋值，
 * p命令空间形式赋值
 *
 */
public class TestDI {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student1", Student.class);
        System.out.println(bean);

    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student2", Student.class);
        System.out.println(bean);

    }

    @Test
    public void test3(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student3", Student.class);
        System.out.println(bean);

    }

    @Test
    public void test4(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student4", Student.class);
        System.out.println(bean);

    }

    @Test
    public void test5(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student5", Student.class);
        System.out.println(bean);

    }

    @Test
    public void test6(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student6", Student.class);
        System.out.println(bean);

    }

    @Test
    public void test7(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student7", Student.class);
        System.out.println(bean);

    }

    @Test
    public void test8(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student bean = contextFactory.getBean("student8", Student.class);
        System.out.println(bean);

    }

}
