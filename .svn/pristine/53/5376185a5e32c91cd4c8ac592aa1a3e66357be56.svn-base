/*安全控件*/
define(function(){
return function(securityWidth,securityHeight){
	window.getSecurityData = function() {
        var newObject=swfobject.getObjectById("SecurityComponent"); 
        return newObject.getSecurityDomainValue();
	}
	var hasFlash = flashChecker();
	if(hasFlash) {
			var swfVersionStr = "9.0.0";
			var xiSwfUrlStr = "";
			var flashvars = {};
			flashvars.url="/anon" ;
			flashvars.width=securityWidth || 277;
			flashvars.height=securityHeight || 36;
			flashvars.isPassword=1;
			var params = {};
			params.quality = "high";
			params.bgcolor = "#ffffff";
			params.allowscriptaccess = "sameDomain";
			params.allowfullscreen = "true";
			var attributes = {};
			attributes.id = "SecurityComponent";
			attributes.name = "SecurityComponent";
			attributes.align = "middle";
			swfobject.embedSWF(
				"/resources/swf/YJFSecurityComponent.swf", "flexContent", 
				flashvars.width+2, flashvars.height+2, 
				swfVersionStr, xiSwfUrlStr, 
				flashvars, params, attributes);
			swfobject.createCSS("#flexContent", "display:block;text-align:left;");
		 }else{
	  	$('#passwordDiv').html('<label class="fn-label">登录密码</label><a href="http://get.adobe.com/cn/flashplayer/?promoid=JZEFT" class="safe-control">请安装安全控件</a>');
	  }
		
		 // 判断是否安装了flash
	  function flashChecker()
	  {
	      var hasFlash=0;         //是否安装了flash
	      var flashVersion=0; //flash版本
	      var isIE=/*@cc_on!@*/0;      //是否IE浏览器
	
	      if(isIE)
	      {
	        try {
	      	  var swf = new ActiveXObject('ShockwaveFlash.ShockwaveFlash'); 
	            if(swf) {
	               hasFlash=1;
	               VSwf=swf.GetVariable("$version");
	               flashVersion=parseInt(VSwf.split(" ")[1].split(",")[0]); 
	            }
	        } catch(e) {
	      	  // 没有flash会抛异常
	        }
	        
	     }else{
	         if (navigator.plugins && navigator.plugins.length > 0)
	         {
	             var swf=navigator.plugins["Shockwave Flash"];
	             if (swf)
	             {
	                hasFlash=1;
	                var words = swf.description.split(" ");
	                for (var i = 0; i < words.length; ++i)
	                {
	                   if (isNaN(parseInt(words[i]))) continue;
	                   flashVersion = parseInt(words[i]);
	                }
	             }
	         }
	     }
	     return hasFlash?true:false;
	  }
}
	
})
	