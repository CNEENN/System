package main.java.view.Customer;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.util.Scanner;
public class CustomerInfoManage {
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();


    public void addCustomer() {
        User user = new User();
        System.out.println("请输入你的用户名：");
        String name = scanner.next();
        user.setName(name);
        System.out.println("请输入你的密码：");
        String password = scanner.next();
        user.setPassword(password);
        userService.add(user);
    }

    public void addDetail(){
        User user = new User();
        System.out.println("输入你的用户ID: ");
        int id = scanner.nextInt();
        System.out.println("当前你的基本信息为：");
        userService.Finduser(id);
        System.out.println("请完善你的详细信息");
        System.out.println("请输入你的用户id：");
        int user_id = scanner.nextInt();
        user.setId(user_id);
        System.out.println("请输入你的手机号：");
        String telNum = scanner.next();
        user.setUser_telNum(telNum);
        System.out.println("请输入你的邮箱地址：");
        String address = scanner.next();
        user.setUser_address(address);
        System.out.println("请输入你的性别：");
        String sex = scanner.next();
        user.setUser_sex(sex);
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();
        user.setUser_age(age);

        userService.adddetail(user);
    }




}
