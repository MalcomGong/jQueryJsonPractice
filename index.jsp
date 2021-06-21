<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>FamousList</title>
<script src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
   //json对象
   var json = {"sid":"1","sname":"Jack","sex":"Female","job":"Programmer"}
   //json数组
   var json1 = [
                    {"sid":"1","sname":"Jack","sex":"Female","job":"Programmer"},
                    {"sid":"2","sname":"Tim","sex":"Male","job":"Farmer"},
                    {"sid":"3","sname":"Bob","sex":"Male","job":"Student"},
                    {"sid":"4","sname":"Jimmy","sex":"Female","job":"Actor"},
                    {"sid":"5","sname":"Odin","sex":"Male","job":"God of All"},
                    {"sid":"6","sname":"Hela","sex":"Female","job":"Goddess of Death"},
                    {"sid":"7","sname":"Thonos","sex":"Male","job":"Infinity Stones Holder"},
                    {"sid":"8","sname":"Dr.Manhattan","sex":"Male","job":"God of Human"},
                    {"sid":"9","sname":"Brray Alen","sex":"Male","job":"Flash"},
                    {"sid":"10","sname":"Author","sex":"Male","job":"AquaMan"},
                    {"sid":"11","sname":"Diana","sex":"Female","job":"WonderWoman"},
                    {"sid":"12","sname":"Clark Kent","sex":"Male","job":"SuperMan"},
                    {"sid":"13","sname":"Strange","sex":"Male","job":"Dr.Strange"},
                    {"sid":"14","sname":"Bruce Wayne","sex":"Male","job":"BatMan"},
                    {"sid":"15","sname":"Tonny","sex":"Male","job":"IronMan"},
                    {"sid":"16","sname":"Steve Rogers","sex":"Male","job":"Captain Ameria"},
                    {"sid":"17","sname":"Pitter Parker","sex":"Male","job":"SpaderMan"},
                    {"sid":"18","sname":"Bruce Banna","sex":"Male","job":"Hulk"},
                    {"sid":"19","sname":"Natasha Romanoff","sex":"Female","job":"Black Widow"},
                    {"sid":"20","sname":"Vison","sex":"Male","job":"A.I."},
                    {"sid":"21","sname":"Wanda","sex":"Female","job":"Witch"},
                    {"sid":"22","sname":"Thor","sex":"Male","job":"God of Thunder"},
                    {"sid":"23","sname":"Loki","sex":"Male","job":"God of Lies"},
                ]
   
     $(function(){
    	
    	 $("#bt").click(function(){
        	 alert(json.sid+" "+json.sname+" "+json.sex+" "+json.job+" ");
         });
    	$("#bt1").click(function(){
    		/* var tableHeader = "<table width='1000' border='2' align='center'>"+"<tr align='center'>"+"<td>ID</td>"+"<td>Name</td>"+"<td>Sex</td>"+"<td>Job</td>"+"</tr>";
    		var tableBody ="";
    		for (var i = 0; i < json1.length; i++) {
    			var json = json1[i];
				tableBody += "<tr align='center'>"+"<td>"+json.sid+"</td>"+"<td>"+json.sname+"</td>"+"<td>"+json.sex+"</td>"+"<td>"+json.job+"</td>"+"</tr>";
			}
    		var tableEnd = tableHeader+tableBody+"</table>";
    		$("#dd").html(tableEnd);  */
    		
    		var tableHeader = "<table width='1000' border='2' align='center'><tr align='center'><td>ID</td><td>Name</td><td>Sex</td><td>Job</td></tr>";
    		var tableBody ="";
    		for (var i = 0; i < json1.length; i++) {
				tableBody += "<tr align='center'><td>"+json1[i].sid+"</td><td>"+json1[i].sname+"</td><td>"+json1[i].sex+"</td><td>"+json1[i].job+"</td></tr>";
			}
    		var tableEnd = tableHeader+tableBody+"</table>";
    		$("#dd").html(tableEnd);
    		$("#dd").slideToggle(2000);
    	});
     })
</script>
</head>
<body>
<input type="button" id="bt" name="bt" value="get value of json">
<input type="button" id="bt1" value="get value of json1">
<form action="https://www.baidu.com/" method="get"><input type="submit" id="bt2" value="Click to Baidu" ></form>

<div id="dd"></div>
</body>
</html>