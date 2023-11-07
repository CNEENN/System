package main.java.com.movie.domain;

public class Ticket {

	/*==============================================================
	create table ticket(
	   ticket_id bigint not null AUTO_INCREMENT,
	   seat_id  int,
	   movie_id int,
	   studio_id int,
	   schedule_id  int,
	   ticket_price float,
	   ticket_status smallint default '0' comment '0表示未售，1表示已售',
	   primary key (ticket_id)
	);

	==============================================================*/

    private int id;//票的ID编号
    private int seatId;//座位的id
    private int movieId;//电影ID
    private int studioId;//放映厅ID
    private int scheduleId;//场次ID
    private float price;//票价
    private int status;//是否已取票
    private String localtime;//出票时间
    //play 的类型
    //开始结束时间    ================  schedule
    //员工的ID

    //play 的name ============ 电影名称
    //影院信息



    public Ticket() {
        super();
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getStudioId() {
        return studioId;
    }
    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public int getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
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

}
