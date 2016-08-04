<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.sm.bean.Page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 
%>
<div style="overflow: hidden;padding: 5px;text-align: center;">
	<a href="StudentListForm">首页</a>
	<c:if test="${page.nowPage == 1}">
		<a>上一页</a>
	</c:if>
	<c:if test="${page.nowPage - 1 > 0}">
		<a href="StudentListForm?page=${page.nowPage - 1}">上一页</a>
	</c:if>
	<a class="now">${page.nowPage}/${page.totalPage}</a>
	<c:if test="${page.nowPage == page.totalPage}">
		<a>下一页</a>
	</c:if>
	<c:if test="${page.totalPage - page.nowPage > 0}">
		<a href="StudentListForm?page=${page.nowPage + 1}">下一页</a>
	</c:if>
	<a href="StudentListForm?page=${page.totalPage}">尾页</a>
</div>



