package main.java.view;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;
import main.java.view.*;
import main.java.view.Administrator.AdminMain;
import main.java.view.Customer.CustomerMain;
import main.java.view.Manager.ManagerMain;
import main.java.view.Saleman.SalemanMain;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException{
        Print print=new Print();
        UserLogin userLogin = new UserLogin();
        Scanner scanner = new Scanner(System.in);
        while(true){
            print.printUserSelect();//用户身份选择(1.管理员 2.经理 3.前台 4.顾客 5.退出)
            System.out.println("输入你的选择（输入相应数字）: ");
            int choice = scanner.nextInt();
            if(choice==1||choice==2||choice==3){
                userLogin.userlogin("employee");
                System.out.println("再次进行身份选择(1.管理员 2.经理 3.前台),输入对应数字：");
                int choice1 = scanner.nextInt();
                if(choice1==1){
                    AdminMain adminMain = new AdminMain();
                    adminMain.main();
                    break;
                }else if(choice1==2){
                    ManagerMain managerMain = new ManagerMain();
                    managerMain.main();
                    break;
                }else if(choice1==3){
                    SalemanMain salemanMain = new SalemanMain();
                    salemanMain.main();
                    break;
                }else{
                    System.out.println("无效的选择!");
                }

            }else if(choice==4){
                userLogin.userlogin("user");
                CustomerMain customerMain = new CustomerMain();
                customerMain.main();
                break;
            }else if(choice==5){//退出
                System.out.println("退出中...");
                break;
            }else{
                System.out.println("无效的选择!");
            }
        }
    }
}
