<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>Sign up</title>
	
	<link href="login.css" rel="stylesheet">
	<link href="settled.css" rel="stylesheet">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>
<body>
	<form class="form-signin" id="Signup-form" method="post">
		<h1 class="text-center mb-3 font-weight-normal">注册</h1>
		<div class="mb-3">
			<label for="usrEmail">邮箱</label>
			<input type="text" class="form-control form-signup" id="usrEmail" name="usrEmail" placeholder="you@example.com">
		</div>
		<div class="mb-3">
			<label for="usrName">用户名</label>
			<input type="text" class="form-control form-signup" id="usrName" name="usrName">
		</div>
		<div class="mb-3">
			<label for="usrKey">密码</label>
			<input  type="password" class="form-control form-signup" id="usrKey" name="usrKey" >
		</div>
		<div class="mb-3">
			<label for="cfmKey">确认密码</label>
			<input type="password" class="form-control form-signup" id="cfmKey">
		</div>
		<div class="mb-3 ro">
			<label for="vcode">验证码</label>
			<div class="row">
				<div class="col-md-6">
					<input type="text" class="form-control form-signup" id="vcode" placeholder="不区分大小写"> 
				</div>
				<div class="col-md-6">
					<input type="text" readonly="readonly" class="form-control code" id="checkCode" onClick="createCode()"> 
				</div>
			</div>
		</div>
		<div class="mb-3">
			<a class="btn btn-lg btn-primary btn-block btn-a" onclick="validate()">注册</a>
		</div>
		<div class="text-center alert alert-dark alert-login">
			<a href="login.jsp" class="alert-link">已有账户？</a>
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
	<script src="signup.js"></script>
	<script>
		$(function(){
			createCode();
		});
	</script>
</body>
</html>