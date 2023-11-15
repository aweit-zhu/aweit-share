<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout.jsp" %>

<div id="content" class="mx-auto vh-100 d-flex justify-content-center w-100">
 	<form class="w-100 mx-5" method="post" action="./page1" onsubmit="return check();">
		<h4 class="fw-bold text-center">假單申請</h4>
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">Email address</label>
		  <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
		<div class="col-auto mx-auto d-flex justify-content-center">
		   <button type="submit" class="btn btn-primary mb-3 mx-2">提交</button>
		   <button type="reset" class="btn btn-success mb-3 mx-2">清除</button>
		</div>
	</form>
</div>

<script>

	function check() {
		let email = $("#email").val();
		console.log(email);
		return false;
	}

</script>