<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>RegisterPage</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function check(){
			var username=document.getElementsByName("username")[0];
			var password=document.getElementsByName("password")[0];
			var repassword=document.getElementsByName("repassword")[0];
			var span1=document.getElementById("span1");
			var span2=document.getElementById("span2");
			var span3=document.getElementById("span3");
			var judge=true;
			span1.innerHTML="";
			span2.innerHTML="";
			span3.innerHTML="";
			if(username.value.length<1){
				span1.innerHTML="username can`t be blank";
				judge=false;
			}
			if(password.value.length<4){
				span2.innerHTML="password is too short";
				judge=false;
			}
			if(password.value.length>10){
				span2.innerHTML="password is too long";
				judge=false;
			}
			if(password.value!=repassword.value){
				span3.innerHTML="password isn`t same as repassword";
				judge=false;
			}
			return judge;
		}
		function res(){
			var span1=document.getElementById("span1");
			var span2=document.getElementById("span2");
			var span3=document.getElementById("span3");
			span1.innerHTML="";
			span2.innerHTML="";
			span3.innerHTML="";
		}
	</script>

	</head>

	<body>
		<form action="RegisterServlet" method="post" onsubmit="return check()">
			<table cellspacing="0px" align="center" width="600px" height="200px">
				<tr>
					<td colspan="3" align="center">
						RegisterPage
					</td>
				</tr>
				<tr>
					<td width="100px">
						username:
					</td>
					<td width="160px">
						<input type="text" name="username">
					</td>
					<td width="240px">
						<span id="span1"></span>
					</td>
				</tr>
				<tr>
					<td>
						password:
					</td>
					<td>
						<input type="password" name="password" id="password" />
					</td>
					<td>
						<span id="span2"></span>
					</td>
				</tr>
				<tr>
					<td>
						repassword:
					</td>
					<td>
						<input type="password" name="repassword" id="repassword" />
					</td>
					<td>
						<span id="span3"></span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="submit" />
						<input type="reset" value="reset" onclick="res()"/>
					</td>
					<td>
						
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
