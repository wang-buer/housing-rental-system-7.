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
            <h5>修改房源</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="HouseServlet?action=update" method="post" >
                            <small   style="color:red">${msg }</small>
                             <input type="hidden" name="id" value="${record.id }" />
                        <div class="form-group">
                            <label>房源名称</label>
                            <input type="text" name="title" id="title" value="${record.title}" class="form-control">
                            <small  id="msg1" style="color:red"></small>
                        </div>

                      

                        <div class="form-group">
                            <label>租金</label>
                            <input type="text" name="price" id="price"  value="${record.price}" class="form-control">
                                 <small  id="msg2" style="color:red"></small>
                        </div>

                        <div class="form-group">
                            <label>房源类型</label>
                          <select name="htype" class="form-control">
                                <option value="一室一厅" <c:if test="${record.htype=='一室一厅' }">selected</c:if>>一室一厅</option>
                                <option value="两室一厅" <c:if test="${record.htype=='两室一厅' }">selected</c:if>>两室一厅</option>  
                                <option value="三室一厅" <c:if test="${record.htype=='三室一厅' }">selected</c:if>>三室一厅</option>  
                                <option value="四室一厅" <c:if test="${record.htype=='四室一厅' }">selected</c:if>>四室一厅</option>  
                                <option value="四室两厅" <c:if test="${record.htype=='四室两厅' }">selected</c:if>>四室两厅</option>                               
                            </select>
                           
                        </div>
                        
                          <div class="form-group">
                            <label>朝向</label>
                            <select name="direction" class="form-control">
                               
                                <option value="朝南" <c:if test="${record.direction=='朝南' }">selected</c:if>>朝南</option>
                                <option value="朝北" <c:if test="${record.direction=='朝北' }">selected</c:if>>朝北</option> 
                                 <option value="朝东" <c:if test="${record.direction=='朝东' }">selected</c:if>>朝东</option>
                                 <option value="朝西" <c:if test="${record.direction=='朝西' }">selected</c:if>>朝西</option>
                                                                                                                  
                            </select>                      
                        </div>
                        
                        
                        
                        <div class="form-group">
                            <label>租房类型</label>
                            <select name="rtype" class="form-control">
                                <option value="整租"<c:if test="${record.rtype=='整租' }">selected</c:if> >整租</option>
                                <option value="合租" <c:if test="${record.rtype=='合租' }">selected</c:if> >合租</option>  
                               <option value="长租" <c:if test="${record.rtype=='长租' }">selected</c:if> >长租</option>  
                                   <option value="短租" <c:if test="${record.rtype=='短租' }">selected</c:if> >短租</option>
                                <option value="其他" <c:if test="${record.rtype=='其他' }">selected</c:if> >其他</option>  
                                                         
                            </select>
                        
                        </div>
                        
                        <div class="form-group">
                            <label>装修风格</label>
                            <select name="style" class="form-control">
                                <option value="精装修" <c:if test="${record.style=='整租' }">selected</c:if> >精装修</option>
                                <option value="普通装修"  <c:if test="${record.style=='普通装修' }">selected</c:if> >普通装修</option>  
                                <option value="毛坯房"  <c:if test="${record.style=='毛坯房' }">selected</c:if> >毛坯房</option>                                                          
                            </select>
                        
                        </div>
                        
                           <div class="form-group">
                            <label>委托中介</label>
                          <select name="a_id" class="form-control">

                         <c:if test="${requestScope.agencyList!=null}">
                           <c:forEach items="${requestScope.agencyList}" var="a">
                                <option value="${a.id }" <c:if test="${a.id==record.a_id}">selected="selected"</c:if>>${a.agentstore }</option>                                                                            
                           </c:forEach>
                           </c:if>
                            </select>
                           
                        </div>
                        
                         <div class="form-group">
                            <label>房屋面积</label>
                            <input type="text" name="area" id="area" value="${record.area }" class="form-control">
                              <small  id="msg3" style="color:red"></small>
                        </div>
                        
                             <div class="form-group">
                            <label>房源状态</label>
                            <select name="status" class="form-control">
                                <option value="0" <c:if test="${record.status==0 }">selected</c:if> >未出租</option>
                                <option value="1"  <c:if test="${record.status==1}">selected</c:if> >出租中</option>  
                                                                                 
                            </select>
                        
                        </div>
                        
                         <div class="form-group">
                            <label>楼层</label>
                            <input type="text" name="floor" id="floor"  value="${record.floor }"  class="form-control">
                              <small  id="msg4" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>所在小区</label>
                              <input type="text" name="xq" id="xq" placeholder="请输入小区" value="${record.xq }" class="form-control">
                              <small  id="msg7" style="color:red"></small>
                        </div>
                        
                        <div class="form-group">
                            <label>房屋地址</label>
                               <textarea type="text" name="address" id="address" rows="5" class="form-control">${record.address }</textarea>
                              <small  id="msg5" style="color:red"></small>
                        </div>
                        
                          <div class="form-group">
                            <label>房源详情</label>
                               <textarea type="text" name="detail" id="detail" rows="5" class="form-control">${record.detail }</textarea>
                              <small  id="msg6" style="color:red"></small>
                        </div>
                        
                   

                      
                      
        <div class="submit-box">
            <button type="submit" id="update" class="btn btn-primary">确定提交</button>
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
	  
	    var title = $("#title").val();
	    var price = $("#price").val(); 
	 
	    var xq = $("#xq").val();
	    var area = $("#area").val();
	    var floor = $("#floor").val();
	    var address = $("#address").val();
	    var detail = $("#detail").val();
	    if(!title) {
            $("#msg1").html("房源名称不能为空！");
            $("#title").focus(); // 聚焦
            return false;
        }
	  
	   
	    if(!price) {
            $("#msg2").html("租金不能为空！");
            $("#price").focus(); // 聚焦
            return false;
        }
	    
	    
       
	     if(!area) {
	            $("#msg3").html("房屋面积不能为空！");
	            $("#area").focus(); // 聚焦
	            return false;
	    }
	 
	     if(!floor) {
	            $("#msg4").html("楼层不许为空！");
	            $("#floor").focus(); // 聚焦
	         
	            return false;
	        }
	     if(!address) {
		        $("#msg5").html("房源地址不能为空！");
		        $("#address").focus(); // 聚焦 */
		        return false;
		    } 
	     if(!detail) {
		        $("#msg6").html("房源详情不能为空！");
		        $("#address").focus(); // 聚焦 */
		        return false;
		    } 
	     
	     if(!xq) {
		        $("#msg7").html("所在小区不能为空！");
		        $("#xq").focus(); // 聚焦 */
		        return false;
		    } 
	}); 
})

</script>
</body>

</html>
