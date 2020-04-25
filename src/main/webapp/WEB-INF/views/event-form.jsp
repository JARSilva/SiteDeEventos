<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EventosApp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="$css">
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/event/showEvents">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/event/showAddForm">Add
						Evento</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/showHouse/showAddForm">Add
						Casa de Show</a></li>
			</ul>
			<form class="form-inline mt-2 mt-md-0">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="#">Entrar</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/client/showAddForm">Registrar</a></li>
				</ul>
			</form>
		</div>
	</nav>
	<div class="container">
		<form:form action="saveEvent" modelAttribute="event" method="POST">
			<div class="form-group">
				<label for="eventName">Nome do Evento</label> <form:input path="name" type="text"
					class="form-control" id="eventName"
					placeholder="Digite o nome do evento" value="${event.name}"/>
				<!-- <small id="emailHelp" class="form-text text-muted">We'll never 
					share your email with anyone else.</small>  -->
			</div>
			<div class="form-group">
				<label for="eventDescription">Descrição</label>
				<form:textarea path="description" class="form-control" id="eventDescription"
					placeholder="Descreva o evento" value="${event.description}"></form:textarea>
			</div>
			<!-- <div class="form-group">
				<label for="eventDate">Data do Evento</label> <form:input path="date" type="date"
					class="form-control" placeholder="Digite a data do evento"
					id="eventDate" value="${event.date}"/>
			</div>-->
			<div class="form-group">
				<label for="eventPrice">Preço por Ingresso do Evento</label> <form:input path="price"
					type="number" class="form-control"
					placeholder="Digite o preço por ingresso do evento" id="eventPrice"
					value="${event.price}"/>
			</div>
			<div class="form-group">
				<label for="eventQtd">Quantidade de Ingressos do Evento</label> <form:input path="qtdTicket"
					type="number" class="form-control"
					placeholder="Digite a quantidade de ingressos do evento"
					id="eventQtd" value="${event.qtdTicket}"/>
			</div>
			<div class="form-group">
				<label for="showHouse">Casa de Shows</label> 
					<form:select class="form-control" id="showHouse" path="showHouse">
					<form:options items="${showHouses}" itemValue="id" itemLabel="name" />
				</form:select>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>