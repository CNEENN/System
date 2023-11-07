package main.java.view.seat;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.util.Scanner;
public class SeatView {
    Scanner scanner = new Scanner(System.in);
    SeatService seatService = new SeatService();
    public void addSeat(){
        Seat seat = new Seat();
        System.out.println("请输入放映厅id：");
        int studio_id = scanner.nextInt();
        seat.setStudioId(studio_id);
        System.out.println("请输入选择座位排数(7-15)：");
        int row = scanner.nextInt();
        seat.setRow(row);
        System.out.println("请输入选择座位列数(12-20)：");
        int col = scanner.nextInt();
        seat.setColumn(col);
        System.out.println("请改变座位状态(0无人 1有人)：");
        int status = scanner.nextInt();
        seat.setStatus(status);
        seatService.modify(seat);
        seatService.add(seat);
    }

    public void updateSeat(){
        Seat seat = new Seat();
        System.out.println("请输入当前的放映厅ID：");
        int id = scanner.nextInt();
        seat.setStudioId(id);
        System.out.println("请输入修改后的座位排数(7-15)：");
        int row = scanner.nextInt();
        seat.setRow(row);
        System.out.println("请输入修改后的座位列数(12-20)：");
        int col = scanner.nextInt();
        seat.setColumn(col);
        System.out.println("请改变座位状态(0无人 1有人)：");
        int status = scanner.nextInt();
        seat.setStatus(status);

        seatService.modify(seat);
        seatService.update(seat);
    }



}
