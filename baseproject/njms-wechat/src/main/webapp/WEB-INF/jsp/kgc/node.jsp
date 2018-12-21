<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title>首页 - 课工场|文鼎校区</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/header.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/footer.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/section-common.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/section-top.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/lunbo.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-clz.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-stu.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-rate.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-course.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-free.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-project.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-biz.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-job.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-teacher.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-news.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index/section-module-schoolAndCompany.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/teacher/nav-teacher.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/teacher/teacher.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/student/student.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/ProcessPage/ProcessPage.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/kgcmk-css/mk-top.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/kgcmk-css/Modular.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/kgcmk-css/uldemo.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/swiper.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/luntanPage/luntantype.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/luntanPage/forum.css" />
		<script src="<%=basePath%>static/js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/pageindex.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		
		<link rel="stylesheet" href="static/layui/css/layui.css"  media="all">
		<script src="static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		
	</head>

		<style type="text/css">
		*{
			padding: 0;
			margin: 0;
			word-wrap:break-word;
		}
		/* 头部标题 */
		.top-link {
			height: 50px;
			line-height: 50px;
		}
		
		.top-link * {
			margin-left: 5px;
		}
		
		.top-link>.a-default:nth-of-type(1) {
			margin-left: 0px;
		}
		
		.type-title {
			background-color: #fff;
			float: left;
		}
		
		.type-title .type-info {
			border-bottom: 1px silver solid;
		}
		/*用户*/
		
		
		.type-info{
			background: white;
			
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
			padding: 20px 30px;
		}
		
		/* 右侧内容 */
		.type-info-detail-text{
			color: #6E6E6E;
			font-size: 14px;
			padding-bottom: 124px; 
		}
		
		/* 右侧回复盒子 */
		.type-info-detail-info-you{
			flex-direction: row;
			text-align: right;
			height: 50px;
			line-height: 50px;
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
		
		/* 下载附件 */
		.type-info-detail-info-you .type-info-detail-info-donwload{
			width: 135px;
			height: 26px;
			line-height: 26px;
			display: inline-block;
			border:1px solid #00A0E9;
			margin-right: 20px;
			text-align: center;
		}
		
		
		/* 回复楼层 */
		.type-info-detail-info-floor{
			margin-right: 10px;
			color: #A2A2A2;
			font-size: 10px;
		}
		
		/* 回复时间 */
		.type-info-detail-info-titleTime{
			margin-right: 10px;
			color: #A2A2A2;
			font-size: 10px;
		}
		
		/* 回复按钮 */
		.type-info-detail-info-talk>a{
			font-size: 12px;
			text-decoration: none;
			
		}
		
		
		
		
		/*回复(快速发帖)*/
		.type-comment {
			height: 280px;
			margin-top: 100px;
		}
		.type-comment .type-comment-ad {
			width: 380px;
			height: 223px;
			float: left;
			margin-right: 20px;
		}
		.type-comment .type-comment-ue{
			float: left;
			width: 800px;
			height: 332px;
		}
		/*去除点击图片后出现的拉伸边框*/
		#edui1_imagescale{
			display:none !important;
		} 
		
		.type-comment-ue-btn{
			width: 150px;
			height: 46px;
			margin-top: 60px;
			background-color: #FF9515;
			cursor: pointer;
			display: inline-block;
			color: #fff;
			border-radius: 2px;
			text-align: center;
			line-height: 46px;
			transition: all 0.3s;
			font-size: 18px;
			float: right;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
		}
		
		.type-comment-ue-btn:hover {
			background-color: #FF6515;
		}
		
		/* 子集帖子回复 */
		.replyReturs{
			width:1002px;
			background:#F8F8F8;
			border:1px #CDCDCD solid;
		}
		
		.replyReturs hr:not(:last-of-type){
			margin-left: 20px;
			color:#CDCDCD;
		}
		
		.replyReturs hr:last-of-type{
			display:none;
		}
		
		
		
		/* 富文本框 */
		.edui-editor-iframeholder.edui-default{
			top: -50px;
		}
		.edui-editor-toolbarbox.edui-default{
			position: absolute;
			top: 170px;
			height:50px;
			border-top: 1px solid #A9A9A9;
		}
		.edui-editor-toolbarboxouter.edui-default{
			border-bottom: none !important;
			background: #fff !important;
			box-shadow: none !important;
			border-radius: 0px !important;
		}
		.edui-toolbar.edui-default{
			border: none;
			height: 60px;
			background-color: #fff !important;
		}
		.edui-default .edui-editor{
			border: none !important;
		}
		.edui-default .edui-toolbar{
			margin-top: 10px;
			display: flex;
			justify-content: flex-end;
		}
		.edui-splitbutton-body.edui-default{
			height: 36px;
		}
		.edui-editor-toolbarboxinner.edui-default{
			border: none;
			padding: 0px !important;
		}
		.edui-box.edui-splitbutton.edui-for-emotion.edui-default,.edui-box.edui-button.edui-for-simpleupload.edui-default{
			line-height: 36px;
		}
		.edui-splitbutton-body.edui-default{
			display: flex;
		}
		#edui3_body{
			display: flex;
		}
		 
		
	</style>

	<body>
		<div id="app">
			<!--头部-->
			<wdheader user="${sessionScope.userph}" ></wdheader>
			
			<div class="container" >
				<div class="top-link">
					<a class="a-default" href="wd/toIndex.do">首页</a>
					<span>&gt;</span>
					<a class="a-default" href="wd/forum.do">技术论坛</a>
					<span>&gt;</span>
					<!-- 类型 -->
					<a class="a-default" href="wd/luntanbytype.do?typeid=${posting.postType_id}">${posting.name}</a>
					<span>&gt;</span>
					帖子正文
				</div>
				<a  name="prime"></a>
				<div style="clear: both;"></div>
				
				<input type="hidden" id="user" name="user" value="${sessionScope.userph}"/>
				<input type="hidden" id="floorId" value="${pid }"/>
				<input type="hidden" id="floorUserId" value="${userid }"/>
				
					<table class="type-info" width="1200px" >
						<tr>
							<td class="type-container" valign="top" width="140px">
								<div class="type-user">
									<div class="type-user-icon"><img src="${requestPath}${posting.picture }" width="100px" height="100px" ></div>
									
									<div class="type-user-name">${posting.nickname}</div>
								</div>
							</td>
							<td class="type-info-detail" width="1000px">
								<div ><h1 class="type-info-detail-title" style="font-size: 20px;margin-bottom: 20px;width:980px;word-wrap:break-word;">${posting.title }</h1></div>
								<div class="type-info-detail-text" style='width:980px;word-wrap:break-word;'>${posting.content }</div>
								<!-- 附件/日期/贴子楼层 -->
								<div style="clear: both;"></div>
								<div class="type-info-detail-info" >
									<div class="type-info-detail-info-you">
										<%-- <div class="type-info-detail-info-donwload" ><a href="${posting.downloadAttachment}" download="#" style="color: #00A0E9;">↓下载附件：26M</a></div> --%>
										<div class="type-info-detail-info-txt">
											<div class="type-info-detail-info-floor">1楼</div>
											<div class="type-info-detail-info-titleTime">使用${posting.releaseCVersion}发布于：<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${posting.createTime}"/></div>
											<div class="type-info-detail-info-talk" ><span onclick='openReplyHtml($(this))' id="${posting.post_id}&${posting.userid}&1&${countPostReturns}" style='color: #00A0E9;cursor:pointer;font-size:12px;'>回复
											<c:if test="${countPostReturns != 0}">(${countPostReturns})</c:if><span></div>
										</div>
									</div>
								</div>
								<div style="clear: both;"></div>
								<!-- 没有内容，隐藏子回复，否则，相反 -->
								<c:if test="${postReturns != '[]' }">
									<div class="replyReturs" >
										<!-- 遍历子回复 -->
										<c:forEach items="${postReturns}" var="p">
											<div style="margin:20px;">
												<div style="display: flex;">
													
													<div>
														<img width="50" height="50" src="${requestPath}${p.rPicture}" style="margin-right: 10px"/>
													</div>
													
													<div >
														<span style='color: #00A0E9;cursor:pointer;'>
															${p.rNickname}<c:if test="${posting.userid == p.userId}">：</c:if>
														</span>
														
														<c:if test="${posting.userid != p.userId}">
															<span style='color: #6E6E6E;margin: 0 10px'>回复</span>
															<span style='color: #00A0E9;cursor:pointer;'>${p.nickname}：</span>
														</c:if>
														<span style='color: #6E6E6E;' >
															${p.commenContent}
														</span>
														
													</div>
												</div>
												<div style="color: #A2A2A2;font-size: 12px;margin-right: 15px;" align="right">
													${p.time}&nbsp;&nbsp;&nbsp;<span style="color: #A2A2A2;font-size: 12px;cursor:pointer;" id="${p.postId }&${p.replierid}&${p.commentFloor}&${countPostReturns}"  onclick='openReplyHtml($(this))'>回复</span>
												</div>
											</div>
											<hr/>
										
										</c:forEach> 
										
									<div>
								</c:if>
								
							</td>
						</tr>
					</table>
					<!-- 楼下回复，忽删 -->	
					
					<table class="type-info" style="width:1200px!important" id="replyFloorBottom"></table>
					
				<!-- 帖子分页 -->
 				<div id="page_type"></div>
 				
				<!--发帖-->
				<div class="type-comment">
					<div class="type-comment-ad"><img src="<%=basePath%>static/img/index/coursepic.png" width="380px" height="223px" /></div>
					<div class="type-comment-ue" >
						<!-- 加载编辑器的容器 -->
						<script id="container" name="commencontent" type="text/plain" ></script> 
						<button type="button" class="layui-btn" id="picbtn" style="transform: translate(500px,-60px);z-index: 99999;position: absolute;background: white;">
		  					<img height="40" width="40" src="static/img/node_picture.jpg"/>
		  					<span class='new-post-text'>插入图片</span>
						</button> 
						<div class="type-comment-ue-btn" style="transform: translateX(-50px) translateY(-20px);" id="${posting.post_id}&${posting.userid}&${countReply}" onclick="replypost($(this))">
						 回复
						</div>
					</div>
				</div>
			</div>
			
			<div style="clear: both;"></div>
			
		<wdfooter :list="footlist" :campusinfo="campusinfo" :path="getPath()"></wdfooter>
			<ul class="fixed" display="none">
				<li class="msg"></li>
				<li class="qa"></li>
				<li class="talk"></li>
				<li class="top"></li>
			</ul>
		</div>
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
		<script src="<%=basePath%>static/components/postingbyid.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/components/replypostfrom.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript" charset="utf-8"></script>
		<!-- 配置文件 -->
		<script type="text/javascript" src="<%=basePath%>static/UEditor/ueditor.config.js" charset="utf-8"></script>
		<!-- 编辑器源码文件 -->
		<script type="text/javascript" src="<%=basePath%>static/UEditor/ueditor.all.js" charset="utf-8"></script>
		<!-- 导入文件上传按钮 -->
		<script src="static/layui/layui.js"></script>
		<!-- 实例化编辑器 -->
		<script type="text/javascript">
		
		$.each($("div.type-info-detail-text"),function(){
			imgSizeBefo($(this),350,550);
		});
		
		function imgSizeBefo(imgObject,newHeight,newWidth){
			
			$.each(imgObject.find("img"),function(){
				var oldHeight = $(this).get(0).naturalWidth;
				var oldWidth = $(this).get(0).naturalHeight;
						
				if(oldHeight>newHeight){
					$(this).height(newHeight);
					$(this).attr("height",newHeight);
				}
				if(oldWidth>newWidth){
					$(this).width(newWidth);
					$(this).attr("width",newWidth);
				}
			})
		
		}  
		
		function imgSize(imgObject,newHeight,newWidth){
			
			$.each(imgObject.find("img"),function(){
				$(this).load(function(){
					var oldHeight = $(this).get(0).naturalWidth;
					var oldWidth = $(this).get(0).naturalHeight;
					
					if(oldHeight>newHeight){
						$(this).height(newHeight);
						$(this).attr("height",newHeight);
					}
					if(oldWidth>newWidth){
						$(this).width(newWidth);
						$(this).attr("width",newWidth);
					}
				})
				
			})
		
		}  
		
		var user = $("#user").val();
		var nickname,wd_users_id;
		//获取用户昵称和id
		if(user.length !=0 ){
			
			user = user.substring(1,user.length-1).split(','); 
			$.each(user,function(index,value){
				value = value.split(':')
				
				if(value[0].substring(1,value[0].length-1)=="nickname"){
					nickname = value[1].substring(1,value[1].length-1);
				}
				if(value[0].substring(1,value[0].length-1)=="wd_users_id"){
					wd_users_id = value[1].substring(1,value[1].length-1);
				}
			})
			
		}
		
		//富文本编辑器
		 var ue = UE.getEditor('container', {

			//这里可以选择自己需要的工具按钮名称
			//simpleupload单图上传   insertimage多图上传   emotion表情
			toolbars: [
				['emotion']
			],
			//focus时自动清空初始化时的内容
			autoClearinitialContent:true,
			//关闭字数统计
			wordCount: true,
			
			//关闭elementPath
			elementPathEnabled: false,
			//默认的编辑区域高度
			initialFrameHeight: 169,
			initialFrameWidth :800,
			autoHeightEnabled: false,
			autoFloatEnabled:false
			
		});
		
		setTimeout(function(){
	    	$("#edui3_button_body").append("<span class='new-post-text'>插入表情</span>");
	    	
	    /* 	$("#edui4_button_body").append("<span class='new-post-text'>插入表情</span>") */
	    },500) 
	    
	   
	    
	    //分页代码
		layui.use('laypage', function(){
		  var laypage = layui.laypage;
		
			laypage.render({
			    elem: 'page_type'
			    ,count:"${countReplys}"
			    ,first: '首页'
			    ,last: '尾页'
			    ,layout: ['prev', 'page', 'next', 'count',  'skip']
			    ,jump: function(obj){
			    	replyAjaxPage(obj.curr);
			    }
			});
	  
		});
		
		//子回复弹出框
		function openReplyHtml(thisObject){
			
			if(user.length ==0 ){
				 return layer.msg('请您登录后再回复！',{icon:5});
			}  
			var id = thisObject.attr("id").split("&");
			var postid = id[0];
			var userid = id[1];
			var commentfloor = id[2];
			var level = parseInt(id[3])+1;
			
			layer.open({
				  type: 1
				  ,title: ['帖子回复', 'font-size:18px;']
				  ,content:'<center><textarea  id="replyToAnswer" style="resize:none;padding:5px;margin-top:10px;" maxlength="255" name="" rows="9" cols="100"></textarea></center>'
				  ,area: ['800px', '300px']
				  ,btn: ['确定', '取消']
				  ,yes: function(index, layero){
					  var replyToAnswer = $("#replyToAnswer").val();
					  if(replyToAnswer.length==0){
						  return layer.msg('内容不能为空！',{icon:5});
					  }
					 $.ajax({
							url:"wd/addReplyPost.do",
				    		type:"post",
				    		contentType:"application/x-www-form-urlencoded;charset=utf-8",
				    		data:{postId:postid,userId:userid,commenContent:replyToAnswer,commentFloor:commentfloor,replierid:wd_users_id,level:level,createuser:nickname},
				    		dataType:"json",
				    		success:function(data){
				    			if(data.result==1){
									layer.msg('回帖成功');
									window.location.reload();
								}else{
									layer.msg('回帖失败');
								}
				    		}
						}); 
				    
				  }
				  ,btn2: function(index, layero){
				    //按钮【按钮二】的回调
				    
				    //return false 开启该代码可禁止点击该按钮关闭
				  }
				  ,cancel: function(){ 
				    //右上角关闭回调
				    
				    //return false 开启该代码可禁止点击该按钮关闭
				  }
				});
		}	
		
			//帖子回复分页
		  function replyAjaxPage(pageNo){
			var pid = $("#floorId").val();
			var userid = $("#floorUserId").val();
			$.ajax({
				url:"wd/toReplyPost.do",
	    		type:"post",
	    		contentType:"application/x-www-form-urlencoded;charset=utf-8",
	    		data:{pageNo:pageNo,postid:pid,userid:userid},
	    		dataType:"json",
	    		success:function(data){
	    			$("#replyFloorBottom").html("");
					var rPicture,rNickname,commenContent,commentFloor,createtime,userId,time,replyCount,count;
					
					$.each(data.replys,function(index,value){
						rPicture=value.rPicture;
						rNickname=value.rNickname;
						commenContent=value.commenContent;
						downloadAttachment=value.downloadAttachment;
						commentFloor=value.commentFloor;
						createtime=value.createtime;
						userId=value.userId;
						time = value.time;
						replyCount = value.replyCount==0?"":"("+value.replyCount+")";
						count = value.replyCount;
						
						var reply = $("<tr><td class='type-container' valign='top' style='width: 140px!important'><div class='type-user'><div class='type-user-icon'><img src='${requestPath}"+
								rPicture+"' width='100px' height='100px'></div><div class='type-user-name' id='user&"+
								userId+"'>"+
								rNickname+"</div></div></td><td class='type-info-detail' style='width:1000px!important'><div class='type-info-detail-text' style='width:980px;word-wrap:break-word;' >"+
								commenContent+"</div><div style='clear: both;'></div><div class='type-info-detail-info' ><div class='type-info-detail-info-you'><div class='type-info-detail-info-txt'><div class='type-info-detail-info-floor'>"+
								commentFloor+"楼</div><div class='type-info-detail-info-titleTime'>使用网页版发布于： "+
								time+"</div><div class='type-info-detail-info-talk'  ><span style='color: #00A0E9;cursor:pointer;font-size:12px;' id ='"+value.postId+"&"+value.replierid+"&"+commentFloor+"&"+count+ "' onclick='openReplyHtml($(this))'>回复"+
								replyCount+"<span></div></div></div></div><div style='clear: right;'></div>"+
								"<div class='replyReturs' style='width:1002px;background:#F8F8F8;border:1px #CDCDCD solid;display:none;'><div></td></tr>");
							
						if(value.postReturns!=""){
							$.each(value.postReturns,function(index,value){
								reply.find(".replyReturs").show();
								reply.find(".replyReturs").append(replyChildren(value,userId,count));
							});
						}
						
						$("#replyFloorBottom").append(reply);
					});
					
					 $.each($("div.type-info-detail-text"),function(){
						 imgSize($(this),350,550);
					}) 

	    		}
			})
		
		}  
			

		/* 帖子子回复页面 */
		function replyChildren(value,userid,count){
			
			var replyType = value.userId != userid ?"<span style='color: #00A0E9;cursor:pointer;'>"+
			value.rNickname+"</span><span style='color: #6E6E6E;margin: 0 10px'>回复</span><span style='color: #00A0E9;cursor:pointer;'>"+
			value.nickname+"：</span>":"<span style='color: #00A0E9;cursor:pointer;'>"+
			value.rNickname+"：</span>";
			
			return $("<div style='margin:20px;'><div style='display: flex;'><div><img width='50' height='50' src='${requestPath}"+
			value.rPicture+"' style='margin-right: 10px'/></div><div style='width:900px;word-wrap:break-word;'>"+
			replyType+"<span style='color: #6E6E6E;'>"+
			value.commenContent+"</span></div></div><div style='color: #A2A2A2;font-size: 12px;margin-right: 15px;' align='right'>"+
			value.time+"&nbsp;&nbsp;&nbsp;<span style='color: #A2A2A2;font-size: 12px;cursor:pointer;' id='"+value.postId+"&"+value.replierid+"&"+value.commentFloor+"&"+count
			+"' onclick='openReplyHtml($(this))'>回复</span></div></div><hr/>"); 
		
		}
		
		//帖子回复（待用忽删）
		/* function replyIsOpen(reply){
			var countReply = 0;
			if(countReply == 0){
				openReplyHtml();
			}else{
			
				if(reply.text()=="回复"){
					reply.css({"padding":"5px 10px 18px 10px","background":"#F8F8F8","border":"1px #CDCDCD solid","border-bottom":"0"});
					reply.text("收起回复");
					reply.parents("td").children("div:last").show();
				}else{
					reply.css({"background":"#fff","border":"0"});
					reply.text("回复");
					reply.parents("td").children("div:last").hide();
				}
			}
			
		} */
		
		/* UE.Editor.prototype.getActionUrl = function(add) {
		//这里很重要，很重要，很重要，要和配置中的imageActionName值一样
		if (add == 'uploadimage') {
	
			//这里调用后端我们写的图片上传接口
			return 'wd/file.do';
		}else{
			return 'wd/toReplyPost.do';
			//alert("图片接口异常");
		/* return this._bkGetActionUrl.call(this, action); */
			//}
		//}  */
      
		setTimeout("ueditor()", 500);
		function ueditor() {
			//返回富文本编辑的内容
			return UE.getEditor('container').getContent();
		}
		function ueClose(){
			return UE.getEditor('container').setContent("");
		}
		//父回复
	  	function replypost(thisObject){
	  	 
	  	 	var data=${not empty sessionScope.userph?sessionScope.userph:0};
 	  	 
		 	if(data==0){
			 	alert("请先登陆");
			 	return;
			}
	  	 	if(ueditor().length==0){
	  			return layer.msg('回复内容不能为空',{icon:5});
	  	 	}
	  	 
	  		if(ueditor().length>1000){
	  			return layer.msg('回复内容不能超过1000字符',{icon:5});
	  		}
	  
	  		var id = thisObject.attr("id").split("&");
			var postid = id[0];
			var userid = id[1];
			var commentfloor = parseInt(id[2])+1;
			
	  		$.ajax({
				url:"wd/addReplyPost.do",
	   			type:"post",
	   			contentType:"application/x-www-form-urlencoded;charset=utf-8",
	   			data:{postId:postid,userId:userid,commenContent:ueditor(),commentFloor:commentfloor,replierid:wd_users_id,level:0,createuser:nickname},
	   			dataType:"json",
	   			success:function(data){
					if(data.result==1){
						layer.msg('回帖成功');
						window.location.reload();
					}else{
						layer.msg('回帖失败');
					}
	   			}
			}); 
	  
	  	}
	  

	
	</script>
		
	<script type="text/javascript">
		var count = 0;
		
		$("#picbtn").click(function(){
			if(count>1){
				$(this).attr("disabled","disabled");
				return false;
			}
		});
		
		layui.use('upload', function(){
			
			if(user.length ==0 ){
				 return;
			}
			  var upload = layui.upload;
			   
			  //执行实例
			  var uploadInst = upload.render({
			    elem: '#picbtn' //绑定元素
			    ,url: 'upload/image.do' //上传接口
			    ,size:'5120'
			    ,done: function(res){
			    	if(count>2){
			    		layer.msg('只允许上传三张图片');
						return false;
					}
			    	//如果上传失败
					if (res.code > 0) {
						return layer.msg('上传失败');
					}else{
						UE.getEditor('container').execCommand('insertHtml', $("<img></img>").attr('src',"static/login/upload/"+res.image).prop("outerHTML"));
						imgSize($(ueditor()),30,50);
						count++;
						return layer.msg('上传成功');
					}
					//上传成功
			       
			    }
			    ,error: function(){
			    	//演示失败状态，并实现重传
					var demoText = $('#demoText');
					demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
					demoText.find('.demo-reload').on('click', function() {
						uploadInst.upload();
					});
			    }
			  });
			});
		</script>
	
	</body>

</html>