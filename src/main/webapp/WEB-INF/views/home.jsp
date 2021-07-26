<%@ page session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	language="java" errorPage = "error.jsp" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>모두의 기분</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<style>
/* 		html, body {
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
			border: 2px solid black;
			margin: 2px;
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
		} */
		.container{
			margin-top: 100px;
			text-align: center;
			width: 50%;
			align: center;
		}
		.table-nav{
			width: 50%;
			text-align: center;
			margin: auto;
		}
		.calendar-img{
			height: 40px;
			width: 40px;
		}
		.sub-title{
			display: inline;
			background: linear-gradient(to top, #FFBB00 50%, transparent 50%);
		}
		.calendar-td{
			text-align: center;
			height: 45px;
			width: 45px;
		}
		.calendar-num{
			background: transparent;
			border: none;
			font-size: x-small;
			color: gray;
		}
		.table-calendar{
		    margin-left: auto;
   			margin-right: auto; 
		}
		.title-year{
			font-size: x-small;
		}
		td > a {
			color: black;
		}
	</style>
</head>
<body>
	<%-- <div class="header">
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
	<jsp:include page="today.jsp"/> --%>
	<div class="container">
		<p ></p>
		<table class="table-nav">
			<tr>
				<td class="title-year" colspan="3">${year}</td>
			</tr>
			<tr>
			  <td><a href="./calendar?value=-1">
			    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
  				  <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
				</svg></a>
			  </td>
			  <td><p class="sub-title">${userId}님의 ${month}월은?</p></td>
  			  <td><a href="./calendar?value=1">
			    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle" viewBox="0 0 16 16">
				  <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
				</svg></a>
			  </td>
		 	 </tr>
		</table>
		<br>
		<!-- 여기다가 달력 형태로 보여주고 -->
		<table class="table-calendar">
			<thead>
<!-- 				<tr>
					<th>일</th> <th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
				</tr> -->
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${map}" var="map">
						<c:choose>
							<c:when test="${fn:contains(map.value,'/')}">
								<td class="calendar-td">
									<img class="calendar-img" onclick="location.href='detail?year=${year}&month=${month}&day=${map.key}&value=${map.value}'" src="${map.value}"/>
								</td>
							</c:when>
							<c:otherwise>
								<td class="calendar-td"><input class="calendar-num" type="button" onclick="location.href='detail?year=${year}&month=${month}&day=${map.key}'" value="${map.value}"></input></td>
							</c:otherwise>
						</c:choose>
						<c:if test="${map.key%7 eq 0}"></tr></c:if>
					</c:forEach>
			</tbody>
		</table>
		<!-- 무드에서는 오늘 기분만 처리 -->
		<jsp:include page="today.jsp"/>
	</div>
</body>
</html>
