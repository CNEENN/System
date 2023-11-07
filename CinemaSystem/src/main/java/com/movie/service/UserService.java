package main.java.com.movie.service;

import main.java.com.movie.domain.User;
import main.java.com.movie.idao.*;

import java.util.List;

public class UserService {

    private IUserDAO userDAO = DAOFactory.creatUserDAO();


    public int add(User user) {
        return userDAO.insert(user);
    }
    public int adddetail(User user) {
        return userDAO.insertDetail(user);
    }

    public int delete(User user) {
        return userDAO.delete(user.getId());
    }

    public int modify(User user) {
        return userDAO.update(user);
    }
    public int modifydetail(User user) {
        return userDAO.updateDetail(user);
    }
    public int modifystatus(String status,int id) {
        return userDAO.updatestatus(status, id);
    }

    public User Find(User user) {
        return userDAO.select(user);
    }
    public User Finduser(int id) {
        return userDAO.selectuser(id);
    }
    public User FindUserdetaile(int id) {
        return userDAO.selectUserdetail(id);
    }

    public List<User> findAll(){return userDAO.findAll();}

}
