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
					
					<form action="learnapplypersonal/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="LEARNAPPLYPERSONAL_ID" id="LEARNAPPLYPERSONAL_ID" value="${pd.LEARNAPPLYPERSONAL_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">学习课程:</td>
								<td><input type="text" name="LEARNTYPE" id="LEARNTYPE" value="${pd.LEARNTYPE}" maxlength="255" placeholder="这里输入学习课程" title="学习课程" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">申请班级:</td>
								<td><input type="text" name="APPLYCLASS" id="APPLYCLASS" value="${pd.APPLYCLASS}" maxlength="255" placeholder="这里输入申请班级" title="申请班级" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">联系方式:</td>
								<td><input type="text" name="APPLYPHONE" id="APPLYPHONE" value="${pd.APPLYPHONE}" maxlength="255" placeholder="这里输入联系方式" title="联系方式" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">申请时间:</td>
								<td><input class="span10 date-picker" name="APPLYDATE" id="APPLYDATE" value="${pd.APPLYDATE}" type="text" data-date-format="yyyy-mm-dd" disabled="disabled" readonly="readonly" placeholder="申请时间" title="申请时间" style="width:98%;"/></td>
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
			if($("#LEARNTYPE").val()==""){
				$("#LEARNTYPE").tips({
					side:3,
		            msg:'请输入学习课程',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LEARNTYPE").focus();
			return false;
			}
			if($("#APPLYCLASS").val()==""){
				$("#APPLYCLASS").tips({
					side:3,
		            msg:'请输入申请班级',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#APPLYCLASS").focus();
			return false;
			}
			if($("#APPLYPHONE").val()==""){
				$("#APPLYPHONE").tips({
					side:3,
		            msg:'请输入联系方式',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#APPLYPHONE").focus();
			return false;
			}
			if($("#APPLYDATE").val()==""){
				$("#APPLYDATE").tips({
					side:3,
		            msg:'请输入申请时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#APPLYDATE").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>