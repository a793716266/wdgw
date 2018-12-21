<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common-header.jsp"%>
<div class="section section-teacher">
	<div class="container module-teacher">
		<xiaolunbo :imglist="studentbroadcast" :path="getAdminPath()"></xiaolunbo>
		<div class="teacher-tab down displayFlex student-tab">
			<div class="teacher-tab-item student-tab-java displayFlex">
				<div class="tag-text font-lg">JAVA大数据学员</div>
			</div>
			<div class="teacher-tab-item student-tab-web displayFlex">
				<div class="tag-text font-lg">WEB前端学员</div>
			</div>
			<div class="teacher-tab-item student-tab-ui displayFlex">
				<div class="tag-text font-lg">UI设计学员</div>
			</div>
			<div class="teacher-tab up student-tab">
				<div class="teacher-tab-item student-tab-java displayFlex">
					<div class="tag-text font-lg">JAVA大数据学员</div>
				</div>
				<div class="teacher-tab-item student-tab-web displayFlex">
					<div class="tag-text font-lg">WEB前端学员</div>
				</div>
				<div class="teacher-tab-item student-tab-ui displayFlex">
					<div class="tag-text font-lg">UI设计学员</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<ul class="stulist stulist-java">
			<stuitem v-for="(item,i) in goodjavaListto"
						:stu-name="item.stuName" :studentimg="item.studentimg?getAdminPath()+item.studentimg:''" :emp-wage="item.empWage?item.empWage:'加载中'"
						:emp-time="item.empTime?item.empTime:'加载中'" :emp-company="item.empCompany?item.empCompany:'加载中'"
						:speech="item.speech?item.speech:'加载中'"></stuitem>
		</ul>
		<ul class="stulist stulist-web">
			<stuitem v-for="(item,i) in goodwebListto" :studentimg="item.studentimg?getAdminPath()+item.studentimg:''"
						:stu-name="item.stuName?item.stuName:'加载中'" :emp-wage="item.empWage?item.empWage:'加载中'"
						:emp-time="item.empTime?item.empTime:'加载中'" :emp-company="item.empCompany?item.empCompany:'加载中'"
						:speech="item.speech?item.speech:'加载中'"></stuitem>
		</ul>
		<ul class="stulist stulist-ui">
			<stuitem v-for="(item,i) in gooduiListto" :studentimg="item.studentimg?getAdminPath()+item.studentimg:''"
						:stu-name="item.stuName?item.stuName:'加载中'" :emp-wage="item.empWage?item.empWage:'加载中'"
						:emp-time="item.empTime?item.empTime:'加载中'" :emp-company="item.empCompany?item.empCompany:'加载中'"
						:speech="item.speech?item.speech:'加载中'"></stuitem>
		</ul>
	</div>
</div>
<%@include file="../common/common-footer.jsp"%>
<script src="<%=basePath%>static/js/lunbo.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/student.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/header.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/footer.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/stuitem.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/xiao.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/xiaolunbo.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript"
	charset="utf-8"></script>
	<script>
	$(function() {
		//获取轮播图信息
		getData({
			url : "wd/findbroadcasts.do",
			data:{
				broadcastPage:3,
				broadcastName:"studentbroadcast"
			},
			attr :"studentbroadcast"
		});
		//获取优秀学生信息
		getData({
			url : "wd/reqStuList.do",
			attr : ["goodjavaListto","goodwebListto","gooduiListto"]
		});
	});
</script>
</body>
</html>