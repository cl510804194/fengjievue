/* 
 * geography location by Ken Liu kunyun
 */
 
  // our name space
  if(typeof(geoloc)=="undefined") 
	  geoloc={
		  selection: {},
		  promptA: {},
		  promptB: {},
		  promptC: {},
		  targetId: {},
		  defaultNumber: {}
	  };
  // debug state
  geoloc.debug=false;
  geoloc.debugOn=function(){geoloc.debug=true;};
  geoloc.debugOff=function(){geoloc.debug=false;};
  // our data
  geoloc.data=null;
  $.ajax({
	  url: butil.fullPath("~/js/geoloc/geoloc.data"),
	  async: false,
	  error: function(resp){
		  if (geoloc.debug) alert("Error: "+resp.responseText);
	  },
	  success: function(data){
		  geoloc.data=data;
	  }
  });
  // find container
  geoloc.findContainer=function(containerId){
	  var obj=$(containerId);
	  if(obj.size()<1) obj=$("#"+containerId);
	  if(obj.size()<1) {
		  if (geoloc.debug) alert("Element not found when calling geoloc.init():\r\n"+containerId);
		  obj=null;
	  }
	  return obj;
  };
  // init
  geoloc.init=function(containerId, promptA, promptB, promptC, targetId, defaultNumber){
	  var obj=geoloc.findContainer(containerId);
	  if(!obj) return false;
	  if(!geoloc.data) return false;
	  var id=obj.get(0).id;
	  obj.html("");
	  if(defaultNumber && defaultNumber.indexOf("|")>0) defaultNumber=defaultNumber.substr(0, defaultNumber.indexOf("|"));
	  geoloc.defaultNumber[id]=defaultNumber;
	  geoloc.targetId[id]=targetId;
	  // make level A select element
	  var a=$("<select groupid='"+id+"' name='"+id+"_geoloc_a' id='"+id+"_geoloc_a' class='geoloc_a'></select>");
	  obj.append(a);
	  // make level B select element
	  var b=$("<select groupid='"+id+"' name='"+id+"_geoloc_b' id='"+id+"_geoloc_b' class='geoloc_b'></select>");
	  obj.append(b);
	  // make level C select element
	  var c=$("<select groupid='"+id+"' name='"+id+"_geoloc_c' id='"+id+"_geoloc_c' class='geoloc_c'></select>");
	  obj.append(c);
	  // fill prompts
	  geoloc.promptA[id]=promptA;
	  geoloc.promptB[id]=promptB;
	  geoloc.promptC[id]=promptC;
	  if(promptA!="") a.append($("<option value=''>"+promptA+"</option>"));
	  // fill province items
	  var foundDefault=false;
	  var pattern = /\d\d0000.*?(?=\d)/g;  // province
	  while(true){
		  var item=pattern.exec(geoloc.data);
		  if(!item) break;
		  item=item[0];
		  //alert(item);
		  var strSelected="";
		  if(defaultNumber && defaultNumber.substr(0,2)==item.substr(0,2)) {
			  strSelected=" selected ";
			  foundDefault=true;
		  }
		  a.append($("<option value='"+item.substr(0,6)+"' "+strSelected+">"+item.substr(6)+"</option>"));
	  }
	  geoloc.resize(id, "b");
	  geoloc.resize(id, "c");
	  a.change(function(){
		  var num=this.value;
		  var text=this.options[this.selectedIndex].text;
		  geoloc.select(id, num);
		  num=num.length==6 ? num.substr(0,2) : "999999";
		  if(text.substr(text.length-1)=="市") {
			  num+="\\d\\d";
			  // clear b
			  geoloc.clear(id, 'b');
			  geoloc.resize(id, "b");
			  // clear c
			  geoloc.clear(id, 'c');
			  geoloc.fillC(num, $(this).attr("groupid"), this.value, text);
			  geoloc.resize(id, "c");
		  }else{
			  // clear b
			  geoloc.clear(id, 'b');
			  geoloc.fillB(num, $(this).attr("groupid"), this.value, text);
			  geoloc.resize(id, "b");
		  }
	  });
	  b.change(function(){
		  if(this.selectedIndex==-1) return;
		  var num=this.value;
		  var text=geoloc.selectedText(this);
		  geoloc.select(id, num);
		  num=num.length==6 ? num.substr(0,4) : "999999";
		  geoloc.clear(id, 'c');
		  geoloc.fillC(num, $(this).attr("groupid"), this.value, text);
		  geoloc.resize(id, "c");
	  });
	  c.change(function(){
		  if(this.selectedIndex==-1) return;
		  var num=this.value;
		  var text=geoloc.selectedText(this);
		  geoloc.select(id, num);
	  });
	  if(foundDefault) a.change();
  };
  // fill B
  geoloc.fillB=function(num, groupid, parentNum, parentText){
	  var promptB=geoloc.promptB[groupid];
	  if(promptB==null) return;
	  var b=$("#"+groupid+"_geoloc_b");
	  if(promptB!="") b.append($("<option value='"+parentNum+"' value2='"+parentText+"'>"+promptB+"</option>"));
	  //fill b
	  var defaultNumber=geoloc.defaultNumber[groupid];
	  var pattern = new RegExp(num+"(?!00)[\\d]{2}00.*?(?=\\d)", "g");
	  while(true){
		  var item=pattern.exec(geoloc.data);
		  if(!item) break;
		  item=item[0];
		  var strSelected="";
		  if(defaultNumber && defaultNumber.substr(0,4)==item.substr(0,4)) {
			  strSelected=" selected ";
		  }
		  b.append($("<option value='"+item.substr(0,6)+"' "+strSelected+">"+item.substr(6)+"</option>"));
	  }
	  b.change();
  };
  // clear
  geoloc.clear=function(groupid, level){
	  $("#"+groupid+"_geoloc_"+level).html("");
  };
  // resize
  geoloc.resize=function(groupid, level){
	  var e=$("#"+groupid+"_geoloc_"+level);
	  e.css("display", (e.get(0).options.length<2)?"none":"inline") ;
	  e.css("width","100px");
	  e.css("width","auto");
  };
  // select
  geoloc.select=function(groupid, num){
	  var value=num;
	  geoloc.selection[groupid]=value;
	  $("#"+geoloc.targetId[groupid]).val(geoloc.getSelection(groupid));
  };
  // get text
  geoloc.selectedText=function(htmlSelect){
	  var ret=null;
	  if(htmlSelect.selectedIndex>=0) {
		  ret=$(htmlSelect.options[htmlSelect.selectedIndex]).attr("value2");
		  if(!ret) ret=htmlSelect.options[htmlSelect.selectedIndex].text;
	  }
	  return ret;
  };
  // fill C
  geoloc.fillC=function(num, groupid, parentNum, parentText){
	  var promptC=geoloc.promptC[groupid];
	  if(promptC==null) return;
	  var defaultNumber=geoloc.defaultNumber[groupid];
	  var foundDefault=false;
	  var c=$("#"+groupid+"_geoloc_c");
	  if(promptC!="") c.append($("<option value='"+parentNum+"' value2='"+parentText+"'>"+promptC+"</option>"));
	  var pattern = new RegExp(num+"(?!00)[\\d]{2}(?!00).*?(?=\\d)", "g");
	  while(true){
		  var item=pattern.exec(geoloc.data);
		  if(!item) break;
		  item=item[0];
		  if(item.substr(6)=="市辖区") continue;
		  var strSelected="";
		  if(defaultNumber && defaultNumber==item.substr(0,6)) {
			  strSelected=" selected ";
			  foundDefault=true;
		  }
		  c.append($("<option value='"+item.substr(0,6)+"' "+strSelected+">"+item.substr(6)+"</option>"));
	  }
	  if(foundDefault) c.change();
  };
  // get selection
  geoloc.getSelection=function(containerId){
	  var ret=geoloc.selection[containerId];
	  if(typeof(ret)=="undefined") ret=null;
	  if(ret) {
		  var textA=geoloc.selectedText($("#"+containerId+"_geoloc_a").get(0));
		  var textB=geoloc.selectedText($("#"+containerId+"_geoloc_b").get(0));
		  var textC=geoloc.selectedText($("#"+containerId+"_geoloc_c").get(0));
		  if(textA==textB) textB="";
		  if(textA==null) textA="";
		  if(textB==null || ret.substr(2,4)=="00" || textB.indexOf("直辖")>=0) textB="";
		  if(textC==null || ret.substr(4)=="00") textC="";
		  ret=ret+"|"+textA+textB+textC;
	  }
	  return ret;
  };
