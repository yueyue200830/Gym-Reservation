<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center><h1>百货商场</h1></center>
  <hr>
  <form action="Shopping" method="POST">
    选购商品
    <p><input type="checkbox" name="item" value="0">
      第一种：Oracle数据库</p>
    <p><input type="checkbox" name="item" value="1">
      第二种：MP5</p>
    <p><input type="checkbox" name="item" value="2">
      第三种：饼干</p>
    <hr>
    <input type="submit" name="submit" value="加入购物车">
  </form>
  <% 
Integer counter=(Integer)application.getAttribute("counter");
if(counter!=null){
%>

当前在线人数为：<%=counter %> <br>
<% } %>
  
</body>
</html>