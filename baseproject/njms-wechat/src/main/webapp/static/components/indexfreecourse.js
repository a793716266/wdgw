//课程列表
Vue.component("freecourse",{
	props:['courseType','courselist','commentlist','picPath'],
	template:`
	<div class="free-detail space-between">
		<div :class="'free-title free-title-'+courseType">
			<div class="free-cover"></div>
			<div :class="'free-all free-all-'+courseType"></div>
		</div>
		<div :class="'free-content space-between free-content-'+courseType">
			<div class="free-content-pic bg-common" v-for="item in courselist" :style="item.pictureName?'background-image:url('+picPath+item.pictureName+')':''">
				<div class="free-content-pic-cover">{{item.title}}</div>
				<a class="freecourse-a" :href="getHref(item.url,courseType)"></a>
			</div>
		</div>
		<div :class="'free-rate free-rate-'+courseType">
			<div class="rate-title space-between">
				<div class="text-rate font-lg">学员感想</div>
				<div>
					<a href="#" class="rate-all a-default">查看全部></a>
				</div>
			</div>
			
			<div class="rate-content-container">
				<div class="rate-content" v-for="item in commentlist">
					<div class="rate-user displayFlex">
						<div class="rate-user-portrait" :style="item.users[0].picture?'background-image:url('+item.users[0].picture+')':''" ></div>
						<div class="rate-username">{{item.users[0].nickName}}</div>
					</div>
					<div class="text-ratecontent">{{item.content}}</div>
				</div>
			</div>
		</div>
	</div>
	`	,methods: {
			getPath:function(){
				let path = window.location.href
				let pathName = window.location.pathname
				let pos = path.indexOf(pathName)
				return path.substring(0,pos)
			},
			getHref:function(url,vtype){
				let href = "";
				if(url)
					href += 'wd/toVideo.do?id='+url
				if(vtype)
					href +='&vtype='+vtype
				return href;
			}
		}
})




