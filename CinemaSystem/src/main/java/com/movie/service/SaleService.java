package main.java.com.movie.service;

import main.java.com.movie.domain.Sale;
import main.java.com.movie.idao.DAOFactory;
import main.java.com.movie.idao.ISaleDAO;

import java.util.List;

public class SaleService {
    private ISaleDAO saleDAO=DAOFactory.creatSaleDAO();

    public int add(Sale sale){
        return saleDAO.insert(sale);
    }

    public int modify(Sale sale){
        return saleDAO.update(sale);
    }

    public int delete(int ID){
        return saleDAO.delete(ID);
    }

    public List<Sale> Fetch(String condt){
        return saleDAO.select(condt);
    }

    public List<Sale> FetchAll(){
        return saleDAO.select("");
    }

}
