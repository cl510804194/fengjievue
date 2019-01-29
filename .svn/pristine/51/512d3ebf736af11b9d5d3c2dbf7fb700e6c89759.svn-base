/**
 * 信用评价
 * 
 */

$(document).ready(init);
/**
 * 初始化
 * */
function init() {
    TradeReview.init($("#trTb").get(0));
}


var TradeReview = {
    container:"",
    //1 表示成功,0和null表示失败
    jsCmd:[1,0],
    btnRow:"",
    init:function(container){
        if(container != null)
            TradeReview.container = container;
        TradeReview.bind();
        var tds = $("td","#trTb");
        for(var i=0;i<tds.length;i++){
            if($(tds[i]).find("span").text() == $("form").eq(0).find("#orderId").val()){
                 TradeReview.btnRow = $(tds[i]).parent();
                 break;
            }
        }
    },
    bind:function(){
        //绑定评价按钮
        $("input[name=pinjia]").each(function(){
            var pinjiabtn = null;
            pinjiabtn = this;
            $(this).click(function(){
                TradeReview.btnRow = $(pinjiabtn).parent();
                while(TradeReview.btnRow.attr("tagName") != "tr".toUpperCase()){
                    TradeReview.btnRow = TradeReview.btnRow.parent();
                    if(TradeReview.btnRow.attr("tagName") == "body".toUpperCase()){
                        TradeReview.btnRow = "";
                        break;
                    }
                }
                var rowData = TradeReview.btnRow.get(0).getAttribute("rowData");
                rowData = $.parseJSON(rowData);
                if(rowData){
                    for(var i in rowData){
                        $("input[name="+i+"]").val(rowData[i]);
                        if(i == "supplier.fullName" || i == "tr.orderId")
                            $("input[name="+i+"]").parent("td").find("span").text($("input[name="+i+"]").val());
                    }
                }
					
            });
        });
        $("#submit").click(function(){
            TradeReview.doReview();
        });
    },
    doReview:function(){

        var data = {};
        var dataEle = $("form").eq(0).find("input:text,input:hidden,input:checked,textarea");
        var validatorData = $("form").eq(0).find("input:hidden,input:checked","#trTb2");
        for(var i=0; i<validatorData.length; i++){
            if($(validatorData[i]).val() == null || $(validatorData[i]).val() == ""){
                alert("请选择一个要评价的订单");
                return;
            }
        }
        for(i=0;i< dataEle.length; i++){
            data[$(dataEle[i]).attr("name")] = $(dataEle[i]).val();
        }
        var result = $.post($("form").attr("action"),data,function(ret){
            if(ret){
                $(TradeReview.btnRow).remove();
                $("form").eq(0).find("#trTb2").find("input:text, input:hidden, textarea").val("");
                $("form").eq(0).find("#trTb2").find("span").text("");
            }
            //提示
            TradeReview.showTip(ret);
        });
        
    },
    //提示信息
    showTip:function(status){

        if($("#showTip") == null ||  $("#showTip").length == 0)
            $("body").append("<div id='showTip' style='display:none;'>");
        if(status == "1"){
            $("#showTip").text("评价成功");
            $("#showTip").css("color","#99FFFF");
            $("#showTip").css("background-color","#70DBFF");
        }
        else{
            $("#showTip").text("评价失败");
            $("#showTip").css("color","#FF3366")
            $("#showTip").css("background-color","#70DBFF");
        }
        $("#showTip").css("position", "fixed").css("top",0).css("left",0).css("right",0);
        $("#showTip").css("text-align","center");
        $("#showTip").toggle("blind",{},1000);
        setTimeout("$(\"#showTip\").toggle(\"blind\",{},1000);",3000);
    }
	
};

