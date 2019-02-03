<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>场馆介绍</title>
	
	<link href="Hello.css" rel="stylesheet">
	<link href="settled.css" rel="stylesheet">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link href="news.css" rel="stylesheet">
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
          <li class="nav-item active">
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
    <div id="ns" class="center table-show col-lg-12">
    	<div class="center_tbl col-md-12">
    		<div class="card flex-md-row mb-4 box-shadow h-md-250">
    			<div class="card-body d-flex flex-column align-items-start"> 
    				<h3 class="mb-0">篮球馆</h3>
    				<div class="mb-1 text-muted">
    					
    				</div>
    				<p class="card-text mb-auto">
    					2700平方米超大公共空间，净高11米，
						无柱空间使展览功能发挥到最大；场馆顶部配有64盏防炫灯，
						符合照度标准；地板采用比赛用全实木地板，常年维持25度的室内温度；
						3个出入口，其中东门可出入小型车辆；2个安全出口，消防设备2组，保证基本安全需求
    				</p>
    			</div>
    			<img class="card-img-right flex-auto d-none d-md-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: auto; height: 250px;" src="images/lanqiu.jpg" data-holder-rendered="true">
    		</div>
    	</div>
    	<div class="center_tbl col-md-12">
    		<div class="card flex-md-row mb-4 box-shadow h-md-250">
    			<div class="card-body d-flex flex-column align-items-start"> 
    				<h3 class="mb-0">乒乓球馆</h3>
    				<div class="mb-1 text-muted">
    					
    				</div>
    				<p class="card-text mb-auto">
    					球馆创建于2009年夏。该馆地理位置优越，条件一流，
						可承接各种规模的乒乓球比赛，并有强大的教练团队执教，常年招收各层次乒乓球学员。
						球馆内打折出售各类乒乓球用品，球衣、球鞋、底板、套胶、
						乒乓球桌等各类器械均低价出售，货真价实，并支持大量团购。
    				</p>
    			</div>
    			<img class="card-img-right flex-auto d-none d-md-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: auto; height: 250px;" src="images/pinpang.jpg" data-holder-rendered="true">
    		</div>
    	</div>
    	<div class="center_tbl col-md-12">
    		<div class="card flex-md-row mb-4 box-shadow h-md-250">
    			<div class="card-body d-flex flex-column align-items-start"> 
    				<h3 class="mb-0">羽毛球馆 </h3>
    				<div class="mb-1 text-muted">
    					
    				</div>
    				<p class="card-text mb-auto">
    					该球馆净高9米，设有16片塑胶羽毛球场地，球馆地面为双层龙骨加双层地板，
						上铺专业地胶，增加了运动弹力。场地间隔1米，场地距离后墙休息区3米。
						球馆内灯光设计是国际最新流行的侧面强烈柔和型的灯光，运动时防止了刺眼和眩光；
						室内的墙壁为国际时尚的墨绿色，以减轻视觉疲劳。馆内配套有更衣室、淋浴室和卫生间。
    				</p>
    			</div>
    			<img class="card-img-right flex-auto d-none d-md-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: auto; height: 250px;" src="images/yumaoqiu.jpg" data-holder-rendered="true">
    		</div>
    	</div>
    	<div class="center_tbl col-md-12">
    		<div class="card flex-md-row mb-4 box-shadow h-md-250">
    			<div class="card-body d-flex flex-column align-items-start"> 
    				<h3 class="mb-0">排球馆 </h3>
    				<div class="mb-1 text-muted">
    					
    				</div>
    				<p class="card-text mb-auto">
    					排球场长度为18米，宽度为9米。四周至少有3米宽的无障碍区。
						排球场地地面为塑胶场地。排球场地地面也有土质、水泥、沥青和木质等。
						不论是采用木板地面还是合成材料地面，都必须保证运动员在比赛中不感到太滑或太粘，
						并有一定的弹性。
    				</p>
    			</div>
    			<img class="card-img-right flex-auto d-none d-md-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: auto; height: 250px;" src="images/paiqiu.jpg" data-holder-rendered="true">
    		</div>
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
	
</body>
</html>