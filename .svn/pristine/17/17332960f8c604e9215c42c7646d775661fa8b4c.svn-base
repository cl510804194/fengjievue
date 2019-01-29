<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cp=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>地区选择组件测试</title>

<script type="text/javascript" src="<%=cp%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/butil.js"></script>
<script type="text/javascript" src="<%=cp%>/js/geoloc/geoloc.js"></script>

<LINK href="<%=cp%>/js/yav/yav-style.css" type=text/css rel=stylesheet>
<SCRIPT src="<%=cp%>/js/yav/yav.js"></SCRIPT>
<SCRIPT src="<%=cp%>/js/yav/yav-config.js"></SCRIPT>


<script type="text/javascript">

	// 初始化地区组件
	geoloc.debugOn();
	$(document).ready(function(){
		// 基本用法
		geoloc.init("divDiQu1", "- 不限省市 -", "- 不限地州市 -", "- 不限区县 -");
		// 指定存储选择结果的域
		geoloc.init("divDiQu2", "- 选择省市 -", "- 选择地州市 -", "- 选择区县 -", "area");
		// 指定存储选择结果的域 并且 指定默认地区（地区号后有无竖线加文字都可以）
		geoloc.init("divDiQu3", "- 选择省市 -", "- 选择地州市 -", "- 选择区县 -", "q", "530422");
		// 不选择下级地区
		geoloc.init("divDiQu4", "- 不限省市 -", null, null, "dq4");
		// 不显示选择提示
		geoloc.init("divDiQu5", "", "", "", "dq5");
	});

	// 取地区选择结果，如果没有选择，结果为null；如果选择，数据形式为：310101|黄浦区
	function showSelection(){
		var sel=geoloc.getSelection("divDiQu1");
		if(sel==null){
			alert("没有选择");
		} else {
			alert(sel);
		}
	}

	// 设置表单验证
	$(document).ready(function(){
		// 定义规则，规则表参见 http://yav.sourceforge.net/en/validationrules.html
		var rules=new Array(
			"area:地区|required",
			"address:详细地址|required",
			"address:详细地址|minlength|8",
			"member.zip:邮政编码|required",
			"member.zip:邮政编码|numeric",
			"member.zip|mask|zip_mask",
			"date|mask|date_mask",
			"date:日期|date"
		);
		// 遮罩规则的详细定义
		yav.addMask('zip_mask', '      ', '1234567890');
		yav.addMask('date_mask', '    .  .  ', '1234567890');
		// 输入提示
		yav.addHelp("member.zip", "邮政编码固定为6位数字");
		yav.addHelp("date", "例如：2010年5月13日输入20100513");
		// 输入时验证
		yav.init('form2', rules);
		// 提交前验证
		$("#form2").submit(function () {
			  return yav.performCheck("form1", rules, "inline");  // classic 或者 inline
		});
	});
</script>
<style>
	.geoloc_a{ font-size:12px; color:#069}
	.geoloc_b{ font-size:12px; color:#903}
	.geoloc_c{ font-size:12px; color:#F60}
</style>
</head>
<body>
<form name="form1" id="form1" method="get" action="http://www.google.com/search?hl=en&aq=f&aqi=&oq=">
  <table width="300" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td nowrap="nowrap">地区一</td>
      <td nowrap="nowrap"><div id="divDiQu3">&nbsp;</div></td>
    </tr>
  </table>

  <button type="submit">Google搜索</button>
  <input type="hidden" name="q" id="q" value="">
</form>
<form name="form2" id="form2" method="post" action="">
  <DIV ID="errorsDiv"></DIV>
  <table width="300" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td nowrap="nowrap">地区一</td>
      <td nowrap="nowrap"><span id="divDiQu1">&nbsp;</span></td>
    </tr>
    <tr>
      <td nowrap="nowrap">地区二</td>
      <td nowrap="nowrap"><span id="divDiQu2">&nbsp;</span><span id=errorsDiv_area></td>
    </tr>
    <tr>
      <td nowrap="nowrap">详细地址</td>
      <td nowrap="nowrap"><input type="text" name="address" id="address"></input><span id=errorsDiv_address></td>
    </tr>
    <tr>
      <td nowrap="nowrap">邮政编码</td>
      <td nowrap="nowrap"><input type="text" name="member.zip" id="member.zip"><span id=errorsDiv_member.zip></input></td>
    </tr>
    <tr>
      <td nowrap="nowrap">有效日期</td>
      <td nowrap="nowrap"><input type="text" name="date" id="date"><span id=errorsDiv_date></input></td>
    </tr>
  </table>

  <button type="button" onclick="alert(geoloc.getSelection('divDiQu2'))">取地区二选项</button>
  <button type="submit">提交</button>
  <input type="hidden" name="area" id="area">
</form>
<p>&nbsp;</p>
限定级数的地区: <span id="divDiQu4">&nbsp;</span>选择结果：<input id="dq4"><br></br>
无提示的地区: <span id="divDiQu5">&nbsp;</span>选择结果：<input id="dq5">
</body>
</html>