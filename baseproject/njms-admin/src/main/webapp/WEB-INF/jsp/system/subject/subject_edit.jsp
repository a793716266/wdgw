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
<link rel="stylesheet" href="static/layui-v2.3.0/layui/css/layui.css"
	media="all">
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
							<form action="subject/${msg }.do" name="Form" id="Form"
								method="post">
								<input type="hidden" name="SUBJECT_ID" id="SUBJECT_ID"
									value="${pd.SUBJECT_ID}" />
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report"
										class="table table-striped table-bordered table-hover">
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">项目名:</td>
											<td><input type="text" name="SUBJECTNAME"
												id="SUBJECTNAME" value="${pd.SUBJECTNAME}" maxlength="255"
												placeholder="这里输入项目名" title="项目名" style="width: 98%;" /></td>
										</tr>
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
															style="width: 80px; height: 80px">
														<p id="demoText"></p>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>图片类型</td>
											<td id="changeBigOrSmall">
												<input id="big" type="radio" name="BIGORSMALL" value="0" title="大图" <c:if test="${pd.BIGORSMALL==0}">checked</c:if>>大图
												<input id="small" type="radio" name="BIGORSMALL" value="1" title="小图" style="margin-left: 30px"<c:if test="${pd.BIGORSMALL==1}">checked</c:if>>小图
											</td>
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
												style="width: 75px; text-align: right; padding-top: 13px;">备注:</td>
											<td><input type="text" name="REMARKS" id="REMARKS"
												value="${pd.REMARKS}" maxlength="255" placeholder="这里输入备注"
												title="备注" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10"><a
												class="btn btn-mini btn-primary" onclick="save();">保存</a> <a
												class="btn btn-mini btn-danger" id="removeit">取消</a></td>
										</tr>
									</table>
								</div>
								<div id="zhongxin2" class="center" style="display: none">
									<br /> <br /> <br /> <br /> <br /> <img
										src="static/images/jiazai.gif" /><br />
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
	<!--选择图片-->
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
										data : {
											kind : "subject"
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
			if ($('#demo1').attr("src") === undefined) {
				$("#pic").tips({
					side : 3,
					msg : '请选择图片',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			if ($("#SUBJECTNAME").val() == "") {
				$("#SUBJECTNAME").tips({
					side : 3,
					msg : '请输入项目名',
					bg : '#AE81FF',
					time : 2
				});
				$("#SUBJECTNAME").focus();
				return false;
			}
			if($('input:radio[name="BIGORSMALL"]:checked').val()===undefined){
				$('#changeBigOrSmall').tips({
					side : 3,
					msg : '请选择图片类型',
					bg : '#AE81FF',
					time : 2
				});
				$('#changeBigOrSmall').focus();
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
					url : 'subject/removeit'
				})
				top.Dialog.close();
			})
		});
	</script>
</body>
</html>