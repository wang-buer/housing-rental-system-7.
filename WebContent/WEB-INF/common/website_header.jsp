<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Author" contect="http://www.webqin.net">
<title>房屋租赁平台</title>
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css"  />
<link rel="stylesheet" href="//unpkg.com/layui@2.6.8/dist/css/layui.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript">
 $(function(){
	 //导航定位
	 $(".nav li:eq(0)").addClass("navCur");
	 })
</script>
</head>

<body> 
 <div class="header">
  <div class="width1190">
   <div class="fl">
   <c:if test="${sessionScope.type==1}">
   您好，欢迎<b>${user.nickname}</b>登录租房平台
   ！</c:if>
   </div>
   <div class="fr">
   <c:if test="${type!=1 }">
    <a href="CommonServlet?action=toUserLogin">租客登录</a> | 
       <a href="CommonServlet?action=toUserReg">租客注册</a> | 
    <a href="CommonServlet?action=toLandLordReg">房东入驻</a> | 
       <a href="CommonServlet?action=toAgencyRegiste">中介入驻</a> | 
    <a href="CommonServlet?action=toLogin" >后台登录</a>  
    </c:if>
    <c:if test="${type==1}">
    <a href="CommonServlet?action=toPersonInfo">个人中心</a> | 
    <a href="LoginServlet?action=loginOut" >退出</a>  
   </c:if>
    <c:if test="${type==2}">

  
    
   </c:if>
   </div>
   <div class="clears"></div>
  </div>
 </div>
  <div class="logo-phone">
  <div class="width1190">
   <h1 class="logo"><a href="CommonServlet?action=toWebsite"><img src="images/zllogo.png" width="163" height="59" /></a></h1>
 <div > <form action="CommonServlet?action=moreHouse2" method="post"> <input type="text" name="title"  style="height:30px;margin-top:10px;"/>&nbsp;<button class="layui-btn layui-btn-normal layui-btn-sm"  type="submit">搜索</button></form></div>
   <!-- <div class="phones"><strong>17766091168</strong></div> -->
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--logo-phone/-->