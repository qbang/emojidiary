<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style>
		html, body {
			width: 100%;
			height: 100%;
			margin: 0;
			padding: 0;
		}
		.header {
			display: flex;
			position: relative;
			top: 0;
			min-width: 100%;
			justify-content: center;
			align-items: center;
			border-bottom: solid 2px #e8e8e8;
			box-shadow: 0 0 3rem #f3f1f1;
		}
		.title {
			margin: 0;
			font-weight: 600;
			font-size: 32px;
			padding: 1rem 0;
		}
		.logout {
			position: absolute;
			background: none;
			border: none;
			top: 26px;
			right: 32px;
			font-size: 20px;
			cursor: pointer;
		}
		.section {
			display: flex;
			flex-direction: column;
			width: 60%;
			margin: 2rem auto;
		}
		.section .date-title {
			font-size: 1rem;
			font-weight: 600;
			margin: 1rem 0;
		}
		.section form {
			display: flex;
			flex-direction: column;
		}
		.section form .radio-btn-list {
			display: flex;
			align-items: center;
			margin: 1rem 0;
		}
		.radio-btn-list img {
			margin-right: 10px;
		}
		.section form textarea {
			margin: 1rem 0;
			padding: 10px;
		}
		.submit-btn {
			width: fit-content;
			font-weight: 600;
			font-size: 20px;
			padding: 7px 20px;
			color: #fff;
			background-color: #17a2b8;
			border: none;
			border-radius: 5px;
			margin-left: auto;
		}
		img{
			height: 50px;
			width: 50px;
		}
	</style>
</head>
<body>
	<div class="header">
		<h1 class="title">모두의 기분 (Mogi)</h1>
		<jsp:include page="logout.jsp"/>
	</div>
	<div class="section">
		<p class="date-title">${year}년 ${month}월 ${day}일</p>
		<form action="registerFeeling" method="POST">
			<c:choose>
				<c:when test="${!empty feeling_arr}">
					<div class="radio-btn-list">
						<c:forEach items="${feeling_arr}" var="feeling_value" varStatus="status">
							<input type="radio" name="feeling" value="${status.index}" <c:if test="${!empty feeling and feeling eq status.index}">checked</c:if>><img src="${feeling_value}">
						</c:forEach>
					</div>
				</c:when>
				<c:otherwise>
					<img src="${feeling_src}"/>
				</c:otherwise>
			</c:choose>
			<textarea name="detail" cols=100 rows=6><c:choose><c:when test="${empty detail}">끄적끄적..</c:when><c:otherwise>${detail}</c:otherwise></c:choose></textarea>
			<input class="submit-btn" type="submit" value="등록"/>
			<input name="feeling" type="hidden" value="${feeling}"/>
			<input name="year" type="hidden" value="${year}"/>
			<input name="month" type="hidden" value="${month}"/>
			<input name="day" type="hidden" value="${day}"/>
		</form>
	</div>
</body>
</html>