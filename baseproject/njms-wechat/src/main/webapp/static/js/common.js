var isFocus = true;
$(window).focus(function(){
	isFocus = true;
}).blur(function(){
	isFocus = false;
})
//顶部导航栏悬浮效果(激活active,改变li背景色和下边框)
$(function() {
	$(".header .container .header-bottom .nav-top li").click(function() {
		$(this).addClass("active").siblings().removeClass("active");
	});
	$(document).scroll(function(){
		if($(this).scrollTop() > window.screen.height)
			$(".fixed .top").fadeIn(200);
		else
			$(".fixed .top").fadeOut(200);
		
	});
	
	//回到顶部
	$(".fixed .top").click(function() {
		let scrolltop = $(document).scrollTop();
		let dist = scrolltop / 25;
		let timer = setInterval(function() {
			scrolltop -= dist;
			if(scrolltop <= 0) {
				scrolltop = 0;
				clearInterval(timer)
			}
			$(document).scrollTop(scrolltop);
		}, 10);
	});

	//为功能按钮组动态定位
	fixedPosition();
	//由于功能按钮组是fix定位，浏览器大小改变时需要重新定位
	$(window).resize(function() {
		fixedPosition();
		$(".lunbo .lunbolist li").width($(document).width());
		$(".lunbo .lunbolist li").width($(document).width()/3.3);
	})
	//功能按钮组动态定位方法
	function fixedPosition() {
		if($(".container").offset()){
			$(".fixed").css("left", $(".container").offset().left + $(".container").width() + 90);
		}
	}
});
//控制边距方法(实现space-between+左对齐，可能会出现误差)
function controlMargin(selector, countinline) {
	let outerWidth = $(selector).width();
	let divWidth = $(selector + " li").width()+2;
	let margin = (outerWidth - divWidth * countinline) / (countinline - 1);
	$(selector + " li").css({
		"marginTop": margin,
		"marginLeft": margin
	})
	$(selector + " li").first().css("marginLeft", 0)
	$(selector + " li").show(function() {
		let index = $(this).index();
		if(index < countinline) {
			$(this).css("marginTop", 0)
		} else if(index === (countinline - 1) || index % (countinline) === 0) {
			$(this).css("marginLeft", 0)
		}
	})
}
/*
 * ajax get请求
 * 参数url:链接地址
 * 参数attr:vm中的属性名，单个属性用字符串，多个属性用数组
 * 原则：Controller中返回的json必须为对象，最简单的方式是将list用Map包起来，key为vm的属性名，必须相同
 */
function getData(obj){
	$.ajax({
		url:obj.url,
		type:"get",
		dataType:"json",
		data:obj.data,
		success:function(data){
			//赋值操作
			assign(obj.attr,data)
			//回调
			if(obj.callback){
				obj.callback(data);
			}
		},
		error:obj.error
	})
}
//为vm中的属性赋值
function assign(attr,data){
	//若参数为字符串
	if(typeof(attr) === "string"){
		vm[attr] = data[attr];
	//若参数为数组
	}else if(typeof(attr) ==="object"){
		for(let item of attr){
			vm[item] = data[item];
		}
	}
}
//控制图片按原尺寸缩放并居中
function controlSize(img,widthM,heightM) {
	let _width = img.width;
	let _height = img.height;
	let pWidth = img.parentNode.offsetWidth;
	let pHeight = img.parentNode.offsetHeight;
	let selfWidth = widthM?(pWidth - widthM):pWidth;
	let selfHeight = heightM?(pHeight - heightM):pHeight;
	if (_width > _height * selfWidth / selfHeight) {
		img.style.width = selfWidth + "px";
		img.style.height = "auto";
	} else {
		img.style.width = "auto";
		img.style.height = selfHeight + "px";
	}
	let pHeightHalf = pHeight / 2
	let pWidthHalf = pWidth / 2
	let widthHalf = img.width / 2
	let heightHalf = img.height / 2
	
	img.style.marginTop = (pHeightHalf - heightHalf)+"px"
	img.style.marginLeft = (pWidthHalf - widthHalf)+"px"
}

//获取项目路径
function getPath(){
	let path = window.location.href
	let pathName = window.location.pathname
	let pos = path.indexOf(pathName)
	return path.substring(0,pos)
}

