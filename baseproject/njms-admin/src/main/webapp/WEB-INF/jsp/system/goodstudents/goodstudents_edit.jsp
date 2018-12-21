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
	<link rel="stylesheet" href="static/layui-v2.3.0/layui/css/layui.css"
	media="all">
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
					
					<form action="goodstudents/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="GOODSTUDENTS_ID" id="GOODSTUDENTS_ID" value="${pd.GOODSTUDENTS_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:110px;text-align: right;padding-top: 13px;">视频连接路径:</td>
								<td><input type="text" name="VIDEONAME" id="VIDEONAME" value="${pd.VIDEONAME}" oninput="getVideoUrl()" onchange="getVideoUrl()" placeholder="这里输入视频类型" title="视频类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">学生姓名:</td>
								<td><input type="text" name="STUNAME" id="STUNAME" value="${pd.STUNAME}" maxlength="20" placeholder="这里输入学生姓名" title="学生姓名" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">学生头像:</td>
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
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">就业薪资:</td>
								<td><input type="number" name="EMPWAGE" id="EMPWAGE" value="${pd.EMPWAGE}" maxlength="32" placeholder="这里输入就业薪资" title="就业薪资" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">课程类型:</td>
								<td style="vertical-align:top;padding-left:2px;">
								 	<select class="chosen-select form-control" name="C_TYPE" id="C_TYPE" data-placeholder="请选择课程类型" style="vertical-align:top;width: 98%;">
									<c:forEach items="${varList1}" var="varList">
										<option value="${varList.C_TYPE}" <c:if test="${pd.C_TYPE==varList.C_TYPE}">selected="selected"</c:if>>${varList.C_TYPE}</option>
									</c:forEach>
								  	</select>
								</td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">学习感言:</td>
								<td><input type="text" name="SPEECH" id="SPEECH" value="${pd.SPEECH}" maxlength="255" placeholder="这里输入学习感言" title="学习感言" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">就业公司:</td>
								<td><input type="text" name="EMPCOMPANY" id="EMPCOMPANY" value="${pd.EMPCOMPANY}" maxlength="50" placeholder="这里输入就业公司" title="就业公司" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">就业时间:</td>
								<td><input class="span10 date-picker" name="EMPTIME" id="EMPTIME" value="${pd.EMPTIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="就业时间" title="就业时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;display: none">创建时间:</td>
								<td><input class="span10 date-picker" name="CREATETIME" id="CREATETIME" style="display: none" value="${pd.CREATETIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="创建时间" title="创建时间" style="width:98%;"/></td>
							</tr>
							<tr style="display: none">
								<td style="width:90px;text-align: right;padding-top: 13px;display: none">创建用户:</td>
								<td><input type="text" name="CREATEUSER" id="CREATEUSER"  value="${USERNAME}" maxlength="60" readonly="readonly" title="创建用户" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:90px;text-align: right;padding-top: 13px;">备注:</td>
								<td><input type="text" name="REMARKS" id="REMARKS" value="${pd.REMARKS}" maxlength="150" placeholder="这里输入备注" title="备注" style="width:98%;"/></td>
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
	<script src="static/layui-v2.3.0/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use('upload',function() {
					var $ = layui.jquery, upload = layui.upload;
					//普通图片上传
					var uploadInst = upload.render({
								elem : '#test1',
								url : 'upload/image/',
								data:{"kind":"goodstudents"},
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
			if($('#demo1').attr("src")===undefined){
				$("#pic").tips({
					side : 3,
					msg : '请选择图片',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			if($("#VIDEONAME").val()==""){
				$("#VIDEONAME").tips({
					side:3,
		            msg:'请输入视频类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#VIDEONAME").focus();
			return false;
			}
			if($("#STUNAME").val()==""){
				$("#STUNAME").tips({
					side:3,
		            msg:'请输入学生姓名',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#STUNAME").focus();
			return false;
			}
			if($("#EMPWAGE").val()==""){
				$("#EMPWAGE").tips({
					side:3,
		            msg:'请输入就业薪资',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#EMPWAGE").focus();
			return false;
			}
			if($("#C_TYPE").val()==""){
				$("#C_TYPE").tips({
					side:3,
		            msg:'请输入课程类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#C_TYPE").focus();
			return false;
			}
			if($("#SPEECH").val()==""){
				$("#SPEECH").tips({
					side:3,
		            msg:'请输入学习感言',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SPEECH").focus();
			return false;
			}
			if($("#EMPCOMPANY").val()==""){
				$("#EMPCOMPANY").tips({
					side:3,
		            msg:'请输入就业公司',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#EMPCOMPANY").focus();
			return false;
			}
			if($("#EMPTIME").val()==""){
				$("#EMPTIME").tips({
					side:3,
		            msg:'请输入就业时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#EMPTIME").focus();
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
		function getVideoUrl(){
			let fullUrl = $("#VIDEONAME").val();
			if(fullUrl.indexOf("imgcache.qq.com/tencentvideo") > -1){
				let indexStart = fullUrl.indexOf("vid=");
				while(fullUrl.indexOf('&') > -1){
					let i = fullUrl.indexOf('&');
					if(i > indexStart){
						fullUrl = fullUrl.substring(indexStart,i)
						$("#VIDEONAME").val("qq"+fullUrl);
						indexEnd = i;
						break;
					}
					fullUrl = fullUrl.substring(i+1)
					indexStart = fullUrl.indexOf("vid=");
				}
			}else if(fullUrl.indexOf("http://player.youku.com") > -1){
				let indexStart = fullUrl.indexOf("sid/");
				while(fullUrl.indexOf('/') > -1){
					let i = fullUrl.indexOf('/');
					if(i > indexStart){
						fullUrl = fullUrl.substring(indexStart,fullUrl.indexOf("==/v.swf"));
						$("#VIDEONAME").val("youku"+fullUrl.replace('/','='));
						indexEnd = i;
						console.log(fullUrl)
						break;
					}
					fullUrl = fullUrl.substring(i+1)
					console.log(fullUrl)
					indexStart = fullUrl.indexOf("sid/");
				}
			}
		}
		</script>
</body>
</html>