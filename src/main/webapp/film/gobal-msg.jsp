<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%	String nextUrl = (String)request.getAttribute("nextUrl");
			%>
			<meta http-equiv="refresh" content="2;url=<%=request.getContextPath()+nextUrl %>">
</head>
<body>
<div style="border:1px solid #B4C9E0;padding:1px;background-color:#F5FAFE;text-align:center;clear:both;">
		<div class="fgreen" style="margin:0 auto;padding:15px;width:60%;background:url(templates/default/images/btn-true.gif) no-repeat left center;">
			<div style="line-height:22px;padding-left:45px;text-align:center;"><%=request.getAttribute("msg") %><br>
			</div>
		</div>
		<div style="clear:both;"></div>
	</div>
</body>
</html>