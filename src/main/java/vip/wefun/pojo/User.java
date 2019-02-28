package vip.wefun.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private List<Menu> menuList;
}
