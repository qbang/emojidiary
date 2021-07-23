<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	.login-form {
		display: flex;
		flex-direction: column;
		width: fit-content;
		margin: auto;
		align-items: center;
	}
	.form-item {
		display: flex;
		align-items: center;
		margin: .5rem 0;
	}
	.form-item label{
		display: inline-block;
		min-width: 100px;
		margin-right: 1rem;
		font-size: 1.5rem;
	}
	.form-item input{
		min-width: 300px;
		font-size: 1.5rem;
	}
	.submit-btn {
		cursor: pointer;
		width: 420px;
		font-size: 1.5rem;
		background: #0170fe;
		border: none;
		color: #fff;
		border-radius: 3px;
		padding: 5px 0;
		margin-top: 2rem;
	}
	.register-link {
		width: 424px;
		text-align: right;
		margin: 1rem auto;
	}
	.register-link a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<form class="login-form" action="login" method="post">
		<div class="form-item">
			<label for="userId">아이디</label>
			<input name="userId" type="text" value=""/>
		</div>
		<div class="form-item">
			<label for="userPw">비밀번호</label>
			<input name="userPw" type="password" value=""/>
		</div>
		<button class="submit-btn" type="submit">로그인</button>
	</form>
	<div class="register-link">
		<a href="register">회원가입</a>
	</div>
</body>
</html>