package main.java.com.movie.service;

import main.java.com.movie.domain.Schedule;
import main.java.com.movie.idao.IScheduleDAO;
import main.java.com.movie.idao.DAOFactory;

import java.util.List;

public class ScheduleService {

    private IScheduleDAO scheduleDAO = DAOFactory.creatScheduleDAO();

    public int add(Schedule schedule) {
        return scheduleDAO.insert(schedule);
    }

    public int delete(Schedule schedule) {
        return scheduleDAO.delete(schedule.getId());
    }

    public int delete(String sql){
        return scheduleDAO.delete(sql);
    }

    public int modify(Schedule schedule) {
        return scheduleDAO.update(schedule);
    }

    public List<Schedule> Fetch(String condt){
        return scheduleDAO.select(condt);
    }

    public List<Schedule> findBy(String condt){
        return scheduleDAO.select(condt);
    }

    public List<Schedule> findAll() {
        return scheduleDAO.findAll();
    }
    public List<Schedule> findBySql(String sql){return scheduleDAO.findBySql(sql);}
}
