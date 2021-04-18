// 轮播图
var slider = document.getElementsByClassName('slider')[0];
var sli_lef = document.getElementsByClassName('sli_lef')[0];
var sli_rig = document.getElementsByClassName('sli_rig')[0];
var sli_num = document.getElementById('sli_num');
var lis = sli_num.children;
// 移除和移入的效果
slider.onmouseover=function(){
    sli_rig.style.display="block"
    sli_lef.style.display="block"
}
slider.onmouseout=function(){
    sli_rig.style.display="none"
    sli_lef.style.display="none"
}
//轮播时间
window.onload = function(){
    init();
}
function init(){
    //window.setTimeout(changeImg,2000);
    window.setInterval(changeImg,3000);
}
//用数组放图片
var arr = new Array("./view/leadingendview/img/slider_1.png","./view/leadingendview/img/slider_2.png","./view/leadingendview/img/slider_3.png");

var index = 0;//数组从0开始

function changeImg(){
    nextImg();
}
//上一张
function onImg(){

    index--;
    if(index<0){
        index = arr.length-1;
    }
    for(var i = 0 ; i < lis.length ; i++){
        lis[i].className=''
    }
    lis[index].className="active"
    myImg.src=arr[index];
}
//下一张
function nextImg(){
    index++;
    if(index>=arr.length){
        index = 0;
    }
    for(var i = 0 ; i < lis.length ; i++){
        lis[i].className=''
    }
    lis[index].className="active"
    myImg.src=arr[index];
}

