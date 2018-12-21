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
					
					<form action="employmentclass/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="EMPLOYMENTCLASS_ID" id="EMPLOYMENTCLASS_ID" value="${pd.EMPLOYMENTCLASS_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">班级编号:</td>
								<td><input type="text" name="CLASSNAME" id="CLASSNAME" value="${pd.CLASSNAME}" maxlength="255" placeholder="这里输入班级名称" title="班级名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90;text-align: right;padding-top: 13px;">班级类型:</td>
								<td style="vertical-align:top;padding-left:2px;">
								 	<select class="chosen-select form-control" name="CLASSTYPE" id="CLASSTYPE" data-placeholder="请选择课程类型" style="vertical-align:top;width: 98%;">
									<c:forEach items="${varList1}" var="varList">
										<option value="${varList.CLASSTYPENAME}" <c:if test="${pd.CLASSTYPE==varList.CLASSTYPENAME}">selected</c:if>>${varList.CLASSTYPENAME}</option>
									</c:forEach>
								  	</select>
								</td>
							</tr>
							<tr>
								<td style="width:90;text-align: right;padding-top: 13px;">最高薪资:</td>
								<td><input type="text" name="MAXSALARY" id="MAXSALARY" value="${pd.MAXSALARY}" maxlength="32" placeholder="这里输入最高薪资" title="最高薪资" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90;text-align: right;padding-top: 13px;">平均薪资:</td>
								<td><input type="text" name="AVGSALARY" id="AVGSALARY" value="${pd.AVGSALARY}" maxlength="32" placeholder="这里输入平均薪资" title="平均薪资" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90;text-align: right;padding-top: 13px;">教员:</td>
								<td><input type="text" name="TEACHERS" id="TEACHERS" value="${pd.TEACHERS}" maxlength="255" placeholder="这里输入教员" title="教员" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90;text-align: right;padding-top: 13px;">班主任:</td>
								<td><input type="text" name="CLASSCHARGE" id="CLASSCHARGE" value="${pd.CLASSCHARGE}" maxlength="255" placeholder="这里输入班主任" title="班主任" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90;text-align: right;padding-top: 13px;">课程类型:</td>
								<td style="vertical-align:top;padding-left:2px;">
								 	<select class="chosen-select form-control" name="C_TYPE" id="C_TYPE" data-placeholder="请选择课程类型" style="vertical-align:top;width: 98%;">
									<c:forEach items="${varList2}" var="varList">
										<option value="${varList.C_TYPE}" <c:if test="${pd.C_TYPE==varList.C_TYPE}">selected="selected"</c:if>>${varList.C_TYPE}</option>
									</c:forEach>
								  	</select>
								</td>
							</tr>
							<tr>
								<td style="width:90;text-align: right;padding-top: 13px;">日制类型:</td>
								<td><input type="text" name="SYSTEMTYPE" id="SYSTEMTYPE" value="${pd.SYSTEMTYPE}" maxlength="255" placeholder="这里输入日制类型" title="日制类型" style="width:98%;"/></td>
							</tr>
							<tr style="display: none">
								<td style="width:90;text-align: right;padding-top: 13px;">创建日期:</td>
								<td><input  class="span10 date-picker" name="CREATETIME" id="CREATETIME" value="${pd.CREATETIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="创建日期" title="创建日期" style="width:98%;"/></td>
							</tr>
							<tr style="display: none">
								<td style="width:90;text-align: right;padding-top: 13px;">创建人:</td>
								<td><input type="text" name="CREATEUSER" id="CREATEUSER" value="${USERNAME}" maxlength="255" title="创建人" style="width:98%;" readonly="readonly"/></td>
							</tr>
							<tr>
								<td style="width:90;text-align: right;padding-top: 13px;">备注:</td>
								<td><input type="text" name="REMARKS" id="REMARKS" value="${pd.REMARKS}" maxlength="255" placeholder="这里输入备注" title="备注" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" id="tit" onclick="save();">${title}</a>
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
			var MAXSALARY = $("#MAXSALARY").val();
			var AVGSALARY = $("#AVGSALARY").val();
			if(MAXSALARY<0){
				alert("最高薪资不可以小于0！");
				return;
			}
			if(AVGSALARY<0){
				alert("平均薪资不可以小于0！");
				return;
			}
			if($("#CLASSNAME").val()==""){
				$("#CLASSNAME").tips({
					side:3,
		            msg:'请输入班级班级编号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CLASSNAME").focus();
			return false;
			}
			if($("#CLASSTYPE").val()==""){
				$("#CLASSTYPE").tips({
					side:3,
		            msg:'请输入班级类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CLASSTYPE").focus();
			return false;
			}
			if($("#MAXSALARY").val()==""){
				$("#MAXSALARY").tips({
					side:3,
		            msg:'请输入最高薪资',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MAXSALARY").focus();
			return false;
			}
			if($("#AVGSALARY").val()==""){
				$("#AVGSALARY").tips({
					side:3,
		            msg:'请输入平均薪资',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#AVGSALARY").focus();
			return false;
			}
			if($("#TEACHERS").val()==""){
				$("#TEACHERS").tips({
					side:3,
		            msg:'请输入教员',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TEACHERS").focus();
			return false;
			}
			if($("#CLASSCHARGE").val()==""){
				$("#CLASSCHARGE").tips({
					side:3,
		            msg:'请输入班主任',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CLASSCHARGE").focus();
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
		
		$(function(){
			var tit = $("#tit").html();
			$("#CLASSNAME").change(function() {
				var className=$("#CLASSNAME").val();
				var EMPLOYMENTCLASS_ID=$("#EMPLOYMENTCLASS_ID").val();
				if($("#CLASSNAME").val()==""){
					$("#CLASSNAME").tips({
						side:3,
			            msg:'请输入班级班级编号',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#CLASSNAME").focus();
				return;
				}
				$.post(
					"employmentclass/validationClassName",
					"EMPLOYMENTCLASS_ID="+EMPLOYMENTCLASS_ID+"&title="+tit+"&CLASSNAME="+className,
					function(rtn) {
						var info = rtn.errInfo;
						if(info!=undefined){
							$("#CLASSNAME").tips({
								side:3,
					            msg:info,
					            bg:'#AE81FF',
					            time:2
					        });
							$("#CLASSNAME").val("");
							$("#CLASSNAME").focus();
						}
					},
					"json"
				);
			});
		});
		</script>
</body>
</html>