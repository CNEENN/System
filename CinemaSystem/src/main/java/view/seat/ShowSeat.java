package main.java.view.seat;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.util.List;
import java.util.Scanner;
public class ShowSeat {
    Scanner scanner = new Scanner(System.in);
    SeatService seatService = new SeatService();
    ScheduleService scheduleService = new ScheduleService();
    StudioService studioService = new StudioService();
    Seat seat = new Seat();

    public void showSeatTable(int schedule_id){
        //System.out.println("请输入要查询的场次ID(schedule_id):");
        //int schedule_id = scanner.nextInt();
        String sql = "select * from schedule where id = "+schedule_id ;
        scheduleService.findBySql(sql);
        System.out.println("请输入放映厅ID(studio_id)以查看座位信息:");
        int studio_id = scanner.nextInt();
        Studio studio = studioService.FetchbyId(studio_id);
        int row=studio.getRowCount();
        int col=studio.getColCount();
        List<Seat> seats = seatService.Fetch("studio_id = "+studio_id);
        String[][] seatTable = new String[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                seatTable[i][j] = "O";
            }
        }
        for(Seat seat: seats){
            int seat_row = seat.getRow()-1;
            int seat_col = seat.getColumn()-1;
            //System.out.println("更新座位表：");
            seatTable[seat_row][seat_col] = seat.getStatus()==0?"O":"X";
        }
        System.out.println("================================================");
        printSeatTable(seatTable);
        System.out.println("================================================");
    }

    void printSeatTable(String[][] seatTable) {
        // 打印表头
        System.out.format("%3s", "");
        for(int i=1; i<=seatTable[0].length; i++) {
            System.out.format("%3s", i);
        }
        System.out.println();
        // 打印各行
        for(int i=1; i<=seatTable.length; i++) {
            System.out.format("%3s", i);
            for(int j=0; j<seatTable[i-1].length; j++) {
                System.out.format("%3s", seatTable[i-1][j]);
            }
            System.out.println();
        }
    }
}
