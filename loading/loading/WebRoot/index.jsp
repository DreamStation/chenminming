<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
    	<form action="LoginServlet" method="post">
			<table cellspacing="0px" align="center" width="300px" height="150px">
				<tr>
					<td colspan="2" align="center">
						LoginPage
					</td>
				</tr>
				<tr>
					<td width="100px">
						username:
					</td>
					<td width="200px">
						<input type="text" name="username">
					</td>
				</tr>
				<tr>
					<td>
						password:
					</td>
					<td>
						<input type="password" name="password" id="password" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="submit" />
						<input type="button" value="register" onclick="window.location.href='register.jsp'">
					</td>
				</tr>
			</table>
		</form>
  </body>
</html>
