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
	<link rel="stylesheet" href="static/layui-v2.3.0/layui/css/layui.css"
	media="all">
	
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
					<form action="classtype/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="CLASSTYPE_ID" id="CLASSTYPE_ID" value="${pd.CLASSTYPE_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:110px;text-align: right;padding-top: 13px;">班级类型名:</td>
								<td>
									<input type="text" name="CLASSTYPENAME" id="CLASSTYPENAME" value="${pd.CLASSTYPENAME}" maxlength="100" placeholder="这里输入班级类型名" title="班级类型名" style="width:98%;"/>
								</td>
							</tr>
							<tr>
								<td style="width:110px;text-align: right;padding-top: 13px;">班级LOGO:</td>
								<td>
									<div class="layui-upload" id="pic">
										<button type="button" class="layui-btn layui-btn-normal layui-btn-sm" id="test1">上传图片</button>
										<div class="layui-upload-list" >
											<img class="layui-upload-img" id="demo1" <c:if test="${upOrAdd =='up' }">src="${subjectImgPath }"</c:if> style="width: 80px; height: 80px">
											<p id="demoText"></p>
										</div>
									</div>
								</td>
							</tr>
							<tr style="display: none">
								<td style="width:110px;text-align: right;padding-top: 13px;">创建时间:</td>
								<td><input class="span10 date-picker"  name="CREATETIME" id="CREATETIME" value="${pd.CREATETIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="创建时间" title="创建时间" style="width:98%;"/></td>
							</tr>
							<tr style="display: none">
								<td style="width:110px;text-align: right;padding-top: 13px;">创建用户:</td>
								<td><input type="text" name="CREATEUSER" id="CREATEUSER" value="${USERNAME}" readonly="readonly" maxlength="20" placeholder="这里输入创建用户" title="创建用户" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:110px;text-align: right;padding-top: 13px;">备注:</td>
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
	<script src="static/layui-v2.3.0/layui/layui.js"></script>
		<script type="text/javascript">
		layui.use('upload',function() {
			var $ = layui.jquery, upload = layui.upload;
			//普通图片上传
			var uploadInst = upload.render({
						elem : '#test1',
						url : 'upload/image/',
						data:{"kind":"classtype"},
						before : function(obj) {
							//预读本地文件示例，不支持ie8
							obj.preview(function(index,file, result) {
										$('#demo1').attr('src',result); //图片链接（base64）
									});
						},
						done : function(res) {
							//如果上传失败
							if (res.code > 0) {
								return layer.msg('上传失败');
							}
							//上传成功
						},
						error : function() {
							//演示失败状态，并实现重传
							var demoText = $('#demoText');
							demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
							demoText.find('.demo-reload').on('click', function() {
								uploadInst.upload();
							});
						}
					});
		})
		$(top.hangge());
		//保存
		function save(){
			if($("#CLASSTYPENAME").val()==""){
				$("#CLASSTYPENAME").tips({
					side:3,
		            msg:'请输入班级类型名',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CLASSTYPENAME").focus();
			return false;
			}
			if($("#CLASSLOGO").val()==""){
				$("#CLASSLOGO").tips({
					side:3,
		            msg:'请输入班级LOGO',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CLASSLOGO").focus();
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
			$("#CLASSTYPENAME").change(function() {
				var className=$("#CLASSTYPENAME").val();
				var CLASSTYPE_ID=$("#CLASSTYPE_ID").val();
				if($("#CLASSTYPENAME").val()==""){
					$("#CLASSTYPENAME").tips({
						side:3,
			            msg:'请输入班级班级编号',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#CLASSTYPENAME").focus();
				return;
				}
				$.post(
					"classtype/validationClassName",
					"CLASSTYPE_ID="+CLASSTYPE_ID+"&title="+tit+"&CLASSTYPENAME="+className,
					function(rtn) {
						var info = rtn.errInfo;
						if(info!=undefined){
							$("#CLASSTYPENAME").tips({
								side:3,
					            msg:info,
					            bg:'#AE81FF',
					            time:2
					        });
							$("#CLASSTYPENAME").val("");
							$("#CLASSTYPENAME").focus();
						}
					},
					"json"
				);
			});
		})
		</script>
</body>
</html>