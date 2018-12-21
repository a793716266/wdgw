<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
		*{
			padding: 0;
			margin: 0;
		}
		/* 左侧 */
		.type-container{
			width: 140px;
			border-right:1px solid silver;
			border-bottom: 1px solid silver;
			text-align: center;
			
		}
		
		/* 左侧内容 */
		.type-user{
			/* transform: translateY(); */
			padding-top: 15px;
		}
		
		/* 左侧用户头像 */
		.type-user-icon{
			
		}
		
		/* 左侧用户名 */
		.type-user-name{
			font-size: 14px;
			color: #434343;
			margin-top: 10px;
		}
		
		/* 右侧 */
		.type-info-detail{
			width: 1000px;
			border-bottom: 1px solid silver;
			color: #A2A2A2;
			padding: 20px 30px;
			font-size: 14px;
		}
		
		/* 右侧内容 */
		.type-info-detail-text{
			 padding-bottom: 124px; 
		}
		
		/* 右侧回复盒子 */
		.type-info-detail-info-you{
			
		}
		
		/* 右侧回复子盒子 */
		.type-info-detail-info-txt{
			display: flex;
			flex-direction: row;
			text-align: right;
			float: right;
			clear: both;
			font-size: 10px;
		}
		
		/* 回复楼层 */
		.type-info-detail-info-floor{
			margin-right: 10px;
		}
		
		/* 回复时间 */
		.type-info-detail-info-titleTime{
			margin-right: 10px;
		}
		
		/* 回复按钮 */
		.type-info-detail-info-talk>a{
			font-size: 12px;
			text-decoration: none;
			color: #00A0E9;
		}
		
		/* 展开回复 */
		.talkChildren{
			border: 1px black solid;
			margin-top:10px;
			float: right;
			clear: both;
			/* 释放 */ display: none; 
		}
		
		.talkChildren>div{
			display: flex;
			flex-direction: row;
		}
		
		.talkChildren_reply{
			text-align: right;
		}
		
		.talkChildren>img{
			
		}
	</style>
</head>
<body>
	<table>
		<tr>
			<td class="type-container" valign="top" align="center" >
				<div class="type-user">
					<!-- 头像 -->
					<div class="type-user-icon"><img alt="" src="../img/221190.jpg" width="100px" width="100px"></div>
					<!-- 评论人 -->
					<div class="type-user-name">小明时代大厦</div>
				</div>
			</td>
			<td class="type-info-detail">
				<!--内容-->
				<div class="type-info-detail-text" >传腾讯音乐10月赴美上市，融资40亿美元，估值近一个网易？ 经理人分享 百家号08-2501:04 在7月份腾讯向港交所提交了《建议分拆腾讯音乐娱乐集团》的文件后，腾讯音乐的赴美上市之路，正式进入了倒计时。而与之相伴而来的，则是腾讯音乐的估值水涨船高。 今日有知情人士称，腾讯音乐娱乐集团计划在今年9月底启动赴美首次公开招股(IPO)前推介活动，10月上市，融资30亿美元至40亿美元。 腾讯音乐是中国最大流媒体音乐公司。今年5月，《金融时报》报道称，腾讯音乐已经聘请高盛集团、摩根士丹利以及美银美林牵头安排备受期待的IPO事宜。银行家们预计，这笔IPO交易对腾讯音乐的估值超过300亿美元。 值得注意的是，此前腾讯音乐上市预计估值超过300亿美元——仅略低于同为互联网音乐巨头的网易公司当前的总市值350亿美元，在资本的明码标价下，二者高下立显。这意味着，腾讯音乐在中概股中的市值排名将超过微博，并接近一整个网易（当前市值约 343 亿美元）的体量。 不过腾讯音乐业务很多元化——自从合并了原QQ音乐旗下的包括QQ音乐、全民K歌等在内的数字音乐播放器、移动在线K歌、版权转授权及广告业务；CMC旗下的酷狗、酷我、海洋、彩虹、源泉等公司的主营业务——包括数字音乐播放器、音乐直播秀场、版权转授权、广告、游戏联运及其他音乐衍生业务等，算是当前业务板块最多元化的互联网音乐平台。 近几年，文娱产业价值创造力备受瞩目，但风口之下问题隐现，狂欢背后多了几分冷静与反思。 音乐产业里也时有“急于求成”的案例，但音乐归根结底是一门“慢生意”。相较于影视和游戏来说，音乐市场的培育需要较长的周期，而被互联网重塑后的新型市场尚未成熟。</div>
				<!--附件/日期/贴子楼层-->
				<div style="clear: both;"></div>
				<div class="type-info-detail-info" >
					<div class="type-info-detail-info-you">
						<div class="type-info-detail-info-txt">
							<div class="type-info-detail-info-floor">1楼</div>
							<div class="type-info-detail-info-titleTime">使用网页版发布于：2018-9-9 10:12</div>
							<div class="type-info-detail-info-talk"><a href="#">回复(12)</a></div>
						</div>
						<div align="left" class="talkChildren" >
							<div>
								<div><img alt="" width="50" height="50" src="../img/2018-09-02_170321.jpg" ></div>
								<div>传腾讯音乐10月赴美上市，融资40亿美元，估值近一个网易？ 经理人分享 百家号08-2501:04 在7月份腾讯向港2222222222222222222222222222222222222222222222222交所提交了《建议分拆腾讯音乐娱乐集团》的文件后，腾讯音乐的赴美上市之路，正式进入了倒计时。而与之相伴而来的，则是腾讯音乐的估值水涨船高。 今日有知情人士称，腾讯音乐娱乐集团计划在今年9月底启动赴美首次公开招股(IPO)前推介活动，10月上市，融资30亿美元至40亿美元。 腾讯音乐是中国最大流媒体音乐公司。今年5月，《金融时报》报道称，腾讯音乐已经聘请高盛集团、摩根士丹利以及美银美林牵头安排备受wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww</div>
							</div>
							<div class="talkChildren_reply">
								<div>2018-08-20 18.31</div>
								<div>回复</div>
							</div>
						</div>
						
					</div>
					
				</div>
				<div style="clear: both;"></div>
			</td>
		</tr> 
	</table>

</body>
</html>