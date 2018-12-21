//小轮播
Vue.component("newslunbo",{ 
 props:["imglist","path"],//freebroadcast，getPath()
 template:`
 <div class="xiaolunbo">
	 <ul class="xiaolunbolist">
		 <li v-for="item in imglist" :style="item.picturePath?'background-image:url('+path+item.picturePath+');':''"></li>
	 </ul>
	 <div class="rotateBtn btnNext"></div>
	 <div class="rotateBtn btnPrev"></div>
</div>
` })