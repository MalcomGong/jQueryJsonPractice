package com.biz;

import java.util.List;

import com.bean.Clazz;
import com.bean.Student;
import com.dao.IStudentBizDao;
import com.dao.StudentBizDao;

public class StudentBiz implements IStudentBiz {
   private IStudentBizDao isbdao = new StudentBizDao();//只对本类有效
	@Override
	public boolean save(Student st) {
		if (st!=null) {
			int rows = isbdao.save(st);
			if(rows>0){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(Student st) {
		int rows = isbdao.update(st);
		if (rows>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delById(int sid) {
		int rows = isbdao.delById(sid);
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Student findById(int sid) {
		// TODO Auto-generated method stub
		return isbdao.findById(sid);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return isbdao.findAll();
	}

	@Override
	public List<Clazz> doinit() {
		// TODO Auto-generated method stub
		return isbdao.doinit();
	}

	@Override
	public List<Student> findPageAll(int page, int rows) {
		// TODO Auto-generated method stub
		return isbdao.findPageAll(page, rows);
	}

	@Override
	public int findMaxPage(int rows) {
		// TODO Auto-generated method stub
		return isbdao.findMaxPage(rows);
	}

}
