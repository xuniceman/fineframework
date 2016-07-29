<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>智慧免疫云-财务报表专用平台</title>
<%@ include file="/WEB-INF/views/layout/command.jsp"%>
<script type="text/javascript" src="resources/js/home.js"></script>
</head>
<body>
	<div class="header">
		<div class="logo"></div>
	</div>
	<div class="index_box">
		<div class="index_pic"></div>
		<div class="login_box">
			<div class="login_panel">
				<form id="_loginform">
					<div class="login_form">
						<div class="login_form_title">
							登录<span class="error_mes"></span>
						</div>
						<div class="login_text_u">
							<div class="icon"></div>
							<input id="_username" type="text" name="username" placeholder="用户名">
						</div>
						<div class="login_text_p">
							<div class="icon"></div>
							<input id="_userpwd" type="password" name="userpwd" placeholder="密码">
						</div>
						<div class="login_code">
							<input id="_usercode" type="text" name="usercode" placeholder="验证码">
							<div class="login_code_pic">
								<img alt="" src="makecode/make">
							</div>
							<div class="login_code_btn">
								<a href="javascript:void(0);" id="codeimg">换一张</a>
							</div>
						</div>
						<div class="login_btn">
							<a href="javascript:void(0);">登录</a>
						</div>
						<div class="login_forgot_pwd">
							<a href="#">忘记密码</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="index_mes_box">
		<ul class="index_mes_layout">
			<li>
				<div>系统公告</div>
				<ul class="index_mes">
					<li><span>沈苏公司智慧免疫云--财务报表专用平台</span></li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="index_footer">沈苏公司研制</div>
</body>
</html>
