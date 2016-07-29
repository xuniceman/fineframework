<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>智慧免疫云-财务报表专用平台</title>
<%@ include file="/WEB-INF/views/layout/command.jsp"%>
</head>
<body>
	<!-- bar start -->
	<div class="content_bar">
		<strong>系统设置</strong> > 系统模块管理
	</div>
	<!-- bar end -->
	<!-- condition box -->
	<form action="">
		<ul class="condition_box">
			<li class="condition_lable">上级模块</li>
			<li class="condition_input"><input type="text"
				class="input_text"></li>
			<li class="condition_lable">模块编码</li>
			<li class="condition_input"><input type="text"
				class="input_text"></li>
		</ul>
		<ul class="condition_box">
			<li class="condition_lable">上级模块名称</li>
			<li class="condition_input"><input type="text"
				class="input_text"></li>
			<li class="condition_lable">上级模块简称</li>
			<li class="condition_input"><input type="text"
				class="input_text"></li>
		</ul>
		<ul class="condition_box">
			<li class="condition_lable">开放级别</li>
			<li class="condition_input"><select class="input_select"></select></li>
			<li class="condition_lable">是否启用</li>
			<li class="condition_input"><input type="radio" name="one"
				class="input_radio">启用<input type="radio" name="one"
				class="input_radio">停用</li>
		</ul>
		<ul class="condition_btn_box">
			<li><input type="submit"></li>
			<li><input type="reset"></li>
			<li><input type="button" value="新增"></li>
		</ul>
	</form>
	<hr>
	<!-- condition end -->
	<!-- table -->
	<!-- table end -->
</body>
</html>
