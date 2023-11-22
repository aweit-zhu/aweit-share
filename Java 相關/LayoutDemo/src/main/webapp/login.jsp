<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String error = (String)request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Layout</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
	    <link rel="shortcut icon" href="./images/icon.png" type="image/x-icon"/>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	    <style>
	    	body {
	            font-family: Arial, sans-serif;
	            background-color: #f4f4f4;
	            margin: 0;
	            padding: 0;
	        }
	    	form {
		    	background-color: #fff;
	            padding: 20px;
	            padding-top: 40px;
	            padding-bottom: 10px;
	            border-radius: 8px;
	            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	            width: 500px;
	            height: 350px;
	    	}
	    </style>
	</head>
	<body>
		<div class="d-flex align-items-center justify-content-center vh-100 ">
			<form class="needs-validation" novalidate action="./login" method="post" >
				<h4 class="text-center">Login</h4>
				<p class="text-center text-danger fw-bold"> ${!empty error ? error: ""} </p>
				<div>
					<label for="username" class="form-label">Username</label> <input
						type="text" class="form-control" id="username" name="username" value="" required>
					<div class="invalid-feedback">請輸入Username</div>
				</div>
				<div>
					<label for="password" class="form-label">Password</label> <input
						type="text" class="form-control" id="password" name="password" value="" required>
					<div class="invalid-feedback">請輸入Password</div>
				</div>
				<div class="d-flex justify-content-center mt-5">
					<button class="btn btn-primary w-100" type="submit">Login</button>
				</div>
			</form>
		</div>
	</body>
</html>

<script type="text/javascript">
	(function() {
		'use strict'

		// Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.querySelectorAll('.needs-validation')

		// Loop over them and prevent submission
		Array.prototype.slice.call(forms).forEach(function(form) {
			form.addEventListener('submit', function(event) {
				if (!form.checkValidity()) {
					event.preventDefault()
					event.stopPropagation()
				}

				form.classList.add('was-validated');
			}, false)
		})
	})()
</script>