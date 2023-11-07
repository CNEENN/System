package main.java.view.Customer;

import main.java.com.movie.domain.Ticket;
import main.java.com.movie.domain.User;
import main.java.com.movie.service.MovieService;
import main.java.com.movie.service.ScheduleService;
import main.java.com.movie.service.TicketService;
import main.java.com.movie.service.UserService;
import main.java.view.Print;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerMain {
    public void main() throws SQLException{
        Print print=new Print();
        Scanner scanner = new Scanner(System.in);

        while(true){
            print.printCustomerFunction();
            System.out.print("输入你的选择: ");
            int choice = scanner.nextInt();
            if(choice==1){//密码管理
                CustomerPassword customerPassword =new CustomerPassword();
                customerPassword.changeSelf();

            }else if(choice==2){//查看电影放映信息
                CustomerMovie customerMovie = new CustomerMovie();
                customerMovie.seeMovie();
                customerMovie.seeMovieDetail();

            }else if(choice==3){//购票
                CustomerTicket customerBuyTicket = new CustomerTicket();
                customerBuyTicket.chooseSeat();
                customerBuyTicket.addSelfTicket();

            }else if(choice==4){//取票
                TicketService ticketService = new TicketService();
                System.out.println("请输入要取票的票的ID：");
                int ticket_id = scanner.nextInt();
                Ticket ticket = new Ticket();
                ticket.setStatus(1);
                ticketService.getTicketByID(ticket_id);
                System.out.println("取票成功！");

            }else if(choice==5){//查看购票历史
                TicketService ticketService = new TicketService();
                MovieService movieService = new MovieService();
                ScheduleService scheduleService = new ScheduleService();
                System.out.println("请输入要查看的票的ID：");
                int ticket_id = scanner.nextInt();
                ticketService.getTicketByID(ticket_id);
                System.out.println("再输入查询到的场次ID查看信息：");
                int schedule_id = scanner.nextInt();
                String sql = "select * from schedule where id = "+schedule_id ;
                scheduleService.findBySql(sql);

            }else if(choice==6){//完善个人详细信息
                CustomerInfoManage customerInfoManage = new CustomerInfoManage();
                UserService userService = new UserService();
                customerInfoManage.addDetail();
                System.out.println("查看完善后的详细信息");
                System.out.println("请输入你的用户ID：");
                int id = scanner.nextInt();
                userService.FindUserdetaile(id);

            }else if(choice==7){//退出
                System.out.println("退出中...");
                System.out.println();
                break;
            }else{
                System.out.println("无效的选择!");
            }

        }
    }

}
