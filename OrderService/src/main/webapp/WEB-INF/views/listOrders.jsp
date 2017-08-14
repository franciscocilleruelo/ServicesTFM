<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Microservicio de pedidos - Crear Pedido</title>

<spring:url value="../resources/css/hello.css" var="coreCss" />
<spring:url value="../resources/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<body>

	<jsp:include page="common/header.jsp" />

	<div class="container">

		<h1>Pedidos</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID Pedido</th>
					<th>ID Cliente</th>
					<th>Estado</th>
					<th>Total</th>
				</tr>
			</thead>

			<c:forEach var="order" items="${orders}">
				<tr>
					<td>${order.orderId}</td>
					<td>${order.customerId}</td>
					<td>${order.status}</td>
					<td>${order.total}</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>