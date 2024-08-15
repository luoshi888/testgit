function seachRole(){
	var roleName = $("input[name='roleName']").val();
	location.href="/club/showRole?roleName="+roleName;
}

function deleteRole(roleId){
	layer.confirm('您确定要删除这条数据吗?', {
		btn : [ '确定', '取消' ]
	}, function() {
		//layer.closeAll('dialog');
		$.ajax({
			type : "post",
			url : "/club/deleteRole",
			data : {"roleId":roleId},
			success : function(data) {
				layer.alert('删除成功', {
					icon: 6,
					title: "提示"
					});
				setTimeout(function () {
					location.href="/club/showRole";
				}, 2000);
				
			},
			error:function(data){
				layer.alert('啊，没删除成功！', {
					icon: 2,
					title: "错误"
					});
			}
		});
	});
	//layer.closeAll('dialog');
}

function addRole(){
	parent.layer.open({
        type: 2
        ,skin: 'demo-class'
        ,title: '新增角色'
        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'addRole'+2 //防止重复弹出
        ,content: '/club/showRoleInfo'
        ,shade: 0 //不显示遮罩
        ,moveOut:true
        ,move:'.layui-layer-title'
        ,area: ['1000px','580px']
		,closeBtn: 1
		,btnAlign: 'c'
		,btn: ['取消','保存']
		,yes: function(index, layero){
			$(location).prop('href', '/club/showRole');
			layer.close(index);
		}
		,btn2: function(index, layero){
			$(layero).find("iframe").contents().find('form[name="roleForm"]').submit();
			$(location).prop('href', '/club/showRole');
			layer.close(index);
		}
		,cancel: function(index, layero){ 
			$(location).prop('href', '/club/showRole');
			layer.close(index);
		}  
      });
}
function updateRole(roleId){
	parent.layer.open({
        type: 2
        ,skin: 'demo-class'
        ,title: '新增角色'
        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'updateRole'+2 //防止重复弹出
        ,content: '/club/showRoleInfo?roleId='+roleId
        ,shade: 0 //不显示遮罩
        ,area: ['1000px','580px']
		,closeBtn: 1
		,btnAlign: 'c'
		,btn: ['取消','保存']
		,yes: function(index, layero){
			$(location).prop('href', '/club/showRole');
			layer.close(index);
		}
		,btn2: function(index, layero){
			$(layero).find("iframe").contents().find('form[name="roleForm"]').submit();
			$(location).prop('href', '/club/showRole');
			layer.close(index);
		}
		,cancel: function(index, layero){ 
			$(location).prop('href', '/club/showRole');
			layer.close(index);
		}  
      });
}

layui.use('form', function(){
	  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
	  
	  //……
	  
	  //但是，如果你的HTML是动态生成的，自动渲染就会失效
	  //因此你需要在相应的地方，执行下述方法来进行渲染
	  form.render();
	}); 

function selectUserDialog(){
	layer.open({
        type: 2
        ,skin: 'demo-class'
        ,title: '选择用户'
        ,offset: 'auto' //http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'layerDemo'+2 //防止重复弹出
        ,content: '/club/findAllUser'
        ,shade: 0 //不显示遮罩
        ,area: ['400px','350px']
		,closeBtn: 1
		,btnAlign: 'r'
		,moveOut: true
		,tipsMore: true
		,btn: ['确定']
		,yes: function(index, layero){
			var obj = $(layero).find("iframe").contents().find('input[name="userId"]:checked').val();
			var objList = obj.split(":");
			var oblUser = $("input[name='roleUser']").val();
			if(oblUser.trim()!=''){
				oblUser = oblUser + ",";
			}else{
				oblUser = "";
			}
			$("input[name='roleUser']").val(oblUser+objList[1]);
			layer.close(index); 
		}
		
      });
}

//权限页面CheckBox回显脚本
function onload_checkBox(){
	var jrisdictionIdStr = $("input[name='jrisdictionIdStr']").val();
	var jdList =jrisdictionIdStr.split(",");
	if($.inArray("1", jdList)>=0){
		$("#addRole").prop("checked","checked"); 
	}
	if($.inArray("2", jdList)>=0){
		$("#updateRole").prop("checked","checked"); 
	}
	if($.inArray("3", jdList)>=0){
		$("#deleteRole").prop("checked","checked"); 
	}
	if($.inArray("5", jdList)>=0){
		$("#addUserInt").prop("checked","checked"); 
	}
	if($.inArray("6", jdList)>=0){
		$("#addUserCon").prop("checked","checked"); 
	}
	if($.inArray("7", jdList)>=0){
		$("#updateUserInt").prop("checked","checked"); 
	}
	if($.inArray("8", jdList)>=0){
		$("#updateUserCon").prop("checked","checked"); 
	}
	if($.inArray("9", jdList)>=0){
		$("#deleteUserInt").prop("checked","checked"); 
	}
	if($.inArray("10", jdList)>=0){
		$("#deleteUserCon").prop("checked","checked"); 
	}
	if($.inArray("11", jdList)>=0){
		$("#addClub").prop("checked","checked"); 
	}
	if($.inArray("12", jdList)>=0){
		$("#updateClub").prop("checked","checked"); 
	}
	if($.inArray("13", jdList)>=0){
		$("#deleteClub").prop("checked","checked"); 
	}
	if($.inArray("15", jdList)>=0){
		$("#addAct").prop("checked","checked"); 
	}
	if($.inArray("16", jdList)>=0){
		$("#updateAct").prop("checked","checked"); 
	}
	if($.inArray("17", jdList)>=0){
		$("#deleteAct").prop("checked","checked"); 
	}
	if($.inArray("18", jdList)>=0){
		$("#approvalAct").prop("checked","checked"); 
	}
	if($.inArray("19", jdList)>=0){
		$("#addType").prop("checked","checked"); 
	}
	if($.inArray("20", jdList)>=0){
		$("#updateType").prop("checked","checked"); 
	}
	if($.inArray("21", jdList)>=0){
		$("#deleteType").prop("checked","checked"); 
	}
}