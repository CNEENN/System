package main.java.com.movie.dao;

import main.java.com.movie.domain.Movie;
import main.java.com.movie.idao.IMovieDAO;
import main.java.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements IMovieDAO{
    @Override
    public int insert(Movie movie) {//插入新电影
        try {
            String sql = "insert into movie(movie_title,movie_director,movie_actor,movie_synopsis,movie_duration)"
                    + " values('"+movie.getTitle()+"','"+movie.getDirector()+"','"+movie.getActor()+"','"+movie.getSynopsis()+"','"+movie.getDuration()+"');";
            DBUtil db = new DBUtil();
            System.out.println(sql);
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst!=null && rst.first()) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {//根据电影ID删除电影
        try{
            String sql = "delete from movie ";
            sql += " where movie_id = " + id + ";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int update(Movie movie) {//更新与键入ID号相同的电影信息
        try{
            String sql = "update movie set "  + "movie_title = '"+movie.getTitle()+"'," + "movie_director='"+movie.getDirector()+"',"+
                    "movie_actor='"+movie.getActor()+"'," + "movie_synopsis='"+movie.getSynopsis()+"'," + "movie_duration='"+movie.getDuration()+"'" ;
            sql += " where movie_id = " + movie.getId()+ ";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public Movie select(String title) {//根据电影名查看相应电影
        String sql = "select * from movie where movie_title = '"+ title +"';";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        Movie movie = null;
        movie = new Movie();
        try {
            while(rs.next()) {
                movie.setId(rs.getInt("movie_id"));
                movie.setTitle(rs.getString("movie_title"));
                movie.setDirector(rs.getString("movie_director"));
                movie.setActor(rs.getString("movie_actor"));
                movie.setSynopsis(rs.getString("movie_synopsis"));
                movie.setDuration(rs.getInt("movie_duration"));
                System.out.println("电影ID： "+movie.getId()
                        +"   片名："+movie.getTitle()
                        +"   导演："+movie.getDirector()
                        +"   主演："+movie.getActor()
                        +"   片长："+movie.getDuration()
                );
                System.out.println("剧情简介："+movie.getSynopsis());
            }} catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        return movie;
    }


    @Override
    public List<Movie> findByDirector(String director) {//根据导演列举其所有电影
        List<Movie> list = null;
        list = new ArrayList<Movie>();
        String sql = "select * from movie where movie_director like '%"+director+"%';";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        try {
            if(rs!=null) {
                while(rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getInt("movie_id"));
                    movie.setTitle(rs.getString("movie_title"));
                    movie.setDirector(rs.getString("movie_director"));
                    movie.setActor(rs.getString("movie_actor"));
                    movie.setSynopsis(rs.getString("movie_synopsis"));
                    movie.setDuration(rs.getInt("movie_duration"));
                    System.out.println("电影ID： "+movie.getId()
                            +"   片名："+movie.getTitle()
                            +"   导演："+movie.getDirector()
                            +"   主演："+movie.getActor()
                            +"   片长："+movie.getDuration()
                    );
                    System.out.println("剧情简介："+movie.getSynopsis());
                    list.add(movie);
                }
            }
        } catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Movie> findAll() {//列举所有电影
        List<Movie> list = null;
        list = new ArrayList<Movie>();
        String sql = "select * from movie;";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        System.out.println("-----------------------所有上映电影------------------------------");
        try {
            if(rs!=null) {
                while(rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getInt("movie_id"));
                    movie.setTitle(rs.getString("movie_title"));
                    movie.setDirector(rs.getString("movie_director"));
                    movie.setActor(rs.getString("movie_actor"));
                    movie.setSynopsis(rs.getString("movie_synopsis"));
                    movie.setDuration(rs.getInt("movie_duration"));
                    System.out.println("电影ID： "+movie.getId()
                            +"   片名："+movie.getTitle()
                            +"   导演："+movie.getDirector()
                            +"   主演："+movie.getActor()
                            +"   片长："+movie.getDuration()
                    );
                    System.out.println("剧情简介："+movie.getSynopsis());
                    list.add(movie);
                }
                System.out.println("===============================================================");
            }
        } catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        return list;
    }

}
