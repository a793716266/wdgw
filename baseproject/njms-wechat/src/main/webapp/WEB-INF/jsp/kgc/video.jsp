<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>视频播放页 - 课工场|文鼎校区</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/footer.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/videoplay/videoheader.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/css/videoplay/videoplay.css" />
<body>
	<div id="app">
	<!--头部-->
	<div class="header">
		<div class="container">
			<div class="header-top displayFlex">
				<div class="logo"></div>
				<div class="title">文鼎校区</div>
				<div class="banner">
					<span>←</span> <a class="backclass" href="javascript:void(0)">
			     			返回课程主页</a>
				</div>
			</div>
		</div>
	</div>
	<!--ssection-->
	<div class="section">
		<div class="container">
			<div class="videoplayer">
				<div class="videoPlayback">
					<div class="topback">
						<span class="videotitle">视频名称</span>
					</div>
					<!-- 腾讯视频格式：http://v.qq.com/iframe/player.html?vid=${vid}&amp -->
					<!-- 优酷视频格式：http://player.youku.com/${sid} -->
					<iframe class="video_iframe" id="myVideo" style=" z-index:1;" 
							src="${videoUrl}" 
							allowfullscreen="" frameborder="0" width="800" height="600">
					</iframe>
				</div>
				<ul class="menu">
					<li><a href="javascript:void(0)" title="问题反馈"><span
							class="feedback img"></span><span>问题反馈</span></a></li>
					<li><a href="javascript:void(0)" title="社区讨论"><span
							class="discuss img"></span><span>社区讨论</span></a></li>
					<li><a href="javascript:void(0)" title="分享课程"><span
							class="share img"></span><span>分享课程</span></a></li>
					<li><a href="javascript:void(0)"><span class="good img"></span><input
							class="zancount" type="text" value="1701" readonly="readonly" /></a></li>
				</ul>
			</div>
			<div class="recommend">
				<div class="part1">
					<div class="text">
						<div class="courses" title="推荐课程">推荐课程</div>
						<div class="whole">
							<a class="a-default" href="javascript:void(0)" title="查看全部">查看全部
								></a>
						</div>
					</div>
				</div>
				<ul class="part2">
					<videoall v-for="item in videolistall"
					:picture-name="item.pictureName?getPath()+item.pictureName:''" 
					:url="item.url?item.url:''"
					:title="item.title?item.title:''" :isfree="item.isfree">
					</videoall>
				</ul>
			</div>
		</div>
	</div>
	<!--footer-->
	<!-- footer-top -->
		<wdfooter :list="footlist" :campusinfo="campusinfo" :path="getPath()"></wdfooter>
	</div>
	<!--footer end...-->
	<script src="<%=basePath%>/static/js/jquery-1.8.3.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/js/common.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/js/videoplay/videoplay.js"
		type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/static/js/vue.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/components/video.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/components/footer.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="<%=basePath%>/static/js/vueConfig.js" type="text/javascript"
		charset="utf-8"></script>
		<script>
	$(function() {
		getData({
			url : "<%=basePath%>wd/findVideoByType.do",
			data:{
				type:"${requestScope.vtype}"
			},
			attr:"videolistall"
		});
	});
</script>
</body>
</html>