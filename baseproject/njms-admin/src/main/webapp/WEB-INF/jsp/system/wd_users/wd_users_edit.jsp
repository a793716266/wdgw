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
							<form action="wd_users/${msg }.do" name="Form" id="Form"
								method="post" enctype="multipart/form-data"  modelAttribute="PageData" >
								<input type="hidden" name="WD_USERS_ID" id="WD_USERS_ID"
									value="${pd.WD_USERS_ID}" />
								<div align="center" style="width: 310px; margin: 0px auto;">
									<!-- 图片路径 -->
									<div class="aui-content-img-box aui-content-full"
										style="margin: 10px;">
										<div class="aui-photo aui-up-img clear">
											<input type="file" id="myfile" name="myfile"style="display: none;" onchange="myupload(this)"accept="image/*"> 
											<img id="priImage" name="priImage" style="display: inline-block; border: 0; float: left;"width="130px" height="130px"   <c:if test="${pd.PICTURE!=null&&pd.PICTURE!=''}">src="${pd.PICTURE }"</c:if> />
											<img type="image" id="mypri" class="add-img" width="130px"height="130px" style="cursor: pointer;" src="static/lunboimge/img/up.png" onclick="$('#myfile').click();" title="用户头像">
										</div>
									</div>
								</div>
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report"
										class="table table-striped table-bordered table-hover">
										<c:if test="${msg=='save'}">
											<tr>
												<td
													style="width: 75px; text-align: right; padding-top: 13px;">用户账户:</td>
												<td>
													<input type="text" name="ACCOUNTNUMBER" id="ACCOUNTNUMBER" value="${pd.ACCOUNTNUMBER}" maxlength="20" style="width: 98%;" placeholder="这里输入用户账户" title="用户账户"   />
												</td>
											</tr>
										</c:if>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">用户密码:</td>
											<td><input type="text" name="PASSWORD" id="PASSWORD"
												value="${pd.PASSWORD}" maxlength="20" placeholder="这里输入用户密码"
												title="用户密码" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">用户昵称:</td>
											<td><input type="text" name="NICKNAME" id="NICKNAME"
												value="${pd.NICKNAME}" maxlength="20" placeholder="这里输入用户昵称"
												title="用户昵称" style="width: 98%;" /></td>
										</tr>

										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">用户手机号:</td>
											<td><input type="text" name="PHONENUMBER"
												id="PHONENUMBER" value="${pd.PHONENUMBER}" maxlength="20"
												placeholder="这里输入用户手机号" title="用户手机号" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">用户邮箱:</td>
											<td><input type="text" name="MAILBOX" id="MAILBOX"
												value="${pd.MAILBOX}" maxlength="20" placeholder="这里输入用户邮箱"
												title="用户邮箱" style="width: 98%;" /></td>
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
			//用户账号正则，4到16位（字母，数字，下划线，减号）//输出 true
			var uPattern = /^[a-zA-Z0-9]{4,16}$/;
			//密码强度正则，最短6位，最长16位 {6,16}可以包含小写大母 [a-z] 和大写字母 [A-Z]可以包含数字 [0-9]可以包含下划线 [ _ ] 
			var pPattern = /^[\w_]{6,16}$/;;
			//昵称正则      有汉字字母数字下划线组成，6-8位
			var nPattern = /^[\w\u4e00-\u9fa5]{0,8}$/;
			//手机号正则
			var yPattern = /^(134[012345678]\d{7}|1[34578][012356789]\d{8})$/;
			var dPattern = /^1[3578][01379]\d{8}$/;
			var lPattern = /^1[34578][01256]\d{8}$/;
			//Email正则
			var ePattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			
			if($("#ACCOUNTNUMBER").val()==""){
				$("#ACCOUNTNUMBER").tips({
					side:3,
		            msg:'请输入用户账户',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}else if(!uPattern.test($("#ACCOUNTNUMBER").val())){
				$("#ACCOUNTNUMBER").tips({
					side:3,
		            msg:'用户账户4到16位可以包含（字母，数字）',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}
			
			if($("#PASSWORD").val()==""){
				$("#PASSWORD").tips({
					side:3,
		            msg:'请输入用户密码',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}else if(!pPattern.test($("#PASSWORD").val())){
				$("#PASSWORD").tips({
					side:3,
		            msg:'最短6位，最长16位（字母，数字，下划线，减号）',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}
			
			if($("#NICKNAME").val()==""){
				$("#NICKNAME").tips({
					side:3,
		            msg:'请输入用户昵称',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}else if(!nPattern.test($("#NICKNAME").val())){
				$("#NICKNAME").tips({
					side:3,
		            msg:'有汉字字母数字下划线组成，6-8位',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}
			
			if($("#PHONENUMBER").val()==""){
				$("#PHONENUMBER").tips({
					side:3,
		            msg:'请输入用户手机号',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}else if(!yPattern.test($("#PHONENUMBER").val())&&!dPattern.test($("#PHONENUMBER").val())&&!lPattern.test($("#PHONENUMBER").val())){
				$("#PHONENUMBER").tips({
					side:3,
		            msg:'手机号格式不正确',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}
			
			/* if($("#MAILBOX").val()==""){
				$("#MAILBOX").tips({
					side:3,
		            msg:'请输入用户邮箱',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}else if(!ePattern.test($("#MAILBOX").val())){
				$("#MAILBOX").tips({
					side:3,
		            msg:'邮箱格式不正确(xx@xx.域名)',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			} */
			
			
			//验证User是否重复
			$.ajax({
				 type: "POST",
				 url:"wd_users/ajax",
				 data: "userNumber="+$("#ACCOUNTNUMBER").val(),
				 dataType: "json",
				 success:function(data){
					 if(data > 0){
						$("#ACCOUNTNUMBER").tips({
							side : 3,
							msg : '用户数据存在请从新添加',
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
		}
		
		</script>
</body>
</html>