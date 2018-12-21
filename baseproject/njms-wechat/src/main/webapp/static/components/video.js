Vue.component("videoall",{
	props: ["title","isfree","url","pictureName"],
	template:`
	<li>
		<div class="course bg-common"  :style="pictureName?'background-image: url('+pictureName+');':''">
		<div class="subject" title="" >
		</div>
		<div class="play" :data-src="url"></div>
		</div>
		<div class="explain">
		<div class="title" title="">
			<a href="javascript:void(0)">{{title}}</a>
		</div>
		<div class="type">{{isfree}}</div>
		</div>
		</li>
		`,
		methods:{
			// 获取项目路径
			getPath:function(){
				let path = window.location.href
				let pathName = window.location.pathname
				let pos = path.indexOf(pathName)
				return path.substring(0,pos)
			}
		}
})