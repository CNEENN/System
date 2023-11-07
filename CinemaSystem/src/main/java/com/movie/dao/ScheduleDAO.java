package main.java.com.movie.dao;

import main.java.com.movie.domain.Schedule;
import main.java.com.movie.idao.IScheduleDAO;
import main.java.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO implements IScheduleDAO{
    public int insert(Schedule schedule) {
        //DateChange change = new DateChange();
        //String time = schedule.getTime();
        //java.util.Date time1 =  change.strChangeToUtil(time);
        //Timestamp timesql = change.utilChangeToSql(time1);
        //String time2 = schedule.getEndtime();
        //java.util.Date time3 =  change.strChangeToUtil(time2);
        //Timestamp time4 = change.utilChangeToSql(time3);
        //	System.out.println(timesql);
        String sql = "insert into schedule(schedule_name,studio_id, movie_id,schedule_time,price)"
                + " values('"+schedule.getSchedule_name()+ "', '"+schedule.getStudio_id()+ "', '" + schedule.getMovie_id()+ "', '" + schedule.getTime()+ "','"+ schedule.getPrice() + "');";
        System.out.println(sql);
        DBUtil db = new DBUtil();
        int n = 0;
        try {
            n = db.execCommand(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (n > 0) {
            String sql2 = "select * from schedule where id = '"+ schedule.getId() +"';";
            ResultSet rs = db.execQuery(sql2);
            int schedule_id = -1;
            try {
                while (rs.next()) {
                    schedule_id = rs.getInt("id");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            schedule.setId(schedule_id);
            return 1;
        }
        int rst = db.update(sql);
        System.out.println(rst);
        if (rst != -1) {
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try{
            String sql = "delete from schedule ";
            sql += " where id = " + id+";";
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int delete(String sql) {
        try{
            System.out.println(sql);
            DBUtil db = new DBUtil();
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int update(Schedule schedule) {
        try{
            //DateChange change = new DateChange();
            //System.out.println(schedule.getTime());
            //String time = schedule.getTime();
            //java.util.Date time1 =  change.strChangeToUtil(time);
            //Timestamp timesql = change.utilChangeToSql(time1);
            //String time2 = schedule.getEndtime();
            //java.util.Date time3 =  change.strChangeToUtil(time2);
            //Timestamp time4 = change.utilChangeToSql(time3);
            String sql = "update schedule set " +  " schedule_name = '"+schedule.getSchedule_name()+"' , " + " studio_id = '"+schedule.getStudio_id()+"'," +
                    "movie_id= '"+schedule.getMovie_id()+"'," + "schedule_time = '"+schedule.getTime()+"'," + "price = '"+schedule.getPrice()+"',"+
                    "status='"+schedule.getStatus()+"'" ;
            sql += " where id = "+schedule.getId()+";";
            DBUtil db = new DBUtil();
            System.out.println(sql);
            return db.execCommand(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }


    @Override
    public Schedule select(int id) {
        String sql = "select * from schedule where id = '"+ id +"';";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        Schedule schedule = null;
        schedule = new Schedule();
        try {
            while(rs.next()) {
                schedule.setId(rs.getInt(1));
                schedule.setSchedule_name(rs.getString(2));
                schedule.setStudio_id(rs.getInt(3));
                schedule.setMovie_id(rs.getInt(4));
                schedule.setTime(rs.getString("schedule_time"));
                schedule.setPrice(rs.getFloat(6));
                schedule.setStatus(rs.getInt(7));
                schedule.setEndtime(rs.getString(8));
                System.out.println("场次ID： "+schedule.getId()+"   场次名："+schedule.getSchedule_name()
                        +"   放映厅ID："+schedule.getStudio_id()+"   电影ID："+schedule.getMovie_id()
                        +"   放映时间："+schedule.getTime()+"   价格："+schedule.getPrice()
                        +"   场次状态："+schedule.getStatus()+"   结束时间："+schedule.getEndtime()
                );
            }
        } catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        return schedule;
    }

//	@Override
//	public List<domain.Schedule> findByType(String status ) {
//		List<Schedule> list = null;
//		list = new ArrayList<Schedule>();
//		String sql = "select * from schedule where status like '%"+ status +"%'";
//		System.out.println(sql);
//		DBUtil util = new DBUtil();
//		ResultSet rs = util.execQuery(sql);
//
//		Schedule schedule = new Schedule();
//		try {
//			while(rs.next()) {
//				schedule.setId(rs.getInt(1));
//				schedule.setStudio_id(rs.getInt(2));
//				schedule.setPlay_id(rs.getInt(3));
//				schedule.setTime(rs.getDate(4));
//				schedule.setDiscount(rs.getInt(5));
//				schedule.setPrice(rs.getInt(6));
//				schedule.setStatus(rs.getInt(7));
//
//				list.add(schedule);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return list;
//	}

    @Override
    public List<Schedule> findAll() {
        List<Schedule> list = null;
        list = new ArrayList<Schedule>();
        String sql = "select * from schedule;";
        System.out.println(sql);
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        System.out.println("-----------------------所有场次信息------------------------------");
        try {
            while(rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt(1));
                schedule.setSchedule_name(rs.getString(2));
                schedule.setStudio_id(rs.getInt(3));
                schedule.setMovie_id(rs.getInt(4));
                schedule.setTime(rs.getString("schedule_time"));
                schedule.setPrice(rs.getFloat(6));
                schedule.setStatus(rs.getInt(7));
                schedule.setEndtime(rs.getString(8));
                System.out.println("场次ID： "+schedule.getId()+"   场次名："+schedule.getSchedule_name()
                                +"   放映厅ID："+schedule.getStudio_id()+"   电影ID："+schedule.getMovie_id()
                                +"   放映时间："+schedule.getTime()+"   价格："+schedule.getPrice()
                                +"   场次状态："+schedule.getStatus()+"   结束时间："+schedule.getEndtime()
                );
                list.add(schedule);
            }
            System.out.println("===============================================================");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Schedule> findBySql(String sql) {
        List<Schedule> list = null;
        list = new ArrayList<Schedule>();
        DBUtil util = new DBUtil();
        ResultSet rs = util.execQuery(sql);
        try{
             while(rs.next()) {
                  //while(rs.next()) {
                  Schedule schedule = new Schedule();
                  schedule.setId(rs.getInt(1));
                  schedule.setSchedule_name(rs.getString(2));
                  schedule.setStudio_id(rs.getInt(3));
                  schedule.setMovie_id(rs.getInt(4));
                  schedule.setTime(rs.getString("schedule_time"));
                  schedule.setPrice(rs.getFloat(6));
                  schedule.setStatus(rs.getInt(7));
                  schedule.setEndtime(rs.getString(8));
                  System.out.println("场次ID： "+schedule.getId()+"   场次名："+schedule.getSchedule_name()
                            +"   放映厅ID："+schedule.getStudio_id()+"   电影ID："+schedule.getMovie_id()
                            +"   放映时间："+schedule.getTime()+"   价格："+schedule.getPrice()
                            +"   场次状态（0未满 1已满）："+schedule.getStatus()+"   结束时间："+schedule.getEndtime()
                    );
                  System.out.println("================================");
                  list.add(schedule);
             }//while

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Schedule> select(String condt) {
        List<Schedule> list = null;
        list = new ArrayList<Schedule>();
        String sql = "select * from schedule ";
        condt.trim();
        if(!condt.isEmpty())
            sql+= " where "  + condt + ";";
        System.out.println(sql);
        DBUtil db = new DBUtil();
        ResultSet rs = db.execQuery(sql);
        System.out.println("-----------------------相关场次信息------------------------------");

        try {
            while(rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt(1));
                schedule.setSchedule_name(rs.getString(2));
                schedule.setStudio_id(rs.getInt(3));
                schedule.setMovie_id(rs.getInt(4));
                schedule.setTime(rs.getString("schedule_time"));
                schedule.setPrice(rs.getFloat(6));
                schedule.setStatus(rs.getInt(7));
                schedule.setEndtime(rs.getString(8));
                System.out.println("场次ID： "+schedule.getId()+"   场次名："+schedule.getSchedule_name()
                        +"   放映厅ID："+schedule.getStudio_id()+"   电影ID："+schedule.getMovie_id()
                        +"   放映时间："+schedule.getTime()+"   价格："+schedule.getPrice()
                        +"   场次状态(0未满，1已满)："+schedule.getStatus()+"   结束时间："+schedule.getEndtime()
                );
                list.add(schedule);
                //System.out.println("================================");
            }
            System.out.println("===============================================================");



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
