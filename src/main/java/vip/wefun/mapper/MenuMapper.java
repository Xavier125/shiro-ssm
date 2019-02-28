package vip.wefun.mapper;

import org.apache.ibatis.annotations.*;
import vip.wefun.pojo.Menu;
import vip.wefun.pojo.User;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "pid", property = "pid"),
            @Result(property = "children", many = @Many(select = "selAllByPid"), column = "id"),
    })
    @Select("select * from t_menu where pid = #{0};")
    List<Menu> selAllByPid(Integer pid);
}
