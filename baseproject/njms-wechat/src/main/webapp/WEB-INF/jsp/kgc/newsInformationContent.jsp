<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%@include file="../common/common-header.jsp"%>
	<div class="curtain">
		<%@include file="newsTextContent.jsp"%>
		<%@include file="groomNews.jsp"%>
	</div>
	<%@include file="../common/common-footer.jsp"%>
</body>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/newsContent/newsInformationContent.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/newsContent/groomNews.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/newsContent/newsTextContent.css" />
<script src="<%=basePath%>static/js/vue.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>static/components/header.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/components/footer.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>static/js/vueConfig.js" type="text/javascript"
	charset="utf-8"></script>
<script src="static/js/newsContent/newsTextContent.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		getData({
			url:"wd/allNewsDesc.do",
			attr:"allNewsDesclist"
		})
	})
	
	function gotoNewsDetail(id){
		location.href="wd/gotoNewsDetail.do?newsid="+id;
	}
	
	function goNewsInfo(){
		location.href="wd/toIndex.do?newsInfoMation=newsInfoMation";
	}
</script>
</html>