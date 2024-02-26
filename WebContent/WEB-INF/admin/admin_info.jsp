<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



 <jsp:include page="/WEB-INF/common/form_header.jsp"/>


<body>


<main>
    <div class="main">

        <div class="title-box">
            <h5>编辑管理员信息</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="AdminServlet?action=update" method="post">
                    <input type="hidden" name="id" value="${admin.id }" />
                            <small   style="color:red">${msg }</small>
                        <div class="form-group">
                            <label>手机号</label>
                            <input type="text" name="phone" id="phone" value="${admin.phone }"  class="form-control">
                            <small  id="msg" style="color:red"></small>
                        </div>


                        <div class="form-group">
                            <label>密码</label>
                            <input type="password" name="pwd" id="pwd" value="${admin.pwd }" class="form-control">
                              <small  id="msg1" style="color:red"></small>
                        </div>

                        <div class="form-group">
                            <label>昵称</label>
                            <input type="text" name="nickname" value="${admin.nickname }"  id="nickname"class="form-control">
                              <small  id="msg2" style="color:red"></small>
                        </div>
                      
        <div class="submit-box">
            <button type="submit" id="update" class="btn btn-primary">确定修改</button>
            <button type="button" onclick="window.history.back()" class="btn btn-outline-secondary">取消</button>
        </div>

                    </form>
                </div>
            </div>

        </div>


    </div>
</main>



<script src="static/admin/js/update.js" ></script>
<script>
$(function(){
	$("#update").click( function() {
	  
	    var nickname = $("#nickname").val();
	    var phone = $("#phone").val(); 
	   
	    
	    var pwd = $("#pwd").val();
	    
	   
	    
	 
	  
	 
	    
	 
	     if(!phone) {
		        $("#msg").html("手机号不能为空！");
		        $("#phone").focus(); // 聚焦 */
		        return false;
		    } 

		    if(!pwd) {
	            $("#msg1").html("密码不能为空！");
	            $("#pwd").focus(); // 聚焦
	            return false;
	        }
	     if(!nickname) {
	            $("#msg2").html("昵称不能为空！");
	            $("#nickname").focus(); // 聚焦
	            return false;
	        }
	});
})


</script>
</body>

</html>
