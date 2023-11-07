package main.java.com.movie.idao;

import main.java.com.movie.dao.*;
import main.java.com.movie.idao.*;

public class DAOFactory {
    public static IUserDAO creatUserDAO() {
        return new UserDAO();
    }
    public static IMovieDAO creatMovieDAO() {
        return new MovieDAO();
    }
    public static ITicketDAO creatTicketDAO() {
        return new TicketDAO();
    }
    public static IScheduleDAO creatScheduleDAO() {
        return new ScheduleDAO();
    }
    public static IStudioDAO creatStudioDAO() {
        return new StudioDAO();
    }
    public static ISeatDAO creatSeatDAO() {
        return new SeatDAO();
    }
    public static IEmployeeDAO creatEmployeeDAO() {
        return new EmployeeDAO();
    }
    public static ISaleDAO creatSaleDAO() {
        return new SaleDAO();
    }
    public static ISaleItemDAO creatSaleItemDAO() {
        return new SaleItemDAO();
    }
}
