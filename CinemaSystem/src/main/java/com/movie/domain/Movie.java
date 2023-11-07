package main.java.com.movie.domain;

public class Movie {
    /*==============================================================
	create table movie(
	   movie_id int not null auto_increment,
	   movie_title varchar(200),
	   movie_director varchar(200),
	   movie_actor varchar(200),
	   movie_synopsis varchar(2000),
	   movie_duration int(100),
	   primary key (movie_id)
	);*/

    private int id;
    private String title;//片名
    private String director;//导演
    private String actor;//主演
    private String synopsis;//剧情简介
    private int duration;//时长（片长时间）

    public Movie(){

    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirector() {
        return director;
    }

    public String getActor() {
        return actor;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
