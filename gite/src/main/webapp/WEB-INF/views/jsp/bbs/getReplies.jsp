<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${!empty replyList }">
		<c:forEach items="${replyList }" var="replyCommand">
			<p>
				<span>${replyCommand.writerId }</span>
				${replyCommand.content }
			</p>
		</c:forEach>		
	</c:when>

	<c:otherwise>
		<h2>댓글이 없습니다.</h2>
	</c:otherwise>
</c:choose>