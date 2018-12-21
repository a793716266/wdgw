
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common-header.jsp"%>
<%@include file="../common/common.jsp"%>

<%
	/* System.out.println("----------"+adminProjPath); */
%>

<!--中部-->
<!--大轮播图-->
<div class="lunbo swiper-container" id="bigluobo">
	<ul class="lunbolist swiper-wrapper">
		<li class="biglunbo-item swiper-slide" v-for="item in broadcastList"
			:style="item.picturePath?'background-image: url(${requestPath }'+item.picturePath+');':''"></li>
	</ul>
</div>
<div  id="Mask">
	<div class="video-btn" id="video-btn">
	<div class="video-area" id="video-area"></div>
	<a class="video-shut" id="video-shut">×</a>
</div>
	<div id="shadow"></div>
</div>
<!--主体-->
<div class="section">
	<div class="container">
		<!-- section-top -->
		<ul class="section-top space-between">
			<li class="displayFlex">
				<div class="icon-computer"></div>
				<div class="aim">
					<div class="font-lg">就业保障</div>
					<div>北京大学校办企业</div>
				</div>
			</li>
			<li class="displayFlex">
				<div class="icon-computer"></div>
				<div class="aim">
					<div class="font-lg">小班面授</div>
					<div>北京大学校办企业</div>
				</div>
			</li>
			<li class="displayFlex">
				<div class="icon-computer"></div>
				<div class="aim">
					<div class="font-lg">项目贯穿</div>
					<div>北京大学校办企业</div>
				</div>
			</li>
			<li class="displayFlex">
				<div class="icon-computer"></div>
				<div class="aim">
					<div class="font-lg">免费试学</div>
					<div>北京大学校办企业</div>
				</div>
			</li>
		</ul>
		<!-- section-module-clz -->
		<div class="section-module">
			<div class="module-title title-salary">
				<img onload="controlSize(this)" src="<%=basePath%>static/img/index/Highsalary.png" />
			</div>
			<div class="module-detail space-between">
				<div class="rotateContainer swiper-container" id="clzitem">
					<div class="rotateBtn btnPrev hide"></div>
					<div class="rotateBtn btnNext hide"></div>
					<ul class="clzlist swiper-wrapper">
						<clzitem v-for="item in clzlist" :clz-type="item.classType"
							:clz-icon="item.classLogo?'${requestPath }'+item.classLogo:''"
							:clz-no="item.className?item.className:'加载中'"
							:clz-desc="item.systemType?item.course+item.systemType:'加载中'"
							:max-salary="item.maxSalary?item.maxSalary:'加载中'"
							:avg-salary="item.avgSalary?item.avgSalary:'加载中'"></clzitem>
					</ul>
				</div>
				<div class="joblist">
					<div class="joblist-title font-lg">最近就业学员</div>
					<div class="rotateContainer swiper-container" id="jobitem">
						<ul class="joblist-nav  swiper-wrapper">
							<jobitem v-for="item in joblist"
								:stu-name="item.name?item.name:'加载中'"
								:company-name="item.companyName?item.companyName:'加载中'"
								:salary="item.salary?item.salary:'加载中'"></jobitem>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- module-section-clz...end -->
		<!-- module-section-stu -->
		<!-- module-section-stuclzitemclzitem -->
		<div class="section-module">
			<div class="module-title title-stu">
				<img onload="controlSize(this)" src="<%=basePath%>/static/img/index/goodStu.png" />
			</div>
			<div class="module-detail space-between">
				<ul class="stulist space-between">
					<stuitem v-for="(item,i) in stulist" v-if="i<4"
						:studentimg="item.studentimg?'${requestPath }'+item.studentimg:''"
						:stu-name="item.stuName?item.stuName:'加载中'" play="true"
						:emp-wage="item.empWage?item.empWage:'加载中'"
						:emp-time="item.empTime?item.empTime:'加载中'"
						:emp-company="item.empCompany?item.empCompany:'加载中'"
						:speech="item.speech?item.speech:'加载中'"
						:video-url="item.videoName"></stuitem>
				</ul>
			</div>
		</div>
		<!-- module-section-stu...end -->
		<!-- module-section-rate -->
		<div class="section-module">
			<div class="module-title title-rate">
				<img onload="controlSize(this)" src="<%=basePath%>/static/img/index/rate.png" />
			</div>
			<div class="module-detail module-detail-rate space-between">
				<ul class="ratelist space-between">
					<rateitem v-for="item in ratelist"
						:rate-name="item.hr_name?item.hr_name:'加载中'"
						:headportrait="item.headPortrait?'${requestPath }'+item.headPortrait:''"
						:text-rate="item.evaluation?item.evaluation:'加载中'"
						:job-name="item.hr_position?item.hr_position:'加载中'"
						:company-logo="item.logo?'${requestPath }'+item.logo:''"></rateitem>
				</ul>
			</div>
		</div>
		<!-- module-section-rate...end -->
		<!-- module-section-course -->
		<div class="section-module">
			<div class="module-title title-course">
				<img onload="controlSize(this)" src="<%=basePath%>/static/img/index/course.png" />
			</div>
			<div class="module-detail">
				<ul class="courselist space-between">
					<courseitem v-for="(item,i) in courselist" :newest="i<1"
						:info-name="item.infoName?item.infoName:'加载中'" version="标准版"
						:wages="item.wages?item.wages:'加载中'"
						:picture="item.picture?'${requestPath }'+item.picture:''"
						:study-time="item.studyTime?item.studyTime:'加载中'"> </courseitem>
				</ul>
			</div>
		</div>
		<!-- module-section-course end...-->
		<!-- module-section-free -->
		<div class="section-module">
			<div class="module-title title-free">
				<img onload="controlSize(this)" src="<%=basePath%>/static/img/index/free.png" />
			</div>
			<div class="module-detail module-detail-free">
				<!--UI-->
				<freecourse course-type="ui" :courselist="uilist"
					:commentlist="commentuiList" :pic-path="'${requestPath }'"></freecourse>
				<!--JAVA-->
				<freecourse course-type="java" :courselist="javalist"
					:commentlist="commentjavaList" :pic-path="'${requestPath }'"></freecourse>
				<!--WEB-->
				<freecourse course-type="web" :courselist="weblist"
					:commentlist="commentwebList" :pic-path="'${requestPath }'"></freecourse>

			</div>
		</div>
		<!-- module-section-free end...-->
		<!-- module-section-project -->
		<div class="section-module">
			<div class="module-title title-project">
				<img onload="controlSize(this)" src="<%=basePath%>/static/img/index/project.png" />
			</div>
			<ul class="nav-project space-between">
				<li class="active" id="tab-ui" @mouseover="changePorject('ui')">UI项目展示</li>
				<li id="tab-java" @mouseover="changePorject('java')">JAVA项目展示</li>
				<li id="tab-web" @mouseover="changePorject('web')">WEB项目展示</li>
			</ul>
			<div class="module-detail module-detail-project space-between">
				<div class="project project-lg bg-common"
					:style="projectlist[0].projectPic?'background-image:url(${requestPath }'+projectlist[0].projectPic+')':''"
					:title="projectlist[0].projectName?projectlist[0].projectName:'加载中'">
				</div>
				<ul class="project-sm-list space-between">
					<projectlist v-for="(item,i) in projectlist" v-if="i>0"
						:imgurl="projectlist[i].projectPic?'${requestPath }'+projectlist[i].projectPic:''"
						:project-name="projectlist[i].projectName?projectlist[i].projectName:'加载中'"></projectlist>
				</ul>
			</div>
		</div>
		<!-- module-section-project end...-->
		<!-- module-section-biz -->
		<div class="section-module">
			<div class="module-title title-biz">
				<img onload="controlSize(this)" src="<%=basePath%>/static/img/index/biz-title.png" />
			</div>
			<div class="module-detail module-detail-biz space-between">
				<div class="biz-train biz">
					<div class="biz-title font-max">{{businesspracticelist[0]?businesspracticelist[0].titleName:''}}</div>
					<ul class="biz-infolist">
						<li class="displayFlex">
							<div class="bizinfo-title font-lg">实战项目数量：</div> <span
							class="font-max text-salary">{{businesspracticelist[0]?businesspracticelist[0].projectCount:''}}个以上</span>
						</li>
						<li class="displayFlex">
							<div class="bizinfo-title font-lg">最高就业月薪：</div> <span
							class="font-max text-salary">{{businesspracticelist[0]?businesspracticelist[0].maxSalary:''}}元</span>
						</li>
						<li class="displayFlex">
							<div class="bizinfo-title font-lg">平均就业月薪：</div> <span
							class="font-max text-salary">{{businesspracticelist[0]?businesspracticelist[0].avgSalary:''}}元</span>
						</li>
						<li class="displayFlex">
							<div class="bizinfo-title font-lg">高薪就业率：</div> <span
							class="font-max text-salary">{{businesspracticelist[0]?businesspracticelist[0].jobPercent:''}}%</span>
						</li>
					</ul>
				</div>
				<div class="biz-notrain biz">
					<div class="biz-title font-max">{{businesspracticelist[1]?businesspracticelist[1].titleName:''}}</div>
					<ul class="biz-infolist">
						<li class="displayFlex">
							<div class="bizinfo-title font-lg">实战项目数量：</div> <span
							class="font-max text-salary">{{businesspracticelist[1]?businesspracticelist[1].projectCount:''}}个左右</span>
						</li>
						<li class="displayFlex">
							<div class="bizinfo-title font-lg">最高就业月薪：</div> <span
							class="font-max text-salary">{{businesspracticelist[1]?businesspracticelist[1].maxSalary:''}}元</span>
						</li>
						<li class="displayFlex">
							<div class="bizinfo-title font-lg">平均就业月薪：</div> <span
							class="font-max text-salary">{{businesspracticelist[1]?businesspracticelist[1].avgSalary:''}}元</span>
						</li>
						<li class="displayFlex">
							<div class="bizinfo-title font-lg">高薪就业率：</div> <span
							class="font-max text-salary">{{businesspracticelist[1]?businesspracticelist[1].jobPercent:''}}%</span>
						</li>
					</ul>
				</div>
				<div class="vs"></div>
			</div>
		</div>
		<!-- module-section-biz end...-->
		<!-- module-section-job -->
		<div class="section-module">
			<div class="module-title title-job">
				<img onload="controlSize(this)" src="<%=basePath%>static/img/index/job-title.png" />
			</div>
			<div class="module-detail module-detail-job space-between">
				<ul class="jobprocess space-between">
				<flowpath v-for="(item,i) in flowpathlist" v-if="i<3" 
				direction="arrow-right"
				:titleimage="item.titleimage?'${requestPath }'+item.titleimage:'加载中'"
				:textdescribe="item.textdescribe?item.textdescribe:'加载中'"
				:detailsurl="item.detailsurl?item.detailsurl:'加载中'"
				></flowpath>
				<flowpath v-for="(item,i) in flowpathlist" v-if="i==3" 
				direction="arrow-down"
				:titleimage="item.titleimage?'${requestPath }'+item.titleimage:'加载中'"
				:textdescribe="item.textdescribe?item.textdescribe:'加载中'"
				:detailsurl="item.detailsurl?item.detailsurl:'加载中'"
				></flowpath>
				<flowpath v-for="(item,i) in flowpathlist" v-if="i==7" 
				:titleimage="item.titleimage?'${requestPath }'+item.titleimage:'加载中'"
				:textdescribe="item.textdescribe?item.textdescribe:'加载中'"
				:detailsurl="item.detailsurl?item.detailsurl:'加载中'"
				></flowpath>
				<flowpath v-for="(item,i) in flowpathlist" v-if="i==6" 
				direction="arrow-left"
				:titleimage="item.titleimage?'${requestPath }'+item.titleimage:'加载中'"
				:textdescribe="item.textdescribe?item.textdescribe:'加载中'"
				:detailsurl="item.detailsurl?item.detailsurl:'加载中'"
				></flowpath>
					<flowpath v-for="(item,i) in flowpathlist" v-if="i==5" 
				direction="arrow-left"
				:titleimage="item.titleimage?'${requestPath }'+item.titleimage:'加载中'"
				:textdescribe="item.textdescribe?item.textdescribe:'加载中'"
				:detailsurl="item.detailsurl?item.detailsurl:'加载中'"
				></flowpath>
					<flowpath v-for="(item,i) in flowpathlist" v-if="i==4" 
				direction="arrow-left"
				:titleimage="item.titleimage?'${requestPath }'+item.titleimage:'加载中'"
				:textdescribe="item.textdescribe?item.textdescribe:'加载中'"
				:detailsurl="item.detailsurl?item.detailsurl:'加载中'"
				></flowpath>
				</ul>
			</div>
		</div>
		<!-- module-section-job end...-->
		<!-- module-section-teacher -->
		<div class="section-module">
			<div class="module-title title-teacher">
				<img onload="controlSize(this)" src="<%=basePath%>static/img/index/teacher-title.png" />
			</div>
			<div class="module-detail module-detail-teacher swiper-container" id="teachers">
				<ul class="teacherlist swiper-wrapper" style="overflow: visible;">
					<teacheritem v-for="item in teacherlist"
						:name="item.name?item.name:'加载中'"
						:head-portrait="item.headPortrait?'${requestPath }'+item.headPortrait:''"
						:numberofyears="item.numberofyears?item.numberofyears:'加载中'"
						:curriculum-type="item.curriculumType?item.curriculumType:'加载中'"
						:remarks="item.remarks?item.remarks:'加载中'"
						:content="item.content?item.content:'加载中'">
					<div class="skillcontent" slot="info">{{item.info?item.info:'加载中'}}</div>
					</teacheritem>
				</ul>
				<div class="swiper-button swiper-button-prev"></div>
				<!--左箭头-->
				<div class="swiper-button swiper-button-next"></div>
				<!--右箭头-->
				<div class="swiper-pagination swiper-pagination-bullets teacherPager" style="bottom: 10px;">
				</div>
			</div>
		</div>
		<!-- module-section-teacher end...-->
		<!-- module-section-news -->
		<a id="newsInfoMation" name="newsInfoMation"></a>
		<div class="section-module">
			<div class="module-title title-news title-sm">
				<img onload="controlSize(this)" src="<%=basePath%>static/img/index/news.png" />
			</div>
			<div class="module-detail module-detail-news space-between">
				<div class="newslist space-between">
					<!--行业动态-->
					<div class="news-item news-industry space-between">
						<div class="news-item-container">
							<div class="news-top space-between">
								<div class="news-type" id="dongtai">行业动态</div>
								<div>
									<a class="btn-all a-default" href="javascript:void(0)"
										onclick="dongtai()">查看全部></a>
								</div>
							</div>
							<div class="news-detail">
								<newstestall v-for="(item,i) in newsListh" v-if="i<1"
									:news_id="item.news_id?item.news_id:''"
									:new-title="item.newTitle?item.newTitle:'加载中'"
									:picture-name="item.pictureName?item.pictureName:'加载中'"
									:new-content="item.newContent?item.newContent:'加载中'"
									newscolor="#FE9515" :path="'${requestPath }'"></newstestall>
								<newsitem v-for="(item,i) in newsListh" v-if="i>0"
									:news_id="item.news_id?item.news_id:''"
									:create-time="item.createTime?item.createTime:'加载中'"
									:news-titleall="item.newTitle?item.newTitle:'加载中'"></newsitem>
							</div>
						</div>
					</div>
					<!--校区新闻-->
					<div class="news-item news-community">
						<div class="news-item-container">
							<div class="news-top space-between">
								<div class="news-type" id="news">校区新闻</div>
								<div>
									<a class="btn-all a-default" href="javascript:void(0)"
										onclick="news()">查看全部></a>
								</div>
							</div>
							<div class="news-detail">
								<newstestall v-for="(item,i) in newsListx" v-if="i<1"
									:news_id="item.news_id?item.news_id:''"
									:new-title="item.newTitle?item.newTitle:'加载中'"
									:picture-name="item.pictureName?item.pictureName:'加载中'"
									:new-content="item.newContent?item.newContent:'加载中'"
									newscolor="#FE9515" :path="'${requestPath }'"></newstestall>
								<newsitem v-for="(item,i) in newsListx" v-if="i>0"
									:news_id="item.news_id?item.news_id:''"
									:create-time="item.createTime?item.createTime:'加载中'"
									:news-titleall="item.newTitle?item.newTitle:'加载中'"></newsitem>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- module-section-news end...-->
		<!-- module-section-school -->
		<div class="section-module swiper-container" id="schools">
			<div class="module-title title-school title-sm">
				<img onload="controlSize(this)" src="<%=basePath%>static/img/index/school-title.png" />
			</div>
			<ul class="module-detail module-detail-school space-between swiper-wrapper">
				<!-- 合作院校 -->
				<li class="swiper-slide" v-for="item in academylist" style="overflow: hidden;"><img
					:src="item.picture?getAdminPath()+item.picture:''" :title="item.name"
					onload="controlSize(this,0,50)" /></li>
			</ul>
		</div>
		<!-- module-section-school end... -->
		<div class="section-module section-company">
			<div class="module-title title-company title-sm">
				<img onload="controlSize(this)" src="<%=basePath%>static/img/index/company-title.png" />
			</div>
			<ul class="module-detail module-detail-company">
				<!--合作企业 -->
				<li v-for="item in companylist" style="overflow: hidden;"><img
					:src="item.picture?'${requestPath }'+item.picture:''" :title="item.name"
					onload="controlSize(this)" /></li>
			</ul>
		</div>
		<!-- module-section-school end... -->
	</div>
</div>
<%@include file="../common/common-footer.jsp"%>

<script src="<%=basePath%>static/js/vue.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/header.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/footer.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/clzitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/indexfreecourse.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/jobitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/newsitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/stuitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/flowpath.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/rateitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/projectlist.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/courseitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/teacheritem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/newsTestall.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript"
	charset="utf-8"></script>
<script>
	window.onload=function(){
		if("${newsInfoMation}"==="miao"){
			//window.location="#newsInfoMation";
			$(window).scrollTop($("#newsInfoMation").offset().top)
		} 
	}
	$(function() {
		
		//首页轮播图
		getData({
			url : "wd/findbroadcasts.do",
			data : {
				broadcastPage : 0,
				broadcastName : "broadcastList"
			},
			attr : "broadcastList",
			callback:function(){
				//轮播
			
				setTimeout(function() {
					var lunSwiper = new Swiper("#bigluobo", {
						slidesPerView: 1,
						loop: true,
						autoplay: {
							delay: 3000,
							stopOnLastSlide: false,
							disableOnInteraction: true,
							disableOnInteraction: false
						},
						
					});
					$(".lunbolist").on("mouseenter",function(){
						lunSwiper.autoplay.stop();
					});
					$(".lunbolist").on("mouseleave", function () {
						lunSwiper.autoplay.start();
					});
				},1)
			}
		});
		//合作院校
		getData({
			url : "wd/getAllAcademy.do",
			attr : "academylist",
			callback:function(data){
				let count = data.academylist.length;
				let schoolSwiper = new Swiper("#schools", {
					slidesPerView: 5,
					spaceBetween: 10,
					loop: true,
					allowTouchMove:false,
					autoplay: {
						delay: 3000,
						stopOnLastSlide: false,
						disableOnInteraction: false
					}
				})
				schoolSwiper.el.onmouseover = function(){
					schoolSwiper.autoplay.stop();
				}
				schoolSwiper.el.onmouseleave = function(){
					schoolSwiper.autoplay.start();
				}
				setTimeout(function(){
					for(let i = 0;i<5;i++){
						$(".module-detail-school.swiper-wrapper .swiper-slide:eq("+(i+count)+")").html($(".module-detail-school.swiper-wrapper .swiper-slide:eq("+(i+count+5)+")").html())
					}
					for(let i = 0;i<5;i++){
						$(".module-detail-school.swiper-wrapper .swiper-slide:eq("+(i+count+5)+")").html($(".module-detail-school.swiper-wrapper .swiper-slide:eq("+(i+5)+")").html())
					}
				},1000)
			}
		});
		//合作企业
		getData({
			url : "wd/getAllCompany.do",
			attr : "companylist",
			callback:function(){
				setTimeout(function(){
					controlMargin(".module-detail-company", 5) 
					$(".module-detail-company").height($(".module-detail-company").height()+70)
				},1000)
			}
		});
		//免费干货课程
		getData({
			url : "wd/reqVidList.do",
			attr : [ "uilist", "javalist", "weblist" ]
		});
		//免费干货课程--学员感想
		getData({
			url : "wd/findComment.do",
			attr : [ "commentuiList", "commentjavaList", "commentwebList" ]
		})
		//获取名企HR评价信息
		getData({
			url : "wd/mainShowHRInfo.do",
			attr : "ratelist"
		})
		//按新闻类型查询
		getData({
			url : "wd/newsindexAll.do",
			attr : [ "newsListh", "newsListx" ]
		})
		//获取优秀老师信息
		getData({
			url : "wd/toIndexk.do",
			attr : [ "teacherlist", "banzhurenlist"],
			callback:function(){
			
				setTimeout(function(){
					let teacherSwiper = new Swiper("#teachers", {
						slidesPerView: 3,
						spaceBetween: 25,
						loop: true,
						allowTouchMove:false,
						autoplay: {
							delay: 3000,
							stopOnLastSlide: false,
							disableOnInteraction: false
						},
						pagination: {
							el: '.swiper-pagination',
							clickable: true,
						},
						navigation: {
							nextEl: '.swiper-button-next',
							prevEl: '.swiper-button-prev',
						},
					})
					teacherSwiper.el.onmouseover = function(){
						teacherSwiper.autoplay.stop();
					}
					teacherSwiper.el.onmouseleave = function(){
						teacherSwiper.autoplay.start();
					}
					$(".teacherPager").prepend($(".swiper-button.swiper-button-prev")) 
					$(".teacherPager").append($(".swiper-button.swiper-button-next"))
				},1)
			}
		})

		//获取班级信息和就业学生信息
		getData({
			url : "wd/reqClzAndJob.do",
			attr : [ "clzlist", "joblist" ],
			callback:function(){
				//clz部分轮播
			
				setTimeout(function(){
					var clzSwiper = new Swiper("#clzitem", {
						slidesPerView: 4,
						spaceBetween: 2,
						loop: true,
						autoplay: {
							delay: 3000,
							stopOnLastSlide: false,
							disableOnInteraction: true,
							disableOnInteraction: false
						},
						navigation: {
							nextEl: '.btnNext',
							prevEl: '.btnPrev',
						},
					});
					$(".clzlist").on("mouseenter",function(){
						clzSwiper.autoplay.stop();
					});
					$(".clzlist").on("mouseleave", function () {
						clzSwiper.autoplay.start();
					});
				},1);
				
			
				setTimeout(function(){
					var jobSwiper = new Swiper("#jobitem", {
						slidesPerView: 6,
						loop: true,
						speed:1000,
						direction: 'vertical',
						autoplay: {
							delay:0,
							stopOnLastSlide: false,
							disableOnInteraction: true,
							disableOnInteraction: false
						},
					});
					$(".joblist-nav").on("mouseenter",function(){
						jobSwiper.autoplay.stop();
					});
					$(".joblist-nav").on("mouseleave", function () {
						jobSwiper.autoplay.start();
					});
				},1);
				
			}
		});

		//获取厉害课程
		getData({
			url : "wd/reqCurList.do",
			attr : "courselist"
		});
		//获取优秀学生信息
		getData({
			url : "wd/findGoodStudent.do",
			attr : "stulist"
		});
		//项目展示信息
		getData({
			url : "wd/getProjectList.do",
			attr : [ "uiprojectlist", "javaprojectlist", "webprojectlist" ],
			callback : function() {
				vm.projectlist = vm.uiprojectlist
			}
		});
		//实训项目展示
		getData({
			url:"wd/getBusinesspracticeInfo.do",
			attr:"businesspracticelist"
		});

		getData({
			url : "wd/flowpathInfo.do",
			attr : "flowpathlist"
		});
		
		
		$("#dongtai").click(
			function() {
				var newsText = $("#dongtai").html();
				location.href = "wd/javaNews.do?newsText="
						+ encodeURI(encodeURI(newsText));
			})

		$("#news").click(
			function() {
				var newsText = $("#dongtai").html();
				location.href = "wd/javaNews.do?newsText="
						+ encodeURI(encodeURI(newsText));
			})
	});

	function dongtai() {
		var newsText = $("#dongtai").html();
		location.href = "wd/javaNews.do?newsText="
				+ encodeURI(encodeURI(newsText));
	}
	function news() {
		var newsText = $("#news").html();
		location.href = "wd/javaNews.do?newsText="
				+ encodeURI(encodeURI(newsText));
	} 
	
</script>
</body>

</html>