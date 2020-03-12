<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add / update customer</title>
</head>


<body>
<form action="custController.do" method="post">
	<input type="hidden" name="id" value="<c:out value="${customer.id}"/>">
	Enter name:<input type="text" name="name" value="<c:out value="${customer.name}"/>" readonly>* not updatable<br/>
	Enter addrss:<input type="text" name="address" value="<c:out value="${customer.address}"/>"><br/>
	Enter dob:<input type="text" name="dob" value="<fmt:formatDate value="${customer.dob }" pattern="dd/MM/yyyy"/>" readonly>* not updatable<br/>
	<input type="submit">
</form>
</body>
</html>