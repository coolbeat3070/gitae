<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Simple Web 2</title>

<script src="http://code.jquery.com/jquery-1.9.0.js"></script>

<script src="/simple/resources/js/valueChecker.js"></script>


</head>
<body>

<table>
	<tbody>
		<tr>
			<td width="100">No : ${command.bbsNo }</td>
			<td width="400">Title : ${command.title }</td>
			<td width="150">View Count : ${command.viewCnt }</td>
		</tr>
		
		<tr>
			<td width="200">작성자ID : ${command.userId }</td>
			<td width="200">작성일 : ${command.regDateStringType }</td>
		</tr>
	</tbody>
</table>

<hr>
	<div style="border:1px solid black; width:600px; min-height:300px; overflow:auto;">${command.content }</div>

	<%-- 댓글 시스템 --%>
	<div style="width:600px; overflow-y:auto; background-color:#BDBDBD; margin-top:50px; margin-bottom:50px;">
		
		<c:if test="${!empty loginInfo }">
			<div style="border-bottom:2px dotted black;">
				<textarea id="reply_content" placeholder="댓글을 입력해주세요"></textarea>
				<button id="replySubmit">등록</button>
			</div>
		</c:if>
		
		<div id="replies"></div>
	</div>

<c:if test="${!empty loginInfo }">
<script>

$("#replySubmit").click(function(){
	
	var content = $("#reply_content").val();
	content = trim(content);
	
	if(content == "")
		return;
	 
	var param = {
		content : content,
		bbsNo : ${command.bbsNo}
	};
	
	var jqXHR = $.ajax({
		url : "/simple/bbs/addReply",
		type: "post",
		dataType : "html",
		data : param
	});
	
	jqXHR.done(function(){
		loadReplyInfo(${command.bbsNo});	
	});
});

</script>
</c:if>


<script>

function loadReplyInfo(bbsNo){

	var param = { "bbsNo" : bbsNo };
	
	var jqXHR = $.ajax({
		url : "/simple/bbs/getReplies",
		type : "get",
		dataType : "html",
		data : param
	});
	
	jqXHR.done(function(data){
		$("#replies").html(data);
	});
}

loadReplyInfo(${command.bbsNo});



</script>	

	
<hr/>
<a href="javascript:backToBbsList('${pageNo }', '${keyword }');">목록으로</a>
<a href="javascript:history.back();">뒤로가기</a>

<script>
function backToBbsList(pageNo, keyword){
	
	var url = "/simple/bbs/list";

	url += "?pageNo=" + pageNo;
	
	if(keyword != null && trim(keyword) != ""){
		url += "&keyword=" + escape(encodeURIComponent(keyword));
	}
	
	location.href = url;
} 


</script>


</body>
</html>