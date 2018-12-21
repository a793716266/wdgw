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
					
					<form action="classopening/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="CLASSOPENING_ID" id="CLASSOPENING_ID" value="${pd.CLASSOPENING_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">课程类型:</td>
								<td>
									<%-- <input type="text" name="CTYPE" id="CTYPE" value="${pd.CTYPE}" maxlength="255" placeholder="这里输入课程类型" title="课程类型" style="width:98%;"/> --%>
									<select name="CTYPE" id="CTYPE">
											<option value="">请选择课程类型</option>
										<c:forEach var="m" items="${mList }">
											<option <c:if test="${pd.CTYPE==m.C_TYPE}">selected="selected"</c:if> value="${m.C_TYPE}" >${m.C_TYPE}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">班级状态:</td>
								<td><input type="text" name="CLASSSTATE" id="CLASSSTATE" value="${pd.CLASSSTATE}" maxlength="255" placeholder="这里输入班级状态" title="班级状态" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">班级类型:</td>
								<td>
									<select name="CLASSTYPENAME" id="CLASSTYPENAME">
											<option value="" >请选择班级类型</option>
										<c:forEach var="c" items="${cList }">
											<option <c:if test="${pd.CLASSTYPENAME==c.CLASSTYPENAME}">selected="selected"</c:if>  value="${c.CLASSTYPENAME}">${c.CLASSTYPENAME}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">班级编号:</td>
								<td><input type="number" name="CLASSNUMBER" id="CLASSNUMBER" value="${pd.CLASSNUMBER}" maxlength="32" placeholder="这里输入班级编号" title="班级编号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">班级总名额:</td>
								<td><input type="number" name="TOTALNUMBER" id="TOTALNUMBER" value="${pd.TOTALNUMBER}" maxlength="32" placeholder="这里输入班级总名额" title="班级总名额" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">现有人数:</td>
								<td><input type="number" name="CURRENTNUMBER" id="CURRENTNUMBER" value="${pd.CURRENTNUMBER}" maxlength="32" placeholder="这里输入现有人数" title="班级现有人数" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">预定状态:</td>
								<td>
									<input type="radio" name="RESERVSSTATE" id="RESERVSSTATE" <c:if test="${pd.RESERVSSTATE==0 }">checked="checked"</c:if>  value="0"/>未满
									<input type="radio" name="RESERVSSTATE" id="RESERVSSTATE" <c:if test="${pd.RESERVSSTATE==1 }">checked="checked"</c:if>  value="1"/>已满
								</td>
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
			if($("#CTYPE").val()==""){
				$("#CTYPE").tips({
					side:3,
		            msg:'请输入课程类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CTYPE").focus();
			return false;
			}
			if($("#CLASSSTATE").val()==""){
				$("#CLASSSTATE").tips({
					side:3,
		            msg:'请输入班级状态',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CLASSSTATE").focus();
			return false;
			}
			if($("#CLASSTYPENAME").val()==""){
				$("#CLASSTYPENAME").tips({
					side:3,
		            msg:'请输入班级类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CLASSTYPENAME").focus();
			return false;
			}
			if($("#CLASSNUMBER").val()==""){
				$("#CLASSNUMBER").tips({
					side:3,
		            msg:'请输入班级编号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CLASSNUMBER").focus();
			return false;
			}else if(0==parseInt($("#CLASSNUMBER").val())){
				$("#CLASSNUMBER").tips({
					side : 3,
					msg :'班级编号不能为零',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}else if(0>parseInt($("#CLASSNUMBER").val())){
				$("#CLASSNUMBER").tips({
					side : 3,
					msg :'班级编号不为负数',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			
			
			
			if($("#TOTALNUMBER").val()==""){
				$("#TOTALNUMBER").tips({
					side:3,
		            msg:'请输入班级总名额',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TOTALNUMBER").focus();
			return false;
			}else if(0==parseInt($("#TOTALNUMBER").val())){
				$("#TOTALNUMBER").tips({
					side : 3,
					msg : '班级总名额不为能为零',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}else if(0>parseInt($("#TOTALNUMBER").val())){
				$("#TOTALNUMBER").tips({
					side : 3,
					msg : '班级总名额不为负数',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			
			if($("#CURRENTNUMBER").val()==""){
				$("#CURRENTNUMBER").tips({
					side:3,
		            msg:'请输入班级现有人数',
		            bg:'#AE81FF',
		            time:2
		        });
			return false;
			}else if(0==parseInt($("#CURRENTNUMBER").val())){
				$("#CURRENTNUMBER").tips({
					side : 3,
					msg : '班级现有人数不为能为零',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}else if(0>parseInt($("#CURRENTNUMBER").val())){
				$("#CURRENTNUMBER").tips({
					side : 3,
					msg : '班级现有人数不为负数',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}else if(parseInt($("#CURRENTNUMBER").val())>parseInt($("#TOTALNUMBER").val())){
				$("#CURRENTNUMBER").tips({
					side : 3,
					msg : '班级现有人数不能大于班级总人数',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			
			
			if($("#RESERVSSTATE").val()==""){
				$("#RESERVSSTATE").tips({
					side:3,
		            msg:'请输入预定状态',
		            bg:'#AE81FF',
		            time:2
		        });
			return false;
			}
			if($("#REMARKS").val()==""){
				$("#REMARKS").tips({
					side:3,
		            msg:'请输入备注',
		            bg:'#AE81FF',
		            time:2
		        });
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