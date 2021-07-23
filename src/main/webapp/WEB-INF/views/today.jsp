<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" errorPage = "error.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style>
		html, body {
			width: 100%;
			height: 100%;
			margin: 0;
			padding: 0;
		}
		img{
			height: 50px;
			width: 50px;
		}
		.today-mood-btn-container {
			width: 60%;
			display: flex;
			flex-direction: column;
			justify-content: center;
			margin: 1.5rem auto;
		}
		.today-mood-btn-list {
			display: flex;
		}
		.today-mood-btn-list button {
			cursor: pointer;
			margin: 0 5px;
		}
	</style>
</head>
<body> 
	<div class="today-mood-btn-container">
		<h3 class="sub-title">오늘의 기분은?</h3>
		<div class="today-mood-btn-list">
		 	<button type="button" onclick="location.href='detail?value=0'"><img src="resources/img/best.svg"></button>
		 	<button type="button" onclick="location.href='detail?value=1'"><img src="resources/img/happy.svg"></button>
		 	<button type="button" onclick="location.href='detail?value=2'"><img src="resources/img/soso.svg"></button>
		 	<button type="button" onclick="location.href='detail?value=3'"><img src="resources/img/sad.svg"></button>
		 	<button type="button" onclick="location.href='detail?value=4'"><img src="resources/img/angry.svg"></button>
		</div>
	</div>
</body>
</html>