<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="true">
		abc
	</c:if>
	<c:if test="false">
		qwert
	</c:if>
	<!--<c:if test="1==1">123</c:if> -->	<!-- 这样可能会导致把1==1看成一个字符串 ，所以使用下面那种方式-->
	<!--<c:if test="${1==1}">456</c:if> -->		<!-- jstl经常和el表达式联用-->
	<br>
	
	
	
	
	
	<!-- 
	for(int i = 0 ;i <= 5 ;i++){
		System.out.println(i);
	} -->
	<c:forEach var="i" begin="0" end="5">
		${i };
	</c:forEach>
	<br/>
	
	
	
	<!-- 
	for(Student stu : Students){
		System.out.println(stu);
	} -->
	<%
		List<Integer> Students = new ArrayList<Integer>();
		Students.add(1);
		Students.add(2);
		Students.add(3);
		request.setAttribute("Stu",Students);//后者是传入进来的参数,前者是设置名字
	%>
	<c:forEach items="${Stu }" var="stu">  <!-- items表示集合或数组    var表示集合中的某一个元素 -->
		${stu };
	</c:forEach>
</body>
</html>