<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>智慧免疫云-财务报表专用平台</title>
<jsp:include page="../layout/command.jsp"></jsp:include>
<jsp:include page="../layout/richclient.jsp"></jsp:include>
<script type="text/javascript"
	src="../resources/js/account/sysmoudel.js"></script>
</head>
<body>
	<!-- bar start -->
	<div class="content_bar">
		<strong>系统设置</strong>&nbsp;&nbsp;>&nbsp;&nbsp;系统模块管理
	</div>
	<!-- bar end -->
	<!-- condition box -->
	<form>
		<ul class="condition_box">
			<li class="condition_lable">上级模块</li>
			<li class="condition_input"><input type="text"
				class="input_text"></li>
			<li class="condition_lable">模块编码</li>
			<li class="condition_input"><input type="text"
				class="input_text"></li>
		</ul>
		<ul class="condition_box">
			<li class="condition_lable">模块名称</li>
			<li class="condition_input"><input type="text"
				class="input_text"></li>
			<li class="condition_lable">模块简称</li>
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
			<li><input type="button" value="查询" id="_query"></li>
			<li><input type="reset"></li>
			<li><input type="button" value="新增" id="_create"></li>
		</ul>
	</form>
	<!-- condition end -->
	<!-- table -->
	<table id="dg" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:'10%',align:'center'">上级模块</th>
				<th data-options="field:'productid',width:'10%',align:'center'">模块编码</th>
				<th data-options="field:'listprice',width:'10%',align:'center'">模块名称</th>
				<th data-options="field:'unitcost',width:'10%',align:'center'">模块简称</th>
				<th data-options="field:'attr1',align:'left',width:'20%'">模块URL</th>
				<th data-options="field:'status',width:'9%',align:'center'">开放级别</th>
				<th data-options="field:'status',width:'10%',align:'center'">模块说明</th>
				<th data-options="field:'status',width:'10%',align:'center'">是否启用</th>
				<th
					data-options="field:'option',width:'10%',align:'center',formatter:optionBtn">操作</th>
			</tr>
		</thead>
	</table>
	<!-- table end -->
</body>
</html>
