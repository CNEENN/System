package main.java.view.Saleman;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;
import main.java.view.Print;
import main.java.view.seat.SeatManage;
import main.java.view.seat.ShowSeat;
import main.java.view.ticket.TicketManage;

import java.sql.SQLException;
import java.util.Scanner;
public class SalemanMain {
    public void main() throws SQLException{
        Print print=new Print();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            print.printSalemanFunction();
            System.out.print("输入你的选择: ");
            int choice = scanner.nextInt();
            if (choice == 1) {//列出所有影片信息
                MovieService movieService = new MovieService();
                movieService.findAll();

            }else if(choice==2){//列出所有场次信息
                ScheduleService scheduleService = new ScheduleService();
                scheduleService.findAll();

            }else if(choice==3){//列出指定电影和场次的信息
                MovieService movieService = new MovieService();
                ScheduleService scheduleService = new ScheduleService();
                ShowSeat showSeat = new ShowSeat();

                System.out.println("请输入指定电影的片名：");
                String movie_title = scanner.next();
                movieService.findByTitle(movie_title);
                System.out.println("输入指定电影的电影ID以查询相应场次：");
                int movie_id = scanner.nextInt();
                String condt = new String();
                condt = "movie_id like '%"+movie_id +"%'";
                scheduleService.findBy(condt);
                System.out.println("请输入要查询的场次ID以查看座位信息:");
                int schedule_id = scanner.nextInt();
                showSeat.showSeatTable(schedule_id);

            }else if(choice==4){//售票功能
                TicketManage ticketManage = new TicketManage();
                SeatManage seatManage = new SeatManage();
                ShowSeat showSeat = new ShowSeat();
                System.out.println("请输入要销售的场次ID：");
                int schedule_id = scanner.nextInt();
                showSeat.showSeatTable(schedule_id);
                System.out.println("进行售票操作的选座操作……");
                seatManage.addSeat();
                System.out.println("进行售票操作的添加电影票信息……");
                ticketManage.addTicket();

            }else if(choice==5){//退出
                System.out.println("退出中...");
                System.out.println();
                break;
            }else{
                System.out.println("无效的选择!");
            }
        }
    }


}
