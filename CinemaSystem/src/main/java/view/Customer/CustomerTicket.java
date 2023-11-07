package main.java.view.Customer;

import main.java.com.movie.domain.Ticket;
import main.java.com.movie.service.TicketService;
import main.java.view.seat.*;
import main.java.view.ticket.*;

import java.sql.SQLException;
import java.util.Scanner;
public class CustomerTicket {
    Scanner scanner = new Scanner(System.in);
    SeatManage seatManage = new SeatManage();
    TicketManage ticketManage = new TicketManage();
    TicketService ticketService = new TicketService();
    public void chooseSeat(){
        System.out.println("请输入你想购买的场次ID：");
        int schedule_id = scanner.nextInt();
        ShowSeat showSeat = new ShowSeat();
        showSeat.showSeatTable(schedule_id);//打印座位表
        System.out.println("进行座位选择……");
        seatManage.addSeat();
        System.out.println("打印更新后的座位表……");
        showSeat.showSeatTable(schedule_id);
        System.out.println("================================================");

    }

    public void addSelfTicket() throws SQLException {//选座后添加电影票的信息完成购票操作
        System.out.println("添加你的电影票信息……");
        ticketManage.addTicket();
        Ticket ticket = new Ticket();
        ticket.setStatus(1);
        ticketService.updateStatus(ticket);
        System.out.println("查看购买的票的ID……");
        ticketManage.seeTicketId();
        System.out.println();
        System.out.println("购票成功！");
    }




}
