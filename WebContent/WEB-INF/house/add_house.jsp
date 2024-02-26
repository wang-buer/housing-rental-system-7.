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
            <h5>发布房源</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="HouseServlet?action=add" method="post" enctype="multipart/form-data">
                            <small   style="color:red">${msg }</small>
                        <div class="form-group">
                            <label>房源名称</label>
                            <input type="text" name="title" id="title" class="form-control">
                            <small  id="msg1" style="color:red"></small>
                        </div>

                      

                        <div class="form-group">
                            <label>租金</label>
                            <input type="text" name="price" id="price" class="form-control">
                                 <small  id="msg2" style="color:red"></small>
                        </div>

                        <div class="form-group">
                            <label>户型</label>
                          <select name="htype" class="form-control">
                         <option value="一室一厅" selected>一室一厅</option>
                                <option value="两室一厅" <>两室一厅</option>  
                                <option value="三室一厅" >三室一厅</option>  
                                <option value="四室一厅" >四室一厅</option>  
                                <option value="四室两厅" >四室两厅</option>                                                           
                            </select>
                           
                        </div>
                        
                        <div class="form-group">
                            <label>租房类型</label>
                            <select name="rtype" class="form-control">
                                <option value="整租" selected>整租</option>
                                <option value="合租">合租</option>  
                                <option value="短租">短租</option>  
                                <option value="长租">长租</option>  
                                <option value="其他">其他</option>  
                                                         
                            </select>
                        
                        </div>
                        
                          <div class="form-group">
                            <label>朝向</label>
                            <select name="direction" class="form-control">
                                <option value="朝南" selected>朝南</option>
                                <option value="朝北">朝北</option>      
                                  <option value="朝东">朝东</option>    
                                    <option value="朝西">朝西</option>                                                                                  
                            </select>                      
                        </div>
                        
                        
                        <div class="form-group">
                            <label>装修风格</label>
                            <select name="style" class="form-control">
                                <option value="精装修" selected>精装修</option>
                                <option value="普通装修">普通装修</option>  
                                <option value="毛坯房">毛坯房</option>  
                                                         
                            </select>
                        
                        </div>
                       <%--    <select name="person_area_id" id="person_area_id">

                            <option value="-1">--请选择部门--</option>
                            <c:if test="${requestScope.areaList!=null}">
                                <c:forEach items="${requestScope.areaList}" var="area">
                                    <option name="depid" value="${area.area_id}">${area.area_name}</option>
                                </c:forEach>
                            </c:if>
                        </select></td> --%>
                        
                         <div class="form-group">
                            <label>委托中介</label>
                          <select name="a_id" class="form-control">
                       <option value="-1">--请选择中介代理商--</option>
                         <c:if test="${requestScope.agencyList!=null}">
                           <c:forEach items="${requestScope.agencyList}" var="a">
                                <option value="${a.id }" >${a.realname}-${a.agentstore}</option>    
                                </c:forEach>  
                                </c:if>                                                                      
                            </select>
                           
                        </div>
                        
                         <div class="form-group">
                            <label>房屋面积</label>
                            <input type="text" name="area" id="area" placeholder="80"  class="form-control">
                              <small  id="msg3" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>楼层</label>
                            <input type="text" name="floor" id="floor" placeholder="1/6" class="form-control">
                              <small  id="msg4" style="color:red"></small>
                        </div>
                        
                         <div class="form-group">
                            <label>所在小区</label>
                              <input type="text" name="xq" id="xq" placeholder="输入小区" class="form-control">
                              <small  id="msg7" style="color:red"></small>
                        </div>
                        <div class="form-group">
                            <label>房屋地址</label>
                               <textarea type="text" name="address" id="address" rows="5" class="form-control"></textarea>
                              <small  id="msg5" style="color:red"></small>
                        </div>
                        
                          <div class="form-group">
                            <label>房源详情</label>
                               <textarea type="text" name="detail" id="detail" rows="5" class="form-control"></textarea>
                              <small  id="msg6" style="color:red"></small>
                        </div>
                        
                        
                        <div class="form-group">
                            <label>房源图片1</label>
                           <div class="field">
						请选择文件1：<input type="file" id="url1" name="resPath"
							class="input input-file tips" style="width: 25%; float: ;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br> 
					</div>
                        </div>
                         <div class="form-group">
                            <label>房源图片2</label>
                           <div class="field">
						请选择文件1：<input type="file" id="url2" name="resPath"
							class="input input-file tips" style="width: 25%; float: ;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br> 
					</div>
                        </div>
                        
                         <div class="form-group">
                            <label>房源图片3</label>
                           <div class="field">
						请选择文件1：<input type="file" id="url3" name="resPath"
							class="input input-file tips" style="width: 25%; float: ;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br> 
					</div>
                        </div>
                        
                         <div class="form-group">
                            <label>房源图片4</label>
                           <div class="field">
						请选择文件1：<input type="file" id="url1" name="resPath"
							class="input input-file tips" style="width: 25%; float: ;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br> 
					</div>
                        </div>

                        <!-- <div class="form-group">
                            <label>手机号</label>
                            <input type="text" name="phone"   id="phone"class="form-control">
                              <small  id="msg2" style="color:red"></small>
                        </div> -->
                      
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
	  
	    var title = $("#title").val();
	    var price = $("#price").val(); 
	 
	
	    var area = $("#area").val();
	    var floor = $("#floor").val();
	    var address = $("#address").val();
	    var xq = $("#xq").val();
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
