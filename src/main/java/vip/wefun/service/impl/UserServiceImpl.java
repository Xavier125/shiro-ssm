package vip.wefun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wefun.mapper.UserMapper;
import vip.wefun.pojo.User;
import vip.wefun.service.MenuService;
import vip.wefun.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private MenuService menuServiceImpl;

    @Override
    public User login(User user) {
        User u = userMapper.selectByUser( user );
        if (u != null) {
            user.setMenuList( menuServiceImpl.show( user.getId() ) );
        }
        return u;
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername( username );
    }


}
