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
					
					<form action="posthost/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="POSTHOST_ID" id="POSTHOST_ID" value="${pd.POSTHOST_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<%-- <tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">表自身id:</td>
								<td><input type="text" name="POSTHOSTID" id="POSTHOSTID" value="${pd.POSTHOSTID}" maxlength="50" placeholder="这里输入表自身id" title="表自身id" style="width:98%;"/></td>
							</tr> --%>
							<%-- <tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">postsrctable表id:</td>
								<td><input type="text" name="POSTSRCTABLEID" id="POSTSRCTABLEID" value="${pd.POSTSRCTABLEID}" maxlength="50" placeholder="这里输入postsrctable表id" title="postsrctable表id" style="width:98%;"/></td>
							</tr> --%>
							<%-- <tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">创建人:</td>
								<td><input type="text" name="CREATEUSER" id="CREATEUSER" value="${pd.CREATEUSER}" maxlength="50" placeholder="这里输入创建人" title="创建人" style="width:98%;"/></td>
							</tr> --%>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">模块名称</td>
								<td><input name="DESCRIBE" id="DESCRIBE" value="${pd.DESCRIBE}" type="text" /></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">模块类型</td>
								<td><input name="CONTENTTYPE" id="CONTENTTYPE" value="${pd.CONTENTTYPE}" type="number"  placeholder="请输入数字"/>
									<input name="STATUS" id="CONTENTTYPE" value="0" type="hidden"   />
									<input name="ISTRUE" id="CONTENTTYPE" value="0" type="hidden"   />
								</td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						<%-- <table id="table_report" class="table table-striped table-bordered table-hover"  >
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;" colspan="1">热帖标题1</td>
								<td><input name="DESCRIBE" id="DESCRIBE" value="${pd.DESCRIBE}" type="text" /></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">轮播图片1</td>
								<td><img alt="" src=""></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片跳转链接地址</td>
								<td><input name="DESCRIBE" id="DESCRIBE" value="${pd.DESCRIBE}" type="text" /></td>
							</tr>
							 
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table> --%>
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
			if($("#POSTHOSTID").val()==""){
				$("#POSTHOSTID").tips({
					side:3,
		            msg:'请输入表自身id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#POSTHOSTID").focus();
			return false;
			}
			if($("#POSTSRCTABLEID").val()==""){
				$("#POSTSRCTABLEID").tips({
					side:3,
		            msg:'请输入postsrctable表id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#POSTSRCTABLEID").focus();
			return false;
			}
			if($("#CREATEUSER").val()==""){
				$("#CREATEUSER").tips({
					side:3,
		            msg:'请输入创建人',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CREATEUSER").focus();
			return false;
			}
			if($("#CREATEDATA").val()==""){
				$("#CREATEDATA").tips({
					side:3,
		            msg:'请输入创建时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CREATEDATA").focus();
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