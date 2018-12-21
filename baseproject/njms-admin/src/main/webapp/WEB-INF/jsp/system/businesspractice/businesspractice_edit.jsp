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
					
					<form action="businesspractice/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="BUSINESSPRACTICE_ID" id="BUSINESSPRACTICE_ID" value="${pd.BUSINESSPRACTICE_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">实战标题:</td>
								<td><input type="text" name="TITLENAME" id="TITLENAME" value="${pd.TITLENAME}" maxlength="20" placeholder="这里输入实战标题" title="实战标题" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">项目数量:</td>
								<td><input type="number" name="PROJECTCOUNT" id="PROJECTCOUNT" value="${pd.PROJECTCOUNT}" maxlength="20" placeholder="这里输入实战项目数量" title="实战项目数量" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">最高月薪:</td>
								<td><input type="number" name="MAXSALARY" id="MAXSALARY" value="${pd.MAXSALARY}" maxlength="20" placeholder="这里输入最高就业月薪" title="最高就业月薪" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">平均月薪:</td>
								<td><input type="number" name="AVGSALARY" id="AVGSALARY" value="${pd.AVGSALARY}" maxlength="20" placeholder="这里输入平均就业月薪" title="平均就业月薪" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">就业率:</td>
								<td><input type="number" name="JOBPERCENT" id="JOBPERCENT" value="${pd.JOBPERCENT}" maxlength="10" placeholder="这里输入高薪就业率" title="高薪就业率" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参加实战:</td>
								<!-- <td><input type="text" name="STATE" id="STATE" value="${pd.STATE}" maxlength="2" placeholder="这里输入是否参加实战" title="是否参加实战" style="width:98%;"/></td> -->
								<td>
									<select  name="STATE" style="width:98%;">
										<option value="0">未参加实战</option>
										<option value="1">参加实战</option>
									</select>
								</td>
							</tr>
							<tr hidden="hidden">
								<td style="width:75px;text-align: right;padding-top: 13px;">创建人:</td>
								<td><input type="text" name="CREATEUSER" id="CREATEUSER" value="${pd.CREATEUSER}" maxlength="50" placeholder="这里输入创建人" title="创建人" style="width:98%;"/></td>
							</tr>
							<tr hidden="hidden">
								<td style="width:75px;text-align: right;padding-top: 13px;">创建时间:</td>
								<td><input class="span10 date-picker" name="CREATETIME" id="CREATETIME" value="${pd.CREATETIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="创建时间" title="创建时间" style="width:98%;"/></td>
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
			<!-- /.page-content   <fmt:formatDate value="${pd.CREATETIME}" pattern="yyyy-MM-dd hh:mm:ss"/> -->
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
			if($("#TITLENAME").val()==""){
				$("#TITLENAME").tips({
					side:3,
		            msg:'请输入实战标题',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TITLENAME").focus();
			return false;
			}
			if($("#PROJECTCOUNT").val()==""){
				$("#PROJECTCOUNT").tips({
					side:3,
		            msg:'请输入实战项目数量',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PROJECTCOUNT").focus();
			return false;
			}
			if($("#MAXSALARY").val()==""){
				$("#MAXSALARY").tips({
					side:3,
		            msg:'请输入最高就业月薪',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MAXSALARY").focus();
			return false;
			}
			if($("#AVGSALARY").val()==""){
				$("#AVGSALARY").tips({
					side:3,
		            msg:'请输入平均就业月薪',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#AVGSALARY").focus();
			return false;
			}
			if($("#JOBPERCENT").val()==""){
				$("#JOBPERCENT").tips({
					side:3,
		            msg:'请输入高薪就业率',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#JOBPERCENT").focus();
			return false;
			}
			if($("#STATE").val()==""){
				$("#STATE").tips({
					side:3,
		            msg:'请输入是否参加实战',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#STATE").focus();
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