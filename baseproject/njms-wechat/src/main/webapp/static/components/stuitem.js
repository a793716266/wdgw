//学生列表
Vue.component("stuitem", {
	/*
	 * name:学生姓名
	 * salary:薪水
	 * desc:描述
	 * words:学习感言
	 * play:是否可播放
	 */
	props: ["stuName","studentimg","empWage","empTime","empCompany","speech","play","videoUrl"],
	template: `
	<li>
		<div class="stupic" :style="studentimg?'background-image:url('+studentimg+')':''">
			<div v-show="play" class="btn-play-sm"></div>
			<div class="shade shadeVideo" id="shadeVideo" :data-url="videoUrl">
				<div v-show="play" class="btn-play-lg"></div>
				<div v-show="play" class="text-play">点击播放</div>
			</div>
		</div>
		<div class="stuinfo">
			<div class="stubaseinfo">
				<div class="stubaseinfo-top space-between">
					<div class="stuname">{{stuName}}</div>
					<div class="stusalary">就业月薪：<span class="font-lg text-salary">{{empWage}}</span></div>
				</div>
				<div class="stubaseinfo-bottom">
					{{empTime}}就职于{{empCompany}}
				</div>
			</div>
			<div class="stuwords">
				<div class="stuwords-text">
					学习感言：{{speech}}
				</div>
			</div>
		</div>
	</li>
	`
});