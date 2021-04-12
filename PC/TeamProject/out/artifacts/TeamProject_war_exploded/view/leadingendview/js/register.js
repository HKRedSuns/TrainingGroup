
$(function () {
    var temp; // 验证码
    var sendTo = 1; // 控制器
    // 用户名
    $(document).keydown(function (event) {
        var event = window.event || event;
        if (event.keyCode == 13) {
            $('#submit').click()
        }
    })
    var myName = document.getElementById('myName');
    // var err = document.getElementsByTagName('span');

    myName.oninput = myName.onpropertychange = function () {
        if (this.value != "") {
            var name = /^[\u4e00-\u9fa5]{3,10}$|^[\dA-Za-z_]{4,14}$/;
            if (!name.test(myName.value)) {
                $('i').addClass('name_false');
                $(".err")[0].innerHTML = "用户名请以汉字或者以数字、字母和下划线组合";
                sendTo = 0;
            } else {
                $.ajax({
                    type: "POST",
                    url: "/UserName_Verification",
                    data: $('#myName').serialize(),// 序列化表单值  
                    async: true,
                    error(request) {
                        return false;
                    },
                    success(data) {  //成功
                        var data = parseInt(data);
                        if (data == 1) {
                            $('i').removeClass('name_true');
                            $('i').addClass('name_false');
                            $(".err")[0].innerHTML = "用户名已被注册";
                            sendTo = 0;
                        } else if (data == -1) {
                            $('i').removeClass('name_false');
                            $('i').addClass('name_true');
                            $(".err")[0].innerHTML = "";
                            sendTo = 1;
                        }


                    }
                });
            }

        } else {
            $('i').removeClass('name_false');
            $('i').removeClass('name_true');
            $(".err")[0].innerHTML = "";

        }



    }

    // 密码
    var pass = document.getElementById("myPass")
    pass.oninput = pass.onpropertychange = function () {
        if (this.value != "") {
            $('s').addClass('eye')
        } else {
            $('s').removeClass('eye')
        }

    }

    $('#myPass').on('blur', function () {
        const password = /^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)(?!([^(0-9a-zA-Z)])+$).{6,20}$/;
        if (!password.test($(this).val()) && $(this).val() != '') {
            $(".err")[1].innerHTML = "密码包含 数字,英文,字符中的两种以上，长度6-20";
            sendTo = 0;
        } else {
            $(".err")[1].innerHTML = "";
            sendTo = 1;
        }
    })

    // 隐藏眼睛
    $('s').mousemove(function () {
        pass.type = "text"
    })
    $('s').mouseout(function () {
        pass.type = "password"
    })
    // 验证码

   var myCode = document.getElementById('myCode');
   myCode.oninput = pass.onpropertychange = function () {
    if(this.value==""){
        $('.err')[3].innerHTML = '';
            sendTo = 1
        // alert(1)
    }
   }

    // 邮箱

    $('#send').on('click', function () {
        if ($('#myEmail').val() == '') {
            $('.err')[2].innerHTML = '请填写邮箱';
            return

        }
        const email = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,})$/;

        if (!email.test($('#myEmail').val())) {
            alert('邮箱格式错误')
            $('.err')[2].innerHTML = '邮箱格式错误';
            sendTo = 0
            return
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
                clearInterval(timer);  // 清除定时器
                count = 60;

            }
        }
        $.ajax({
            type: "POST",
            url: "/RegVerification",
            data: $('#myEmail').serialize(),
            async: true,
            error(request) {
                alert("发送失败");
            },
            success(data) {  //成功
                temp = data;
            }
        })

    })




    $("#submit").click(function () {
        var userName = $.trim($("#myName").val());
        var passWord = $.trim($("#myPass").val());
        var email = $.trim($("#myEmail").val());
        var code = $.trim($("#myCode").val());
        var isSuccess = 1;
        if ($('#myCode').val() != temp) {
            $('.err')[3].innerHTML = '验证码有误';
            sendTo = 0
        }


        if (userName == "") {
            $(".err")[0].innerHTML = "用户名不能为空";
            isSuccess = 0;
        }
        if (passWord == "") {
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
            url: "/Register",
            data: $('#myForm').serialize(),// 序列化表单值  
            async: true,
            error(request) {
                alert("用户信息有误,请从新填写");
                // 清空数据
                $('s').removeClass('eye')
                $('i').removeClass('name_false');
                $(".err")[0].innerHTML = "";
                $('#myForm')[0].reset();
            },
            success(data) {  //成功
                alert(data);  //就将返回的数据显示出来
                window.location.href = "跳转页面";
            }
        });
    })

})

