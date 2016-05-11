<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("home", path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MyInfo</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${home}/res/css/bootstrap.min.css" type="text/css"></link>
	<link rel="stylesheet" href="${home}/res/css/allStyle.css" type="text/css"></link>
	
	<style type="text/css">
	
	.userTable{
		
		font-size: 20px;
	}
	
	</style>
	
	<script type="text/javascript">
		var home ="${home}";
	</script> 
  </head>
  
  <body>
  
   <h2 class="sub-header">我的信息</h2> 
   

	update当前用户：${accounterNumber }

	
   
   
    <script type="text/javascript" src="${home}/res/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${home}/res/js/bootstrap.min.js"></script>
	<%-- <script type="text/javascript" src="${home}/res/js/jquery.1.7.2.min.js"></script> --%>
	<script type="text/javascript" src="${home}/res/js/docs.min.js"></script>
	<script type="text/javascript"
		src="${home}/res/js/ie10-viewport-bug-workaround.js"></script>
	
</html>
