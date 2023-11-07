package main.java.view.Manager;

import main.java.com.movie.domain.Movie;
import main.java.com.movie.domain.Schedule;
import main.java.com.movie.domain.Studio;
import main.java.com.movie.domain.User;
import main.java.com.movie.service.*;
import main.java.view.Print;

import java.sql.SQLException;
import java.util.Scanner;

public class ManagerMain {
    public void main() throws SQLException{
        Print print=new Print();
        Scanner scanner = new Scanner(System.in);

        while(true){
            print.printManagerFunction();//打印经理功能菜单
            System.out.print("输入你的选择:（输入相应数字） ");
            int choice = scanner.nextInt();

            if(choice==1){//密码管理
                while(true){
                    print.printPwdManage();//打印密码管理菜单
                    ManagerPassword changePwd = new ManagerPassword();
                    System.out.print("输入选择: （输入相应数字）");
                    int choose = scanner.nextInt();
                    if(choose == 1){//修改自身密码
                        changePwd.changeSelf();
                    }else if(choose == 2){//重置消费者的密码
                        changePwd.changeCustomer();
                    }else if(choose == 3){//退出操作
                        System.out.println("退出中...");
                        break;
                    }else{
                        System.out.println("无效的选择!");
                    }
                }

            }else if(choice==2){//影片管理
                while(true){
                    print.printMovieManage();//打印影片管理菜单
                    ManagerMovie managerMovie = new ManagerMovie();
                    MovieService movieService = new MovieService();
                    System.out.print("输入选择: （输入相应数字）");
                    int choose = scanner.nextInt();
                    if(choose==1){//列出所有正在上映影片的信息
                        movieService.findAll();
                    }else if(choose==2){//添加影片的信息
                        managerMovie.AddMovie();
                    }else if(choose==3){//修改电影的信息
                        managerMovie.updateMovie();
                    }else if(choose==4){//删除影片的信息
                        System.out.println("请输入要删除的影片ID（如：1、2、……）：");
                        int id = scanner.nextInt();
                        Movie movie = new Movie();
                        movie.setId(id);
                        movieService.delete(movie);
                    }else if(choose==5){//查询影片的信息
                        managerMovie.findMovie();
                    }else if(choose==6){//退出操作
                        System.out.println("退出中...");
                        break;
                    }else{
                        System.out.println("无效的选择!");
                    }
                }

            }else if(choice==3){//放映厅管理
                while(true){
                    print.printStudioManage();
                    ManageStudio manageStudio = new ManageStudio();
                    StudioService studioService = new StudioService();
                    System.out.print("输入选择: （输入相应数字）");
                    int choose = scanner.nextInt();
                    if(choose==1){//增加放映厅
                        manageStudio.addStudio();
                    }else if(choose==2){//修改放映厅
                        manageStudio.updateStudio();
                    }else if(choose==3){//删除放映厅
                        System.out.println("输入要删除的放映厅ID:（如：1、2、……） ");
                        int id =scanner.nextInt();
                        studioService.delete(id);
                    }else if(choose==4){//列出所有放映厅信息
                        studioService.FetchAll();
                    }else if(choose==5){//退出操作
                        System.out.println("退出中...");
                        break;
                    }else{
                        System.out.println("无效的选择!");
                    }
                }

            }else if(choice==4){//排片管理
                while(true){
                    print.printScheduleManage();
                    ManagerSchedule managerSchedule = new ManagerSchedule();
                    ScheduleService scheduleService = new ScheduleService();
                    System.out.print("输入选择: （输入相应数字）");
                    int choose = scanner.nextInt();
                    if(choose==1){//增加场次
                        managerSchedule.addSchedule();
                    }else if(choose==2){//修改场次
                        managerSchedule.updateSchedule();
                    }else if(choose==3){//删除场次
                        System.out.println("输入要删除的场次ID:（如：1、2、……） ");
                        int id =scanner.nextInt();
                        Schedule schedule = new Schedule();
                        schedule.setId(id);
                        scheduleService.delete(schedule);
                    }else if(choose==4){//列出所有场次信息
                        scheduleService.findAll();
                    }else if(choose==5){//退出操作
                        System.out.println("退出中...");
                        break;
                    }else{
                        System.out.println("无效的选择!");
                    }
                }
            }else if(choice==5){//用户（消费者）管理
                while(true){
                    ManagerCustomer customer = new ManagerCustomer();
                    UserService userService = new UserService();
                    ManagerCustomer managerCustomer = new ManagerCustomer();

                    print.printUserManageByManager();
                    System.out.print("输入选择:（输入相应数字） ");
                    int choose = scanner.nextInt();
                    if(choose==1){//列出所有消费者信息
                        userService.findAll();
                    }else if(choose==2){//查询用户信息
                        System.out.println("输入要查询的用户ID: ");
                        int id = scanner.nextInt();
                        userService.Finduser(id);
                        userService.FindUserdetaile(id);
                    }else if(choose==3){//增加用户基本信息
                        managerCustomer.addCustomer();
                    }else if(choose==4){//删除用户信息
                        System.out.println("输入要删除的用户ID: ");
                        int id = scanner.nextInt();
                        User user = new User();
                        user.setId(id);
                        userService.delete(user);
                    }else if(choose==5){//退出操作
                        System.out.println("退出中...");
                        break;
                    }else{
                        System.out.println("无效的选择!");
                    }
                }

            } else if (choice == 6) {//退出操作
                System.out.println("退出中...");
                System.out.println();
                break;

            } else {
                System.out.println("无效的选择!");
            }


        }

    }
}
