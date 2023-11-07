package main.java.view.Customer;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.util.Scanner;
public class CustomerPassword {
    UserService userService = new UserService();
    Scanner scanner = new Scanner(System.in);
    public void changeSelf(){//重置密码
        User user = new User();
        System.out.println("请输入你的ID：");
        int id = scanner.nextInt();
        user.setId(id);
        System.out.println("请输入更改后的密码：");
        String pwd = scanner.next();
        user.setPassword(pwd);
        userService.modify(user);
        System.out.println("修改后的信息为：");
        userService.Finduser(id);
        System.out.println("======================================");
    }

}
