Vue.component("posttypeitem", {
	/*
	 * pic:背景图
	 * typetitle:类型名称
	 * theme：主题数
	 * replycard：回帖数
	 */
	props:["posttype"],
	template: `
	<div class="fl_g" @click="posttype?toTypePage(posttype.posttype_id):'void(0)'">
		<div class="fl_img" :style="posttype?'background-image:url('+posttype.pic+')':''"></div>
		<div class="fl_test">
			<h4>{{posttype?posttype.name:'加载中'}}</h4>
			<p>主题:<span>{{posttype?posttype.theme:'加载中'}}</span></p>
			<p>回帖:<span>{{posttype?posttype.replycard:'加载中'}}</span></p>
		</div>
	</div>
	`,
	methods:{
		toTypePage:function(typeid){
		
			/*location.href = this.getProjPath()+"/wd/luntanbytype.do?typeid="+typeid */
			location.href = this.getProjPath()+"wd/luntanbytype.do?typeid="+typeid
		},
		getPath:function(){
			let path = window.location.href
			let pathName = window.location.pathname
			let pos = path.indexOf(pathName)
			return path.substring(0,pos)
		},
		getProjPath:function(){
		
			/*return "http://www.zbkgc.com/"; */
			return "";
		}
	}
});