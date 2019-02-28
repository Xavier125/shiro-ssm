package vip.wefun.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Set;

public interface PermissionMapper {
    @Select("select id from t_role_permission where role = #{0};")
    Set<String> selectPermissionByUserId(@Param("id") Integer id);
}
