<%@ include file="/WEB-INF/view/header.jsp" %>
	<div class="w-100 vh-100" style="min-height:100%;padding-top:5rem">
		<h2>Hello, ${message}</h2>
		<h2> ${sessionScope.username} </h2>
	</div>
<%@ include file="/WEB-INF/view/footer.jsp" %>