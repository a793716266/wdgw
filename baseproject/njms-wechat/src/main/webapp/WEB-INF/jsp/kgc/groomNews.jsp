<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="floatLeft straightMatterBodyRight">
	<div class="straightMatterBodyRightHead FFFFFF">相关推荐</div>
	<div class="straightMatterBodyRightBody FFFFFF">
		<div class="straightMatterBodyRightBodyNews" v-for="item in allNewsDesclist">
			<div class="straightMatterBodyRightBodyNewsImg Title floatLeft">
				<img :src='item.pictureName' :onclick="'gotoNewsDetail(\''+item.news_id+'\')'"/>
			</div>
			<div class="straightMatterBodyRightBodyNewsBody floatLeft">
				<div class="straightMatterBodyRightBodyNewsBodya" >
					<a href="javascript:;" class="noUnderline" :onclick="'gotoNewsDetail(\''+item.news_id+'\')'">{{item.newTitle}}</a>
				</div>
				<div class="textColor straightMatterBodyRightBodyNewsBodyTime">
					{{item.createTime?item.createTime.substring(0,10):''}}
				</div>
			</div>
		</div>
	</div>
	<div class="straightMatterBodyRightFoot FFFFFF" onclick="goNewsInfo()">
		回到新闻资讯主页
	</div>
</div>
