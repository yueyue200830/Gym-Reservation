<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>预约</title>
	<link href="reservation.css" rel="stylesheet">
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
          <li class="nav-item dropdown active">
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
          <li class="nav-item dropdown no-arrow">
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
	<div class="center">
		<div class="btn-group btn_group_date" role="group" id="days" aria-label="First group" >
	    </div>
		<div class="card-body table-responsive table-show col-10">
			<table class="table table-bordered mb-0" id="reservation-table">
				
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
	<script>
	$(document).ready(function() {
		addDate();
		getTable();
	});
	function addDate() {
		var d = new Date();
		for (var i = 0; i < 4; i++) {
			var changeID = "day" + (i + 1);
			d = d.setDate(d.getDate() + 1);
			d = new Date(d);
			var changeday = d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate();
			// document.getElementById(changeID).innerHTML = changeday;
			$("#days").append(
					"<a type='button' class='btn btn-secondary' id='" + changeID
					+ "' href='reservation.jsp?rnvid="+<%= request.getParameter("rnvid") %>+
					"&year="+d.getFullYear()+"&month="+(d.getMonth()+1)+"&day="+ d.getDate() +"')>" + changeday + "</a>");
		}
	}
	function getTable() {
		var t = new Date();
		t = t.setDate(t.getDate() + 1);
		t = new Date(t);
		var year = t.getFullYear();
		var month = t.getMonth()+1;
		var day = t.getDate();
		var rvnid = <%= request.getParameter("rnvid") %>;
		if(<%= request.getParameter("year") %> != null){
			year = <%= request.getParameter("year") %>;
			month = <%= request.getParameter("month") %>;
			day = <%= request.getParameter("day") %>;
		}
		var today = year + "-" + month + "-" + day;
		$.ajax({
			type : "POST",
			url : "OrderAvailable",
			data : {
				rvnID : rvnid,
				rvnDate : today
			},
			dataType : "json",
			success : function(data) {
				var list="<tr><th>";
				if(rvnid == 1){
					list += "篮球";
				}else if(rvnid == 2){
					list += "乒乓球";
				}else if(rvnid == 3){
					list += "羽毛球";
				}else if(rvnid == 4){
					list += "排球";
				}
				list += " / " + today;
				list += "</th><th>场地1</th><th>场地2</th><th>场地3</th><th>场地4</th></tr>";
				$("#reservation-table").append(list);
				for (var j = 0; j < 8; j++) {
					var item = "<th>" + (j + 12) + ":00 - " + (j + 13) + ":00</th>";
					for (var i = 0; i < 4; i++) {
						if (data[i][j] != 0) {
							item += "<td><a href='orderadd.jsp?rvnRoom="+(i+1)+"&rvnTime="+(j+1)+"&rvnId="+
									rvnid+"&rvnPrice="+data[i][j]+"&year="+ year+"&month="+month+"&day="+day+
									"'>"+data[i][j]+"元</a></td>";
						} else {
							item += "<td><a>已预约</a></td>";
						}
					}
					$("#reservation-table").append("<tr>" + item + "<tr>");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		});
	}
	</script>
</body>
</html>