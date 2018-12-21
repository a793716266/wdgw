$(function zhengli() {
	$(".header .nav-top li").eq(1).addClass("active").siblings().removeClass("active");
	let outerWidth = $(".central-section-from-central").width();
	let divWidth = $(".central-section-from-central .container-from-t").width();
	let margin = (outerWidth - divWidth * 4) / 3;
	$(".central-section-from-central .container-from-t").css({
		"marginTop": margin,
		"marginLeft": margin
	})
	$(".central-section-from-central .container-from-t").first().css("marginLeft", 0)
	$(".central-section-from-central .container-from-t").show(function() {
		let index = $(this).index();
		if(index < 4) {
			$(this).css("marginTop", 0)
		} else if(index === 3 || index % 4 === 0) {
			$(this).css("marginLeft", 0)
		}
	})
});