package com.servlet;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.Student;
import com.biz.IStudentBiz;
import com.biz.StudentBiz;

/**
 * Servlet implementation class PicServlet
 */
@WebServlet("/PicServlet")
public class PicServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入PicServlet的doPost方法.....");
		response.setContentType("text/html;Charset=utf-8");
 		PrintWriter out=response.getWriter();
 		HttpSession session=request.getSession();
 		
 		IStudentBiz isb = new StudentBiz();
 		Student st = new Student();
 		
 		String op1 = null;
 		/***************************请求处理文件处理*************************/
 		//1.获取磁盘工厂对象
 		DiskFileItemFactory dfactory = new DiskFileItemFactory();
 		//2.获取上传的servlet对象
 		ServletFileUpload upload = new ServletFileUpload(dfactory);
 		//3.解析request请求，获取上传的选项对象
 		try {
			List<FileItem> lstItems = upload.parseRequest(request);
			//4.处理上传的数据
			if(lstItems!=null){
				//遍历请求选项
				for (FileItem fileItem : lstItems) {
					System.out.println("正在判断fileItem请求选项是表单元素还是文件......");
					//判断fileItem请求选项是表单元素还是文件
					if (fileItem.isFormField()) {//是表单元素
						System.out.println("是表单元素......");
						String fieldName = fileItem.getFieldName();
						//根据获取到的表单元素名称判断fileItem代表的是哪个选项
						if(fieldName.equals("sid")){
							//获取表单元素值
							String sid=fileItem.getString();
							st.setSid(Integer.parseInt(sid));
						}
						if(fieldName.equals("sname")){
							//获取表单元素值
							String sname=fileItem.getString("utf-8");
 							st.setSname(sname);
						}
						if(fieldName.equals("sex")){
 							//获取表单元素值
 							String sex=fileItem.getString("utf-8");
 							st.setSex(sex);
 						}
						if(fieldName.equals("birthday")){
 							//获取表单元素值
 							String birthday=fileItem.getString("utf-8");
 							st.setBirthday(birthday);
 						}
						if(fieldName.equals("addrs")){
 							//获取表单元素值
 							String addrs=fileItem.getString("utf-8");
 							st.setAddrs(addrs);
 						}
						if(fieldName.equals("classid")){
 							//获取表单元素值
 							String classid=fileItem.getString("utf-8");
 							st.setClassid(Integer.parseInt(classid));
 						}
						if(fieldName.equals("op")){
 							//获取表单元素值
 							 op1=fileItem.getString("utf-8");
 							System.out.println("pic:op="+op1);
 							session.setAttribute("op", op1);
 						}
					}else{//是文件域
						System.out.println("是文件......");
 						//获取上传的文件名称
						System.out.println("上传文件..........");
 						String picname=fileItem.getName();
 						System.out.println("原始文件名:"+picname);
 						//获取上传文件的后缀
 						if(picname.lastIndexOf(".")!=-1){
 							//获取后缀
 							String ext=picname.substring(picname.lastIndexOf("."));
 							//限制上传文件类型
 							if(ext!=null&&(ext.equalsIgnoreCase(".jpg"))){
 								//改文件名
 								picname=new Date().getTime()+ext;
 							}
 						}
 						System.out.println("修改后文件名:"+picname);
 						//获取服务器根路径
 						String realpath=getServletContext().getRealPath("/");
 						System.out.println("realpath:"+realpath);
 						//获取上传文件的字节数组
 						byte[] b=fileItem.get();
 						//创建输出流
 						FileOutputStream fos=new FileOutputStream(new File(realpath+"/upPic/"+picname));
 						fos.write(b);
 						fos.flush();
 						fos.close();
 						Student oldst=(Student)session.getAttribute("oldst");
 						if(oldst==null){
 						/**
 						 * 结合富文本文件上传的回调功能，回调图片路径，实现预览效果
 						 * **/
 						String imageContextPath1=realpath+"/upPic/"+picname;
 						String imageContextPath=imageContextPath1.replace("\\", "/");
 						System.out.println("原始路径:"+imageContextPath);
 						 //返回"图像信息"选项卡并显示图片
 						String callback = request.getParameter("CKEditorFuncNum");
 			            out = response.getWriter();
 			            out.println("<script type=\"text/javascript\">");
 			            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
 			            out.println("</script>");
 			            System.out.println("已返回图像信息选项卡并显示图片");
 			            out.flush();
 			    		out.close();
 						}
 						session.setAttribute("picname", picname);
 					}
				}
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		/*******请求处理文件处理end**********/
 		//判断有无文本数据，有则跳转
 		if(st.getSname()!=null&&!op1.equals("2")){
				st.setPicname((String)session.getAttribute("picname"));
				boolean flag=isb.save(st);
				if(flag){
					System.out.println("添加完成即将跳转到StudentServlet的op=5");
					response.sendRedirect(request.getContextPath()+"/StudentServletTest?op=5");
					return;
				}else{
					
					
				}
			}
 		//修改时
			if(st.getSname()!=null&&op1.equals("2")){
				st.setPicname((String)session.getAttribute("picname"));
				boolean flag=isb.update(st);
				if(flag){
					session.removeAttribute("oldst");
					System.out.println("修改完成准备跳转到StudentServlet的op=5");
					response.sendRedirect(request.getContextPath()+"/StudentServletTest?op=5");
					
					return;
				}else{
					
					
				}
			}
 		out.flush();
 		out.close();
	}

}
