package vip.wefun.mapper;

import org.apache.ibatis.annotations.*;
import vip.wefun.pojo.Menu;
import vip.wefun.pojo.User;

import java.util.List;

public interface UserMapper {
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "password_salt")
    })
    @Select("select *,0 pid from t_user where username=#{username} and password=#{password}")
    User selectByUser(User user);

    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "password_salt")
    })
    @Select("select * from t_user where username=#{username}")
    User selectByUsername(@Param("username") String userName);
}
