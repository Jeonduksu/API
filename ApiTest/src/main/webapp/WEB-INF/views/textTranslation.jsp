<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js
"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			let text = $("#inputText").val();
			console.log(text);
			$.ajax({
				url:"/api/trans",
				data:JSON.stringify({"text":text}),
				method:"post",
				dataType:"json",
				contentType:"application/json",
				success:function(data){
					console.log(data.data);
					let res = JSON.parse(data.data).message.result.translatedText;
					console.log(res);
					
					$("#res").text(res);
				},
				error:function(){
					alert("통신 실패");
				}
			})
		});
	});
</script>
</head>
<body>
	<div>
		<div>
		<input type="text" id="inputText"> &nbsp;<button id="btn">번역</button>
		</div>
		<div>
			<div id="res"></div>
		</div>
	</div>
</body>
</html>