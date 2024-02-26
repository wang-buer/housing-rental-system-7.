<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>租房后台</title>
  <link rel="icon" href="<%=path%>/resource/static/favicon.ico">
<link rel="stylesheet"
	href="<%=path%>/static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=path%>/static/admin/css/index.css">
<link rel="stylesheet"
	href="<%=path%>/static/admin/css/main.css">
<link rel="stylesheet"
	href="<%=path%>/static/admin/css/html.css">
<script src="<%=path%>/static/js/vue.min.js"></script>
<script src="<%=path%>/static/js/jquery-3.3.1.min.js"></script>
<script src="<%=path%>/static/bootstrap/js/bootstrap.bundle.js"></script>
<script src="<%=path%>/static/admin/js/config.js"></script>
<script src="<%=path%>/static/admin/js/script.js"></script>
</head>
<body>

<div id="app" class="d-flex">

    <nav>
        <div class="logo">
            <h4>租房后台</h4>
        </div>
        <ul class="menu">
          <c:if test="${type==2 }">
             <li><a href="CommonServlet?action=welcome" target="main"><i class="iconfont mr-1">&#xe6a2;</i>首页</a> </li> 
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6e0;</i>个人信息管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="LandloardServlet?action=findMyInfo&l_id=${landloard.id }" target="main">我的个人信息</a></li></ul> </li> 
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>房源管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="HouseServlet?action=findMyHouse&l_id=${landloard.id}" target="main">查看我的房源</a></li><li><a href="HouseServlet?action=toAddHouse" target="main">发布房源</a></li></ul> </li>
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6e0;</i>中介列表<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="AgencyServlet?action=list" target="main">查看中介信息</a></li></ul> </li>                                        
 		 </c:if>
 		  <c:if test="${type==3 }">
             <li><a href="CommonServlet?action=welcome" target="main"><i class="iconfont mr-1">&#xe6a2;</i>首页</a> </li> 
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6e0;</i>个人信息管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="AgencyServlet?action=findMyInfo&a_id=${agency.id }" target="main">我的个人信息</a></li></ul> </li> 
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>房源信息<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="HouseServlet?action=list" target="main">查看房源</a></li></ul> </li>
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6e0;</i>租客预约管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="YykfServlet?action=yykfMe" target="main">查看租客预约信息</a></li></ul> </li>
 		 </c:if>
        <c:if test="${type==4 }">
             <li><a href="CommonServlet?action=welcome" target="main"><i class="iconfont mr-1">&#xe6a2;</i>首页</a> </li> 
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6e0;</i>租客管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="UserServlet?action=list" target="main">租客列表</a></li><li><a href="UserServlet?action=toAddUser" target="main">添加租客</a></li></ul> </li> 
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6e0;</i>房东管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="LandloardServlet?action=list" target="main">房东列表</a></li><li><a href="LandloardServlet?action=toAddLandloard" target="main">添加房东</a></li></ul> </li>
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6e0;</i>中介管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="AgencyServlet?action=list" target="main">中介列表</a></li><li><a href="AgencyServlet?action=toAddAgency" target="main">添加中介</a></li></ul> </li>
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>导航栏管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="NavServlet?action=list" target="main">导航栏列表</a></li><li><a href="NavServlet?action=toAddNav" target="main">添加导航栏</a></li></ul> </li>
             <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>房源管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="HouseServlet?action=list" target="main">房源列表</a></li></ul> </li>
           <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6ad;</i>预约看房管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="YykfServlet?action=list" target="main">查看租客预信息列表</a></li></ul> </li>
             
  
              <li><a class="top-menu" href="javascript:;"><i class="iconfont mr-1">&#xe6d4;</i>个人信息管理<i class="iconfont arrow float-right">&#xe66c;</i></a><ul class="sub-menu"><li><a href="AdminServlet?action=findMyInfo&id=${admin.id }" target="main">修改个人信息</a></li></ul> </li>
 		 </c:if>
 <li><a href="LoginServlet?action=loginOut"><i class="iconfont mr-1">&#xe68c;</i>退出登录</a> </li> 
        </ul>
    </nav>

    <main>
        <header>
            <a href="CommonServlet?action=toWebsite" target="_blank">网站首页</a>



            <div class="dropdown float-right">


                <button class="btn  btn-sm  dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               <c:if test="${type==2}">  
             	欢迎房东：${landloard.realname}
             </c:if>
              <c:if test="${type==3}">  
             	欢迎中介：${agency.realname}
             </c:if>
                  
                  
             <c:if test="${type==4}">  
             	欢迎管理员：${admin.nickname }
             </c:if>
                  
                </button>


                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
                 <c:if test="${type==3}"> 
                    <a class="dropdown-item" href="AgencyServlet?action=findMyInfo&a_id=${agency.id }">修改个人信息</a>
                    </c:if>
                    <a class="dropdown-item" href="LoginServlet?action=loginOut">退出登录</a>
                </div>
            </div>


           


        </header>

        <iframe src="CommonServlet?action=welcome" name="main"></iframe>
    </main>
</div>

</body>
</html>



