package main.java.com.movie.service;

import main.java.com.movie.domain.Studio;
import main.java.com.movie.idao.DAOFactory;
import main.java.com.movie.idao.IStudioDAO;

import java.util.List;

public class StudioService {
    private IStudioDAO stuDAO=DAOFactory.creatStudioDAO();

    public int add(Studio stu){
        return stuDAO.insert(stu);
    }

    public int modify(Studio stu){
        return stuDAO.update(stu);
    }

    public int delete(int ID){
        return stuDAO.delete(ID);
    }

    public List<Studio> Fetch(String condt){
        return stuDAO.select(condt);
    }

    public List<Studio> FetchAll(){
        return stuDAO.select("");
    }

    public Studio FetchbyId(int id) {
        return stuDAO.findbyId(id);
    }
}
