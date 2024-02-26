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
   <div class="contleft">
    <ul class="leftNav">
     <li><a href="CommonServlet?action=toAbout">关于我们</a></li>
     <li class="leftNavCur"><a href="CommonServlet?action=toContact">联系我们</a></li>
    </ul><!--leftNav/-->
   </div><!--contleft/-->
   <div class="contright">
    <h2 class="rightat">联系我们</h2>
    <div class="about">
     <img src="images/about.jpg" /><br />
   
    </div>
   </div><!--contright/-->
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 

 <jsp:include page="/WEB-INF/common/footer.jsp"/>
 

</body>
</html>
