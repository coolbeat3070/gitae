<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Simple Web 2</title>

<script src="http://code.jquery.com/jquery-1.9.0.js"></script>

<script src="/simple/resources/js/valueChecker.js"></script>

</head>
<body>



<h2>비밀번호 변경</h2>
<form:form action="/simple/member/changePasswordApply" method="post" onsubmit="return checkFields();" commandName="passwordChangeCommand">
	<form:password path="password" onblur="checkPasswordValue();"/>
	<p id="text_passwordValid"></p>
	<form:errors />

	<button type="submit">등록</button>
	<a href="javascript:window.close();">창닫기</a>
</form:form>

<script>

var isPasswordValid = false;

function checkPasswordValue(){
var password = $("#password").val();
	
	// 공백체크
	if(isEmptyOrWhitespaceOnly(password)){
		$("#text_passwordValid").css("color", "red");
		$("#text_passwordValid").text("비밀번호를 입력해주세요");
		isPasswordValid = false;
		return;
	}
	
	// 길이체크
	if(!lengthEnough(password, 4, 12)){
		$("#text_passwordValid").css("color", "red");
		$("#text_passwordValid").text("비밀번호는 4자리 이상 12자리 미만이어야 합니다");
		isPasswordValid = false;
		return;
	}
	
	// 텍스트 사이에 있는 공백체크
	if(isWhitespaceInserted(password)){
		$("#text_passwordValid").css("color", "red");
		$("#text_passwordValid").text("비밀번호에 공백이 들어갈 수 없습니다");
		isPasswordValid = false;
		return;
	}
	
	$("#text_passwordValid").css("color", "green");
	$("#text_passwordValid").text("사용하실 수 있는 비밀번호입니다");
	isPasswordValid = true;  
}

function checkFields(){
	if(!isPasswordValid)
		return false;
	
	return true;
}

</script>



</body>
</html>