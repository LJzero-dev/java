<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/addr_api.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.4.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<p>우편번호 : 
<input type="text" id="sample4_postcode" placeholder="우편번호" readonly="readonly">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
</p>
<p>주소 : 
<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" id="sample4_detailAddress" placeholder="상세주소">
<span id="guide" style="color:#999;display:none;position:absolute; top:-500px;left:-500px;"></span>
</p>
</body>
</html>