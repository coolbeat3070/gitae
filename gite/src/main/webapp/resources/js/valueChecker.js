

function trim(text){
	return text.replace(/(^\s*)|(\s*$)/g, ""); 
}

function isEmptyOrWhitespaceOnly(text){
	text = trim(text);
	return text == "";
}

function lengthEnough(text, length, maxLength){
	if(text.length < length)
		return false;
	
	if(maxLength != null){
		if(text.length > maxLength)
			return false;
	}
	
	return true;
}

function isWhitespaceInserted(text){
	for(var i=0; i<text.length; i++){
		var ch = text.charAt(i);
		if(ch == ' ')
			return true;
	}
	
	return false;
}

function checkIdAlphaNumeric(id){
	for(var i=0; i<id.length; i++){
		ch = id.charAt(i);
		
		if( !(ch >= '0' && ch <= '9')
				&&
			!(ch >= 'a' && ch <= 'z')
				&&
			!(ch >= 'A' && ch <= 'Z')
		){
			return false;
		}
	}
	
	
	return true;
}


