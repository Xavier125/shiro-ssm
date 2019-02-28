package vip.wefun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vip.wefun.mapper.MenuMapper;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class SqlTest {
    @Resource
    private MenuMapper menuMapper;

    @Test
    public void selBlogListTest() {
//        System.out.println(menuMapper.selByPid(0));
    }
}
