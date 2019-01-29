/**
 * 基于JQUERY的 行情选择器工具
 * @author hooxin
 */
(function($)
{
	/**
	 * 行情产品选择器 依赖于YAV验证框架和JQUERY JS库。 用法：$(ele1).quoProductSelect(ele1,ele2)
	 * 
	 * @param returnEle
	 *            回填元素
	 * @param option 窗口选项
	 */
	$.fn.quoProductSelect =
		$.fn.quo_product_select =
			function(returnEle,option)
			{
				var _self = this;
				var formAction = butil.getContextPath() + 'admin/quotation/initProductList';
				var returnValue1 = null;
				var returnValue2 = null;
				var returnEle1 = null;
				
				if ($(returnEle1).length == 0)
					returnEle1 = _self;
				var selectWin =
					function()
					{
						if ($("#productSelect").length == 0)
							$("<div>", {
							style : "display: none;",
							id : "productSelect"
							}).appendTo("body");
						var $select_win = $("#productSelect");
						
						var $quoProductTb = null;
						
						// 绑定产品选择按键
						var postCallback =
							function(ret)
							{
								$quoProductTb = $select_win.find("#quoProductTb");
								if ($quoProductTb.length == 0)
								{
									alert("没有ID为quoProductTb的数据容器");
									return;
								}
								
								// 绑定表格选择
								var $selectTr = $quoProductTb.find("tr");
								$selectTr.slice(1, $selectTr.length - 1).selectable({
									stop : function(evt, ui)
									{
										if (evt.target.getAttribute("rowData"))
										{
											try
											{
												rowData = $.parseJSON(evt.target.getAttribute("rowData"));
											}
											catch (e)
											{
												rowData = evt.target.getAttribute("rowData");
											}
											// 加选中颜色
											$selectTr.removeClass('selectedRow');
											$(evt.target).addClass('selectedRow');
											
											returnValue1 = rowData["quotationPName"];
											returnValue2 = rowData["quotationPCode"];
										}
										
									}
								});
								// /绑定产品选择按键
								$select_win.find("#okbtn").click(function()
								{
									if (!returnValue2)
									{
										alert("未选择记录");
										return;
									}
									$(returnEle1).val(returnValue1);
									$(returnEle).val(returnValue2);
									$select_win.dialog("close");
									
								});
								$select_win.find("#cancel").click(function()
								{
									returnValue1 = returnValue2 = null;
									$select_win.dialog("close");
								});
								$selectTr.each(function()
								{
									$(this).dblclick(function()
									{
										try
										{
											rowData = $.parseJSON(this.getAttribute("rowData"));
										}
										catch (e)
										{
											rowData = this.getAttribute("rowData");
										}
										if (rowData)
										{
											returnValue1 = rowData["quotationPName"];
											returnValue2 = rowData["quotationPCode"];
											$select_win.find("#okbtn").click();
										}
									});
								});
								
								$select_win.find("input:button[name*=action:]").each(
									function()
									{
										$(this).click(
											function()
											{
												var postAction =
													formAction.substring(0, formAction.lastIndexOf("/")) + "/"
														+ this.name.split(":")[1];
												var data = {
													productNameOrAlias : $("input[name=productNameOrAlias]").val()
												};
												$.post(postAction, data, postCallback);
											});
									});
								
								// 新增产品
								$select_win.find("input[name=toNewQuoProduct]").click(
									function()
									{
										if ($("#newQuoProduct").length == 0)
											$("<div>", {
											id : "newQuoProduct",
											style : "display:none;"
											}).appendTo($select_win);
										var $newQuoProudct_win = $("#newQuoProduct");
										var newPdtAction = formAction;
										newPdtAction =
											newPdtAction.substring(0, newPdtAction.lastIndexOf("/")) + "/"
												+ "toAddQuoProduct";
										// 载入行情产品添加页面
										$newQuoProudct_win.load(
											newPdtAction,
											null,
											function()
											{
												// 加载行情产品类型选择组件
												$("input[name*=quotationPTName]", $newQuoProudct_win).selectQuoPT(
													$("input[name*=quotationPTypeCode]"));
												// 美化按钮
												$newQuoProudct_win.find('.button').button();
												// 新增产品绑定
												$("#ok", $newQuoProudct_win)
													.click(
														function()
														{
															newPdtAction =
																newPdtAction
																	.substring(0, newPdtAction.lastIndexOf("/"))
																	+ "/" + "doAddQuoProduct";
															var data = {};
															var $dataEle =
																$("input:text, input:hidden", $newQuoProudct_win);
															for (i = 0; i < $dataEle.length; i++)
															{
																data[$dataEle.eq(i).attr("name")] =
																	$dataEle.eq(i).val();
															}
															// 验证
															if ($('input[name=qp.quotationPName]').val() == null
																|| $('input[name=qp.quotationPName]').val() == '')
															{
																alert('行情产品名称为空');
																$('input[name=qp.quotationPName]').focus();
																return;
															}
															if ($('input[name=qp.quotationPT.quotationPTypeCode]')
																.val() == null
																|| $('input[name=qp.quotationPT.quotationPTypeCode]')
																	.val() == '')
															{
																alert('行情产品类型');
																$('input[name=qp.quotationPT.quotationPTypeCode]')
																	.focus();
																return;
															}
															$.post(newPdtAction, data, function(ret)
															{
																if (ret.split("::")[0] == "1")
																	alert("新增成功");
																else
																	alert("新增失败");
																$newQuoProudct_win.dialog("close");
																$select_win.load(formAction, null, postCallback);
															});
														});
												// 打开新增产品窗口
												$newQuoProudct_win.dialog({
												modal : true,
												close : function()
												{
													$newQuoProudct_win.dialog("destroy");
												},
												title : '新增产品'
												});
											});
										
									});
								
								// 打开产品选择窗口
								var dialogOption = {
									autoOpen : false,
									modal : true,
									close : function()
									{
										$select_win.dialog("destroy");
									},
									title : "行情产品"
								};
								if(option != null && option != {})
									for(i in option){
										dialogOption[i] = option[i];
									}
								$select_win.dialog(dialogOption);
								
								// 分页部分
								var pager =
									function()
									{
										var postAction =
											formAction.substring(0, formAction.lastIndexOf('/')) + '/'
												+ 'doFindQuoProduct';
										$select_win.load(postAction, {
										'page' : $('#thePage').val(),
										'productNameOrAlias' : $('input[name=productNameOrAlias]').val()
										}, postCallback);
									};
								// 分页A标签注入
								var $pageDiv = $('#huzxPageDiv', $select_win);
								$('a', $pageDiv).each(function()
								{
									var setPage = $(this).attr('onclick');
									$(this).unbind('click');
									$(this).unbind('onclick');
									$(this).click(function()
									{
										setPage();
										pager();
									});
								});
								
								// 美化按钮
								$select_win.find('.button').button();
								
								$select_win.dialog('open');
							};
						
						$select_win.load(formAction, null, postCallback);
					};
				
				$("<img>", {
				style : "border:0px; width:22px; height:22px;cursor:pointer;",
				click : selectWin,
				src : butil.getContextPath() + "image/Search_28a.png"
				}).insertAfter(_self);
				
				return _self;
			};
	/***************************************************************************
	 * 行情产品类型选择器 基于JQUERY，依赖于YAV验证框架 用法 $(Ele1).selectQuoPT(Ele1, Ele2);
	 * 
	 * @param returnEle
	 *            回填元素
	 * @param option 窗口选项
	 */
	$.fn.selectQuoPT =
		$.fn.select_quoPT =
			function(returnEle,woption)
			{
				var _self = this;
				var option = woption;
				var formAction = butil.getContextPath() + "/admin/quotation/initPTList";
				var returnValue1 = null;
				var returnValue2 = null;
				var returnEle1 = null;
				
				if ($(returnEle1).length == 0)
					returnEle1 = _self;
				var selectWin =
					function()
					{
						// 选择窗口
						if ($("#quoPTSelect").length == 0)
							$("<div>", {
							style : "display:none;",
							id : "quoPTSelect"
							}).appendTo("body");
						var $select_win = $("#quoPTSelect");
						var $ptTb = null;
						
						var postCallback =
							function(ret)
							{
								if (!ret)
								{
									alert("还没有产品类型");
									return;
								}
								$ptTb = $select_win.find("#ptTb");
								if ($ptTb.length == 0)
								{
									alert("ptTb的目标容器不存在");
									return;
								}
								// 功能键绑定
								$ptTb.find("tr").slice(1, $ptTb.find("tr").length - 1).selectable({
									stop : function(evt, ui)
									{
										try
										{
											rowData = $.parseJSON(evt.target.getAttribute("rowData"));
										}
										catch (e)
										{
											rowData = evt.target.getAttribute("rowData");
										}
										// 加选中颜色
										$ptTb.find('tr').removeClass('selectedRow');
										$(evt.target).addClass('selectedRow');
										
										returnValue1 = rowData["quotationPTName"];
										returnValue2 = rowData["quotationPTypeCode"];
									}
								});
								
								// 双击确认
								$ptTb.find("tr").each(
									function()
									{
										$(this).dblclick(function()
										{
											try
											{
												rowData = $.parseJSON(this.getAttribute("rowData"));
											}
											catch (e)
											{
												rowData = this.getAttribute("rowData");
											}
											if (rowData)
											{
												returnValue1 = rowData["quotationPTName"];
												returnValue2 = rowData["quotationPTypeCode"];
												$select_win.find("#okbtn").click();
											}
										});
										
										$select_win.find("input:button[name*=action:]").each(
											function()
											{
												btn = this;
												$btn = $(btn);
												$btn.click(function()
												{
													var postAction =
														formAction.substring(0, formAction.lastIndexOf("/")) + "/"
															+ this.name.split(":")[1];
													var data = {
														"qpt.quotationPTName" : $("input[name*=quotationPTName]").val()
													};
													$select_win.load(postAction, data, postCallback);
												});
											});
										
										// 确认按钮绑定
										$select_win.find("#okbtn").click(function()
										{
											if (!returnValue2)
											{
												alert("未选择记录");
												return;
											}
											$(returnEle1).val(returnValue1);
											$(returnEle).val(returnValue2);
											$select_win.dialog("close");
										});
										
										$select_win.find("#cancel").click(function()
										{
											returnValue1 = returnValue2 = null;
											$select_win.dialog("close");
										});
										
									});
								
								// 分页部分
								var pager =
									function()
									{
										var postAction =
											formAction.substring(0, formAction.lastIndexOf('/')) + '/' + 'doFindPTList';
										$select_win.load(postAction, {
											'page' : $('#thePage').val()
										}, postCallback);
									};
								// 分页A标签注入
								var $pageDiv = $('#huzxPageDiv', $select_win);
								$('a', $pageDiv).each(function()
								{
									var setPage = $(this).attr('onclick');
									$(this).unbind('click');
									$(this).unbind('onclick');
									$(this).click(function()
									{
										setPage();
										pager();
									});
								});
								
								// 美化按钮
								$select_win.find('.button').button();
								// 对话框初始化和显示
								var dialogOption = {
								autoOpen : false,
								modal : true,
								close : function()
								{
									$select_win.dialog("destroy");
								},
								zIndex : 2000,
								width : '330px',
								title : '行情产品类型'};
								
								if(option != null && option != {})
									for(i in option){
										dialogOption[i] = option[i];	
									}
								$select_win.dialog(dialogOption);
								$select_win.dialog('open');
								
							};
						$select_win.load(formAction, null, postCallback);
					};
				
				$("<img>", {
				style : "border:0px; width:22px; height:22px;cursor:pointer;",
				click : selectWin,
				src : butil.getContextPath() + "image/Search_28a.png"
				}).insertAfter(_self);
				
				return _self;
			};
	
	/**
	 * 行情市场选择器 用法: $(Ele1).marketSelect(Ele1,Ele2);
	 * 
	 * @param returnEle
	 *            回填元素2 市场编号
	 * @param option 窗口选项
	 */
	$.fn.marketSelect =
		$.fn.market_select =
			function(returnEle,option)
			{
				var _self = this;
				var formAction = butil.getContextPath() + "/admin/quotation/initMarketList";
				var returnValue1 = null;
				var returnValue2 = null;
				var returnEle1 = null;
				if ($(returnEle1).length == 0)
					returnEle1 = _self;
				var selectWin =
					function()
					{
						if ($("#marketSelect").length == 0)
							$("<div>", {
							style : "display:none;",
							id : "marketSelect"
							}).appendTo("body");
						var $select_win = $("#marketSelect");
						var $marktetTb = null;
						
						var postCallback =
							function(ret)
							{
								if (!ret)
								{
									alert("还没有市场信息");
									return;
								}
								// 弹出框显示
								var dialogOption = {
									modal : true,
									autoOpen : false,
									width : "509px",
									title : '行情市场'
								};
								if(option != null && option != {})
									for(i in option){
										dialogOption[i] = option[i];
									}
								$select_win.dialog(dialogOption);
								
								$select_win.dialog('close');
								$marktetTb = $('#marktetTb', $select_win);
								
								// 设置按钮动作名字含有action:按钮，提交路径为她的NAME
								$select_win.find("input:button[name*=action:]").each(
									function()
									{
										btn = this;
										$btn = $(btn);
										$btn.click(function()
										{
											var postAction =
												formAction.substring(0, formAction.lastIndexOf("/")) + "/"
													+ this.name.split(":")[1];
											var data = {
											"qm.marketName" : $("input[name=qm.marketName]").val(),
											"qm.area" : $('input[name=qm.area]').val()
											};
											$select_win.load(postAction, data, postCallback);
										});
									});
								// 分页部分
								var pager =
									function()
									{
										var postAction =
											formAction.substring(0, formAction.lastIndexOf('/')) + '/' + 'doFindMarket';
										$select_win.load(postAction, {
											'page' : $('#thePage').val()
										}, postCallback);
									};
								// 分页A标签注入
								var $pageDiv = $('#huzxPageDiv', $select_win);
								$('a', $pageDiv).each(function()
								{
									var setPage = $(this).attr('onclick');
									$(this).unbind('click');
									$(this).unbind('onclick');
									$(this).click(function()
									{
										setPage();
										pager();
									});
								});
								// 确认按钮绑定
								$select_win.find("#okbtn").click(function()
								{
									if (!returnValue2)
									{
										alert("未选择记录");
										return;
									}
									$(returnEle1).val(returnValue1);
									$(returnEle).val(returnValue2);
									$select_win.dialog("close");
								});
								
								$select_win.find("#cancel").click(function()
								{
									returnValue1 = returnValue2 = null;
									$select_win.dialog("close");
								});
								
								// 绑定表格选择
								$selectTr = $marktetTb.find("tr").slice(1, $marktetTb.find("tr").length - 1);
								$selectTr.unbind('selectable');
								$selectTr.selectable({
									stop : function(evt, ui)
									{
										if (evt.target.getAttribute("rowData"))
										{
											var rowData = null;
											try
											{
												rowData = $.parseJSON(evt.target.getAttribute("rowData"));
											}
											catch (e)
											{
												rowData = evt.target.getAttribute("rowData");
											}
											// 加选中颜色
											$selectTr.removeClass('selectedRow');
											$(evt.target).addClass('selectedRow');
											
											returnValue1 = rowData["marketName"];
											returnValue2 = rowData["marketCode"];
										}
									}
								});
								$selectTr.each(function()
								{
									
									$(this).dblclick(function()
									{
										var rowData = null;
										try
										{
											rowData = $.parseJSON(this.getAttribute("rowData"));
										}
										catch (e)
										{
											rowData = this.getAttribute("rowData");
										}
										if (rowData)
										{
											returnValue1 = rowData["marketName"];
											returnValue2 = rowData["marketCode"];
											$select_win.find("#okbtn").click();
										}
										
									});
								});
								// 美化按钮
								$select_win.find('.button').button();
								
								$select_win.dialog('open');
							};
						
						$select_win.load(formAction, null, postCallback);
					};
				
				$("<img>", {
				style : "border:0px; width:22px; height:22px;cursor:pointer;",
				click : selectWin,
				src : butil.getContextPath() + "/image/Search_28a.png"
				}).insertAfter(_self);
				
				return _self;
			};
	
})(jQuery);