package main.java.view.Manager;

import main.java.com.movie.service.ScheduleService;
import main.java.com.movie.domain.Schedule;

import java.util.Scanner;
public class ManagerSchedule {
    Scanner scanner = new Scanner(System.in);
    ScheduleService scheduleService = new ScheduleService();
    public void addSchedule(){//增加场次
        Schedule schedule = new Schedule();
        System.out.println("请输入要增加的场次名称（如：早间场/午间场/晚间场）：");
        String name = scanner.next();
        schedule.setSchedule_name(name);
        System.out.println("请输入要增加的放映厅ID(如：001)：");
        int studio_id = scanner.nextInt();
        schedule.setStudio_id(studio_id);
        System.out.println("请输入要上映的影片ID(如：1)：");
        int movie_id = scanner.nextInt();
        schedule.setMovie_id(movie_id);
        System.out.println("请输入放映时间(如：二零二三年十月三十一日九点三十分):");
        String time = scanner.next();
        schedule.setTime(time);
        System.out.println("请输入价格(小数，如：39.9)：");
        float price = scanner.nextFloat();
        schedule.setPrice(price);

        scheduleService.add(schedule);
    }

    public void updateSchedule(){//修改场次信息
        Schedule schedule = new Schedule();
        System.out.println("请输入要修改的场次ID：");
        int id = scanner.nextInt();
        schedule.setId(id);
        System.out.println("请输入修改的场次名称（如：早间场/午间场/晚间场）：");
        String name = scanner.next();
        schedule.setSchedule_name(name);
        System.out.println("请输入修改的放映厅ID(如：1/2/3...)：");
        int studio_id = scanner.nextInt();
        schedule.setStudio_id(studio_id);
        System.out.println("请输入修改的影片ID(如：1)：");
        int movie_id = scanner.nextInt();
        schedule.setMovie_id(movie_id);
        System.out.println("请输入修改的放映时间(如：二零二三年十月三十一日九点三十分):");
        String time = scanner.next();
        schedule.setTime(time);
        System.out.println("请输入修改的价格(小数，如：39.9)：");
        float price = scanner.nextFloat();
        schedule.setPrice(price);
        scheduleService.modify(schedule);
    }



}
