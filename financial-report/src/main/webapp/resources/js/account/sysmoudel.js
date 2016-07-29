/**
 * 权限模块 模块管理js
 */
$(function() {
	$("#_create").click(toCreateView);
	// $("#dg").datagrid({
	// onClickRow:function(index,row){
	// $.messager.alert('Info', row.itemid+":"+row.productid+":"+row.attr1);
	// }
	// });
	$("#_query").click(function() {
		init(1);
	});
	init(null);
});

function init(p) {

	var startPage = null;
	if (p) {
		startPage = p;
	}
	$('#dg').datagrid({
		url : 'sysmoudel/querymoudel',
		singleSelect : true,
		border : false,
		noheader : true,
		rownumbers : true,
		pagination : true,
		method : 'POST',
		queryParams : {
			name : 'easyui',
			subject : "dd",
			startPage:startPage
		},
		onLoadSuccess : loadData
	});
}

function loadData(data) {

	// var merges = [{
	// index: 0,
	// colspan: 4
	// }];
	// for(var i=0; i<merges.length; i++){
	// $(this).datagrid('mergeCells',{
	// index: merges[i].index,
	// field: 'productid',
	// colspan: merges[i].colspan
	// });
	// }
}

function toCreateView() {
	window.location.href = "sysmoudel/createview";
}
function optionBtn(val, row, index) {
	return '<a class="optionbtn" href="javascript:void(0);" onclick="doEdit('
			+ index
			+ ')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="optionbtn" href="javascript:void(0);" onclick="doDelete('
			+ index + ')">刪除</a>';
}
function doEdit(index) {
	window.location.href = "sysmoudel/createview";
}
function doDelete(index) {
	if (confirm("确定刪除？")) {
		$('#dg').datagrid('deleteRow', index);
		var rows = $('#dg').datagrid("getRows");
		$('#dg').datagrid("loadData", rows);
	}
}