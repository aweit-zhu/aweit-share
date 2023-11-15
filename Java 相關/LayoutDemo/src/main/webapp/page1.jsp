<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/layout.tld" prefix="ex" %>

<%-- <%@ include file="/WEB-INF/view/header.jsp" %> --%>

<ex:Layout>
	<div class="w-100 h-100" style="min-height:100%;padding-top:5rem">
		<div class="d-flex justify-content-center mx-auto" >
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
	</div>
</ex:Layout>


<%-- <%@ include file="/WEB-INF/view/footer.jsp" %> --%>


<script>

	function check() {
		let email = $("#email").val();
		console.log(email);
		return false;
	}

</script>