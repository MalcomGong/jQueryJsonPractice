package com.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Clazz;
import com.bean.Student;
/**
 * 利用Java编写执行数据库sql语句代码
 * */
public class StudentBizDao implements IStudentBizDao {
   private ResultSet rs = null;//结果�?(ResultSet)是数据中查询结果返回的一种对象，可以说结果集是一个存储查询结果的对象
	@Override
	public int save(Student st) {
		String sql = "insert into student(sname,sex,addrs,birthday,picname,classid)values(?,?,?,?,?,?)";//?用于数�?�占�?
		System.out.println("运行sql添加语句");
		int rows =DBHelperDao.executeUpdate(sql, new Object []{
				 st.getSname(),
				 st.getSex(),
				 st.getAddrs(),
				 st.getBirthday(),
				 st.getPicname(),
				 st.getClassid()
		});
		System.out.println("后台添加数据成功");
		return rows;
	}

	@Override
	public int update(Student st) {
		String sql = "UPDATE student SET sname = ?, sex=?,addrs=?,birthday=?,picname=?,classid=? WHERE sid=? ";
		System.out.println("运行sql修改语句");
		int rows = DBHelperDao.executeUpdate(sql, new Object [] {
				st.getSname(),
				st.getSex(),
				st.getAddrs(),
				st.getBirthday(),
				st.getPicname(),
				st.getClassid(),
				st.getSid()
		});
		return rows;
	}

	@Override
	public int delById(int sid) {
		String sql = "DELETE FROM student WHERE sid = ?";
		int rows = DBHelperDao.executeUpdate(sql, new Object [] {sid});
		System.out.println("后台执行删除数据成功");
		return rows;
	}

	@Override
	public Student findById(int sid) {
		String sql = "SELECT student.* FROM student WHERE sid=?";
		rs = DBHelperDao.executeQuery(sql, new Object []{sid});
		Student st;
		System.out.println("运行sql查询单个语句");
		try {
			if(rs.next()){
				st = new Student(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7)
						);
				System.out.println("后台获取查询单个信息成功");
				return st;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("后台无法获取查询单个信息");
		return null;
	}

	@Override
	public List<Student> findAll() {
		//sql语句
		String sql = "SELECT student.*,clazz.clazzname FROM student,clazz WHERE student.classid = clazz.clazzid";
		 rs = DBHelperDao.executeQuery(sql, null);
		 List<Student> lsst = new ArrayList<Student>();
		 System.out.println("运行sql查询�?有语�?");
		 try {
			while (rs.next()) {
				Student st = new Student(//此顺序要与数据库列的顺序相同且数据类型一�?
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8)
						);
				lsst.add(st);
				System.out.println("后台获取查询�?有信息成�?");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsst;
	}

	@Override
	public List<Clazz> doinit() {
		//sql语句
		String sql = "select * from clazz";
		rs = DBHelperDao.executeQuery(sql, null);//.executeQuery(实现sql语句的sql对象, 参数)
		List<Clazz> lst_claz =new ArrayList<Clazz>();
		System.out.println("运行sql查询班级语句");
		try {
			//遍历集合
			while (rs.next()) {
				System.out.println("遍历clazz");
				Clazz claz = new Clazz(
						                rs.getInt("clazzid"),//.getInt(数据库中某张表的第几列或此列的字段名)
						                rs.getString("clazzname")
						                );
				System.out.println("遍历完成clazz");
				lst_claz.add(claz);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst_claz;
	}
	
	//验证是否可以获取下拉列表
	public static void main(String[] args) {
		StudentBizDao sbd = new StudentBizDao();
		sbd.doinit();
	}

	@Override
	public List<Student> findPageAll(int page, int rows) {
		String sql="SELECT s.*,c.clazzname FROM student s,clazz c WHERE s.classid=c.clazzid LIMIT "+(page-1)*rows+","+rows;
		rs = DBHelperDao.executeQuery(sql, null);
		List<Student> lsst=new ArrayList<Student>();
		try {
			while (rs.next()) {
				Student st = new Student(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8)
						);
				lsst.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsst;
	}

	@Override
	public int findMaxPage(int rows) {
		int maxrows=0;//总记录数
		int maxpage=0;//总页数
		String sql = "SELECT COUNT(*) FROM student";
		rs = DBHelperDao.executeQuery(sql, null);
		try {
			if (rs.next()) {
				maxrows = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (maxrows ==0) {
			maxpage = 1;//没有记录则默认为一页
		}else{
			maxpage = maxrows%rows ==0? maxrows/rows:maxrows/rows+1;
		}
		return maxpage;
	}

}
