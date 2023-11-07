package main.java.view.Administrator;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.sql.SQLException;
import java.util.Scanner;
public class AdminEmployee {
    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeService();
    Employee employee = new Employee();
    public void addEmployee() throws SQLException {//增加经理、前台信息
        System.out.println("请输入要增加的经理/前台ID(如：2002/3005)：");
        int id = scanner.nextInt();
        employee.setUser_id(id);
        System.out.println("请输入要增加的经理/前台的用户名(默认密码为123456)：");
        String name = scanner.next();
        employee.setEmp_name(name);
        System.out.println("请输入要增加的用户类型(经理/前台)：");
        String type = scanner.next();
        employee.setEmp_type(type);
        System.out.println("请输入要增加的用户手机号：");
        String tel_num = scanner.next();
        employee.setEmp_telNum(tel_num);
        System.out.println("请输入要增加的用户邮箱(不含空格)：");
        String address = scanner.next();
        employee.setAddress(address);
        employeeService.add(employee);
    }
     public void updateEmployee() throws SQLException {
         System.out.println("请输入要修改的用户的ID(如：2002/3005)：");
         int id = scanner.nextInt();
         employee.setUser_id(id);
         System.out.println("请输入修改后的用户类型(经理/前台)：");
         String type = scanner.next();
         employee.setEmp_type(type);
         System.out.println("请输入修改后的用户手机号：");
         String tel_num = scanner.next();
         employee.setEmp_telNum(tel_num);
         System.out.println("请输入修改后的用户邮箱(不含空格)：");
         String address = scanner.next();
         employee.setAddress(address);

         employeeService.update(employee);
     }
}
