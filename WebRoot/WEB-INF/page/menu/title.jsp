
<%@ page language="java"  pageEncoding="UTF-8"%>




<HTML>
<HEAD>
<TITLE>Top</TITLE>

<STYLE type=text/css>BODY {
	FONT-SIZE: 12px; MARGIN: 0px; COLOR: #000000; BACKGROUND-COLOR: #ffffff
}
TD {
	FONT-SIZE: 12px; COLOR: #000000
}
TH {
	FONT-SIZE: 12px; COLOR: #000000
}
</STYLE>
<SCRIPT type="text/javascript">
function submitrequest(action){
eval("document.location='"+action+"'");
}

</SCRIPT>
</HEAD>
<BODY>
<FORM id="Form1" name="Form1"  method="post">
<table border="0" width="100%" height="9" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100%" colspan="4" background="${pageContext.request.contextPath }/images/title.jpg" height="58">　</td>
  </tr>
  <tr>
    <td width="100%" height="1" bgcolor="#66C89C" colspan="4"><img border="0" src="${pageContext.request.contextPath }/images/titleline.jpg" width="100%" height="3"></td>
  </tr>
  <tr>
    <td width="20%" height="19" bgcolor="#0965CA">
    <table border="0" width="100%" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15%" align="center"><font color="#FFFFFF"><b>|</b></font></td>
        <td width="70%" align="center">
        <FONT color=#FFFFFF>
            <b>
            <SCRIPT language=JavaScript>
										<!--
										tmpDate = new Date();
										date = tmpDate.getDate();
										month= tmpDate.getMonth() + 1 ;
										year= tmpDate.getFullYear();
										document.write(year);
										document.write("-");
										document.write(month);
										document.write("-");
										document.write(date);
										document.write(" ");

										myArray=new Array(6);
										myArray[0]="Sunday"
										myArray[1]="Monday"
										myArray[2]="Tuesday"
										myArray[3]="Wednesday"
										myArray[4]="Thursday"
										myArray[5]="Friday"
										myArray[6]="Saturday"
										weekday=tmpDate.getDay();
										if (weekday==0 | weekday==6)
										{
										document.write(myArray[weekday])
										}
										else
										{document.write(myArray[weekday])
										};
										// -->
										</SCRIPT>
            </b>
            </FONT></td>
        <td width="15%" align="center"><font color="#FFFFFF"><b>|</b></font></td>
      </tr>
    </table>
    
    <td width="16%" height="19" bgcolor="#0965CA">
    <table cellSpacing="2" height="19" cellPadding="0" width="100%" border="0" ><tr><td valign="top">
    <b><font color="#FFFFFF">Welcome!&nbsp;&nbsp;&nbsp;admin</font></b>
    </td></tr></table>
    </td>
    <td width="46%" height="19" bgcolor="#0965CA">　</td>
    <td width="18%" height="19" bgcolor="#0965CA" align="center">
      <table border="0" width="100%" cellspacing="0" cellpadding="0">
        <tr>
          <td width="100%" align="center">
          <A href="elecMenuAction_loading.do" target="mainFrame"><font color="#FFFFFF"><b>Return Home</b></font></a>
          <font color="#FFFFFF"><b>|</b></font>
          <A href="elecMenuAction_logout.do"   target="_top"> <font color="#FFFFFF"><b>Re-Login</b></font></A>
          <font color="#FFFFFF"><b>|</b></font>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</FORM>
</BODY>
</HTML>
