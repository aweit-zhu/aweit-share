<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<div class="w-100 vh-100" style="min-height: 100%; padding-top: 1rem">
	<spform:form modelAttribute="employee" 
	             method="post" 
	             action="/LayoutSpringMVC/mvc/emp/save" 
	             cssClass="mx-3 w-50 border border-dark rounded">
	    <div class="m-4">
		    <div class="mb-3 row">
				<label for="staticEmail" class="form-label">Name</label>
				<div class="col">
					<spform:input path="name" cssClass="form-control" type="text" />
				</div>
			</div>
			<div class="mb-3 row">
				<label for="staticEmail" class="form-label">Salary</label>
				<div class="col">
					<spform:input path="salary" cssClass="form-control" type="text" />
				</div>
			</div>
			<div class="mb-3 row">
				<label for="staticEmail" class="form-label">Designation</label>
				<div class="col">
					<spform:input path="designation" cssClass="form-control" type="text" />
				</div>
			</div>
			<button class="btn btn-primary" type="submit">Save</button>
	    </div>
	</spform:form>
</div>
<%@ include file="/WEB-INF/view/footer.jsp"%>
