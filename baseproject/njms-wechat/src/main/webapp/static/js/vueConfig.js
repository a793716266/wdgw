const vm = new Vue({
	el:'#app',
	data:{
		flowpathlist:[{},{},{}],
		// ui信息集合
		uilist : [{}],
		// 合作院校
		academylist:[{},{},{},{},{}],
		//合作企业
		companylist:[{},{},{},{},{}],
		// java信息集合
		javalist : [{}],
		// web信息集合
		weblist :  [{}],
		flowpathye :[{},{},{},{},{},{},{},{}],
		// ui优秀学员信息集合
		commentuiList : [{users:[{}]}],
		// java优秀学员信息集合
		commentjavaList : [{users:[{}]}],
		// web优秀学员信息集合
		commentwebList : [{users:[{}]}],
		//首页轮播图
		broadcastList:[{},{},{}],
		//免费课程页轮播图
		freebroadcast:[{},{},{}],
		//名师团队页轮播图
		teacherbroadcast:[{},{},{}],
		//学员风采页轮播图
		studentbroadcast:[{},{},{}],
		// 课程列表
		courselist:[{},{},{},{}],
		// 班级列表
		clzlist:[{},{},{},{},{},{},{},{},{},{}],
		// 已工作学生列表
		joblist:[{},{},{},{}],
		//实训项目列表
		businesspracticelist:[],
		//金牌讲师列表
		teacherlist:[{},{},{},{},{},{},{},{},{}],
		// 班主任列表
		banzhurenlist:[{},{},{},{},{},{},{},{}],
		// HR们对学员的评价
		ratelist:[],
		// Java新闻详情展示
		javaFirstNews:[],
		//Java新闻列表展示 
		javaListNews:[],
		newsListh:[{}],
		newsListx:[{}],
		// C#新闻详情展示
		cFirstNews:[],
		// C#新闻列表展示
		cListNews:[],
		// UI开班信息列表展示
		ui_class: [],
		// JAVA开班信息列表展示
		java_class : [],
		// WEB开班信息列表展示
		web_class:[],
		// 优秀学员列表
		stulist:[],
		//优秀UI学员列表
		gooduiListto:[{},{},{},{},{},{},{},{},{},{}],
		//优秀JAVA学员列表
		goodjavaListto:[{},{},{},{},{},{},{},{},{},{}],
		//优秀WEB学员列表
		goodwebListto:[{},{},{},{},{},{},{},{},{},{}],
		//免费JAVA课程
		freecoursejavalist:[{},{},{},{},{},{},{},{},{},{},{},{}],
		//免费UI课程
		freecourseuilist:[{},{},{},{},{},{},{},{},{},{},{},{}],
		//免费WEB课程
		freecoursehalist:[{},{},{},{},{},{},{},{},{},{},{},{}],
		//项目列表
		projectlist:[{},{},{},{},{}],
		//UI项目列表
		uiprojectlist:[{},{},{},{},{}],
		//JAVA项目列表
		javaprojectlist:[{},{},{},{},{}],
		//WEB项目列表
		webprojectlist:[{},{},{},{},{}],
		//新闻列表
		newslist:[{createTime:"8-06"},{createTime:"8-06"},{createTime:"8-06"},{createTime:"8-06"},{createTime:"8-06"}],
		//推荐新闻
		allNewsDesclist:[{},{},{},{},{}],
		//
		footlist:[],
		//
		campusinfo:[],
        //视频推荐
        videolistall:[{},{},{},{}],
        //学习/生活类型
        postTypeStudyList:[{},{},{},{},{},{}],
        postTypeLifeList:[],
        //热门话题
        postHotList:[],
        replypostlist:[],
        Activeman:[],
        checkposthost:[],
        //帖子回复
        replypostlist:[],
		//精华回复
		checkhostrep:[]
	},
	methods:{
		// 项目展示部分切换选项卡
		changePorject:function(projectType){
			this.projectlist = this[projectType.toLowerCase()+"projectlist"]
		},
		// 获取项目路径
		getPath:function(){
			let path = window.location.href
			let pathName = window.location.pathname
			let pos = path.indexOf(pathName)
			return path.substring(0,pos)
		},
		getAdminPath:function(){
			/*return "http://admin.zbkgc.com/static/login/upload/";*/
			return "http://127.0.0.1:8080/njms-admin/static/login/upload/";
		},
		getProjPath:function(){
			return "http://www.zbkgc.com/";
		}
		
	}
});
