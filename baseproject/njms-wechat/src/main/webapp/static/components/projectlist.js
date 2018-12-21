Vue.component("projectlist", {
	props:["imgurl","projectName"],
	template:
	`<li class="project project1 bg-common" :style="imgurl?'background-image:url('+imgurl+')':''"  :title="projectName?projectName:''">
	</li>`
})



