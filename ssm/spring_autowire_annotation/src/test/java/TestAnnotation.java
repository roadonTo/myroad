import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import road.controller.UserController;

public class TestAnnotation {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = classPathXmlApplicationContext.getBean(UserController.class);
        userController.mSave();

    }




}
