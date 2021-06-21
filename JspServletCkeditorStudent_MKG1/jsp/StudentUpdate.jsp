<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="INC.jsp" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${lst_cla==null && oldst==null}">
	<c:redirect url="servlet/StudentServlet?op=6"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息修改页面</title>
<%-- <%
	//从session获取要修改的对象oldst
	Student oldst = (Student)session.getAttribute("oldst");
    IStudentBiz isb = new StudentBiz();
    //获取班级下拉列表中的班级信息
    List<Clazz> lst_class = isb.doinit();
%> --%>
</head>
<body>
<form id="form2" name="form2" action="PicServletTest" enctype="multipart/form-data" method="post">
  <table align="center" width="700px" border="2px">
			<tr align="center">
				<td colspan="3">学生信息修改</td>
			</tr>
			<tr align="center">
				<td>姓名:</td>
				<td>
				 <input type="text" id="sname" name="sname" value="${oldst.sname  }" >
				 <input type="hidden" id="sid" name="sid" value="${oldst.sid }">
				</td>
				<td rowspan="6">
                  <a href="upPic/${oldst.picname}">
                  <img src="upPic/${oldst.picname}" width="120" height="130" alt="图片未上传"></img>
                  </a>
                </td>
			</tr>
		    <tr align="center">
				<td>性别:</td>
				<td><input type="radio" readonly="readonly" id="sex" name="sex" value="${oldst.sex}" checked="checked">${oldst.sex }
				</td>
			</tr>
			<tr align="center">
				<td>所在地:</td>
				<td><input type="text" id="addrs" name="addrs" value="${oldst.addrs }"></td>
			</tr>
			<tr align="center">
				<td>生日:</td>
				<td><input type="date" id="birthday" name="birthday" value="${oldst.birthday }"></td>
			</tr>
			<tr align="center">
                <td>上传图片</td>
                <td>
                   <input  type="file" name="pic" id="pic"/></td>
            </tr>
			<tr align="center">
				<td>班级:</td>
				<td>
				   <select  id="classid" name="classid">
				      <c:forEach items="${lst_cla}" var="clazz">
      			         <option value="${clazz.clazzid}" 
      				         <c:if test="${clazz.clazzid==oldst.classid}">
      					     selected="selected"
      				         </c:if>
      			             >${clazz.clazzname}</option>
      		          </c:forEach>
				   </select>
				</td>
			</tr>
			<tr align="center">
				<td align="center" colspan="3">
				<input type="hidden" id="op" name="op" value="2">
				<input type="submit" value="确定修改"> 
				<input type="reset" value="重新填写"></td>
			</tr>
		</table>
</form>
</body>
</html>