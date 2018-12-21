<%@  taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>



<%@include file="../common/common-header.jsp"%>

<!--中部-->
<div class="per-zong">
		<div class="per-subject">
			<div class="per-left">
				<ul class="per-left-ul">
					<li onmouseenter="showSubject()">
						<div class="per-left-ul-li">
							<div class="per-left-ul-li-img"></div>
							<div class="per-left-ul-li-text">我的课程</div>
						</div>
					</li>
					<li onmouseenter="showPostReturn()">
						<div class="per-left-ul-li">
							<div class="per-left-ul-li-img"></div>
							<div class="per-left-ul-li-text">我的回复</div>
						</div>
					</li>
					<li onmouseenter="showPosts()">
						<div class="per-left-ul-li">
							<div class="per-left-ul-li-img"></div>
							<div class="per-left-ul-li-text">我的帖子</div>
						</div>
					</li>
					<li onmouseenter="showdata()">
						<div class="per-left-ul-li">
							<div class="per-left-ul-li-img"></div>
							<div class="per-left-ul-li-text">系统消息</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="per-right">
				<!--<ul class="per-right-ul">-->
				<!--<li class="per-right-ul-li">-->

				<div class="per-right-one" style="display:none">
					<ul class="per-right-one-ul" id="subject">
						<li>
							<div class="per-right-one-ul-subject">
								<div class="per-right-one-ul-img"></div>
								<div class="per-right-one-ul-text">
									<div class="per-right-one-ul-text-sub">
										<h3 class="per-right-one-ul-text-h3">JAVA软件入门（第一讲）</h3>
										<span class="per-right-one-ul-text-sp">已经学习80%</span>
										<div class="per-right-one-ul-text-hr">
											<div class="per-right-one-ul-text-hr-pe"></div>
										</div>
										<span class="per-right-one-ul-text-sp">课程编号：KJ:555444421151</span>
										<br />
										<span class="per-right-one-ul-text-sp">1633人正在学习</span>
									</div>
								</div>
								<div class="per-right-one-ul-text-bor">
									<div class="per-text-top">继续学习</div>
									<div class="per-text-bottom">社区讨论</div>
								</div>
							</div>
						</li>
						<hr class="right-hr" />
						
					</ul>
				</div>

				<!--	<li class="per-right-ul-li">-->
				<div class="per-right-two" style="display:none">
					<div class="per-right-two-ul">
						<!-- <li>
							<div class="per-right-two-ul-li-text">
								<div class="per-right-two-ul-li-text-top">我在<span class="top-question">Eclipse java EE 安装中遇到的一些问题</span>回复：</div>
								<div class="per-right-two-ul-li-text-center">
									<p>输入 netstat -ano 查询Tomcat端口占用的进程号。 找到这个PID后。。杀死这个进程杀死进程 tskill 查询到的PIDwindows下ctrl+alt+del打开任务管理器,在进程里面找到tomcat.exe,点击右键结束进行</p>
								</div>
								<div class="per-right-two-ul-li-text-bottom">
									<div class="per-right-two-ul-li-text-bottom-1">回复：6</div>
									<div class="per-right-two-ul-li-text-bottom-2">2018-8-12</div>
									<div class="per-right-two-ul-li-text-bottom-3">删除</div>
								</div>
							</div>
						</li>
						<hr class="right-hr" />
						 -->
					</div>
					<div class="per-right-two-bottom">
						<div class="per-right-two-bottom-paging">
							<div class="per-right-two-bottom-paging-Fristpage" onclick="clearNum()">首页</div>
							<div class="per-right-two-bottom-paging-Previouspage" onclick="showPostReturn(--numNoReturn)">上一页</div>
							<div class="per-right-two-bottom-paging-Nextiouspage" onclick="showPostReturn(++numNoReturn)">下一页</div>
							<div class="per-right-two-bottom-paging-Lastpage" onclick="showPostReturn(-1)">尾页</div>
						</div>
					</div>
				</div>
				<!--</li>
				-->

				<!--<li class="per-right-ul-li">-->
				<div class="per-right-three" style="display:none">
					<div class="per-right-three-ul">
						<!-- <li>
							<div class="per-right-three-ul-li-text">
								<div class="per-right-three-ul-li-text-top">我在<span class="top-question">java 大数据板块</span>发帖：</div>
								<div class="per-right-three-ul-li-text-bottom">
									<div class="per-right-three-ul-li-text-bottom-question">Eclipse java EE 安装中遇到的一些问题</div>
									<div class="per-right-three-ul-li-text-bottom-lui">浏览：120</div>
									<div class="per-right-three-ul-li-text-bottom-1">回复：6</div>
									<div class="per-right-three-ul-li-text-bottom-2">2018-8-12</div>
									<div class="per-right-three-ul-li-text-bottom-3">删除</div>
								</div>
							</div>
						</li>-->
					</div>
				 	 <div class="per-right-three-bottom">
						<div class="per-right-three-bottom-paging">
							<div class="per-right-three-bottom-paging-Fristpage" onclick="clearNumNo()">首页</div>
							<div class="per-right-three-bottom-paging-Previouspage" onclick="showPosts(--numNo)">上一页</div>
							<div class="per-right-three-bottom-paging-Nextiouspage" onclick="showPosts(++numNo)">下一页</div>
							<div class="per-right-three-bottom-paging-Lastpage" onclick="showPosts(-1)">尾页</div>
						</div>
					</div>
				</div>
				<!--</li>-->

				<div class="per-right-four" style="display:none">
					<ul class="per-right-four-ul" id="systext">
						<li>
							<div class="per-right-four-ul-li-text">
								<div class="per-right-four-ul-li-text-tooop"></div>
								<div class="per-right-four-ul-li-text-top">《英雄联盟》网络游戏用户协议</div>
								<div class="per-right-four-ul-li-text-conter">
								
									<span class="per-right-four-ul-li-text-conter-span1">2018-8-12</span><span class="per-right-four-ul-li-text-conter-span2">16:00</span>
									
								</div>
								<div class="per-right-four-ul-li-text-bottom">
									深圳市腾讯计算机系统有限公司（以下又称“腾讯”或“腾讯公司”，在《文化部网络游戏服务格式化协议必备条款》当中又被称为“甲方”）在此特别提醒用户（在《文化部网络游戏服务格式化协议必备条款》当中又被称为“乙方”）仔细阅读本《〈英雄联盟〉网络游戏用户协议》（下称“本《用户协议》”） 中的各个条款，包括但不限于免除或者限制腾讯责任的条款、对用户权利进行限制的条款以及约定争议解决方式、司法管辖的条款。 请您仔细阅读本《用户协议》（未成年人应当在其法定监护人陪同下阅读），并选择接受或者不接受本《用户协议》。除非您同意并接受本《用户协议》中的所有条款，否则您无权接收、下载、安装、启动、升级、登录、显示、运行、 截屏《英雄联盟》网络游戏，亦无权使用该游戏软件的某项功能或某一部分或者以其他的方式使用该游戏软件。您接收、下载、安装、启动、升级、登录、显示、运行、截屏《英雄联盟》网络游戏，或者使用该游戏软件的某项功能、某一部分， 或者以其他的方式使用该游戏软件的行为，即视为您同意并接受本《用户协议》，愿意接受本《用户协议》所有条款的约束。
								</div>
							</div>
						</li>
						<hr class="right-hr" />
						<li>
							<div class="per-right-four-ul-li-text">
								<div class="per-right-four-ul-li-text-tooop"></div>
								<div class="per-right-four-ul-li-text-top">《英雄联盟》网络游戏用户协议</div>
								<div class="per-right-four-ul-li-text-conter">
									<span class="per-right-four-ul-li-text-conter-span1">2018-8-12</span><span class="per-right-four-ul-li-text-conter-span2">16:00</span>
								</div>
								<div class="per-right-four-ul-li-text-bottom">
									深圳市腾讯计算机系统有限公司（以下又称“腾讯”或“腾讯公司”，在《文化部网络游戏服务格式化协议必备条款》当中又被称为“甲方”）在此特别提醒用户（在《文化部网络游戏服务格式化协议必备条款》当中又被称为“乙方”）仔细阅读本《〈英雄联盟〉网络游戏用户协议》（下称“本《用户协议》”） 中的各个条款，包括但不限于免除或者限制腾讯责任的
								</div>
							</div>
						</li>
						<hr class="right-hr" />
						<!-- <li>
							<div class="per-right-four-ul-li-text">
								<div class="per-right-four-ul-li-text-tooop"></div>
								<div class="per-right-four-ul-li-text-top">《英雄联盟》网络游戏用户协议</div>
								<div class="per-right-four-ul-li-text-conter">
									<span class="per-right-four-ul-li-text-conter-span1">2018-8-12</span><span class="per-right-four-ul-li-text-conter-span2">16:00</span>
								</div>
								<div class="per-right-four-ul-li-text-bottom">
									深圳市腾讯计算机系统有限公司（以下又称“腾讯”或“腾讯公司”，在《文化部网络游戏服务格式化协议必备条款》当中又被称为“甲方”）在此特别提醒用户（在《文化部网络游戏服务格式化协议必备条款》当中又被称为
								</div>
							</div>
						</li> -->
						<li>
						<posting v-for="(item,i) in postTypeStudyList"
						:MNAME="item.MNAME?item.MNAME:'0'"
					></posting>
						</li>
					</ul>
				</div>

				<!--</ul>-->
			</div>
		</div>
		
		</div>
			<!-- <wdfooter></wdfooter> -->
			<ul class="fixed">
				<li class="msg"></li>
				<li class="qa"></li>
				<li class="talk"></li>
				<li class="top"></li>
			</ul>
<%@include file="../common/common-footer.jsp"%>

<script src="<%=basePath%>static/js/vue.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/header.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/footer.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/clzitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/indexfreecourse.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/jobitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/newsitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/stuitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/flowpath.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/rateitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/projectlist.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/courseitem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/forumplat.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/teacheritem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/newsTestall.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>static/UEditor/ueditor.config.js"
 charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>static/UEditor/ueditor.all.js"
 charset="utf-8"></script>
<script type="text/javascript">
var data=${sessionScope.userph};
var towhere='${towhere}';
if(towhere=="one"){
	showSubject();
}else if(towhere=="three"){
	showPosts(numNo);
}else if(towhere=="four"){
	showdata();
}

/* 我的课程 */
function showSubject(){
	getData({
		url : "<%=basePath%>wd/mySubject.do",
		attr:"mySubjectList",
		callback:function(data){

/* 			console.log(data.mySubjectList); */
 			var path = data.requestPath;
			$(".per-right-one").css("display","block");
			$("#subject").html("");
			
			for(var i=0;i<data.mySubjectList.length;i++){
				var str="<li>";
				str+="<div class='per-right-one-ul-subject'>";
				str+="<div class='per-right-one-ul-img'><img height='120px' width='170px' src='"+path+data.mySubjectList[i].pictureName+"' /></div>";
				str+="<div class='per-right-one-ul-text'>";
				str+="<div class='per-right-one-ul-text-sub'>";
				str+="<h3 class='per-right-one-ul-text-h3'>"+data.mySubjectList[i].title+"</h3>";
				str+="<span class='per-right-one-ul-text-sp' style='display:none'>已经学习80%</span>";
				str+="<div class='per-right-one-ul-text-hr' style='display:none'>";
				str+="<div class='per-right-one-ul-text-hr-pe' style='width:10%'></div>";
				str+="</div>";
				str+="<span class='per-right-one-ul-text-sp'>课程编号："+data.mySubjectList[i].video_code+"</span>";
				str+="<br />";
				str+="<span class='per-right-one-ul-text-sp'>"+data.mySubjectList[i].number+"人正在学习</span>";
				str+="</div>";
				str+="</div>";
				str+="<div class='per-right-one-ul-text-bor'>";
				str+="<a href='wd/toVideo.do?id="+data.mySubjectList[i].url+"&vtype="+data.mySubjectList[i].course+"' class='per-text-top'>开始学习</a>";
				str+="<a href='wd/forum.do' class='per-text-bottom' >社区讨论</a>";
				str+="</div>";
				str+="</div>";
				str+="</li>";
				str+="<hr class='right-hr' />";
				$("#subject").append(str);
			}
		}
	})
}


/*我的回复*/
var numNoReturn = 1;  //我的回复页码
var sumPageReturn = 1; //我的回复总页数
function clearNum(){
	numNoReturn=1;
	showPostReturn(numNoReturn);
}
//showPostReturn();
function showPostReturn(pageNo){
	/* alert("第"+numNoReturn+"页共"+sumPageReturn+"页"); */
	if(numNoReturn<1){
		numNoReturn = 1;
	}else if(pageNo==-1){
		numNoReturn = sumPageReturn;
	}
	if( sumPageReturn < numNoReturn){
		 numNoReturn  = sumPageReturn;
		return false;
	}
	getData({
		url:"<%=basePath%>wd/postReturn.do?page="+numNoReturn,
		attr:"postReturnList",
		callback:function(data){
			if(data.findAllReturnSize==0){
				return;
			}
			sumPageReturn=data.sumPage;
			var arr=data.postReturnList;
			$(".per-right-two").css("display","block");
			var root=$(".per-right-two-ul").html("");
			for ( var item in arr) {
				var li="<li><div class='per-right-two-ul-li-text'><div class='per-right-two-ul-li-text-top'>我在<span class='top-question'>"+arr[item].title+"</span>回复：</div><div class='per-right-two-ul-li-text-center'><p>"+arr[item].commencontent+"</p></div><div class='per-right-two-ul-li-text-bottom'><div class='per-right-two-ul-li-text-bottom-1'>回复："+arr[item].restorenumber+"</div><div class='per-right-two-ul-li-text-bottom-2'>"+arr[item].commenttime.substring(0,10)+"</div><div class='per-right-two-ul-li-text-bottom-3' id='"+arr[item].postreturn_id+"' onclick = 'delPostReturn(this)' style='cursor: pointer;'>删除</div></div></div></li> <hr class='right-hr'/>"
				root.append(li);
			}
			var num = $(".per-right-two-ul-li-text").length;
			if(num==0){
				$(".per-right-two-bottom").html("<h1 style='font-size:25px;text-align:center;margin-top:20px;'>无数据</h1>");
			}
		}
	})																				
}

/*删除我的回复*/
function delPostReturn(now){
	var post_id=now.id;
	if(confirm("您确定要删除该回复吗？")){
		$.ajax({
			type:"post",
			url:"<%=basePath%>wd/postReturnDel.do",
			contentType:"application/x-www-form-urlencoded;charset=utf-8",
			data:{id:post_id},
			dataType:"json",
			success:function(json){
				$(now).parent().parent().parent().remove();
				 alert(json.msg);
				 var num = $(".per-right-two-ul-li-text").length;
					if(num==0){
						/* $(".per-right-three-bottom").hide(); */
						$(".per-right-three-bottom").html("<h1 style='font-size:25px;text-align:center;margin-top:20px;'>无数据</h1>");
					}
			},
			async:true
		});	
	}
}


/* 系统消息 */
function showdata(){
	getData({
		url : "<%=basePath%>ms/text.do",
		attr:"postTypeStudyList",
		callback:function(data){
			/* console.log(data.postTypeStudyList); */
			$(".per-right-four").css("display","block");
			$("#systext").html("");
			for(var i=0;i<data.postTypeStudyList.length;i++){
				var createTime = data.postTypeStudyList[i].mCreateTime.substring(0,16);
				var str="<li>";
				str+="<div class='per-right-four-ul-li-text'>";
				str+="<div class='per-right-four-ul-li-text-tooop'></div>";
				str+="<div class='per-right-four-ul-li-text-top'>"+data.postTypeStudyList[i].mName+"</div>";
				str+="<div class='per-right-four-ul-li-text-conter'>";
				str+="<span class='per-right-four-ul-li-text-conter-span1'>"+createTime+"</span>";
				str+="</div>";
				str+="<div class='per-right-four-ul-li-text-bottom'>"+data.postTypeStudyList[i].mText;
				str+="</div>";
				str+="</div>";
				str+="</li>";
				str+="<hr class='right-hr' />";
				$("#systext").append(str);
			}
		}
	})
}
/* 我的贴子  */
var numNo = 1;	//我的贴子条数
var sumPage = 1; //我的贴子总页数
function clearNumNo(){
	numNo=1;
	showPosts(numNo);
}

function showPosts(pageNo){
	/* alert("第"+numNo+"页共"+sumPage+"页"); */
	if(numNo<1){
		numNo = 1;
	}else if(pageNo==-1){
		numNo = sumPage;
	}else if(numNo>sumPage){
		numNo = sumPage;
		return false;
	}
	
	getData({
		url:"/njms-wechat/wd/post.do?page="+numNo,
		attr:"postsList",
		callback:function(data){
			if(data.findAllPostsSize==0){
				return;
			}
			$(".per-right-three").css("display","block");
			sumPage=data.sumPage;
			var arr=data.postsList;
			//alert(data.postsList[0].name)
			var root=$(".per-right-three-ul").html("");
			for ( var item in arr) {
				var li="<li><div class='per-right-three-ul-li-text'><div class='per-right-three-ul-li-text-top'>我在<a href='wd/luntanbytype.do?typeid="+arr[item].postType_id+"' style='color:#166CBF!important;margin:0 7px!important;'>"+arr[item].name+"</a>发帖：</div><div class='per-right-three-ul-li-text-bottom'><div class='per-right-three-ul-li-text-bottom-question'>"+arr[item].title+"</div><div class='per-right-three-ul-li-text-bottom-lui'>浏览："+arr[item].viewnumber+"</div><div class='per-right-three-ul-li-text-bottom-1'>回复："+arr[item].restorenumber+"</div><div class='per-right-three-ul-li-text-bottom-2'>"+arr[item].createtime.substring(0,10)+"</div><div class='per-right-three-ul-li-text-bottom-3' id='"+arr[item].post_id+"' onclick = 'delPost(this)' style='cursor: pointer;'>删除</div></div></div></li> <hr class='right-hr'/>"
				root.append(li);
			}
			var num = $(".per-right-three-ul-li-text").length;
			if(num==0){
				$(".per-right-three-bottom").html("<h1 style='font-size:25px;text-align:center;margin-top:20px;'>无数据</h1>");
			}
		}
	})
}

/*删除我的贴子*/
function delPost(now){
	var post_id=now.id;
	if(confirm("您确定要删除该贴子吗？")){
		$.ajax({
			type:"post",
			url:"wd/del.do",
			contentType:"application/x-www-form-urlencoded;charset=utf-8",
			data:{post_id:post_id},
			dataType:"json",
			success:function(json){
				$(now).parent().parent().parent().remove();
				 alert(json.msg);
				 var num = $(".per-right-three-ul-li-text").length;
					if(num==0){
						
						/* $(".per-right-three-bottom").hide(); */
						$(".per-right-three-bottom").html("<h1 style='font-size:25px;text-align:center;margin-top:20px;'>无数据</h1>");
					}
			},
			async:true
		});	
	}
}

$(function() {
	$(".per-left-ul>li").hover(function() {
		$(this).css("border-bottom"," 1px solid #9A9A9A").prev().css("border-bottom"," 1px solid #9A9A9A").siblings().css("border-bottom"," 1px solid #FFFFFF");
	    $(this).css("border-bottom"," 1px solid #9A9A9A");
	})
		$(".per-left-ul>li:eq(0)").hover(function() {
		$(this).css("border-bottom"," 1px solid #9A9A9A").siblings().css("border-bottom"," 1px solid #FFFFFF");
	})
});

$(function() {
	$(".per-left-ul>li:eq(0)").hover(function() {
		$(".per-right-one").show().siblings().hide();
	})
	$(".per-left-ul>li:eq(1)").hover(function() {
		$(".per-right-two").show().siblings().hide();
	})
	$(".per-left-ul>li:eq(2)").hover(function() {
		$(".per-right-three").show().siblings().hide();
	})
	$(".per-left-ul>li:eq(3)").hover(function() {
		$(".per-right-four").show().siblings().hide();
	})
	
	
});


</script>
</body>
<style type="text/css">
	.per-right-one-ul-subject{
		margin-left: 25px;
	}
</style>
</html>