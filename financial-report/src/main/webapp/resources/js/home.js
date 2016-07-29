/**
 * 免疫规划信息系统 首页脚本控制
 */

$(function() {
	$("#codeimg").click(
			function() {
				$(".login_code_pic img").attr("src",
						'makecode/make?' + new Date().getTime());
			});
	// 回车登录事件
	$("#_username").keypress(keyPressEvent);
	$("#_userpwd").keypress(keyPressEvent);
	$("#_usercode").keypress(keyPressEvent);

	// 处理登录
	$(".login_btn a").click(doLogin);
});
// 处理回车登录
function keyPressEvent() {
	if (event.keyCode == 13) {
		doLogin();
	}
}
// 处理登录
function doLogin() {

	// 登录前验证
	var username = $("#_username").val();
	var password = $("#_userpwd").val();
	var usercode = $("#_usercode").val();
	if (!$.trim(username)) {
		alert("请输入用户名");
	} else if (!$.trim(password)) {
		alert("请输入密码");
	} else if (!$.trim(usercode)) {
		alert("请输入验证码");
	} else {
		$.ajax({
			cache : true,
			type : "POST",
			url : "login",
			data : $('#_loginform').serialize(),// 你的formid
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if (data.success) {
					window.location.href = "main";
				} else {
					alert(data.msg);
				}
			}
		});
	}

}