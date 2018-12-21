<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>

	
	<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
		<title>首页 - 课工场|文鼎校区</title>
		
	    <link rel="stylesheet" href="<%=basePath%>static/jQuery-emoji-master/lib/css/jquery.mCustomScrollbar.min.css"/>
	    <link rel="stylesheet" href="<%=basePath%>static/jQuery-emoji-master/dist/css/jquery.emoji.css"/>
	    
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/header.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/footer.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/wyplay.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/section-common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/section-top.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/lunbo.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-clz.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-stu.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-rate.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-course.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-free.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-project.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-biz.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-job.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-teacher.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-news.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-schoolAndCompany.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/teacher/nav-teacher.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/teacher/teacher.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/student/student.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/ProcessPage/ProcessPage.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/kgcmk-css/mk-top.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/kgcmk-css/Modular.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/kgcmk-css/uldemo.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/swiper.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/Personal/Personal-comm.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/Personal/Personal-right-one.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/Personal/Personal-right-two.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/Personal/Personal-right-three.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/Personal/Personal-right-four.css" /> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/Forumplatform/Forumplatform.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/luntanPage/luntantype.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/luntanPage/forum.css" />

		<link rel="stylesheet" href="static/layui/css/layui.css" media="all">

		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/layui/css/layui.css" />
		<script src="<%=basePath%>static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="<%=basePath%>static/css/picture/updPicture.css" type="text/css">

		<link rel="stylesheet" href="<%=basePath%>static/jQueryHdPaging/paging.css">
		<!-- 图片上传 -->
		<link rel="stylesheet" href="<%=basePath%>static/layui/css/layui.css">
	    <!-- 分页 -->
		<script src="<%=basePath%>static/js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/pageindex.js" type="text/javascript" charset="utf-8"></script>
		
		

	</head>
	<body>
		<div id="app">
			<!--头部-->
			 <wdheader user="${sessionScope.userph}"></wdheader>
			 
			 
		
