<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../ServletContextDemo2" method="post"><!-- 参照的是web.xml中的ServletContextDemo2，但是使用注解的方式，它找的是注解-->
		用户名:<input type="text" value="" name="userName"/>
		密码:<input type="text" value="" name="password"/>
		<input type="submit" value="登录"/>
	</form>

</body>
</html>