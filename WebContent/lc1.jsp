<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <form action="<%=basePath%>/loginc/tj1.do" method="post">
     请假人：<input type="text" name="qjr" value="${user.nc}"/><br/>
     请假天数：<input type="text" name="qjts" value=""/><br/>
     请假原因：<input type="text" name="qjyy" value=""/><br/>
  <input type="submit" value="提交"/><br/>
 </form>
</center>
</body>
</html>