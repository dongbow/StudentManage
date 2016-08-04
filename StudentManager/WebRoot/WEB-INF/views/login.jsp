<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录-学生管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	
	<style type="text/css">
		*{margin:0;padding:0}
		.cont{width: 400px;height: auto; margin: 200px auto;}
		table{width: 100%;}
		th{width:80px;text-align: right;margin-bottom: 10px;}
		td{margin-bottom: 10px}
		input{width: 240px;height: 30px;padding: 6px;color: #444;border: 1px solid #666;}
		.btn{text-align: center;margin-top: 15px;}
		button{width: 120px;height: 30px;border: 1px solid #666; 
			background: #666;color: #fff;cursor: pointer;}
	</style> 
  </head>
  
  <body>
  	<div class="cont">
  		<label style="color: red">${loginMsg}</label>
  		<form action="<%=basePath%>LoginServlet" method="post">
  			<table>
  				<tbody>
  					<tr>
  						<th>登录名：</th>
  						<td>
  							<input name="username" type="text" >
  						</td>
  					</tr>
  					<tr>
  						<th>密码：</th>
  						<td>
  							<input name="password" type="password" >
  						</td>
  					</tr>
  				</tbody>
  			</table>
  			<div class="btn">
  				<button>登录</button>
  			</div>
  		</form>
  	</div>
  </body>
</html>
