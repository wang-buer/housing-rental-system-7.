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
            <h5>新增中介</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="AgencyServlet?action=add&flag=2"  enctype="multipart/form-data"   method="post" > <!---->
                            <small   style="color:red">${msg}</small>
                    <!--    <div class="form-group">
                            <label>头像：</label>
                            <input type="file" name="resPath"  id="tx" class="form-control"/>                                                
                            <small  id="msg" style="color:red"></small>
                        </div> -->
                          <div class="form-group">
                            <label>头像</label>
                           <div class="field">
						请选择头像：<input type="file" id="tx" name="resPath"
							class="input input-file tips" style="width: 25%; float: ;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br> 
							 <small  id="msg" style="color:red"></small>
					</div>
                        </div>
                        
                        <div class="form-group">
                            <label>姓名：</label>
                            <input type="text" name="realname" id="realname" value="${realname }" class="form-control">                          
                            <small  id="msg1" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>手机号：</label>
                            <input type="text" name="phone" id="phone" value="${phone }" class="form-control">                          
                            <small  id="msg2" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>工作年限：</label>
                            <input type="text" name="gznx" id="gznx" class="form-control">                          
                            <small  id="msg3" style="color:red"></small>
                        </div>
                        
                         
                           <div class="form-group">
                            <label>个人描述：</label>
                               <textarea type="text" name="note" id="note" rows="5" class="form-control"></textarea>
                             
                        </div>
                        
                          
                        <div class="form-group">
                            <label>性别：</label>
                            <select name="sex" class="form-control">
                                <option value="女" selected>女</option>
                                <option value="男">男</option>                                                                                   
                            </select>                       
                        </div>
                        
                         <div class="form-group">
                            <label>年龄：</label>
                            <input type="text" name="age" id="age" class="form-control">                          
                            <small  id="msg4" style="color:red"></small>
                        </div>
                        
                           <div class="form-group">
                            <label>身份证号：</label>
                            <input type="text" name="cno"  id="cno" class="form-control">
                            <small  id="msg5" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>学历：</label>
                            <select name="education" class="form-control">
                                 <option>硕士</option>
						         <option>本科</option> 
						         <option selected>大专</option>
						         <option>高中</option>
						         <option>小学</option>                                                                             
                            </select>                       
                        </div> 
                        <div class="form-group">
                            <label>QQ：</label>
                            <input type="text" name="qq"  id="qq" class="form-control">
                            <small  id="msg6" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>密码：</label>
                            <input type="text" name="pwd"  id="pwd" class="form-control">
                            <small  id="msg7" style="color:red"></small>
                        </div>
                        
                          <div class="form-group">
                            <label>中介代理商：</label>
                            <input type="text" name="agentstore"  id="agentstore" class="form-control">
                            <small  id="msg8" style="color:red"></small>
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
		 var tx = $("#tx").val();
		    var realname = $("#realname").val();
		    var phone = $("#phone").val(); 
		    var gznx = $("#gznx").val(); 
		    var age = $("#age").val(); 
		    var cno = $("#cno").val(); 
		    var qq = $("#qq").val(); 
		    var pwd = $("#pwd").val(); 
		    var agentstore = $("#agentstore").val(); 
		 /*   if(!tx) {
	            $("#msg").html("请上传头像");
	            $("#tx").focus(); // 聚焦
	            return false;
	        }
		 */
		    if(!realname) {
	            $("#msg1").html("真实姓名不能为空！");
	            $("#realname").focus(); // 聚焦
	            return false;
	        }
		  
		    if(!phone) {
	            $("#msg2").html("手机号不能为空！");
	            $("#phone").focus(); // 聚焦
	            return false;
	        }
		    
		    if(!gznx) {
	            $("#msg3").html("工作年限不能为空！");
	            $("#gznx").focus(); // 聚焦
	            return false;
	        }
		    
		    if(!age) {
	            $("#msg4").html("年龄不能为空！");
	            $("#age").focus(); // 聚焦
	            return false;
	        }
		    if(!cno) {
	            $("#msg5").html("身份证号不能为空！");
	            $("#cno").focus(); // 聚焦
	            return false;
	        }
		    
		    if(!qq) {
	            $("#msg6").html("QQ不能为空！");
	            $("#qq").focus(); // 聚焦
	            return false;
	        }
		    
		    if(!pwd) {
	            $("#msg7").html("密码不能为空！");
	            $("#pwd").focus(); // 聚焦
	            return false;
	        }
		    
		    if(!agentstore) {
	            $("#msg8").html("中介代理商不能为空！");
	            $("#agentstore").focus(); // 聚焦
	            return false;
	        }
		 
	});
})


</script>
</body>

</html>
