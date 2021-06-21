<%@page language="java" contentType="text/html; charset=utf-8" import="java.sql.*" pageEncoding="utf-8" errorPage=""%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="INC.jsp" %>
<c:if test="${lst_cla==null}">
	<c:redirect url="StudentServlet?op=6"></c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息添加页面</title>
<!-- 引入富文本 -->
<script src="ckeditor/ckeditor.js"></script>
<!-- 控件替换 -->
<script type="text/javascript">
   window.onload=function(){
	   CKEDITOR.replace('description');
   }
</script>
</head>
<body>
<form  id="form1" name="form1" action="PicServletTest" method="post"  enctype="multipart/form-data">
		<table align="center" border="2px" width="700px" height="500px">
			<tr align="center">
				<td colspan="2">学生信息</td>
			</tr>
			<tr align="center">
				<td>姓名:</td>
				<td><input type="text" id="sname" name="sname"></td>
			</tr>
			<tr align="center">
				<td>性别:</td>
				<td><input type="radio" id="sex" name="sex" checked="checked" value="男">男
				<input type="radio" id="sex" name="sex"  value="女">女
				</td>
			</tr>
			<tr align="center">
				<td>所在地:</td>
				<td><input type="text" id="addrs" name="addrs"></td>
			</tr>
			<tr align="center">
				<td>生日:</td>
				<td><input type="date" id="birthday" name="birthday"  value="1997-01-01"></td>
			</tr>
			<tr align="center">
				<td>班级:</td>
				<td><select  id="classid" name="classid">
				<c:forEach items="${lst_cla}" var = "Clazz">
				<option  value="${Clazz.clazzid}">${Clazz.clazzname}</option> 
				</c:forEach>
				</select>
				</td>
			</tr>
		    <tr align="center">
		 		<td>描述:</td>
				<td><textarea rows="" cols="" name="description" id="description"></textarea>
                   </td>
			</tr>
			<tr align="center">
				<td align="center" colspan="2">
				     <input type="submit" />
					 <input type="hidden" id="op" name="op" value="1">
			</tr>
		</table>
	</form>
	<p align="center"><a href="StudentServlet?op=5">显示列表</a></p>
	
</body>
</html>