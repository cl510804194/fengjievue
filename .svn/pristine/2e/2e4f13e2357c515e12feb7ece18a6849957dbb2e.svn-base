function ajax(type,file,text,func)
{
	var XMLHttp_Object;
	try{XMLHttp_Object = new ActiveXObject("Msxml2.XMLHTTP");}
	catch(new_ieerror)
	{
		try{XMLHttp_Object = new ActiveXObject("Microsoft.XMLHTTP");}
		catch(ieerror){XMLHttp_Object = false;}
	}
	if(!XMLHttp_Object && typeof XMLHttp_Object != "undefiend")
	{
		try{XMLHttp_Object = new XMLHttpRequest();}
		catch(new_ieerror){XMLHttp_Object = false;}
	}
	type = type.toUpperCase();
	if(type == "GET") file = file + "?" + text;
	XMLHttp_Object.open(type,file,true);
	if(type == "POST") XMLHttp_Object.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	XMLHttp_Object.onreadystatechange = function ResponseReq()
	{
		if(XMLHttp_Object.readyState == 4) func(XMLHttp_Object.responseText);
	};
	if(type == "GET") text = null;
	XMLHttp_Object.send(text);
}

Date.prototype.format = function(format) {
	var o = {
		"M+": this.getMonth() + 1,
		//month 
		"d+": this.getDate(),
		//day 
		"h+": this.getHours(),
		//hour 
		"m+": this.getMinutes(),
		//minute 
		"s+": this.getSeconds(),
		//second 
		"q+": Math.floor((this.getMonth() + 3) / 3),
		//quarter 
		"S": this.getMilliseconds() //millisecond 
	}

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}

	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

//´û´ûÍø
