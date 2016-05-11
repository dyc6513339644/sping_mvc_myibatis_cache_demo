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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
   <h2 class="sub-header">用户列表</h2> 
   
	<!--  <div class="addbtn" >
	<button class="btn  btn-warning" data-toggle="modal"
			data-target="#addModal">增加用户</button>
	</div>  -->
	
	<!-- 信息列表 -->
	<div class="table-responsive">
	<!--  -->
		<table class="userTable table table-striped table-bordered table-hover" id="userListTable">
			<thead>
				<tr>
					<th>MEMBERNAME</th>
		   			<th>ACCOUNTNUMBER</th>
		   			<th>AGE</th>
		   			<th>GENDER</th>
		   			<th>BIRTHDAY</th>
		   			<th>MEMBER_LABEL</th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
			
		</table>
		
		<!-- 分页 -->
		 <ul id="pages" class="pages"></ul>
		
		共 <input type="text" id="pageSize" value="0" readonly="readonly"> 条记录 /当前页:<input type="text" id="currentPage" readonly="readonly" class="currentPage"> 
	</div>
  
   
   
    <script type="text/javascript" src="${home}/res/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${home}/res/js/bootstrap.min.js"></script>
	<%-- <script type="text/javascript" src="${home}/res/js/jquery.1.7.2.min.js"></script> --%>
	<script type="text/javascript" src="${home}/res/js/docs.min.js"></script>
	<script type="text/javascript"
		src="${home}/res/js/ie10-viewport-bug-workaround.js"></script>
	<script type="text/javascript" src="${home}/res/js/memberUser.js"></script>
	
	<!-- 分页  -->
	<script src="${home}/res/js/page/jquery.twbsPagination.js" type="text/javascript"></script>
	<%-- <script src="${home}/js/page/zzsc.js" type="text/javascript"></script> --%>
  </body>
</html>
