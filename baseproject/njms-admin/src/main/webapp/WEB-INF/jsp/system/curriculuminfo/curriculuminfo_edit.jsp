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

							<form action="curriculuminfo/${msg }.do" name="Form" id="Form"
								method="post" enctype="multipart/form-data"  modelAttribute="PageData">
								<input type="hidden" name="CURRICULUMINFO_ID"
									id="CURRICULUMINFO_ID" value="${pd.CURRICULUMINFO_ID}" />
								<div align="center" style="width: 310px; margin: 0px auto;">
									<!-- 图片路径 -->
									<div class="aui-content-img-box aui-content-full">
										<div class="aui-photo aui-up-img clear">
											<input type="file" id="myfile" name="myfile" style="display: none;" onchange="myupload(this)"accept="image/*"> 
											<img id="priImage" name="priImage" style="display: inline-block; border: 0; float: left;"width="130px" height="130px" onload="controlSize(this)"  <c:if test="${pd.PICTURE!=null&&pd.PICTURE!=''}">src="${pd.PICTURE }" </c:if> /> 
											<img  type="image" id="mypri" class="add-img" style="cursor: pointer;" title="课程类型图片上传" width="130px" height="130px" src="static/lunboimge/img/up.png" onclick="$('#myfile').click();" >
										</div>
									</div>
								</div>
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report"
										class="table table-striped table-bordered table-hover">
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">课程类型:</td>
											<td>
												<select id="INFONAME" name="INFONAME" style="vertical-align: top; width: 120px;">
														<option value="" selected="selected">请选择</option>
														<c:forEach items="${listAllC_Types}"  var="ctypes" varStatus="vs">
																<option value='${ctypes.C_TYPE}' <c:if test='${ctypes.C_TYPE==curriculumInfo.INFONAME}'>selected="selected"</c:if> >${ctypes.C_TYPE}</option>
														</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">就业工资:</td>
											<td><input type="number" name="WAGES" id="WAGES"
												value="${pd.WAGES}" maxlength="32" placeholder="这里输入就业工资"
												title="就业工资" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">课程学习总时间:</td>
											<td><input type="text" name="STUDYTIME" id="STUDYTIME"
												value="${pd.STUDYTIME}" maxlength="50"
												placeholder="这里输入课程学习总时间" title="课程学习总时间"
												style="width: 98%;" /></td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">创建备注:</td>
											<td style="height: 10px;"><input type="text"
												name="REMARKS" id="REMARKS" maxlength="100" value="${pd.REMARKS}"
												placeholder="这里输入创建备注" title="创建备注" 
												style="width: 98%;" /></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10"><input type="submit" value="保存" class="btn btn-mini btn-primary" />
												<input type="reset" value="取消"class="btn btn-mini btn-danger"
												onclick="top.Dialog.close();" /></td>
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
		$(function() {
			$("#Form").submit(function () {
				if($('#priImage').attr("src")===undefined){
					$("#mypri").tips({
						side : 3,
						msg : '请选择上传图片',
						bg : '#AE81FF',
						time : 2
					});
					return false;
				}
				
				if ($("#INFONAME").val() == "") {
					$("#INFONAME").tips({
						side : 3,
						msg : '请选择课程类型',
						bg : '#AE81FF',
						time : 2
					});
					return false;
				}
				if ($("#WAGES").val() == "") {
					$("#WAGES").tips({
						side : 3,
						msg : '请输入就业工资',
						bg : '#AE81FF',
						time : 2
					});
					return false;
				}else if(0>parseInt($("#WAGES").val())){
					$("#WAGES").tips({
						side : 3,
						msg : '金额不能为负数',
						bg : '#AE81FF',
						time : 2
					});
					$("#WAGES").val(0);
					return false;
				}
				
				if ($("#STUDYTIME").val() == "") {
					$("#STUDYTIME").tips({
						side : 3,
						msg : '请输入课程学习总时间',
						bg : '#AE81FF',
						time : 2
					});
					$("#STUDYTIME").focus();
					return false;
				}else if(isNaN($("#STUDYTIME").val())){
					$("#STUDYTIME").tips({
						side : 3,
						msg : '请输入数字',
						bg : '#AE81FF',
						time : 2
					});
					return false;
				}
				$("#Form").submit();
				$("#zhongxin").hide();
				$("#zhongxin2").show();
			});
		});
		
	</script>
</body>
</html>