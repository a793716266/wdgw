//金牌讲师列表元素
Vue.component("teacheritem",{
	/*
	 * name：讲师姓名
	 * exp：开发经验
	 * designation：称号
	 * tags：标签
	 * 
	 * 插槽：skills：技能描述
	 */
	props:["name","curriculumType","remarks","content","headPortrait","numberofyears","identity"],
	template:`
	<li class="jiangshi-item swiper-slide">
		<div class="teacherinfo displayFlex">
			<div class="teacher-portrait bg-common" :style="headPortrait?'background-image: url('+headPortrait+');':''"></div>
			<div class="teacherinfo-detail">
				<div class="teacherinfo-base">
					<span class="teacher-name font-lg">{{name}}</span>
					<span class="exp">{{numberofyears}}年开发经验</span>
				</div>
				<div class="designation font-md text-salary">{{curriculumType}}金牌讲师</div>
				<div class="btn-play"></div>
			</div>
		</div>
		<div class="teacherinfo-skills">
			<slot name="info"></slot>
			<div class="text-salary">
				学员对他的评价：
			</div>
			<div class="tags">
				<div v-for="(item,i) in content" v-if="i<4">{{item.content}}</div>
			</div>
		</div>
	</li>
	`
});