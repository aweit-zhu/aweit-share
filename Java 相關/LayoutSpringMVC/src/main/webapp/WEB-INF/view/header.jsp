<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Layout</title>
		<%@ include file="/WEB-INF/view/library.jspf" %>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-primary vw-100">
		  <div class="container-fluid">
		    <i class="bi bi-calendar3 h5 my-0 text-light me-2"></i>
		    <a class="navbar-brand text-light" href="./">請假系統</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		      	<li class="nav-item">
		          <a role="button" class="nav-link text-light" href="/LayoutSpringMVC/">🎄報表</a>
		        </li>
		        <li class="nav-item">
		          <a role="button" class="nav-link text-light" href="/LayoutSpringMVC/page1.jsp">🎄表單製作</a>
		        </li>
		        <li class="nav-item">
		          <a role="button" class="nav-link text-light" href="/LayoutSpringMVC/page2">🎄表單驗證+上傳檔案</a>
		        </li>
		        <li class="nav-item">
		          <a role="button" class="nav-link text-light" href="/LayoutSpringMVC/page3.jsp">🎄下載檔案</a>
		        </li>
		        <li class="nav-item">
		          <a role="button" class="nav-link text-light" href="/LayoutSpringMVC/page4.jsp">🎄上傳檔案</a>
		        </li>
		        <li class="nav-item">
		          <a role="button" class="nav-link text-light" href="/LayoutSpringMVC/shopping.jsp">🎄購物車</a>
		        </li>
		        <li class="nav-item">
		          <a role="button" class="nav-link text-light" href="/LayoutSpringMVC/app/hello">🎄Hello Page</a>
		        </li>
		     </ul>
		     <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
		     	<li class="nav-item">
		         	<i class="bi bi-person-circle d-none d-lg-block h5 my-0 text-light me-3" role="button"> ${sessionScope.username}</i>
		        </li>
		        <li class="nav-item">
		         	<i class="bi bi-box-arrow-right text-light ml-3" role="button" onclick="window.location.href='/LayoutSpringMVC/app/logout'">Logout</i>
		        </li>
		     </ul>
		    </div>
		  </div>
		</nav>
	</body>
</html>