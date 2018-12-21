//头部
Vue.component("wdheader",{ 
	props:["user"],
	template:`
			<div class="header">
				<div class="container">
					<div class="header-top displayFlex">
						<div class="logo"></div>
						<div class="banner"></div>
					</div> 
					<div class="header-bottom displayFlex">
						<ul class="nav-top displayFlex">
							<li><a href="wd/toIndex.do">首页</ a></li>
							<li><a href="wd/toFreecourse.do">免费课程</ a></li>
							<li><a href="wd/toTeacher.do">名师团队</ a></li>
							<li><a href="wd/toStudent.do">学员风采</ a></li>
							<li><a href="wd/toProcessPage.do">报名流程</ a></li>
							<li><a href="wd/gotoNewsDetail.do?newsid=129bcf2cb8f7494b9008d335fab9ee16">校区介绍</ a></li>
							<li class="nav-item-tribune">
								<a href="wd/forum.do">技术论坛</ a>
							</li>
						</ul>
						<div class="userinfo displayFlex" style="height:58px">
						   <div @mouseover="overShow(user)" @mouseout="outHide">
							<div class="portrait" style="float:left" id="userPortrait" :style="user?'background-image:url('+toJSON(user).picture+')':'' " @click="toLogin()"></div>
							<div style="float:left" class="nickname" ref="menuItem" @click="toLogin(user)">
							{{user?toJSON(user).nickname:'未登录'}}<span style="display:none" id="status">{{user?toJSON(user).nickname:''}}</span>
						</div>		
								<div @mouseover="overShow(user)" @mouseout="outHide" class="list" style="margin-top:52px;margin-left:60px;display:none;transform:translate(-55px,0);background-color:white;z-index:10;position:relative;font-size:14px;width:130px">
									<div style="transform:translate(20px,15px)">
										<ul class="show" style="height:180px" >
											<li style="height:30px;cursor: pointer" @click="toMySub()"> 我 的 课 程<span style='color:#FEA73F;'>&nbsp;&nbsp;{{user?toJSON(user).projectNum:'0'}}</span></li>
											<li style="height:30px;cursor: pointer" @click="toMyPosts()"> 我 的 贴 子 <span style='color:#FEA73F;'>({{user?toJSON(user).postNum:'0'}})</span></li>
											<li style="height:30px;cursor: pointer" @click="toMySys()"> 系 统 消 息 <span style='color:#FEA73F;'>({{user?toJSON(user).sysNum:'0'}})</span></li>
											<li style="height:30px;cursor: pointer" @click="toUpd()"> 账 号 设 置 </li>
											<li style="height:30px;cursor: pointer" @click="toExit()"> 退 出 登 录 </li>
										</ul>
									</div>
								</div>	
							</div>
						</div>		
					</div>
				</div>
	    	</div>` ,
			
			methods: {
				  toLogin: function (user) {
					  if(user==''){
						  window.location = "wd/toLogin.do";
					  } 
		
				  },
				  overShow:function(user){
						  if(user==''){
							  $(".list").hide();
						  }else{
							  $(".list").show();
						  }
				  },
				  outHide:function() {
					  $(".list").hide();
				  },
					getPath:function(){
						let path = window.location.href
						let pathName = window.location.pathname
						let pos = path.indexOf(pathName)
						return path.substring(0,pos);
					},
					toJSON:function(user){
						let reg = new RegExp("\'", "g" );
						console.log(JSON.parse(user.replace(reg,"\"")));
						return JSON.parse(user.replace(reg,"\""));
					}
					/*,
					getuserpath(){
						let path = window.location.href
						let pathName = window.location.pathname
						let pos = path.indexOf(pathName)
						return path.substring(0,pos)+"/njms-wechat/static/login/upload//";
					}*/
					,toMySub(){
						window.location="wd/toPerson.do?towhere=one";
					},toMySys(){
						window.location="wd/toPerson.do?towhere=four";
					},toMyPosts(){
						window.location="wd/toPerson.do?towhere=three";
					},toUpd(){
						window.location="wd/toUpdPicture.do";
					},toExit(){
						window.location="wd/toLogin.do";
					}
				}
				
			})