package main.java.view.Manager;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.util.Scanner;
public class ManagerCustomer {
    Scanner scanner = new Scanner(System.in);
    User user = new User();
    UserService userService = new UserService();
    public void addCustomer() {
        User user = new User();
        System.out.println("请输入要增加的用户名：");
        String name = scanner.next();
        user.setName(name);
        System.out.println("密码默认123456");
        user.setPassword("123456");
        userService.add(user);
        System.out.println("完成添加");
    }

}
