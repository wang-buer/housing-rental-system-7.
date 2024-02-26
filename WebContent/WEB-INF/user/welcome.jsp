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

<script>
console.log(config);
$(function() {
    $('#version').html(config.version);
});

</script>
<style>

    .main {
        overflow-y: auto;
    }

    .info .card {
        min-height: 330px;
    }

    .user .card {
        min-height: 500px;
    }

    .card h5 {
        margin-bottom: 20px;
    }

    .main ul li {
        margin-bottom: 3px;
    }
</style>
<main>
    <div class="main pt-5 pb-5">

        <div class="jumbotron bg-white pt-1 pb-1 mb-0">
            <h1 class="display-4">BsAdmin</h1>
            <p class="lead">基于Bootstrap4构建的BsAdmin后台模板</p>
        </div>

        <hr class="my-4">
        <div class="info">
            <div class="row">


                <div class="col-4">


                    <div class="card">
                        <div class="card-body">
                            <h5>支持我们</h5>
                            <ul>
                                <li>如果您认为BsAdmin对你有所帮助,你可以扫描以上二维码支持我们</li>
                              
                            </ul>
                        </div>
                    </div>


                </div>
                <div class="col-4">

                    <div class="card">
                        <div class="card-body">
                            <h5>BsAdmin 介绍</h5>
                            <ul>
                                <li>BsAdmin 是一个轻量级的后台模板,基于Bootstrap4构建</li>
                                <li>风格简洁简单,中小型项目首选</li>
                                <li>不管你是初级还是高级工程师,都有可以快速上手</li>
                                <li>BsAdmin是由Bootstrap4开发,可以在模板任意使用jq或vue</li>
                                <li>当前版本: <b id="version"></b></li>
                                <li><b>关注官网或github随时下载最新版</b></li>
                              
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-4">

                    <div class="card">
                        <div class="card-body">
                            <h5> BsAdmin 特点</h5>
                            <ul>
                                <li>轻量级</li>
                                <li>简洁直爽</li>
                                <li>基于Bootstrap4,上手快</li>
                                <li>支持jq/vue</li>
                                <li>...</li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <hr class="my-4">

  
    </div>

</main>


<script src="static/admin/js/update.js" ></script>
</body>

</html>
