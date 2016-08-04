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
    
    <title>学生列表-学生管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<script type="text/javascript">
		function deleteS(e,id){
			var msg = "确定删除？";
			if(confirm(msg) == true){
				e.href='<%=basePath%>DeleteServlet?id='+id;
				return true;
			} else {
				return false;
			}
		}
	</script>
	<style type="text/css">
		*{margin:0;padding:0}
		.cont{width: 1000px; height: auto;overflow: hidden;margin: 0px auto;}
		.tools form{width:500px;float: right;text-align: right;}
		table{width: 100%;margin-top: 20px;margin-bottom: 10px;}
		table,td,th{border: 1px solid #666;border-collapse:collapse;text-align: center;}
		button{width: 50px;height: 30px;border: 1px solid #666; 
			background: #666;color: #fff;cursor: pointer;}
		input[type="text"]{width: 150px;height: 30px;padding: 5px;border: 1px solid #666;
				font-szie: 15px;}
		select{width: 100px;height: 30px;}
		a{text-decoration: none;color: #444;}
		a:hover{color: #19b4ea;}
	</style>

  </head>
  
  <body>
  	<jsp:include page="/common/header.jsp"></jsp:include>
    <div class="cont">
    	<div class="tools">
    		<a class="sign" href="javascript:;" 
    			onclick="javascript:window.open(
    					'<%=basePath %>AddStudentForm','_blank',
    					'location=yes, directories=no, status=no, toolbar=no,menubar=no,fullscreen=no,dependent=no,scrollbars=no,resizable=no, copyhistory=yes, width=750, height=400');">录入新学生</a>
    		<form action="<%=basePath %>SearchServlet" method="get">
    			<select name="way">
    				<option value="0" <c:if test="${0 eq param.way}">selected</c:if>>学号</option>
    				<option value="1" <c:if test="${1 eq param.way}">selected</c:if>>学生姓名</option>
    			</select>
    			<input type="text" name="keyword" placeholder="支持相似查询" value="${keyword}">
    			<button>查找</button>
    		</form>
    	</div>
    	<table>
    		<tbody>
    			<tr>
    				<td width="6%">序号</td>
    				<td width="10%">学号</td>
    				<td width="10%">名字</td>
    				<td width="7%">性别</td>
    				<td width="7%">年龄</td>
    				<td width="15%">班级</td>
    				<td width="25%">家庭住址</td>
    				<td width="15%">操作</td>
    			</tr>
    			<c:forEach items="${studentList}" var="Student">
    				<tr>
	    				<td>${Student.id}</td>
	    				<td>${Student.stuId}</td>
	    				<td>${Student.stuName}</td>
	    				<td>${Student.stuSex}</td>
	    				<td>${Student.stuAge}</td>
	    				<td>${Student.stuClass}</td>
	    				<td>${Student.stuAddress}</td>
	    				<td>
	    				<a href="javascript:;" onclick="javascript:window.open(
    						'<%=basePath%>UpdateForm?id=${Student.id}','_blank',
    						'location=yes, directories=no, status=no, toolbar=no,menubar=no,fullscreen=no,dependent=no,scrollbars=no,resizable=no, copyhistory=yes, width=750, height=400');">修改</a>
	    					&nbsp;&nbsp;|&nbsp;&nbsp;
	    					<a href="javascript:;" onclick="deleteS(this,${Student.id});">删除</a>
	    				</td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
    	<c:if test="${param.keyword != null && param.keyword != ''}">
    		<a href="<%=basePath%>StudentListForm">返回学生列表</a>
    	</c:if>
    	<c:if test="${(param.page == null || param.page > 0) && param.keyword == null}">
    		<jsp:include page="/common/page.jsp"></jsp:include>
    	</c:if>
    </div>
  </body>
</html>
