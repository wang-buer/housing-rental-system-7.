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
            <form class="form-inline float-left" action="UserServlet?action=findByMap" method="post">
                <div class="form-group">
                    <input type="text" name="phone" value="" class="form-control" placeholder="手机号">
                </div>
                
                 <div class="form-group">
                    <input type="text" name="realname" value="" class="form-control" placeholder="真实姓名">
                </div>
                <button type="submit" class="btn btn-primary"><i class="iconfont"></i>搜索</button>
            </form>


            <a class="btn btn-primary float-right" href="UserServlet?action=toAddUser"><i class="iconfont"></i>新增</a>
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
                    <th scope="col">姓名</th>
                    <th scope="col">呢称</th>
                    <th scope="col">登录密码</th>
                    <th scope="col">性别</th>
                    <th scope="col">手机号</th>
                    <th scope="col">注册时间</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${userList }" var="u">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                    <td>${u.realname}</td>
			                    <td>${u.nickname }</td>
			                     <td>${u.pwd }</td>
			                    <td>${u.sex }</td>
			                   
			                    <td>${u.phone }</td>
			                  <td> <fmt:formatDate value="${u.createtime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td> 
			                   
			                    <td>
			                        <a class="btn btn-info btn-sm" href="UserServlet?action=query&id=${u.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" href="UserServlet?action=delete&id=${u.id }">删除</a>
			                    </td>
			                </tr>
			 </c:forEach>               

                </tbody>
                
            </table>
                   <div class="page">
            <span class="total float-left page-link">共${tp }条</span>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="UserServlet?action=list&p=1">&lt;&lt;</a></li>
                             
                 <c:if test="${cp>1}">
                  <li class="page-item"><a class="page-link" href="UserServlet?action=list&p=${cp-1}">上一页</a></li>
                            <a  href="">上一页</a>
                        </c:if>
                        <%--        循环显示页码--%>
                        <c:forEach begin="${cp-2>1 ? (cp-2) :1}" end="${cp+2>tp?tp:(cp+2)}" var="e">
                            <%--            判断是否是当前页--%>
                            <c:if test="${cp==e}">
                            <li class="page-item"><a class="page-link" href="UserServlet?action=list&p=${e}">${e}</a></li>
                              
                            </c:if>
                            <c:if test="${cp!=e}">
                        <li class="page-item"><a class="page-link" href="UserServlet?action=list&p=${e}">${e}</a></li>
                                                        
                            </c:if>

                        </c:forEach>

                        <%--        判断是否有下一页--%>
                        <c:if test="${cp<tp}">
                         <li class="page-item"><a class="page-link" href="UserServlet?action=list&p=${cp+1}">下一页</a></li>                        
                        </c:if>
             
                <li class="page-item"><a class="page-link" href="UserServlet?action=list&p=${tp}">&gt;&gt;</a></li>
            </ul>
        </div>
        </div>

 
    </div>
</main>




<script src="static/admin/js/update.js" ></script>
</body>

</html>
