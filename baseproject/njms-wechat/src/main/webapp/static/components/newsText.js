Vue.component("newslist",{
	props:["list","path"],
	template:`
		<div id="newstext">
			<ul class="newsitem" v-for="(newsText,i) in list" v-if="i>=5">
				<div class="newsleft">
					<li class="day">{{newsText.createTime.split(" ")[0].split("-")[2]}}</li>
					<li class="month">{{newsText.createTime.split(" ")[0].split("-")[1]}}月</li>
					<li class="henxian">——</li>
				</div> 
				<div>
					<dl class="news imgText">
						<dt @click="gotoNewsDetail(newsText.news_id)"><img onload="controlSize(this)" :src="newsText.pictureName?path+newsText.pictureName:''"/></dt>
						<dd><h2 class="newsTitle">{{newsText.newTitle}}</h2></dd>
						<dd class="txt"><a class="a-default" href="javascript:void(0)" @click="gotoNewsDetail(newsText.news_id)">{{getText(newsText.newContent)}}</a></dd>
						<dd><span onclick="weiguan()" class="btnText" @click="gotoNewsDetail(newsText.news_id)">围观一下<i class="fa fa-angle-right" aria-hidden="true"></i></span></dd>
					</dl>
				</div>
		</ul>
	</div>
	`,
	methods:{
		getText:function(txt){
			return $(txt).text();
		},
		gotoNewsDetail:function(id){
			location.href="gotoNewsDetail.do?newsid="+id;
			}
		}
	})

				