$(function() {
	$(".header .nav-top li").eq(3).addClass("active").siblings().removeClass("active");
	controlMargin(".stulist", 4);
	$(".student-tab .teacher-tab-item").mouseover(function() {
		$(this).addClass("active").siblings().removeClass("active");
		if($(this).is(".student-tab-java")) {
			$(".stulist-java").show();
			$(".stulist-web").hide();
			$(".stulist-ui").hide();
			controlMargin(".stulist-java", 4);
		} else if($(this).is(".student-tab-web")){
			$(".stulist-java").hide();
			$(".stulist-web").show();
			$(".stulist-ui").hide();
			controlMargin(".stulist-web", 4);
		}else{
			$(".stulist-java").hide();
			$(".stulist-web").hide();
			$(".stulist-ui").show();
			controlMargin(".stulist-ui", 4);
		}
	});
	for (let i = 0;i<$(".teacher-tab.up>.teacher-tab-item").length;i++) {
		$($(".teacher-tab.up>.teacher-tab-item")[i]).css("left",220*i)
	}
	$(".teacher-tab>.teacher-tab-item").mouseover(function(){
		let _index = $(this).index()
		$(".teacher-tab.up").stop()
		$(".teacher-tab.up").animate({
			"left":_index*220
		},200)
		for (let i = 0;i<$(".teacher-tab.up>.teacher-tab-item").length;i++) {
			$($(".teacher-tab.up>.teacher-tab-item")[i]).stop()
			$($(".teacher-tab.up>.teacher-tab-item")[i]).animate({
				"left":220*(i-_index)
			},200)
		}
	})
})