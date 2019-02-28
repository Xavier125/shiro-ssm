package vip.wefun.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
	private int id;
	private String name;
	private int pid;
	private List<Menu> children;
}
