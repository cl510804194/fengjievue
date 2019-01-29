var chat_html_1 = '<div class="q"><div class="h"><span class="user">';
var chat_html_2 = '</span><span class="time">';
var chat_html_3 = '</span></div><div class="main">';
var chat_html_4 = '</div></div><div class="a"><div class="h"><span class="user">';
var chat_html_5 = '</span><span class="time">';
var chat_html_6 = '</span></div><div class="m">';
var chat_html_7 = '</div></div>';

$("#chat_index").mouseover(function(){
	$(this).css("background-position","0px 0px");
});
$("#chat_index").mouseout(function(){
	$(this).css("background-position","0px -48px");
});
$("#chat_index").click(function(){
	if($("#chat_box").css("display") == "none")
	{
		$("#chat_box").fadeIn();
	}else{
		$("#chat_box").fadeOut();
	}
});
$("#chat_box .qs a").click(function(){
	var obj = $(this);
	var id = $(this).attr("rid");
	ajax("post","/?ajax/","cmd=get_answer&val=&id=" + id,
	function(data)
	{ 
		if(data != 0)
		{
			$("#chat_box .qs .txt").hide(300);
			obj.next().text(data);
			obj.next().show(300);
		}
	});	
});
$("#chat_box *").click(function(){
	$("#chat_box .search .show_qs").hide();
});
$("#chat_box .search .txt_bg").click(function(){
	$(this).hide();
	$("#chat_box .search .txt").focus();
});
$("#chat_box .search .txt").click(function(){
	$("#chat_box .search .txt_bg").hide();
});
$("#chat_box .search .txt").keyup(function(){
	get_question();
});
$("#chat_box .search .txt").blur(function(){
	get_question();
});
$("#chat_box .search .bt").click(function(){
	show_chat($("#chat_box .search .txt").val());
});
function get_question()
{
	var val = $("#chat_box .search .txt").val();
	ajax("post","/?ajax/","cmd=get_question&val=" + val,
	function(data)
	{ 
		if(data != 0)
		{
			$("#chat_box .search .show_qs").html(data);
			$("#chat_box .search .show_qs").show();
			$("#chat_box .show_qs a").click(function(){
				show_chat($(this).text());
			});
		}
	});	
}
function show_chat(text)
{
	ajax("post","/?ajax/","cmd=get_answer&id=&val=" + text,
	function(data)
	{ 
		if(data != 0)
		{
			$("#chat_box .q_list").hide(300);
			$("#chat_box .chat").show(300);
			$("#chat_box .bts .back").show();
			$("#chat_box .down_or_remove").show();
			var now = new Date();
			var nowStr = now.format("yyyy-MM-dd hh:mm:ss"); 
			str = chat_html_1 + "·Ã¿Í£º" + chat_html_2 + "(" + nowStr + ")" + chat_html_3 + text + chat_html_4 + "Ð¡´û½â´ð£º" + chat_html_5  + "(" + nowStr + ")" + chat_html_6 + data + chat_html_7;
			$("#chat_box .chat_main").html($("#chat_box .chat_main").html() + str);
			$("#chat_box .search .show_qs").hide();
			$("#chat_box .search .txt").val("");
		}
	});	
}
/////////////////////////////////
$("#chat_box .bts .close").mouseover(function(){
	$(this).css("background-position","-20px -16px");
});
$("#chat_box .bts .close").mouseout(function(){
	$(this).css("background-position","0 -16px");
});
$("#chat_box .bts .close").click(function(){
	$("#chat_box").fadeOut();
});
$("#chat_box .bts .back").mouseover(function(){
	if($("#chat_box .chat").css("display") == "block")
	{
		$(this).css("background-position","-20px -36px");
	}else{
		$(this).css("background-position","-20px -56px");
	}
});
$("#chat_box .bts .back").mouseout(function(){
	if($("#chat_box .chat").css("display") == "block")
	{
		$(this).css("background-position","0 -36px");
	}else{
		$(this).css("background-position","0 -56px");
	}
});
$("#chat_box .bts .back").click(function(){
	if($("#chat_box .chat").css("display") == "block")
	{
		$("#chat_box .q_list").show(300);
		$("#chat_box .chat").hide(300);
		$("#chat_box .down_or_remove").hide();
	}else{
		$("#chat_box .q_list").hide(300);
		$("#chat_box .chat").show(300);
		$("#chat_box .down_or_remove").show();
	}
});
/*
$("#chat_box .down_or_remove .down").click(function(){
	var html = encodeURI($("#chat_box .chat_main").html());
	html = encodeURI(encodeURI(html));
	ajax("post","/?ajax/","cmd=get_chat_record&html=" + html,
	function(data)
	{ 
		if(data != 0)
		{
			alert("http://dyp2p.net/"+data);
		}
	});	
});
*/
$("#chat_box .down_or_remove .remove").click(function(){
	$("#chat_box .chat_main").html("");
});
$("#chat_box .tel .u2 span").mouseover(function(){
	$("#chat_box .wechat").fadeIn();
});
$("#chat_box .tel .u2 span").mouseout(function(){
	$("#chat_box .wechat").fadeOut();
});

