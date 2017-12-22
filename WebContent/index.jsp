<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${user.approved=='有'}">
		
		<form action="<%=basePath%>loginc/qd.do" method="post">
		  流程选择：       <select name="s1">
		                <option value="leave">请假流程</option>
		              </select>
		  直属部门领导：<select name="s2">
		                <option value="libai">李白</option>
		                <option value="zhang">张</option>
		              </select>
		  终极boss领导：<select name="s3">
		                <option value="lijiacheng">李嘉诚</option>
		                <option value="mayun">马云</option>
		              </select>

		              
         <input type="submit" value="启动流程"/>
		</form>
		<hr/>
		
		<button id="b2"><a href="<%=basePath%>/loginc/sp.do">流程审批</a></button><br/>
	
	
	</c:if>
	<c:if test="${user.approved=='否'}">
			
		<form action="<%=basePath%>/loginc/qd.do" method="post">
		  流程选择：       <select name="s1">
		                <option value="leave">请假流程</option>
		              </select>
		  直属部门领导：<select name="s2">
		                <option value="libai">李白</option>
		                <option value="zhang">张</option>
		              </select>
		  终极boss领导：<select name="s3">
		                <option value="lijiacheng">李嘉诚</option>
		                <option value="mayun">马云</option>
		              </select>

		              
         <input type="submit" value="启动流程"/>
		</form>
		<hr/>
	</c:if>
</body>
</html>
