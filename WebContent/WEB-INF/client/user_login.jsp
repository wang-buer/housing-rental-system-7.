<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css"  />
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/common/website_header.jsp"/>

 <div class="list-nav">
  <div class="width1190">
   <div class="list">
    <h3>房源分类</h3>
 <jsp:include page="/WEB-INF/common/top_left.jsp"/>
   </div><!--list/-->
   <ul class="nav">
   <c:forEach items="${navList }" var="n">
     <li><a href="${n.url}">${n.name }</a></li>
   </c:forEach>

    <div class="clears"></div>
   </ul><!--nav/-->
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--list-nav/-->
  <div class="banner" style="background:url(images/ban.jpg) center center no-repeat;"></div>

<div class="content">
  <div class="width1190">
   <div class="reg-logo">
   <form id="signupForm" method="post" action="LoginServlet?action=login&type=1" class="zcform">
        <p class="clearfix">
        	<label class="one" for="phone">手机号：</label>
        	<input id="phone" name="phone" type="text" class="required" value placeholder="请输入您的手机号" />
        	 <span id="msg" style="color:red">${msg }</span>
        	 	 <span id="msg1" style="color:red"></span>
        </p>
        <p class="clearfix">
         	<label class="one"  for="password">登录密码：</label>
        	<input id="pwd" name="pwd" type="pwd" class="{required:true,rangelength:[8,20],}" value placeholder="请输入密码" />
       	 <span id="msg2" style="color:red"></span>
        </p>
        <!--<p class="clearfix agreement">
        	<input type="checkbox" />
            <b class="left">已阅读并同意<a href="#">《用户协议》</a></b>
        </p>-->
       	<p class="clearfix"><input class="submit" id="login" type="submit" style="width:180px;" value="立即登录"/></p>
    </form>
    <div class="reg-logo-right">
     <h3>如果您没有账号，请</h3>
     <a href="CommonServlet?action=toUserReg" class="logo-a">立即注册</a>
    </div><!--reg-logo-right/-->
    <div class="clears"></div>
  </div><!--reg-logo/-->
  </div><!--width1190/-->
 </div><!--content/-->
 

 <jsp:include page="/WEB-INF/common/footer.jsp"/>
 <script>
$(function(){
	$("#login").click( function() {
	  
	
	    var phone = $("#phone").val(); 

	    
	    var pwd = $("#pwd").val();
	   
	    if(!phone) {
	        $("#msg1").html("手机号不能为空！");
	        $("#phone").focus(); // 聚焦 */
	        return false;
	    } 
	   
	    if(!pwd) {
            $("#msg2").html("密码不能为空！");
            $("#pwd").focus(); // 聚焦
            return false;
        }
	    
	    
       
	    
	});
})


</script>

</body>
</html>
