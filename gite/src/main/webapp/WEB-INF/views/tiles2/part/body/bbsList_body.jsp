<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${!empty bbsWriteNewSuccessMessage }">

<script>

alert("${bbsWriteNewSuccessMessage}");

</script>

</c:if>

<style>

th{
	border:1px solid purple;
}

td{
	border-bottom:1px dotted black;
	text-align:center;
}

</style>

<%
	/* String keyword = request.getParameter("keyword"); 
	
	if(keyword != null){
		try{
			keyword = new String(keyword.getBytes("iso-8859-1"), "EUC-KR");
		}catch(java.io.UnsupportedEncodingException e){
			throw new java.lang.RuntimeException(e);
		}
		
		try{
			keyword = java.net.URLDecoder.decode(keyword, "UTF-8");
		}catch(java.io.UnsupportedEncodingException e){
			throw new RuntimeException(e);
		}
		
		System.out.println("LIST PAGE KEYWORD : " + keyword);
	}
	
	
	
	String pageNo = request.getParameter("pageNo");
	try{
		Integer.parseInt(pageNo);
	}catch(NumberFormatException e){
		pageNo = "1";
	} */
%>


<section id="bbsListWrap">

	<table style="margin-top:100px;">
		<colgroup>
			<col width="200" />
			<col width="600" />
			<col width="150" />
			<col width="150" />
			<col width="300" />
		</colgroup>
		<thead>
			<tr>
				<th>No</th>
				<th>Title</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${articleList }" var="article">
				<tr>
					<td>${article.bbsNo }</td>
					
					<td>
						<c:choose>
							<c:when test="${empty keyword }">
								<a href="javascript:viewArticle('${article.bbsNo}', '${pageNo }');">${article.title }</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:viewArticle('${article.bbsNo}', '${pageNo }', '${keyword }' );">${article.title }</a>							
							</c:otherwise>
						</c:choose>
						<p style="text-overflow:ellipsis; width:600px; max-height:150px;">${article.preContents }</p>
					</td>
					
					<td>${article.userId }</td>
					
					<td>${article.viewCnt }</td>
					
					<td>${article.regDateStringType }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<div id="paging" style="text-align:center; margin-top:50px;">
		<%-- 페이징 --%>
		<%
		
		 	BbsPaging paging = (BbsPaging) request.getAttribute("paging");
			String keyword = (String) request.getAttribute("keyword");
			System.out.println("IN LIST PAGE, KEYWORD : " + keyword);
			
			
			if(paging.isActivatePrevButton()){
				if(keyword == null || keyword.equals("")){
					// System.out.println("check here 1  =================================");
					out.println("[<a href=\"javascript:page(" + paging.getLeftButtonPageNum() + ")\">&lt;</a>]");
				}else{
					// System.out.println("check here 2  =================================");
					out.println("[<a href=\"javascript:page(" + paging.getLeftButtonPageNum() + ", '" + keyword + "')\">&lt;</a>]");
				}
			}
			   
			for(int i=paging.getStartPageNum(); i<=paging.getEndPageNum(); i++){
				if(i == paging.getPagePos())
					out.println("<span>" + i +"</span>");
				else{     
					if(keyword == null || keyword.equals(""))
						out.println("[<a href=\"javascript:page(" + i + ")\">" + i +"</a>]");
					else
						out.println("[<a href=\"javascript:page(" + i + ", '" + keyword + "')\">" + i +"</a>]");
					
				}
			}
			   
			if(paging.isActivateNextButton()){
				if(keyword == null || keyword.equals(""))
					out.println("[<a href=\"javascript:page(" + (paging.getEndPageNum()+1) + ")\">&gt;</a>]");
				else
					out.println("[<a href=\"javascript:page(" + (paging.getEndPageNum()+1) + ", '" + keyword + "')\">&gt;</a>]");
			}
		 
		%>
	</div>
	
	<div style="text-align:center; margin-top:30px;">
		<form action="/simple/bbs/list" method="get">
			<input type="text" name="keyword" placeholder="검색어를 입력해주세요" />
			<button type="submit">검색</button>				
		</form>
	</div>


	<c:if test="${!empty loginInfo }">
		<p style="margin-top:100px;"><a href="/simple/bbs/writeForm">글쓰기</a></p>
	</c:if>


	

	
	
</section>

<script>
/* 
function viewArticle(bbsNo){
	location.href="/simple/bbs/viewArticle?bbsNo=" + bbsNo;
} */


function viewArticle(bbsNo, pageNo, keyword){
	var url = "/simple/bbs/viewArticle?bbsNo=" + bbsNo;
	
	if(pageNo != null)
		url += "&pageNo=" + pageNo;
	if(keyword != null)
		url += "&keyword=" + keyword;
	
	location.href = url;
}


function page(pageNo, keyword){

	var url = "/simple/bbs/list";
	url += "?pageNo=" + pageNo;
	if(keyword != null )
		url+= "&keyword=" + keyword;
	
	location.href = url; 
} 

</script>
