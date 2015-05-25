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

<form:form commandName="loginCommand" action="/simple/member/loginApply" method="post" name="loginForm">
	<table>
		<tbody>
			<tr>
				<td><label for="id">���̵�</label></td>
				<td><form:input path="id" /></td>
				<td><form:errors path="id" cssStyle="color:red" /></td>
			</tr>	
			
			<tr>
				<td><label for="password">�н�����</label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssStyle="color:red" autocomplete="off" /></td>
			</tr>	
		</tbody>
	</table>
	
	<form:errors cssStyle="color:red;"/>
	
	<button type="submit">�α���</button>
	<a href="/simple/member/joinInput">ȸ������</a>
	<a href="/simple">��������</a>
</form:form>

<script>
document.loginForm.id.focus();

</script>

</body>
</html>