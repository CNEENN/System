package main.java.com.movie.idao;

import main.java.com.movie.domain.Employee;

import java.util.List;

public interface IEmployeeDAO {
    public int insert(Employee employee);
    public int update(Employee employee);
    public int delete(int user_id);
    public List<Employee> select(String condt);
    public int updateStatus(int Status,int id);
    public int updateSelf(Employee employee);
}
