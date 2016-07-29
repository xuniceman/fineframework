/**
 * 权限模块 模块管理js
 */

$(function() {
	$.validator.setDefaults({
		submitHandler : function() {
			alert("提交事件!");
		}
	});
	$("#validate").validate();
	$("#_cancel").click(doCancel);
	$("#_formbtn").click(submitForm);
	var status = $.trim($("#_status").val());
	if(status!=null && status==1)
	{
		alert("新增成功");
	}
	else if(status!=null && status==2)
	{
		alert("新增失败");
	}
});
function submitForm()
{
	$("#validate").attr("action","create");
	$("#validate").attr("method","POST");
	$("#validate").submit();
}
function doCancel() {
	window.location.href = "../sysmoudel";
}
