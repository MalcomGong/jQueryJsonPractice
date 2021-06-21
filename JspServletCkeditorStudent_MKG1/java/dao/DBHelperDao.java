package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.util.JdbcUtil;
/**
 * JDBC的操作步�?

1.加载JDBC驱动�?

2.与数据库建立连接�?

3.创建Statement或PreparedStatement对象�?

4.发�?�SQL语句，并且得到返回结果；

5.处理返回结果�?

6.释放资源�? 

遍历结果集中数据可使用列号或者列名标识列�?
 * 
 * 在使用JDBC操作数据库时，常常调用PreparedStatement的对象使用setObject方法去遍历SQL语句传入的数据，

这时常常�?要一个一个的去判断数据的类型，导致代码量成�?�增加，而使用setObject可以自动识别SQL中的数据

类型，对大量数据量节约的时间是非常可观的�?

public static int executeUpdate(String sql,Object...params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {        
            //1.加载驱动
            //2.连接数据�?
            conn = JDBCUtil.getConn();
            //3.创建语句//st = conn.createStatement();
            ps = conn.prepareStatement(sql);
            //遍历参数
            for(int i=0;i<params.length;i++) {
                ps.setObject(i+1, params[i]);    
            }
            //4.执行语句//st.executeLargeUpdate(sql);
            return ps.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();            
        }finally {        
            JDBCUtil.close(conn, ps, null);
        }
        return 0;
    }

 * 
 * */
public class DBHelperDao {//通用dao�?
   //通用属�??
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	//通用增删改的方法(Int executeUpdate(String sql):可以执行插入、删除�?�更新等操作，返回�?�是执行该操作所影响的行�?)
	public static int executeUpdate(String sql,Object[] obj){
		//连接通道
		conn = JdbcUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			//判断是否有参�?
			if(obj!=null&&obj.length>0){
				for (int i = 0; i < obj.length; i++) {
					//遍历参数
					ps.setObject(i+1, obj[i]);
				}
			}
			int rows = ps.executeUpdate();
			if(rows>0){
				return rows;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally{
			//调用JDBC关闭通道方法
			DbConnection.colseAll(null, null, ps, conn);
		}*/
		return -1;
	}
	
	
	//通用查询的方�?(ResultSet executeQuery(String sql):执行SQL查询并且获取ResultSet对象)
	public static ResultSet executeQuery(String sql,Object [] obj){
		//连接通道
		conn=JdbcUtil.getConnection();
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//判断是否有参�?
		if(obj!=null&&obj.length>0){
			//遍历参数
			for (int i = 0; i < obj.length; i++) {
				try {
					ps.setObject(i+1, obj[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
}
