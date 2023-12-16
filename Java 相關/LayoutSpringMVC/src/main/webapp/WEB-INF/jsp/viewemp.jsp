<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="/WEB-INF/view/header.jsp"%>
<div class="w-100 vh-100" style="min-height:100%;padding-top:5rem">
	<%-- ${list} --%>
	<ol class="list-group list-group-numbered">
		<c:forEach items="${ list }" var="emp">
		  <li class="list-group-item d-flex justify-content-between align-items-start">
		    <div class="ms-2 me-auto">
		      <div class="fw-bold"> ${ emp.name }</div>
		       薪水：${ emp.salary }
		       職業：${ emp.designation }
		    </div>
		  </li>
		</c:forEach>
	</ol>
</div>
<%@ include file="/WEB-INF/view/footer.jsp"%>
	
