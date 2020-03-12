<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="logout">logout</a>
	<table border="1">
		<thead>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>address</td>
				<td>dob</td>
				<c:if test="${user.profile == 'admin'}">
					<td>delete</td>
					<td>update</td>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.id }</td>
					<td>${customer.name }</td>
					<td>${customer.address }</td>
					<td><fmt:formatDate value="${customer.dob }"
							pattern="dd/MM/yyyy" /></td>

					<c:if test="${user.profile == 'admin'}">
						<td><a
							href="custController.do?action=delete&id=<c:out value="${customer.id }"/>">delete</a>
						</td>
						<td><a
							href="custController.do?action=update&id=<c:out value="${customer.id }"/>">update</a>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${user.profile == 'mgr'|| user.profile == 'admin' }">
		<a href="custController.do?action=add">add new customer</a>
	</c:if>

</body>
</html>




