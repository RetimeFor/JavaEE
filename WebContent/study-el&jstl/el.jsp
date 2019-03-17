<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="el.study.bean.studentInfo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	request.setAttribute("school","吉首大学");//一个字符串
	studentInfo stu1 = new studentInfo();
	stu1.setName("张三");
	stu1.setAge(18);
	stu1.setId(1);
	session.setAttribute("student", stu1);//一个对象
	
	List<studentInfo> list = new ArrayList<studentInfo>();
	studentInfo stu2 = new studentInfo();
	stu2.setName("李四");
	stu2.setAge(20);
	stu2.setId(2);
	list.add(stu2);
	studentInfo stu3 = new studentInfo();
	stu3.setName("王五");
	stu3.setAge(19);
	stu3.setId(3);
	list.add(stu3);
	application.setAttribute("list",list);//一个集合
%>


<%=request.getAttribute("school") %>
<br>
<%
	studentInfo s = (studentInfo)session.getAttribute("student");
	out.print(s.getName()+"---");
	out.print(s.getAge()+"---");
	out.print(s.getId()+"---");
%>
<br>
<!-- 使用el表达式 -->
${requestScope.school }
<p>-----------------</p>
${sessionScope.student.name}
<p>----------------------</p>
${applicationScope.list[0].name}


<!-- 最常用的方式 -->
<br>
${school }
${student.name }
${list[1].name }
</body>
</html>