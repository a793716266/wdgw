//评价列表
Vue.component("rateitem",{
	/*
	 * rateName：评价人姓名
	 * textRate：评价内容
	 * jobName：在公司职位
	 */
	props:["rateName","textRate","jobName","headportrait","companyLogo"],
	template:`
	<li>
		<div class="rate-top">
			<div class="portrait"  :style="'background-image: url('+headportrait+');'"></div>
			<div class="rate-name">{{rateName}}</div>
			<div class="rate-quot"></div>
			<div class="text-rate">
			{{textRate}}
			</div>
		</div>
		<div class="rate-bottom space-between">
			<div class="rate-company-logo">
				<img :src="companyLogo" onload="controlSize(this)" />
			</div>
			<div class="rate-company-name">{{jobName}}</div>
		</div>
	</li>
	`
})
