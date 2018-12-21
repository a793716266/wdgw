//脚部
Vue.component("wdfooter",{
props:["list","campusinfo","path"],
template:`
	<div class="footer">
		<!-- footer-top -->
		<div class="footer-top">
			<div class="footer-container">
				<ul class="footer-nav space-between">
					<li v-for="item in list">
						<div class="footer-icon bg-common" :style="item.lOGO?'background-image:url('+path+item.lOGO+')':''"></div>
						<div class="footer-number font-max text-salary">{{item.cOUNT.toUpperCase()}}+</div>
						<div class="text-lightgrey footer-desc">{{item.nAME}}</div>
						<div class="btn-know"><a :href="item.rESPATH"></a>了解详细</div>
					</li>
				</ul>
			</div>
		</div>
		<!-- footer-top end...-->
		<!-- footer-bottom -->
		<div class="footer-bottom">
			<div class="footer-container space-between">
				<div class="footer-bottom-left space-between">
					<ul>
						<a href="wd/gotoNewsDetail.do?newsid=4fdc6d3df74441b8aec069f422149390"><li class="font-md text-lightgrey">关于课工场</li></a>
						<a href="wd/gotoNewsDetail.do?newsid=7415f93f273546c99660391f057c13e0"><li class="text-lightgrey">校园环境</li></a>
						<a href="wd/gotoNewsDetail.do?newsid=6d1fd75f443a4c09b7cde9e4d0daf5d9"><li class="text-lightgrey">发展历程</li></a>
						<a href="wd/gotoNewsDetail.do?newsid=f80b2b163363435ea12059dd6d602e5a"><li class="text-lightgrey">招贤纳士</li></a>
					</ul>
					<ul>
						<a href="wd/toFreecourse.do"><li class="font-md text-lightgrey">学习资源</li></a>
						<a href="wd/toFreecourse.do"><li class="text-lightgrey">免费公开课</li></a>
						<a href="wd/toFreecourse.do"><li class="text-lightgrey">免费课程视频</li></a>
						<a href="wd/toFreecourse.do"><li class="text-lightgrey">学习路线</li></a>
					</ul>
					<ul>
						<a href="wd/toProcessPage.do"><li class="font-md text-lightgrey">报名入学</li></a>
						<a href="wd/toProcessPage.do"><li class="text-lightgrey">报名流程</li></a>
						<a href="wd/toProcessPage.do"><li class="text-lightgrey">报名须知</li></a>
						<a href="wd/toFreecourse.do"><li class="text-lightgrey">课程安排</li></a>
					</ul>
				</div>
				<div class="footer-bottom-right" v-for="item in campusinfo">
					<div class="address text-lightgrey">文鼎校区地址：{{item.aDDRESS}}</div>
					<div class="address text-lightgrey">咨询热线：{{item.aDVISORYTELEPHONE}}</div>
					<div class="copyright text-lightgrey">©CopyRight {{item.vERSIONNUMBER}}</div>
				</div>
			</div>
		</div>
		<!-- footer-bottom end...-->
	</div>
`,
	mounted:function(){
		getData({
			url : "wd/getAllWdgw_foot.do",
			attr :"footlist"
		});
		
		getData({
			url : "wd/getAllWdgw_campusinfo.do",
			attr :"campusinfo"
		});
	}
	
})