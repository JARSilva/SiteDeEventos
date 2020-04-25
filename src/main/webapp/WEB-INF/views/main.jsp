<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<a class="navbar-brand  active" href="${pageContext.request.contextPath}/event/showEvents">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/event/showAddForm">Add Evento</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/showHouse/showAddForm">Add Casa de Show</a></li>
			</ul>
			<form class="form-inline mt-2 mt-md-0">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="#">Entrar</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/client/showAddForm">Registrar</a></li>
				</ul>
			</form>
		</div>
	</nav>

	<div class="site-section bg-light">
		<div class="container">
			<div class="row align-items-stretch retro-layout-2">
				<div class="col-md-4">
					<c:forEach var="tempEvent" items="${events}">
					<a href="single.html" class="h-entry mb-30 v-height gradient"
						style="background-image: url('images/img_1.jpg');">

						<div class="text">
							<h2>${tempEvent.name}</h2>
							<span class="date">${tempEvent.date}</span>
						</div>
					</a>
					</c:forEach> 
				</div>
				

			</div>
		</div>
	</div>
</body>
</html>