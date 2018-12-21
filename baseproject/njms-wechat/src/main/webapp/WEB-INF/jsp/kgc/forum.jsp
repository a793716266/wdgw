<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common-header.jsp"%>
		<div class="forum">
			<!-- 第一部分 -->
			<div class="part1">
				
				<div class="p1_left" id="autoplay"  style="transition: opacity 1s;">
					<div class="back"></div>
					<p class="test" id="pictureCxt">加载中</p>
				</div>
				<div id="headPlay_UL_Move">	
						<ul id="headPlay_UL" >
						 
					    </ul>
					</div>
				<div class="p1_right" id="hotpicsrc" style="cursor: pointer;">
					<div class="back"></div>
					<div class="test">
						<div class="hot">
							热门话题
						</div>
						<div class="title" id="hottopic">
							加载中
						</div>
					</div>
				</div>  
			</div>
			<!-- 第二部分 -->
			<div class="part2">
				<div class="p2_left">
					<!-- 学习类 -->
					<posttypeitem v-for="item in postTypeStudyList"
						:posttype="item"
					></posttypeitem>
				</div>
					
				<div class="p2_right">
					<!-- 生活类 -->
					<posttypeitem v-for="item in postTypeLifeList"
						:posttype="item"
					></posttypeitem>
				</div>
			</div>
			<!-- 第三部分 -->
			<div class="part3">
				<div class="p3_left">
					<div class="part3_tit">
						<div class="titText">
							热门话题
						</div>
					</div>
					<posting v-for="(item,i) in postHotList"
						:post_id="item.post_id?item.post_id:'0'"
						:userid="item.userid?item.userid:'0'"
						:name="item.name?item.name:'0'"
						:title="item.title?item.title:'加载中'"
						:replycard="item.replycard?item.replycard:'0'"
						:content="item.content?item.content:'加载中'"
						:nickname="item.nickname?item.nickname:'加载中'"
						:viewnumber="item.viewnumber?item.viewnumber:'0'"
						:tf="item.timeDiff?item.timeDiff:'加载中'"
					></posting>
				</div>
				
				<div class="p3_right">
					<div class="part3_tit">
						<div class="titText">
							精华回复
						</div>
					</div>
					
					 <replypost v-for="(item,i) in checkhostrep"
					 	:postid="item.postId?item.postId:'加载中'"
					 	:userid="item.userId?item.userId:'加载中'"
					 	:commencontent="item.commenContent?item.commenContent:'加载中'"
					 	:nickname="item.nickname?item.nickname:'加载中'"
					 	:picture="item.picture?item.picture:'加载中'"
					 >
					 	
					 </replypost>
					
				</div>
				
				<div class="p3_right_bt">
					<div class="part3_tit">
						<div class="titText">
							活跃达人
						</div>
					</div>
					<div class="ranking">
						 <activeman v-for="item in Activeman"
							:username="item.username?item.username:'加载中'"
							:postcount="item.postcount?item.postcount:'加载中'"
							:userpicture="item.userpicture?item.userpicture:'加载中'"
							:count="item.count?item.count:'加载中'"
							></activeman>
				 
					</div>
				</div>
				
			</div>
		</div>
		<%@include file="../common/common-footer.jsp"%>
		<script src="<%=basePath%>static/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/lunbo.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/pageindex.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/vue.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/header.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/footer.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/clzitem.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/jobitem.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/stuitem.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/rateitem.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/courseitem.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/teacheritem.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/posttypeitem.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/posting.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/activeman.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/wyplay.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/replypost.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		function clk(link){
			$("#hotpicsrc").click(function(){
				window.open(link);
			})
		}
		
		$(function() {
			//获取论坛的学习/生活类型
		   
			getData({
				url : "wd/postStudyList.do",
				attr : "postTypeStudyList",
				
			})
			getData({
				url : "wd/postLifeList.do",
				attr : "postTypeLifeList",
			})
			
			//获取热门话题
			getData({
				url : "wd/postHotList.do",
				attr : "postHotList",
				callback:function(data){
				/* 	$.each(data.postHotList,function(index,value){
						alert(value.timeDiff);
					}) */
				 
					console.log(data)
						
				}
			})
			
			getData({
				url : "wd/checkposthost.do",
				attr : "checkposthost",
				callback:function(data){
					AnimatedOn=data.checkposthost[0].istrue;
					checkposthostlength=data.checkposthost.length;
					$("#hotpicsrc").css("background","url("+data.hottopic[0].picsrc+")no-repeat");
					$("#hotpicsrc").css("background-size","cover");
					$("#hottopic").text(data.hottopic[0].title);
					clk(data.hottopic[0].posturl);
				 	var ul=$("#headPlay_UL")
					var li=""; 
						for (var i = 0; i < checkposthostlength; i++) {
							if(checkposthostlength<=1){
								clearInterval(setAutoplayInterval);
								clearInterval(changeOpacityTime);
							}else{
								li="<li>.</li>"
								ul.append(li);
							}
							
							pictures.push(data.checkposthost[i].picsrc);
							pictureContent.push(data.checkposthost[i].title);
							pictrueslink.push(data.checkposthost[i].posturl);
						
						}
						 
					 	
						isrun();
					 
				}
			})
			//获取活跃达人
			getData({
				url : "wd/postActiveman.do",
				attr : "Activeman",
				callback:function(data){
					console.log(data)
				 
					//data.postActiveman[0].username
						
				}
			})
			 //获取热门回复
			getData({
				url : "wd/checkpostrep.do",
				attr : "checkhostrep",
				callback:function(data){
						
				}
			})
		});
		</script>
	</body>
</html>
