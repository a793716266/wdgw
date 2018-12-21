Vue.component("reigsterinput",{
	props:[],
	template:`
	<div class="contain">
			<div class="register">
				<form :action="getPath()+'/wd/registeruser.do'" method="post" id="register">
					<div class="title">用户注册</div>
						<div class="dataDiv-text"></div>
					<div class="dataDiv">
						<input class="inp" id="phone" name="phonenumber" type="text" placeholder="请输入手机号" />
					</div>
					<div class="phone-text"></div>
					<div class="dataDiv">
						<input class="inp" id="password" name="password" type="password" placeholder="请6位以上输入密码" />
					</div>
					<div class="password-text"></div>
					<div class="dataDiv">
						<input class="inp" id="repassword" name="repassword" type="password" placeholder="请重复输入密码" />
					</div>
					<div class="repassword-text"></div>
					<div class="dataDiv">
						<input class="code inp" id="code" name="code" type="text" placeholder="验证码" />
						<input class="codebtn codebtnDefault" id="codebtn" type="text" value="获取验证码" />
					</div>
					<div class="code-text"></div>
					<div class="dataDiv">
						<input class="inp submit" type="button" value="立即注册" />
					</div>
				</form>
			</div>
		</div>
	`,
	methods:{
		// 获取项目路径
		getPath:function(){
			let path = window.location.href
			let pathName = window.location.pathname
			let pos = path.indexOf(pathName)
			return path.substring(0,pos)
		}
	}
})
