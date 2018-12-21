Vue.component("banzhurenitem", {
	/*
	 * name：讲师姓名
	 * exp：开发经验
	 * tags：标签
	 * 
	 * 插槽：skills：技能描述
	 */
	props:["name","curriculumType","remarks","content","headPortrait","numberofyears","identity"],
	template: `
	<li class="banzhuren-item displayFlex">
		<div class="banzhuren-left">
			<div class="banzhuren-pic bg-common" :style="headPortrait?'background-image: url('+headPortrait+');':''"></div>
			<div class="btn-play"></div>
		</div>
		<div class="banzhuren-right">
			<div class="banzhuren-right-container">
				<div class="banzhuren-name font-lg">{{name}}</div>
				<div class="banzhuren-exp font-sm text-lightgrey">{{numberofyears}}年带班经验</div>
				<div class="banzhuren-words font-sm text-salary">她想说的话：</div>
				<div class="text-banzhuren-words font-sm">
					<slot name="info"></slot>
				</div>
				<div class="banzhuren-tags text-salary">学员对她的评价</div>
				<div class="tags">
					<div v-for="(item,i) in content" v-if="i<2">{{item.content}}</div>
				</div>
			</div>
		</div>
	</li>
	`
});