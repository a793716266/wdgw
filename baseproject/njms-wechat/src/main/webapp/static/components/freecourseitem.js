
Vue.component("freecourseitem",{
	props: [ "picturename","title","number","borderk","heightk","url","isfree","course"],
	template:`
      <div class="container-from-t" >
		<div class="container-from-t-top"  :style="picturename?'background-image: url('+picturename+');':''">
		<a :href="getHref(url,course)" ></a>
		</div>
		<div class="container-from-t-sttom" :style="'width:'+number+'px;border:'+borderk+'px solid #DDDDDD;height:'+heightk+'px;'">
			<p class="text-p-1"><a :href="getHref(url,course)" >{{title}}</a></p>
			<p class="text-p-2">{{isfree}}</p>
		</div>
	  </div>
`,
	methods:{
		getPath:function(){
			let path = window.location.href
			let pathName = window.location.pathname
			let pos = path.indexOf(pathName)
			return path.substring(0,pos)
		},
		getHref:function(url,vtype){
			var status = $("#status").text();
			if(status == '' ){
				return "wd/toLogin.do";
			}
			let href = "";
			if(url)
				href += 'wd/toVideo.do?id='+url
			if(vtype)
				href +='&vtype='+vtype
			return href;
		}
	}
})