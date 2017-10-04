function sendAjaxQuery() {
	$.ajax({
		url :'user.servlet', //gidecegi, istekte bulunacağımız servlet.
		method :'POST',
		data : {
			nameJava: $('#firstName').val() //datayı post ediyoruz.
			//nameJava, servlet kısmında. #firstName jsp kisminda kullanılacak.
		},
		success : function(responseText) {
			$('#ajaxGetUserServletResponse').text(responseText); //gelen cevabı aynı sayfada güncelleme.
		}
	});
}