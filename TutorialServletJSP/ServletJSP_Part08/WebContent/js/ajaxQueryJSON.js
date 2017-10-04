function sendAjaxQueryJSON(){
	// formdaki alanları name, surname, gender degerlerine atıyorum.
	var postData = {
			name:$('#firstName').val(),
			surname:$('#lastName').val(),
			gender:$('#gender').val()
	};
	
	$.ajax({
		url:'person.servlet',
		method:'POST',
		data:JSON.stringify(postData), //datayı json'dan gecirmek
		contentType:"application/json; charset=utf-8",
		dataType:"json",
		success:function(responseText){
			$('#ajaxGetUserServletResponse').text(responseText.message);
		}
	});
}