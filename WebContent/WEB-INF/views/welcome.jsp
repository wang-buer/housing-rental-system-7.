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
            <h1 class="display-4">欢迎来到房屋租赁后台</h1>
        </div>



    </div>

</main>


<script src="static/admin/js/update.js" ></script>
</body>

</html>
