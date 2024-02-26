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
        <div class="search">


     
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    <th scope="col">预约人</th> 
               
                                    
                    <th scope="col">房源名称</th>
                     <th scope="col">房东</th>
                    <th scope="col">所在楼层</th>
                    <th scope="col">户型</th>
                     <th scope="col">朝向</th>
                    <th scope="col">房屋面积</th>
                    <th scope="col">租房类型</th>
                     <th scope="col">装修风格</th>
                    <th scope="col">租金</th>
                    <th scope="col">所在小区</th>
                
                    <th scope="col">房源地址</th>
                  
        
                    <th scope="col">预约状态</th>
                      <th scope="col">预约时间</th>
                     <th scope="col">联系方式</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${yykfList }" var="y">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                     <td>${y.user.realname}</td>	
			                                  
			                     <td>${y.house.title }</td>
			                      <td>${y.landloard.realname }</td>
			                         <td>${y.house.floor }</td>
			                    <td>${y.house.htype }</td>
			                     <td>${y.house.direction }</td>
			                   <td>${y.house.area }m²</td>
			                   <td>${y.house.rtype }</td>
			                       <td>${y.house.style }</td>
			                   <td>${y.house.price }￥</td>
			                   
			                   <td>${y.house.xq }</td> 
			                   <td>${y.house.address }</td>
			                      <td>    	  
			             <c:if test="${y.status==1 }"><span style="color:blue">预约中</span></c:if>
			             <c:if test="${y.status==0 }"><span style="color:blue">预约失败</span></c:if>          
			              <c:if test="${y.status==2 }"><span style="color:green">预约成功</span></c:if>
			         
			              </td>
			                   <td> <fmt:formatDate value="${y.create_time }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td> 	              
			               
			                   
			                     <td>${y.landloard.phone }</td>			                   
			                    <td>
			                     <a class="btn btn-success btn-sm" href="HouseServlet?action=findAllImgs&fwbh=${y.house.fwbh }">查看图片</a>
			                        <a class="btn btn-info btn-sm" href="YykfServlet?action=agree&id=${y.id }">同意</a>
			                        <a class="btn btn-danger btn-sm" href="YykfServlet?action=disagree&id=${y.id }">拒绝</a>
			                       <%--  <a class="btn btn-danger btn-sm" href="YykfServlet?action=delete&id=${y.id }">删除</a> --%>
			                    </td>
			                </tr>
			 </c:forEach>               

                </tbody>
                
            </table>
                   <div class="page">
            <span class="total float-left page-link">共${tp }条</span>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="YykfServlet?action=yykfMe&p=1">&lt;&lt;</a></li>
                             
                 <c:if test="${cp>1}">
                  <li class="page-item"><a class="page-link" href="YykfServlet?action=yykfMe&p=${cp-1}">上一页</a></li>
                            <a  href="">上一页</a>
                        </c:if>
                        <%--        循环显示页码--%>
                        <c:forEach begin="${cp-2>1 ? (cp-2) :1}" end="${cp+2>tp?tp:(cp+2)}" var="e">
                            <%--            判断是否是当前页--%>
                            <c:if test="${cp==e}">
                            <li class="page-item"><a class="page-link" href="YykfServlet?action=yykfMe&p=${e}">${e}</a></li>
                              
                            </c:if>
                            <c:if test="${cp!=e}">
                        <li class="page-item"><a class="page-link" href="YykfServlet?action=yykfMe&p=${e}">${e}</a></li>
                                                        
                            </c:if>

                        </c:forEach>

                        <%--        判断是否有下一页--%>
                        <c:if test="${cp<tp}">
                         <li class="page-item"><a class="page-link" href="YykfServlet?action=yykfMe&p=${cp+1}">下一页</a></li>                        
                        </c:if>
             
                <li class="page-item"><a class="page-link" href="YykfServlet?action=yykfMe&p=${tp}">&gt;&gt;</a></li>
            </ul>
        </div>
        </div>

 
    </div>
</main>




<script src="static/admin/js/update.js" ></script>
</body>

</html>
