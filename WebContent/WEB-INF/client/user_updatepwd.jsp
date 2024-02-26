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
<jsp:include page="/WEB-INF/common/left.jsp"/>
    <div class="vip-right">
     <h3 class="vipright-title">修改密码</h3>
      <form action="UserServlet?action=updateUserPwd" method="post">
        <input type="hidden" name="id" value="${user.id }" />
     <table class="grinfo">
      <tbody>
        <tr>
        <th>原手机号：</th>
        <td> <strong>${user.phone }</strong></td>
        </tr>
      
        <tr>
        <th>新密码：</th>
        <td>
        <input class="inp inw" type="password" id="newpwd" name="pwd" placeholder="不少于6位">
        <span id="msg1" style="color:red"></span>
        </td>
        </tr>
        <tr>
        <th>重复新密码：</th>
        <td>
        <input class="inp inw" type="password" id="repwd" placeholder="不少于6位">
        <span id="msg2" style="color:red"></span>
             <span id="msg3" style="color:red"></span>
        </td>
        </tr>
        <tr>
        <th>&nbsp;</th>
        <td colspan="2">
        <label class="butt" id="butt">
        <input  type="submit" id="update" value="确认修改"/>
      
        </label>
        </td>
        </tr>
        </tbody>
     </table>
     </form>
    </div><!--vip-right/-->
    <div class="clearfix"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 
 
 

 <jsp:include page="/WEB-INF/common/footer.jsp"/>
 
<script>
$(function(){
	$("#update").click( function() {
	  
	    var newpwd = $("#newpwd").val();
	    var repwd = $("#repwd").val(); 
	 
	    
	    if(!newpwd) {
            $("#msg1").html("新密码不能为空！");
            $("#newpwd").focus(); // 聚焦
            return false;
        }
	  
	    if(!repwd) {
            $("#msg2").html("重复密码不能为空！");
            $("#repwd").focus(); // 聚焦
            return false;
        }
	    if(newpwd!=repwd) {
            $("#msg3").html("两次密码不一致！");
            $("#newpwd").focus(); // 聚焦
            $("#repwd").focus(); // 聚焦
            return false;
        }
	    
	    
       
	    
	
	});
})


</script>
</body>
</html>
