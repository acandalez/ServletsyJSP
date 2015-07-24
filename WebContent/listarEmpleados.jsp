<%@page import="model.beans.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
// 	ArrayList<Employee> empleados = (ArrayList<Employee>) request
// 			.getAttribute("empleados");
%>
<html>
<head>
<!-- CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" type='text/css' />

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de empleados</title>
<style type="text/css">
#empleados {
	margin-left: 5%;
}

h1 {
	font-size: 50px;
}

body {
	width: 100%;
	text-align: center;
}




</style>
</head>
<body class="container-fluid">
	<h1>Empleados</h1>
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Department ID</th>
			<th>Salario</th>
		</tr>
		<c:forEach items="${empleados}" var="empleado">
			<tr>
				<td>${empleado.employeeId}</td>
				<td>${empleado.firstName} ${empleado.lastName}</td>
				<td>${empleado.departmentId}</td>
				<td>${empleado.salary}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>