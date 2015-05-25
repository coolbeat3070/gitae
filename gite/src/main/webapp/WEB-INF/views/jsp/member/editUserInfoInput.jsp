<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Simple Web 2</title>

<script src="http://code.jquery.com/jquery-1.9.0.js"></script>

</head>
<body>

<form:form action="/simple/member/editUserInfoApply" method="post" commandName="userInfoCommand">
	<table>
		<tbody>
			<tr>
				<td><label for="id">아이디</label></td>
				<td><form:input path="id" disabled="true" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><a href="javascript:passwordChangeFormOpen();">비밀번호 변경</a></td>
			</tr>
			
			<tr>
				<td><label for="name">이름</label></td>
				<td><form:input path="name" /></td>
			</tr>
		</tbody>	
	</table>
	
	<button type="submit">변경</button>
	<a href="javascript:history.back();">뒤로가기</a>
</form:form>

<script>

function passwordChangeFormOpen(){

	var win;
	var url = "/simple/member/prePasswordChangeForm";
	var name = "prePasswordChangeForm"
	var winWidth = 400, winHeight = 400;
	var winLocationX = (screen.width - winWidth) / 2;
	var winLocationY = (screen.height - winHeight) / 2;
	var specs = "width=" + winWidth + ", height=" + winHeight + ", left=" + winLocationX + ", top=" + winLocationY;
	
	win = window.open(url, name, specs);  
}

</script>

</body>
</html>