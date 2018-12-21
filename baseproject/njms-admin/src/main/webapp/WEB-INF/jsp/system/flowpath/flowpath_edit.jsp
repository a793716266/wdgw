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
<!-- 下拉框 -->
<link rel="stylesheet" href="static/ace/css/chosen.css" />
<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>
<!-- 日期框 -->
<link rel="stylesheet" href="static/ace/css/datepicker.css" />
<link rel="stylesheet" href="static/layui-v2.3.0/layui/css/layui.css" />
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
							<form action="flowpath/${msg }.do" name="Form" id="Form"
								method="post">
								<input type="hidden" name="FLOWPATH_ID" id="FLOWPATH_ID"
									value="${pd.FLOWPATH_ID}" />
									
								<input type="hidden" name="imageName" value="${pd.TITLEIMAGE}" />
								<input type="hidden" name="imageName1" value="${pd.image1}" />
								<input type="hidden" name="imageName2" value="${pd.image2}" />
								<input type="hidden" name="imageName3" value="${pd.image3}" />
										
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report"
										class="table table-striped table-bordered table-hover">
										<tr>
											<td
												style="width: 90px; text-align: right; padding-top: 13px;">标题图片:</td>
											<td><div class="layui-upload" id="pic">
													<button type="button"
														class="layui-btn layui-btn-normal layui-btn-sm" id="test">上传图片</button>
													<div class="layui-upload-list">
														<img class="layui-upload-img" id="demo"
															<c:if test="${upOrAdd =='up' }">src="${subjectImgPath }"</c:if>
															style="width: 80px; height: 80px">
														<p id="demoText"></p>
													</div>
												</div></td>
										</tr>
										<tr>
											<td
												style="width: 90px; text-align: right; padding-top: 13px;">标题描述:</td>
											<td>
											<input type="text" name="TEXTDESCRIBE" id="TEXTDESCRIBE" value="${pd.TEXTDESCRIBE}" maxlength="50" placeholder="这里输入标题描述" title="文本描述" style="width: 98%;" /></td>
										</tr>

										<tr>
											<td
												style="width: 80px; text-align: right; padding-top: 13px;">文本描述:</td>
											<td><input type="text" name="describeText" id="describeText" value="${pd.describeText}" maxlength="50" placeholder="这里输入文本描述" title="文本描述" style="width: 98%;" /></td>
										</tr>

										<tr>
											<td
												style="width: 90px; text-align: right; padding-top: 13px;">详情路径:</td>
											<td><input type="text" name="DETAILSURL" id="DETAILSURL" value="${pd.DETAILSURL}" maxlength="50" placeholder="这里输入详情路径" title="详情路径" style="width: 98%;" /></td>
										</tr>

										<tr>
											<td
												style="width: 90px; text-align: right; padding-top: 13px;">描述图片1:</td>
											<td>
												<div class="layui-upload" id="pic1">
													<button type="button"
														class="layui-btn layui-btn-normal layui-btn-sm" id="test1">上传图片</button>
													<div class="layui-upload-list">
														<img class="layui-upload-img" id="demo1"
															<c:if test="${upOrAdd =='up' }">src="${subjectImgPath1}"</c:if>
															style="width: 80px; height: 80px">
														<p id="demoText1"></p>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td
												style="width: 90px; text-align: right; padding-top: 13px;">描述图片2:</td>
											<td>
												<div class="layui-upload" id="pic2">
													<button type="button"
														class="layui-btn layui-btn-normal layui-btn-sm" id="test2">上传图片</button>
													<div class="layui-upload-list">
														<img class="layui-upload-img" id="demo2"
															<c:if test="${upOrAdd =='up' }">src="${subjectImgPath2}"</c:if>
															style="width: 80px; height: 80px">
														<p id="demoText2"></p>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td
												style="width: 90px; text-align: right; padding-top: 13px;">描述图片3:</td>
											<td>
												<div class="layui-upload" id="pic3">
													<button type="button"
														class="layui-btn layui-btn-normal layui-btn-sm" id="test3">上传图片</button>
													<div class="layui-upload-list">
														<img class="layui-upload-img" id="demo3"
															<c:if test="${upOrAdd =='up' }">src="${subjectImgPath3 }"</c:if>
															style="width: 80px; height: 80px">
														<p id="demoText3"></p>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td
												style="width: 90px; text-align: right; padding-top: 13px;">排序:</td>
											<td><input type="number" name="SORT" id="SORT" value="${pd.SORT}" onblur="sortUnqiue()" maxlength="100" placeholder="这里输入页面顺序" title="排序" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td
												style="width: 90px; text-align: right; padding-top: 13px;">备注:</td>
											<td><input type="text" name="REMARKS" id="REMARKS" value="${pd.REMARKS}" maxlength="100" placeholder="这里输入备注" title="备注" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10"><a
												class="btn btn-mini btn-primary" onclick="save();" id="save">保存</a>
												<a class="btn btn-mini btn-danger" id="removeit">取消</a></td>
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
		/* 排序的唯一性验证 */
		function sortUnqiue(){
			var SORT = $("#SORT").val();
			$.ajax({
				type:"post",
				url:"<%=basePath%>flowpath/ajaxSORTUnique",
				data : {
					SORT : SORT
				},
				success : function(json) {
					if (json.statu >= 1) {
						$("#SORT").tips({
							side : 1,
							msg : '该序号已存在',
							bg : '#AE81FF',
							time : 2
						});
						$("#save").attr("disabled", "disabled");
						$("#SORT").focus();
					} else {
						$("#save").removeAttr("disabled");
					}

				},
				async : true

			})
		}

		$(top.hangge());

		//标题图片
		layui
				.use(
						'upload',
						function() {
							var $ = layui.jquery, upload = layui.upload;
							//普通图片上传
							var uploadInst = upload
									.render({
										elem : '#test',
										url : 'upload/image/',
										data : {
											"kind" : ""
										},
										before : function(obj) {
											//预读本地文件示例，不支持ie8
											obj.preview(function(index, file,
													result) {
												$('#demo').attr('src', result); //图片链接（base64）
												
											});
										},
										done : function(res) {
											//如果上传失败
											if (res.code > 0) {
												return layer.msg('上传失败');
											}else{
												$("input[name='imageName']").val(res.image);
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

		//image1
		layui
				.use(
						'upload',
						function() {
							var $ = layui.jquery, upload = layui.upload;
							//普通图片上传
							var uploadInst = upload
									.render({
										elem : '#test1',
										url : 'upload/image1/',
										data : {
											"kind" : ""
										},
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
											}else{
												$("input[name='imageName1']").val(res.image1);
											}
											//上传成功
										},
										error : function() {
											//演示失败状态，并实现重传
											var demoText = $('#demoText1');
											demoText
													.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
											demoText.find('.demo-reload').on(
													'click', function() {
														uploadInst.upload();
													});
										}
									});
						})
		//image2
		layui
				.use(
						'upload',
						function() {
							var $ = layui.jquery, upload = layui.upload;
							//普通图片上传
							var uploadInst = upload
									.render({
										elem : '#test2',
										url : 'upload/image2/',
										data : {
											"kind" : ""
										},
										before : function(obj) {
											//预读本地文件示例，不支持ie8
											obj
													.preview(function(index,
															file, result) {
														$('#demo2').attr('src',
																result); //图片链接（base64）
													});
										},
										done : function(res) {
											//如果上传失败
											if (res.code > 0) {
												return layer.msg('上传失败');
											}else{
												$("input[name='imageName2']").val(res.image2);
											}
											//上传成功
										},
										error : function() {
											//演示失败状态，并实现重传
											var demoText = $('#demoText2');
											demoText
													.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
											demoText.find('.demo-reload').on(
													'click', function() {
														uploadInst.upload();
													});
										}
									});
						})

		//image3
		layui
				.use(
						'upload',
						function() {
							var $ = layui.jquery, upload = layui.upload;
							//普通图片上传
							var uploadInst = upload
									.render({
										elem : '#test3',
										url : 'upload/image3/',
										data : {
											"kind" : ""
										},
										before : function(obj) {
											//预读本地文件示例，不支持ie8
											obj
													.preview(function(index,
															file, result) {
														$('#demo3').attr('src',
																result); //图片链接（base64）
													});
										},
										done : function(res) {
											//如果上传失败
											if (res.code > 0) {
												return layer.msg('上传失败');
											}else{
												$("input[name='imageName3']").val(res.image3);
											}
											//上传成功
										},
										error : function() {
											//演示失败状态，并实现重传
											var demoText = $('#demoText3');
											demoText
													.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
											demoText.find('.demo-reload').on(
													'click', function() {
														uploadInst.upload();
													});
										}
									});
						})

		//保存
		function save() {
			//判断是否选中图片
			if ($('#demo').attr("src") == undefined) {
				$("#pic").tips({
					side : 3,
					msg : '请选择图片',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			if ($('#demo1').attr("src") == undefined) {
				$("#pic1").tips({
					side : 3,
					msg : '请选择图片',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			if ($('#demo2').attr("src") == undefined) {
				$("#pic2").tips({
					side : 3,
					msg : '请选择图片',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			if ($('#demo3').attr("src") == undefined) {
				$("#pic3").tips({
					side : 3,
					msg : '请选择图片',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}

			if ($("#TEXTDESCRIBE").val() == "") {
				$("#TEXTDESCRIBE").tips({
					side : 3,
					msg : '请输入文本描述',
					bg : '#AE81FF',
					time : 2
				});
				$("#TEXTDESCRIBE").focus();
				return false;
			}
			if ($("#DETAILSURL").val() == "") {
				$("#DETAILSURL").tips({
					side : 3,
					msg : '请输入详情路径',
					bg : '#AE81FF',
					time : 2
				});
				$("#DETAILSURL").focus();
				return false;
			}
			if ($("#SORT").val() == "") {
				$("#SORT").tips({
					side : 3,
					msg : '请输入页面排序',
					bg : '#AE81FF',
					time : 2
				});
				$("#SORT").focus();
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

			$("#removeit").click(function() {
				$.ajax({
					type : 'post',
					url : 'flowpath/removeit'
				})
				top.Dialog.close();
			})
		});
	</script>
</body>
</html>