<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
    
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><tiles:getAsString name="title"/></title>

<link rel="shortcut icon" href="/simple/resources/favicon/favicon.ico" />

</head>
<body>

<div id="wrap">
	<tiles:insertAttribute name="topMenus" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</div>



</body>
</html>