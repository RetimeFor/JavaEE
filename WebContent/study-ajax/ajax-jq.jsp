<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function register() {
		var number = $('#num').val();
		//方式一
		$.ajax({
			url:"../ServletDemo",
			data:"n="+number,
			success:function(result,textStatus){
				if(result == "true"){
					alert("注册失败");
				}else{
					alert("注册成功")
				}
			}
		})
		//方式二
		/*$.get(
				"../ServletDemo",
				"n="+number,
				function(result){
					if(result == "true"){
						alert("注册失败");
					}else{
						alert("注册成功")
					}
				},
				"text"  //返回值类型，可以不写
			);*/
		//方式三
		/*$.post(
				"../ServletDemo",
				"n="+number,
				function(result){
					if(result == "true"){
						alert("注册失败");
					}else{
						alert("注册成功")
					}
				},
				"text"  //返回值类型，可以不写
			);*/
		//方式四
		/*$('#abc').load(
				"Servlet",
				"n="+number
				//直接在servlet写注册成功或注册失败（）	它会把结果放在#abc里面
				"text"  //返回值类型，可以不写
			);*/
		//方式五
		/*$.getJSON(
				"Servlet",
				{"n":number},//里面可以放多组值
				function(result){//注意，这里的result是json格式的，应在servlet中设置输出的格式
					if(result.msg == "true"){
						alert("注册失败");
					}else{
						alert("注册成功")
					}
				}
		)*/
	}
</script>
</head>
<body>
	号码:<input type="text" id="num">
	<input type="button" value="注册" onclick="register()">
	<span id="abc"></span>
</body>
</html>