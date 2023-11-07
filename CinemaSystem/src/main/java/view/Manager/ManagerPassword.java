package main.java.view.Manager;

import main.java.com.movie.domain.Employee;
import main.java.com.movie.domain.User;
import main.java.com.movie.service.EmployeeService;
import main.java.com.movie.service.UserService;

import java.util.Scanner;

public class ManagerPassword {
    EmployeeService manager = new EmployeeService();
    UserService customer = new UserService();
    Scanner scanner = new Scanner(System.in);
    public void changeSelf(){//修改自身密码
        Employee employee = new Employee();
        System.out.println("请输入要修改的用户的ID：");
        int id = scanner.nextInt();
        employee.setUser_id(id);
        System.out.println("请输入更改后的密码：");
        String pwd = scanner.next();
        employee.setUser_pwd(pwd);
        manager.updateSelf(employee);
    }

    public void changeCustomer(){//重置消费者的密码
        User user = new User();
        System.out.println("请输入要修改的用户的ID：");
        int id = scanner.nextInt();
        user.setId(id);
        System.out.println("请输入更改后的密码：");
        String pwd = scanner.next();
        user.setPassword(pwd);
        customer.modify(user);
    }


}
