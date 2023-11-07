package main.java.com.movie.dao;

import main.java.com.movie.domain.Movie;
import main.java.com.movie.domain.User;
import main.java.com.movie.idao.IUserDAO;
import main.java.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    @Override
    public int insert(User user) { //新增顾客基本信息
        try {
            String sql = "insert into user(user_name, user_password)"
                    + " values('"
                    + user.getName()
                    + "', "
                    + " '"+ user.getPassword()
                    +"')";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst!=null && rst.first()) {
                user.setId(rst.getInt("user_id"));
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int insertDetail(User user) {//新增顾客详细信息
        try{
            String sql = "insert into userdetail(user_id,user_telNum,user_address,user_sex,user_age)"
                    + " values('"+user.getId()+"','"+ user.getUser_telNum()+"','"+user.getUser_address()
                    +"','"+user.getUser_sex()+"','"+user.getUser_age()+"'); ";
            //sql += "where user_id = "+user.getId()+";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int ID) {  //根据用户ID删除用户全部信息
        try{
            String sql = "delete from  user ";
            sql += " where user_id = " + ID;
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            String sql1 = "delete from  userdetail ";
            sql1 += " where user_id = " + ID;
            System.out.println(sql1);
            DBUtil db = new DBUtil();
            return db.execCommand(sql1);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int update(User user) {  //根据用户ID更改用户密码
        try{
            String sql = "update user set " + " user_password = '" + user.getPassword()
                    + "' ";
            sql += " where user_id = " + user.getId()+";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateDetail(User user) { //根据用户ID完善用户详细信息
        try{
            String sql = "update userdetail set " + " user_telNum ='" + user.getUser_telNum()
                    + "', " + " user_address = '" + user.getUser_address()
                    + "', " + " user_bankcarid = '" + user.getUser_bankcarid()
                    + "', " + " user_sex = '" + user.getUser_sex()
                    + "', " + " user_age = '" + user.getUser_age()
                    + "' ";
            sql += " where user_id = " + user.getId()+";";
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
    @Override
    public int updatestatus(String status,int id) {//根据用户ID更改用户状态
        try{
            String sql = "update user set " + " user_status ='" + status
                    + "' ";
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
    public User select(User user) {  //根据用户名查询基本信息
        String sql = "select * from user where user_name = '"+ user.getName() +"'";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        User user1 = new User();
        try {
            while(rs.next()) {
                user1.setId(rs.getInt("user_id"));
                user1.setName(rs.getString("user_name"));
                user1.setPassword(rs.getString("user_password"));
                user1.setStatus(rs.getString("user_status"));
                System.out.println("用户ID："+user1.getId()+ "   用户名："+user1.getName()+"   用户类型："+user1.getStatus());
            }} catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        return user1;
    }
    @Override
    public User selectuser(int id) {  //根据用户ID查询基本信息
        String sql = "select * from user where user_id = '"+ id +"';";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        User user1 = new User();
        try {
            while(rs.next()) {
                user1.setId(rs.getInt("user_id"));
                user1.setName(rs.getString("user_name"));
                user1.setPassword(rs.getString("user_password"));
                user1.setStatus(rs.getString("user_status"));
                System.out.println("用户ID："+user1.getId()+ "   用户名："+user1.getName()
                        + "   密码："+user1.getPassword()+"   用户类型："+user1.getStatus());
            }} catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        return user1;
    }
    @Override
    public User selectUserdetail(int id) { //根据用户ID查询详细信息
        String sql = "select * from userdetail where user_id = '"+ id +"'";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        User user1 = new User();
        try {
            while(rs.next()) {
                user1.setId(rs.getInt("user_id"));
                user1.setUser_telNum(rs.getString("user_telNum"));
                user1.setUser_address(rs.getString("user_address"));
                user1.setUser_sex(rs.getString("user_sex"));
                user1.setUser_age(rs.getInt("user_age"));
                System.out.println("用户ID："+user1.getId()+ "   手机号："+user1.getUser_telNum()
                        +"   邮箱："+user1.getUser_address()+"   性别："+user1.getUser_sex()
                        +"   年龄："+user1.getUser_age());
            }} catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        return user1;
    }

    public List<User> findAll() {//列出所有用户（消费者）详细信息
        List<User> list = new ArrayList<>();
        String sql = "select * from userdetail;";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        try {
            if(rs!=null) {
                while(rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("user_id"));
                    user.setUser_telNum(rs.getString("user_telNum"));
                    user.setUser_address(rs.getString("user_address"));
                    user.setUser_bankcarid(rs.getString("user_bankcarid"));
                    user.setUser_paypwd(rs.getString("user_paypwd"));
                    System.out.println("用户ID："+user.getId()+ "   用户手机号："+user.getUser_telNum()+"   用户邮箱："+user.getUser_address());
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        return list;
    }
}
