<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../common/common-header.jsp"%>

<div class="container">
	<div class="top-link">
		<a class="a-default" href="wd/toIndex.do">首页</a>
		<span>&gt;</span>
		<a class="a-default" href="wd/forum.do">技术论坛</a>
		<span>&gt;</span> 
		<a class="a-default">${luntanType.name}</a>
	</div>
	<div class="type-title">
		<div class="type-info">
			<div class="type-icon" id="${luntanType.posttype_id }"><img src='${requestPath}${luntanType.picture}' width="160" height="160" onerror="this.src='<%=basePath%>static/img/index/ps.png'"/></div>
			<div class="type-info-detail">
				<div class="type-info-base">
					<div class="type-info-base-title font-max">${luntanType.name}</div>
					<div class="type-info-base-count displayFlex">
						<span class="text-lightgrey">帖子数：</span><span class="text-salary">${luntanType.num}</span>
						<div class="type-info-base-count-vertical text-lightgrey">|</div>
						<span class="text-lightgrey">今日：</span><span class="text-salary" id="todayTheme">${luntanType.todaynum}</span>
					</div>
					<div class="type-info-base-admin displayFlex">
						<div class="type-info-base-admin-tag">${luntanType.createuser}</div>
						<div class="type-info-base-admin-name">${luntanType.manager}</div>
						<div class="type-info-base-admin-signature"></div>
					</div>
				</div>
				<div class="type-info-content">
					${luntanType.synopsis}
				</div>
				<div class="type-info-btn" id="quickPosting">快速发帖</div>
				<input type="hidden" id="user" name="user" value="${sessionScope.userph}"/>
			</div>
		</div>
	</div>
	<div class="type-content space-between" style="padding-bottom:30px">
		<div>
			<div class="type-content-left">
				<div class="type-content-left-inner"  id="content">
					<div style="height: 100px;" >
						<strong><em>暂无帖子</em></strong>
					</div>
				</div>
				
				<!-- 分页插件 -->
				<div class="type-post-pager displayFlex" id="page" style="height: 100px">
					<div class="box" id="box" style="position: static;transform: translateX(20px) translateY(20px);"></div>
				</div> 
					
				
				
				<!-- 折叠 -->
				<div class="type-new-post-title">
					<div class="type-new-post-title-inputcontainer">
						<input class="type-new-post-title-input" id="inputTitle" placeholder="请填写标题" maxlength="255"/>
					</div>
				</div>
				<div class="type-new-post-content">
				
					<div class="type-new-post-content-inputcontainer" style="width:788px;height:260px;overflow-y: auto; padding: 5px" id="editor" contenteditable="true" >
						<!--这里放富文本-->
					</div>
					<input type="hidden" id="nodeTitle" name="nodeTitle" />
					<input type="hidden" id="nodeContent" name="nodeContent" />
				
					<div class="type-new-post-content-inputcontainer-other">
						<div class="new-post-face displayFlex">
							<div class="new-post-face-icon" ></div>
							<span class="new-post-text" id="btn">插入表情</span>
						</div>
						<div class="new-post-pic displayFlex" id="photos_continer">
							<div class="new-post-pic-icon"></div>
							<span class="new-post-text" id="inputPhoto">插入图片</span>
						</div>
						
					</div>
					
				</div>
				<div class="type-content-left-bottom">
					<div class="btn-post-bottom" id="sendNode">发布帖子</div>
				</div>
			</div>
		</div>
		<div class="type-content-right">
			<div class="module-download">
				<div class="download-title font-lg">资料下载</div>
				<ul class="download-list">
					
				</ul>
				<div class="type-content-right-pager displayFlex">
					<div class="pagePrev" id="downloadPre">&lt;&nbsp;上一页</div>
					<div class="pageIndex">1&nbsp;/&nbsp;${totalPageDatadownload}</div>
					<div class="pageNext" id="downloadEnd">下一页&nbsp;&gt;</div>
				</div>
			</div>

			<div class="joblist">
				<div class="joblist-title font-lg">最近就业学员</div>
				<ul class="joblist-nav">
					<!-- <jobitem v-for="item in joblist" time="true" :stu-name="item.name"
						:company-name="item.company" :salary="item.salary"></jobitem> -->
				</ul>
				<div class="type-content-right-pager displayFlex">
					<div class="pagePrev" id="jobStart">&lt;&nbsp;上一页</div>
					<div class="pageIndex">1&nbsp;/&nbsp;${totalJobStudent}</div>
					<div class="pageNext" id="jobEnd">下一页&nbsp;&gt;</div>
				</div>
			</div>

			<div class="topbox-small-box">
				<div class="small-box-title">近期开班信息</div>
				<ul class="small-box-ulbox">
					<class-item v-for="item in java_class" :clas="item" :active="item.active"></class-item>
				</ul>
			</div>
		</div>
	</div>
</div>
<%@include file="../common/common-footer.jsp"%>
<script src="<%=basePath%>static/js/lunbo.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/pageindex.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/vue.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/header.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/footer.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/clzitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/jobitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/stuitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/rateitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/ProcessPage.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/courseitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/teacheritem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript"
	charset="utf-8"></script>
	
<script src="<%=basePath%>static/layui/layui.all.js" type="text/javascript"
	charset="utf-8"></script>
	

<script src="<%=basePath%>static/jQuery-emoji-master/lib/script/jquery.mousewheel-3.0.6.min.js"></script>
<script src="<%=basePath%>static/jQuery-emoji-master/lib/script/jquery.mCustomScrollbar.min.js"></script>
<script src="<%=basePath%>static/jQuery-emoji-master/dist/js/jquery.emoji.min.js"></script>

<script src="<%=basePath%>static/jQueryHdPaging/paging.js"></script>


<link rel="stylesheet" href="static/layui-v2.3.0/layui/css/layui.css" />

<script type="text/javascript">
/***************************加载事件************************************************************/    
	
	var user = $("#user").val();
	var nickname,wd_users_id;
	$(function(){
		
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
		
/* ***********************************↓待释放↓********************************************** */

		$(document).on("click",".type-content-post",function(){
			var user_id = $(this).attr("id").split('&')[0];
			var post_id = $(this).attr("id").split('&')[1];
			var heat = $(this).attr("id").split('&')[2];
			window.location.href="wd/updatePost.do?post_id="+post_id; 
		});
		
/* ***********************************↑待释放↑********************************************** */

		//网盘下载
		ajaxDwonloadPage(1);
		//近期就业学员
		ajaxJobPage(1);
		
		//发送帖子
		$("#sendNode").click(function(){
			if(user.length==0){
   				alert("您还未登录，无法发帖！");
   				return;
   			}
			
			var title = $("#inputTitle").val();
			if(title.length==0){
				alert("帖子标题不能为空");
				return;
			}
			var content =$("#editor").html();
			if(content.length==0){
				alert("帖子内容不能为空");
				return;
			}
			$("#nodeTitle").val(title);
			$("#nodeContent").val(content);
			var typeid = $('.type-icon').attr('id');
			$.ajax({
	    		url:"wd/addPost.do",
	    		type:"post",
	    		contentType:"application/x-www-form-urlencoded;charset=utf-8",
	    		data:{title:title,content:content,postType_id:typeid,use:wd_users_id,createUser:nickname},
	    		dataType:"json",
	    		success:function(data){
	    			if(data.addPostResult==1){
	    				window.location.reload();
	    			}
	    		
	    		}
	    	});
		});
		
	})
	
	 $("#editor,#inputTitle").click(function(){
		if(user.length==0){
			alert("您还未登录，无法发帖！");
			$(this).blur();
			return;
		}
	});
	
	$("#btn").click(function(){
		if(user.length==0){
			alert("您还未登录，无法发帖！");
			return;
		}
	}); 
	
	$("#inputPhoto").click(function(){
		if(user.length==0){
			alert("您还未登录，无法发帖！");
			return;
		}
	})
	
/*******************************************插入图片***************************************************/
	var imgCount = 0;
	
	$("#inputPhoto").click(function(){
		al
		if(imgCount>1){
			$("#photos_continer").attr("disabled","disabled");
			return false;
		}
	})
	
	layui.use('upload',function() {
		if(user.length==0){
			return;
		}
		var $ = layui.jquery, upload = layui.upload;
		//普通图片上传
		var uploadInst = upload.render({
					elem : '#inputPhoto',
					url : 'upload/image.do',
					data:{"kind":"hr"},
					size:'10240',
					before : function(obj) {
						//预读本地文件示例，不支持ie8
						obj.preview(function(index,file, result) {
							$('#demo1').attr('src',result); //图片链接（base64）
							
						});
					},
					done : function(res) {
						
						//如果上传失败
						if (res.code > 0) {
							return layer.msg('上传失败');
						}else{
							
							$("#editor").html($("#editor").html()+
									$("<img></img>").attr('src',"static/login/upload/"+res.image).prop("outerHTML"));
							imgCount++;
							return layer.msg('上传成功');
						}
						//上传成功
					},
					error : function() {
						//演示失败状态，并实现重传
						var demoText = $('#demoText');
						demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
						demoText.find('.demo-reload').on('click', function() {
							uploadInst.upload();
						});
					}
				});
	})
	
	
	

/* 	function imgSize(thisImg){
		if(thisImg.width()>600){
			thisImg.attr("width","600");
		}
		if(thisImg.height()>500){
			thisImg.attr("height","500");
		} 
		
		$("#editor").html($("#editor").html()+$("#img").html());
	}); */
	
	
/* 	//图片取消按钮
	$("#photoNo").click(function(){
		$.ajax({
    		url:"wd/removeImg.do",
    		type:"post",
    		contentType:"application/x-www-form-urlencoded;charset=utf-8",
    		dataType:"json",
    		success:function(data){
    			if(data.result==1){
    				alert("取消成功");
    			}
    		
    		}
    	});
		$("#inputPhotoWindow").hide();
	});*/  
	
/*******************************************插入表情***************************************************/    	
	function emoji(){
		if(user.length==0){
			return;
		}
		$("#editor").emoji({ 
	           button: "#btn",
	           showTab: false,
	           animation: 'slide',
	           icons: [{
	               name: "QQ表情",
	               path: "<%=basePath%>static/jQuery-emoji-master/dist/img/qq/",
	               maxNum: 91,
	               excludeNums: [41, 45, 54],
	               file: ".gif"
	           }]
	       }); 
	}
	
       
/*****************************************点击顶端快速发出定位到底端发帖*****************************************************/      

       $("#quickPosting").click(function(){
    	   if(user.length==0){
   				alert("您还未登录，无法发帖！");
   				return;
   			}
    	   $(window).scrollTop($("#inputTitle").offset().top);
    	   $("#inputTitle").focus(); 
    	
       });
       
/*****************************************最近就业学员*****************************************************/       
    
    
	//最近就业学员上一页
	$("#jobStart").click(function(){
		ajaxJobPage(ajaxPage($(this),true));
	})
	//最近就业学员下一页
	$("#jobEnd").click(function(){
		ajaxJobPage(ajaxPage($(this),false));
	})
	
	 //最近就业学员Ajax分页
    function ajaxJobPage(pageStart){
    	if(!pageStart){
    		return;
    	}
    	$.ajax({
    		url:"wd/findJobStudent.do",
    		type:"post",
    		contentType:"application/x-www-form-urlencoded;charset=utf-8",
    		data:{pageNo:pageStart},
    		dataType:"json",
    		success:function(data){
    			$(".joblist-nav").text("");
    			
    			var name,companyName,salary,getjobtime;  
    			$.each(data.findJobStudent,function(index,value){
    				
    				name=value.name;
    				companyName=value.companyName;
    				salary=value.salary;
    				getjobtime=value.getjobtime;
    				
    				var jobitem = $("<li class='space-between job-item swiper-slide'><div class='stu-name'>"+
    				name+"</div><div class='company-name'>"+
    				companyName+"</div><div class='job-salary'>月薪：<span class='text-salary'>"+
    				salary+"元</span></div><div class='job-date'>"+
    				getjobtime+"</div></li>");
    				
    				$(".joblist-nav").append($(jobitem));
    			});
    			
    			
    		}
    	});
    }
	
/******************************************近期开班信息****************************************************/    
	$(".type-content-post").last().css("border-bottom", "none");
	$(".download-list>.download-item").last().css("border-bottom", "none");

	//获取优秀学生信息
	getData({
		url : "wd/reqClassOPeningList.do",
		attr : [ "ui_class", "java_class", "web_class" ],
		callback : function() {
			vm.ui_class.reverse();
			vm.java_class.reverse();
			vm.web_class.reverse();
		}
	});

/***************************最近就业学院和/网盘分页公用分页方法************************************************************/    
     //分页方法
    function ajaxPage(pageObject,pageState){
    	var pageStart,pageEnd;
    	if(pageState){
    		pageStart = pageObject.next().text().split("/")[0].trim();
        	pageEnd = pageObject.next().text().split("/")[1].trim();
        	if(pageStart<=1){
        		alert("无上一页");
        		return false;
        	}
        	pageStart--;
        	pageObject.next().text("");
	    	pageObject.next().text(pageStart+" / "+pageEnd);
    	}else{
    		pageStart = pageObject.prev().text().split("/")[0].trim();
        	pageEnd = pageObject.prev().text().split("/")[1].trim();
        	if(pageStart>=pageEnd){
        		alert("无下一页");
        		return false;
        	}
        	pageStart++;
        	pageObject.prev().text("");
	    	pageObject.prev().text(pageStart+" / "+pageEnd);
    	}
    	return pageStart;
    }
/***************************网盘分页************************************************************/      
     //网盘上一页
    $("#downloadPre").click(function(){
    	ajaxDwonloadPage(ajaxPage($(this),true));
    });
    //网盘下一页
    $("#downloadEnd").click(function(){
    	ajaxDwonloadPage(ajaxPage($(this),false));
    });
    
    //网盘Ajax分页
    function ajaxDwonloadPage(pageStart){
    	if(!pageStart){
    		return;
    	}
    	$.ajax({
    		url:"wd/datadownloadByPage.do",
    		type:"post",
    		contentType:"application/x-www-form-urlencoded;charset=utf-8",
    		data:{pageNo:pageStart},
    		dataType:"json",
    		success:function(data){
    			$(".download-list").text("");
    			
    			var datadownload_id,dataname,datasize,kanboxurl,lookintroduceurl,downloadcount;
    			$.each(data.findDatadownloadList,function(index,value){
    				
    				datadownload_id=value.datadownload_id;
    				dataname=value.dataname;
    				datasize=value.datasize;
    				kanboxurl=value.kanboxurl;
    				lookintroduceurl=value.lookintroduceurl;
    				downloadcount=value.downloadcount;
    				var download = $("<li class='download-item' id='"+
    			    		  		datadownload_id+"'><div class='download-item-top space-between'><div class='download-title'>"+
    			    		  		dataname+"</div><div class='download-size'>"+
    			    		  		datasize+"</div></div><div class='download-item-bottom space-between'><div class='download-way displayFlex'><div onclick='toUrl($(this))' class='download-way-disk' id='"+
    			    		  		kanboxurl+"'>网盘下载</div><div class='download-way-desc' onclick='toUrl($(this))' id='"+
    			    		  		lookintroduceurl+"'>查看介绍</div></div><div class='download-count'>"+
    			    		  		downloadcount+"次下载</div></div></li>");
    				$(".download-list").append($(download));
    				
    			});
    			
    			
    		}
    	});
    }
    
    function toUrl(thisUrl){
    	var url = thisUrl.attr("id");
    	window.location.href=url;
    }
/***************************帖子分页************************************************************/
	
	//帖子分页方法
	function ajaxPostPage(page){
		var id = $(".type-icon").attr("id");
    	$.ajax({
        	url:"wd/postListByPageNo.do",
        	type:"post",
        	contentType:"application/x-www-form-urlencoded;charset=utf-8",
        	data:{pageNo:page,posttypeid:id},
        	dataType:"json",
        	success:function(data){
        		$("#content").text(""); 
        		
        		var title,restoreNumber,content,nickname,viewnumber,timeDiff,use,post_id;
        		$.each(data.postingByIdList,function(index,value){
        			post_id = value.post_id;
        			use = value.use;
        			title = value.title;
        			restoreNumber = value.restoreNumber;
					content = value.content;
					nickname = value.nickname;
					viewnumber = value.viewnumber;
					timeDiff=value.timeDiff;
					
					 var divcontent = $("<div class='type-content-post' id='"+
							 			use+"&"+post_id+"&"+viewnumber+"'><div class='type-content-title displayFlex'><div class='font-lg post-title' style='width: 10em;white-space: nowrap;overflow:hidden;text-overflow: ellipsis;'>"+
            							title+"</div><div class='type-content-commentcount text-salary'>"+
            							restoreNumber+"</div></div><div class='type-content-detail' style='height:50px;word-wrap:break-word;'>"+
            							content+"</div><div class='type-content-info displayFlex'><div class='post-usericon'></div><div class='post-username'>"+
            							nickname+"</div><div class='post-watchicon'></div><div class='post-watchcount'>"+
            							viewnumber+"</div><div class='post-timeicon'></div><div class='post-time'>"+
            							timeDiff+"</div></div></div>"); 
					/*  var divcontent = $("<div class='type-content-post' id='"+
					 			use+"&"+post_id+"&"+viewnumber+"'><div class='type-content-title displayFlex'><div class='font-lg post-title'>"+
 							title+"</div><div class='type-content-commentcount text-salary'>"+
 							restoreNumber+"</div></div><div class='type-content-detail'>"+
 							content+"</div><div class='type-content-imgs displayFlex'><div class='type-content-img'>"+
 							"<img src='static/img/index/ps.png' onload='controlSize(this)' /></div><div class='type-content-img'>"+
 							"<img src='static/img/index/ps.png' onload='controlSize(this)' /></div><div class='type-content-img'>"+
 							"<img src='static/img/index/ps.png' onload='controlSize(this)' /></div></div><div class='type-content-info displayFlex'><div class='post-usericon'></div><div class='post-username'>"+
 							nickname+"</div><div class='post-watchicon'></div><div class='post-watchcount'>"+
 							viewnumber+"</div><div class='post-timeicon'></div><div class='post-time'>"+
 							timeDiff+"</div></div></div>");  */
            		$("#content").append(divcontent); 
            		
        		});
        		emoji();
        	}
        });
	}

	//帖子分页ajax
	var countAndtotalPage = "${countAndtotalPage}";
	var setTotalCount = countAndtotalPage.split("&")[0];
	var setTotalPages = countAndtotalPage.split("&")[1];
	if(setTotalCount==0){
		emoji();
	}
    $('#box').paging({
    	initPageNo: 1, // 初始页码
    	totalPages: setTotalPages, //总页数
    	totalCount: '合计' + setTotalCount + '条帖子', // 条目总数
    	slideSpeed: 600, // 缓动速度。单位毫秒
        jump: true, //是否支持跳转
        callback: function(page) { // 回调函数
        	if(setTotalCount>0){
        		ajaxPostPage(page);
        		
        	}
        	
          }
      })      
    
</script>
</body>

</html>