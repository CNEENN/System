package main.java.com.movie.idao;

import main.java.com.movie.domain.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;
public interface ITicketDAO {
    /*
    private int id;
    private int seat_id;
    private int schedule_id;
    private int movie_id;
    private float price;
    private int status;
    private String localtime;
     */

    public int insert(Ticket ticket) throws SQLException;

    public boolean delete(int ticket_id);

    public int  update(Ticket ticket);

    int updateStatus(Ticket ticket);

    public int selectBy(int seatid, int scheduleid, int studio);
    public Ticket getTicketByID(int ticket_id);

    public Ticket getTicketBySeat(int seat_id);

    public ArrayList<Ticket> getTicketBySchedule(int page, int schedule_id);

    public ArrayList<Ticket> getTicketByMovie(int page, int movie_id);

    public ArrayList<Ticket> getTicketByPage(int page);

    public ArrayList<Ticket> getTicketBySchedule(int schedule_id);

    public ArrayList<Ticket> getTicketByMovie(int movie_id);

    public ArrayList<Ticket> getAllTicket();

}
