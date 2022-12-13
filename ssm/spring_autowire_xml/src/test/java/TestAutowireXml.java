import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import road.controller.UserController;

/**
 * 基于xml的自动装配
 * byType：根据类中需要的类型 和配置的bean中的类型 匹配
 *当配置的bean中有多个相同类型时，ioc不知道该使用哪一个了，就会使用默认的
 * byName：根据类中需要的类型 和配置的bean中的id 匹配
 *
 */
public class TestAutowireXml {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = classPathXmlApplicationContext.getBean(UserController.class);
        userController.mSave();

    }



}
