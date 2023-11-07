package main.java.com.movie.dao;

import main.java.com.movie.domain.Employee;
import main.java.com.movie.idao.IEmployeeDAO;
import main.java.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    @Override
    public int insert(Employee employee) {
        try{
            String sql = "insert into employee(user_id, emp_type, user_name, emp_telNum , address)"
                    + " values("+ employee.getUser_id()
                    + ", "
                    + "'" + employee.getEmp_type()
                    + "', "
                    +"'"  + employee.getEmp_name()
                    +"',"
                    + "'" + employee.getEmp_telNum()
                    + "',"
                    +"'" + employee.getAddress()
                    +"')";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int update(Employee employee) {
        try{
            String sql = "update employee set " + " emp_type = '" + employee.getEmp_type()+ "' "
                    + ", "
                    + " emp_telNum = '" + employee.getEmp_telNum() + "', "
                    + " address = '" + employee.getAddress() +"'"
                    ;
            sql += " where user_id = " + employee.getUser_id()+";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
    @Override
    public int updateStatus(int Status,int id) {
        try{
            String sql = "update employee set " + " status =" + Status;
            sql += " where user_id = " + id;
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateSelf(Employee employee) {
        try{
            String sql = "update employee set "
                    + " user_password = '" +employee.getUser_pwd()+"' "
                    ;
            sql += " where user_id = " + employee.getUser_id()+";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int delete(int id) {
        try{
            String sql = "delete from  employee ";
            sql += " where user_id = " + id;
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public List<Employee> select(String condt) {
        List<Employee> employeeList = null;
        employeeList=new LinkedList<Employee>();
        try {
            String sql = "select user_id,emp_type,user_name,emp_telNum,address from employee ";
            condt.trim();
            if(!condt.isEmpty())
                sql+= " where " + condt + ";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            ResultSet rst = db.execQuery(sql);
            if (rst!=null) {
                while(rst.next()){
                    Employee employee=new Employee();
                    employee.setUser_id(rst.getInt("user_id"));
                    employee.setEmp_type(rst.getString("emp_type"));
                    employee.setEmp_name(rst.getString("user_name"));
                    employee.setEmp_telNum(rst.getString("emp_telNum"));
                    employee.setAddress(rst.getString("address"));
                    employeeList.add(employee);
                    System.out.println("ID： "+employee.getUser_id()
                            +"   类型："+employee.getEmp_type()
                            +"   用户名："+employee.getEmp_name()
                            +"   手机号："+employee.getEmp_telNum()
                            +"   邮箱："+employee.getAddress()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

}
