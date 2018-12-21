//小轮播
Vue.component("xiaolunbo",{ 
 props:["imglist","path"],//freebroadcast，getPath()
 template:`
 <div class="xiaolunbo swiper-container" id="xiaolun">
	 <ul class="xiaolunbolist swiper-wrapper">
		 <li class="xiaolunbo-item swiper-slide" v-for="item in imglist" :style="item.picturePath?'background-image:url('+path+item.picturePath+');':''"></li>
	 </ul>
	
</div>
` })