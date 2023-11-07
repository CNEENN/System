package main.java.com.movie.domain;

public class Studio {//放映厅
    /*==============================================================
	create table studio(
	   studio_id int not null auto_increment,
	   studio_name varchar(200),
	   studio_row_count int,
	   studio_col_count int,
	   studio_introduction varchar(2000),
	   primary key (studio_id)
	);*/
    private int id=0;
    private String name="";
    private int rowCount=0;
    private int colCount=0;
    private String introduction="";
    private String image = null;

    public Studio()
    {

    }


    public void setID(int ID){
        this.id=ID;
    }
    public int getID(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setRowCount(int count){
        this.rowCount=count;
    }
    public int getRowCount(){
        return rowCount;
    }

    public void setColCount(int count){
        this.colCount=count;
    }
    public int getColCount(){
        return colCount;
    }

    public void setIntroduction(String intro){
        this.introduction=intro;
    }
    public String getIntroduction(){
        return introduction;
    }
}
