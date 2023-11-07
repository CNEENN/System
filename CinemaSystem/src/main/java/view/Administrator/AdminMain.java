package main.java.view.Administrator;


import main.java.com.movie.domain.Employee;
import main.java.com.movie.service.EmployeeService;
import main.java.com.movie.service.UserService;
import main.java.util.*;
import main.java.view.Print;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminMain {

    public void main(){
        Scanner scanner = new Scanner(System.in);
        try{
            Print print=new Print();
            EmployeeService employeeService = new EmployeeService();
            AdminEmployee adminEmployee = new AdminEmployee();

            while(true){
                print.printUserManageByAdmin();
                System.out.print("输入你的选择: ");
                int choice = scanner.nextInt();

                if(choice==1){//列出管理员、经理、前台信息
                    employeeService.FetchALL();

                }else if(choice==2){//输入用户ID，删除影城方用户信息
                    System.out.println("请输入要删除的用户ID(如：2002/3005)：");
                    int id = scanner.nextInt();
                    employeeService.delete(id);
                    System.out.println("删除成功！");

                }else if(choice==3){//查询影城方用户信息
                    System.out.println("选择输入ID或用户名进行查询(如：user_id=**** 或 user_name='***' )：");
                    //System.out.println("或选择输入想要查看的用户类型进行查询(如：user_type='经理' 或 user_type='前台' )：");
                    String sc = scanner.next();
                    employeeService.Fetch(sc);

                }else if(choice==4){//增加影城方用户（经理、前台）信息
                    adminEmployee.addEmployee();

                }else if(choice==5){//修改影城方用户（经理、前台）信息
                    adminEmployee.updateEmployee();

                }else if(choice==6){//退出操作
                    System.out.println("退出中...");
                    System.out.println();
                    break;
                }else{
                    System.out.println("无效的选择!");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("数据库发生错误!");
        } finally {
            scanner.close();
        }
    }
}
