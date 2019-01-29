<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML><HEAD><TITLE>yav - Javascript form validation tool</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META name="Author" content="f.crivellaro" />
<META name="Keywords" content="javascript, form, forms, validation, validator, form validation, form validator, javascript validation, web design" />
<META name="Description" content="yav is a SIMPLE, POWERFUL and CUSTOMIZABLE javascript-based form validation tool" />
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<LINK href="../styles/yav-style.css" type=text/css rel=stylesheet>
<SCRIPT src="../js_compact/yav.js"></SCRIPT>
<SCRIPT src="../js_compact/yav-config.js"></SCRIPT>
<SCRIPT src="../js/util.js"></SCRIPT>

<SCRIPT>
//only for test purposes
function checkOnSubmit(formName, r) {
    if (yav.performCheck(formName, r, 'inline')) {
        alert('Form validated (you usually submit your form now)');
    }
}

var rules=new Array();
rules[0]='code:the captcha code|required';
yav.addHelp('code', 'Please enter the characters on the image above');
yav.postValidation_OnOK('code', 'blur', 'ajaxCall()');

var url = 'captcha_check.php?code=';
var captchaOK = 2;  // 2 - not yet checked, 1 - correct, 0 - failed

// a simple ajax implementation
// here you can use your ajax framework as you prefer
function getHTTPObject() {
    try {
          req = new XMLHttpRequest();
    } catch (err1) {
        try {
            req = new ActiveXObject("Msxml12.XMLHTTP");
        } catch (err2) {
            try {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (err3) {
                req = false;
            }
        }
    }
    return req;
}
        
var http = getHTTPObject(); // We create the HTTP Object        

function handleHttpResponse() {
   if (http.readyState == 4) {
    captchaOK = http.responseText;
    if(captchaOK != 1) {              
      yav.displayMsg('code', 'Code not correct, please try again.', yav_config.innererror);
      document.myform.code.value='';
      yav.get('submitbutton').className = 'buttonstyledisabled';
      document.myform.submitbutton.disabled=true;
      return false;
      }  else {
          yav.displayMsg('code', 'Code verified, You are human!', yav_config.innerhelp);
          yav.get('submitbutton').className = 'buttonstyle';
          document.myform.submitbutton.disabled=false;
          return true;
      }
   }
}

function ajaxCall() {
    http.open("GET", url + escape(document.myform.code.value), true);
    http.onreadystatechange = handleHttpResponse;
    http.send(null);
    return false;
}      
   
</script>
</HEAD>
<BODY onload="yav.init('myform', rules);" >
<TABLE id=layout style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px" cellSpacing=0 cellPadding=0 width="100%">
  <TBODY>

<!-- HEADER -->
  <TR>
    <TD 
    style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 6px; PADDING-TOP: 6px" 
    colSpan=3>
      <TABLE id=banner 
      style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px" 
      width="100%">
        <TBODY>
        <TR>
          <TD vAlign=center align=left width=90><img src="../img/yav-logo.gif" width="80" height="50" alt="Yav Logo" border="0"></TD>
          <TD><FONT size=5>yav - javascript validation tool</FONT></TD>
          <TD 
          style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px" 
          vAlign=center align=right>
          <a href="http://sourceforge.net"><img src="http://sourceforge.net/sflogo.php?group_id=133036&amp;type=2" width="125" height="37" border="0" alt="SourceForge.net Logo" /></a>
        </TD></TR></TBODY></TABLE></TD></TR>
  <TR>

<!-- TOP BAR -->
    <TD id=bar colSpan=3>
      <TABLE 
      style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px" 
      width="100%">
        <TBODY>
        <TR>
          <TD align=left>
          <a href="../en/index.html"><img src="../img/flag.en.png" width="20" height="14" border="0" alt="english" /></a>
          <a href="../it/index.html"><img src="../img/flag.it.png" width="20" height="14" border="0" alt="italiano" /></a>
          &nbsp;&nbsp;<A href="index.html">Home</A> </TD>
          <TD align=right><SPAN id=Content> 
            <A href="download.html">Download</A></SPAN> | <a href="http://groups.google.com/group/yav-en/">Support</a> 
        </TD></TR></TBODY></TABLE></TD></TR>
  <TR>

<!-- LEFT COLUMN -->
    <TD id=leftColumn style="PADDING-TOP: 0px" vAlign=top><SPAN id=Content>
      <br>
      
        <table class="htmlBox" border="0" cellpadding="0" cellspacing="0">
        <tbody>
        <tr>
        <th class="L"><br></th>
        <th class="C">Documentation</th>
        <th class="R"><br></th>
        </tr>
        <tr>
            <td colspan="3" class="B"><ul class="htmlBoxUl">
            <li><A title="Getting started" href="gettingstarted.html">Getting started</A></li>
            <li><A title="Validation rules" href="validationrules.html">Validation rules</A></li>
            <li><A title="Multi-language support" href="languages.html">Multi-language support</A></li></ul></td>
        </tr>
        </tbody>
        </table>

        <table class="htmlBox" border="0" cellpadding="0" cellspacing="0">
        <tbody>
        <tr>
        <th class="L"><br></th>
        <th class="C">Learn by example</th>
        <th class="R"><br></th>
        </tr>
        <tr>
            <td colspan="3" class="B"><ul class="htmlBoxUl">
            <li><A title="Simple registration form" href="example_1.html">Simple registration form</A></li>
            <li><A title="Notification of changes" href="example_2.html">Notification of changes</A></li>
            <li><A title="Newsletter Sign-up" href="example_3.html">Newsletter Sign-up</A></li>
            <li><A title="Captcha" href="example_4.php">Captcha</A></li>
            <li><A title="The andor-operator" href="example_5.html">The andor-operator</A></li>
            <li><A title="Pre/Post/Implies rules" href="example_6.html">Pre/Post/Implies rules</A></li>
            <li><A title="Working with the masks" href="example_7.html">Working with the masks</A></li></ul></td>
        </tr>
        </tbody>
        </table>

        <table class="htmlBox" border="0" cellpadding="0" cellspacing="0">
        <tbody>
        <tr>
        <th class="L"><br></th>
        <th class="C">Support</th>
        <th class="R"><br></th>
        </tr>
        <tr>
            <td colspan="3" class="B"><ul class="htmlBoxUl">
            <li><A title="Discussion group" href="http://groups.google.com/group/yav-en/">Discussion group</A></li>
            <li><A title="Mailing list" href="mailto:f.crivellaro@gmail.com?subject=[Yav]subscribe_mailing_list">Mailing list</A></li>
            <li><A title="E-mail contact" href="mailto:f.crivellaro@gmail.com?subject=[Yav]contact">E-mail contact</A></li></ul></td>
        </tr>
        </tbody>
        </table>

    </TD>

<!-- RIGHT COLUMN -->
    <TD id=rightColumn vAlign=top>
      <DIV>
      <DIV id=Content>
      <H1 class=heading1>Example 4</H1>
      <P class=paragraph>
      <DIV class=panelContent >

      <FORM name="myform" onsubmit="checkOnSubmit('myform', rules);return false;" method="post">
        <input type=hidden name=alertType id=alertType value=inline />
        <TABLE width=100%>
        <TR>
          <TD>
          Here you can learn more about the ajax calls with yav using the post validation.<br><br>
          [This is a trivial captcha example (you must have cookies enabled because of our server's settings for php).<br>
          In a real web application you should use a more secure captcha service. The captcha validation is case insensitive.]<br><br>
          <a href="#" onclick="toggle($('source'));">source</a><br>
          <span id="source" style="display: none"><TEXTAREA name=foo class=inputNormal cols=80 rows=4 readonly=true disabled>
    var rules=new Array();
    rules[0]='code:the captcha code|required';
    yav.addHelp('code', 'Please enter the characters on the image above');
    yav.postValidation_OnOK('code', 'blur', 'ajaxCall()');
          </TEXTAREA></span>
          </TD>
        </TR>
        <TR>
        <TD width=100% valign=top>
            <TABLE valign=top>
            <TR><TD class=><H4>Captcha Example</H4></TD>
            <TD align=right></TD></TR>
            <TR><TD class=><DIV id=errorsDiv></DIV></TD><TD></TD></TR>
            <TR><TD class=><img src="captcha_image.php" border="0"></TD><TD></TD></TR>
            <TR><TD class=>Enter the code:&nbsp;&nbsp;&nbsp;<INPUT type=text name=code class=inputNormal />&nbsp;&nbsp;<span id=errorsDiv_code></span></TD><TD></TD></TR>
            <TR><TD class=>&nbsp;</TD><TD></TD></TR>
            <TR><TD class=><INPUT type=submit id=submitbutton name=submitbutton value=submit class=buttonstyledisabled disabled=true /><br></TD><TD></TD></TR>
            </TABLE>
        </TD>
        <TD width=5%></TD>
        <TD width=55% valign=top>
           &nbsp;
       </TD>
        </TR>
        </TABLE>
      </FORM>
      </DIV>

      </P></DIV></DIV>&nbsp;
      </TD>
    <TD></TD></TR>
<!-- FOOTER -->
  <TR>
    <TD id=footer colSpan=3>
      <TABLE width="100%">
        <TBODY>
        <TR>
          <TD vAlign=top align=right>
            Copyright 2005-2008. All rights reserved.</TD></TR></TBODY>
      </TABLE>
  </TD></TR></TABLE>
</TR></TBODY></TABLE></BODY></HTML>