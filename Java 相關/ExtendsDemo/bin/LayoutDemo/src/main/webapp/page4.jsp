<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/view/header.jsp" %>

<div class="w-100 h-100" style="min-height:100%;padding-top:5rem">
	<h3 class="text-center">檔案上傳</h3>
	<div class="d-flex justify-content-center">
		<form class="row g-3 needs-validation col-12 col-lg-6" novalidate 
		      action="./upload" 
		      method="post" 
		      enctype="multipart/form-data">
		      
		    <div>
				<label for="username" class="form-label">Username</label> <input
					type="text" class="form-control" id="username" name="username"
					value="" required>
				<div class="invalid-feedback">請輸入Username</div>
			</div>
			
			<div class="mb-3">
				<label class="btn btn-outline-primary w-100"> 
				<input type="file"
				       id="upfile"
				       name="upfile"
				       multiple
					   class="upfile d-none"
					   accept=".jpg, .jpeg, .png, .gif"
					   required>
					上傳檔案
					<div class="invalid-feedback">請上傳證明文件</div>
				</label>
			</div>
			<div id="img_area" class="text-center"></div>
			<div class="col-12 d-flex justify-content-center">
				<button class="btn btn-primary" type="submit">Submit form</button>
			</div>
        </form>
	</div>
</div>


<%@ include file="/WEB-INF/view/footer.jsp" %>
    