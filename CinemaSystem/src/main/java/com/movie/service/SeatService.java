package main.java.com.movie.service;

import main.java.com.movie.domain.Seat;
import main.java.com.movie.idao.DAOFactory;
import main.java.com.movie.idao.ISeatDAO;

import java.util.List;

public class SeatService {
    private ISeatDAO seatDAO= DAOFactory.creatSeatDAO();

    public int add(Seat seat) {
        return seatDAO.insert(seat);
    }

    public int modify(Seat seat) {
        return seatDAO.modifylist(seat);
    }

    public int delete(int seatID) {
        return seatDAO.delete(seatID);
    }
    public List<Seat> Fetch(String condt){
        return seatDAO.select(condt);
    }

    public List<Seat> FetchAll(){
        return seatDAO.select("");
    }

    public int update(Seat seat) {
        return seatDAO.update(seat);
    }
    public int deleteByStudio(int studioId) {
        return seatDAO.deleteByStudio(studioId);
    }
}
