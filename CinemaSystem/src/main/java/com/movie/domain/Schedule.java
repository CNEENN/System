package main.java.com.movie.domain;

public class Schedule {

    /*==============================================================
    create table schedule(
        id int not null auto_increment,
        schedule_name varchar(50),
        studio_id int,
        movie_id int,
        schedule_time varchar(50),
        price float,
        status int,
        end_time varchar(50),
        primary key (id)
    );*/

    private int id;//场次ID
    private int studio_id;//放映厅ID
    private int movie_id;//放映影片ID
    private String time;//场次开始时间
    private float discount;
    private float price;//场次价格
    private int status;//是否满场（0不满，1满）
    private String schedule_name;//放映场次（早/午/晚间场）
    private int ticket_status;
    private String endtime;//结束时间

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getStudio_id() {
        return studio_id;
    }
    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public int getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getEndtime() {
        return endtime;
    }
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String date1) {
        this.time = date1;
    }

    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getSchedule_name() {
        return schedule_name;
    }
    public void setSchedule_name(String schedule_name) {
        this.schedule_name = schedule_name;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public Schedule() {
        super();
        // TODO Auto-generated constructor stub
    }
}
