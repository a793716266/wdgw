Vue.component("newstestall",{
	props:["newscolor","newContent","newTitle","pictureName",'path',"news_id"],
	template:`
		<div class="news-head space-between">
		<div class="news-pic" @click="goto(news_id)">
			<img :src="pictureName?path+pictureName:''" onload="controlSize(this)" />
		</div>
		<div class="news-content">
		<div class="news-title" @click="goto(news_id)">{{newTitle?newTitle:'加载中'}}</div>
		<div class="news-content-text a-default" @click="goto(news_id)">{{newContent?getText(newContent):'加载中'}}</div>
		</div>
		</div>
`,
methods:{
	getText:function(txt){
		return $(txt).text();
	}
	,goto:function(id){
		location.href="wd/gotoNewsDetail.do?newsid="+id;
	}
}
})

	