<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function register() {
		number = document.getElementById("num").value;
		xhr = new XMLHttpRequest();//如果不写var就是全局变量
		xhr.onreadystatechange = callBack;  //设置回调函数
		xhr.open("post","../ServletDemo",true);//打开请求(不需要知道包名，直接找到这个类(它扫描的是自己和兄弟节点的所有类和子包中的所有类))
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//设置post方式的头信息
		xhr.send("n="+number);//发送信息给servlet
		//如果是get方式提交,把上面三句替换成下面两句
		/*  xhr.open("get","Servlet1?n="+number,true);
			xhr.send(null);*/
	}
	function callBack() {//定义回调函数，用于接收返回的结果
		if(xhr.readyState == 4 && xhr.status == 200){//如果请求读取完毕并且状态正确
			var data = xhr.responseText;
			if(data == "true"){
				alert("注册失败");
			}
			else{
				alert("注册成功");
			}
		}
	}
</script>
</head>
<body>
	号码:<input type="text" id="num">
	<input type="button" value="注册" onclick="register()">
</body>
</html>