<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#0a2f5b">

<br/>

<form method="post" action="${pageContext.request.contextPath }/demo">
<center><input type="text" name="productId">
<input type="submit" value="Generate"><br><br/>
<img border="3px" height="300px" width="300px" src="${pageContext.request.contextPath }/qrcode?productId=${productId}"></center>
</form>
</body>
</html>