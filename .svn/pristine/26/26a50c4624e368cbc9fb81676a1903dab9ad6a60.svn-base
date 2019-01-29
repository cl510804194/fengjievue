function init(){
	ptManage();
}

function ptManage(){
	$(".category-list").find("a").each(function(i){
		var href = this.href;
		this.href="javascript:";
		this.target="";
		var para = null;
		if(href.split("?").length>1)
			para = href.split("?")[1];
		$(this).click(function(event){
			$("*").stop();
            $("#tooltip").dialog("close");
            
            var top = $(event.target).offset().top + 20;
            var left = $(event.target).offset().left;
            $("#tooltip").dialog({
            	title:"产品类型维护",
            	minwidth:300,
            	width:340,
            	position: [left, top],
            	open:function(){$.ajax({
                	type:'get',
                	data:para,
            		url:'${pageContext.request.contextPath}/do/ptManage/toUpdate',
            		success:function(rt,ts){
    					$("#tooltip").html(rt);
    					$("button, input:button",".butbar").button().each(function() {
    						$(this).click(function(){
    							//通过按钮动态修改 URL
    							var formJQ = $("form","#tooltip");
        						var action = formJQ.attr("action");
        						action = action.substr(0,action.lastIndexOf("/"));
        						action += "/" + $(this).attr("name");
        						dataEleJQ = $("input:text,input:hidden",formJQ);
        						var formPara = "";
        						for(var i=0;i<dataEleJQ.length;i++){
        							formPara += dataEleJQ[i].name + "="+dataEleJQ[i].value+"&";
        						}
        						formPara = formPara.substr(0,formPara.length-1);
        						$.ajax({
        							type:'post',
        							data:formPara,
        							url:action,
        							success:function(rest){
        							var restAr = rest.split("::");
        							restAr.length>1? rest = restAr[1] : rest = restAr[0];
        							if(rest == "yes")
        								$.ajax({
        									type:"get",
        									url:formJQ.attr("action"),
        									data:"async=true",
        									success:function(typeRes) {
        										$("#pttp").html(typeRes);
        										ptManage();
        									}
        								});
        							else if(restAr[0] == "error"){
        								//稍候处理
        								alert(restAr[1]);
        							}
        							//可以返回其他类型消息比如info,debug
        						}
        						});
        						//通过JS修改INNERHTML的按钮属性，达到AJAX回调，成功后更新主页面的顶级分类内容
        					});
    					});
                    }
                });}
            });
            $("#tooltip").dialog("open");
		});
	});
}
function test(paras){
	var ret = $.ajax({
		type:'get',
		url:'${pageContext.request.contextPath}/do/productType/productTypeManage!toUpdate',
		data:paras,
		success:function(rt, ts){
			$("#tooltip").html(rt);
		}
	});
}
$(document).ready(init);
