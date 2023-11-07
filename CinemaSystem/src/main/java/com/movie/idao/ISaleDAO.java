package main.java.com.movie.idao;

import main.java.com.movie.domain.Sale;

import java.util.List;

public interface ISaleDAO {
    public int insert(Sale sale);
    public int update(Sale saleu);
    public int delete(int ID);
    public List<Sale> select(String condt);
    public List<Sale> selectAll();
}
