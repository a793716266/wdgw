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
					
					<form action="postreturn/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="POSTRETURN_ID" id="POSTRETURN_ID" value="${pd.POSTRETURN_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">帖子的ID:</td>
								<td><input type="number" name="POSTID" id="POSTID" value="${pd.POSTID}" maxlength="32" placeholder="这里输入帖子的id" title="帖子的ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">用户ID:</td>
								<td><input type="text" name="USERID" id="USERID" value="${pd.USERID}" maxlength="100" placeholder="这里输入用户id" title="用户ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">评论内容:</td>
								<td><input type="text" name="COMMENCONTENT" id="COMMENCONTENT" value="${pd.COMMENCONTENT}" maxlength="255" placeholder="这里输入评论内容" title="评论内容" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">评论楼层:</td>
								<td><input type="number" name="COMMENTFLOOR" id="COMMENTFLOOR" value="${pd.COMMENTFLOOR}" maxlength="32" placeholder="这里输入评论楼层" title="评论楼层" style="width:98%;"/></td>
							</tr>
							<tr hidden="hidden">
								<td style="width:75px;text-align: right;padding-top: 13px;">评论时间:</td>
								<td><input class="span10 date-picker" name="COMMENTTIME" id="COMMENTTIME" value="${pd.COMMENTTIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="评论时间" title="评论时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">回复人ID:</td>
								<td><input type="text" name="REPLIERID" id="REPLIERID" value="${pd.REPLIERID}" maxlength="100" placeholder="这里输入回复人id" title="回复人ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">回复层级:</td>
								<%-- <td><input type="number" name="LEVEL" id="LEVEL" value="${pd.LEVEL}" maxlength="32" placeholder="这里输入回复层级" title="回复层级" style="width:98%;"/></td> --%>
								<td>
									<input type="hidden" id="hiddenLevel" name="hiddenLevel" value="${pd.LEVEL}"/>
									<select name="LEVEL" id="LEVEL" data-placeholder="请选择" title="回复层级" style="width:98%;">
										<option value="">选择回复层级</option>
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
								  	</select>
								</td>
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
		
		//修改时下拉框回复层级选中
		$(function(){
			var level = $("#hiddenLevel").val();
			if(level != "" || level != '' || level>=0 ){
				$.each($("#LEVEL option"),function(){
					if( $(this).val()== level ){
						$(this).attr("selected","selected");
					}
				})	
			}
		})
		
		$(top.hangge());
		//保存
		function save(){
			if($("#POSTID").val()==""){
				$("#POSTID").tips({
					side:3,
		            msg:'请输入帖子的ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#POSTID").focus();
			return false;
			}
			if($("#USERID").val()==""){
				$("#USERID").tips({
					side:3,
		            msg:'请输入用户ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#USERID").focus();
			return false;
			}
			if($("#COMMENCONTENT").val()==""){
				$("#COMMENCONTENT").tips({
					side:3,
		            msg:'请输入评论内容',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#COMMENCONTENT").focus();
			return false;
			}
			if($("#COMMENTFLOOR").val()==""){
				$("#COMMENTFLOOR").tips({
					side:3,
		            msg:'请输入评论楼层',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#COMMENTFLOOR").focus();
			return false;
			}
			if($("#REPLIERID").val()==""){
				$("#REPLIERID").tips({
					side:3,
		            msg:'请输入回复人ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#REPLIERID").focus();
			return false;
			}
			if($("#LEVEL").val()==""){
				$("#LEVEL").tips({
					side:3,
		            msg:'请输入回复层级',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LEVEL").focus();
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