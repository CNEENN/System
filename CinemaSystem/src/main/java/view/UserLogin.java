package main.java.view;

import main.java.com.movie.domain.Employee;
import main.java.com.movie.domain.User;
import main.java.util.*;

import java.sql.*;
import java.util.Scanner;

public class UserLogin {
    public void userlogin(String usertype) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Print print=new Print();
        while(true){
            print.printLoginMenu();//打印登录菜单
            System.out.print("输入你的选择: ");//获取用户输入
            int choice = scanner.nextInt();

            if(choice == 1){//进行登录操作
                System.out.println("请输入用户名：");
                String username = scanner.next();
                System.out.println("请输入密码：");
                String password = scanner.next();
                login(usertype,username,password);
                boolean flag = new UserLogin().login(usertype,username,password);
                if(flag){ System.out.println("登录成功！（输入‘3’退出当前界面）"); }
                else{ System.out.println("登录失败！请重新登录！ "); }

            }else if(choice == 2){//进行注册操作
                System.out.println("请输入用户名：");
                String username = scanner.next();
                System.out.println("请输入密码：");
                String password = scanner.next();
                System.out.println("注册中……");
                //boolean flag = register(usertype,username,password);
                System.out.println("判断是否成功注册……");

                boolean flag = new UserLogin().register(usertype,username, password);
                while(!flag) {
                    System.out.println("注册失败，请重新输入用户名：");
                    username = scanner.next();
                    System.out.println("请输入你的密码：");
                    password = scanner.next();
                    flag = new UserLogin().register(usertype,username, password);
                }

                System.out.println("注册成功!");

            }else if(choice == 3){//退出操作
                System.out.println("退出中...");
                System.out.println("进入下一步操作……");
                break;
            }else{
                System.out.println("无效的选择!");
            }
        }
        //scanner.close();
    }

    //登录方法
    public static boolean login(String usertype,String username, String password) throws SQLException {
        if(username == null || password == null) {
            System.out.print("用户名和密码不能为空！");
            return false;
        }
        DBUtil db = new DBUtil();
        Connection conn;
        Statement stmt;
        ResultSet rs;
        try {
            conn = db.createConn();
            String sql = "select * from "+usertype+ " where user_name = '"+username
                    +"' and user_password = '"+password+"';";
            stmt = conn.createStatement();//获取执行sql对象
            rs=stmt.executeQuery(sql);//执行查询
            return rs.next(); //返回查询结果的下一行 查询到多少行
        }catch (SQLException e){
             e.printStackTrace();
        }finally {
             db.closeDB(db);//(?)
        }
        return false;
    }

    //注册方法
    public static boolean register(String usertype, String username, String password) throws SQLException {
        if (username == null || password == null) {
            System.out.println("用户名和密码不能为空！请重新输入！");
            return false;
        }
        DBUtil db = new DBUtil();
        Connection conn;
        PreparedStatement stmt; // 修改为 PreparedStatement
        ResultSet rs;
        try {
            conn = db.createConn();
            // 定义sql
            String sql1 = "select * from " + usertype + " where user_name=?";
            // 获取执行sql对象
            stmt = conn.prepareStatement(sql1); // 使用预编译语句
            stmt.setString(1, username); // 设置参数
            rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("用户名重复！");
                return false; // 因为查询到此账户，所以拒绝注册
            } else {
                // 定义sql
                String sql = "INSERT into " + usertype + "(user_name,user_password) " +
                        "value (?, ?)";
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // 指定返回生成的键
                stmt.setString(1, username); // 设置参数
                stmt.setString(2, password); // 设置参数
                stmt.executeUpdate(); // 执行插入语句
                ResultSet generatedKeys = stmt.getGeneratedKeys(); // 获取生成的键
                if (generatedKeys != null && generatedKeys.first()) {
                    if (usertype.equals("user")) {
                        User user = new User();
                        user.setId(generatedKeys.getInt(1));
                    } else {
                        Employee employee = new Employee();
                        int id = generatedKeys.getInt(1); // 获取生成的主键
                        employee.setUser_id(id);
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeDB(db);
        }
        return false;
    }

}
