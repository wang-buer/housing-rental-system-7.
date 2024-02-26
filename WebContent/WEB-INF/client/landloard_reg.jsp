<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
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
 <h4>房东入驻</h4>
   <form id="signupForm" method="post" action="LoginServlet?action=registe2" class="zcform">
  <span  style="color:red">${msg }</span>
        <p class="clearfix">
        	<label class="one" for="realname">姓名：</label>
        	<input id="realname" name="realname" type="text" value="${realname }" class="required" placeholder="请输入您的姓名" />
        	 <span id="msg1" style="color:red"></span>
        </p>
       
        
        <p class="clearfix">
        	<label class="one" for="phone">手机号：</label>
        	<input id="phone" name="phone" type="text" class="required"  value="${phone }"  placeholder="请输入您的手机号" />
        	  <span id="msg2" style="color:red"></span>
        </p>
       
        <p class="clearfix">
        	<label class="one" for="agent">性别：</label>
        	<select name="sex" style="width:180px;height:30px;border:1px solid #000">
        	<option value="男"> 男</option>
        		<option value="女"> 女</option>
        	</select>
        
        </p>
        
        
        
        <p class="clearfix">
         	<label class="one"  for="pwd">登录密码：</label>
        	<input id="pwd" name="pwd" type="password" class="{required:true,rangelength:[8,20],}" value placeholder="请输入密码" />
        	 <span id="msg4" style="color:red"></span>
        </p>
        
        <p class="clearfix">
        	<label class="one" for="rpwd">确认密码：</label>
        	<input id="rpwd" name="rpwd" type="password" class="{required:true,equalTo:'#password'}" value placeholder="请再次输入密码" />
        	 <span id="msg5" style="color:red"></span>
        </p>
        
        <!--<p class="clearfix agreement">
        	<input type="checkbox" />
            <b class="left">已阅读并同意<a href="#">《用户协议》</a></b>
        </p>-->
       	<p class="clearfix"><input class="submit" id="registe" type="submit" style="width:180px;height:40px;" value="立即注册"/></p>  
    </form>
    <div class="reg-logo-right">
     <h3>如果您已有账号，请</h3>
     <a href="CommonServlet?action=toLogin" class="logo-a">立即登录</a>
    </div><!--reg-logo-right/-->
    <div class="clears"></div>
  </div>
  </div>
 </div>
 <jsp:include page="/WEB-INF/common/footer.jsp"/>
<script>
$(function(){
	$("#registe").click( function() {
	  
	    var realname = $("#realname").val();
	    var phone = $("#phone").val(); 
	    
	    
	    var pwd = $("#pwd").val();
	    var rpwd = $("#rpwd").val();
	   
	    
	    if(!realname) {
            $("#msg1").html("真实姓名不能为空！");
            $("#realname").focus(); // 聚焦
            return false;
        }
	    if(!phone) {
	        $("#msg2").html("手机号不能为空！");
	        $("#phone").focus(); // 聚焦 */
	        return false;
	    } 
	   
	    if(!pwd) {
            $("#msg4").html("密码不能为空！");
            $("#pwd").focus(); // 聚焦
            return false;
        }
	    
	    
       
	     if(!rpwd) {
	            $("#msg5").html("确认密码不能为空！");
	            $("#rpwd").focus(); // 聚焦
	            return false;
	    }
	 
	     if(rpwd!=pwd) {
	            $("#msg4").html("两次密码不一致！");
	            $("#pwd").focus(); // 聚焦
	            $("#rpwd").focus(); // 聚焦
	            return false;
	        }
	});
})


</script>

</body>
</html>
