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
  <div class="width1190" style="width:1000px;">
   <div class="proImg fl">
    <img src="upload/${house.imgs.img_url }" />
   </div><!--proImg/-->
   <div class="proText fr">
    <h4 class="proTitle">${house.title } </h4>
    <div class="proText1">
     编号：${house.fwbh }<br />
     户型：${house.htype }<br />
     面积：${house.area }㎡<br />
     朝向：${house.direction }<br />
     楼层：${house.floor }层<br />
     装修：${house.style }<br />
     小区：${house.xq }<br />
      地址：${house.address }  
    </div>
    <div class="xun-car">
     <a href="javascript:;" class="xwjg">租金：¥<strong>${house.price }</strong>元</a>
     <a href="GzfyServlet?action=gzfy&hid=${house.id}" class="projrgwc">关注房源</a>
     
    </div><!--xun-car/-->
   </div><!--proText/-->
   <div class="clears"></div>
  </div><!--width1190/-->
  <div class="proBox" style="width:1000px;margin:10px auto;">
  <div class="proEq">
   <ul class="fl">
    <li class="proEqCur">房源详情</li>
    <li>房源图片</li>
    <li>中介信息</li>
   </ul>
   <div class="lxkf fr"><a href="http://wpa.qq.com/msgrd?v=3&uin=1072631488&site=qq&menu=yes" target="_blank"></a></div>
   <div class="clears"></div>
  </div><!--proEq/-->
  <div class="proList">
  ${house.detail }
 <br />
<br />
<c:forEach items="${imgsList}" var="i">
     <img src="upload/${i.img_url}" style="width:250px;height:180px;"/>
  </c:forEach>
<!--  <img src="images/fang1.jpg" /><img src="images/fang2.jpg" /><img src="images/fang3.jpg" /><img src="images/fang4.jpg" /><img src="images/fang5.jpg" /><img src="images/fang6.jpg" /><img src="images/fang7.jpg" /><img src="images/fang8.jpg" />
 -->  </div><!--proList/-->
  <div class="proList">
  <c:forEach items="${imgsList}" var="i">
     <img src="upload/${i.img_url}"  style="width:250px;height:180px;"/>
  </c:forEach>

  </div><!--proList/-->
    <div class="proList">
  
     <img src="upload/${agency.tx}"  style="width:180px;height:250px;"/>
 联系方式：${agency.realname}-${agency.phone }

 <form action="YykfServlet?action=addYykf" method="post">
 <input type="hidden" name="h_id" value="${house.id }"/>
 <input type="hidden" name="a_id" value="${agency.id }"/>
 <input type="submit" value="预约看房"/>
 </form>

 <%--  <a href="&h_id=${house.id }&a_id=${agency.id}" style="color:red">预约看房</a> --%>
  </div><!--proList/-->
 </div><!--proBox/-->
 </div><!--content/-->
 

 <jsp:include page="/WEB-INF/common/footer.jsp"/>
 

</body>
</html>
