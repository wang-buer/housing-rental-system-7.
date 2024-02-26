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
            <form class="form-inline float-left" action="HouseServlet?action=findHouseByMap" method="post">
                <div class="form-group">
                    <input type="text" name="xq" value="" class="form-control" placeholder="小区">
                </div>
                
                 <div class="form-group">
                    <input type="text" name="address" value="" class="form-control" placeholder="地址">
                </div>
                <button type="submit" class="btn btn-primary"><i class="iconfont"></i>搜索</button>
            </form>

<c:if test="${type==2 }">
            <a class="btn btn-primary float-right" href="HouseServlet?action=toAddHouse"><i class="iconfont"></i>发布房源</a>
       </c:if>
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
                    <th scope="col">房源编号</th>   
                                  
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
                   <c:if test="${type==3 }">
                    <th scope="col">房源地址</th>
                    </c:if>
                    <th scope="col">发布日期</th>
                    <th scope="col">房源状态</th>
                    <th scope="col">委托中介</th>
                       <c:if test="${type==3 }">
                     <th scope="col">联系方式</th>
                     </c:if>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${houseList }" var="h">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                    <td>${h.fwbh}</td>			                  
			                     <td>${h.title }</td>
			                      <td>${h.realname }</td>
			                         <td>${h.floor }</td>
			                    <td>${h.htype }</td>
			                     <td>${h.direction }</td>
			                   <td>${h.area }m²</td>
			                   <td>${h.rtype }</td>
			                       <td>${h.style }</td>
			                   <td>${h.price }￥</td>
			                   
			                   <td>${h.xq }</td> 
			                   <c:if test="${type==3 }">
			                   <td>${h.address }</td>
			                   </c:if>
			                       <td> <fmt:formatDate value="${h.fbrq }" pattern="yyyy-MM-dd "></fmt:formatDate></td> 	              
			              <td><c:if test="${h.status==0 }"><span style="color:green">出租中</span></c:if><c:if test="${h.status==1 }"><span style="color:red">已出租</span></c:if></td>
			                      <td>${h.agentstore }</td>
			                       <c:if test="${type==3 }">
			                     <td>${h.phone }</td>	
			                     </c:if>		                   
			                    <td>
			                     <a class="btn btn-success btn-sm" href="HouseServlet?action=findAllImgs&fwbh=${h.fwbh }">查看图片</a>
			                  <%--      <c:if test="${h.status==0 }">
			                        <a class="btn btn-primary btn-sm" href="HouseServlet?action=pass&id=${h.id }">通过</a>
			                        </c:if> --%>
			                        <a class="btn btn-info btn-sm" href="HouseServlet?action=query&id=${h.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" href="HouseServlet?action=delete&id=${h.id }">删除</a>
			                    </td>
			                </tr>
			 </c:forEach>               

                </tbody>
                
            </table>
                   <div class="page">
            <span class="total float-left page-link">共${tp }条</span>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="HouseServlet?action=list&p=1">&lt;&lt;</a></li>
                             
                 <c:if test="${cp>1}">
                  <li class="page-item"><a class="page-link" href="HouseServlet?action=list&p=${cp-1}">上一页</a></li>
                            <a  href="">上一页</a>
                        </c:if>
                        <%--        循环显示页码--%>
                        <c:forEach begin="${cp-2>1 ? (cp-2) :1}" end="${cp+2>tp?tp:(cp+2)}" var="e">
                            <%--            判断是否是当前页--%>
                            <c:if test="${cp==e}">
                            <li class="page-item"><a class="page-link" href="HouseServlet?action=list&p=${e}">${e}</a></li>
                              
                            </c:if>
                            <c:if test="${cp!=e}">
                        <li class="page-item"><a class="page-link" href="HouseServlet?action=list&p=${e}">${e}</a></li>
                                                        
                            </c:if>

                        </c:forEach>

                        <%--        判断是否有下一页--%>
                        <c:if test="${cp<tp}">
                         <li class="page-item"><a class="page-link" href="HouseServlet?action=list&p=${cp+1}">下一页</a></li>                        
                        </c:if>
             
                <li class="page-item"><a class="page-link" href="HouseServlet?action=list&p=${tp}">&gt;&gt;</a></li>
            </ul>
        </div>
        </div>

 
    </div>
</main>




<script src="static/admin/js/update.js" ></script>
</body>

</html>
