var hoverLI,pictrues,pictrueslink,checkposthostlength,pictureContent,setAutoplayInterval,clickLI,lastLI,changeOpacityTime,isok,opentransition,closetransition,AnimatedOn;
clickLI=0;
pictures=[];
pictrueslink=[];
pictureContent=[];
opentransition=true;
closetransition=false;
 
function isrun(){
	if(AnimatedOn==1){
		isok=opentransition;
	}else{
		isok=closetransition;
	}
	autoPlay();
	Hover();
	autoPlayClick();
	changeOpacity(isok);
	$("#autoplay").css("background","url("+pictures[0]+")no-repeat");
	$("#autoplay").css("background-size","cover");
	$("#pictureCxt").text(pictureContent[0]);
	 
}
function Hover(){
	hoverLI=0;
	$("#headPlay_UL").on("hover","li",function(){
		clearInterval(setAutoplayInterval);
		clearInterval(changeOpacityTime);
			hoverLI=$(this).index();
			$("#headPlay_UL li:eq("+hoverLI+")").css("color","red");
			 
	});
	$("#headPlay_UL").on("mouseout","li",function(){
		if(lastLI!=hoverLI){
			$("#headPlay_UL li:eq("+(hoverLI)+")").css("color","white");
		}
			 
	});
	$("#autoplay").hover(function(){
		clearInterval(setAutoplayInterval);
		clearInterval(changeOpacityTime);
	},function(){
			if(checkposthostlength>1){autoPlay(); changeOpacity(isok);}
	});
}
 
function autoPlayClick(){
	$("#headPlay_UL li:eq("+clickLI+")").css("color","red");
	
	lastLI=clickLI;
	$("#headPlay_UL").on("click","li",function(){
		
		$("#headPlay_UL li:eq("+(lastLI)+")").css("color","white");
		clickLI=$(this).index();
		$("#headPlay_UL li:eq("+clickLI+")").css("color","red");
		lastLI=clickLI;
		$("#autoplay").css("background","url("+pictures[clickLI]+")no-repeat");
		$("#autoplay").css("background-size","cover");
		$("#pictureCxt").text(pictureContent[clickLI]);
		
	});
	$("#autoplay").click(function(){
		window.open(pictrueslink[clickLI])
	});
	
}

function changeOpacity(isok){
	if(isok){
		changeOpacityTime=setInterval(function(){
		 	 $("#autoplay").css("opacity","0.1")
	 	  	setTimeout(function(){
				$("#autoplay").css("opacity","1")
			},1000)
	 },3000);
	}
}

function autoPlay(){
	
	 setAutoplayInterval=setInterval(function(){
	 	 clearInterval(changeOpacityTime)
	 	 clickLI=clickLI>=pictures.length-1?0:clickLI+1;
	 	 $("#headPlay_UL>li").get(clickLI).click();
	 	 changeOpacity(isok);
	 
	 },4000);
}
