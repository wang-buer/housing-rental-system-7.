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
              <a class="btn btn-success float-right" href="LandloardServlet?action=list">返回主界面</a>
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
                    <th scope="col">姓名</th>
                   
                    <th scope="col">登录密码</th>
                    <th scope="col">性别</th>
                    <th scope="col">手机号</th>
                    <th scope="col">注册时间</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="u">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                    <td>${u.realname}</td>
			                  
			                     <td>${u.pwd }</td>
			                    <td>${u.sex }</td>
			                   
			                    <td>${u.phone }</td>
			                  <td> <fmt:formatDate value="${u.createtime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td> 
			                   
			                    <td>
			                        <a class="btn btn-info btn-sm" href="LandloardServlet?action=query&id=${u.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" href="LandloardServlet?action=delete&id=${u.id }">删除</a>
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
