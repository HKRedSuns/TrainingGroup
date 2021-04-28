$(function() {
	var temp; // 验证码
	var sendTo = 1; // 控制器
	// 用户名
	$(document).keydown(function(event) {
		var event = window.event || event;
		if (event.keyCode == 13) {
			$('#submit').click()
		}
	})


	$('#newPassword').on('blur', function() {
		const password = /^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)(?!([^(0-9a-zA-Z)])+$).{6,20}$/;
		if (!password.test($(this).val()) && $(this).val() != '') {
			$(".err")[0].innerHTML = "密码包含 数字,英文,字符中的两种以上，长度6-20";
			sendTo = 0;
		} else {
			$(".err")[0].innerHTML = "";
			sendTo = 1;
		}
	})


	/* 两次密码动态校验 */
	var pass2 = document.getElementById('newPassword');
	pass2.oninput = pass2.onpropertychange = function() {
		//input propertychange即实时监控键盘输入包括粘贴
		var pwd = $.trim($(this).val());
		//获取this，即newPassword的val()值，trim函数的作用是去除空格
		var rpwd = $.trim($("#repeatPassword").val());
		if (this.value != "") {
			$('s').addClass('eye')
		} else {
			$('s').removeClass('eye')
		}
		if (rpwd != "") {
			if (pwd != rpwd) {
				$(".err")[1].innerHTML = "两次输入密码不匹配,请重输！";
			} else {
				$(".err")[1].innerHTML = "";
			}
		}
	}
	//由于是两个输入框，所以进行两个输入框的几乎相同的判断
	var pass1 = document.getElementById('repeatPassword');
	pass1.oninput = pass1.onpropertychange = function() {
		var pwd = $.trim($(this).val());
		var rpwd = $.trim($("#newPassword").val());
		if (pwd != rpwd) {
			$(".err")[1].innerHTML = "两次输入密码不匹配,请重输！";
		} else {
			$(".err")[1].innerHTML = "";
		}
	}



	// 隐藏眼睛
	$('s').mousemove(function() {
		pass2.type = "text";
	})
	$('s').mouseout(function() {
		pass2.type = "password"
	})

// 验证码

var myCode = document.getElementById('myCode');
myCode.oninput = myCode.onpropertychange = function () {
 if(this.value==""){
	 $('.err')[3].innerHTML = '';
		 sendTo = 1
	//  alert(1)
 }
}

	// 邮箱

	$('#send').on('click', function() {
		if ($('#myEmail').val() == '') {
			$('.err')[2].innerHTML = '请填写邮箱';
			return

		}
		const email = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,})$/;

		if (!email.test($('#myEmail').val())) {
			alert('邮箱格式错误')
			$('.err')[2].innerHTML = '邮箱格式错误';
			return
			sendTo = 0
		} else {
			alert('验证码已发送到您的邮箱，如若长时间未接受到，请前往垃圾邮件内查看')
			$('.err')[2].innerHTML = '';

		}

		var timer = null; // 定时器的名称
		var count = 60;
		clearInterval(timer); // 点击后就清除定时器
		this.disabled = true; // 点击后 让此标签不能再次被点击 disabled 不可用的

		var that = this;

		timer = setInterval(change, 1000); // 开启定时器
		function change() {
			count--;
			if (count >= 0) {
				that.innerHTML = count + "秒";
			} else {
				that.innerHTML = "重新发送";
				that.disabled = false;
				clearInterval(timer); // 清除定时器
				count = 60;

			}
		}
		$.ajax({
			type: "POST",
			url: "/Project/Login?action=emailCheck",
			data: $('#myEmail').serialize(),
			async: true,
			error(request) {
				alert("发送失败");
			},
			success(data) { //成功
				//测试
				// alert(data);
				temp = data;
			}
		})

	})




	$("#submit").click(function() {
		var newPassword = $.trim($("#newPassword").val());
		var repeatPassword = $.trim($("#repeatPassword").val());
		var email = $.trim($("#myEmail").val());
		var code = $.trim($("#myCode").val());
		var isSuccess = 1;
		if ($('#myCode').val() != temp) {
			$('.err')[3].innerHTML = '验证码有误';
			sendTo = 0
		}

		if (newPassword == "") {
			$(".err")[0].innerHTML = "密码包含 数字,英文,字符中的两种以上，长度6-20";
			isSuccess = 0;
		}
		if (repeatPassword == "") {
			$(".err")[1].innerHTML = "密码包含 数字,英文,字符中的两种以上，长度6-20";
			isSuccess = 0;
		}
		if (email == "") {
			$(".err")[2].innerHTML = "请填写邮箱,获取验证码";
			isSuccess = 0;
		}
		if (code == "") {
			$(".err")[3].innerHTML = "";
			isSuccess = 0;
		}

		if (isSuccess == 0) {
			return false;
		}
		if (sendTo == 0) {
			// alert('请认真填写数据');
			return false;
		}
		$.ajax({
			type: "POST",
			url: "/Project/Login?action=retrieve",
			data: $('#myForm').serialize(), // 序列化表单值  
			async: true,
			error(request) {
				alert("用户信息有误,请从新填写");
				// 清空数据
				$('s').removeClass('eye')
				$('i').removeClass('name_false');
				$(".err")[0].innerHTML = "";
				$('#myForm')[0].reset();
			},
			success(data) { //成功
				alert(data); //就将返回的数据显示出来
				window.location.href = "/view/leadingendview/view/login.html";
			}
		});
	})

})
