<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	let res = ${res};
	console.log(res);
	
	// $("div").append("<b>"+res.text+"</b>");
	
	for(let i=0; i<res.segments.length; i++){
		$("div").append("<b>"+res.segments[i].text+"</b><br />");
	}
});

</script>
</head>
<body>
	<div>
	
	</div>
</body>
</html>