<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("home", path);
%>
 <!DOCTYPE HTML>
<html lang="en-US"> 
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> -->
<head>
	<meta charset="UTF-8">
	<title>用户登录</title>
	<link rel="stylesheet" href="${home}/res/login/login.css" type="text/css"></link>
	
	<script type="text/javascript">
		var home ="${home}";
	</script>

	</head>
<body>

	   <div class="content">
           <form action="${home}/user/toLogin" method="post" class="login-form">
               <div class="username">
                   <input type="text" name="username" placeholder="emma.watson@gmail.com" autocomplete="on" />
                    <span class="user-icon icon">u</span> 
               </div>
               <div class="password">
                   <input type="password" name="password" placeholder="*******" />
                   <span class="password-icon icon">p</span>
               </div>
               <div class="account-control">
                   <input type="checkbox" name="rememberMe" id="Remember me" value="Rememberme" checked="checked" />
                   <label for="Remember me" data-on="c" class="check"></label>
                   <label for="Remember me" class="info">Remember me</label>
                   <button type="submit">Login</button>
               </div>
               <p class="not-registered">Not a registered user yet?<a>Sign up now!</a></p>
           </form>
	   </div>
<div style="text-align:center;clear:both">
<!-- <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script> -->
<script type="text/javascript" src="${home}/res/login/prefixfree.min.js"></script>
</div>

	
</body>
</html>