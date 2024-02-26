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
            <h5>新增房东</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="LandloardServlet?action=add" method="post">
                            <small   style="color:red">${msg }</small>
                        <div class="form-group">
                            <label>姓名</label>
                            <input type="text" name="realname" id="realname" class="form-control">
                            <small  id="msg1" style="color:red"></small>
                        </div>

                      

                        <div class="form-group">
                            <label>密码</label>
                            <input type="password" name="pwd" id="pwd" class="form-control">
                              <small  id="msg4" style="color:red"></small>
                        </div>

                        <div class="form-group">
                            <label>确认密码</label>
                            <input type="password" name="rpwd" id="rpwd" class="form-control">
                            <small  id="msg5" style="color:red"></small>
                        </div>
                        
                        <div class="form-group">
                            <label>性别</label>
                            <select name="sex" class="form-control">
                                <option value="男" selected>男</option>
                                <option value="女">女</option>                            
                            </select>
                            <small class="form-text text-muted"></small>
                        </div>

                        <div class="form-group">
                            <label>手机号</label>
                            <input type="text" name="phone"   id="phone"class="form-control">
                              <small  id="msg2" style="color:red"></small>
                        </div>
                      
        <div class="submit-box">
            <button type="submit" id="add" class="btn btn-primary">确定提交</button>
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
	$("#add").click( function() {
	  
	    var realname = $("#realname").val();
	    var phone = $("#phone").val(); 
	 
	    
	    var pwd = $("#pwd").val();
	    var rpwd = $("#rpwd").val();
	   
	    
	    if(!realname) {
            $("#msg1").html("真实姓名不能为空！");
            $("#realname").focus(); // 聚焦
            return false;
        }
	  
	   
	    if(!pwd) {
            $("#msg4").html("密码不能为空！");
            $("#pwd").focus(); // 聚焦
            return false;
        }
	    
	    
       
	     if(!rpwd) {
	            $("#msg5").html("确认密码不能为空！");
	            $("#rpwd").focus(); // 聚焦
	            return false;
	    }
	 
	     if(rpwd!=pwd) {
	            $("#msg4").html("两次密码不一致！");
	            $("#pwd").focus(); // 聚焦
	            $("#rpwd").focus(); // 聚焦
	            return false;
	        }
	     if(!phone) {
		        $("#msg2").html("手机号不能为空！");
		        $("#phone").focus(); // 聚焦 */
		        return false;
		    } 
	});
})


</script>
</body>

</html>
