package road.on.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import road.on.domain.SystemUser;

@Mapper
@Repository
public interface SystemUserMapper {
    SystemUser login(SystemUser user);
}
