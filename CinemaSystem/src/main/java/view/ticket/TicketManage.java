package main.java.view.ticket;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.sql.SQLException;
import java.util.Scanner;
public class TicketManage {
    Scanner scanner = new Scanner(System.in);
    TicketService ticketService = new TicketService();
    public void addTicket() throws SQLException {
        Ticket ticket = new Ticket();
        //System.out.println("请输入座位ID：");
        //int seat_id = scanner.nextInt();
        //ticket.setSeatId(seat_id);
        System.out.println("请输入电影ID：");
        int movie_id = scanner.nextInt();
        ticket.setMovieId(movie_id);
        System.out.println("请输入放映厅ID：");
        int studio_id = scanner.nextInt();
        ticket.setStudioId(studio_id);
        System.out.println("请输入场次ID：");
        int schedule_id = scanner.nextInt();
        ticket.setScheduleId(schedule_id);
        System.out.println("请输入票价：");
        float price = scanner.nextFloat();
        ticket.setPrice(price);

        ticketService.add(ticket);
        System.out.println("添加电影票成功！");
    }

    public void updateTicket(){
        Ticket ticket = new Ticket();
        System.out.println("请输入要更新的电影票ID：");
        int id = scanner.nextInt();
        ticket.setId(id);
        System.out.println("请输入更新后的座位ID：");
        int seat_id = scanner.nextInt();
        ticket.setSeatId(seat_id);
        System.out.println("请输入更新后的电影ID：");
        int movie_id = scanner.nextInt();
        ticket.setMovieId(movie_id);
        System.out.println("请输入更新后的放映厅ID：");
        int studio_id = scanner.nextInt();
        ticket.setStudioId(studio_id);
        System.out.println("请输入更新后的场次ID：");
        int schedule_id = scanner.nextInt();
        ticket.setScheduleId(schedule_id);
        System.out.println("请输入更新后的票价：");
        float price = scanner.nextFloat();
        ticket.setPrice(price);

        ticketService.update(ticket);
        System.out.println("更新电影票信息成功！");
    }

    public void seeTicketId(){//查看票的ID
        //int seatid,int scheduleid,int studio
        Ticket ticket = new Ticket();
        System.out.println("请输入座位ID：");
        int seat_id = scanner.nextInt();
        ticket.setSeatId(seat_id);
        System.out.println("请输入放映厅ID：");
        int studio_id = scanner.nextInt();
        ticket.setStudioId(studio_id);
        System.out.println("请输入场次ID：");
        int schedule_id = scanner.nextInt();
        ticket.setScheduleId(schedule_id);
        ticketService.selectBy(seat_id,schedule_id,studio_id);
    }

}
