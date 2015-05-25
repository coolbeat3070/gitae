<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Simple Web 2</title>
</head>
<body>


<h3>비밀번호 확인</h3>
<form:form method="post" action="/simple/member/passwordChangeForm" commandName="passwordChangeCommand">
	<input type="password" name="password" />
	<form:errors cssStyle="color:red;" />
	<button type="submit">확인</button>
</form:form>


</body>
</html>