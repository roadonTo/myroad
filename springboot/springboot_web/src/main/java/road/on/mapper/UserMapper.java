package road.on.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import road.on.domain.User;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<User> findAll();

}
