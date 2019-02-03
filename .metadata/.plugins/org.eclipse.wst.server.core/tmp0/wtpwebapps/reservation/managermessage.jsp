<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>留言管理</title>
	<link href="Hello.css" rel="stylesheet">
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
            <a class="nav-link" href="managermain.jsp">首页<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="managerorder.jsp">订单管理 </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">新闻管理</a>
            <div class="dropdown-menu dropdown-top" aria-labelledby="dropdown03">
              <a class="dropdown-item dropdown-word" href="addnews.jsp">发布新闻 </a>
              <a class="dropdown-item dropdown-word" href="managernews.jsp">查看新闻</a>
            </div>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="managermessage.jsp">留言管理</a>
          </li>
          <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            	<i class="ps-icon"></i>
            	<%= session.getAttribute("usrName") %>
            </a>
            <div class="dropdown-menu dropdown-menu-right dropdown-top" aria-labelledby="userDropdown">
              <a class="dropdown-item dropdown-word" href="managerInform.jsp">个人信息</a>
            <div class="dropdown-divider"></div>
              <a class="dropdown-item dropdown-word" href="#" data-toggle="modal" data-target="#logoutModal">登出</a>
            </div>
        </li>
      </ul>
      </div>
    </nav>
	<div>
		<div class="btn-group" role="group" id="days" aria-label="First group" >
	    </div>
		<div class="card-body table-responsive table-show col-10">
			<table class="table table-bordered mb-0" id="message-table">
				<tr>
					<th>留言昵称</th>
					<th>留言内容</th>
					<th>通过</th>
				</tr>
			</table>
		</div>
	</div>
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
            <button class="btn btn-secondary btn-cencel" type="button" data-dismiss="modal">取消</button>
            <a class="btn btn-primary" href="logout.jsp">确定</a>
          </div>
        </div>
      </div>
    </div>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.3.1.min.js"></script>
	<script src="https://cdn.staticfile.org/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="managermessage.js"></script>
</body>
</html>