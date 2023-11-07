package main.java.com.movie.idao;

import main.java.com.movie.domain.User;

import java.util.List;

public interface IUserDAO {
    public int insert(User user);
    public int insertDetail(User user);
    public int update(User user);
    public int updateDetail(User user);
    public int updatestatus(String status,int id);
    public int delete(int ID);
    public User select(User user);
    public User selectuser(int id);
    public User selectUserdetail(int id);
    public List<User> findAll();
}
