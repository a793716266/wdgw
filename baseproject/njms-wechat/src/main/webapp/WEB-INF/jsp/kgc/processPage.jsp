<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common-header.jsp"%>
<!--****************华丽的分割线****************-->
<!--
        	作者：郑高
        	时间：2018-07-23
        	描述：流程主体部分
       -->
<!--第一部分：开班信息展示-->
<div class="big-topbox">
	<div class="topbox-small-box">
		<div class="small-box-title">UI设计开班信息</div>
		<ul class="small-box-ulbox">
			<class-item v-for="(item,i) in ui_class" :clas="item"></class-item>
		</ul>
	</div>
	<div class="topbox-small-box" style="margin: 0 20px;">
		<div class="small-box-title" style="border-left: solid 3px #FE9515;">JAVA大数据开班信息</div>
		<ul class="small-box-ulbox">
			<class-item v-for="(item,i) in java_class" :clas="item"></class-item>
		</ul>
	</div>
	<div class="topbox-small-box">
		<div class="small-box-title" style="border-left: solid 3px #FE4A4B;">
			WEB前端开班信息</div>
		<ul class="small-box-ulbox">
			<class-item v-for="(item,i) in web_class" :clas="item"></class-item>
		</ul>
	</div>

</div>
<!--第二部分：入学和学习流程信息展示-->
<div>
	<!--2.1原形盒子在左，图片在右-->

	<rightbox-item 
	         :titleimage="flowpathye[0].titleimage?getAdminPath()+flowpathye[0].titleimage:'加载中'"
	         :textdescribe="flowpathye[0].textdescribe?flowpathye[0].textdescribe:'加载中'"
	         :describetext="flowpathye[0].describetext?flowpathye[0].describetext:'加载中'"
	         :image1="flowpathye[0].image1?getAdminPath()+flowpathye[0].image1:'加载中'"
	         :image2="flowpathye[0].image2?getAdminPath()+flowpathye[0].image2:'加载中'"
	         :image3="flowpathye[0].image3?getAdminPath()+flowpathye[0].image3:'加载中'"
	         :sort="flowpathye[0].sort?flowpathye[0].sort:'加载中'"
	>
	

	</rightbox-item>
	<!--2.2原形盒子在右，图片在左-->
	<leftbox-item 
	       :titleimage="flowpathye[1].titleimage?getAdminPath()+flowpathye[1].titleimage:'加载中'"
	         :textdescribe="flowpathye[1].textdescribe?flowpathye[1].textdescribe:'加载中'"
	         :describetext="flowpathye[1].describetext?flowpathye[1].describetext:'加载中'"
	         :image1="flowpathye[1].image1?getAdminPath()+flowpathye[1].image1:'加载中'"
	         :image2="flowpathye[1].image2?getAdminPath()+flowpathye[1].image2:'加载中'"
	         :image3="flowpathye[1].image3?getAdminPath()+flowpathye[1].image3:'加载中'"
	         :sort="flowpathye[1].sort?flowpathye[1].sort:'加载中'">
	</leftbox-item>
	<rightbox-item
	         :titleimage="flowpathye[2].titleimage?getAdminPath()+flowpathye[2].titleimage:'加载中'"
	         :textdescribe="flowpathye[2].textdescribe?flowpathye[2].textdescribe:'加载中'"
	         :describetext="flowpathye[2].describetext?flowpathye[2].describetext:'加载中'"
	         :image1="flowpathye[2].image1?getAdminPath()+flowpathye[2].image1:'加载中'"
	         :image2="flowpathye[2].image2?getAdminPath()+flowpathye[2].image2:'加载中'"
	         :image3="flowpathye[2].image3?getAdminPath()+flowpathye[2].image3:'加载中'"
	         :sort="flowpathye[2].sort?flowpathye[2].sort:'加载中'">
	

	</rightbox-item>
	<!--2.2原形盒子在右，图片在左-->
	<leftbox-item
	      :titleimage="flowpathye[3].titleimage?getAdminPath()+flowpathye[3].titleimage:'加载中'"
	         :textdescribe="flowpathye[3].textdescribe?flowpathye[3].textdescribe:'加载中'"
	         :describetext="flowpathye[3].describetext?flowpathye[3].describetext:'加载中'"
	         :image1="flowpathye[3].image1?getAdminPath()+flowpathye[3].image1:'加载中'"
	         :image2="flowpathye[3].image2?getAdminPath()+flowpathye[3].image2:'加载中'"
	         :image3="flowpathye[3].image3?getAdminPath()+flowpathye[3].image3:'加载中'"
	         :sort="flowpathye[3].sort?flowpathye[3].sort:'加载中'">
	</leftbox-item>
	<rightbox-item 
	         :titleimage="flowpathye[4].titleimage?getAdminPath()+flowpathye[4].titleimage:'加载中'"
	         :textdescribe="flowpathye[4].textdescribe?flowpathye[4].textdescribe:'加载中'"
	         :describetext="flowpathye[4].describetext?flowpathye[4].describetext:'加载中'"
	         :image1="flowpathye[4].image1?getAdminPath()+flowpathye[4].image1:'加载中'"
	         :image2="flowpathye[4].image2?getAdminPath()+flowpathye[4].image2:'加载中'"
	         :image3="flowpathye[4].image3?getAdminPath()+flowpathye[4].image3:'加载中'"
	         :sort="flowpathye[4].sort?flowpathye[4].sort:'加载中'">

	</rightbox-item>
	<!--2.2原形盒子在右，图片在左-->
	<leftbox-item 
	       :titleimage="flowpathye[5].titleimage?getAdminPath()+flowpathye[5].titleimage:'加载中'"
	         :textdescribe="flowpathye[5].textdescribe?flowpathye[5].textdescribe:'加载中'"
	         :describetext="flowpathye[5].describetext?flowpathye[5].describetext:'加载中'"
	         :image1="flowpathye[5].image1?getAdminPath()+flowpathye[5].image1:'加载中'"
	         :image2="flowpathye[5].image2?getAdminPath()+flowpathye[5].image2:'加载中'"
	         :image3="flowpathye[5].image3?getAdminPath()+flowpathye[5].image3:'加载中'"
	         :sort="flowpathye[5].sort?flowpathye[5].sort:'加载中'">
	</leftbox-item>
	<rightbox-item 
	         :titleimage="flowpathye[6].titleimage?getAdminPath()+flowpathye[6].titleimage:'加载中'"
	         :textdescribe="flowpathye[6].textdescribe?flowpathye[6].textdescribe:'加载中'"
	         :describetext="flowpathye[6].describetext?flowpathye[6].describetext:'加载中'"
	         :image1="flowpathye[6].image1?getAdminPath()+flowpathye[6].image1:'加载中'"
	         :image2="flowpathye[6].image2?getAdminPath()+flowpathye[6].image2:'加载中'"
	         :image3="flowpathye[6].image3?getAdminPath()+flowpathye[6].image3:'加载中'"
	         :sort="flowpathye[6].sort?flowpathye[6].sort:'加载中'">
	

	</rightbox-item>
	<!--2.2原形盒子在右，图片在左-->
	<leftbox-item 
	      :titleimage="flowpathye[7].titleimage?getAdminPath()+flowpathye[7].titleimage:'加载中'"
	         :textdescribe="flowpathye[7].textdescribe?flowpathye[7].textdescribe:'加载中'"
	         :describetext="flowpathye[7].describetext?flowpathye[7].describetext:'加载中'"
	         :image1="flowpathye[7].image1?getAdminPath()+flowpathye[7].image1:'加载中'"
	         :image2="flowpathye[7].image2?getAdminPath()+flowpathye[7].image2:'加载中'"
	         :image3="flowpathye[7].image3?getAdminPath()+flowpathye[7].image3:'加载中'"
	         :sort="flowpathye[7].sort?flowpathye[7].sort:'加载中'">
	</leftbox-item>
	
</div>
<%@include file="../common/common-footer.jsp"%>
<script src="<%=basePath%>static/js/process.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/header.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/footer.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/ProcessPage.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript"
	charset="utf-8"></script>
	<script>
	$(function() {
		//获取优秀学生信息
		getData({
			url : "wd/reqClassOPeningList.do",
			attr : ["ui_class","java_class","web_class"],
			callback:function(){
				vm.ui_class.reverse();
				vm.java_class.reverse();
				vm.web_class.reverse();
			}
		});
		getData({
			url : "wd/flowpathye.do",
			attr : "flowpathye"
		});
		
	});
</script>
</body>
</html>