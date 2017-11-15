$(document).ready(function() {

	if ($('#validate').length > 0) {
		$('#validate').validate({
			errorPlacement : function(error, element) {
				element.parent().append("&nbsp;&nbsp;");
				element.parent().append(error.html());
				element.parent().css("color","red");
			}
		});
	}
});
