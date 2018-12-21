<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common-header.jsp"%>
<!--主体-->
<div class="section">
	<!--主体中部-->
	<div class="container">
		<!--轮播-->
		<xiaolunbo :imglist="freebroadcast" :path="'${requestPath }'"></xiaolunbo>
		<!--结束轮播-->
		<!--间隔-->
		<div class="interval">
			<!--UL设计图标-->
			<div class="uldemo">
				<div class="uldemo-lcon"
					style="background: url(static/img/mkimg/KU.png); background-size: 100% 100%;">
				</div>
				<div class="uldemo-text">
					<span class="uldemo-text-t">UI设计</span>
				</div>
			</div>
			<!--结束UI设计图标-->
		</div>
		<!--结束间格-->
		<div class="container-from ">
		<!--vue onclick事件  -->
			<div class="container-from-top  EF">
				<freecourseitem v-for="item in freecourseuilist"
					:picturename="item.picturename?'${requestPath }'+item.picturename:''" :title="item.title?item.title:''"
					:url="item.url" :isfree="item.isfree"
					:course="item.course" 
					
					>
				</freecourseitem>
			</div>
		</div>
		
	</div>
	<!--结束主体中部-->
</div>
<div class="test1"></div>
<!--结束主体-->
<!--间隔-->
<div class="interval-w yuan">
	<div class="interval yuan">
		<!--UI设计图标-->
		<div class="uldemo  yuan">
			<div class="uldemo-lcon"
				style="background: url(static/img/mkimg/ziyuan12.png); background-size: 100% 100%;">
			</div>
			<div class="uldemo-text">
				<span class="uldemo-text-t"> JAVA大数据 </span>
			</div>
		</div>
		<!--结束UI设计图标-->
	</div>
</div>
<!--结束间格-->
<div class="Central-section">
	<div class="central-section-from-central  yuan ">
		<freecourseitem v-for="item in freecoursejavalist"
			:picturename="item.picturename?'${requestPath }'+item.picturename:''" :title="item.title?item.title:''"
			:url="item.url?item.url:''" number="278" borderk="1" heightk="48"
			:isfree="item.isfree"
			:course="item.course"
			> </freecourseitem>
	</div>
</div>
<div class="test"></div>
<!--间隔-->
<div class="interval-w-stoom">
	<div class="interval-stoom">
		<!--UL设计图标-->
		<div class="uldemo ">
			<div class="uldemo-lcon "
				style="background: url(static/img/mkimg/ziyuan13.png); background-size: 100% 100%;">
			</div>
			<div class="uldemo-text">
				<span class="uldemo-text-t">WEB前端</span>
			</div>
		</div>
		<!--结束UL设计图标-->
	</div>
</div>
<!--结束间格-->
<div class="Central-section-sttom EF">
	<div class="container-from-sttom EF ">
		<freecourseitem v-for="item in freecoursehalist"
			:picturename="item.picturename?'${requestPath }'+item.picturename:''" :title="item.title?item.title:''"
		:course="item.course"	:url="item.url" :isfree="item.isfree"> </freecourseitem>
	</div>
</div>
<div class="test2"></div>
<%@include file="../common/common-footer.jsp"%>
<script src="<%=basePath%>static/js/lunbo.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/header.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/footer.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/freecourseitem.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/xiao.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/mkjs/xiaolunbo.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/mkjs/zhengligeshi.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/mkjs/zhengligeshi1.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/mkjs/zhengligeshi2.js" type="text/javascript"
	charset="utf-8"></script>
<script>
	$(function() {
		//免费课程轮播图
		getData({
			url : "wd/findbroadcasts.do",
			data:{
				broadcastPage:1,
				broadcastName:"freebroadcast"
			},
			attr:"freebroadcast"
		});
		getData({
			url : "wd/findfreecourse.do",
			attr:["freecoursejavalist","freecourseuilist","freecoursehalist"]
		});
		
	});
</script>
</body>

</html>