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

							<form action="curriculum/${msg }.do" name="Form" id="Form"
								method="post">
								<input type="hidden" name="CURRICULUM_ID" id="CURRICULUM_ID"
									value="${pd.CURRICULUM_ID}" />
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report"
										class="table table-striped table-bordered table-hover">
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">课程类型:</td>
											<td>
												<input type="text" name="C_TYPE" id="C_TYPE"  <c:if test="${pd.C_TYPE!=null && pd.C_TYPE!=''}">value="${pd.C_TYPE}" readonly="readonly"</c:if> maxlength="20" placeholder="这里输入课程类型" title="课程类型" style="width: 98%;" />
											</td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">
												备注:</td>
											<td><input type="text" name="REMARKS" id="REMARKS"
												value="${pd.REMARKS}" maxlength="100" placeholder="这里输入 备注"
												title=" 备注" style="width: 98%;" /></td>
										</tr>

										<tr>
											<td style="text-align: center;" colspan="10"><a
												class="btn btn-mini btn-primary" onclick="save();">保存</a> <a
												class="btn btn-mini btn-danger"
												onclick="top.Dialog.close();">取消</a></td>
										</tr>
									</table>
								</div>
								<div id="zhongxin2" class="center" style="display: none">
									<br />
									<br />
									<br />
									<br />
									<br />
									<img src="static/images/jiazai.gif" /><br />
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
		//保存
		function save() {
			if ($("#C_TYPE").val() == "") {
				$("#C_TYPE").tips({
					side : 3,
					msg : '请输入课程类型',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
		

			if("${pd.C_TYPE}"==''){
				$.ajax({
					 type: "POST",
					 url:"curriculum/ajax",
					 data: "type="+$("#C_TYPE").val(),
					 dataType: "json",
					 success:function(data){
						 if(data > 0){
							$("#C_TYPE").tips({
								side : 3,
								msg : '数据存在请从新添加类型',
								bg : '#AE81FF',
								time : 2
							});
						 }else{
								$("#Form").submit();
								$("#zhongxin").hide();
								$("#zhongxin2").show();
						 }
					 }
				});
			}else{
				$("#Form").submit();
				$("#zhongxin").hide();
				$("#zhongxin2").show();
			}
		}
	</script>
</body>
</html>