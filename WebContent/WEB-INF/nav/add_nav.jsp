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
            <h5>新增导航栏</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="NavServlet?action=add" method="post">
                            <small   style="color:red">${msg }</small>
                        <div class="form-group">
                            <label>名称：</label>
                            <input type="text" name="name" id="name" class="form-control">
                               <small  id="msg" style="color:red">${msg }</small>
                            <small  id="msg1" style="color:red"></small>
                        </div>

                        <div class="form-group">
                            <label>跳转路径</label>
                            <input type="text" name="url"  id="url" class="form-control">
                            <small  id="msg2" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>路径说明</label>
                               <textarea type="text" name="note" id="note" rows="5" class="form-control"></textarea>
                              <small  id="msg6" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>排序</label>
                          <select name="px" class="form-control">
                         <option value="1" selected>1</option>
                                <option value="2" >2</option>  
                                <option value="3" >3</option>  
                                <option value="4" >4</option>  
                                <option value="5" >5</option> 
                                 <option value="6" >6</option>
                                   <option value="7" >7</option>  
                                    <option value="7" >8</option>                                                                           
                            </select>
                           
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
	  
	    var name = $("#name").val();
	    var url = $("#url").val(); 
	  
	    if(!name) {
            $("#msg1").html("导航栏名称不能为空！");
            $("#name").focus(); // 聚焦
            return false;
        }
	  
	    if(!url) {
            $("#msg2").html("跳转路径不能为空！");
            $("#url").focus(); // 聚焦
            return false;
        }
	 
	});
})


</script>
</body>

</html>
