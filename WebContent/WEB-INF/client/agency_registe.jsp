<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css"  />
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/common/website_header.jsp"/>

 <div class="list-nav">
  <div class="width1190">
   <div class="list">
    <h3>房源分类</h3>
     <jsp:include page="/WEB-INF/common/top_left.jsp"/>
   </div><!--list/-->
   <ul class="nav">
   <c:forEach items="${navList }" var="n">
     <li><a href="${n.url}">${n.name }</a></li>
   </c:forEach>

    <div class="clears"></div>
   </ul><!--nav/-->
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--list-nav/-->
  <div class="banner" style="background:url(images/ban.jpg) center center no-repeat;"></div>

 <div class="content">
  <div class="width1190">
 <div class="vip-left">
       <div class="vipNav">
       
        <dl>
        
         <dt class="vipIcon1">关于中介</dt>
          <dd>          
           <a href="CommonServlet?action=toAgencyRegiste">申请房产中介</a>
           <a href="AgencyServlet?action=findAll">房产中介列表</a>
          </dd>
        </dl>
       </div><!--vipNav/-->
    </div>
    <div class="vip-right">
     <h3 class="vipright-title">申请社区自由经纪人</h3>
     <form action="AgencyServlet?action=add&flag=1" enctype="multipart/form-data" method="post">
     <dl class="vip-touxiang">
      <dt><img src="images/upload.png" id="preview_img" width="100" height="100" /></dt>
      <dd>
       <h3><strong>点击选择文件上传头像</strong></h3>
       <div class="sctx"><input type="file" name="resPath"  id="tx"/><a href="javascript:;">上传</a></div>
       <p>图片格式：GIF、JPG、JPEG、PNG ，最适合尺寸100*100像素</p>
      </dd>
      <div class="clearfix"></div>
     </dl><!--vip-touxiang/-->
   
     
     <table class="grinfo">
       <span id="msg" style="color:red">${msg }</span>
        <tbody>
         </tr>
        <tr>
        <th><span class="red">*</span> 姓名：</th>
        <td>
        <input class="inp inw" type="realname" name="realname" id="realname" value="" maxlength="14">
         <span id="msg1" style="color:red"></span>
        </td>
        </tr>
        <tr>
        <th>手机号：</th>
        <td> 
         <input class="inp inw" type="text" name="phone" id="phone" value="" maxlength="14">
          <span id="msg2" style="color:red"></span>
        </td>
       
        <tr>
        <th><span class="red"></span> 工作年限：</th>
        <td>
        <input class="inp inw" type="text" id="gznx" name="gznx" placeholder="3" value="" maxlength="2" ">年
           <span id="msg3" style="color:red"></span>
        </td>
        </tr>
        
        <tr>
        <th valign="top">个人描述：</th>
        <td>
        <textarea id="note" name="note" class="grtextarea"></textarea>
        <br>
        <span class="fgrey">(128字符以内)</span>
        </td>
        </tr>
    

     
        <tr>
        <th><span class="red">*</span> 性 &nbsp; &nbsp;别：</th>
        <td>
        <input type="radio" value="2" id="sex" name="sex" >
        <label for="rbSex1">女</label>
        <input type="radio" value="1" id="sex" name="sex" checked>
        <label for="rbSex2">男</label>
        <span id="Sex_Tip"></span>
        </td>
        </tr>
       <!--  <tr>
        <th><span class="red"></span> 年 &nbsp; &nbsp;龄：</th>
        <td>
        <input class="inp inw" type="text" maxlength="2" id="age"  name="age">
           <span id="msg4" style="color:red"></span>
        </td>
        </tr> -->
        <tr>
        <th><span class="red"></span> 身份证信息：</th>
        <td>
        <input class="inp inw" type="text" id="cno" name="cno" value="">
           <span id="msg5" style="color:red"></span>
        </td>
        </tr>
       
        <tr>
        <th><span class="red"></span> 学历程度：</th>
        <td>
        <div style="clear:both;"><div style="clear:both;">
        
        <div style="float:left;">
        <select name="education"> 
         <option>硕士</option>
         <option>本科</option> 
         <option>大专</option>
         <option>高中</option>
         <option>小学</option>
        </select>
        </div>
        </div></div>
        
        </td>
        </tr>
        
        
        <tr>
        <th>&nbsp;Q &nbsp; &nbsp;Q：</th>
        <td>
        <input class="inp inw" type="text" maxlength="15" value="" id="qq"  name="qq">
           <span id="msg6" style="color:red"></span>
        </td>
        </tr>
        
          <tr>
        <th>&nbsp;密&nbsp; &nbsp;码：</th>
        <td>
        <input class="inp inw" type="text" maxlength="15" value="" id="pwd"  name="pwd">
           <span id="msg7" style="color:red"></span>
        </td>
        </tr>
        
          <tr>
        <th>中介代理商：</th>
        <td>
        <input class="inp inw" type="text" maxlength="15" value="" id="agentstore"  name="agentstore">
           <span id="msg8" style="color:red"></span>
        </td>
        </tr>
        
        
        <tr>
        <th>&nbsp;</th>
        <td colspan="2">
        <label class="butt" id="butt">
        <input type="submit" value="提交申请" id="add" class="member_mod_buttom"/>
        
        </label>
        </td>
        </tr>
        </tbody>
     </table>
       </form>
    </div><!--vip-right/-->
    <div class="clearfix"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 

 <jsp:include page="/WEB-INF/common/footer.jsp"/>
 <script type="text/javascript">  

$("#tx").change(function () {
    //创建blob对象，浏览器将文件放入内存中，并生成标识
    var img_src = URL.createObjectURL($(this)[0].files[0]);
    //给img标检的src赋值
    document.getElementById("preview_img").src=img_src;
    //URL.revokeObjectURL(img_src);// 手动 回收，
});
$(function(){
	$("#add").click( function() {
		 var tx = $("#tx").val();
	    var realname = $("#realname").val();
	    var phone = $("#phone").val(); 
	    var gznx = $("#gznx").val(); 
	   /*  var age = $("#age").val();  */
	    var cno = $("#cno").val(); 
	    var qq = $("#qq").val(); 
	    var pwd = $("#pwd").val(); 
	    var agentstore = $("#agentstore").val(); 
	    if(!tx) {
            $("#msg").html("请上传头像");
            $("#tx").focus(); // 聚焦
            return false;
        }
	  
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
