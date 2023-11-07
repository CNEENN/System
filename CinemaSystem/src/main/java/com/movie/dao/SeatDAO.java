package main.java.com.movie.dao;

import main.java.com.movie.domain.Seat;
import main.java.com.movie.idao.ISeatDAO;
import main.java.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SeatDAO implements ISeatDAO{
    @Override
    public int insert(Seat seat) {//选择要添加的座位
        try {
            String sql = "insert into seat(studio_id, seat_row, seat_column,seat_status)"
                    + " values('"
                    + seat.getStudioId()
                    + "', '" + seat.getRow()
                    + "', '" + seat.getColumn()
                    +"','"+ seat.getStatus()
                    + "' );";
            DBUtil db = new DBUtil();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst!=null && rst.first()) {
                seat.setId(rst.getInt(1));
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public int update(Seat seat) { //根据原来的放映厅ID修改座位信息
        try{
            String sql = "update seat set "+" seat_row = '" + seat.getRow() + "', "
                    + " seat_column = '" + seat.getColumn() + "', "
                    +"seat_status = '"+seat.getStatus()+"'";
            sql += " where studio_id = " + seat.getStudioId();
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int modifylist(Seat seat) {//根据已选择的座位所在的放映厅ID、排数、列数将位置状态改变（0无人，1有人）
        try{
            String sql = "update seat set " +"seat_status = '"+seat.getStatus()+"'";
            sql += " where seat_row = '" + seat.getRow() + "'" + " and seat_column = '"+seat.getColumn()+"'"+ " and studio_id='"+seat.getStudioId()+"'";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int seatID) {//根据座位ID删除座位信息
        try{
            String sql = "delete from  seat ";
            sql += " where seat_id = " + seatID+";";
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
    @Override
    public int deleteByStudio(int studioId) {//根据放映厅ID删除座位信息
        try{
            String sql = "delete from seat ";
            sql += " where studio_id = " + studioId+";";
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public List<Seat> select(String condt) {//查看座位信息
        List<Seat> seatList = null;
        seatList=new LinkedList<Seat>();
        try {
            String sql = "select * from seat ";
            condt.trim();
            if(!condt.isEmpty())
                sql+= " where " + condt +";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            ResultSet rst = db.execQuery(sql);
            /*System.out.print("sql:"+sql);*/
            if (rst!=null) {
                while(rst.next()){
                    Seat seat=new Seat();
                    seat.setId(rst.getInt("seat_id"));
                    seat.setStudioId(rst.getInt("studio_id"));
                    seat.setRow(rst.getInt("seat_row"));
                    seat.setColumn(rst.getInt("seat_column"));
                    seat.setStatus(rst.getInt("seat_status"));
                    System.out.println("座位ID： "+seat.getId()+"   放映厅ID："+seat.getStudioId()
                            +"   排数："+seat.getRow()+"   列数："+seat.getColumn()+"   座位状态："+seat.getStatus()
                    );
                    seatList.add(seat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatList;
    }


}
