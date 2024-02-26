<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();//获得当前的项目根目录路径赋值给path
%>
 <div class="vip-left">
       <div class="vipNav">
        <h3 class="vipTitle">个人中心</h3>
        <dl>
         <dt class="vipIcon3">账户设置</dt>
          <dd>
           <a href="CommonServlet?action=toPersonInfo">我的资料</a>
           <a href="CommonServlet?action=toUpdateUserPwd">账户密码设置</a>
          </dd>
         <dt class="vipIcon1">关于房源</dt>
          <dd>
           <a href="GzfyServlet?action=mygzfy" >关注房源</a>
           <a href="CommonServlet?action=toAgencyRegiste">申请房产中介</a>
           <a href="AgencyServlet?action=findAll">房产中介列表</a>
          </dd>
        </dl>
       </div><!--vipNav/-->
    </div>