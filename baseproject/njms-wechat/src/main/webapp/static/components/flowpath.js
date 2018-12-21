Vue.component("flowpath",{
	props:["direction","titleimage","textdescribe","detailsurl"],
	template:`
       <li class="pro1" :style="titleimage?'background-image: url('+titleimage+');':''">
			<div :class="'arrow '+direction" ></div>
			<div class="process-name font-md">{{textdescribe}}</div>
			<div class="btn-know"><a :href="detailsurl"></a>了解详情</div>
		</li>
	`
})