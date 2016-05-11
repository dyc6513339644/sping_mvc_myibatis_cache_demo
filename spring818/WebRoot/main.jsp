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
    
    <title>main</title>
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
  
  <div>
   <h2 class="sub-header">管理列表</h2> 
   	
   	<ul>
   		<li> <a href="${home}/user/queryUserInfoByUsername?username=liuyuxin" target="_blank">lyx信息</a></li>
   		<li> <a href="${home}/user/queryUserInfoByUsername?username=liudong" target="_blank">ld信息</a></li>
   		<li> <a href="${home}/user/update?username=liudong" target="_blank">更新</a></li>
   		<li> <a href="${home}/user/removeAll" target="_blank">清空</a></li>
   		<li> <a href="${home}/index.jsp" target="_blank">全部信息</a></li>
   	</ul>
  </div>
   
   
    <script type="text/javascript" src="${home}/res/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${home}/res/js/bootstrap.min.js"></script>
	<%-- <script type="text/javascript" src="${home}/res/js/jquery.1.7.2.min.js"></script> --%>
	<script type="text/javascript" src="${home}/res/js/docs.min.js"></script>
	
  </body>
</html>
