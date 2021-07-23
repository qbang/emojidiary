<%@ page session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	language="java" errorPage = "error.jsp" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>모두의 기분</title>
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
		.navigator {
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			margin: 1rem auto;
		}
		.prev, .next {
			margin: auto 2rem;
			text-decoration: none;
			font-weight: 500;
			font-size: 32px;
			color: black;
		}
		.logout:hover, .prev:hover, .next:hover {
			color: #1890ff;
		}
		.sub-title {
			font-size: 24px;
		}
		.calendar {
			min-width: 60%;
			text-align: center;
			margin: 0 auto;
			border-collapse: collapse;
		}
		.calendar th, .calendar td{
			border: 1px solid black;
			margin: 0;
			padding: 0;
			box-sizing: border-box;
			width: 100px;
		}
		.calendar td {
			height: 100px;
		}
		.calendar td input {
			border: none;
			background: none;
			font-size: 16px;
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
	<div class="navigator">
		<a class="prev" href="./calendar?value=-1">&lt;</a>
		<h1 class="sub-title">${userId}님의 ${month}월 기분입니다.</h1>
		<a class="next" href="./calendar?value=1">&gt;</a>
	</div>
	<!-- 여기다가 달력 형태로 보여주고 -->
	<table class="calendar">
		<thead>
			<tr>
				<th>일</th> <th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${map}" var="map">
					<c:choose>
						<c:when test="${fn:contains(map.value,'/')}">
							<td>
								<img onclick="location.href='detail?year=${year}&month=${month}&day=${map.key}&value=${map.value}'" src="${map.value}"/>
							</td>
						</c:when>
						<c:otherwise>
							<td><input type="button" onclick="location.href='detail?year=${year}&month=${month}&day=${map.key}'" value="${map.value}"></input></td>
						</c:otherwise>
					</c:choose>
					<c:if test="${map.key%7 eq 0}"></tr></c:if>
				</c:forEach>
		</tbody>
	</table>
	
	<!-- 무드에서는 오늘 기분만 처리 -->
	<jsp:include page="today.jsp"/>
</body>
</html>
