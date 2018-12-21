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
					
					<form action="post/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="POST_ID" id="POST_ID" value="${pd.POST_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">帖子类型:</td>
								<td id="changePostType">
									<select class="chosen-select form-control" data-placeholder="请选择" id="POSTTYPE_ID" style="width: 98%;vertical-align:top;" name="POSTTYPE_ID">
										<option value=""></option>
										<c:forEach var="c" items="${allPostType}">
											<option value="${c.POSTTYPE_ID}"<c:if test="${c.POSTTYPE_ID==pd.POSTTYPE_ID}">selected</c:if>>${c.NAME}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">标题:</td>
								<td><input type="text" name="TITLE" id="TITLE" value="${pd.TITLE}" maxlength="255" placeholder="这里输入标题" title="标题" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">内容:</td>
								<td><input type="text" name="CONTENT" id="CONTENT" value="${pd.CONTENT}" maxlength="255" placeholder="这里输入内容" title="内容" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">用户:</td>
								<td id="changeUser">
									<select class="chosen-select form-control" data-placeholder="请选择" id="USER" style="width: 98%;vertical-align:top;" name="USER">
										<option value=""></option>
										<c:forEach var="c" items="${allUser}">
											<option value="${c.WD_USERS_ID}"<c:if test="${c.WD_USERS_ID==pd.USER}">selected</c:if>>${c.NICKNAME}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">下载附件:</td>
								<td><input type="text" name="DOWNLOADATTACHMENT" id="DOWNLOADATTACHMENT" value="${pd.DOWNLOADATTACHMENT }" maxlength="255" placeholder="这里输入下载附件" title="下载附件" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">发布版本:</td>
								<td>
									<input type="radio" name="RELEASEVERSION" id="computer" value="网页版" <c:if test="${pd.RELEASEVERSION=='网页版'}">checked="checked"</c:if><c:if test="${pd.RELEASEVERSION==null}">checked="checked"</c:if>/>网页版
									<input type="radio" name="RELEASEVERSION" id="phone" value="手机版" <c:if test="${pd.RELEASEVERSION=='手机版'}">checked="checked"</c:if>/>手机版
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注:</td>
								<td><input type="text" name="REMARKS" id="REMARKS" value="${pd.REMARKS}" maxlength="255" placeholder="这里输入备注" title="备注" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
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
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#TITLE").val()==""){
				$("#TITLE").tips({
					side:3,
		            msg:'请输入标题',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TITLE").focus();
			return false;
			}
			if($("#CONTENT").val()==""){
				$("#CONTENT").tips({
					side:3,
		            msg:'请输入内容',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CONTENT").focus();
			return false;
			}
			if($("#USER").val()==""){
				$("#changeUser").tips({
					side:3,
		            msg:'请选择用户',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#changeUser").focus();
			return false;
			}
			if($("#POSTTYPE_ID").val()==""){
				$("#changePostType").tips({
					side:3,
		            msg:'请选择帖子类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#changePostType").focus();
			return false;
			}
			if($("#DOWNLOADATTACHMENT ").val()==""){
				$("#DOWNLOADATTACHMENT ").tips({
					side:3,
		            msg:'请输入下载附件',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DOWNLOADATTACHMENT ").focus();
			return false;
			}
			
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
			
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