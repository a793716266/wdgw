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
					
					<form action="datadownload/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="DATADOWNLOAD_ID" id="DATADOWNLOAD_ID" value="${pd.DATADOWNLOAD_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">资料名称:</td>
								<td><input type="text" name="DATANAME" id="DATANAME" value="${pd.DATANAME}" maxlength="255" placeholder="这里输入资料名称" title="资料名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">资料大小:</td>
								<td>
									<input type="text" name="DATASIZE" id="DATASIZE" value="${pd.DATASIZE}" maxlength="20" placeholder="这里输入资料大小" title="资料大小" style="width:75%;display: inline;"/>
									<select class="chosen-select form-control" name="suffix" data-placeholder="请选择" style="vertical-align:top;width: 69px;height:30px;display: inline;">
										<option value="KB">KB</option>
										<option value="M">M</option>
										<option value="G">G</option>
								   </select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">网盘下载:</td>
								<td>
									<input type="text" name="KANBOXURL" id="KANBOXURL" value="${pd.KANBOXURL}" maxlength="100" placeholder="这里输入网盘下载地址" title="网盘下载" style="width:85%;"/>
									<input type="button" value="提示" title="网址格式：https://pan.baidu.com/" style="height:30px; border:none; "></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">查看介绍:</td>
								<td><input type="text" name="LOOKINTRODUCEURL" id="LOOKINTRODUCEURL" value="${pd.LOOKINTRODUCEURL}" maxlength="100" placeholder="这里输入查看介绍链接" title="查看介绍" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">下载次数:</td>
								<td><input type="number" name="DOWNLOADCOUNT" id="DOWNLOADCOUNT" value="${pd.DOWNLOADCOUNT}" maxlength="32" placeholder="这里输入下载次数" title="下载次数" style="width:98%;"/></td>
							</tr>
							<tr hidden="hidden">
								<td style="width:75px;text-align: right;padding-top: 13px;">创建人:</td>
								<td><input type="text" name="CREATEUSER" id="CREATEUSER" value="${pd.CREATEUSER}" maxlength="100" placeholder="这里输入创建人" title="创建人" style="width:98%;"/></td>
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
			if($("#DATANAME").val()==""){
				$("#DATANAME").tips({
					side:3,
		            msg:'请输入资料名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DATANAME").focus();
			return false;
			}
			//验证资料大小
			var datasize = $("#DATASIZE").val();
			var regex =  /^[0-9]+([.]{1}[0-9]+){0,1}$/;
			if(!regex.test(datasize)){
				$("#DATASIZE").tips({
					side:3,
		            msg:'资料输入为空或有误',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DATASIZE").focus();
			return false;
			}
			//验证百度网盘的网址
			var kanboxurl = $("#KANBOXURL").val();
			var reg = /^((https|http|ftp|rtsp|mms)?:\/\/)[^\s]+$/;
			if(!reg.test(kanboxurl)){
				$("#KANBOXURL").tips({
					side:3,
		            msg:'网址不能为空或格式输入错误',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#KANBOXURL").focus();
			return false;
			}
			//验证查看介绍地址 
			var lookintroduceurl = $("#LOOKINTRODUCEURL").val();
			var lookReg = /^((https|http|ftp|rtsp|mms)?:\/\/)[^\s]+$/;
			if(!lookReg.test(lookintroduceurl)){
				$("#LOOKINTRODUCEURL").tips({
					side:3,
		            msg:'查看介绍地址格式有误',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LOOKINTRODUCEURL").focus();
			return false;
			} 
			
			//验证下载次数不能输入负数
			var downloadcount = $("#DOWNLOADCOUNT").val();
			var count = /^[+]{0,1}(\d+)$/;
			if($("#DOWNLOADCOUNT").val()=="" || !count.test(downloadcount)){
				$("#DOWNLOADCOUNT").tips({
					side:3,
		            msg:'下载次数不能为空或输入有误',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DOWNLOADCOUNT").focus();
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