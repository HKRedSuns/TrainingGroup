// 没有登录点击会出现登录框
function show_login(event){
    var e = event || window.event;
    // 用cook判断
   if( getCookie("headImg") == ''){
       e.preventDefault()
       // 验证码
    createCode();
    $(' #login_page').fadeIn(400)
   }
}
// 测试成功
// document.onclick=function(){
//     alert(1)
// }