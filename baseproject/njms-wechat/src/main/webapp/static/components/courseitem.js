//课程列表
Vue.component("courseitem",{
	/*
	 * courseTitle:课程名称 version:版本 avgSalary:平均薪水 weekCount:学习周数
	 */
	props:["infoName","version","wages","studyTime","newest","picture"],
	template:`
	<li>
		<div v-show="newest" class="newest">最新</div> 
		<div class="coursepic"   :style="picture?'background-image: url('+picture+');':''"></div>
		<div class="courseinfo">
			<div class="course-title displayFlex">
				<div class="text-course-title font-lg">
					{{infoName}}
				</div>
				<div class="course-version">
					{{version}}
				</div>
			</div>
			<div class="course-detail">
				<div>就业起薪：平均<span class="text-salary">{{wages}}</span>元</div>
				<div>学习周期：<span class="text-salary">{{studyTime}}</span>周</div>
			</div>
			<div class="btn-know">
				了解一下
			</div>
		</div>
	</li>`	
})