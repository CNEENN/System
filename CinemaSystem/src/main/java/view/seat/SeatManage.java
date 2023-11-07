package main.java.view.seat;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.util.Scanner;
public class SeatManage {
    Scanner scanner = new Scanner(System.in);
    SeatService seatService = new SeatService();
    public void addSeat(){
        Seat seat = new Seat();
        System.out.println("请输入要选择的座位所在的放映厅ID：");
        int studio_id = scanner.nextInt();
        seat.setStudioId(studio_id);
        System.out.println("请输入要选择的座位所在的排数：");
        int row = scanner.nextInt();
        seat.setRow(row);
        System.out.println("请输入要选择的座位所在的列数：");
        int col = scanner.nextInt();
        seat.setColumn(col);
        System.out.println("请输入1以更改座位状态（1有人）");
        int status = scanner.nextInt();
        seat.setStatus(status);

        seatService.add(seat);
        System.out.println("选座成功！");
    }

    public void updateSeat(){

    }

}
