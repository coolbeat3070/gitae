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
				<td><form:input path="id" placeholder="아이디를 입력해주세요" onblur="checkIdValid();"  style="ime-mode:disabled;"/></td>
				<td><p id="text_idValid"></p><form:errors path="id" cssStyle="color:red;" /></td>
			</tr>
			
			<tr>
				<td><label for="password">PASSWORD</label></td>
				<td><form:password path="password" placeholder="비밀번호를 입력해주세요" onblur="checkPasswordValue();checkPasswordConfirmValue();" autocomplete="off"/></td>
				<td><p id="text_passwordValid"></p><form:errors path="password" cssStyle="color:red;" /></td>
			</tr>
			
			<tr>
				<td><label for="passwordConfirm">PASSWORD CONFIRM</label></td>
				<td><form:password path="passwordConfirm" placeholder="비밀번호를 다시 입력해주세요" onblur="checkPasswordValue(); checkPasswordConfirmValue()" autocomplete="off" /></td>
				<td><p id="text_passwordConfirmValid"></p><form:errors path="passwordConfirm" cssStyle="color:red;" /></td>
			</tr>
			
			<tr>
				<td><label for="name">NAME</label></td>
				<td><form:input path="name" placeholder="이름을 입력해주세요" onblur="checkNameValue();" autocomplete="off" /></td>
				<td><p id="text_nameValid"></p><form:errors path="name" cssStyle="color:red;" /></td>
			</tr>
		</tbody>
	</table>
	
	<button type="submit">회원가입</button>
	<a href="javascript:history.back();">뒤로가기</a>
</form:form>

<script>

var isIdValid = false;
var isPasswordValid = false;
var isPasswordConfirmValid = false;
var isNameValid = false;


// 아이디 검사
function checkIdValid(){
	var id = $("#id").val();
	
	// 공백체크
	if(isEmptyOrWhitespaceOnly(id)){
		$("#text_idValid").css("color", "red");
		$("#text_idValid").text("아이디를 입력해주세요");
		isIdValid = false;
		return;
	}
	
	// 길이체크
	if(!lengthEnough(id, 6, 12)){
		$("#text_idValid").css("color", "red");
		$("#text_idValid").text("아이디는 6자리 이상 12자리 미만이어야 합니다");
		isIdValid = false;
		return;
	}
	
	// 텍스트 사이에 있는 공백체크
	if(isWhitespaceInserted(id)){
		$("#text_idValid").css("color", "red");
		$("#text_idValid").text("아이디에 공백이 들어갈 수 없습니다");
		isIdValid = false;
		return;
	}
	
	// 아이디가 영문과 숫자로 조합되었는지 체크
	if(!checkIdAlphaNumeric(id)){
		$("#text_idValid").css("color", "red");
		$("#text_idValid").text("아이디는 영문과 숫자의 조합으로만 만들 수 있습니다");
		isIdValid = false;
		return;
	}
	
	// 아이디 중복검사
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
			$("#text_idValid").text("이 아이디는 현재 다른 사용자가 사용하고 있습니다");
			isIdValid = false;
		}else{
			$("#text_idValid").css("color", "green");
			$("#text_idValid").text("사용하실 수 있는 아이디입니다");
			isIdValid = true;
		}
			
	});   
}

// 비밀번호 검사
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


// 비밀번호 재확인 검사
function checkPasswordConfirmValue(){
	var password = $("#password").val();
	var passwordConfirm = $("#passwordConfirm").val();
	
	// 공백체크
	if(isEmptyOrWhitespaceOnly(passwordConfirm)){
		$("#text_passwordConfirmValid").css("color", "red");
		$("#text_passwordConfirmValid").text("확인 비밀번호를 입력해주세요");
		isPasswordConfirmValid = false;
		return;
	}
	
	if(password != passwordConfirm){
		$("#text_passwordConfirmValid").css("color", "red");
		$("#text_passwordConfirmValid").text("비밀번호와 확인 비밀번호를 같게 입력해주세요");
		isPasswordConfirmValid = false;
		return;
	}
	
	$("#text_passwordConfirmValid").css("color", "green");
	$("#text_passwordConfirmValid").text("비밀번호와 확인비밀번호 일치");
	isPasswordConfirmValid = true;	 
}


// 이름 검사
function checkNameValue(){
	var name = $("#name").val();
	
	// 공백체크
	if(isEmptyOrWhitespaceOnly(name)){
		$("#text_nameValid").css("color", "red");
		$("#text_nameValid").text("이름을 입력해주세요");
		isNameValid = false;
		return;
	}
	
	// 길이체크
	if(!lengthEnough(name, 2, 12)){
		$("#text_nameValid").css("color", "red");
		$("#text_nameValid").text("이름은 2자리 이상 12자리 미만이어야 합니다");
		isNameValid = false;
		return;
	}
	
	// 텍스트 사이에 있는 공백체크
	if(isWhitespaceInserted(name)){
		$("#text_nameValid").css("color", "red");
		$("#text_nameValid").text("이름에 공백이 들어갈 수 없습니다");
		isNameValid = false;
		return;
	} 
	
	$("#text_nameValid").css("color", "green");
	$("#text_nameValid").text("유효한 이름 입력");
	isNameValid = true; 
}


// submit 하기 전에 각 필드값 유효 플래그 검사
function isFieldsValid(){
	if( !isIdValid || !isPasswordValid || !isPasswordConfirmValid || !isNameValid )
		return false;
	 
	return true;
}
 
</script>


</body>
</html>