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
<!--图片上传  -->
<link rel="stylesheet" href="static/lunboimge/css/home.css" />
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
					
					<form action="foot/${msg }.do" name="Form" id="Form" method="post" enctype="multipart/form-data"  modelAttribute="PageData">
						<input type="hidden" name="FOOT_ID" id="FOOT_ID" value="${pd.FOOT_ID}"/>
						<div align="center" style="width: 310px; margin: 0px auto;">
							<!-- 图片路径 -->
							<div class="aui-content-img-box aui-content-full">
								<div class="aui-photo aui-up-img clear">
									<input type="file" id="myfile" name="myfile" style="display: none;" onchange="myupload(this)" accept="image/*"> <img id="priImage" name="priImage"	style="display: inline-block; border: 0; float: left;" width="130px" height="130px" <c:if test="${pd.LOGO!=null&&pd.LOGO!=''}">src="${pd.LOGO }" </c:if> />
									<img type="image" id="mypri" class="add-img"
										style="cursor: pointer;" title="标志图片上传" width="130px"
										height="130px" src="static/lunboimge/img/up.png"
										onclick="$('#myfile').click();" >
								</div>
							</div>
						</div>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
<!-- 			 				<tr> -->
<!-- 								<td style="width:75px;text-align: right;padding-top: 13px;">资源标志:</td> -->
<%-- 								<td><input type="text" name="LOGO" id="LOGO" value="${pd.LOGO}" maxlength="255" placeholder="这里输入资源标志" title="资源标志" style="width:98%;"/></td> --%>
<!-- 							</tr> -->
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">资源内容:</td>
								<td><input type="text" name="COUNT" id="COUNT" value="${pd.COUNT}" maxlength="255" placeholder="这里输入资源内容" title="资源内容" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">资源名称:</td>
								<td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="255" placeholder="这里输入资源名称" title="资源名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">资源路径:</td>
								<td><input type="text" name="RESPATH" id="RESPATH" value="${pd.RESPATH}" maxlength="255" placeholder="这里输入资源路径" title="资源路径" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注:</td>
								<td><input type="text" name="REMARKS" id="REMARKS" value="${pd.REMARKS}" maxlength="255" placeholder="这里输入备注" title="备注" style="width:98%;"/></td>
							</tr>
<!-- 							<tr> -->
<!-- 								<td style="width:75px;text-align: right;padding-top: 13px;">创建时间:</td> -->
<%-- 								<td><input type="text" name="CREATETIME" id="CREATETIME" value="${pd.CREATETIME}" maxlength="255" placeholder="这里输入创建时间" title="创建时间" style="width:98%;"/></td> --%>
<!-- 							</tr> -->
<!-- 							<tr> -->
<!-- 								<td style="width:75px;text-align: right;padding-top: 13px;">创建人:</td> -->
<%-- 								<td><input type="text" name="CREATEUSER" id="CREATEUSER" value="${pd.CREATEUSER}" maxlength="255" placeholder="这里输入创建人" title="创建人" style="width:98%;"/></td> --%>
<!-- 							</tr> -->
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
		//预览图片
		function myupload(obj) {
			var file = obj.files[0];
			var reader = new FileReader();
			//读取文件过程方法
			reader.onload = function(e) {
				var img = document.getElementById("priImage");
				img.src = e.target.result;
				url = window.URL.createObjectURL(file);
			}
			reader.readAsDataURL(file)
		}
		//保存
		function save(){
			if($("#LOGO").val()==""){
				$("#LOGO").tips({
					side:3,
		            msg:'请输入资源标志',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LOGO").focus();
			return false;
			}
			if($("#COUNT").val()==""){
				$("#COUNT").tips({
					side:3,
		            msg:'请输入资源内容',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#COUNT").focus();
			return false;
			}
			if($("#NAME").val()==""){
				$("#NAME").tips({
					side:3,
		            msg:'请输入资源名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#NAME").focus();
			return false;
			}
// 			if($("#REMARKS").val()==""){
// 				$("#REMARKS").tips({
// 					side:3,
// 		            msg:'请输入备注',
// 		            bg:'#AE81FF',
// 		            time:2
// 		        });
// 				$("#REMARKS").focus();
// 			return false;
// 			}
// 			if($("#CREATETIME").val()==""){
// 				$("#CREATETIME").tips({
// 					side:3,
// 		            msg:'请输入创建时间',
// 		            bg:'#AE81FF',
// 		            time:2
// 		        });
// 				$("#CREATETIME").focus();
// 			return false;
// 			}
// 			if($("#CREATEUSER").val()==""){
// 				$("#CREATEUSER").tips({
// 					side:3,
// 		            msg:'请输入创建人',
// 		            bg:'#AE81FF',
// 		            time:2
// 		        });
// 				$("#CREATEUSER").focus();
// 			return false;
// 			}
			if($("#RESPATH").val()==""){
				$("#RESPATH").tips({
					side:3,
		            msg:'请输入资源路径',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RESPATH").focus();
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