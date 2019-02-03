<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>个人信息管理</title>
	
	<link href="Information.css" rel="stylesheet">
	<link href="settled.css" rel="stylesheet">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <a class="navbar-brand">东方体育中心</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
      	<span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link" href="Hello.jsp">首页 <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="news.jsp">新闻 </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="rvnintro.jsp">场馆介绍</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">场馆预约</a>
            <div class="dropdown-menu dropdown-top" aria-labelledby="dropdown03">
              <a class="dropdown-item dropdown-word" href="reservation.jsp?rnvid=1">篮球</a>
              <a class="dropdown-item dropdown-word" href="reservation.jsp?rnvid=2">乒乓球</a>
              <a class="dropdown-item dropdown-word" href="reservation.jsp?rnvid=3">羽毛球</a>
              <a class="dropdown-item dropdown-word" href="reservation.jsp?rnvid=4">排球</a>
            </div>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="messageboard.jsp">留言板</a>
          </li>
          <li class="nav-item dropdown no-arrow active">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            	<i class="ps-icon"></i>
            	<%= session.getAttribute("usrName") %>
            </a>
            <div class="dropdown-menu dropdown-menu-right dropdown-top" aria-labelledby="userDropdown">
              <a class="dropdown-item dropdown-word" href="UserInform.jsp">个人信息</a>
              <a class="dropdown-item dropdown-word" href="myorder.jsp">我的订单</a>
            <div class="dropdown-divider"></div>
              <a class="dropdown-item dropdown-word" href="#" data-toggle="modal" data-target="#logoutModal">登出</a>
            </div>
        </li>
      </ul>
      </div>
    </nav>
	<form class="personal-form" id="personal-information" method="post" action="UserUpdate">
		<div class="mb-3">
			<label for="usrName">用户名</label>
			<input type="text" class="form-control form-signup" id="usrName" name="usrName">
		</div>
		<div class="mb-3">
			<label for="usrEmail">邮箱</label>
			<input type="email" class="form-control form-signup" id="usrEmail" name="usrEmail">
		</div>
		<div class="mb-3">
			<label for="usrKey">新密码</label>
			<input  type="password" class="form-control form-signup" id="usrnewKey" name="usrnewKey" >
		</div>
		<div class="mb-3">
			<label for="usrKey">确认密码</label>
			<input type="password" class="form-control form-signup" id="usrKey" name="usrKey">
		</div>
		<div class="mb-3">
			<label for="usrOldKey">旧密码</label>
			<input type="password" class="form-control form-signup" id="usrOldKey" name="usrOldKey">
		</div>
		<div class="mb-3">
			<button class="btn btn-lg btn-primary btn-block btn-login" type="submit">修改</button>
		</div>
	</form>
    <footer class="footer">
      <div class="container foot-text">
        <span class="foot-t">Created by Jiayi Zhu & Shen Lei</span>
      </div>
    </footer>
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">确定登出？</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body" style="text-align:center">生命在于运动</div>
          <div class="modal-footer">
            <button class="btn btn-secondary btn-cancel" type="button" data-dismiss="modal">取消</button>
            <a class="btn btn-primary" href="logout.jsp">确定</a>
          </div>
        </div>
      </div>
    </div>
	<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.3.1.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			$.ajax({
				type: "POST",
				url: "UserInformation",
				dataType: "json",
				success: function(message){
					document.getElementById("usrEmail").value = message[0];
					document.getElementById("usrName").value = message[1];
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
				}
			});
		});
	</script>
</body>
</html>