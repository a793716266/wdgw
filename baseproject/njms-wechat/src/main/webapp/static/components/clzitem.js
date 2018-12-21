//班级列表
Vue.component("clzitem", {
	/*
	 * clzType：班级类型，取值[UI,KW,KD]
	 * clzNo：班级编号
	 * clzDesc：班级类型描述
	 * maxSalary：最高月薪
	 * avgSalary：平均月薪
	 */
	props:["clzType","clzNo","clzDesc","maxSalary","avgSalary","clzIcon"],
	template: `
	<li class="banji-item swiper-slide">
		<div class="clz-top">
			<div :class="'clz-icon clz-icon-'+clzType" :style="clzIcon?'background-image:url('+clzIcon+');':''"></div>
			<div class="font-lg clz-name">{{clzType+(clzNo<10?('0'+clzNo):clzNo)}}班</div>
			<div :class="'clz-line clz-'+clzType+'-line'"></div>
		</div>
		<div class="clz-bottom">
			<div>班级类型：{{clzDesc}}</div>
			<div>最高月薪：<span class="font-lg text-salary">{{maxSalary}}元</span></div>
			<div>平均月薪：<span class="font-lg text-salary">{{avgSalary}}元</span></div>
		</div>
	</li>
	`
})