<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/view/header.jsp" %>

<div class="w-100 h-100" style="min-height:100%;padding-top:5rem">
	<h3 class="text-center">檔案下載</h3>
	<div class="d-flex justify-content-center">
		<button class="btn btn-primary mx-4" type="submit" onclick="window.location.href='./download?filename=Java班第1梯次課表.xlsx'">Java班第1梯次課表.xlsx</button>
		<button class="btn btn-success mx-4" type="submit" onclick="window.location.href='./download?filename=Java程式設計入門1.pdf'">Java程式設計入門1.pdf</button>
	</div>
</div>


<%@ include file="/WEB-INF/view/footer.jsp" %>
    