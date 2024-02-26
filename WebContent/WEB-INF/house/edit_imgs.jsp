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
            <h5>修改房源图片</h5>
        </div>
        <div class="form-box">
            <div class="row">
                <div class="col-5">
                    <form action="HouseServlet?action=updateImgs&fwbh=${record.fwbh}&id=${record.id}" enctype="multipart/form-data" method="post" >
                     
                            <small   style="color:red">${msg }</small>
                         <div class="form-group">
                            <label>房源图片</label>
                           <div class="field">
						请选择文件：<input type="file" id="url1" name="resPath"
							class="input input-file tips" style="width: 25%; float: ;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br> 
					</div>
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

</body>

</html>
