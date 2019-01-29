/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

(function($) {
	/**
	 * 全选/翻选
	 */
	$.fn.selectAll = $.fn.select_all = function(objs, handler) {
		var _self = this;
		var _type = $(_self).attr('type');
		if (_type.toLowerCase() != "checkbox") {
			alert("使用对象必须为复选框");
			return;
		}

		$(_self).change(function() {
			if ($(_self).attr('checked') == true)
				$(objs).filter('[disabled=false]').attr("checked", true);
			else
				$(objs).filter('[disabled=false]').attr("checked", false);
			if (handler != undefined && handler != null)
				handler();
		});

		return self;
	};

	/**
	 * 倒计时
	 * 
	 * @param type
	 *            类型
	 * @param leftTime
	 *            剩余时间
	 * @param format
	 *            格式(支持HTML方式,yy-年,mm-月,dd-日,hh-时,mi-分钟,ss-秒,ms-毫秒)
	 */
	$.fn.countDown = $.fn.count_down = function(leftTime, type, format) {
		var _self = this;

		var SysSecond;
		var InterValObj;
		var intervalMillisecond;// 间隔时间，单位毫秒
		var _type;
		var _format;
		var _formatMap = {};
		var SetRemainTime;

		if (format != undefined && format != null)
			_format = format;

		if (type == undefined || type == null)
			_type = "sec";
		else
			_type = type;

		if (_type == "sec") {
			if (_format == null)
				_format = "{dd}天{hh}小时{mi}分{ss}秒";
			intervalMillisecond = 1000;
		} else if (_type == "min") {
			if (_format == null)
				_format = "{dd}天{hh}小时{mi}分";
			intervalMillisecond = 1000 * 60;
		} else if (_type == "hh") {
			if (_format == null)
				_format = "{dd}天{hh}小时";
			intervalMillisecond = 1000 * 60 * 60;
		}

		// 代理,接单的时间+1小时减去当前时间的秒数
		SetRemainTime = function() {
			if (SysSecond > 0) {
				SysSecond = SysSecond - 1;
				var second = Math.floor(SysSecond % 60); // 计算秒
				var minite = Math.floor((SysSecond / 60) % 60); // 计算分
				var hour = Math.floor((SysSecond / 3600) % 24); // 计算小时
				var day = Math.floor((SysSecond / 3600) / 24); // 计算天

				var formatValueMap = {
					'dd' : day,
					'hh' : hour,
					'mi' : minite,
					'ss' : second
				};

				// this.html(day + "天" + hour + "小时" + minite + "分" + second +
				// "秒");
				// 格式替换
				var pattern = /{(\w+)}/;
				var intervalTimeDisplay = _format;
				var matcher;
				while (matcher= pattern.exec(intervalTimeDisplay)) {
					intervalTimeDisplay = intervalTimeDisplay.replace(pattern,
							formatValueMap[matcher[1]]);
				}
				_self.html(intervalTimeDisplay);
			} else {// 剩余时间小于或等于0的时候，就停止间隔函数
				_self.html('');
				window.clearInterval(InterValObj);
			}
		};
		
		SysSecond = leftTime / 1000; // 在服务端算好了剩余的秒数，并保存到客户端，如果过期则返回0
		if (InterValObj)
			window.clearInterval(InterValObj);

		InterValObj = window.setInterval(SetRemainTime, intervalMillisecond); // 间隔函数，1秒执行
		
		return _self;
	};
})(jQuery);
