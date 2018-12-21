$(function() {
			var myVideo = document.getElementById("myVideo");
			var timeoutID= null;  /*解决单机和双击事件作用同一元素的问题*/
			videoplay(myVideo);
			$("#myVideo").click(function() {
				clearTimeout(timeoutID);
				 timeoutID= window.setTimeout(function(){
					switchVideo(myVideo); //video 被点击时切换播放状态
				},200);
			});
			/* 音频播放当前时间  和  总时间 */
			$(myVideo).on('loadedmetadata', function() {
				$('.duration').html(conversionFormat(myVideo.duration));
			});

			$(myVideo).on('timeupdate', function() {
				$('.current').html(conversionFormat(myVideo.currentTime));
			});
			$(".videoplayer span").css("color","#A8A5A5");
			var conversionFormat = function(time){
				timeLength = parseInt(time);
		        var second = timeLength%60;
		        var minute = (timeLength-second)/60;
		        return (minute<10?"0"+minute:minute)+":"+(second<10?"0"+second:second);
            }
			
			//Mute/Unmute control clicked
			$('.muted').click(function() {
			   myVideo.muted = !myVideo.muted;
			   if(myVideo.muted){
			   	 $(".container .videoplayer .controls .muted").addClass("mutedUnmuted");
			   }else{
			   	 $(".container .videoplayer .controls .muted").removeClass("mutedUnmuted");
			   }
			   return false;
			});
			 
			var isDown = false;
			$('.volume').mousedown(function() {
				isDown = true;
			});
			$(".volumeBar").mousemove(function(e) {
				if(isDown){
					var volume = $(".volume");
					var vo = (e.pageX - volume.offset().left);
					var lume = (volume.offset().left) - $(".volumeBar").offset().left;
					var volumeSize = vo + lume;
					if(volumeSize>=100){
						volume.css("left","100px");
						myVideo.volume = 1;	
						$(".container .videoplayer .controls .muted").removeClass("mutedUnmuted");
						return false;
					}
					volumeSize = volumeSize<=0.5?0:volumeSize;
					volume.css("left",volumeSize+"px");
					myVideo.volume = volumeSize / 100;
					if(!myVideo.volume){ //音量为0时
			   		 $(".container .videoplayer .controls .muted").addClass("mutedUnmuted");
					}
					if(myVideo.volume){ //音量大于0时
			   		 $(".container .videoplayer .controls .muted").removeClass("mutedUnmuted");
					}
				}
			});
			$("body").mouseup(function() {
				isDown = false;
			});
			
			
			
			
			/*大video悬浮显示与隐藏播放按钮*/
			$(".container .videoplayer").hover(function(){
				$(".container .videoplayer .play").stop(false,true).fadeIn("slow");
				$(".container .videoplayer .videotitle").stop(false,true).fadeIn("slow");
				$(".container .videoplayer .controls").stop(false,true).fadeIn("slow");
			},function(){
				$(".container .videoplayer .play").stop(false,true).fadeOut()
				$(".container .videoplayer .videotitle").stop(false,true).fadeOut()
				$(".container .videoplayer .controls").stop(false,true).fadeOut()
			});
			/*推荐课程悬浮显示与隐藏播放按钮*/
			$(".container .recommend .part2 .course").hover(function(){
				$(this).find(".play").stop(false,true).fadeIn("slow");
			},function(){
				$(this).find(".play").stop(false,true).fadeOut()
			})
			/*点赞*/
			$(".container .videoplayer .menu").toggle(function(){
				$(this).find(".good").css("background-image","url("+getPath()+"/static/img/videoplay/zan3.png)")
				let zancount = parseInt($(this).find(".zancount").val())+1;
				$(this).find(".zancount").val(zancount);
			},function(){
				$(this).find(".good").css("background-image","url("+getPath()+"/static/img/videoplay/zan2.png)");
				let zancount = parseInt($(this).find(".zancount").val())-1;
				$(this).find(".zancount").val(zancount);
			})
			/*推荐课程的播放按钮被点击时*/
			$(".container .recommend .part2 li .course .play").click(function(){
				var vsrc = $(this).data("src"); //获取src路径
				var title = $(this).prev().attr("title"); //获取src路径
				$(myVideo).attr("src",vsrc);  //赋给大video
				$(".videoPlayback .videotitle").html(title);  //赋给大video
				$(".container .videoplayer .play").css("background-position-x", "-90px");
				myVideo.play();//播放
				myVideo.onload = function(){
					console.log($(".top_area .top-header .title").text())
				}
			})
			function videoplay(myVideo) {
				$(".container .videoplayer .play").click(function() {
					switchVideo(myVideo);//播放按钮 被点击时切换播放状态
				});
				myVideo.onended = function() {
					$(".container .videoplayer .play").css("background-position-x", "0px");
				};
			};

			function switchVideo(myVideo) {
				if(myVideo.paused) {
					$(".container .videoplayer .play").css("background-position-x", "-90px");
					myVideo.play(); //播放
				} else {
					$(".container .videoplayer .play").css("background-position-x", "0px");
					myVideo.pause(); //暫停
				}
			}
			
			
			//<!-- 音频播放进度条 -->
			//update HTML5 video current play time
			$(myVideo).on('timeupdate', function() {
				var currentPos = myVideo.currentTime; //Get currenttime
				var maxduration = myVideo.duration; //Get video duration
				var percentage = 100 * currentPos / maxduration; //in %
				$('.timeBar').css('width', percentage + '%');
			});
			var timeDrag = false; /* Drag status */
			$('.progressBar').mousedown(function(e) {
				timeDrag = true;
				updatebar(e.pageX);
			});
			$(document).mouseup(function(e) {
				if(timeDrag) {
					timeDrag = false;
					updatebar(e.pageX);
				}
			});
			$(document).mousemove(function(e) {
				if(timeDrag) {
					updatebar(e.pageX);
				}
			});
			//update Progress Bar control
			var updatebar = function(x) {
				var progress = $('.progressBar');
				var maxduration = myVideo.duration; //Video duraiton
				var position = x - progress.offset().left; //Click pos
				var percentage = 100 * position / progress.width();
				//Check within range
				if(percentage > 100) {
					percentage = 100;
				}
				if(percentage < 0) {
					percentage = 0;
				}

				//Update progress bar and video currenttime
				$('.timeBar').css('width', percentage + '%');
				myVideo.currentTime = maxduration * percentage / 100;
			};
			/*视频全屏 */
			$("#myVideo").dblclick(function(){
				 clearTimeout(timeoutID);
				 full();
			})
			$(".full").click(function(){
				 full();
			})
			function full() {
				myVideo.webkitEnterFullscreen();

				myVideo.mozRequestFullScreen();

				return false;
			};
		})