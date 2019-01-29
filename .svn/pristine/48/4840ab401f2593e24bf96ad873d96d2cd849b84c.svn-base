

define(function(require, exports, module){

  require("../Y-script/Y-base.js");
  require("../Y-script/Y-msg.js");
  $('#alert').click(function(){
	  Y.alert('消息框','来自网页的消息',function(opn){
	      alert(opn);
	  });
  });  
  
  $('#confirm').click(function(){
	  Y.confirm('选择框','是否确定',function(opn){
	      if(opn == 'yes') {
		      $('body').Y('Msg',{
	              type:'alert',
		          content:'成功',
		          icon:'success'
	          });
		  } else {
		      $('body').Y('Msg',{
	              type:'confirm',
		          content:'放弃?',
		          icon:'ask'
	          });
		  }
	  });
  }); 
});