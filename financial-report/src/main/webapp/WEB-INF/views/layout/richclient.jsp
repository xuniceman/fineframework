<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basepath", basePath);
%>
<link href="<%=basePath%>resources/css/richclient/themes/default/easyui.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>resources/css/richclient/themes/icon.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>resources/css/dataview.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>resources/js/jquery.richclient.min.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/js/richclient-lang-zh_CN.js"></script>
