/**
 * 系统主页脚本
 */
$(function(){
	//浏览器可见区域高度
	var clientHeight = document.documentElement.clientHeight-90;
	$(".main_left").css("height",clientHeight);
	$(".main_right").css("height",clientHeight);
	//浏览器可见区域宽度
	var clientWidth = document.documentElement.clientWidth;
	$(".header").css("width",clientWidth);
	//.main主体宽度
	var mainWidth = $(".main").css("width");
	$(".main").css("width",mainWidth);
	
	$(".main_right").css("width",parseInt(mainWidth)-201);
});