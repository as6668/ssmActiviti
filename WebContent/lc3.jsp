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
<center>
   查看<br/> 
   		<form action="<%=basePath%>/loginc/tj2.do" method="post">
		    请假人：${c1.请假人}<BR/>
		    请假天数：${c1.请假天数}<BR/>
		    请假原因：${c1.请假原因}<BR/>
		 <c:if test="${c1.直属部门领导!=null}">
		     直属部门领导：${c1.直属部门领导}<BR/>
		 </c:if>
		 <c:if test="${c1.直属部门领导!=null}">
		     终极boss领导:${c1.终极boss领导}<BR/>
		 </c:if>
                  直属部门审批意见：
         <input type="text" name="yj1"/><BR/>  
                  终极boss审批意见：
         <input type="text" name="yj2"/><BR/>    
       
         <input type="submit" value="处理提交"/>
		</form>
</center>
</body>
</html>