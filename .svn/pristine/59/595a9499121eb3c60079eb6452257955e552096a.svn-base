/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

(function($){

    
    
    /**
     * 全选/翻选
     * */
    $.fn.selectAll = $.fn.select_all = function(objs){
    	_self = this;
    	_type = $(_self)[0].type;
    	if(_type.toLowerCase() != "checkbox"){
    		alert("使用对象必须为复选框");
    		return;
    	}
    	
    	$(_self).click(function(){
    		if(this.checked == true)
    			$(objs).attr("checked",true);
    		else
    			$(objs).attr("checked",false);
    	});
    	return _self;
    };
})(jQuery);

