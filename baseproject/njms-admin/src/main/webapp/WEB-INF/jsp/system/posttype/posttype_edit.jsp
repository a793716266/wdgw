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
					
					<form action="posttype/${msg }.do" name="Form" id="Form" method="post" enctype="multipart/form-data"  modelAttribute="PageData">
						<input type="hidden" name="POSTTYPE_ID" id="POSTTYPE_ID" value="${pd.POSTTYPE_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">管理员:</td>
								<td id="changeAdmin">
									<select class="chosen-select form-control" data-placeholder="请选择" id="MANAGER" style="width: 98%;vertical-align:top;" name="MANAGER">
										<option value=""></option>
										<c:forEach var="c" items="${allAdmin}">
											<option value="${c.WD_USERS_ID}"<c:if test="${c.WD_USERS_ID==pd.MANAGER }">selected</c:if>>${c.NICKNAME}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">名称:</td>
								<td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="255" placeholder="这里输入名字" title="名字" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">简介:</td>
								<td><input type="text" name="SYNOPSIS" id="SYNOPSIS" value="${pd.SYNOPSIS}" maxlength="255" placeholder="这里输入简介" title="简介" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片:</td>
								<td>
									<div class="input-group row">
						                <div class="col-sm-9 big-photo">
						                	<div id="preview">
						                        <img id="imghead" border="0" <c:if test="${picture==null}">src="static/images/photo_icon.png"</c:if><c:if test="${picture!=null}">src="${picture}"</c:if> width="90" height="90" onclick="$('#previewImg').click();">
						                     </div>         
						                    <input type="file" name="myfile" onchange="previewImage(this)" style="display: none;" id="previewImg">
						                </div>
						            </div>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">版块:</td>
								<td><input type="number" name="PLATE" id="PLATE" value="${pd.PLATE}" maxlength="32" placeholder="这里输入版块" title="版块" style="width:98%;"/></td>
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
		//图片上传预览    IE是用了滤镜。
        function previewImage(file)
        {
          var MAXWIDTH  = 90; 
          var MAXHEIGHT = 90;
          var div = document.getElementById('preview');
          if (file.files && file.files[0])
          {
              div.innerHTML ='<img id=imghead onclick=$("#previewImg").click()>';
              var img = document.getElementById('imghead');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight ){
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                
                if( rateWidth > rateHeight ){
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else{
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }
		
		$(top.hangge());
		//保存
		function save(){
			if ($('#preview img').attr("src") === 'static/images/photo_icon.png'||$('#preview img').attr("src") ===""||$('#preview img').attr("src") ===null||$('#preview img').attr("src") ===undefined) {
				$("#preview").tips({
					side : 3,
					msg : '请选择图片',
					bg : '#AE81FF',
					time : 2
				});
				return false;
			}
			if($("#NAME").val()==""){
				$("#NAME").tips({
					side:3,
		            msg:'请输入名字',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#NAME").focus();
			return false;
			}
			if($("#SYNOPSIS").val()==""){
				$("#SYNOPSIS").tips({
					side:3,
		            msg:'请输入简介',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SYNOPSIS").focus();
			return false;
			}
			if($("#MANAGER").val()==""){
				$("#changeAdmin").tips({
					side:3,
		            msg:'请选择管理员',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MANAGER").focus();
			return false;
			}
			if($("#PLATE").val()==""){
				$("#PLATE").tips({
					side:3,
		            msg:'请输入版块',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PLATE").focus();
			return false;
			}
			var res="true";
			var plate=$("#PLATE").val();
			var plate1="${pd.PLATE}";
			if(plate!=plate1){
				$.ajax({
					type:"post",
					async:false,
					url:"posttype/ajax",
					data:{"plate":plate},
					success:function(data){
						if(data==="false")
							res="false";
					},
					dataType:"json"
				})
			}
			
			if(res==="false"){
				$("#PLATE").tips({
					side:3,
		            msg:'输入版块已存在',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PLATE").focus();
				return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
			
			//下拉框
			if(!ace.vars['touch']) {
				$('.chosen-select').chosen({allow_single_deselect:true}); 
				$(window)
				.off('resize.chosen')
				.on('resize.chosen', function() {
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': "98%"});
					});
				}).trigger('resize.chosen');
				$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
					if(event_name != 'sidebar_collapsed') return;
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					});
				});
				$('#chosen-multiple-style .btn').on('click', function(e){
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
					 else $('#form-field-select-4').removeClass('tag-input-style');
				});
			}
		});
		</script>
</body>
</html>