<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>Login</title>
	
	<link href="login.css" rel="stylesheet">
	<link href="settled.css" rel="stylesheet">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body class="text-center">
	<form class="form-signin" id="login-form" method="post" action="UserLogin">
		<h1 class="mb-3 font-weight-normal">登陆</h1>
		<div class="mb-3">
			<label for="usrName" class="sr-only">用户名或邮箱</label>
			<input type="text" id="usrName" name="usrName" class="form-control form-signin-up" placeholder="用户名或邮箱" required autofocus>
			<label for="usrKey" class="sr-only">密码</label>
			<input type="password" id="usrKey" name="usrKey" class="form-control form-signin-down" placeholder="密码" required>
		</div>
		<div class="mb-3">
			<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
		</div>
		<div class="alert alert-dark alert-login">
			<a href="signup.jsp" class="alert-link">注册账号</a>
		</div>
	</form>
	<footer class="footer">
      <div class="container foot-text">
        <span class="foot-t">Created by Jiayi Zhu & Shen Lei</span>
      </div>
    </footer>
	<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.3.1.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>