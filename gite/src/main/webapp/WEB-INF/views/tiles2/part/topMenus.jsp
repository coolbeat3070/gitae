<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<section>
	메뉴 부분
	<nav>
		<c:choose>
			<c:when test="${empty loginInfo.id }">
				<a href="/simple/member/loginInput">로그인</a>
				<a href="/simple/member/joinInput">회원가입</a>
			</c:when>
			<c:otherwise>
				<a href="/simple/member/editUserInfoInput">정보수정</a>
				<a href="/simple/member/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
		
		<a href="/simple/bbs/list">게시판</a>
	</nav>
</section>

<hr/>	