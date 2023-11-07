package main.java.com.movie.idao;

import main.java.com.movie.domain.SaleItem;

import java.util.List;

public interface ISaleItemDAO {
    public int insert(SaleItem saleitem);
    public int update(SaleItem saleitem);
    public int delete(int ID);
    public List<SaleItem> select(String condt);
}
