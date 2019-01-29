define(function(require) {
	var Site = require('../comp/init.js');
	require('../plugins/jquery.box.js');
	require('../Y-all/Y-script/Y-tip.js');
	require('../plugins/jquery.combobox.js');
	require('../content/chineseAmountExchange.js');
	var flag = false;
	function handleFee(obj){
		var standard=obj;
		var cash=$("input[name='amount']").val()
		var availableBalance = $("input[name='money']").val();
		if(parseFloat(cash)>parseFloat(availableBalance)){
			flag=false;
		}else{
			flag = true;
		}
		$("#fuwu").text(standard);
		$("#f").text(standard);
		var scash=cash-standard;
		$("#ti").text(cash);
		if(scash>0){
			$("#s").text(scash)
		}else{
			$("#s").text("0")
		}
		$("#fee").val(standard);
		$("#rea").val(scash);
		var chineseAmount = convertCurrency(cash);
		if(chineseAmount.indexOf("error") >= 0 || cash == ""){
			$("#amountChinese").val("");
			$(".fn-y-tip").css("display","none");
			return;
		}
		$(".fn-y-tip").css("display","block");
		$("#amountChinese").val(chineseAmount);
	}
	$("input[name='amount']").blur(function(){
		handleFee(10.0);
	})
	$("#biao").mouseover(function(){
		$("#table").show();
	})
	$("#biao").mouseout(function(){
		$("#table").hide();
	})
	$("#quan").Y('ToolTip',{
	    content:'提现时使用可抵消一次提现手续费',
	    align: 'top'
	});
	
	$("input[name='coupons']").click(
		function(){
			var couponsAmount = $("#couponsAmount").text();
			couponsAmount = parseInt(couponsAmount);
			if($(this).attr("checked") == "checked"){
				 $("#couponsAmount").text(couponsAmount - 1);
				 handleFee(0.0);
			}else{
				 $("#couponsAmount").text(couponsAmount + 1);
				 handleFee(10.0);
			}
		}
	);
	
	var launchWithdrawals_form = $('#launchWithdrawals_form');
	function _submitHandler(){
		if(flag){
			launchWithdrawals_form[0].submit();
		}else{
			alert("提现金额大于账户可用余额,请重新输入提现金额!");
		}
		
	}
	if (launchWithdrawals_form.length) {
		launchWithdrawals_form.validate({
			errorClass : 'error-tip',
			errorElement : 'b',
			submitHandler:function(){
				_submitHandler();
			},
			errorPlacement : function(error, element) {
				if (element.attr('name') == 'amount') {
					element.next().after(error);
					
				} else {
					element.after(error);
				}
			},
			rules : {
				amount : {
					required : true
				}

			},
			messages : {
				amount : {
					required : '请填输入金额'
				}
			},
			onkeyup : false

		});
	}

});