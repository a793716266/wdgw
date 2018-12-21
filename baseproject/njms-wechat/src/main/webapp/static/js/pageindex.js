$(function() {
	// 动态设置轮播图宽度
	$(".lunbo .lunbolist li").width($(document).width());
	$(".lunbo .lunbolist li").height($(document).width()/3.3);
	$(".section .container .section-module .module-detail").hover(function() {
		$(this).find(".hide").fadeIn(100);
	}, function() {
		$(this).find(".hide").fadeOut(100);
	});
	// 小轮播
	
setTimeout(function() {
	var xiaolunSwiper = new Swiper("#xiaolun",{
		slidesPerView: 1,
		loop: true,
		autoplay: {
			delay: 3000,
			stopOnLastSlide: false,
			disableOnInteraction: true,
			disableOnInteraction: false
		},
		navigation: {
			nextEl: '.btnNext',
			prevEl: '.btnPrev',
		},
});
$(".xiaolunbolist").on("mouseenter",function(){
xiaolunSwiper.autoplay.stop();
});
$(".xiaolunbolist").on("mouseleave", function () {
xiaolunSwiper.autoplay.start();
});
},1);
	// 免费课程学员感想轮播
	(function(){
		let dist1 = 0;
		let dist2 = 0;
		let dist3 = 0;
		let canmove1 = true;
		let canmove2 = true;
		let canmove3 = true;
		setInterval(()=>{
			if(isFocus){
				if(canmove1){
					if(--dist1>=-118){
						$(".rate-content-container").first().find(".rate-content").first().css("margin-top", dist1);
					}else{
						dist1 = 0;
						$(".rate-content-container").first().find(".rate-content").first().css("margin-top", 0);
						let xxx = $(".rate-content-container").first().find(".rate-content").first();
						$(".rate-content-container").first().find(".rate-content").first().remove().appendTo($(".rate-content-container").first())
					}
				}
				
				if(canmove2){
					if(--dist2>=-118){
						$(".rate-content-container").eq(1).find(".rate-content").first().css("margin-top", dist2);
					}else{
						dist2 = 0;
						$(".rate-content-container").eq(1).find(".rate-content").first().css("margin-top", 0);
						$(".rate-content-container").eq(1).find(".rate-content").first().appendTo($(".rate-content-container").eq(1))
					}
				}
				
				if(canmove3){
					if(--dist3>=-118){
						$(".rate-content-container").eq(2).find(".rate-content").first().css("margin-top", dist3);
					}else{
						dist3 = 0;
						$(".rate-content-container").eq(2).find(".rate-content").first().css("margin-top", 0);
						$(".rate-content-container").eq(2).find(".rate-content").first().appendTo($(".rate-content-container").eq(2))
					}
				}
			}
		},25);
		
		$(".rate-content-container").first().hover(()=>{
			canmove1 = false;
		},()=>{
			canmove1 = true;
		});
		
		$(".rate-content-container").eq(1).hover(()=>{
			canmove2 = false;
		},()=>{
			canmove2 = true;
		});
		
		$(".rate-content-container").eq(2).hover(()=>{
			canmove3 = false;
		},()=>{
			canmove3 = true;
		});
	})();
	// 项目展示部分单击切换样式
	$(".section .container .section-module .nav-project li").mouseover(function() {
		$(this).addClass("active").siblings().removeClass("active");
	});
	$(".module-detail").on("click",".shade",function(e){
	  var Y = $(window).scrollTop();
	  $(".fixed").hide();
	 $("#video-btn").css({"display":"block","top":Y+"px"});
	 $("#shadow").css({"display":"block","top":Y+"px"});
	 $("body").parent().css("overflow-y","hidden");
	 let videoUrl = $(this).data("url");
	 $("#video-area").html("<iframe src='"+videoUrl+"' scrolling='no' border='0' frameborder='no' framespacing='0' allowfullscreen='true'> </iframe>");
	})
   
    $(".video-shut").on("click",function(){
      $("#video-btn").css("display","none");
      $("body").parent().css("overflow-y","auto");
 	 $("#shadow").css("display","none");
 	 $("#video-area").html("");
	  $(".fixed").show();
    })
});