Zepto(function($){
//微信配置注册	
	aqApi('/html/login.html');
	
//点击微信扫一扫
	$('.rich-scan').click(function(){
		wx.scanQRCode({
			needResult: 1, 			// 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
			scanType: ["qrCode"], 	// 可以指定扫二维码还是一维码，默认二者都有
			success: function(res){
				var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
				$.ajax({
					url: '/ebook/system/checkDepartmentCode',
					type: 'post',
					data: {
						departmentCode: result
					},
					success: function(data){
						if(data.code == 200){
							window.location.href = '/ebook/html/personal/register.html?code='+result;
						}else{
							alertTs('企业码错误，请确认扫描的二维码','提示');
						}
					}
				})
			}
		});
	});
	
//点击登陆
	$(".login").click(function() {
		if (check()) {
			var user = $("#username").val();
			var psd = hex_md5($('#pwd').val());
			loginStatus({username:user,pwd:psd});
		};
	});
	
//免登陆
	$('.avoid-login').click(function(){
		var psd = hex_md5('11111111');
		loginStatus({username: 16666666666,pwd: psd});
	});
	
//登录函数	
	function loginStatus(dataObj){
		$.ajax({
			type : "post",
			url : "/ebook/validateUser",
			data : dataObj,
			success : function(data) {
				if (data.code == "200") {
					localStorage.setItem('departName',data.topDepartmentName);
					localStorage.setItem('openId',true);
					localStorage.setItem('funcIntroduction','true,true,true,true,true,true');
					pageGuide();
				} else {
					alertTs('请检查您的用户名或密码是否正确','提示');
				};
			}
		});
	};
	
//获取openId
	function aqOpenId(path){
		$.ajax({
			url:'/ebook/user/checkOpenId',
			type:'post',
			data: {
				path: path
			},
			success:function(data){
               window.location.href = data.codeUrl;
			}
		});
	};
	
//登录成功后页面跳转
	function pageGuide(){
		var url = top.document.referrer;
		if(url.indexOf('todayWork.html?type=1') !== -1){
			aqOpenId('/html/position/todayWork.htm?type=1');
			return;
		};
		if(url.indexOf('todayWork.html?type=2') !== -1){
			aqOpenId('/html/position/todayWork.htm?type=2');
			return;
		};
		if(url.indexOf('weekBigEventList.html') !== -1){
			aqOpenId('/html/position/weekBigEventList.html');
			return;
		};
		if(url.indexOf('answerActivity.html') !== -1){
			aqOpenId('/html/activity/answerActivity.html');
			return;
		};
		if(url.indexOf('bookRack.htm?rack=6') !== -1){
			aqOpenId('/html/myTest/goTest.html');
			return;
		};
		if(url.indexOf('bookRack.htm?rack=7') !== -1){
			aqOpenId('/html/myTest/letTest.html');
			return;
		};
		if(url.indexOf('goldRead.html') !== -1){
			aqOpenId('/html/read/goldRead.html');
			return;
		};
		if(url.indexOf('jobRead.html') !== -1){
			aqOpenId('/html/read/jobRead.html');
			return;
		};
		if(url.indexOf("bookSearch.htm") !== -1){
			aqOpenId('/html/read/bookSearch.htm');
			return;
		};
		if(url.indexOf("personal.html") !== -1){
			aqOpenId('/html/personal.html');
			return;
		};
		if(url.indexOf('practiceTest.htm') !== -1){
			aqOpenId('/html/test/practiceTest.htm?mix=3&type=1');
			return;
		};
		if(url.indexOf("question-bank.htm") !== -1){
			aqOpenId('/html/test/question-bank.htm');
			return;
		};
		if(url.indexOf("questionRead.htm") !== -1){
			aqOpenId('/html/read/questionRead.htm');
			return;
		};
		if(url.indexOf('bookRack.htm?rack=4') !== -1){
			aqOpenId('/html/read/bookRack.htm?rack=4');
			return;
		};
		if(url.indexOf('bookRack.htm?rack=3') !== -1){
			aqOpenId('/html/read/bookRack.htm?rack=3');
			return;
		};
		aqOpenId('/html/read/bookSearch.htm');
	};

//登陆前的一些校验	
	function check() {
		var username = $("#username").val();
		var pwd = $("#pwd").val();
		if (username == "") {
			alertTs('请您输入用户密码后登陆','提示');
			return false;
		};
		if (pwd == "") {
			alertTs('请您输入用户密码后登陆','提示');
			return false;
		};
		return true;
	};
})