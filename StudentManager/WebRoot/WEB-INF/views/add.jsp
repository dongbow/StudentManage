<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>录入学生-学生管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	
	<style type="text/css">
		*{margin:0;padding:0}
		.cont{width:1000px;height: auto;overflow: hidden;margin: 20px auto;}
		table{width: 50%;margin: 0 100px}
		th{width: 120px;text-align: right;}
		th,td{height: 40px;}
		input[type="text"]{width: 300px;height: 30px;padding: 6px;border: 1px solid #444;
				font-szie: 15px;}
		select{width:100px;height: 30px;}
		td{padding-left: 20px;}
		.btns{text-align: center;width: 750px}
		button,input[type="reset"]{width: 50px;height: 30px;border: 1px solid #666; 
			background: #666;color: #fff;cursor: pointer; margin-right: 15px;}
	</style>

  </head>
  
  <body>
    <div class="cont">
    	<form action="<%=basePath %>AddStudentServlet" method="post" target="opener">
	    	<table>
	    		<tbody>
	    			<tr>
	    				<th>学号：</th>
	    				<td>
	    					<input type="text" name="stuid">
	    				</td>
	    			</tr>
	    			<tr>
	    				<th>姓名：</th>
	    				<td>
	    					<input type="text" name="stuname">
	    				</td>
	    			</tr>
	    			<tr>
	    				<th>性别：</th>
	    				<td>
	    					<select name="stusex">
	    						<option value="0">男</option>
	    						<option value="1">女</option>
	    					</select>
	    				</td>
	    			</tr>
	    			<tr>
	    				<th>年龄：</th>
	    				<td>
	    					<input type="text" name="stuage">
	    				</td>
	    			</tr>
	    			<tr>
	    				<th>班级：</th>
	    				<td>
	    					<input type="text" name="stuclass">
	    				</td>
	    			</tr>
	    			<tr>
	    				<th>家庭住址：</th>
	    				<td>
	    					<input type="text" name="stuaddress">
	    				</td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<div class="btns">
	    		<button onclick="javascript:window.open('','_self').close();">添加</button>
	    		<input type="reset" value="重置">
	    	</div>
    	</form>
    </div>
  </body>
</html>
