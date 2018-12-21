//评价列表
Vue.component("newsitem",{
	/*
	 * newsTitle：新闻标题
	 * createTime：新闻时间
	 */
	props:["newsTitleall","createTime","news_id"],
	template:`
		<ul class="news-names"> 
		<li class="space-between">
		<div class="news-name displayFlex">
		<div class="point"></div>
		<div class="text-news-name" @click="goto(news_id)">{{newsTitleall}}</div>
		</div>
		<div class="news-date a-default">{{createTime}}</div>
		</li>
		</ul>
		`,
	methods:{
		goto:function(id){
			location.href="wd/gotoNewsDetail.do?newsid="+id;
		}
	}
})