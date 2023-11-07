package main.java.com.movie.dao;

import main.java.com.movie.domain.SaleItem;
import main.java.com.movie.idao.ISaleItemDAO;
import main.java.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SaleItemDAO implements ISaleItemDAO {
    @Override
    public int insert(SaleItem saleitem) {
        try{
            String sql = "insert into sale_item(ticket_id, sale_ID, sale_item_price )"
                    + " values("
                    + saleitem.getId()
                    + ", "
                    + saleitem.getTicketId()
                    + ", " + saleitem.getSaleId()
                    + ", " + saleitem.getPrice()
                    + " )";
            DBUtil db = new DBUtil();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst!=null && rst.first()) {
                saleitem.setId(rst.getInt(1));
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(SaleItem saleitem) {
        try{
            String sql = "update sale_item set " + " sale_item_id =" + saleitem.getId()
                    + ", " + " ticket_id = " +  +saleitem.getTicketId() +", "
                    + " sale_ID = " + saleitem.getSaleId() + ", "
                    + " sale_item_price = " + saleitem.getPrice();
            sql += " where sale_item_id = " + saleitem.getId();
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int delete(int ID) {
        try{
            String sql = "delete from  sale_item ";
            sql += " where sale_item_id = " + ID;
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public List<SaleItem> select(String condt) {
        List<SaleItem> saleitemList = null;
        saleitemList=new LinkedList<SaleItem>();
        try {
            String sql = "select sale_item_id, ticket_id, Sale_ID, sale_item_price from sale_item ";
            condt.trim();
            if(!condt.isEmpty())
                sql+= " where " + condt;
            DBUtil db = new DBUtil();
            ResultSet rst = db.execQuery(sql);
            //System.out.print("sql:"+sql);
            if (rst!=null) {
                while(rst.next()){
                    SaleItem saleItem=new SaleItem();
                    saleItem.setId(rst.getInt("sale_item_id"));
                    saleItem.setTicketId(rst.getInt("ticket_id"));
                    saleItem.setSaleId(rst.getFloat("sale_ID"));
                    saleItem.setPrice(rst.getInt("sale_item_price"));
                    saleitemList.add(saleItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleitemList;
    }
}
