<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>你好</title>
	
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
        <li class="nav-item active">
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
          <li class="nav-item">
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
    <main role="main">
      <div class="jumbotron first-section">
        <div class="container">
          <h1 class="display-5">您好！</h1>
          <p class="display-text">
          	欢迎来到东方体育中心，您可以在此管理订单、新闻和留言。
          </p>
          <p class="display-text">祝您上班愉快！</p>
          <p class="display-button"><a class="btn btn-primary btn-lg btn-word" href="UserInform.jsp" role="button">管理个人账户</a></p>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <h3>新闻</h3>
            <p class="display-text">在这里您可以查看和发布场馆新闻。</p>
            <p><a class="btn btn-secondary btn-next" href="managernews.jsp" role="button">查看更多</a></p>
          </div>
          <div class="col-md-4">
            <h3>订单</h3>
            <p class="display-text">您可以在这里查看所有用户订单，并对其进行操作。</p>
            <p><a class="btn btn-secondary btn-next" href="managerorder.jsp" role="button">查看更多</a></p>
          </div>
          <div class="col-md-4">
            <h3>留言板</h3>
            <p class="display-text">您可以查看并审核用户留言。</p>
            <p><a class="btn btn-secondary btn-next" href="managermessage.jsp" role="button">查看更多</a></p>
          </div>
        </div>
        <hr>
      </div>
    </main>
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
</body>
</html>