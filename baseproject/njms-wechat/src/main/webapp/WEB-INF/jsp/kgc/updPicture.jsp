<%@  taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<%@include file="../common/common-header.jsp"%>


<!--中部-->
<div class="pic-zong" >
		<div class="pic-center">
			<div class="pic-name">
				<span class="name"><%=session.getAttribute("userNickName") %></span>
				<span class="updName" onclick="showUpdateNN()" style="cursor:pointer">
					<button type="button" class="layui-btn">
					<input type="text" value="" id="wd_users_id" style="display:none">
  						<i class="layui-icon"></i>修改昵称
					</button>
				</span>
				<span style="display:none" class="NNval"><input type="text" class="changeName" maxlength="8" value="<%=session.getAttribute("userNickName") %>"  /></span>
				<span class="upNName" style="display:none;cursor:pointer" onclick="UpdateNN()">
					<button type="button" class="layui-btn">
					<input type="hidden" id="userid" value="${wd_users_id}"/>
					<input type="hidden" id="userphone" value="${userphone}"/>
					<input type="text" value="" id="wd_users_id" style="display:none">
  						<i class="layui-icon"></i>保存
					</button>
				</span>
				<span class="cc" style="display:none;cursor:pointer" onclick="cancel()">
					<button type="button" class="layui-btn">
					<input type="text" value="" id="wd_users_id" style="display:none">
  						<i class="layui-icon"></i>取消
					</button>
				</span>
			</div>
			<hr class="right-hr" />
			<div class="pic-photo">
					<img alt="" src="<%=session.getAttribute("picture") %>" class="picture">
			
				<span class="updPic" style="cursor:pointer">
					<button type="button" class="layui-btn" id="test1">
					<input type="text" name="wd_users_id" value="" id="wd_users_id" style="display:none">
  						<i class="layui-icon"></i>修改头像
					</button>
				</span>
			</div>
			<hr class="right-hr" />
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
 <script src="<%=basePath%>static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">


/* var data=${not empty sessionScope.userph?sessionScope.userph:0}; */
 


function showUpdateNN(){
	$(".name").css("display","none");
	$(".updName").css("display","none");
	$(".NNval").css("display","");
	$(".upNName").css("display","");
	$(".cc").css("display","");
	
}
function cancel(){
	$(".NNval").css("display","none");
	$(".upNName").css("display","none");
	$(".cc").css("display","none");
	$(".name").css("display","");
	$(".updName").css("display","");
}
function UpdateNN(){
	var nickName=$(".changeName").val();
	if(nickName==''){
		alert("请输入昵称!");
		return;
	} 
	window.location.href = encodeURI(encodeURI("wd/updateNickName.do?nickname=" + nickName)) ;
}

/**
 * 修改头像
 */
 var userid  = $("#userid").val();
 var userphone = $("#userphone").val();
layui.use('upload', function(){
  var upload = layui.upload;
  
  //执行实例
  var uploadInst = upload.render({
    elem: '#test1' //绑定元素
    ,url: 'wd/tofile.do?wd_users_id='+userid //上传接口
    ,done: function(res){
    $(".picture").attr("src",res.newpicture);
    $(".portrait").css("background-image","url("+res.newpicture+")")
   		alert(res.msg);
    	window.location.href = "wd/picture.do?userphone="+userphone;
    }
    ,error: function(){
      //请求异常回调
    }
  });
});


</script>

</body>

</html>