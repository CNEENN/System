package main.java.view.Manager;

import main.java.com.movie.domain.Movie;
import main.java.com.movie.service.MovieService;

import java.util.Scanner;

public class ManagerMovie {
    MovieService movieService = new MovieService();
    Scanner scanner = new Scanner(System.in);

    public void AddMovie(){//添加影片的信息
        Movie movie = new Movie();
        System.out.println("请输入要增加的片名：");
        String title = scanner.next();
        movie.setTitle(title);
        System.out.println("请输入要增加的影片的导演：");
        String director = scanner.next();
        movie.setDirector(director);
        System.out.println("请输入要增加的影片的主演：");
        String actor = scanner.next();
        movie.setActor(actor);
        System.out.println("请输入要增加的影片的剧情简介：");
        String synopsis = scanner.next();
        movie.setSynopsis(synopsis);
        System.out.println("请输入要增加的影片的时长（片长时间）：");
        int duration = scanner.nextInt();
        movie.setDuration(duration);
        movieService.add(movie);
    }

    public void updateMovie(){//修改电影的信息
        Movie movie = new Movie();
        System.out.println("请输入要修改的电影的ID：");
        int id = scanner.nextInt();
        movie.setId(id);
        System.out.println("请输入修改的片名：");
        String title = scanner.next();
        movie.setTitle(title);
        System.out.println("请输入修改的影片的导演：");
        String director = scanner.next();
        movie.setDirector(director);
        System.out.println("请输入修改的影片的主演：");
        String actor = scanner.next();
        movie.setActor(actor);
        System.out.println("请输入修改的影片的剧情简介：");
        String synopsis = scanner.next();
        movie.setSynopsis(synopsis);
        System.out.println("请输入修改的的影片的时长（片长时间）：");
        int duration = scanner.nextInt();
        movie.setDuration(duration);
        movieService.modify(movie);
    }

    public void findMovie(){//查询影片的信息
        Movie movie = new Movie();
        System.out.println("请输入查询条件的序号（1.片名  2.导演）：");
        int choice = scanner.nextInt();
        if(choice==1){
            System.out.println("请输入片名：");
            String title = scanner.next();
            movieService.findByTitle(title);
        }else if(choice==2){
            System.out.println("请输入导演名：");
            String director = scanner.next();
            movieService.findByDirector(director);
        }else{
            System.out.println("无效的选择!");
        }
    }
}
