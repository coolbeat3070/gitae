<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<section>
	�޴� �κ�
	<nav>
		<c:choose>
			<c:when test="${empty loginInfo.id }">
				<a href="/simple/member/loginInput">�α���</a>
				<a href="/simple/member/joinInput">ȸ������</a>
			</c:when>
			<c:otherwise>
				<a href="/simple/member/editUserInfoInput">��������</a>
				<a href="/simple/member/logout">�α׾ƿ�</a>
			</c:otherwise>
		</c:choose>
		
		<a href="/simple/bbs/list">�Խ���</a>
	</nav>
</section>

<hr/>	