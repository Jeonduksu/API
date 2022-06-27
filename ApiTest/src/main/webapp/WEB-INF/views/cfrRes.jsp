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
	let res = ${res};
	
	console.log(res);
	
	for(let i=0; i<res.faces.length; i++){
		$("div").append("닮은 유명인: <span>"+res.faces[i].celebrity.value+"</span><br />");
		$("div").append("싱크로율: <span>"+res.faces[i].celebrity.confidence+"</span><br />");
	}
});
</script>
</head>
<body>
	<img src="/resources/img05.jpg">
	<div>
	
	</div>

</body>
</html>