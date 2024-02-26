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
   <h2 class="title">最新房源 <a href="CommonServlet?action=moreHouse">更多&gt;&gt;</a></h2>
   <div class="index-fang-list">
   <c:forEach items="${houseList}" var="h">
    <dl>
     <dt><a href="HouseServlet?action=detail&id=${h.id }"><img src="upload/${h.imgs.img_url }" width="286" height="188" /></a></dt>
     <dd>
      <h3><a href="#"></a>${h.title }</h3>
      <div class="hui">${h.htype } | ${h.area }m² | 精装修</div>
     </dd>
     
    </dl>
     </c:forEach>   
   </div>
  <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 <div class="xinren">
  <div class="width1190">
   <dl style="background:url(images/icon1.jpg) left center no-repeat;">
    <dt>承诺</dt>
    <dd>真实可信100%真房源<br />链家承诺，假一赔百</dd>
   </dl>
   <dl style="background:url(images/icon2.jpg) left center no-repeat;">
    <dt>权威</dt>
    <dd>独家房源 覆盖全城<br />房源信息最权威覆盖最广</dd>
   </dl>
   <dl style="background:url(images/icon3.jpg) left center no-repeat;">
    <dt>信赖</dt>
    <dd>万名置业顾问 专业服务<br />百万家庭的信赖之选</dd>
   </dl>
   <dl style="background:url(images/icon4.jpg) left center no-repeat;">
    <dt>安全</dt>
    <dd>安心承诺 保驾护航<br />多重风险防范机制 无后顾之忧</dd>
   </dl>
   <div class="clears"></div>
  </div>
 </div>
 <jsp:include page="/WEB-INF/common/footer.jsp"/>
 

</body>
</html>
