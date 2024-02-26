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
        <c:if test="${type==4 }">
    <a class="btn btn-success float-right" href="HouseServlet?action=list">返回主界面</a>
</c:if>
  <c:if test="${type==2 }">
    <a class="btn btn-success float-right" href="HouseServlet?action=findMyHouse&l_id=${landloard.id}">返回主界面</a>
</c:if>
            <table class="table" >
                <thead>
                <tr>
                    
                    <th scope="col">房源编号</th>                 
                    <th scope="col">房源图片</th>
                    
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="h">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                    <td>${h.fwbh}</td>			                  
			                     <td><img src="upload/${h.img_url}" style="width:200px;height:150px;"/></td>		                   			                      
			                    <td>
			                 		<a class="btn btn-primary btn-sm" href="HouseServlet?action=query2&id=${h.id }">修改</a>			                 
			                        <a class="btn btn-danger btn-sm" href="HouseServlet?action=deleteImgs&id=${h.id }&fwbh=${h.fwbh}">删除</a>
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
