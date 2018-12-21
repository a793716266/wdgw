
	var wait=60;//倒计时初始值
	var end = new Date();
	var isRe = false;//是否被注册
$(function(){
	$(".submit").click(verifications);
	$("#codebtn").click(function(){
		if(phoneVerification()){
			var phone = $("#phone").val();
			isRegister(phone);
			if(!isRe){
				return false;
			}
			sendCode();//ajax发送验证码
		}
		return false;
	})
	

	/*验证码验证方法*/
	function codeVerification(){
		var phone = $("#phone").val();
		$.ajax({  
            url:"codeVerification.do",
            type:"post",
            data:{"phone_number":phone},
            dataType: "json",  
            async:false,
            success: function(data){  
            var	codeData = data;
			if(codeData == null){
				$(".code-text").html("<div class='waining'></div><div id='account-text-w'></div>");
				$(".code-text #account-text-w").html("请先获取手机验证码！");
				 isRe= false;
				 return;
			}
			if(codeData === -1){
				$(".code-text").html("<div class='waining'></div><div id='account-text-w'></div>");
				$(".code-text #account-text-w").html("手机验证码失效，请重新发送！");
				 isRe= false;
				 return;
			}
			var code = $("#code").val();
			if(code != codeData || code == null || code =='') {
				//验证码错误
				$(".code-text").html("<div class='waining'></div><div id='account-text-w'></div>");
				$(".code-text #account-text-w").html("验证码错误！");
				 isRe = false;
				 return;
			}else{
				$(".code-text").html("<div class='ok'></div>");
				$(".code-text .ok").css("background-image","url(../static/img/account/ok.png)");
			}
			isRe = true;
            }
        })
	}
	
	//ajax发送验证码
	function sendCode(){
		var phone = $("#phone").val();
		$.ajax({  
            url:"sendCode.do",
            type:"post",
            data:{"phone_number":phone}, 
            async:false,
            dataType: "json",  
            success: function(data){  
            	//return -1;  //时间过短
            	//return 0;   //发送成功
            	//return 1;   //非法手机号
            	//return 2;   //业务限流(操作过于频繁)
            	//return 3;   //其他错误
				$(".code-text").empty();
            	switch (data) {
            	case 0:
	                 countdown($('#codebtn')); //实现发送验证码倒计时60s
					break;
				case -1:
					$(".code-text").html("<div class='waining'></div><div id='account-text-w'></div>");
					$(".code-text #account-text-w").html("时间过短,请一分钟后再试！");
					break;
				case 1:
					$(".code-text").html("<div class='waining'></div><div id='account-text-w'></div>");
					$(".code-text #account-text-w").html("手机号非法！");
					break;
				case 2:
					$(".code-text").html("<div class='waining'></div><div id='account-text-w'></div>");
					$(".code-text #account-text-w").html("操作过于频繁！");
					break;
				default:
					$(".code-text").html("<div class='waining'></div><div id='account-text-w'></div>");
					$(".code-text #account-text-w").html("发生错误！");
					break;
				}
            }  
           
        });  
	}
	
	/*验证码组件悬浮事件*/
	$("#codebtn").hover(function(){
		if(isRe && phoneVerification() && wait==60){
		    $(this).removeClass("codebtnActive").addClass("codebtnHover");
		}
		},function(){
		if(isRe && phoneVerification() && wait==60){
			$(this).removeClass("codebtnHover").addClass("codebtnActive");
		}
	});

	/*手机号错误的提示*/
	function phoneError(){
		$(".phone-text").empty();
		$(".phone-text").html("<div class='waining'></div><div id='account-text-w'></div>");
		$(".phone-text #account-text-w").html("请输入正确的手机号码！");
	  	$("#codebtn").removeClass("codebtnActive").addClass("codebtnDefault");
	}
	/*手机号值被更改时*/
	$('#phone').bind('input propertychange', function() {
		if(!phoneVerification()) {
			phoneError();
			return false;
		}
		var phone = $("#phone").val(); //获取输入的手机号
		isRegister(phone); //验证
	  	if(wait==60 && isRe){
	  		$("#codebtn").removeClass("codebtnDefault").addClass("codebtnActive");
	  	}
	})
	
	/*手机号失去焦点验证手机号是否已被注册*/
	$("#phone").blur(function(){
		if(!phoneVerification()) {
			phoneError();
			return false;
		}
		var phone = $("#phone").val();
		isRegister(phone);
	})
	
	/*密码验证*/
	$("#password").blur(function(){
		passwordVerification();
	}).focus(function(){
		$(".password-text").empty();
	})
	/*密码二次验证*/
	$("#repassword").blur(function(){
		if(!passwordVerification()) {
			return false;
		}
		repasswordVerification();
	}).focus(function(){
		$(".repassword-text").empty();
	})
	/*验证码验证*/
	/*$("#code").blur(function(){
		codeVerification();
	}).focus(function(){
		$(".code-text").empty();
	})*/
	

	/*验证码倒计时*/
	function countdown($code) {
	    var btn = $code;
		btn.attr('disabled',true).removeClass("codebtnActive codebtnHover").addClass("codebtnDefault");
	    var resend = setInterval(function(){
	    	wait--;
	        if (wait > 0){
	            btn.val(wait + "秒后可重发");
	        }else {
	            wait = 60;
	            clearInterval(resend);
	            btn.val("获取验证码");
	            if(phoneVerification() && wait==60){
		  			btn.removeClass("codebtnDefault").addClass("codebtnActive");
		  		}
		  		btn.attr('disabled',false);
	        }
	    }, 1000);
	}
	/*手机号验证方法*/
	function phoneVerification (){
		$(".phone-text").empty();
		var phone = $("#phone").val(); //获取输入的手机号
		var yidongreg = /^(134[012345678]\d{7}|1[34578][012356789]\d{8})$/;
		var dianxinreg = /^1[3578][01379]\d{8}$/;
		var liantongreg = /^1[34578][01256]\d{8}$/;
		if(!yidongreg.test(phone) && !dianxinreg.test(phone) && !liantongreg.test(phone)) {
			return false;
		}else{
			$(".phone-text").html("<div class='ok'></div>");
			$(".phone-text .ok").css("background-image","url(../static/img/account/ok.png)");
		}
		return true;
	} 
	/*密码验证方法*/
	function passwordVerification(){
		var password = $("#password").val();
		var reg = /^[a-zA-Z0-9]{6,}$/;
		if(reg.test(password) == false){
			//pwdId.innerHTML = "密码不能含有非法字符，长度在最小6位";
			$(".password-text").html("<div class='waining'></div><div id='account-text-w'></div>");
			$(".password-text #account-text-w").html("密码不能含有非法字符，长度在最小6位！");
			return false;
		}else{
			$(".password-text").html("<div class='ok'></div>");
			$(".password-text .ok").css("background-image","url(../static/img/account/ok.png)");
		}
		return true;
	}

	/*密码二次验证方法*/
	function repasswordVerification(){
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		if(password != repassword) {
			//repwdId.innerHTML="两次密码不一致";
			$(".repassword-text").html("<div class='waining'></div><div id='account-text-w'></div>");
			$(".repassword-text #account-text-w").html("两次密码请保持一致！");
			return false;
		}else{
			$(".repassword-text").html("<div class='ok'></div>");
			$(".repassword-text .ok").css("background-image","url(../static/img/account/ok.png)");
		}
		return true;
	}
	
	

	/*验证表单元素*/
	function verifications() {
		if(!phoneVerification()) {
			phoneError();
			return false;
		}
		var phone = $("#phone").val(); //获取输入的手机号
		isRegister(phone); //验证
		if(!isRe) {
			return false;
		}
		if(!passwordVerification()) {
			return false;
		}
		if(!repasswordVerification()) {
			return false;
		}
		codeVerification();
		if(!isRe) {
			return false;
		}
		$("#register").submit();
	}
	
	/*验证手机号是否已被注册的方法*/
	function isRegister(phone){
		$.ajax({  
            url:"isRegister.do",
            type:"post",
            data:{"phone_number":phone}, 
            async:false,
            dataType: "json",  
            success: function(data){  
            	//data -1 已存在    0 不存在,可以注册
            	if(data === -1){
            		$(".phone-text").empty();
                	$(".phone-text").html("<div class='waining'></div><div id='account-text-w'></div>");
            		$(".phone-text #account-text-w").html("此手机号码已被注册！");
            	  	$("#codebtn").removeClass("codebtnActive").addClass("codebtnDefault");
            	  	isRe = false;
            	  	return;
            	}
            	isRe = true;
            }  
           
        });
	}
})