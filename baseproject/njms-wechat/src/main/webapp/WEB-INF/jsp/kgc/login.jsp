<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/common.css" />
<link rel="stylesheet" href="<%=basePath%>/static/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/footer.css" />
<link rel="stylesheet"
	href="<%=basePath%>/static/css/account/accountcommon.css" />
<link rel="stylesheet"
	href="<%=basePath%>/static/css/account/logininput.css" />
</head>
<body>
	<div class="ks" id="app">
		<div class="login-big">
			<div class="login-big-top"></div>
			<logininput></logininput>
		</div>
		<wdfooter></wdfooter>
	</div>
	<script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.8.3.js"></script>
	<script src="<%=basePath%>/static/js/vue.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/js/common.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/components/logininput.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/components/footer.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/js/vueConfig.js" type="text/javascript"
		charset="utf-8"></script>

	<script type="text/javascript">
		$(function(){
			if("${is}"!=null && "${is}" !=''){
				$("#password-text").html("<div class='waining'></div><div id='account-text-w'></div>");
				$("#account-text-w").html("用户名和密码不匹配");
			}else{
				$("#account-text").empty();
				$("#password-text").empty();
			}
		})
		//登录
		$("#btnlogin").click(function() {
			$("#account-text").empty();
			$("#password-text").empty();
			var ok = $('<div class="ok"></div>');
			var warning = $('<div class="waining"></div>');
			var accout = $("#account").val();
			var password = $("#password").val();
			if (accout === '') {
				$("#account-text").html("<div class='waining'></div><div id='account-text-w'></div>");
				$("#account-text-w").html("请输入账号");
				return false;
			}
			if (password === '') {
				$("#password-text").html("<div class='waining'></div><div id='account-text-w'></div>");
				$("#account-text-w").html("请输入密码");
				return false;
			}
			$("#myForm").submit();
				
// 				$.ajax({
// 					url : "userList.do",
// 					type : "POST",
// 					data : {
// 						phonenumber : accout,
// 						password : password
// 					},
// 					dataType : "json",
// 					success : function(data) {
// 						if (data.userph == null) {
// 							$("#account-text").html("<div class='waining'></div><div id='account-text-w'></div>");
// 							$("#account-text-w").html("该手机号未注册！");
// 						}
// 						if (data.userph != null	&& password != data.userph.password) {
// 							$("#password-text").html("<div class='waining'></div><div id='account-text-w'></div>");
// 							$("#account-text-w").html("用户名和密码不匹配");
// 							return false;
// 						}
// 						if (data.userph != null) {
// 							if (accout == data.userph.phonenumber && password == data.userph.password) {
// 								$("#account-text").html("<div class='ok'></div><div id='account-text-w'></div>");
// 								$("#password-text").html("<div class='ok'></div><div id='account-text-w'></div>");
// 								$(".ok").css("background-image","url(../static/img/account/ok.png)");
// 								//window.location = "toIndex.do";
// 							}
// 						}
// 					}
// 				})
		});
		
		function on_return(){
			if(window.event.keyCode == 13){
				if (document.all('btnlogin')!=null){
					document.all('btnlogin').click();
				}
			}
		}
	</script>
</body>
</html>