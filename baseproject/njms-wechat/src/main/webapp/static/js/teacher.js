$(function() {
	$(".header .nav-top li").eq(2).addClass("active").siblings().removeClass("active");
	controlMargin(".jiangshilist",3);
	$(".teacher-tab-item").mouseover(function() {
		$(this).addClass("active").siblings().removeClass("active");
		if($(this).is(".teacher-tab-jiangshi")) {
			$(".jiangshilist").show();
			$(".banzhurenlist").hide();
			controlMargin(".jiangshilist",3);
		} else {
			$(".jiangshilist").hide();
			$(".banzhurenlist").show();
			controlMargin(".banzhurenlist",3);
		}
	});
	for (let i = 0;i<$(".teacher-tab.up>.teacher-tab-item").length;i++) {
		$($(".teacher-tab.up>.teacher-tab-item")[i]).css("left",260*i)
	}
	$(".teacher-tab>.teacher-tab-item").mouseover(function(){
		let _index = $(this).index()
		$(".teacher-tab.up").stop()
		$(".teacher-tab.up").animate({
			"left":_index*260
		},200)
		for (let i = 0;i<$(".teacher-tab.up>.teacher-tab-item").length;i++) {
			$($(".teacher-tab.up>.teacher-tab-item")[i]).stop()
			$($(".teacher-tab.up>.teacher-tab-item")[i]).animate({
				"left":260*(i-_index)
			},200)
		}
	})
})