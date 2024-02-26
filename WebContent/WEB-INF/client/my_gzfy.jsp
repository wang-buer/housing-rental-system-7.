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
     <h3 class="vipright-title">我关注房源</h3>
     <ul class="guanzhueq">
      <li class="guanzhueqcur"><a href="javascript:;">租房</a></li>
     
      <div class="clearfix"></div>
     </ul><!--guanzhueq/-->
     <div class="guanzhulist">
     <c:forEach items="${gzfylist }" var="g">
      <dl>
       <dt><a href=""><img src="upload/${g.imgs.img_url }" width="190" height="128" /></a></dt>
       <dd>
        <h3><a href="HouseServlet?action=detail&id=${g.house.id }">${g.house.title }</a></h3>
        <div class="guantext">${g.house.xq }</div>
        <div class="guantext">${g.house.htype } | ${g.house.area }平米 | ${g.house.direction }</div>
        <div class="guantext2">关注时间：<fmt:formatDate value="${g.gzsj }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>   <a href="GzfyServlet?action=delete&id=${g.id}" class="qxgz">取消关注</a></div>
       </dd>
       <div class="price">¥ <strong>${g.house.price }</strong><span class="font12">元/月</span></div>
       <div class="clearfix"></div>
      </dl>
      </c:forEach>
  
     </div><!--guanzhulist/-->
    
    </div><!--vip-right/-->
    <div class="clearfix"></div>
  </div><!--width1190/-->
 </div><!--content/-->

 <jsp:include page="/WEB-INF/common/footer.jsp"/>
 

</body>
</html>
