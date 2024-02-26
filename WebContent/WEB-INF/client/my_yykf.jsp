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
  <div class="banner" style="background:url(images/ban.jpg) center center no-repeat;"></div>


 <div class="content">
  <div class="width1190">
  <jsp:include page="/WEB-INF/common/left.jsp"/>
    <div class="vip-right">
     <h3 class="vipright-title">我的预约看房记录</h3>
     <ul class="guanzhueq">
      <li class="guanzhueqcur"><a href="javascript:;">我的预约</a></li>
     
      <div class="clearfix"></div>
     </ul><!--guanzhueq/-->
     <div class="guanzhulist">
     <c:forEach items="${yykflist }" var="y">
      <dl>
       <dt><a href=""><img src="upload/${y.imgs.img_url }" width="190" height="128" /></a></dt>
       <dd>
        <h3><a href="proinfo.html">${y.house.title }</a></h3>
        <div class="guantext">${y.house.xq }</div>
        <div class="guantext">${y.house.htype } | ${g.house.area }平米 | ${y.house.direction }</div>
           <div class="guantext2">中介姓名:${y.agency.realname }|手机号：${y.agency.phone}</div>   
        <div class="guantext2">预约时间：<fmt:formatDate value="${y.create_time }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>   <a href="YykfServlet?action=delete&id=${y.id}" class="qxgz">取消预约</a></div>
        
       </dd>
          <div class="price"><img src="upload/${y.agency.tx }" width="80" height="120" /></div>
       <div ><h4 style="color:red">¥ <strong>${y.house.price }</strong><strong></strong><span class="font12">元/月</span></div></h4>
       <p>预约状态：<span style="color:green"><c:if test="${y.status==0 }">预约失败</c:if><c:if test="${y.status==1 }">预约中</c:if><c:if test="${y.status==2 }">预约成功</c:if></span></p>
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
