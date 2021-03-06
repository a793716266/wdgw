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
					
					<form action="studentinfo/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="STUDENTINFO_ID" id="STUDENTINFO_ID" value="${pd.STUDENTINFO_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">学员姓名:</td>
								<td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="255" placeholder="这里输入学员姓名" title="学员姓名" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">公司名称:</td>
								<td><input type="text" name="COMPANYNAME" id="COMPANYNAME" value="${pd.COMPANYNAME}" maxlength="255" placeholder="这里输入公司名称" title="公司名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">就业薪资:</td>
								<td><input type="number" name="SALARY" id="SALARY" value="${pd.SALARY}" maxlength="32" placeholder="这里输入就业薪资" title="就业薪资" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">就业时间:</td>
								<td><input type="date" name="GETJOBTIME" id="GETJOBTIME" value="${pd.GETJOBTIME}"  placeholder="这里输入就业时间" title="就业时间" style="width:98%;height:30px"/></td>
							</tr>
							<tr style="display: none">
								<td style="width:90px;text-align: right;padding-top: 13px;">创建时间:</td>
								<td><input class="span10 date-picker" name="CREATETIME" id="CREATETIME" value="${pd.CREATETIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="创建时间" title="创建时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">创建用户:</td>
								<td><input type="text" name="CREATEUSER" id="CREATEUSER" value="${USERNAME}" maxlength="255" readonly="readonly" title="创建用户" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">备注:</td>
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
			if($("#NAME").val()==""){
				$("#NAME").tips({
					side:3,
		            msg:'请输入学员姓名',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#NAME").focus();
			return false;
			}
			if($("#COMPANYNAME").val()==""){
				$("#COMPANYNAME").tips({
					side:3,
		            msg:'请输入公司名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#COMPANYNAME").focus();
			return false;
			}
			if($("#SALARY").val()==""){
				$("#SALARY").tips({
					side:3,
		            msg:'请输入就业薪资',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SALARY").focus();
			return false;
			}
			if($("#GETJOBTIME").val()==""){
				$("#GETJOBTIME").tips({
					side:3,
		            msg:'请输入就业时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GETJOBTIME").focus();
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