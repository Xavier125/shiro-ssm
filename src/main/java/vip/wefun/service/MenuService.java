package vip.wefun.service;

import vip.wefun.pojo.Menu;

import java.util.List;


public interface MenuService {
    List<Menu> show(Integer pid);
}
