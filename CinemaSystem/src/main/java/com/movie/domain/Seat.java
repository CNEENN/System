package main.java.com.movie.domain;

public class Seat {
    /*==============================================================
	create table seat(
	   seat_id int not null auto_increment,
	   studio_id int,
	   seat_row int,
	   seat_column int,
	   seat_status smallint comment '0表示位置为空，1表示位置已满’,
	   primary key (seat_id)
	);*/
    private int id;
    private int studioId;
    private int row;
    private int column;
    private int status;

    public Seat() {
        // TODO Auto-generated constructor stub
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getStudioId() {
        return studioId;
    }
    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
