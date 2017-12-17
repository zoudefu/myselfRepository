$(document).ready(function(){ 
  $('.login-button-class').click(function(){
	  debugger;
	  var userName=$('#username').val();
	  var passWord=$('#pwd').val();
	  $.ajax({
			type : "post",
			url : "/ydfr/login",
			data : {userName:userName,
				    passWord:passWord},
			success : function(data) {
					alert('请检查您的用户名或密码是否正确');
			}
		});
  });
}); 