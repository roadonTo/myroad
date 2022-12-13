import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import road.pojo.User;

public class TestFactoryBean {


    /**
     * 通过FactoryBean 来获取实体对象
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext contextFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = contextFactory.getBean("factoryBean", User.class);
        System.out.println(user1);


    }




}
