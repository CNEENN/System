package main.java.com.movie.service;

import main.java.com.movie.domain.SaleItem;
import main.java.com.movie.idao.DAOFactory;
import main.java.com.movie.idao.ISaleItemDAO;

import java.util.List;

public class SaleItemService {
    private ISaleItemDAO saleItemDAO=DAOFactory.creatSaleItemDAO();

    public int add(SaleItem saleItem){
        return saleItemDAO.insert(saleItem);
    }

    public int modify(SaleItem saleItem){
        return saleItemDAO.update(saleItem);
    }

    public int delete(int ID){
        return saleItemDAO.delete(ID);
    }

    public List<SaleItem> Fetch(String condt){
        return saleItemDAO.select(condt);
    }

    public List<SaleItem> FetchAll(){
        return saleItemDAO.select("");
    }
    public float CountTotalmoney() {
        List<SaleItem> count=FetchAll();
        float totalprice = 0;
        for(SaleItem s:count) {
            totalprice+=s.getPrice();
        }
        System.out.println(count.size());
        return totalprice;
    }
}
