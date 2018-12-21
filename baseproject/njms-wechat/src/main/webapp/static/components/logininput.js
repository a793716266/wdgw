Vue.component("logininput",{
	props:["toRegister","byWechat","byQq"],
	template:`
	
<form action="userList.do"  method="post" id="myForm" onkeydown="on_return();">
	<div class="accountContainer">
		<div class="loginTitle">
			用户登录
		</div>
		<div class="loginInput account">
			<div class="loginicon account"></div>
			<input id="account" placeholder="输入账号" name="phonenumber"/>
		</div>
		<div id="account-text"></div>
		<div class="loginInput password">
			<div class="loginicon password"></div>
			<input id="password" placeholder="输入密码" type="password" name="password"/>
		</div>
		<div id="password-text"></div>
		<input class="loginInput" id="btnlogin" type="button" value="点击登录" />
		<div class="loginInput toRegister">
			<div>
				<span>还没有账号？</span>
				<a href="toRegister.do">马上注册</a>
			</div>
		</div>
		<div class="thirdLogin">
			<div class="thirdLoginTitle">快捷登录</div>
			<div class="btnThirdLogin" id="btnwechat" title="微信登录" :data-href="byWechat" onClick="weixinLogin()"></div>
			<div class="btnThirdLogin" id="btnqq" title="QQ登录" :data-href="byQq"></div>
		</div>
	</div>
	</form>
	`
})
