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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/common.css" />
		<link rel="stylesheet" href="<%=basePath%>/static/css/header.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/footer.css"/>
		<link rel="stylesheet" href="<%=basePath%>/static/css/account/accountcommon.css" />
		<link rel="stylesheet" href="<%=basePath%>/static/css/account/register.css" />
		<script src="<%=basePath%>/static/js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="ks" id="app">
			<div class="login-big-two ">
				<div class="login-big-top">
				</div>
				<reigsterinput></reigsterinput>
			</div>
			<wdfooter></wdfooter>
		</div>
		<script type="text/javascript" src="<%=basePath%>/static/js/jquery-1.8.3.js"></script>
		<script src="<%=basePath%>/static/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/static/js/vue.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/static/components/reigsterinput.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/static/components/footer.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/static/js/vueConfig.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/static/js/register.js" type="text/javascript" charset="utf-8"></script>
		
	</body>
	<script type="text/javascript">
	window.document.onkeydown = disableRefresh;
	function disableRefresh(evt){
	evt = (evt) ? evt : window.event
	if (evt.keyCode) {
	if(evt.keyCode == 13){
	     $(".submit").click();
			}
		}
	}
	</script>
</html>