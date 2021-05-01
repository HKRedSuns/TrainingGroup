$(function () {
	// 文章内容
	var art_html ;
	
	var E = window.wangEditor;
	var editor = new E('#editor')
	
	//配置信息
	var config = editor.customConfig;
	config.menus = [
		'head', // 标题
		'bold', // 粗体
		'fontSize', // 字号
		'fontName', // 字体
		'italic', // 斜体
		'underline', // 下划线
		'strikeThrough', // 删除线
		'foreColor', // 文字颜色
		'backColor', // 背景颜色
		'link', // 插入链接
		'list', // 列表
		'justify', // 对齐方式
		'undo', // 撤销
	]
	
	
	// 自定义配置颜色（字体颜色、背景色）
	config.colors = [
		'#000000',
		'#eeece0',
		'#1c487f',
		'#4d80bf',
		'#c24f4a',
		'#8baa4a',
		'#7b5ba1',
		'#46acc8',
		'#f9963b',
		'#ffffff'
	]
	
	//lang配置项配置多语言
	config.lang = {
		'设置标题': 'title',
		'正文': 'p',
		'链接文字': 'link text',
		'链接': 'link',
		'上传图片': 'upload image',
		'上传': 'upload',
		'创建': 'init',
		'设置列表': 'set something'
		// 还可自定添加更多
	}
	
	editor.customConfig.onchange = function(html) {
		
		// html 即变化之后的内容
		art_html = html;
		// console.log(html)
	}
	// 或者 var editor = new E( document.getElementById('editor') )
	editor.create();
	E.fullscreen.init('#editor');

	
    $("#btn_issus").click(function () {
		// console.log(art_html) // 含有html标签的文章
		var isAddBlog ;
		var titleVal = $("#title").val(); // 标题
		var userId = getCookie("id");
		
		var context = editor.txt.text(); // 没有html标签的文章
		var conStr = context.slice(0,100); // 主页显示文章字段
		
		
		if(!userId){
			alert('亲爱的美食家，首先请登录奥');
			return false
		}
		if( titleVal == ''  && art_html == undefined){
			alert("请填写文章和标题");
			return false
		}
		if( titleVal == ''){
			alert('标题未写')
			return false
			// isAddBlog = 0;
		}
		if(art_html == undefined || art_html == '<p><br></p>'){
			alert('文章未写')
			return false
		}
		if(art_html.length<20 && art_html !=undefined && art_html != '<p><br></p>'){
			alert('文章字数应大于20')
			isAddBlog = 0;
		}
		if(isAddBlog == 0){
			return false;
		}
		
       
		var formData = new FormData();
		formData.append('file', $('#inp_file')[0].files[0]); // 图片
		formData.append('title',titleVal); // 标题
		formData.append('conStr', conStr); // 100字文章
		formData.append('context',art_html) ;// 含有html标签的全部文章
		formData.append('userId',userId);
		// console.log(formData.get('file'))
		// console.log(formData.get('title'))
		// console.log(formData.get('conStr'))
		// console.log(formData.get('context'))
		console.log(formData.get('userId'));
		$.ajax({
			url:"/addBlog",
            type:"POST",
            data:formData,
			processData: false,
			contentType: false,
            success:function (result) {
                if (result == 200){
                    alert("发布成功");
                    window.location.href= "http://localhost:80/index.html";
                }
            }
        });
    });
});