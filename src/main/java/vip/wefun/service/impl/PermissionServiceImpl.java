package vip.wefun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wefun.mapper.PermissionMapper;
import vip.wefun.service.PermissionService;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Set<String> getPermissionByUserId(Integer userId) {
        return permissionMapper.selectPermissionByUserId( userId );
    }
}
