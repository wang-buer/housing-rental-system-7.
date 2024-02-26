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
                       <a class="btn btn-success float-right" href="HouseServlet?action=list"><i class="arrow-left-bold"></i>返回主界面</a>
           

 <c:if test="${type==4}">	 
            <a class="btn btn-primary float-right" href="AgencyServlet?action=toAddAgency"><i class="iconfont"></i>添加中介</a>
    </c:if>  
        </div>

        <div class="table-box">


            <table class="table" >
                <thead>
                <tr>
                    
                    <th scope="col">中介姓名</th>
                    <th scope="col">性别</th>
                     <th scope="col">头像</th>
                      <th scope="col">工作年限</th>
                       <th scope="col">个人说明</th>
                        <th scope="col">身份证号</th>
                           <th scope="col">学历</th>
                              <th scope="col">QQ</th>
                                 <th scope="col">身份状态</th>
                                   <th scope="col">中介代理商</th>    
                    <th scope="col">联系方式</th>
                     <c:if test="${type==4}">	   
                      <th scope="col">操作</th>
                      </c:if>
                </tr>
                </thead>
                <tbody>

			<c:forEach items="${list }" var="a">
			                <tr>
			                  <!--   <th scope="row">1</th> -->
			                    <td>${a.realname}</td>
			                    <td>${a.sex}</td>
			                     <td><img src="upload/${a.tx}" style="width:60px;height:80px;"/></td>
			                     <td>${a.gznx}</td>
			                    <td>${a.note}</td>
			                   <td>${a.cno}</td>
			                  <td>${a.education}</td>
			                 <td>${a.qq}</td>
			                 <td><c:if test="${a.status==0 }"><span style="color:green">审核中</span></c:if><c:if test="${a.status==1 }"><span style="color:red">正常</span></c:if></td>
		                     <td>${a.agentstore}</td>	
		                          <td>${a.phone}</td>		   
		                           <c:if test="${type==4}">	                    
		                    <td>
		                    <c:if test="${a.status==0 }">
		                    		<a class="btn btn-success btn-sm" href="AgencyServlet?action=pass&id=${a.id }">通过</a>		                    
			                  </c:if>    
 							<a class="btn btn-info btn-sm" href="AgencyServlet?action=query&id=${a.id }">修改</a>
			                        <a class="btn btn-danger btn-sm" onClick="del_agency(this,'${a.id }')" href="javascript:;">删除</a>
			                    </td>
			                    </c:if>
			                </tr>
			 </c:forEach>               

                </tbody>
                
            </table>
               
        </div>

 
    </div>
</main>




<script src="static/admin/js/update.js" ></script>
<script type="text/javascript">
function del_agency(obj,id){
	 //用户安全提示
    if(confirm("您确定要删除该条记录吗？")){
        //访问路径
        location.href="${pageContext.request.contextPath}/AgencyServlet?action=delete&id="+id;
    }
}

</script>
</body>

</html>
