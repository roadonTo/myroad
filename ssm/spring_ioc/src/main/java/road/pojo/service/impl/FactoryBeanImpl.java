package road.pojo.service.impl;

import org.springframework.beans.factory.FactoryBean;
import road.pojo.User;

public class FactoryBeanImpl implements FactoryBean<User> {
    public User getObject() throws Exception {
        return new User();
    }

    public Class<?> getObjectType() {
        return User.class;
    }
}
