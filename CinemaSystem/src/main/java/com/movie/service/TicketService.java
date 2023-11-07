package main.java.com.movie.service;

import main.java.com.movie.domain.Ticket;
import main.java.com.movie.idao.ITicketDAO;
import main.java.com.movie.idao.DAOFactory;

import java.sql.SQLException;

public class TicketService {
    private ITicketDAO ticketDAO =DAOFactory.creatTicketDAO();

    public int add(Ticket ticket) throws SQLException {
        return ticketDAO.insert(ticket);
    }

    public boolean delete(int schedule_id) {
        return ticketDAO.delete(schedule_id);
    }

    public int  update(Ticket ticket) {
        return ticketDAO.update(ticket);
    }
    public int updateStatus(Ticket ticket) {return ticketDAO.updateStatus(ticket);}

    public int selectBy(int seatid,int scheduleid,int studio) {
        return ticketDAO.selectBy(seatid, scheduleid, studio);
    }
    public Ticket getTicketByID(int ticket_id) {
        return ticketDAO.getTicketByID(ticket_id);
    }
}
