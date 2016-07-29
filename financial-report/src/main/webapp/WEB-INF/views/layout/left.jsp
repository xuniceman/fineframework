<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="${basepath}resources/css/zTreeStyle/zTreeStyle.css" rel="stylesheet"
	type="text/css">
<link href="${basepath}resources/css/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${basepath}resources/js/jquery.ztree.core.js"></script>
<script type="text/javascript">
	var setting = {
		data : {
			simpleData : {
				enable : true
			}
		},
		view : {
			showLine : false,
			showIcon : false,
			selectedMulti : false,
			dblClickExpand : false,
			addDiyDom : addDiyDom
		},
		callback : {
			beforeClick : beforeClick
		}
	};

	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "系统管理",
		open : true
	}, {
		id : 11,
		pId : 1,
		name : "父节点11 - 折叠",
		url:"http://www.baidu.com"
		
	}, {
		id : 12,
		pId : 11,
		name : "父节点12 - 折叠",
		url:"http://www.baidu.com"
	}, {
		id : 13,
		pId : 1,
		name : "父节点13 - 没有子节点",
		url:"http://www.baidu.com"
	}, {
		id : 2,
		pId : 0,
		name : "系统设置"
	}, {
		id : 21,
		pId : 2,
		name : "系统模块管理",
		url:"account/sysmoudel",
		target:"conentview"
	}, {
		id : 4,
		pId : 0,
		name : "财务统计",
		isParent : true
	} ];
	var node;
	function addDiyDom(treeId, treeNode) {
		if(treeNode.open)
		{
			node = "_menu_tree_"+treeNode.id+"_a .pointicon";
		}
	}
	
	function beforeClick(treeId, treeNode) {
		if (treeNode.level == 0) {
			var zTree = $.fn.zTree.getZTreeObj("_menu_tree");			
			if(treeNode.open)
			{
				$("#"+treeNode.tId+"_a .pointicon").css("background","url(resources/images/base_z.png) 0 -422px no-repeat");
			}
			else
			{
				$("#"+treeNode.tId+"_a .pointicon").css("background","url(resources/images/base_z.png) 0 -396px no-repeat");
			}
			zTree.expandNode(treeNode);
			return false;
		}
		return true;
	}
	$(document).ready(function() {
		$.fn.zTree.init($("#_menu_tree"), setting, zNodes);
		//调整ztree树左侧图标
		$(".ztree li a.level0").prepend("<i class='icon'></i>");
		$(".ztree li a.level0").append("<i class='pointicon'></i>");
		$("#"+node).css("background","url(resources/images/base_z.png) 0 -396px no-repeat");
		node = null;
		
		/*$.ajax({
			cache : true,
			type : "POST",
			url : "account/sysmenu",
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if (data.success) {
					$.fn.zTree.init($("#_menu_tree"), setting, data.data);
					//调整ztree树左侧图标
					$(".ztree li a.level0").prepend("<i class='icon'></i>");
					$(".ztree li a.level0").append("<i class='pointicon'></i>");
					$("#"+node).css("background","url(resources/images/base_z.png) 0 -396px no-repeat");
					node = null;
				} else {
					alert(data.msg);
				}
			}
		});*/
	});
</script>
<ul id="_menu_tree" class="ztree"></ul>
