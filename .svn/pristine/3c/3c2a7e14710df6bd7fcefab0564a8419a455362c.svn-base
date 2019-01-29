
(function($){

function Y_Window(){
    if(Y.Window) return;
	Y.inherit('Window','container',{
	    init: function(cfg){
	        var _this = this;
	        if(cfg.url) {
	            $.ajax({
	                    url: cfg.url,
	                    async: false,
	                    success: function(res){
	                        res = res.replace(/<!\-\-.*>/g,'');//移除html注释
	                        cfg.content = $(res);
	                        cfg.url = null;
	                    }
	            });
	        }
	        this.callBase('init','container',cfg);
	    },
	    doInit: function(cfg){
	        var _this = this;
            if(cfg.simple && typeof cfg.contentClone == 'undefined') {
		        cfg.contentClone = false;
            }
			var defaults = Y.Window.defaults;
            var wndStyle = $.extend({},defaults.wndStyle,this.cfg.wndStyle || {});
            var headerStyle = $.extend({},defaults.headerStyle,this.cfg.headerStyle || {});
            var bodyStyle = $.extend({},defaults.bodyStyle,this.cfg.bodyStyle || {});
            var overStyle = $.extend({},cfg.overStyle,defaults.overStyle,this.cfg.overStyle || {});
			var renderTo = cfg.renderTo || cfg.target || 'body';
			renderTo = this.toJqObj(renderTo);
			var item = this.toJqObj(cfg.content);
            if(item.parent().length>0) {
                if(cfg.contentClone) {
                    item = item.clone(true,true);
                } else {
					this.contentParent = item.parent();
					item.detach();
                }
                item.show();
            }
			if(cfg.removeLocation) {
				if(item.css('position') && item.css('position') != 'static' ) {
			        item.css({left:'',top:'',position:''});
				}
			}
			var position = 'absolute';
			wndStyle.left = cfg.left || wndStyle.left;
			wndStyle.top = cfg.top || wndStyle.top;
			wndStyle.width = cfg.width?cfg.width: wndStyle.width;
            wndStyle.height = cfg.height?cfg.height: wndStyle.height;
			if(cfg.simple) {
			    $.extend(this,{
                    container: renderTo,
					renderTo: renderTo,
					el:item,
                    body: item,
                    wnd: item,
                    item: item,
                    cfg: cfg
                });
				this.wnd.css(wndStyle);
				this.wnd.css('position',position);
				$.extend(cfg,{
				    noheader: true
				});
				this.noStyle = true;
				this.simple = true;
				this.setManager(Y.Window.manager);
				return this.wnd;
			}
			
			if(cfg.noStyle) {
			    $.extend(cfg,{
				    wndCss: 'wnd-wnd-no',
		            bodyCss: 'wnd-body-no',
		            headerCss: 'wnd-header-no',
		            closeBtnCss: 'wnd-close-no'
				});
				this.noStyle = true;
			}
            var $header = $("<div>").append($('<span>').html(cfg.title).addClass('wnd-title'));
            var $body = $("<"+(cfg.bodyEle || "div")+">").css('display','block');
            var $closeBtn = $("<a>").attr({href:'javascript:void(0)'});
			if(cfg.closeAble === false) {
			    $closeBtn.hide();
			}
            var $wnd = $("<"+cfg.el+">");
            $header.append($closeBtn).css(headerStyle);
            $body.css(bodyStyle);
            $wnd.css(wndStyle);
			$header.addClass(cfg.headerCss);
			$body.addClass(cfg.bodyCss);
			$wnd.addClass(cfg.wndCss);
			$closeBtn.addClass(cfg.closeBtnCss);
            $wnd.css({
			    'position':position
			}).hide();
            $.extend(this,{
                container: renderTo,
				renderTo: renderTo,
                header: $header,
                body: $body,
                wnd: $wnd,
				el:$wnd,
                closeBtn: $closeBtn,
                item: item
            });
			this.setManager(Y.Window.manager);
		},
		liveDrag: function(ele,closeEle){//该函数激活拖拽
            if(this.dragAble === true) {
                return;
            }
            var _this = this;
			var closeBtn = closeEle || this.closeBtn;
			if(closeBtn) {
			    this.bind(closeBtn,'mousedown',function(ev){//用以阻止事件冒泡,保证在关闭按钮上不会触发拖拽
                   if(ev) {
                       ev.stopPropagation();
                   }
                });
			}
			var dragEle = ele || this.header;
            this.bind(dragEle,'mousedown',function(ev){
                if(ev) {
                    _this.startX = ev.pageX;
                    _this.startY = ev.pageY;
                }
                else {
                    _this.startX = event.offsetX;
                    _this.startY = event.offsetY;
                }
                _this.startLeft = _this.wnd.offset().left;
                _this.startTop = _this.wnd.offset().top;
                _this.isDragging = true;
				dragEle.css('cursor','pointer');
            });
			this.bind($(document),'mousemove',function(ev){
                if(!_this.isDragging) return;
                var x,y;
                if(ev) {
                    x = ev.pageX;
                    y = ev.pageY;
                }
                else {
                    x = event.offsetX;
                    y = event.offsetY;
                }
                var xp = x - _this.startX,yp = y - _this.startY;
                var left = _this.startLeft + xp;
                var top = _this.startTop + yp;
                //_this.wndrect.css({left: left,top: top});
				_this.wnd.css({left: left,top: top});
            });
			this.bind($(document),'mouseup',function(ev){
                if(!_this.isDragging) return;
                var x,y;
                if(ev) {
                    x = ev.pageX;
                    y = ev.pageY;
                }
                else {
                    x = event.offsetX;
                    y = event.offsetY;
                }
                var xp = x - _this.startX,yp = y - _this.startY;
                var left = _this.startLeft + xp;
                var top = _this.startTop + yp;
                _this.wnd.css({left: left,top: top});
                _this.isDragging = false;
				dragEle.css('cursor','');
            });
			dragEle.attr('title','可拖动');
            this.dragAble = true;
        },
        doRender: function(){
            if(!this.cfg.noheader) {
                this.el.append(this.header);
            }			
			this.renderTo.append(this.el);
			if(!this.cfg.simple) {
			    this.el.append(this.body);
                this.body.append(this.item);
			}		
            if(!this.cfg.noheader) {
                if(this.cfg.dragAble) {
                    this.liveDrag();
                }
            } else {
                if(this.cfg.dragAble && this.cfg.dragEle) {
                    var dragEle = typeof this.cfg.dragEle=="object"?this.cfg.dragEle: this.wnd.find(this.cfg.dragEle);
                    this.liveDrag(dragEle,closeEle);
                }
            }
            var _this = this;
            var closeEle;
            var optEle = this.cfg.closeEle;
            if(!optEle) {
                closeEle = this.closeBtn;
            } else {
                closeEle = this.cfg.noheader?(typeof optEle=="object"?optEle: this.wnd.find(optEle)): this.closeBtn;
            }
			if(closeEle) {
			    closeEle.attr('title','关闭');
			    _this.bind(closeEle,'click',function(ev){
                     _this.close();
                });
			}
			if(this.cfg.modal) {
				if(_this.renderTo.get(0) == $('body').get(0)) {
					var docuSize = {width:$(document).width(),height:$(document).height()};
					_this.bind($(window),'resize',function(){
					    if(!_this.over) return;
					    if(!_this.bodyResizing) {
						    _this.bodyResizing = true;
							setTimeout(function(){
							    if(_this.isDistroy) return;
							    setSize();
								var off = _this.wnd.offset();
								var rect = {top:off.top,left:off.left,width:_this.wnd.outerWidth(),height:_this.wnd.outerHeight()};
								var wndH = $(window).height(),wndW = $(window).width();
								if(rect.top > wndH - rect.height) {
								    var top = wndH - rect.height;
									if(top < 0) top =0;
								    _this.wnd.css('top',top);
								}
								if(rect.left > wndW - rect.width) {
								    var left = wndW - rect.width;
									if(left < 0) left =0;
								    _this.wnd.css('left',left);
								}
								setTimeout(function(){
								    setSize();
								},1);
							},300);
						}
			        });
					function setSize(){
					    var wndH = $(window).height(),wndW = $(window).width();
						var overH = wndH > docuSize.height?wndH:docuSize.height;
						var overW = wndW > docuSize.width?wndW:docuSize.width;
						_this.over.css({'width':overW,'height':overH});
					    _this.bodyResizing = false;
					}
				}
			}
        },
		showOver: function(){
		    var over = $("<div>");
            over.css(this.cfg.overStyle);
            var left = this.container.offset().left,top=this.container.offset().top;
            var width = this.container.outerWidth(),height=this.container.outerHeight();
            if(this.container.get(0)==$('body').get(0)) {
                width = $(document).outerWidth();
                height = $(document).outerHeight();
                top = 0,left = 0;
            }
            var overIndex = this.manager?this.manager.getTop().zIndex - 1: parseInt(this.wnd.css('zIndex')) - 1;
            over.css({width: width,height: height,left: left,top: top,position: 'absolute',zIndex: overIndex});
            over.hide();
			if($.browser.msie && ($.browser.version == "6.0") && !$.support.style) {
			    over.append($('<iframe>').attr('src','').css({
				    width:'100%',
					height:'100%',
					opacity:0.01
				}));
			}
            this.container.append(over);
            over.fadeIn();
            this.over = over;
            this.isModal = true;
		},
        doShow: function(speed){
		    this.callBase('doShow','container',speed);
            if(this.cfg.modal) {
                this.showOver();
            }
            if(this.manager) {
                this.manager.toFront(this);
            }
        },
		doHide: function(speed){
			if(this.isModal && this.over) {
                this.over.remove();
				this.over=null;
            }
			this.callBase('doHide','container',speed);
		},
		close: function(){
		    if(this.callBase('close','container') === false) {
			    return;
			}
			if(this.over) {
			    this.over.fadeOut();
			}
		},
        doDistroy: function(){
			if(this.isModal && this.over) {
                this.over.remove();
				this.over=null;
            }
			if(this.contentParent && this.cfg.contentRecovery) {
				this.item.hide();
			    this.contentParent.append(this.item);
			}
			if(this.manager) {
                this.manager.remove(this);
				this.manager=null;
            }
			this.clearHandlers();
			if(this.simple && this.contentParent) {
			    this.contentParent.append(this.el);
				this.el = null;
			}
			else this.el.remove();
			var _this = this;
			setTimeout(function(){
			    var props = ['item','wnd','header','closeBtn','body','el'];
			    for(var i=0;i<props.length;i++) {
			        if(_this[props[i]]) delete _this[props[i]];
			    }
			},1);
        },
        getRect: function(){
            var zIndex = this.manager?this.manager.getTop().zIndex + 1: this.wnd.css('zIndex') + 1;
            var wnd = this.wnd;
            var left = wnd.offset().left,top = wnd.offset().top,width = wnd.outerWidth(),height = wnd.outerHeight();
            var rect = $("<div>").css({
                left: left,
                top: top,
                height: height,
                width: width,
                border: 'dotted Black 1px',
                position: 'absolute',
                zIndex: zIndex,
                background: '#666666',
                opacity: 0.2
            });
            this.container.eq(0).append(rect);
            return rect;
        },
        setManager: function(manager){
            this.manager = manager;
            var _this = this;
            manager.add(this);
            this.bind(this.wnd,'mousedown',function(){
               manager.toFront(_this);
            });
        },
		removeManager: function(){
		    if(this.manager) {
			    this.manager.remove(this);
				this.manager = null;
			}
		},
		setXY:function(){
		    var cfg = this.cfg;
			if(!cfg.left && !cfg.wndStyle.left) {
				var left = ($(window).width() - this.wnd.width())/2 +($(document).scrollLeft() || 0) ;
				this.wnd.css('left',left);
			}
			if(!cfg.top && !cfg.wndStyle.top) {
				var top = ($(window).height() - this.wnd.height())/2 +($(document).scrollTop() || 0) ;
				this.wnd.css('top',top);
			}
		},
		doSize: function(){
		    if(this.simple) {
			    this.setXY();
			    return;
			}
		    var _this = this;
			var cfg = this.cfg;
		    var itemWidth = _this.item.outerWidth(),itemHeight =_this.item.outerHeight();
   		    var headerHeight,headerWidth;
            if(_this.cfg.noheader) {
                headerHeight = 0,headerWidth = 0;
            } else {
                headerHeight = _this.header.outerHeight();
				headerWidth = _this.header.outerWidth();
            }
			var minWidth = _this.cfg.minWidth || 100;
            var width = itemWidth > minWidth?itemWidth:minWidth;
            var height = _this.body.outerHeight() + headerHeight;
			var wndIW = _this.el.innerWidth(),wndW =  _this.el.outerWidth();
			var wndIH = _this.el.innerHeight(),wndH = _this.el.outerHeight();
			if(this.cfg.autoSize) {
			    width = width + wndW - wndIW,height = 'auto';
			} else {
				width = this.cfg.width || this.wndStyle.width || 'auto',
				height = this.cfg.height || this.wndStyle.height || 'auto'
        	}
			this.body.css({width: width, height: 'auto'});
			this.el.css({width: width, height: height});
			if(this.header) {
			    this.header.css('width', width);
			}
			this.setXY();
			this.isDoSize = true;
		}
	});

	
        Y.Window.manager = $.extend(new Array(),{
            getTop: function(){
                var topOne = {index: 0,wnd: null,zIndex: 0};
                for(var i = 0;i<this.length;i++ )
                {
                    var zIndex = parseInt(this[i].wnd.css('zIndex'));
                    if(zIndex > topOne.zIndex) {
                        topOne.zIndex = zIndex;
                        topOne.wnd = this[i];
                        topOne.index = i;
                    }
                }
                return topOne;
            },
            getHigher: function(wnd){
                if(!wnd) return [];
                var zIndex = wnd.wnd.css('zIndex');
                var higherWnds = [];
                $.each(this,function(i,item){
                    var aindex = item.wnd.css('zIndex');
                    if(aindex > zIndex) {
                        higherWnds.push(item);  
                    }
                })
                return higherWnds;
            },
            getIndex: function(wnd){
                if(!wnd) return;
                var index;
                for(var i = 0;i<this.length;i++ ) {
                    if(wnd==this[i]) {
                        return i;
                    }
                }
                return -1;
            },
            remove: function(wnd){
                if(!wnd || !wnd.manager) return;
                var index = this.getIndex(wnd);
                this.splice(index,1);
				wnd.manager=null;
            },
            add: function(wnd){
			    if(!wnd) return;
			    var topone = this.getTop();
				var newIndex;
				if(!topone.wnd) {
				    newIndex = 5000;
				} else {
				    newIndex = topone.zIndex + 2;
					if(wnd.over) {
					    newIndex = newIndex >= parseInt(wnd.over.css('zIndex'))?newIndex:parseInt(wnd.over.css('zIndex')) + 1;
					}
				    wnd.wnd.css('zIndex',newIndex);
				}
                this.push(wnd);
            },
            toFront: function(wnd){
                if(!wnd) return;
                var topone = this.getTop();
                var higherWnds = this.getHigher(wnd);
                $.each(higherWnds,function(i,item){
                    var newIndex = parseInt(item.wnd.css('zIndex')) - 2;
                    item.wnd.css('zIndex',newIndex);
                    if(item.over) item.over.css('zIndex',newIndex-1);
                });
                wnd.wnd.css('zIndex',topone.zIndex);
            }
        });
		
		
	Y.Window.defaults = {
        title: '',//默认标题
        content: '',//主体部分的默认内容
        dragAble: true,
		closeAble: true,
        modal: true,
        contentClone: false,
		removeLocation: true,
		contentRecovery:true,
		wndCss: 'wnd-wnd',
		bodyCss: 'wnd-body',
		headerCss: 'wnd-header',
		closeBtnCss: 'wnd-close',
		autoSize: true,
		noStyle: false,
        wndStyle: {
		    'z-index': 5000
		},
		el:'div',
        headerStyle: {},
        bodyStyle: {},
        overStyle: {
            opacity: 0.5,
            background: '#666666'
        }
    }
		
}

if(typeof define == 'function') {
    define(Y_Window);
} else {
    Y_Window();
}


})($);
