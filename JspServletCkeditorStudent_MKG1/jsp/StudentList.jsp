<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="INC.jsp" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息页面</title>
<c:if test="${pic == null }">
  <c:redirect url = "StudentServletTest?op=5"></c:redirect>
</c:if>
<script>
   //更改每页记录数
   function changeRows(){
	   //获取文本框数据
	   var rows=document.form1.rows.value;
	   if(isNaN(rows)){
		   alert("请输入数字");
		   document.form1.rows.value=${pic.rows}; 
		   return;
	   }
	   window.location="StudentServletTest?op=5&rows="+rows;  
   }
   //跳转到指定页
   function changePage(){
	   //获取文本框数据
	   var page=document.form1.page.value;
	   if(isNaN(page)){
		   alert("请输入数字");
		   document.f1.page.value=${pic.page}; 
		   return;
	   }
	   window.location="StudentServletTest?op=5&page="+page; 
   }
</script>
</head>
<body>
		<table align="center" width="700px" border="2px">
			<tr align="center">
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>所在地</td>
				<td>出生年月</td>
				<td>班级</td>
				<td>图片</td>
				<td>功能</td>
			</tr>
			<c:forEach items="${pic.pageList}" var = "st">
			<tr align="center">
				<td>${st.sid}</td>
				<td>${st.sname}</td>
				<td>${st.sex}</td>
				<td>${st.addrs}</td>
				<td>${st.birthday}</td>
			    <td>${st.classname}</td>
			    <td>
                  <a href="upPic/${st.picname}">
                  <img src="upPic/${st.picname}" width="100" height="100" alt="图片未上传"></img>
                  </a>
                </td>
				<td>
				<a href="StudentServletTest?op=3&sid=${st.sid }">删除</a>
				<a href="StudentServletTest?op=4&sid=${st.sid }">修改</a> 
				</td>
			</tr>
			 </c:forEach>	
		</table>
		 <form id = "form1" name="form1" method="post" action="">
			 <table align="center" width="700px" border="2px">
			 <tr align="center" >
             <td>
               <c:if test="${pic.page>1}">
                <a href="StudentServletTest?op=5&page=1">
               </c:if> 首页</a></td>
        <td>
       <c:if test="${pic.page>1}">
       <a href="StudentServletTest?op=5&page=${pic.page-1}">
       </c:if>
           上一页</a></td>
        <td>
       <c:if test="${pic.page<pic.maxPage}">
       <a href="StudentServletTest?op=5&page=${pic.page+1}">
       </c:if>
           下一页</a></td>
        <td>
       <c:if test="${pic.page<pic.maxPage}">
       <a href="StudentServletTest?op=5&page=${pic.maxPage}">
       </c:if>
            尾页</a></td>
        <td>每页
         <input type="text" size="2" name="rows" id="rows" value="${pic.rows}" />  
            条记录
         <input type="button" name="changerows" id="changerows" value="确定" onclick="changeRows()" />   
            </td>
        <td>跳转
       <input type="text" size="2" name="page" id="page" value="${pic.page}" />  
             页
          <input type="button" name="changepage" id="changepage" value="确定" onclick="changePage()" />       
             </td>
        <td>${pic.page}/${pic.maxPage}</td>
         
     </tr>
     </form>
	   <tr align="center">
	        <td colspan="7"><p><a href="StudentAdd.jsp">继续添加</a></p></td>
		</tr>
	</table>
</body>
</html>