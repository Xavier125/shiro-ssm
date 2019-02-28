package vip.wefun.service;

import vip.wefun.pojo.User;


public interface UserService {
    User login(User user);

    User getUserByUsername(String username);
}
