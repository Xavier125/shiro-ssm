package vip.wefun.service;

import java.util.Set;

public interface PermissionService {
    Set<String> getPermissionByUserId(Integer userId);
}
