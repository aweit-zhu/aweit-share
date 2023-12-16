<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<div class="w-100 vh-100" style="min-height:100%;padding-top:5rem">
	<form:form modelAttribute="employee" 
	             method="post" 
	             action="/LayoutSpringMVC/app/emp/save" 
	             cssClass="mx-3 w-50 border border-dark rounded">
	    <div class="m-4">
		    <div class="mb-3 row">
				<label for="staticEmail" class="form-label">Name</label>
				<div class="col">
					<form:input path="name" cssClass="form-control" type="text" />
				</div>
				<form:errors path="name" />
			</div>
			<div class="mb-3 row">
				<label for="staticEmail" class="form-label">Salary</label>
				<div class="col">
					<form:input path="salary" cssClass="form-control" type="text" />
				</div>
				<form:errors path="salary" />
			</div>
			<div class="mb-3 row">
				<label for="staticEmail" class="form-label">Designation</label>
				<div class="col">
					<form:input path="designation" cssClass="form-control" type="text" />
				</div>
				<form:errors path="designation" />
			</div>
			<button class="btn btn-primary" type="submit">Save</button>
	    </div>
	</form:form>
</div>
<%@ include file="/WEB-INF/view/footer.jsp"%>
