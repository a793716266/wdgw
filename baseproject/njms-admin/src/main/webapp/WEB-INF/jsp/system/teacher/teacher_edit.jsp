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

							<form action="teacher/${msg }.do" name="Form" id="Form" method="post" enctype="multipart/form-data" modelAttribute="PageData">
								<input type="hidden" name="TEACHER_ID" id="TEACHER_ID" value="${pd.TEACHER_ID}" />
									
								<div align="center" style="width: 310px; margin: 0px auto;">
									<!-- 图片路径 -->
									<div class="aui-content-img-box aui-content-full">
										<div class="aui-photo aui-up-img clear">
											<input type="file" id="myfile" name="myfile" style="display:none;" onchange="myupload(this)" accept="image/*"   />
											<img  id="priImg" name="priImg" style="display:inline-block;border:0; float: left;"  width="130px" height="130px" onload="controlSize(this)" <c:if test="${pd.HEADPORTRAIT != null&&pd.HEADPORTRAIT!=''}">src="${pd.HEADPORTRAIT}"</c:if> /> 
											<img  type="image" value="${pd.HEADPORTRAIT}" name="image" id="image" class="add-img" width="130px" height="130px" src="static/lunboimge/img/up.png" onclick="$('#myfile').click();" >
										</div>
									</div>
								</div>
								
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										
										<tr>
											<td style="width: 75px; text-align: right; padding-top: 13px;">姓名:</td>
											<td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="255" placeholder="这里输入姓名" title="姓名" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td style="width: 75px; text-align: right; padding-top: 13px;">身份:</td>
											<td>
												<select class="chosen-select form-control"  name="identity" id="identity"  style="vertical-align: top; width: 120px;" onchange="show_sub(this.options[this.options.selectedIndex].value)">
														<option value="教员" <c:if test="${pd.IDENTITY=='教员'}">selected="selected"</c:if>>教员</option>
														<option value="班主任" <c:if test="${pd.IDENTITY=='班主任'}">selected="selected"</c:if>>班主任</option>
												</select>
											</td>
										</tr>
										<tr id="identype"  <c:if test="${pd.IDENTITY=='班主任'}">style="display: none;"</c:if>>
											<td style="width: 75px; text-align: right; padding-top: 13px;">教学方向:</td>
											<td>
												<select class="chosen-select form-control" name="curriculumtype" id="curriculumtype"  style="vertical-align: top; width: 120px;">
													<c:forEach items="${list}" var="c">
														<option value="${c.C_TYPE}" <c:if test="${pd.CURRICULUMTYPE==c.C_TYPE}">selected="selected"</c:if>>${c.C_TYPE}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td style="width: 75px; text-align: right; padding-top: 13px;">简介:</td>
											<td>
												<textarea name="INFO" id="INFO" value="${pd.INFO}" maxlength="255" placeholder="这里输入简介" title="简介" style="width: 98%;">${pd.INFO}</textarea>
											</td>
										</tr>
										<tr>
											<td style="width: 75px; text-align: right; padding-top: 13px;">备注:</td>
											<td><input type="text" name="REMARKS" id="REMARKS" value="${pd.REMARKS}" maxlength="255" placeholder="这里输入备注" title="备注" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td style="width: 75px; text-align: right; padding-top: 13px;">从业年数:</td>
											<td><input type="number" name="NUMBEROFYEARS" id="NUMBEROFYEARS" value="${pd.NUMBEROFYEARS}" maxlength="255" placeholder="这里输入从业年数" title="开发经验" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10"><a class="btn btn-mini btn-primary" onclick="save();">保存</a> <a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a></td>
										</tr>
									</table>
								</div>
								<div id="zhongxin2" class="center" style="display: none">
									<br /> <br /> <br /> <br /> <br /> <img src="static/images/jiazai.gif" /><br />
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
		//预览图片
		function myupload(obj) {
			var file = obj.files[0];
            var reader = new FileReader();
            //读取文件过程方法
            reader.onload = function (e) {
                var img = document.getElementById("priImg");
                img.src = e.target.result;
                url = window.URL.createObjectURL(file);
            }
            reader.readAsDataURL(file)
		}
		//下拉框改变事件
		function show_sub(obj){
			//alert(obj);
			if(obj=="教员"){
				$("#identype").show();
			}else if(obj=="班主任"){
				$("#identype").hide();
			}
		}
		//保存
		function save() {
			if ($("#HEADPORTRAIT").val() == "") {
				$("#HEADPORTRAIT").tips({
					side : 3,
					msg : '请输入头像',
					bg : '#AE81FF',
					time : 2
				});
				$("#HEADPORTRAIT").focus();
				return false;
			}
			if ($("#NAME").val() == "") {
				$("#NAME").tips({
					side : 3,
					msg : '请输入姓名',
					bg : '#AE81FF',
					time : 2
				});
				$("#NAME").focus();
				return false;
			}
			if ($("#CURRICULUMTYPE").val() == "") {
				$("#CURRICULUMTYPE").tips({
					side : 3,
					msg : '请输入课程类型',
					bg : '#AE81FF',
					time : 2
				});
				$("#CURRICULUMTYPE").focus();
				return false;
			}
			if ($("#EVALUATE").val() == "") {
				$("#EVALUATE").tips({
					side : 3,
					msg : '请输入评价',
					bg : '#AE81FF',
					time : 2
				});
				$("#EVALUATE").focus();
				return false;
			}
			
			
			if ($("#NUMBEROFYEARS").val() == "") {
				$("#NUMBEROFYEARS").tips({
					side : 3,
					msg : '请输入从业年数',
					bg : '#AE81FF',
					time : 2
				});
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
		});
	</script>
</body>
</html>