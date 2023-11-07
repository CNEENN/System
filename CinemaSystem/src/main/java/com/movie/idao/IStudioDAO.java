package main.java.com.movie.idao;

import main.java.com.movie.domain.Studio;

import java.util.List;

public interface IStudioDAO {
    public int insert(Studio stu);
    public int update(Studio stu);
    public int delete(int ID);
    public List<Studio> select(String condt);
    public Studio findbyId(int id);
}
