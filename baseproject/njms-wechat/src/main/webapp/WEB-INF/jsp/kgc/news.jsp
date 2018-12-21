<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>首页 - 课工场|文鼎校区</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/header.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/footer.css" />
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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/news/nesList.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/font-awesome.min.css" />
		<script src="<%=basePath%>static/js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div id="app">
			<!--头部-->
			<wdheader></wdheader>
			<div class="section">
				<div class="container">
				<div class="newsUrl"><a class="a-default" href="javascript:void(0" onclick="toIndex();">${index}<i class="fa fa-angle-right da" aria-hidden="true"></i></a><a class="a-default" href="javascript:void(0)" onclick="fanhui();">${news}<i class="fa fa-angle-right da" aria-hidden="true"></i></a><a class="a-default" href="#">${newsType}</a></div>
					<!--轮播-->
					<div class="xiaolunbo">
						<ul class="xiaolunbolist">
							<li v-for="(item,i) in newslist" :onclick="'gogogo(\''+item.news_id+'\')'" v-if="i<5":style="item.pictureName?'background-image:url('+getAdminPath()+item.pictureName+');':''">
								<div class="slots" :onclick="'gogogo(\''+item.news_id+'\')'" style="width: 100%;height: 40px;background: rgba(255,255,255,.8);">{{item.newTitle?item.newTitle:'加载中'}}</div>
							</li>
						</ul>
						<div class="rotateBtn btnNext"></div>
						<div class="rotateBtn btnPrev"></div>
					</div>
				</div>

				<div class="container newsText">
					<newslist :list="newslist" :path="getAdminPath()"></newslist>
				</div>
			</div>
			<div id="newsType" style="display: none">${newsType}</div>
			<%@include file="../common/common-footer.jsp"%>
		<script src="<%=basePath%>static/js/xiaolunbo.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/vue.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/header.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/footer.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/newsText.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			//获取新闻信息
			getData({
				url : "newsAll.do",
				attr:"newslist"
			})
			
			function weiguan() {
				location.href="#";
			}
			
			function fanhui() {
				history.go(-1);
			}
			
			function toIndex() {
				location.href="toIndex.do";
			}
			function gogogo(newsid) {
				location.href="gotoNewsDetail.do?newsid="+newsid;
			}
		</script>
	</body>

</html>