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



<h2>��й�ȣ ����</h2>
<form:form action="/simple/member/changePasswordApply" method="post" onsubmit="return checkFields();" commandName="passwordChangeCommand">
	<form:password path="password" onblur="checkPasswordValue();"/>
	<p id="text_passwordValid"></p>
	<form:errors />

	<button type="submit">���</button>
	<a href="javascript:window.close();">â�ݱ�</a>
</form:form>

<script>

var isPasswordValid = false;

function checkPasswordValue(){
var password = $("#password").val();
	
	// ����üũ
	if(isEmptyOrWhitespaceOnly(password)){
		$("#text_passwordValid").css("color", "red");
		$("#text_passwordValid").text("��й�ȣ�� �Է����ּ���");
		isPasswordValid = false;
		return;
	}
	
	// ����üũ
	if(!lengthEnough(password, 4, 12)){
		$("#text_passwordValid").css("color", "red");
		$("#text_passwordValid").text("��й�ȣ�� 4�ڸ� �̻� 12�ڸ� �̸��̾�� �մϴ�");
		isPasswordValid = false;
		return;
	}
	
	// �ؽ�Ʈ ���̿� �ִ� ����üũ
	if(isWhitespaceInserted(password)){
		$("#text_passwordValid").css("color", "red");
		$("#text_passwordValid").text("��й�ȣ�� ������ �� �� �����ϴ�");
		isPasswordValid = false;
		return;
	}
	
	$("#text_passwordValid").css("color", "green");
	$("#text_passwordValid").text("����Ͻ� �� �ִ� ��й�ȣ�Դϴ�");
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