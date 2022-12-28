package road.xml;

import org.springframework.stereotype.Component;


@Component
public class ValidateAspect {

    public void beforeMethod() {
        System.out.println("ValidateAspect-->前置通知");
    }

}
