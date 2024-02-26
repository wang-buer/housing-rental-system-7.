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
    <div class="list-list">
  <!--    <dl>
      <dt><a href="javascript:;">房源区域</a></dt>
      <dd>
       <a href="javascript:;">智慧园</a>
       <a href="javascript:;">立民村</a>
       <a href="javascript:;">塘口村</a>
       <a href="javascript:;">勤劳村</a>
       <a href="javascript:;">芦胜村</a>
       <a href="javascript:;">知新村</a>
      </dd>
     </dl> -->
     <dl>
      <dt><a href="pro_zu.html">租房类型</a></dt>
      <dd>
       <a href="pro_zu.html">整租</a>
       <a href="pro_zu.html">合租</a>
    
      </dd>
     </dl>
     <dl>
      <dt><a href="pro_xin.html">户型面积</a></dt>
      <dd>
       <a href="pro_xin.html">一室一厅</a>
       <a href="pro_xin.html">两室一厅</a>
       <a href="pro_xin.html">三室一厅</a>
         <a href="pro_xin.html">四室一厅</a>
           <a href="pro_xin.html">四室两厅</a>
      </dd>
     </dl>
     
      <dl>
      <dt><a href="pro_xin.html">装修风格</a></dt>
      <dd>
       <a href="pro_xin.html">精装修</a>
       <a href="pro_xin.html">普通装修</a>
       <a href="pro_xin.html">毛坯房</a>
       
      </dd>
     </dl>
   
    </div>
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
  <jsp:include page="/WEB-INF/common/left.jsp"/>
    <div class="vip-right">
     <h3 class="vipright-title">房产中介经纪人列表</h3>
     <div class="jingjiren">
     <c:forEach items="${agencyList}" var="a">
      <dl>
       <dt><img src="upload/${a.tx }" /></dt>
       <dd>
        <h3>${a.realname } <img src="images/phone2.jpg" /> ${a.phone}</h3> 
        <p>QQ：${a.qq }</p>
        <p>备注：${a.note }</p>
           <div class="dizhi">所属中介：${a.agentstore }</div>
       </dd>
       <div class="xunzhang"><img src="images/xunzhang.jpg" width="51" height="50" /></div>
       <div class="clearfix"></div>
      </dl>
      </c:forEach>
    
     </div><!--jingjiren/-->
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
	    var age = $("#age").val(); 
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
