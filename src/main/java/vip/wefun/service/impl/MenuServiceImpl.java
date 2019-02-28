package vip.wefun.service.impl;

import org.springframework.stereotype.Service;
import vip.wefun.mapper.MenuMapper;
import vip.wefun.pojo.Menu;
import vip.wefun.service.MenuService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> show(Integer pid) {
        return menuMapper.selAllByPid( pid );
    }
}
