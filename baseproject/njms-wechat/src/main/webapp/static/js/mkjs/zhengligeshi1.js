$(function zhengli() {
	$(".header .nav-top li").eq(1).addClass("active");
	let outerWidth = $(".container-from").width();
	let divWidth = $(".container-from .container-from-t").width();
	let margin = (outerWidth - divWidth * 4) / 3;
	$(".container-from .container-from-t").css({
		"marginTop": margin,
		"marginLeft": margin
	})
	$(".container-from .container-from-t").first().css("marginLeft", 0)
	$(".container-from .container-from-t").show(function() {
		let index = $(this).index();
		if(index < 4) {
			$(this).css("marginTop", 0)
		} else if(index === 3 || index % 4 === 0) {
			$(this).css("marginLeft", 0)
		}
	})
});