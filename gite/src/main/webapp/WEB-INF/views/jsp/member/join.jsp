<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Simple Web 2 Join</title>

<script src="http://code.jquery.com/jquery-1.9.0.js"></script>

<script src="/simple/resources/js/valueChecker.js"></script>

</head>
<body>

<form:form action="/simple/member/joinApply" method="post" commandName="joinCommand" name="joinForm" onsubmit="return isFieldsValid();">
	<table>
		<tbody>
			<tr>
				<td><label for="id">ID</label></td>
				<td><form:input path="id" placeholder="���̵� �Է����ּ���" onblur="checkIdValid();"  style="ime-mode:disabled;"/></td>
				<td><p id="text_idValid"></p><form:errors path="id" cssStyle="color:red;" /></td>
			</tr>
			
			<tr>
				<td><label for="password">PASSWORD</label></td>
				<td><form:password path="password" placeholder="��й�ȣ�� �Է����ּ���" onblur="checkPasswordValue();checkPasswordConfirmValue();" autocomplete="off"/></td>
				<td><p id="text_passwordValid"></p><form:errors path="password" cssStyle="color:red;" /></td>
			</tr>
			
			<tr>
				<td><label for="passwordConfirm">PASSWORD CONFIRM</label></td>
				<td><form:password path="passwordConfirm" placeholder="��й�ȣ�� �ٽ� �Է����ּ���" onblur="checkPasswordValue(); checkPasswordConfirmValue()" autocomplete="off" /></td>
				<td><p id="text_passwordConfirmValid"></p><form:errors path="passwordConfirm" cssStyle="color:red;" /></td>
			</tr>
			
			<tr>
				<td><label for="name">NAME</label></td>
				<td><form:input path="name" placeholder="�̸��� �Է����ּ���" onblur="checkNameValue();" autocomplete="off" /></td>
				<td><p id="text_nameValid"></p><form:errors path="name" cssStyle="color:red;" /></td>
			</tr>
		</tbody>
	</table>
	
	<button type="submit">ȸ������</button>
	<a href="javascript:history.back();">�ڷΰ���</a>
</form:form>

<script>

var isIdValid = false;
var isPasswordValid = false;
var isPasswordConfirmValid = false;
var isNameValid = false;


// ���̵� �˻�
function checkIdValid(){
	var id = $("#id").val();
	
	// ����üũ
	if(isEmptyOrWhitespaceOnly(id)){
		$("#text_idValid").css("color", "red");
		$("#text_idValid").text("���̵� �Է����ּ���");
		isIdValid = false;
		return;
	}
	
	// ����üũ
	if(!lengthEnough(id, 6, 12)){
		$("#text_idValid").css("color", "red");
		$("#text_idValid").text("���̵�� 6�ڸ� �̻� 12�ڸ� �̸��̾�� �մϴ�");
		isIdValid = false;
		return;
	}
	
	// �ؽ�Ʈ ���̿� �ִ� ����üũ
	if(isWhitespaceInserted(id)){
		$("#text_idValid").css("color", "red");
		$("#text_idValid").text("���̵� ������ �� �� �����ϴ�");
		isIdValid = false;
		return;
	}
	
	// ���̵� ������ ���ڷ� ���յǾ����� üũ
	if(!checkIdAlphaNumeric(id)){
		$("#text_idValid").css("color", "red");
		$("#text_idValid").text("���̵�� ������ ������ �������θ� ���� �� �ֽ��ϴ�");
		isIdValid = false;
		return;
	}
	
	// ���̵� �ߺ��˻�
	var jqXHR = $.ajax({
		url : "/simple/member/checkIdDuplicate",
		type : "post",
		datatype : "json",
		
		data : {
			id : escape(encodeURIComponent(id))		
		}
	});
	jqXHR.done(function(data, textStatus){
		if(data.duplicate){
			$("#text_idValid").css("color", "red");
			$("#text_idValid").text("�� ���̵�� ���� �ٸ� ����ڰ� ����ϰ� �ֽ��ϴ�");
			isIdValid = false;
		}else{
			$("#text_idValid").css("color", "green");
			$("#text_idValid").text("����Ͻ� �� �ִ� ���̵��Դϴ�");
			isIdValid = true;
		}
			
	});   
}

// ��й�ȣ �˻�
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


// ��й�ȣ ��Ȯ�� �˻�
function checkPasswordConfirmValue(){
	var password = $("#password").val();
	var passwordConfirm = $("#passwordConfirm").val();
	
	// ����üũ
	if(isEmptyOrWhitespaceOnly(passwordConfirm)){
		$("#text_passwordConfirmValid").css("color", "red");
		$("#text_passwordConfirmValid").text("Ȯ�� ��й�ȣ�� �Է����ּ���");
		isPasswordConfirmValid = false;
		return;
	}
	
	if(password != passwordConfirm){
		$("#text_passwordConfirmValid").css("color", "red");
		$("#text_passwordConfirmValid").text("��й�ȣ�� Ȯ�� ��й�ȣ�� ���� �Է����ּ���");
		isPasswordConfirmValid = false;
		return;
	}
	
	$("#text_passwordConfirmValid").css("color", "green");
	$("#text_passwordConfirmValid").text("��й�ȣ�� Ȯ�κ�й�ȣ ��ġ");
	isPasswordConfirmValid = true;	 
}


// �̸� �˻�
function checkNameValue(){
	var name = $("#name").val();
	
	// ����üũ
	if(isEmptyOrWhitespaceOnly(name)){
		$("#text_nameValid").css("color", "red");
		$("#text_nameValid").text("�̸��� �Է����ּ���");
		isNameValid = false;
		return;
	}
	
	// ����üũ
	if(!lengthEnough(name, 2, 12)){
		$("#text_nameValid").css("color", "red");
		$("#text_nameValid").text("�̸��� 2�ڸ� �̻� 12�ڸ� �̸��̾�� �մϴ�");
		isNameValid = false;
		return;
	}
	
	// �ؽ�Ʈ ���̿� �ִ� ����üũ
	if(isWhitespaceInserted(name)){
		$("#text_nameValid").css("color", "red");
		$("#text_nameValid").text("�̸��� ������ �� �� �����ϴ�");
		isNameValid = false;
		return;
	} 
	
	$("#text_nameValid").css("color", "green");
	$("#text_nameValid").text("��ȿ�� �̸� �Է�");
	isNameValid = true; 
}


// submit �ϱ� ���� �� �ʵ尪 ��ȿ �÷��� �˻�
function isFieldsValid(){
	if( !isIdValid || !isPasswordValid || !isPasswordConfirmValid || !isNameValid )
		return false;
	 
	return true;
}
 
</script>


</body>
</html>