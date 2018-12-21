Vue.component("posting", {
	/**
	 * 帖子热门话题
	 * name:帖子类型名字
	 * title：帖子标题
	 * replycard:回帖数
	 * content:帖子内容
	 * nickname:发帖人用户名
	 * viewnumber:帖子浏览量
	 * timeDiff:发帖时间距离当前日期的时间差显示
	 */
	props:["post_id","name","title","replycard","content","nickname","viewnumber","userid","tf"],
	template: `
	<div class="content">
		<div class="p3_title">
			<div class="txt" @click="toNode()" style='width: 10em;white-space: nowrap;overflow:hidden;text-overflow: ellipsis;'>【<span>{{name}}</span>】{{title}}</div>
			<div class="p3_num">{{replycard}}</div>
		</div>
		<div class="p3_paragraph" style='width:650px;height:50px;word-wrap:break-word;' v-html = 'content'>
			
		</div>
		
		<div class="p3_data">
			<div class="post_name">
				<i class="icon"></i>{{nickname}}
			</div>
			<div class="post_num">
				<i class="icon"></i>{{viewnumber}}
			</div>
			<div class="post_time">
				<i class="icon"></i>{{tf}}
			</div>
		</div>
	</div>
	`,
	
	methods:{
		toNode:function(){
			window.location.href="wd/updatePost.do?post_id="+this.post_id;
			
		}
	}
	
});