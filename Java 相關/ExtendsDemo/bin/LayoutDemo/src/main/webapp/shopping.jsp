<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="./js/html5-qrcode.js"></script>

<%@ include file="/WEB-INF/view/header.jsp" %>
<div style="padding-top:5rem">
	
	<div class="d-flex flex-column justify-content-center align-items-center">
		<div id="reader" width="300px"></div>
		<div id="result" class="my-5"></div>
	</div>

    <script>
    
    	var g_decodedText = '';
    
        function onScanSuccess(decodedText, decodedResult) {
        	if(g_decodedText == decodedText) {
        		return;
        	}
        	g_decodedText = decodedText;
            $('#result').load(decodedText);
            $('#html5-qrcode-button-camera-stop').on('click', function() {
            	g_decodedText = '';
            });
            $('#html5-qrcode-button-camera-stop').trigger('click');
            setTimeout(() => {
            	$("#openModal" ).trigger( "click" );
			}, 300);
        }

        var html5QrcodeScanner = new Html5QrcodeScanner("reader", {
             fps: 1000, 
             qrbox: 100,
             rememberLastUsedCamera: false,
         });
        html5QrcodeScanner.render(onScanSuccess);
    </script>
	
</div>


