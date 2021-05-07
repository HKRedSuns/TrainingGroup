
$(".btn_send").on('click',function(){
	var now = time()
	//获取评论信息
	var text_send = $("#text_send").val();
	if(text_send == ""){
		return false;
	}
	var html;
	html = '<div class="cont">'+
				'<div class="observer-out">'+
					'<div class="observer-internal">'+
						'<div class="one img">'+
							'<img src="../comments-master/img/a.png">'+
						'</div>'+
						'<div style="margin-left: 8px;">'+
							'<div class="comment-right">'+
								'<span class="observer">'+
									'<a href="">评论者</a>'+
								'</span>'+
								'<div class="comment-content-header">'+
									'<span><i class="iconfont icon-riqishijian two"></i>'+now+'</span>&nbsp;&nbsp;&nbsp;&nbsp;'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div>'+
				'</div>'+
				'<div class="one content">'+
					'<p class="text">'+text_send+'</p>'+
					'<div class="reply-list three">'+
						
					'</div>'+
					'<div class="content_text one three">'+
						'<textarea class="col-md-10 col-sm-10 col-xl-10 con_back" id="con_back"></textarea>'+
						'<div class="col-md-2 col-sm-2 col-xl-2 btn btn-small btn_back">提交</div>'+
					'</div>'+
				'</div>'+
			'</div>';
			
	$(".tent_info").append(html);
	$(".text_send").val("");
})

$(".content_text").show();
$(".tent_info").on('click','.btn_back',function(){
	
	var back_time = time()

	
	//获取评论信息
	var con_back = $(this).parent().parent().parent().find("#con_back").val();
	if(con_back == ""){
		return false;
	}
	var html_back;
	html_back = '<div class="reply">'+
					'<div class="three">'+
						'<a class="replyname">匿名</a>:<span >@brother</span><span style="font-size: 12px; color: #969696;">&nbsp;&nbsp;<i class="iconfont icon-riqishijian two"></i>'+back_time+'</span>'+
					'</div>'+
				'</div>'+
				'<p class="indent"><span>'+con_back+'</span></p>';
	$(this).parent().parent().parent().find(".reply-list").append(html_back);
	$(this).parent().parent().parent().find("#con_back").val("");
})

//评论提交
function time(){
	function time(s) {
	    return s < 10 ? '0' + s: s;
	}
	var myDate = new Date();
	//获取当前年
	var year=myDate.getFullYear();
	//获取当前月
	var month=myDate.getMonth()+1;
	//获取当前日
	var date=myDate.getDate(); 
	var h=myDate.getHours();       //获取当前小时数(0-23)
	var m=myDate.getMinutes();     //获取当前分钟数(0-59)
	var s=myDate.getSeconds();  
	return year+'-'+time(month)+"-"+time(date)+" "+time(h)+':'+time(m)+":"+time(s);
}
