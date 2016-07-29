<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>智慧免疫云-财务报表专用平台</title>
<%@ include file="/WEB-INF/views/layout/command.jsp"%>

<script type="text/javascript"
	src="../../resources/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="../../resources/js/jquery.metadata.js"></script>
<script type="text/javascript" src="../../resources/js/error.js"></script>
<script type="text/javascript"
	src="../../resources/js/account/sysmoudelform.js"></script>
</head>
<body>
	<!-- bar start -->
	<div class="content_bar">
		<strong>系统设置</strong>&nbsp;&nbsp;>&nbsp;&nbsp;系统模块管理&nbsp;&nbsp;>&nbsp;&nbsp;新增
	</div>
	<!-- bar end -->
	<!-- condition box -->
	<input type="hidden" id="_status" value="${status}">
	<form id="validate">
		<ul class="condition_box">
			<li class="condition_lable">上级模块</li>
			<li class="condition_input sysmoudel_input_width"><input
				type="text" name="upmoudel" id="upmoudel"
				class="input_text {required:true,messages:{required:'请输入上级模块'}}"><span>*</span></li>

			<li class="condition_lable">模块编码</li>
			<li class="condition_input sysmoudel_input_width"><input
				type="text" name="moudelcode"
				class="input_text {required:true,messages:{required:'请输入模块编码'}}"><span>*</span></li>

		</ul>
		<ul class="condition_box">
			<li class="condition_lable">模块名称</li>
			<li class="condition_input sysmoudel_input_width"><input
				type="text" name="moudelname"
				class="input_text {required:true,messages:{required:'请输入模块名称'}}"><span>*</span></li>

			<li class="condition_lable">模块简称</li>
			<li class="condition_input sysmoudel_input_width"><input
				type="text" name="moudelshort"
				class="input_text {required:true,messages:{required:'请输入模块简称'}}"><span>*</span></li>

		</ul>
		<ul class="condition_box">
			<li class="condition_lable">模块URL</li>
			<li class="condition_input sysmoudel_input_width"><input
				type="text" class="input_text" name="moudelurl"></li>

			<li class="condition_lable">功能描述</li>
			<li class="condition_input sysmoudel_input_width"><input
				type="text" class="input_text" name="moudeldesc"></li>

		</ul>
		<ul class="condition_box">
			<li class="condition_lable">开放级别</li>
			<li class="condition_input sysmoudel_input_width"><select
				class="input_select" name="moudellevel"></select></li>

			<li class="condition_lable">是否启用</li>
			<li class="condition_input sysmoudel_input_width"><input
				type="radio" name="moudelstatus" class="input_radio">启用<input
				type="radio" name="moudelstatus" class="input_radio">停用</li>

		</ul>
		<ul class="condition_box">
			<li class="condition_lable">操作权限</li>
			<li class="condition_input sysmoudel_option_box"><input
				name="moudeloption" type="checkbox">新增功能 <input
				type="checkbox" name="moudeloption">删除功能 <input
				name="moudeloption" type="checkbox">修改功能 <input
				type="checkbox" name="moudeloption">查询功能 <input
				type="checkbox" name="moudeloption">导出功能</li>
		</ul>
		<ul class="condition_btn_box">
			<li><input type="button" value="确认新增" id="_formbtn"/></li>
			<li><input type="reset" /></li>
			<li><input type="button" value="取消" id="_cancel" /></li>
		</ul>
	</form>
	<!-- condition end -->
</body>
</html>
