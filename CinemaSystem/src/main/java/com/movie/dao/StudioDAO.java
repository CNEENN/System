package main.java.com.movie.dao;

import main.java.com.movie.domain.Studio;
import main.java.com.movie.idao.IStudioDAO;
import main.java.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudioDAO implements IStudioDAO {
    @Override
    public int insert(Studio stu) {
        try {
            String sql = "insert into studio(studio_name, studio_row_count, studio_col_count, studio_introduction )"
                    + " values('"
                    + stu.getName()
                    + "', "
                    + stu.getRowCount()
                    + ", " + stu.getColCount()
                    + ", '" + stu.getIntroduction()
                    + "' );";
            DBUtil db = new DBUtil();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if (rst!=null && rst.first()) {
                stu.setID(rst.getInt(1));
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Studio stu) {//根据放映厅ID修改放映厅信息
        try{
            String sql = "update studio set " + " studio_name ='" + stu.getName()
                    + "', " + " studio_row_count = " + stu.getRowCount() + ", "
                    + " studio_col_count = " + stu.getColCount() + ", "
                    + " studio_introduction = '" + stu.getIntroduction() + "' ";
            sql += " where studio_id = " + stu.getID()+";";
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int delete(int ID) {//根据放映厅ID删除放映厅信息
        try{
            String sql = "delete from studio ";
            sql += " where studio_id = " + ID+";";
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public List<Studio> select(String condt) {//查询放映厅信息
        List<Studio> stuList = null;
        stuList=new LinkedList<Studio>();
        try {
            String sql = "select * from studio";
            condt.trim();
            if(!condt.isEmpty())
                sql+= " where " + condt+";";
            DBUtil db = new DBUtil();
            ResultSet rst = db.execQuery(sql);
            //System.out.print("sql:"+sql);
            if (rst!=null) {
                while(rst.next()){
                    Studio stu=new Studio();
                    stu.setID(rst.getInt("studio_id"));
                    stu.setName(rst.getString("studio_name"));
                    stu.setRowCount(rst.getInt("studio_row_count"));
                    stu.setColCount(rst.getInt("studio_col_count"));
                    stu.setIntroduction(rst.getString("studio_introduction"));
                    System.out.println("放映厅ID："+stu.getID()+"   放映厅名："+stu.getName()
                                    +"   放映厅排数："+stu.getRowCount()+"   放映厅列数："+stu.getColCount()
                                    +"   放映厅介绍："+stu.getIntroduction());
                    stuList.add(stu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stuList;
    }
    public Studio findbyId(int id) {//根据放映厅ID查询放映厅信息
        String sql = "select * from studio where studio_id = '"+ id +"';";
        DBUtil db = new DBUtil();
        ResultSet rst = db.execQuery(sql);
        Studio stu = null;
        stu = new Studio();
        try {
            if (rst!=null) {
                while(rst.next()){
                    stu.setID(rst.getInt("studio_id"));
                    stu.setName(rst.getString("studio_name"));
                    stu.setRowCount(rst.getInt("studio_row_count"));
                    stu.setColCount(rst.getInt("studio_col_count"));
                    stu.setIntroduction(rst.getString("studio_introduction"));
                    System.out.println("放映厅ID："+stu.getID()+"   放映厅名："+stu.getName()
                            +"   放映厅排数："+stu.getRowCount()+"   放映厅列数："+stu.getColCount()
                            +"   放映厅介绍："+stu.getIntroduction());
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stu;
    }
}
