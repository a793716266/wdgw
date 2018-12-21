<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="static/layui-v2.3.0/layui/css/layui.css"
	media="all">
<!-- 下拉框 -->
<link rel="stylesheet" href="static/ace/css/chosen.css" />
<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>
<!-- 日期框 -->
<link rel="stylesheet" href="static/ace/css/datepicker.css" />
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

							<form action="video/${msg }.do" name="Form" id="Form"
								method="post">
								<input type="hidden" name="VIDEO_ID" id="VIDEO_ID"
									value="${pd.VIDEO_ID}" />
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report"
										class="table table-striped table-bordered table-hover">
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">图片:</td>
											<td>
												<div class="layui-upload" id="pic">
													<button type="button"
														class="layui-btn layui-btn-normal layui-btn-sm" id="test1">上传图片</button>
													<div class="layui-upload-list">
														<img class="layui-upload-img" id="demo1"
															<c:if test="${upOrAdd =='up' }">src="${subjectImgPath }"</c:if>
															style="width: 80px; height: 80px" onload="controlSize(this)">
														<p id="demoText"></p>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">老师:</td>
											<td id="teacherWarn">
												<select  class="chosen-select form-control" data-placeholder="请选择老师" id="TEACHER" style="width: 98%;vertical-align:top;" name="TEACHER">
													<option value=""></option>
													<c:forEach var="t" items="${teachers}">
														<option value="${t.NAME}" <c:if test="${pd.TEACHER==t.NAME }">selected</c:if>>${t.NAME}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">标题:</td>
											<td><input type="text" name="TITLE" id="TITLE"
												value="${pd.TITLE}" maxlength="255" placeholder="这里输入标题"
												title="标题" style="width: 98%;" /></td>
										</tr>
										
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">课程类型:</td>
											<td><select id="COURSE" style="width: 98%;"
												name="COURSE">
													<c:forEach var="c" items="${courses }">
														<option value="${c.C_TYPE}"
															<c:if test="${pd.COURSE==c.C_TYPE }">selected</c:if>>${c.C_TYPE}</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">是否免费:</td>
											<td>
												<select id="ISFREE" name="ISFREE" style="width: 98%;">
													<option value="免费" <c:if test="${pd.ISFREE}=='免费'">selected</c:if>>免费</option>
													<option value="收费" <c:if test="${pd.ISFREE}=='收费'">selected</c:if>>收费</option>
												</select>
											</td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">视频路径:</td>
											<td><input type="text" name="URL" id="URL"
												value="${pd.URL}" maxlength="255" placeholder="请输入视频路径(腾讯和优酷视频分享按钮可获得链接，复制即可)"
												title="视频路径" style="width: 98%;" onchange="getVideoUrl()" oninput="getVideoUrl()" /></td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">备注:</td>
											<td><input type="text" name="REMARKS" id="REMARKS"
												value="${pd.REMARKS}" maxlength="255" placeholder="这里输入备注"
												title="备注" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10"><a
												class="btn btn-mini btn-primary" onclick="save();">保存</a> <a
												class="btn btn-mini btn-danger"
												id="removeit">取消</a></td>
										</tr>
									</table>
								</div>
								<div id="zhongxin2" class="center" style="display: none">
									<br />
									<br />
									<br />
									<br />
									<br />
									<img src="static/images/jiazai.gif" /><br />
									<h4 class="lighter block green">提交中...</h4>
								</div>
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
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script src="static/layui-v2.3.0/layui/layui.js"></script>
	<script type="text/javascript">
		layui
				.use(
						'upload',
						function() {
							var $ = layui.jquery, upload = layui.upload;

							//普通图片上传
							var uploadInst = upload
									.render({
										elem : '#test1',
										url : 'upload/image/',
										data:{"kind":"video"},
										before : function(obj) {
											//预读本地文件示例，不支持ie8
											obj
													.preview(function(index,
															file, result) {
														$('#demo1').attr('src',
																result); //图片链接（base64）
													});
										},
										done : function(res) {
											//如果上传失败
											if (res.code > 0) {
												return layer.msg('上传失败');
											}
											//上传成功
										},
										error : function() {
											//演示失败状态，并实现重传
											var demoText = $('#demoText');
											demoText
													.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
											demoText.find('.demo-reload').on(
													'click', function() {
														uploadInst.upload();
													});
										}
									});
						})
		$(top.hangge());
		//保存
		function save() {
			if($('#demo1').attr("src")===undefined){
				$("#pic").tips({
					side : 3,
					msg : '请选择图片',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			if ($("#PICTURENAME").val() == "") {
				$("#PICTURENAME").tips({
					side : 3,
					msg : '请输入图片名',
					bg : '#AE81FF',
					time : 2
				});
				$("#PICTURENAME").focus();
				return false;
			}
			if ($("#TITLE").val() == "") {
				$("#TITLE").tips({
					side : 3,
					msg : '请输入标题',
					bg : '#AE81FF',
					time : 2
				});
				$("#TITLE").focus();
				return false;
			}
			if ($("#COURSE").val() == "") {
				$("#COURSE").tips({
					side : 3,
					msg : '请输入课程类型',
					bg : '#AE81FF',
					time : 2
				});
				$("#COURSE").focus();
				return false;
			}
			if ($("#ISFREE").val() == "") {
				$("#ISFREE").tips({
					side : 3,
					msg : '请输入是否免费',
					bg : '#AE81FF',
					time : 2
				});
				$("#ISFREE").focus();
				return false;
			}
			if ($("#TEACHER").val() == "") {
				$("#teacherWarn").tips({
					side : 3,
					msg : '请选择老师',
					bg : '#AE81FF',
					time : 2
				});
				$("#TEACHER").focus();
				return false;
			}
			if ($("#URL").val() == "") {
				$("#URL").tips({
					side : 3,
					msg : '请输入视频路径(腾讯和优酷视频分享按钮可获得链接，复制即可)',
					bg : '#AE81FF',
					time : 2
				});
				$("#URL").focus();
				return false;
			}
			
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}

		$(function() {
			//日期框
			$('.date-picker').datepicker({
				autoclose : true,
				todayHighlight : true
			});
			
			//下拉框
			if(!ace.vars['touch']) {
				$('.chosen-select').chosen({allow_single_deselect:true}); 
				$(window)
				.off('resize.chosen')
				.on('resize.chosen', function() {
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					});
				}).trigger('resize.chosen');
				$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
					if(event_name != 'sidebar_collapsed') return;
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					});
				});
				$('#chosen-multiple-style .btn').on('click', function(e){
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
					 else $('#form-field-select-4').removeClass('tag-input-style');
				});
			}
			
			
			$("#removeit").click(function(){
				$.ajax({
					type:'post',
					url:'video/removeit'
				})
				top.Dialog.close();
			})
		});
		
		function getVideoUrl(){
			let fullUrl = $("#URL").val();
			if(fullUrl.indexOf("imgcache.qq.com/tencentvideo") > -1){
				let indexStart = fullUrl.indexOf("vid=");
				while(fullUrl.indexOf('&') > -1){
					let i = fullUrl.indexOf('&');
					if(i > indexStart){
						fullUrl = fullUrl.substring(indexStart,i)
						$("#URL").val("qq"+fullUrl);
						indexEnd = i;
						break;
					}
					fullUrl = fullUrl.substring(i+1)
					indexStart = fullUrl.indexOf("vid=");
				}
			}else if(fullUrl.indexOf("http://player.youku.com") > -1){
				let indexStart = fullUrl.indexOf("sid/");
				while(fullUrl.indexOf('/') > -1){
					let i = fullUrl.indexOf('/');
					if(i > indexStart){
						fullUrl = fullUrl.substring(indexStart,fullUrl.indexOf("==/v.swf"));
						$("#URL").val("youku"+fullUrl.replace('/','='));
						indexEnd = i;
						console.log(fullUrl)
						break;
					}
					fullUrl = fullUrl.substring(i+1)
					console.log(fullUrl)
					indexStart = fullUrl.indexOf("sid/");
				}
			}
		}
	</script>
</body>
</html>