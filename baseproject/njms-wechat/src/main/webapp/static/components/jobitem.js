//已工作学生列表
Vue.component("jobitem", {
	/*
	 * stuName:学生姓名
	 * companyName:公司名称
	 * salary:月薪
	 */
	props:["stuName","companyName","salary","time"],
	template: `
		<li class="space-between job-item swiper-slide">
			<div class="stu-name">{{stuName}}</div>
			<div class="company-name">{{companyName}}</div>
			<div class="job-salary">
			月薪：<span class="text-salary">{{salary}}</span>
			</div>
			<div class="job-date" v-if="time">2018-08-20</div>
		</li>
	`
})