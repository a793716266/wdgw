Vue.component("replypost", {
	/**
	 * 帖子热门话题
	 * name:帖子类型名字
	 * title：帖子标题
	 * replycard:回帖数
	 * content:帖子内容
	 * nickname:发帖人用户名
	 * viewnumber:帖子浏览量
	 * NewTimeDifference:发帖时间距离当前日期的时间差显示
	 */
	props:["postid","userid","commencontent","nickname","picture"],
	template:`<div class="p3_r_content">
						<div class="data">
							<div class="icon"   :style="picture?'background-image:url('+picture+')':''" ></div> <div class="title" @click="postid?gorep(postid):'void(0)'">{{nickname}}</div> 
						</div>
						<div class="p3_paragraph">
						{{commencontent}}
						
						</div>
					</div>
		 ` ,
		 methods:{
			 gorep:function(id){
					window.location.href="wd/toNode.do?post_id="+id;
				}
		}
	
});