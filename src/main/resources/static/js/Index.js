layui.use(['laypage', 'layer'], function(){
  var countA = $("input[name='countA']").val();
  var pageA = $("input[name='pageA']").val();
  var countB = $("input[name='countB']").val();
  var pageB = $("input[name='pageB']").val();
  var countN = $("input[name='countN']").val();
  var pageN = $("input[name='pageN']").val();
  var laypage = layui.laypage
  ,layer = layui.layer;
  
  //总页数低于页码总数
  laypage.render({
    elem: 'pageA'
    ,count: countA //数据总数
    ,limit:5
    ,curr:pageA
    ,jump: function(obj,first){
    	if(!first){
    		location.href="/club/showApprovalListPage?curPage="+obj.curr;
    	}
    }
  });
  
  laypage.render({
	    elem: 'pageB'
	    ,count: countB //数据总数
	    ,limit:5
	    ,curr:pageB
	    ,jump: function(obj,first){
	    	if(!first){
	    		location.href="/club/showActivityReadyListPage?curPage="+obj.curr;
	    	}
	    }
	  });
  
  laypage.render({
	    elem: 'pageN'
	    ,count: countN //数据总数
	    ,limit:10
	    ,curr:pageN
	    ,jump: function(obj,first){
	    	if(!first){
	    		location.href="/club/showNoticeListPage?curPage="+obj.curr;
	    	}
	    }
	  });
});
