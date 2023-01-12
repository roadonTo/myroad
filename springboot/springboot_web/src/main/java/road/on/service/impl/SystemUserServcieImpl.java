package road.on.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import road.on.domain.SystemUser;
import road.on.mapper.SystemUserMapper;
import road.on.service.SystemUserService;

@Service
public class SystemUserServcieImpl implements SystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public SystemUser login(SystemUser user) {
        SystemUser loginUser = systemUserMapper.login(user);
        return loginUser;
    }
}
