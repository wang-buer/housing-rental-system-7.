<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>多文件上传</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>

<!-- <body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span>多文件示例</strong> <a
				href="index.jsp" style="float: right;">-->首页</a>
		</div>
		<div class="body-content ">
			<form action="HouseServlet?action=add" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						文件1描述：<input type="text" class="input" name="filediscription1"
							value=""> 
						<div class="tips"></div>

				</div>
				<div class="form-group">

					<div class="field">
						请选择文件1：<input type="file" id="url1" name="resPath"
							class="input input-file tips" style="width: 25%; float: ;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br> 
					</div>
				</div>
				<div class="form-group">
					<div class="field">
						文件2描述：<input
							type="text" class="input" name="filediscription2" value="">
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">

					<div class="field">
						请选择文件2：<input
							type="file" id="url2" name="resPath"
							class="input input-file tips" style="width: 25%; float:;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br>
						</div>
				</div>
				<div class="form-group">
					<div class="field">
						文件3描述：<input
							type="text" class="input" name="filediscription3" value="">
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">

					<div class="field">
						请选择文件3：<input
							type="file" id="url3" name="resPath"
							class="input input-file tips" style="width: 25%; float: ;"
							value="+ 浏览上传" data-toggle="hover" data-place="right"
							data-image="" accept=".jpg,.png,.gif" /><br> <br>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
											<button class="button bg-main icon-check-squre-o" onclick="addline();">单击此处添加更多文件</button>
						<button class="button bg-main icon-check-squre-o" type="submit">提交</button>
						<button class="button bg-main icon-check-squre-o" type="reset">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>

  <!-- <body>
    <form name="theform" method="post" action="fileUploadTest" enctype="multipart/form-data">
        <h4>附件上传：</h4>
        <table id=test border="0">
            <tr>
                <td>
                    <input type="file" name="file_info" size="60">&nbsp;
                </td>
            </tr>
        </table>
        <button onclick="addline();">单击此处添加更多附件</button><hr>
        <input type="submit" />
    </form>
  </body>   -->
</html>