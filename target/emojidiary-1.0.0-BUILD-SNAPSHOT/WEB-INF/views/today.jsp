<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" errorPage = "error.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
	<style>
/* 		html, body {
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
			background-color: white;
			margin: 0 5px;
			text-align: center;
		} */
		img{
			height: 40px;
			weight: 40px;
		}
	</style>
</head>
<body> 
<!-- 	<div class="today-mood-btn-container">
		<h3 class="sub-title">오늘의 기분은 어때요?</h3>
		<div class="today-mood-btn-list">
		 	<button type="button" onclick="location.href='detail?value=0'"><img src="resources/img/best.svg"></button>
		 	<button type="button" onclick="location.href='detail?value=1'"><img src="resources/img/happy.svg"></button>
		 	<button type="button" onclick="location.href='detail?value=2'"><img src="resources/img/soso.svg"></button>
		 	<button type="button" onclick="location.href='detail?value=3'"><img src="resources/img/sad.svg"></button>
		 	<button type="button" onclick="location.href='detail?value=4'"><img src="resources/img/angry.svg"></button>
		</div>
	</div> -->
	<div class="container">
		<p>오늘의 기분은 어때요?</p>
		<ul class="nav justify-content-center">
		  <li class="nav-item">
		    <a class="item" onclick="location.href='detail?value=0'"><img src="resources/img/best.svg"></a>
		  </li>
		  <li class="nav-item">
		   <a class="item" onclick="location.href='detail?value=1'"><img src="resources/img/happy.svg"></a>
		  </li>
		  <li class="nav-item">
		   <a class="item" onclick="location.href='detail?value=2'"><img src="resources/img/soso.svg"></a>
		  </li>
		  <li class="nav-item">
		   <a class="item" onclick="location.href='detail?value=3'"><img src="resources/img/sad.svg"></a>
		  </li>
  		  <li class="nav-item">
		   <a class="item" onclick="location.href='detail?value=4'"><img src="resources/img/angry.svg"></a>
		  </li>
		</ul>
	</div>
</body>
</html>