package main.java.com.movie.dao;

import main.java.com.movie.domain.Studio;
import main.java.com.movie.domain.Ticket;
import main.java.com.movie.idao.ITicketDAO;
import main.java.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class TicketDAO implements ITicketDAO{
    @Override
    public int insert(Ticket ticket) throws SQLException {  //新增电影票信息
        try{

            String sql = "insert into ticket(seat_id,movie_id,studio_id,schedule_id,ticket_price) " +
                    "VALUES ('"+ ticket.getSeatId()+"','"+ ticket.getMovieId()+"','"+ticket.getStudioId()+"','"
                    +ticket.getScheduleId()+"','"+ ticket.getPrice()+"')";
            DBUtil db = new DBUtil();
            System.out.println(sql);
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst!=null && rst.first()) {
                return 1;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean delete(int schedule_id) {//根据场次退票
        boolean rtu = false;
        String sql = "delete from  ticket ";
        sql += " where schedule_id = " + schedule_id;
        DBUtil db = new DBUtil();
        if(db.update(sql)>0) {
            rtu = true;
        }
        return rtu;
    }

    @Override
    public int update(Ticket ticket) {//根据票的ID更改票的信息
        try{
            String sql = "update ticket set " + " seat_id ='" + ticket.getSeatId()
                    + "', " + " movie_id = " + ticket.getMovieId() + ", "
                    + " studio_id = " + ticket.getStudioId() + ", "
                    + " schedule_id = '" + ticket.getScheduleId() + ", "
                    + "price = '" + ticket.getPrice() + "' ";

            sql += " where ticket_id = " + ticket.getId()+";";
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateStatus(Ticket ticket) { //更新票的状态：是否已取票
        String sql = "update ticket set " + " ticket_status ='" + ticket.getStatus()
                +"'";
        sql += " where ticket_id = '" + ticket.getId() +"'";
        System.out.println(sql);
        DBUtil db = new DBUtil();
        return db.update(sql);
    }


    public int selectBy(int seatid,int scheduleid,int studio) {//根据座位、场次、放映厅查询电影票ID
        String sql = "select ticket_id from ticket where "
                + "seat_id= '"+seatid+"' "
                + " and schedule_id= '"+scheduleid+"'"
                + " and studio_id= '"+studio+"'";
        System.out.println(sql);
        DBUtil db = new DBUtil();
        ResultSet rst = db.execQuery(sql);
        int ticket_id =0;
        try {
            if (rst!=null) {
                while(rst.next()){
                    ticket_id = rst.getInt("ticket_id");
                    System.out.println("票ID："+ticket_id);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ticket_id;
    }
    @Override
    public Ticket getTicketByID(int ticket_id) {
        String sql = "select * from ticket where ticket_id = '"+ ticket_id +"';";
        DBUtil db = new DBUtil();
        ResultSet rst = db.execQuery(sql);
        Ticket ticket = new Ticket();
        try {
            if (rst!=null) {
                while(rst.next()){
                    ticket.setId(rst.getInt("ticket_id"));
                    ticket.setSeatId(rst.getInt("seat_id"));
                    ticket.setMovieId(rst.getInt("movie_id"));
                    ticket.setStudioId(rst.getInt("studio_id"));
                    ticket.setScheduleId(rst.getInt("schedule_id"));
                    System.out.println("票ID："+ticket.getId()+"   座位ID："+ticket.getSeatId()
                            +"   电影ID："+ticket.getMovieId()+"   放映厅ID："+ticket.getStudioId()
                            +"   场次ID："+ticket.getScheduleId());
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public ArrayList<Ticket> getTicketByPage(int page) {
        return null;
    }

    @Override
    public ArrayList<Ticket> getTicketBySchedule(int schedule_id) {
        ArrayList<Ticket> list = new ArrayList<>();

        return list;
        }


    @Override
    public ArrayList<Ticket> getTicketByMovie(int movie_id) {
        return null;
    }

    @Override
    public ArrayList<Ticket> getAllTicket() {
        return null;
    }

    @Override
    public Ticket getTicketBySeat(int seat_id) {
        Ticket rtu = null;
        return null;
    }

    @Override
    public ArrayList<Ticket> getTicketBySchedule(int page, int schedule_id) {
        return null;
    }

    @Override
    public ArrayList<Ticket> getTicketByMovie(int page, int movie_id) {
        return null;
    }


}
