<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div style="height:30px;overflow: hidden;padding: 20px;">
	<div style="width: 1000px;margin: 0 auto;overflow: hidden;">
		欢迎你，<label>${admin.nickName}</label>
		<a class="sign" style="margin-left: 20px;" href="<%=basePath%>LogoutServlet">退出</a>
	</div>
</div>
