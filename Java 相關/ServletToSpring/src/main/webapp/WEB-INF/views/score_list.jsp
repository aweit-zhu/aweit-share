<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<%-- ${ scores } --%>
<%-- ${ totalPage }--%>
<%-- ${ currentPage }--%>

<div class="d-flex flex-column" style="width:500px">
	<table class="table">
	  <thead>
	    <tr>
			<th scope="col" style="width: 50px;">ID</th>
	      	<th scope="col" style="width: 50px;">學生</th>
	      	<th scope="col" style="width: 100px;">國文</th>
	     	<th scope="col" style="width: 100px;">英文</th>
	      	<th scope="col" style="width: 100px;">數學</th>
	      	<th scope="col" style="width: 100px;">自然</th>
	      	<th scope="col" style="width: 100px;">社會</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${ scores }" var="score">
	    	<tr>
		      <th scope="row">${ score.studentId }</th>
		      <td>${ score.studentName }</td>
		      <td>${ score.chinese }</td>
		      <td>${ score.english }</td>
		      <td>${ score.math }</td>
		      <td>${ score.science }</td>
		      <td>${ score.social }</td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	
	<nav class="d-flex justify-content-end me-2">
	  <ul class="pagination">
	    <li class="page-item"><a class="page-link" href="/ServletToSpring/mvc/score?currentPage=${ (currentPage - 1) <= 0 ? 1: currentPage - 1}">Previous</a></li>
	    <c:forEach begin="1" end="${ totalPage }" varStatus="loop">
	      <li class="page-item">
	      	<a class="page-link" href="/ServletToSpring/mvc/score?currentPage=${loop.index}">${loop.index}</a>
	      </li>
	    </c:forEach>
	    <li class="page-item"><a class="page-link" href="/ServletToSpring/mvc/score?currentPage=${ (currentPage + 1) >= totalPage ? totalPage: currentPage + 1  }">Next</a></li>
	  </ul>
	</nav>
</div>