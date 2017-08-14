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

		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>Pedido creado</strong>
		</div>

		<div class="row">
			<label class="col-sm-2">ID pedido</label>
			<div class="col-sm-10">${order.orderId}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">ID Cliente</label>
			<div class="col-sm-10">${order.customerId}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Total</label>
			<div class="col-sm-10">${order.total}</div>
		</div>

	</div>

</body>
</html>