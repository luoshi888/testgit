function myLoad(){
	var pictruePath =$("input[name='pictruePath']").val();
	//var url = "background-image: url('"+pictruePath+"')";
	$(".picture img").attr("src",pictruePath);
}

var isAllowOpenMore =false;
function allowOpenMore(){
	if($("input[name='left_menu']").is(':checked')){
		isAllowOpenMore = true;
	}else{
		isAllowOpenMore = false;
	}
}
/**
 * 点击左侧一级目录的时候，打开它的二级目录
 */
function showNextPrev(divObje){
	if($($(divObje).next()).attr("style")=='display: none'||$($(divObje).next()).attr("style")=='display:none'){
		$($(divObje).next()).attr("style", "display:");
		$($(divObje)).children().eq(1).attr("class","menu_pic_late2");
	}else{
		$($(divObje).next()).attr("style", "display: none");
		$($(divObje)).children().eq(1).attr("class","menu_pic_late1");
	}
	//不允许同时展开多个左侧主菜单
	if(!isAllowOpenMore){
		//获取父节点
		var parentDiv = $(divObje).parent();
		//获取父节点的兄弟节点
		var parentBrothers = parentDiv.siblings();
		//兄弟节点下第二个子节点
		parentBrothers.each(function(){
			$($(this).children().eq(0).children().eq(1)).attr("class", "menu_pic_late1");
			$($(this).children()).eq(1).attr("style", "display: none");
		});
	}
}

/**
 * 点击左侧菜单的时候，触发的函数，用户添加tab页和显示其对应页面
 */
function openTab(obj){
	//过滤重复的tab
	var isRepeat = false;
	var countTab = $("#navigation_2").children().length;
	$("#navigation_2").children().each(function(){
		if($(this).attr("id") && $(obj).attr("id") && $(this).attr("id")==$(obj).attr("id")){
			isRepeat = true;
			return;
		}
	});
	if(countTab>9){
		alert("tab也打开太多了，请关掉一些再试！");
	}
	if(isRepeat==false && countTab<10){
		var htmlText = $(obj).html();
		var newTab = '<div onclick="viewTab(this)" id="'+$(obj).attr("id")+'" class="menu_comment"><span>'+htmlText+'</span><span class="delLogo" onclick="delTab(this)"></span></div>';
		$("#next").before(newTab);
		//当打开一个新的tab页时，隐藏其他页面
		$("#details_1").children().each(function(){
			$(this).attr("style","display:none");
			
		});
		//tab标签为选中样式，其他非选中
		$("#navigation_2").children().each(function(){
			if($(this).attr("id")!="bank" && $(this).attr("id")!="next" && $(this).attr("id")!=$(obj).attr("id")){
				$(this).attr("class","menu_tab");
			}
		});
		//载入新的页面
		var url = $(obj).children().val();
		var page = '<iframe name="'+$(obj).attr("id")+'" src="'+url+'" width="100%" height="100%"></iframe>';
		$("#details_1").append(page);
	}
}

/** 
 * 删除tab
 * isDel:此为全局变量，用于防止点击删除tab的时候，触发viewTab方法。
 */
var isDel = false;
function delTab(obj){
	isDel  = true;
	//将前一个tab设置成当前tab,并显示其页面
	var length = $("#details_1").children().length;
	$("#navigation_2").children().eq(length-1).attr("class","menu_comment");
	$("#details_1").children().each(function(){
		if($(this).attr("name")==$("#details_1").children().eq(length-2).attr("name")){
			$(this).attr("style","display:");
		}
	});
	//删除tab
	$(obj).parent().remove();
	//删除iframe
	$("#details_1").children().each(function(){
		if($(this).attr("name")==$(obj).parent().attr("id")){
			$(this).remove();
			return ;
		}
		
	});
}
/**
 * 点击tab目录的时候，触发的函数
 */
function viewTab(obj){
	//将所有tab设置为不选中样式
	if(!isDel){
		$("#navigation_2").children().each(function(){
			if($(this).attr("id")!="bank" && $(this).attr("id")!="next"){
				$(this).attr("class","menu_tab");
			}
		});
		//设置选中tab的样式
		$(obj).attr("class","menu_comment");
		//显示选中tab的页面，隐藏其他页面
		$("#details_1").children().each(function(){
			if($(this).attr("name")==$(obj).attr("id")){
				$(this).attr("style","display:");
			}else{
				$(this).attr("style","display:none");
			}
		});
	}
	isDel = false;
}

/**
 * 方法showOwnSet()用于显示修改个人信息的选项
 * 参数isOpen用户判断第一次点击的时候打开，第二次点击关闭，再次点击打开
 */
var isOpenOwnSet = false;
function showOwnSet(){
	if(!isOpenOwnSet){
		var top=$("#up").offset().top;//得到当前li到顶部的距离
		var left=$("#up").offset().left;//得到当前li到顶部的距离
		$("#selectDiv").addClass("selectDiv");
		$("#selectDiv").attr("style","display:;margin-left:"+left+"px;"+"margin-top:"+top-60+"px");
		isOpenOwnSet = true;
	}else{
		$("#selectDiv").removeClass("selectDiv");
		$("#selectDiv").attr("style","display:none;");
		isOpenOwnSet = false;
	}
}

/**
 * 用于显示简单的系统设置选项
 */
var isOpenSysSinSet= false;
function showSysSinSet(){
	if(!isOpenSysSinSet){
		var top=$("#navigation_2").offset().top;//得到当前navigation_2到顶部的距离
		$("#simSetDiv_info").addClass("simSetDiv_info");
		$("#simSetDiv_info").attr("style","display:;margin-top:"+top+"px;");
		isOpenSysSinSet = true;
	}else{
		$("#simSetDiv_info").removeClass("simSetDiv_info");
		$("#simSetDiv_info").attr("style","display:none;");
		isOpenSysSinSet = false;
	}
	
}
function updatePicture(){
	var pictruePath =$("input[name='pictruePath']").val();
	layer.open({
        type: 2
        ,skin: 'demo-class'
        ,title: '更换头像'
        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'updatePicture'+2 //防止重复弹出
        ,content: '/club/openUploadPicture?pictruePath='+pictruePath
        ,shade: 0 //不显示遮罩
        ,area: ['600px','350px']
		,closeBtn: 1
		,btnAlign: 'c'
		,btn: ['取消','确定']
		,yes: function(index, layero){
			layer.close(index);
		}
		,btn2: function(index, layero){
			var path = $(layero).find("iframe").contents().find('input[name="pictruePath"]').val();
			$.ajax({
				url:'/club/copyPicture',//地址
				type:'GET',//类型
				data:{'isNotTemp':'true'},
				timeout:10000,//超时
				//请求成功
				success:function(data){
					$(".picture img").attr("src",path);
				},
				//失败/超时
				error:function(data){
					
				}
			});
		}
		,cancel: function(index, layero){ 
			
		}  
      });
}