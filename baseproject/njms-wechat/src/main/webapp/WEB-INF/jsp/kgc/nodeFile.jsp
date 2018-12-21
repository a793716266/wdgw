<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page isELIgnored="false" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<%=basePath%>static/js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<style type="text/css">
		*{
			padding: 0;
			margin: 0;
		}
		/* 左侧 */
		.type-container{
			width: 140px;
			border-right:1px solid silver;
			border-bottom: 1px solid silver;
			text-align: center;
			
		}
		
		/* 左侧内容 */
		.type-user{
			/* transform: translateY(); */
			padding-top: 15px;
		}
		
		/* 左侧用户头像 */
		.type-user-icon{
			
		}
		
		/* 左侧用户名 */
		.type-user-name{
			font-size: 14px;
			color: #434343;
			margin-top: 10px;
		}
		
		/* 右侧 */
		.type-info-detail{
			width: 1000px;
			border-bottom: 1px solid silver;
			color: #A2A2A2;
			padding: 20px 30px;
			font-size: 14px;
		}
		
		/* 右侧内容 */
		.type-info-detail-text{
			 padding-bottom: 124px; 
		}
		
		/* 右侧回复盒子 */
		.type-info-detail-info-you{
			
		}
		
		/* 右侧回复子盒子 */
		.type-info-detail-info-txt{
			display: flex;
			flex-direction: row;
			text-align: right;
			float: right;
			clear: both;
			font-size: 10px;
		}
		
		/* 回复楼层 */
		.type-info-detail-info-floor{
			margin-right: 10px;
		}
		
		/* 回复时间 */
		.type-info-detail-info-titleTime{
			margin-right: 10px;
		}
		
		/* 回复按钮 */
		.type-info-detail-info-talk>a{
			font-size: 12px;
			text-decoration: none;
			color: #00A0E9;
		}
		
		/* 展开回复 */
		.talkChildren{
			border: 1px black solid;
			margin-top:10px;
			float: right;
			clear: both;
			/* 释放 */ display: none; 
		}
		
		.talkChildren>div{
			display: flex;
			flex-direction: row;
		}
		
		.talkChildren_reply{
			text-align: right;
		}
		
		.talkChildren>img{
			
		}
	</style>
</head>
<body>

  <div id="app" >
  <table>
	<replypost v-for="(item,i) in replypostlist"
						:postid="item.postid?item.postid:'0'"
						:pictrue="item.userpictrue?item.userpictrue:'0'"
						:userid="item.userid?item.userid:'0'"
						:commencontent="item.commencontent?item.commencontent:'加载中'"
						:commentfloor="item.commentfloor?item.commentfloor:'0'"
						:commenttime="item.commenttime?item.commenttime:'加载中'"
						:usernickname="item.usernickname?item.usernickname:'加载中'"
						:replyfloormath="item.replyfloormath?item.replyfloormath:'加载中'"
						
					id="tab"></replypost></table>
	<div id="Nodata" style="display: none;">还没有回复哦来抢一楼</div>
					
					
					</div>
					
</body>
<script src="<%=basePath%>static/js/common.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript" charset="utf-8"></script>



<script src="<%=basePath%>static/components/replypost.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">  

	$(function(){
		
		var postid="${postid}";
		var pagenow="${pagenow}";
		var pagesize="${pagesize}";
		var size="${size}";
		var replierid="${replierid}";
	 
		if(size==0){
			$("#Nodata").css("display","block");	 
		}else{
			 $("#Nodata").css("display","none") 
		}
		getData({
			url : "getReplyPost.do?post_id="+postid+"&pagenow="+pagenow+"&pagesize="+pagesize+"&replierid="+replierid+"&level="+0,
			attr : "replypostlist",
			callback:function(data){
				
			}
		}); 
	   
	    
		
		//$(window.parent.document).find("#audio").attr("src","music/"+songname+".mp3");
	
	
	});
	/* parent.document.getElementById("two").height=0;
	parent.document.getElementById("two").height=document.body.scrollHeight; */
	setTimeout(function(){
		var height=$("#app").height();
		var fatherheight=""+height+"px"
	  
	    $(window.parent.document).find("#ifm").css("height",fatherheight);
		//window.parent.document.getElement('#div').style.height = zzz;
	},200)
	
</script>
 
</html>