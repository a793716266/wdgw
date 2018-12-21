Vue.component("activeman", {
	/*
	 * pic:背景图
	 * typetitle:类型名称
	 * theme：主题数
	 * replycard：回帖数
	 */
	props:["username","postcount","userpicture","count"],
	template: `
		<div class="rank">
							<div class="ranking_num left">
								{{count}}
							</div>
							<div class="rank_data left">
								
								<img :src="userpicture" class="rank_img left">
								
								<div class="rank_name left">
									{{username}}
								</div>
								<div class="rank_count">
									发帖：<span>{{postcount}}</span>
								</div>
							</div>
						</div>
	`
});