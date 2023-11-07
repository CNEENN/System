package main.java.view.Customer;

import main.java.com.movie.domain.*;
import main.java.com.movie.service.*;

import java.util.Scanner;
public class CustomerMovie {
    Scanner scanner = new Scanner(System.in);
    public void seeMovie(){//查看电影放映信息
        MovieService movieService = new MovieService();
        System.out.println("-----------------------所有上映电影------------------------------");
        movieService.findAll();
        System.out.println("===============================================================");
        System.out.println("输入以上某部电影的导演的名字，查看其所有上映电影：");
        String director = scanner.next();
        movieService.findByDirector(director);
        System.out.println("===============================================================");
    }

    public void seeMovieDetail(){
        System.out.println("请输入需要查看相关信息的电影ID：");
        int movie_id = scanner.nextInt();
        ScheduleService scheduleService = new ScheduleService();
        String condt = new String();
        condt = "movie_id like '%"+movie_id +"%'";
        System.out.println("-----------------------电影相关信息------------------------------");
        scheduleService.findBy(condt);
        System.out.println("===============================================================");
    }
}
