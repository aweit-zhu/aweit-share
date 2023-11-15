<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Layout</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	    <style>
	    	.nav-item a:hover {
	    		color: yellow !important;
	    	}
	    	
	    	nav {
	    		position:fixed !important;
	    		z-index: 99;
	    	}
	    	
	    	#content {
	    		position:relative;
	    		top:80px;
	    	}
	    </style>
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
		          <a role="button" class="nav-link text-light" href="./">首頁</a>
		        </li>
		        <li class="nav-item">
		          <a role="button" class="nav-link text-light" href="./page1.jsp">Page1</a>
		        </li>
		        <li class="nav-item">
		          <a role="button" class="nav-link text-light" href="./page2">Page2</a>
		        </li>
		     </ul>
		    </div>
		    <i class="bi bi-person-circle d-none d-xl-block h5 my-0 text-light me-3" role="button"></i>
		  </div>
		</nav>
	</body>
</html>