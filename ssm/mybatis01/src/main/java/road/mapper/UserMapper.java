package road.mapper;

import road.pojo.User;

import java.util.List;

public interface UserMapper {

    int insertUser();

    User getUserById();

    List<User> getAllUser();

}
