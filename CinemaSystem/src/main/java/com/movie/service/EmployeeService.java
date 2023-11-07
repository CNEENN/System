package main.java.com.movie.service;

import main.java.com.movie.domain.Employee;
import main.java.com.movie.idao.DAOFactory;
import main.java.com.movie.idao.IEmployeeDAO;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private IEmployeeDAO employeeDAO =DAOFactory.creatEmployeeDAO();

    public int add(Employee employee)throws SQLException {
        return employeeDAO.insert(employee);
    }

    public int delete(int id) throws SQLException{
        return employeeDAO.delete(id);
    }

    public int modify(Employee employee) {
        return employeeDAO.update(employee);
    }

    public List<Employee> Fetch(String condt) throws SQLException {
        return employeeDAO.select(condt);
    }

    public List<Employee> FetchALL() throws SQLException{
        return employeeDAO.select("");
    }

    public int update(Employee employee) throws SQLException{
        return employeeDAO.update(employee);
    }
    public int updateStatus(int status,int id) {
        return employeeDAO.updateStatus(status, id);
    }

    public int updateSelf(Employee employee) {
        return employeeDAO.updateSelf(employee);
    }
}
