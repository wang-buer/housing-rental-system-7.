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
          <a class="btn btn-success float-right" href="YykfServlet?action=list">返回主界面</a>     
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

			<c:forEach items="${list }" var="y">
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
			                       
			                        <a class="btn btn-danger btn-sm" href="YykfServlet?action=delete2&id=${y.id }">删除</a>
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
