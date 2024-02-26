<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css"  />
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      　　<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  
 <jsp:include page="/WEB-INF/common/top.jsp"/>
 
  <div class="width1190">
   <div class="pro-left">
   <c:forEach items="${houseList}" var="h">
    <dl>
     <dt><a href="HouseServlet?action=detail&id=${h.id }"><img src="upload/${h.imgs.img_url }" width="286" height="188" /></a></dt>
     <dd>
      <h3><a href="HouseServlet?action=detail&id=${h.id }">${h.title }</a></h3>
      <div class="pro-wei">
       <img src="images/weizhi.png" width="12" height="16" /> <strong class="red">${h.xq }</strong>
      </div>
      <div class="pro-fang">${h.htype }| ${h.area }平 ${h.direction } 楼层${h.floor }层</div>
        <div class="pro-fang">中介：${h.agency.agentstore} |${h.agency.realname }，联系电话:${h.agency.phone }</div>
      <div class="pra-fang">发布人：${h.landloard.realname } 发布日期：<fmt:formatDate value="${h.fbrq }" pattern="yyyy-MM-dd "></fmt:formatDate></div>
     </dd>
     <div class="price"> <img src="upload/${h.agency.tx}" style="width:50px;height:70px;"/>¥ <strong>${h.price }</strong><span class="font12">元/月</span></div>
     <div class="clears"></div>
    </dl>
    </c:forEach>
   
   </div><!--pro-left/-->
   <div class="pro-right">
    <h2 class="right-title">我浏览的足迹</h2>
    <div class="right-pro">
    
    <c:forEach items="${lastlylist}" var="l">
     <dl>
      <dt><a href="HouseServlet?action=detail&id=${l.id }"><img src="upload/${l.imgs.img_url }" /></a></dt>
      <dd>
       <h3><a href="HouseServlet?action=detail&id=${l.id }">${l.title }</a></h3>
       <div class="pro-fang">${l.htype }| ${l.area }平 ${l.direction } 楼层${l.floor }层</div>
       <div class="right-price">${l.price }元/月</div>
      </dd>
     </dl>
     </c:forEach>
    
    </div><!--right-pro/-->
   </div><!--pro-right/-->
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--content/-->

 <jsp:include page="/WEB-INF/common/footer.jsp"/>
 

</body>
</html>
