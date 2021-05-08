/*
# 页面加载获取页面数据
# 用户信息 文章信息 关注
*/
var userName = "";
var userBirthday = "";
var userStr = "";
var tpm_user = $("#tpm_user");
// 使用模板字符串
$.ajax({
    type: "POST",
    url: "/Project/personal_Center?action=user",
    dataType: 'json',  // 自己改值
    jsonp:'callback',
    async: false,
    success(userData) {  // 请求成功
        console.log(userData);
        var html = '';
        for(var i in userData){
            // userData[i].Blog_Title // 文章标题
            // userData[i].Blog_ContextStr // 文章

            if(typeof(userData[i].UserName)=="undefined"){
                userData[i].UserName = userName;
            }

            html+=`
            <h3>${userData[i].UserName}</h3>
                        <br>
                        <div class="info">
                            <ul>
                                <li>
                                    <a href="javascript:;"><span>${userData[i].LaunchNumber}</span>&nbsp;关注</a>
                                    <i>|</i>
                                </li>
                                <li>
                                    <a href="javascript:;"><span>${userData[i].FansNumber}</span>&nbsp;粉丝</a>
                                    <i>|</i>

                                </li>
                                <li>
                                    <a href="javascript:;"><span>${userData[i].BlogNumber}</span>&nbsp;文章</a>
                                    <i>|</i>
                                </li>
                                <li>
                                    <a href="javascript:;"><span>${userData[i].LikesNUmber}</span>&nbsp;点赞</a>
                                </li>

                            </ul>
                        </div>
            
            
            `
        }
        $('#userData').html(html)

    }
});



// 文章请求

$.ajax({
    type: "POST",
    url: "/Project/personal_Center?action=blog",
    dataType: 'json',  // 自己改值
    jsonp:'callback',
    async: false,
    success(userData) {  // 请求成功
        // var jsData = JSON.parse(userData);
        var html = '';
        userName = userData[0].Blog_UserID;
        userBirthday = userData[0].Blog_ReleaseDate;
        userStr = userData[0].Blog_Content;
        for(var i in userData){
             // userData[i].Blog_Title // 文章标题
             // userData[i].Blog_ContextStr // 文章

            html+=`
            <li>
            <div class="content">
                <a class="title" href="">
                    <h4>${ userData[i].Blog_Title}</h4>
                </a>
                <p class="article">
                    ${userData[i].Blog_ContextStr}
                </p>

            </div>
        </li>
            
            
            `
        }
        $('#note_list').html(html)
        

        
    }
})
$('#userName').val(userName);
$('#user_bir').val(userBirthday);
$('#user_str').val(userStr);
// 修改个人信息
$('#userBTN').click(function(){
   var data =  $('#UpdataMyForm').serialize();

    $.ajax({
        type: "GET",
        url: "/Project/personal_Center?action=person",
        data,
        async: false,
        success(callback) {  // 请求成功
            if(callback=="1"){
                alert("数据修改成功");
            }
        },
        error(request) {
            alert("请填写生日信息！")
        }
    })
      
})





/*
@ 实现页面头像的操作功能
@ 获取 add_img 鼠标移入移除 
@ 点击获取16张 自定义图片 保存修改
*/
var head_IMg = $('#head_IMg'); // 头像
var add_img = $('#add_img');// 头像上阴影盒子
var close_addBox = $('#close_addBox'); // 关闭更换盒子按钮
var addImgBox = $('#addImgBox'); // 更换头像的大盒子

head_IMg.mouseenter(function () {
    add_img.css('display', 'block');
});
head_IMg.mouseleave(function () {
    add_img.css('display', 'none');
});
add_img .click(function(){
    addImgBox.fadeIn(300)
})
head_IMg.click(function(){
    addImgBox.fadeIn(300)
})
close_addBox.click(function(){
    addImgBox.fadeOut(300)
})
 
// 定义img 路径
var path = '' ;
var img = '';
// 点击按钮
var upImg_btn = $('#upImg_btn');
// 获取所有的图像图片
 var lis = addImgBox.children("ul").children()

 for (var i = 0; i < lis.length; i++) {

    lis[i].onclick = function () {

        for (var j = 0; j < lis.length; j++) {
            lis[j].className = "";
        }
        this.className = "borderBox";

        img = $(this.children).attr('src');
        path = {"path":$(this.children).attr('src')};// 获取到的src路径
    };
};
// 点击修改图片

upImg_btn.click(function(){   
   addImgBox.fadeOut(300);
   $.ajax({
    type: "POST",
    url: "/Project/personal_Center?action=img",
    data: path,
    async: false,
    error(request) {
        alert("修改失败");
    },
    success(data) {  // 请求成功
        var data = parseInt(data); // 转换
        if (data == 1) {
            alert('修改成功');
            head_IMg.attr('src',img);
        }else { // 0用户不存在
            alert('修改失败');
            return false
        }

    }
   })
})