package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Clazz;
import com.bean.Page;
import com.bean.Student;
import com.biz.IStudentBiz;
import com.biz.StudentBiz;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		IStudentBiz isb = new StudentBiz();
		// 获取客户端传递的数据
		String op = request.getParameter("op");
		switch (op) {
		case "1"://增加
			System.out.println("进入op=1");
			Student st = (Student) request.getAttribute("st");
			//标识符
			boolean flag = isb.save(st);
		    if(flag){
		    	 out.print("<script type ='text/javascript'>alert('添加成功！')</script>");
		    	//重定向至其他页面
				response.sendRedirect("StudentServletTest?op=5");
				return;
		    }else{
		    	out.print("<script type ='text/javascript'>alert('添加失败！')</script>");
		    }
			break;
		case "2"://修改
			System.out.println("进入op=2");
			st = (Student) request.getAttribute("st");
		    flag = isb.update(st);
		    if(flag){
			          response.sendRedirect("StudentServletTest?op=5");
			          return;
		            }else{
			               out.print("<script type='text/javascript'>alert('修改失败！')</script>");
		                   response.sendRedirect("BugTest.jsp");
		            }             
			break;
		case "3"://删除
			System.out.println("进入op=3");
			//获取要删除的编号(通过集合下标删除数据)
			String sid = request.getParameter("sid");
			flag = isb.delById(Integer.parseInt(sid));
			if(flag){
				response.sendRedirect("StudentServletTest?op=5");
				return;
			}else{
				out.print("<script  type ='text/javascript'>alert('删除失败！')</script>");
				response.sendRedirect("StudentList.jsp");
			}
			break;
		case "4"://查询单个
			System.out.println("进入op=4");
		    //通过下标查询
		    sid= request.getParameter("sid");
		    Student oldst = isb.findById(Integer.parseInt(sid));
		    //上传服务器保存
		    session.setAttribute("oldst", oldst);
		    //重定向至修改页面以供修改操作
		    response.sendRedirect("StudentUpdate.jsp");
			break; 
		case "5"://查询所有
			System.out.println("进入op=5");
			//从session获取分页对象
			Page pic = (Page) session.getAttribute("pic");
			pic = pic==null?new Page():pic;
			//从页面请求获取page rows
			String page = request.getParameter("page");
			String rows =request.getParameter("rows");
			//从servlet中来的请求
			page = page==null? pic.getPage()+"":page;
			rows = rows==null? pic.getRows()+"":rows;
			int int_page =Integer.parseInt(page);
			int int_rows = Integer.parseInt(rows);
			//限制数据
			if(int_page<1)int_page=1;
			if(int_rows<1)int_rows=8;
			//获取总页数
			int maxPage = isb.findMaxPage(int_rows);
			if(int_page>maxPage) int_page=maxPage;
			//获取当前页记录集合
			List<Student> lsst = isb.findPageAll(int_page, int_rows);
			//将分页数据存入pic对象
			pic.setPage(int_page);
			pic.setRows(int_rows);
			pic.setMaxPage(maxPage);
			pic.setPageList(lsst);
			//存入服务器
			session.setAttribute("pic", pic);
		    response.sendRedirect("StudentList.jsp");
			break;
		case "6":
			System.out.println("进入op=6");
			List<Clazz> lst_cla = isb.doinit();
			System.out.println("进入班级下拉列表获取方法");
			session.setAttribute("lst_cla", lst_cla);
			System.out.println("班级列表上传至服务器");
			response.sendRedirect("StudentAdd.jsp");
			System.out.println("转至StudentAdd.jsp页面");
			break;
		}
		
		out.flush();
		out.close();
	  }
	}




/*switch (op) {
case "1"://增加
	//标识符
	boolean flag = isb.save(st);
    if(flag){
    	 out.print("<script type ='text/javascript'>alert('添加成功！')</script>");
    	//重定向至其他页面
		response.sendRedirect("doService.jsp?op=5");
    }else{
    	out.print("<script type ='text/javascript'>alert('添加失败！')</script>");
    	
    }
	break;
case "2"://修改
flag = isb.update(st);
if(flag){
	out.print("<script type='text/javascript'>alert('修改成功！')</script>");
	response.sendRedirect("doService.jsp?op=5");
	return;
}else{
	out.print("<script type='text/javascript'>alert('修改失败！')</script>");
 response.sendRedirect("BugTest.jsp");
}
	break;
case "3"://删除
	//获取要删除的编号(通过集合下标删除数据)
	String sid = request.getParameter("sid");
	flag = isb.delById(Integer.parseInt(sid));
	if(flag){
		response.sendRedirect("doService.jsp?op=5");
		return;
	}else{
		out.print("<script  type ='text/javascript'>alert('删除失败！')</script>");
		response.sendRedirect("StudentList.jsp");
	}
	break;
case "4"://查询单个
//通过下标查询
sid= request.getParameter("sid");
Student oldst = isb.findById(Integer.parseInt(sid));
//上传服务器保存
session.setAttribute("oldst", oldst);
//重定向至修改页面以供修改操作
response.sendRedirect("StudentUpdate.jsp");
	break; 
case "5"://查询所有
	 lsst = isb.findAll();//StudentBiz的findAll()方法
session.setAttribute("lsst", lsst);
response.sendRedirect("StudentList.jsp");
	break;
}*/