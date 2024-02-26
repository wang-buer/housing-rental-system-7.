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
          

            <a class="btn btn-success float-right" href="NavServlet?action=list">返回主界面</a>
        </div>

        <div class="table-box">

<span style="color:red">${msg}</span>
         <table class="table" >
                <thead>
                <tr>
                    
                    <th scope="col">导航栏名称</th>
                    <th scope="col">跳转路径</th>
                      <th scope="col">路径说明</th>
                          <th scope="col">排序</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="n">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                    <td>${n.name}</td>
			                    <td>${n.url}</td>
			                      <td>${n.note}</td>
			                          <td>${n.px}</td>
		                    <td>
			                        <a class="btn btn-info btn-sm" href="NavServlet?action=query&id=${n.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" href="NavServlet?action=delete&id=${n.id }">删除</a>
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
