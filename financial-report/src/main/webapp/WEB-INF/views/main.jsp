<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>智慧免疫云-财务报表专用平台</title>
<%@ include file="/WEB-INF/views/layout/command.jsp"%>
<script type="text/javascript" src="resources/js/main.js"></script>
</head>
<body>
	<div class="header">
		<div class="logo">
			<ul class="head_menu">
				<li class="head_menu_logout"><a href="javascript:void(0);">退出</a></li>
				<li class="head_menu_space">|</li>
				<li class="head_menu_mail"><a href="javascript:void(0);"></a></li>
				<li class="head_menu_mes">浙江省超级管理员</li>
			</ul>
		</div>
	</div>
	<!-- 视图主体 -->
	<div class="main">
		<div class="main_left">
			<jsp:include page="layout/left.jsp"/>
		</div>
		<div class="main_right">dd</div>
		<div class="clear"></div>
	</div>
	<!-- 视图主体end -->
</body>
</html>
