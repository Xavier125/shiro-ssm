package vip.wefun.mapper;

import vip.wefun.pojo.Role;

import java.util.List;

public interface RoleMaper {
    List<Role> selectRoleByUserId();
}
