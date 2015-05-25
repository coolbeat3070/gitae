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
	<form:input path="title" placeholder="����" />
	<form:errors path="title" />
	<br/>
	<form:textarea path="content" placeholder="����" />
	<form:errors path="content" />
	<br/>
	
	<button type="submit">���</button>
</form:form>

<script>

var editor = null;
jQuery(function() {
     // ckeditor ����
    ckeditor_config = {
		    	
  		resize_enabled : true,    		
   		filebrowserUploadUrl: "/simple/bbs/file_upload",
   		extraPlugins : "colorbutton,panelbutton",	 
		enterMode : CKEDITOR.ENTER_BR , // ����Ű�� <br> �� ������.
		shiftEnterMode : CKEDITOR.ENTER_P ,  // ����Ʈ +  ���͸� <p> �� ������.
		toolbarCanCollapse : true , 
		removePlugins : "elementspath", // DOM ������� ����
		
		// �����Ϳ� ����� ��ɵ� ����
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

// ������ ���� üũ �Լ�
function form_save() {
	editor.updateElement();
	return true;
} 

</script>

</body>
</html>