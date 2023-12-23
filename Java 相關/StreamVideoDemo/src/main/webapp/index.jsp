<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>


<div class="d-flex  flex-column justify-content-center align-items-center vh-100">
	
	<div class="d-flex justify-content-center mt-5">
		<button  onclick="window.location.href='${pageContext.request.contextPath}/mvc/auth/login'" 
		     class="btn btn-primary m-3" ${ user != null ? 'disabled':'' }>登入</button>
		  
		<button  onclick="window.location.href='${pageContext.request.contextPath}/mvc/auth/logout'" 
	         class="btn btn-danger m-3" ${ user == null ? 'disabled':'' }>登出</button>
	</div>
	
	<div class="d-flex justify-content-center align-items-center">
	    <!-- 靜態資源：（Servlet 容器） -->
		<video width="640" height="360" controls preload="metadata" class="m-2">
		    <c:if test="${ user != null }">
		    	<source src="/StreamVideoDemo/mvc/videos/video.mp4" type="video/mp4">
		    </c:if>
		</video>
	
		<!-- 動態資源: （Spring 控制器處理 - FileSystemResource）-->
		<video width="640" height="360" controls preload="metadata" class="m-2">
			<c:if test="${ user != null }">
		    	<source src="/StreamVideoDemo/mvc/video/v2" type="video/mp4">
			</c:if>
		</video>
		
	</div>

</div>