package com.dao;

import java.util.List;

import com.bean.Clazz;
import com.bean.Student;

public interface IStudentBizDao {
  public int save(Student st);
  public int update(Student st);
  public int delById(int sid);
  public Student findById(int sid);
  public List<Student> findAll();
  
  //查询班级
  public List<Clazz> doinit();
  
  /**分页*/
  public List<Student> findPageAll(int page,int rows);
  /**总页数**/
  public int findMaxPage(int rows);
}
