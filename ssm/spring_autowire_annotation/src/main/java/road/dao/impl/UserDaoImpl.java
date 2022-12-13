package road.dao.impl;

import org.springframework.stereotype.Repository;
import road.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("保存成功");
    }
}
