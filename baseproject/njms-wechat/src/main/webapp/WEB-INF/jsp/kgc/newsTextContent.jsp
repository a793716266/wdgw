<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="straightMatter">
	<ul class="straightMatterul  textColor">
		<li class="straightMatterli">
			<a href="javascript:;" onclick="newsTextGoIndex()" class="noUnderline textColor textSize">首页</a>
		</li>
		<li class="straightMatterli">></li>
		<li class="straightMatterli">
			<a href="javascript:;" class="noUnderline textColor textSize" onclick="goNewsInfo()">新闻资讯</a>
		</li>
		<li class="straightMatterli">></li>
		<li class="straightMatterli">
			<a href="javascript:;" onclick="newsTextGoDynamics('${newsType}')" class="noUnderline textColor textSize">${newsType}</a>
		</li>
		<li class="straightMatterli">></li>
		<li class="straightMatterli">
			<a href="javascript:;" class="noUnderline textColor textSize">正文</a>
		</li>
	</ul>
</div>
<div class="floatLeft straightMatterBody">
	<div class="straightMatterTextTitle FFFFFF">
		<div class="overflowTitle">
			<div class="straightMatterTextTitleH2">${newsInformation.newTitle}</div>
			<div class="createtime textColor formCrateTime">
				${newsInformation.createTime.substring(0,5).replace('-','年')}${newsInformation.createTime.substring(5,8).replace('-','月')}${newsInformation.createTime.substring(8,10)}日${newsInformation.createTime.substring(10)}
			</div>
			<div class="createtime textColor fromWhere">来源：
				<span class="textColor"  style="font-size:12px !important">${newsInformation.ORIGIN}</span>
			</div>
		</div>
	</div>
	<div class="straightMatterTextContainer  FFFFFF">
		<div class="straightMatterTextContainerBody textColor textSize">
			${newsInformation.newContent}
		</div>
	</div>
	<div class="straightMatterTextFootThree FFFFFF">
		<img src="static/img/newsContent/weibo.png" title="微博" />
		<img src="static/img/newsContent/kongjian.png" title="QQ空间" />
		<img src="static/img/newsContent/penyouquan.png" title="微信" />
		<div class="fenxiang textColor textSize">分享到：</div>
	</div>
</div>

