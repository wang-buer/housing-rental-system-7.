<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     　　<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>


 <jsp:include page="/WEB-INF/common/form_header.jsp"/>
<body>
<style>
th,tr,td{    border: 1px solid #ced4da;}
</style>

<main>
    <div class="main">
       
        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
                    <th scope="col">房源编号</th>                 
                    <th scope="col">房源名称</th>
                     <th scope="col">房东</th>
                    <th scope="col">楼层</th>
                    <th scope="col">户型</th>
                     <th scope="col">朝向</th>
                    <th scope="col">面积</th>
                    <th scope="col">租房类型</th>
                        <th scope="col">装修风格</th>
                    <th scope="col">租金</th>
                    <th scope="col">所在小区</th>
                    <th scope="col">房源地址</th>
                    <th scope="col">发布日期</th>
                    <th scope="col">房源状态</th>
                     <th scope="col">联系方式</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="h">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                    <td>${h.fwbh}</td>			                  
			                     <td>${h.title }</td>
			                      <td>${h.realname }</td>
			                        <td>${h.floor }</td>
			                    <td>${h.htype }</td>
			                      <td>${h.direction }</td>
			                   < <td>${h.area }m²</td>
			                   <td>${h.rtype }</td>
			                     <td>${h.style }</td>
			                   <td>${h.price }￥</td>		                 			              
			                   <td>${h.xq }</td> 
			                   <td>${h.address }</td>
			                       <td> <fmt:formatDate value="${h.fbrq }" pattern="yyyy-MM-dd "></fmt:formatDate></td> 	              
			              <td><c:if test="${h.status==0 }"><span style="color:green">出租中</span></c:if><c:if test="${h.status==1 }"><span style="color:red">已出租</span></c:if></td>
			                     <td>${h.phone }</td>
			                    <td>
			                     <a class="btn btn-success btn-sm" href="HouseServlet?action=findAllImgs&fwbh=${h.fwbh }">查看图片</a>
			                        <a class="btn btn-info btn-sm" href="HouseServlet?action=query&id=${h.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" href="HouseServlet?action=delete&id=${h.id }">删除</a>
			                    </td>
			                </tr>
			 </c:forEach>               

                </tbody>
                
            </table>
        
        </div>

 
    </div>
</main>




<script src="static/admin/js/update.js" ></script>
</body>

</html>
