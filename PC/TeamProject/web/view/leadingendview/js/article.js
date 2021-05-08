$(function () {
    var imgs = getCookie("headImg");
    var ids = getCookie('id');
    var blog_box = $('#blog_box');
    var art_context = $('#art_context');
    var cont_ID = getUrl("Blog_id");
    var cont_Img = getUrl("Blog_img");
    var BlogID = {"cont_ID":cont_ID};

    // 获取作者信息
    $.ajax({
        url:"/Project/Browse_Blog?action=user",
        async:false,
        dataType: 'json',  // 自己改值
        jsonp:'callback',
        data:BlogID,
        success:function (result) {
            var html = '';
            var html_two = '';
            for(var i in result){
                //文章标题
                //角色头像
                //作者名称
                //评论数量
                //点赞数量
                html+=`<h2 class="blog-post-title" id="blog_title">${result[i].Title}</h2>
							<!-- 作者相关区 -->
							<div class="author-out">
								<div class="author-internal">
									<a class="head_portrait" href=""><img class="img-border-radius" src="./..${result[i].UserHeadImg}"></a>
									<div style="margin-left: 8px;">
										<div class="author-about">
										<span class="author">
											<a class="inherit" href="">${result[i].UserName}</a>
										</span>
											<button data-locale="zh-CN" class="attention"
													type="button"><span>关注</span></button>
										</div>
										<div class="post-about">
											<span><i class="iconfont icon-riqishijian"></i>&nbsp;2021.5.1&nbsp;22:28:00</span>
											<span><i class="iconfont icon-guanzhu1"></i>&nbsp;${result[i].Comments}</span>
											<span><i class="iconfont icon-pinglun"></i>&nbsp;${result[i].Likes}</span>
										</div>
									</div>
								</div>
							</div>`;
                html_two = `<div class="author-out">
\t\t\t\t\t\t\t<div class="author-internal">
\t\t\t\t\t\t\t\t<a class="head_portrait" href=""><img class="img-border-radius"
\t\t\t\t\t\t\t\t\t\tsrc="./..${result[i].UserHeadImg}"></a>
\t\t\t\t\t\t\t\t<div style="margin-left: 8px;">
\t\t\t\t\t\t\t\t\t<div class="author-about">
\t\t\t\t\t\t\t\t\t\t<span class="author">
\t\t\t\t\t\t\t\t\t\t\t<a class="inherit" href="">${result[i].UserName}</a>
\t\t\t\t\t\t\t\t\t\t</span>
\t\t\t\t\t\t\t\t\t\t<button data-locale="zh-CN" class="attention bg-color"
\t\t\t\t\t\t\t\t\t\t\ttype="button"><span>关注</span></button>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t\t<div class="post-about">
\t\t\t\t\t\t\t\t\t\t<span><i class="iconfont icon-guanzhu1"></i>&nbsp;${result[i].Comments}</span>
\t\t\t\t\t\t\t\t\t\t<span><i class="iconfont icon-pinglun"></i>&nbsp;${result[i].Likes}</span>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>`;
            }
            blog_box.html(html);
            $('#blog_html').html(html_two)
        }
    })







    // 获取url传值
    function getUrl(key)
    {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair[0] == key){return pair[1];}
        }
        return(false);
    }
    // console.log(getUrl("Blog_img")) //  获取 url 参数值


    if(cont_Img != '1'){
        $('#title_Img').attr('src',cont_Img);
    }else {
        $('#title_ImgBox').css('display','none')
    }
    // 获取文章信息
    if (imgs != '' && ids != '') {
        //请求带有标签对象的文章内容
        $.ajax({
            url:"/Project/Browse_Blog?action=BlogStr",
            async:false,
            data:BlogID,
            success:function (result) {
                console.log(result);
                art_context.html(result);
            }
        });
    }

    if($('#title_Img').attr('src')==''){
        $('#title_ImgBox').css('display','none')
    }

    if (imgs == '' || ids == '') {
        $('body').css('display', 'none')
        alert('请登录')
        window.location.href = './login.html';
    }
})