<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style>
		.logout {
				position: absolute;
				background: none;
				border: none;
				top: 26px;
				right: 32px;
				font-size: 20px;
				cursor: pointer;
			}
	</style>
</head>
<body>
	<button class="logout" onclick="location.href='logout'">로그아웃</button>
</body>
</html>