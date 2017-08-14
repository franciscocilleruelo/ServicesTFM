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

	<h1>Crear pedido</h1>
	<br/>
	<spring:url value="/orders/create" var="orderActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="order"
		action="${orderActionUrl}">

		<spring:bind path="customerId">
			<div class="form-group">
				<label class="col-sm-2 control-label">ID Cliente</label>
				<div class="col-sm-10">
					<form:input path="customerId" type="text" class="form-control"
						id="customerId" placeholder="ID Cliente" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="total">
			<div class="form-group">
				<label class="col-sm-2 control-label">Total</label>
				<div class="col-sm-10">
					<form:input path="total" type="text" class="form-control" id="total"
						placeholder="Total" />
				</div>
			</div>
		</spring:bind>



		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Crear</button>
			</div>
		</div>
	</form:form>

</div>

</body>
</html>