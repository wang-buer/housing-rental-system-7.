<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>房屋租赁后台</title>
    <link rel="icon" href="<%=path%>/static/favicon.ico">
    <link rel="stylesheet" href="<%=path%>/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/static/admin/css/login.css">
    <script src="<%=path%>/static/js/vue.min.js"></script>
    <script src="<%=path%>/static/js/jquery-3.3.1.min.js"></script>
    <script src="<%=path%>/static/bootstrap/js/bootstrap.bundle.js"></script>
</head>
<body>
<div class="login"  style="height:500px;">
    <form action="LoginServlet?action=login" method="post">
        <h2>房屋租赁系统</h2>
        <div class="form-group">
            <label>手机号</label>
            <input type="text" name="phone" id="phone" class="form-control form-control-lg">
        </div>
       <span style="color:red;" id="msg">${msg}</span>
        <div class="form-group">
            <label>密码</label>
            <input type="password" name="pwd" id="pwd" class="form-control form-control-lg" id="pwd">
        </div>
          <span style="color:red;" id="msg2"></span>
         <div class="form-group">
             <label>
              <input type="radio" value="2" name="type" data-title="房东"/>房东&emsp;
         </label>
         <label>
              <input type="radio" value="3" name="type" data-title="中介"/>中介&emsp;
         </label>
  			<label>
              <input type="radio" value="4" name="type" data-title="管理员" checked/>管理员
         </label>
        </div>
      <!--  <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">记住密码</label>
        </div> -->

        <button type="submit" id="login" class="btn btn-primary btn-lg  btn-block">
    
            立即登录
        </button>
        
         <button type="button" onclick="location.href='CommonServlet?action=toWebsite'" class="btn btn-success btn-lg  btn-block">
    
          返回首页
        </button>
    </form>
</div>

<p style="position: fixed;bottom: 0;text-align: center; width: 100%;">

</p>
<script src="<%=path %>/static/js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	$("#login").click( function() {
	    var phone = $("#phone").val().trim(); // trim()去除空格
	    var pwd = $("#pwd").val().trim();
	   
	    if(!phone) {
	        $("#msg").html("手机号不能为空！");
	       /*  $("#username").focus(); // 聚焦 */
	        return false;
	    } 
        if($("#phone").focus()){
        	 $("#msg").html("");
        }; // 聚焦
	  
	     if(!pwd) {
	            $("#msg2").html("密码不能为空！");
	            $("#pwd").focus(); // 聚焦
	            return false;
	   } else {
	            $("#msg2").html("");
	     }
	 
	});
})


</script>

</body>
</html>
