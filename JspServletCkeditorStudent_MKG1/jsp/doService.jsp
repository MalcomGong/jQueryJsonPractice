<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"   import="java.sql.*"%>
<%@ include file="INC.jsp"%>
<jsp:useBean id="st" class = "com.bean.Student" scope = "request"></jsp:useBean>
<jsp:setProperty property="*" name="st"/>

<%
	//获取各个页面关于操作传递的数据
	String op = request.getParameter("op");
%>

<jsp:forward page="/StudentServletTest">
  <jsp:param value="<%=op %>" name="op"/>
</jsp:forward>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>业务处理中转（学生管理系统）</title>

</head>
<body>
</body>
</html>
