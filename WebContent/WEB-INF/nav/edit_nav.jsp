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
            <h5>修改导航栏</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="NavServlet?action=update" method="post">
                     <input type="hidden" name="id" value="${nav.id }" />
                            <small   style="color:red">${msg }</small>
                        <div class="form-group">
                            <label>名称：</label>
                            <input type="text" name="name" id="name" value="${nav.name }" class="form-control">
                            <small  id="msg1" style="color:red"></small>
                        </div>

                        <div class="form-group">
                            <label>跳转路径：</label>
                            <input type="text" name="url"  id="url"  value="${nav.url }" class="form-control">
                            <small  id="msg2" style="color:red"></small>
                        </div>
                        
                          <div class="form-group">
                            <label>路径说明：</label>
                               <textarea type="text" name="note" id="note" rows="5" class="form-control">${nav.note }</textarea>
                              <small  id="msg6" style="color:red"></small>
                        </div>
                        
                             <div class="form-group">
                            <label>排序</label>
                          <select name="px" class="form-control">
                         <option value="1" <c:if test="${nav.px==1 }">1</c:if>>1</option>
                                <option value="2" <c:if test="${nav.px==2 }">2</c:if>>2</option>  
                                <option value="3" <c:if test="${nav.px==3 }">3</c:if>>3</option>  
                                <option value="4" <c:if test="${nav.px==4 }">4</c:if>>4</option>  
                                <option value="5" <c:if test="${nav.px==5 }">5</c:if>>5</option> 
                                 <option value="6"<c:if test="${nav.px==6 }">6</c:if> >6</option>
                                   <option value="7" <c:if test="${nav.px==7 }">7</c:if>>7</option>  
                                    <option value="8" <c:if test="${nav.px==8 }">8</c:if>>8</option>                                                                           
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
