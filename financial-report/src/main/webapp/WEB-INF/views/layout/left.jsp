<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="resources/css/zTreeStyle/zTreeStyle.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/jquery.ztree.core.js"></script>
<script type="text/javascript">
	var curMenu = null, zTree_Menu = null;
	var setting = {
		view : {
			showLine : false,
			showIcon : false,
			selectedMulti : false,
			dblClickExpand : false,
			addDiyDom : addDiyDom
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeClick : beforeClick
		}
	};

	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "文件夹",
		open : true
	}, {
		id : 11,
		pId : 1,
		name : "收件箱"
	}, {
		id : 12,
		pId : 1,
		name : "垃圾邮件"
	}, {
		id : 13,
		pId : 1,
		name : "草稿"
	}, {
		id : 14,
		pId : 1,
		name : "已发送邮件"
	}, {
		id : 15,
		pId : 1,
		name : "已删除邮件"
	}, {
		id : 3,
		pId : 0,
		name : "快速视图"
	}, {
		id : 31,
		pId : 3,
		name : "文档"
	}, {
		id : 32,
		pId : 3,
		name : "照片"
	} ];

	function addDiyDom(treeId, treeNode) {
		var spaceWidth = 5;
		var switchObj = $("#" + treeNode.tId + "_switch"), icoObj = $("#"
				+ treeNode.tId + "_ico");
		switchObj.remove();
		icoObj.before(switchObj);

		if (treeNode.level > 0) {
			var spaceStr = "<span style='display: inline-block;width:"
					+ (spaceWidth * treeNode.level) + "px'></span>";
			switchObj.before(spaceStr);
		}
	}

	function beforeClick(treeId, treeNode) {
		if (treeNode.level == 0) {
			var zTree = $.fn.zTree.getZTreeObj("_menu_tree");
			zTree.expandNode(treeNode);
			return false;
		}
		return true;
	}

	$(document).ready(function() {
		var treeObj = $("#_menu_tree");
		$.fn.zTree.init(treeObj, setting, zNodes);
		$(".ztree li a.level0").prepend("<i class='icon'></i>");
		//$(".ztree li a.level0").prepend("<i class='pointicon'></i>");
	});
</script>

<ul id="_menu_tree" class="ztree">
</ul>
