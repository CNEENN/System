package main.java.com.movie.idao;

import main.java.com.movie.domain.Schedule;
import java.util.List;
public interface IScheduleDAO {
    int insert(Schedule schedule);
    int update(Schedule schedule);
    int delete(int id);
    int delete(String sql);
    Schedule select(int id);
    List<Schedule> select(String condt);
    List<Schedule> findAll();
    List<Schedule> findBySql(String sql);
}
