
   
    // 盒子消失
    function box_hide(){
        $(' #login_page').click(function(event){
            // jq消失动画
            $(this).fadeOut(800)
			// 清除数据
			$('#myForm')[0].reset();
			for(let i = 0 ; i < 3 ; i++){
				$('.err')[i].innerHTML=''
			}
            event.stopPropagation();
        })
        $(' #login_box').click(function(event){
            //阻止冒泡
            var event = event || window.event; 
            event.stopPropagation();
        })
    }
    box_hide();
   // 验证码
   var code;
   function createCode() {
	   code = "";
	   var codeLength = 4;
	   var codeNum = $('#codeNum');
	   var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
	   for (var i = 0; i < codeLength; i++) {
		   var index = Math.floor(Math.random() * 36);
		   code += random[index];
	   }
	   $('#codeNum').html(code);

   }
   $('#codeNum').click(function () {
	   createCode();
   })
   // 绑定回车键  
   $(document).keydown(function (event) {
	   var event = window.event || event;
	   if (event.keyCode == 13) {
		   $('#btn').click()
	   }
   })

   // 当失去焦点时

   $('#userName').blur(function () {
	   if ($('#userName').val().length > 0) {
		   $(".err")[0].innerHTML = "";
	   }
   })
   $('#passWord').blur(function () {
	   if ($('#passWord').val().length > 0) {
		   $(".err")[1].innerHTML = "";
	   }
   })
   $('#verification').blur(function () {
	   if ($('#verification').val().length > 0) {
		   $(".err")[2].innerHTML = "";
	   }
   })


   // 点击发送
   $('#btn').click(function () {
	//    alert(1)
	console.log()
	   var userName = $.trim($("#userName").val());
	   var passWord = $.trim($("#passWord").val());
	   var verification = $.trim($("#verification").val());
	   var bigStr = verification.toUpperCase();

	   var isSuccess = 1;

	   if (userName == '') {
		   $(".err")[0].innerHTML = "用户名不能为空!";
		   isSuccess = 0;
	   }
	   if (passWord == '') {
		   $(".err")[1].innerHTML = "密码不能为空！";
		   isSuccess = 0
	   }
	   if (verification == '') {
		   $(".err")[2].innerHTML = "请输入验证码！";
		   isSuccess = 0;
	   } else if (verification.length != 4 || bigStr != code) {
		   $(".err")[2].innerHTML = "请输入正确的验证码";
		   createCode();
		   isSuccess = 0;
	   }
	   if (isSuccess == 0) {
		   return false;
	   }
	   $.ajax({
		   type: "POST",
		   url: "/Project/Login?action=login",
		   data: $('#myForm').serialize(),// 序列化表单值
		   async: false,
		   error(request) {
			   alert("提交失败");
		   },
		   success(data) {  // 请求成功
			   // alert(typeof(data));  // string 类型
			   var data = parseInt(data); // 转换
			   if (data == 1) {
				   alert('登录成功');
				   window.location.href = "./../../../index.html";
			   }else { // 0用户不存在
				   alert('登录失败,用户名或密码错误');
				   createCode();
				   return false;
			   }

		   }
	   });

   })
