<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Untitled Document</title>
<style type="text/css"> 
<!-- 
body  {
	font: 100% Verdana, Arial, Helvetica, sans-serif;
	background: #666666;
	margin: 0; /* it's good practice to zero the margin and padding of the body element to account for differing browser defaults */
	padding: 0;
	text-align: center; /* this centers the container in IE 5* browsers. The text is then set to the left aligned default in the #container selector */
	color: #000000;
}
.thrColFixHdr #container { 
	width: 780px;  /* using 20px less than a full 800px width allows for browser chrome and avoids a horizontal scroll bar */
	background: #FFFFFF;
	margin: 0 auto; /* the auto margins (in conjunction with a width) center the page */
	border: 1px solid #000000;
	text-align: left; /* this overrides the text-align: center on the body element. */
} 
.thrColFixHdr #header { 
	background: #DDDDDD; 
	padding: 0 10px 0 20px;  /* this padding matches the left alignment of the elements in the divs that appear beneath it. If an image is used in the #header instead of text, you may want to remove the padding. */
} 
.thrColFixHdr #header h1 {
	margin: 0; /* zeroing the margin of the last element in the #header div will avoid margin collapse - an unexplainable space between divs. If the div has a border around it, this is not necessary as that also avoids the margin collapse */
	padding: 10px 0; /* using padding instead of margin will allow you to keep the element away from the edges of the div */
}
.thrColFixHdr #sidebar1 {
	float: left; /* since this element is floated, a width must be given */
	width: 150px; /* the actual width of this div, in standards-compliant browsers, or standards mode in Internet Explorer will include the padding and border in addition to the width */
	background: #EBEBEB; /* the background color will be displayed for the length of the content in the column, but no further */
	padding: 15px 10px 15px 20px; /* padding keeps the content of the div away from the edges */
}
.thrColFixHdr #sidebar2 {
	float: right; /* since this element is floated, a width must be given */
	width: 160px; /* the actual width of this div, in standards-compliant browsers, or standards mode in Internet Explorer will include the padding and border in addition to the width */
	background: #EBEBEB; /* the background color will be displayed for the length of the content in the column, but no further */
	padding: 15px 10px 15px 20px; /* padding keeps the content of the div away from the edges */
}
.thrColFixHdr #mainContent { 
	margin: 0 200px; /* the right and left margins on this div element creates the two outer columns on the sides of the page. No matter how much content the sidebar divs contain, the column space will remain. You can remove this margin if you want the #mainContent div's text to fill the sidebar spaces when the content in each sidebar ends. */
	padding: 0 10px; /* remember that padding is the space inside the div box and margin is the space outside the div box */
} 
.thrColFixHdr #footer { 
	padding: 0 10px 0 20px; /* this padding matches the left alignment of the elements in the divs that appear above it. */
	background:#DDDDDD;
} 
.thrColFixHdr #footer p {
	margin: 0; /* zeroing the margins of the first element in the footer will avoid the possibility of margin collapse - a space between divs */
	padding: 10px 0; /* padding on this element will create space, just as the the margin would have, without the margin collapse issue */
}
.fltrt { /* this class can be used to float an element right in your page. The floated element must precede the element it should be next to on the page. */
	float: right;
	margin-left: 8px;
}
.fltlft { /* this class can be used to float an element left in your page */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* this class should be placed on a div or break element and should be the final element before the close of a container that should fully contain a float */
	clear:both;
    height:0;
    font-size: 1px;
    line-height: 0px;
}
--> 
</style><!--[if IE 5]>
<style type="text/css"> 
/* place css box model fixes for IE 5* in this conditional comment */
.thrColFixHdr #sidebar1 { width: 180px; }
.thrColFixHdr #sidebar2 { width: 190px; }
</style>
<![endif]--><!--[if IE]>
<style type="text/css"> 
/* place css fixes for all versions of IE in this conditional comment */
.thrColFixHdr #sidebar2, .thrColFixHdr #sidebar1 { padding-top: 30px; }
.thrColFixHdr #mainContent { zoom: 1; }
/* the above proprietary zoom property gives IE the hasLayout it needs to avoid several bugs */
</style>
<![endif]--></head>

<body class="thrColFixHdr">

<div id="container" style="background-color:#69C">
  <div id="header" style="background-color:#69C">
    <h1 align="center"><font color="#FFFFFF">Swen</font></h1>
  </div>
  <div id="sidebar1" style="background-color:#69C">
    <table width="100%" border="1" cellspacing="3">
        <tr>
      <td><a href="http://localhost:8080/swen"><font color="#000000">Trang chủ</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/1"><font color="#000000">An ninh hình sự</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/2"><font color="#000000">Bóng đá</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/3"><font color="#000000">Thời trang</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/4"><font color="#000000">Tài chính - Bất động sản</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/5"><font color="#000000">Ẩm thực</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/6"><font color="#000000">Làm đẹp</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/7"><font color="#000000">Điện ảnh</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/8"><font color="#000000">Giáo dục - du học</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/9"><font color="#000000">Bạn trẻ - Cuộc sống</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/10"><font color="#000000">Ca nhạc</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/11"><font color="#000000">Phi thường - kì quặc</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/12"><font color="#000000">Vi tính - Internet</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/13"><font color="#000000">Điện thoại</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/14"><font color="#000000">Oto - xe máy</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/15"><font color="#000000">Thị trường - Tiêu dùng</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/16"><font color="#000000">Du lịch</font></a></td>
      </tr>
      <tr>
      <td><a href="http://localhost:8080/swen/cat/17"><font color="#000000">Y tế - thiết bị</font></a></td>
      </tr>
    </table>
  <h3>&nbsp;</h3>
  <!-- end #sidebar1 --></div>
  <div id="sidebar2" style="background-color:#69C">
  <c:if test="${true!=signIn}">
	  <h3><a href="${baseUrl}/signin"><font color="#000000">Sign in</font></a></h3>
	  <h3><a href="${baseUrl}/SignUp"><font color="#000000">Sign up</font></a></h3>
	    <p>&nbsp;</p>
  </c:if>
  <c:if test="${true==signIn}">
  	<h3><a href="${baseUrl}/suggest"><font color="#000000">Đề xuất tin mới</font></a></h3>
	<h3><a href="${baseUrl}/SignOut"><font color="#000000">Sign out</font></a></h3>
	    <p>&nbsp;</p>
  </c:if> 
  <!-- end #sidebar2 --></div>
  <div id="mainContent" style="background-color:#C1DBDD">
  <c:forEach items="${articles}" var="article">
  	<h3><a href="${baseUrl}/art/${article.id}">${article.name}</a></h3>
  </c:forEach>
  <!-- end #mainContent --></div>
	<!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats --><br class="clearfloat" />
  <div id="footer" style="background-color:#69C">
    <p align="center"><font size="-1">Dev team: Lê Ngọc Minh, Đỗ Bích Ngọc, Phạm Vũ Long</font></p>
  <!-- end #footer --></div>
<!-- end #container --></div>
</body>
</html>