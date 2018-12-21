<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common-header.jsp"%>
<div class="section section-teacher">
	<div class="container module-teacher">
		<xiaolunbo :imglist="teacherbroadcast" :path="getAdminPath()"></xiaolunbo>
		<div class="teacher-tab down displayFlex">
			<div class="teacher-tab-item teacher-tab-jiangshi displayFlex active">
				<div class="teacher-icon jiangshi-icon"></div>
				<div class="tag-text font-lg">技术大咖讲师们</div>
			</div>
			<div class="teacher-tab-item teacher-tab-banzhuren displayFlex">
				<div class="teacher-icon banzhuren-icon"></div>
				<div class="tag-text font-lg">貌美如花班主任</div>
			</div>
			<div class="teacher-tab up">
				<div class="teacher-tab-item teacher-tab-jiangshi displayFlex active">
					<div class="teacher-icon jiangshi-icon"></div>
					<div class="tag-text font-lg">技术大咖讲师们</div>
				</div>
				<div class="teacher-tab-item teacher-tab-banzhuren displayFlex">
					<div class="teacher-icon banzhuren-icon"></div>
					<div class="tag-text font-lg">貌美如花班主任</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<ul class="teacherlist jiangshilist">
			<teacheritem v-for="item in teacherlist" :name="item.name?item.name:'加载中'"
				:head-portrait="item.headPortrait?getAdminPath()+item.headPortrait:''"
				:numberofyears="item.numberofyears?item.numberofyears:'加载中'"
				:curriculum-type="item.curriculumType?item.curriculumType:'加载中'" :remarks="item.remarks?item.remarks:'加载中'"
				:content="item.content?item.content:'加载中'"><div class="skillcontent" slot="info">{{item.info?item.info:'加载中'}}</div>
			</teacheritem>
		</ul>
		
		<ul class="teacherlist banzhurenlist">
			<banzhurenitem v-for="item in banzhurenlist" :name="item.name?item.name:'加载中'"
				:head-portrait="item.headPortrait?getAdminPath()+item.headPortrait:''"
				:numberofyears="item.numberofyears?item.numberofyears:'加载中'"
				:curriculum-type="item.curriculumType?item.curriculumType:'加载中'" :remarks="item.remarks?item.remarks:'加载中'"
				:content="item.content"> <span slot="info">{{item.info?item.info:'加载中'}}</span>
			</banzhurenitem>
		</ul>
	</div>
</div>
<%@include file="../common/common-footer.jsp"%>
<script src="<%=basePath%>static/js/teacher.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/header.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/footer.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/xiao.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/xiaolunbo.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/teacheritem.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/banzhurenitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript"
	charset="utf-8"></script>
	<script>
	$(function() {
		//名师团队轮播图
		getData({
			url : "wd/findbroadcasts.do",
			data:{
				broadcastPage:2,
				broadcastName:"teacherbroadcast"
			},
			attr:"teacherbroadcast"
		});
		//获取优秀教员信息
		getData({
			url : "wd/toIndexk.do",
			attr:["teacherlist","banzhurenlist"]
		})
	});
	</script>
</body>
</html>