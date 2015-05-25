<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
    
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Simple Web 2</title>

<script src="http://code.jquery.com/jquery-1.9.0.js"></script>

<script src="/simple/resources/ckeditor/ckeditor.js"></script>

</head>
<body>

<form:form name="bbsWriteForm" action="/simple/bbs/writeApply" method="post" commandName="bbsWriteCommand" onsubmit="return form_save();">
	<form:input path="title" placeholder="제목" />
	<form:errors path="title" />
	<br/>
	<form:textarea path="content" placeholder="내용" />
	<form:errors path="content" />
	<br/>
	
	<button type="submit">등록</button>
</form:form>

<script>

var editor = null;
jQuery(function() {
     // ckeditor 적용
    ckeditor_config = {
		    	
  		resize_enabled : true,    		
   		filebrowserUploadUrl: "/simple/bbs/file_upload",
   		extraPlugins : "colorbutton,panelbutton",	 
		enterMode : CKEDITOR.ENTER_BR , // 엔터키를 <br> 로 적용함.
		shiftEnterMode : CKEDITOR.ENTER_P ,  // 쉬프트 +  엔터를 <p> 로 적용함.
		toolbarCanCollapse : true , 
		removePlugins : "elementspath", // DOM 출력하지 않음
		
		// 에디터에 사용할 기능들 정의
		toolbar : [
			[ 'Source', '-' , 'NewPage', 'Preview' ],
			[ 'Cut', 'Copy', 'Paste', 'PasteText', '-', 'Undo', 'Redo' ],
			[ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript'],
			[ 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ],
			'/',
			[ 'Styles', 'Format', 'Font', 'FontSize' ],
			[ 'TextColor', 'BGColor' ],
			[ 'Image', 'Flash', 'Table' , 'SpecialChar' , 'Link', 'Unlink']
		]
    };
     
    editor = CKEDITOR.replace( "content" , ckeditor_config );
});

// 전송을 위한 체크 함수
function form_save() {
	editor.updateElement();
	return true;
} 

</script>

</body>
</html>