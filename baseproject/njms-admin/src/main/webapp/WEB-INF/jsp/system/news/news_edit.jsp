<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/index/top.jsp"%>
	<!--富文本样式-->
	<link rel="stylesheet" href="plugins/ueditor/themes/default/css/ueditor.css"/>
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
					<form action="news/${msg }.do" name="Form" id="Form" method="post" enctype="multipart/form-data" modelAttribute="PageData">
						<input type="hidden" name="NEWS_ID" id="NEWS_ID" value="${pd.NEWS_ID}"/>
						
						<div align="center" style="width: 310px; margin: 0px auto;">
									<!-- 图片路径 -->
							<div class="aui-content-img-box aui-content-full">
								<div class="aui-photo aui-up-img clear">
									<input type="file" id="myfile" name="myfile" style="display:none;" onchange="myupload(this)" accept="image/*"   />
									<img  id="priImg" name="priImg" style="display:inline-block;border:0; float: left;"  width="130px" height="130px" onload="controlSize(this)" <c:if test="${pd.PICTURENAME != null&&pd.PICTURENAME!=''}"> src="${pd.PICTURENAME}" </c:if> /> 
									<img  type="image" value="${pd.PICTURENAME}" name="image" id="image" class="add-img" width="130px" height="130px" src="static/lunboimge/img/up.png" onclick="$('#myfile').click();" >
								</div>
							</div>
						</div>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">新闻标题:</td>
								<td><input type="text" name="NEWTITLE" id="NEWTITLE" value="${pd.NEWTITLE}" maxlength="255" placeholder="这里输入新闻标题" title="新闻标题" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">新闻内容:</td>
								<td>
									<script id="myEditor" type="text/plain" style="width:750px;height: 300px" name="NEWCONTENT" value="${pd.NEWCONTENT}"></script>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">新闻类型:</td>
								<td style="vertical-align:top;padding-left:2px;">
								 	<select class="chosen-select form-control" name="type" id="type" data-placeholder="请选择新闻类型" style="vertical-align:top;width: 120px;">
										<c:forEach items="${list}" var="n">
									 			<option value="${n.TYPE}" <c:if test="${pd.NEWSTYPE == n.TYPE}">selected="selected"</c:if> >${n.TYPE}</option>
										</c:forEach>
								  	</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">作者:</td>
								<td><input type="text" name="AUTHOR" id="AUTHOR" <c:if test="${pd.AUTHOR!=''}">value="${pd.AUTHOR}"</c:if> maxlength="255" placeholder="这里输入作者" title="作者" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">来源:</td>
								<td><input type="text" name="ORIGIN" id="ORIGIN" <c:if test="${pd.ORIGIN!=''}">value="${pd.ORIGIN}"</c:if>  maxlength="255" placeholder="这里输入来源" title="来源" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">点击量:</td>
								<td><input type="text" name="CLICKS" id="CLICKS"  <c:if test="${pd.CLICKS!=''}">value="${pd.CLICKS}"</c:if> maxlength="255" placeholder="这里输入点击量" title="点击量" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">发表时间:</td>
								<td style="padding-left:2px;">
									<input type="text" value="${pd.CREATETIME}" id="CREATETIME" name="CREATETIME" placeholder="发表日期" title="发表日期" readonly="readonly"  placeholder="发表日期" title="发表日期"/>
								</td>
							</tr>
							
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" id="save">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
<!-- 	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script> -->
	<script type="text/javascript" src="static/ace/laydate/laydate.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<!--富文本-->
	<script src="plugins/ueditor/ueditor.config.js"></script>
	<script src="plugins/ueditor/ueditor.all.js"></script>
	<script src="plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
		$(top.hangge());
		//预览图片
		function myupload(obj) {
			var file = obj.files[0];
	           var reader = new FileReader();
	           //读取文件过程方法
	           reader.onload = function (e) {
	               var img = document.getElementById("priImg");
	               img.src = e.target.result;
	               url = window.URL.createObjectURL(file);
	           }
	           reader.readAsDataURL(file)
		}

		//保存
		$("#save").click(function(){
			
			if($('#priImg').attr("src")===undefined){
				alert("请选择上传图片");
				return false;
			}
			if($("#NEWTITLE").val()==""){
				alert("请输入新闻标题");
				return false;
			}
			
			var ue = UE.getEditor('myEditor');
			var context=ue.getContent();//获取新闻内容
			if(context==""){
				alert("请输入新闻内容");
			return false;
			}
			if($("#NEWSTYPE").val()==""){
				$("#NEWSTYPE").tips({
					side:3,
		            msg:'请输入新闻类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#NEWSTYPE").focus();
			return false;
			}
			//作者 
			if($("#AUTHOR").val()==""){
				$("#AUTHOR").tips({
					side:3,
		            msg:'请输入新闻作者',
		            bg:'#AE81FF',
		            time:2
		        });
			return false;
			}
			//来源
			if($("#ORIGIN").val()==""){
				$("#ORIGIN").tips({
					side:3,
		            msg:'请输入新闻来源',
		            bg:'#AE81FF',
		            time:2
		        });
			return false;
			}
			//发布时间
			if($("#CREATETIME").val()==""){
				$("#CREATETIME").tips({
					side:3,
		            msg:'请输入发布时间',
		            bg:'#AE81FF',
		            time:2
		        });
			return false;
			}
			//点击量
			var reCLICKS = /^[0-9]+.?[0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/
			if (!reCLICKS.test($("#CLICKS").val())) {
				$("#CLICKS").tips({
					side:3,
		            msg:'请输入正确的点击量',
		            bg:'#AE81FF',
		            time:2
		        });
			　　　　$("#CLICKS").val("0");
			　　　　return false;
			　　}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		});
		//时间
		laydate.render({
			  elem: '#CREATETIME' //指定元素
			  ,type: 'datetime'
		});
		
		var ue = UE.getEditor('myEditor');//初始化对象
		$(document).ready(function(){
			var ue = UE.getEditor('myEditor');
			var proinfo='${pd.NEWCONTENT}';
			ue.ready(function() {//编辑器初始化完成再赋值
				ue.setContent(proinfo);  //赋值给UEditor
			});
			
		});
	</script>
</body>
</html>