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
            <form class="form-inline float-left" action="NavServlet?action=findByMap" method="post">
                <div class="form-group">
                    <input type="text" name="name" value="" class="form-control" placeholder="导航栏名称">
                </div>
                
                <button type="submit" class="btn btn-primary"><i class="iconfont"></i>搜索</button>
            </form>


            <a class="btn btn-primary float-right" href="NavServlet?action=toAddNav"><i class="iconfont"></i>新增导航栏</a>
        </div>

        <div class="table-box">


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

			<c:forEach items="${navList }" var="n">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                    <td>${n.name}</td>
			                    <td>${n.url}</td>
			                     <td>${n.note}</td>
			                      <td>${n.px}</td>
		                    <td>
			                        <a class="btn btn-info btn-sm" href="NavServlet?action=query&id=${n.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" onClick="del_nav(this,'${n.id }')" href="javascript:;">删除</a>
			                    </td>
			                </tr>
			 </c:forEach>               

                </tbody>
                
            </table>
                   <div class="page">
            <span class="total float-left page-link">共${tp }条</span>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="NavServlet?action=list&p=1">&lt;&lt;</a></li>
                             
                 <c:if test="${cp>1}">
                  <li class="page-item"><a class="page-link" href="NavServlet?action=list&p=${cp-1}">上一页</a></li>
                            <a  href="">上一页</a>
                        </c:if>
                        <%--        循环显示页码--%>
                        <c:forEach begin="${cp-2>1 ? (cp-2) :1}" end="${cp+2>tp?tp:(cp+2)}" var="e">
                            <%--            判断是否是当前页--%>
                            <c:if test="${cp==e}">
                            <li class="page-item"><a class="page-link" href="NavServlet?action=list&p=${e}">${e}</a></li>
                              
                            </c:if>
                            <c:if test="${cp!=e}">
                        <li class="page-item"><a class="page-link" href="NavServlet?action=list&p=${e}">${e}</a></li>
                                                        
                            </c:if>

                        </c:forEach>

                        <%--        判断是否有下一页--%>
                        <c:if test="${cp<tp}">
                         <li class="page-item"><a class="page-link" href="NavServlet?action=list&p=${cp+1}">下一页</a></li>                        
                        </c:if>
             
                <li class="page-item"><a class="page-link" href="NavServlet?action=list&p=${tp}">&gt;&gt;</a></li>
            </ul>
        </div>
        </div>

 
    </div>
</main>




<script src="static/admin/js/update.js" ></script>
<script type="text/javascript">
function del_nav(obj,id){
	 //用户安全提示
    if(confirm("您确定要删除该条记录吗？")){
        //访问路径
        location.href="${pageContext.request.contextPath}/NavServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
