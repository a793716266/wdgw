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

							<form action="comment/${msg }.do" name="Form" id="Form"
								method="post">
								<input type="hidden" name="COMMENT_ID" id="COMMENT_ID"
									value="${pd.COMMENT_ID}" />
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report"
										class="table table-striped table-bordered table-hover">
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">评论用户:</td>
											<td id="connmentUser">
												<select class="chosen-select form-control" data-placeholder="请选择" id="COMMENTUSER" style="width: 98%;vertical-align:top;" name="COMMENTUSER">
													<option value=""></option>
													<c:forEach var="c" items="${WDUsers }">
														<option value="${c.WD_USERS_ID}"<c:if test="${pd.COMMENTUSER==c.WD_USERS_ID }">selected</c:if>>${c.ACCOUNTNUMBER}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">评论内容:</td>
											<td><input type="text" name="CONTENT" id="CONTENT"
												value="${pd.CONTENT}" maxlength="255" placeholder="这里输入评论内容"
												title="评论内容" style="width: 98%;" /></td>
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
												class="btn btn-mini btn-danger"
												onclick="top.Dialog.close();">取消</a></td>
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
	<script type="text/javascript">
		$(top.hangge());
		//保存
		function save() {
			if ($("#COMMENTUSER").val() == "") {
				$("#connmentUser").tips({
					side : 3,
					msg : '请输入评论用户',
					bg : '#AE81FF',
					time : 2
				});
				$("#COMMENTUSER").focus();
				return false;
			}
			if ($("#CONTENT").val() == "") {
				$("#CONTENT").tips({
					side : 3,
					msg : '请输入评论内容',
					bg : '#AE81FF',
					time : 2
				});
				$("#CONTENT").focus();
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
						 $this.next().css({'width': "98%"});
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
		});
	</script>
</body>
</html>