$(function() {
	$(".xiaolunbo").hover(function() {
		$(".rotateBtn").fadeIn(100);
	}, function() {
		$(".rotateBtn").fadeOut(100);
	});
	$(".xiaolunbolist").rotatePlay({
		direction: "x",
		loop: true
	});
})