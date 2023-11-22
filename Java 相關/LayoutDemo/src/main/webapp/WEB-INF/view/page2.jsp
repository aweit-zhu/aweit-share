<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/view/header.jsp"%>

<!-- FullCalendar -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.9/index.global.min.js'></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth',
			events : [ {
				title : '公司建議休假',
				start : '2023-11-22',
				end : '2023-11-25',
				color : 'red'
			}, ]
		});
		calendar.render();
		//calendar.on('dateClick', function(info) {
		//   console.log('clicked on ' + info.dateStr);
		//});
	});
</script>

<div class="w-100 h-100" style="padding-top: 5rem">
	<div
		class="d-flex flex-column flex-lg-row justify-content-center mx-5 align-items-center">
		<form id="form1" class="row g-3 needs-validation col-12 col-lg-6" novalidate 
		      action="./page2" method="post" enctype="multipart/form-data" onsubmit="return check()">
			<h4 class="text-center">請假表單</h4>

			<!-- 文字輸入框 -->
			<div>
				<label for="username" class="form-label">Username</label> <input
					type="text" class="form-control" id="username" name="username"
					value="${sessionScope.username}" required>
				<div class="invalid-feedback">請輸入Username</div>
			</div>

			<!-- 下拉選單 -->
			<div>
				<label for="type" class="form-label">假別</label> <select
					class="form-select" id="type" name="type" required>
					<option selected disabled value="">Choose...</option>
					<option value="1">事假</option>
					<option value="2">病假</option>
					<option value="3">特休假</option>
				</select>
				<div class="valid-feedback">OK</div>
				<div class="invalid-feedback">Please select a valid state.</div>
			</div>

			<!-- 日期 -->
			<div class="col-lg-6">
				<label for="start_date" class="form-label">起始日期</label> <input
					type="date" class="form-control" id="start_date" name="start_date"
					value="" required>
				<div class="invalid-feedback">請輸入起始日期</div>
			</div>
			<div class="col-lg-6">
				<label for="end_date" class="form-label">結束日期</label> <input
					type="date" class="form-control" id="end_date" name="end_date"
					value="" required>
				<div class="invalid-feedback">請輸入結束日期</div>
			</div>

			<!-- 檔案上傳 -->
			<div class="mb-3">
				<label class="btn btn-outline-primary w-100"> <input
					type="file" name="upfile[]" id="upfile" multiple
					class="upfile d-none" accept=".jpg, .jpeg, .png, .gif" required>
					上傳檔案
					<div class="invalid-feedback">請上傳證明文件</div>
				</label>
				<div id="img_area" class="text-center"></div>
			</div>

			<!-- 多行文字 -->
			<div>
				<label for="memo" class="form-label">備註</label>
				<textarea class="form-control" id="memo" name="memo" rows="3"
					required></textarea>
				<div class="invalid-feedback">請輸入備註</div>
			</div>

			<div class="col-12 d-flex justify-content-center">
				<button class="btn btn-primary" type="submit">Submit form</button>
			</div>
		</form>
		<div id='calendar'
			class="mx-5 flex-shrink-0 flex-frow-0 border border-white"></div>
	</div>
</div>

<%--@ include file="/WEB-INF/view/footer.jsp" --%>

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

	$('#upfile').on('change', function(e) {
		let fileInfo = '<font color="blue">';
		$(e.target.files).each(function(i, obj) {
			let fileName = obj.name;
			fileInfo += ' ' + fileName;
		});
		fileInfo += "</font>";
		$('#img_area').html(fileInfo);
	});
	
	function check() {
		
		let start_date = $('#start_date').val();
		let end_date = $('#end_date').val();

		if(Date.parse(start_date) > Date.parse(end_date)) {
			$('#start_date').removeClass('is-valid');
			$('#end_date').removeClass('is-valid ');
			$('#start_date').addClass('is-invalid ');
			$('#end_date').addClass('is-invalid ');
			$('#start_date').val('');
			$('#end_date').val('');
			return false;
		}
		return false;
	}
</script>