$(document).ready(function() {

	if ($('.validate').length > 0) {
		$('.validate').validate({
			errorPlacement : function(error, element) {
				alert(error);
				$(".error_mes").append(error);
			}
		});
	}
});
