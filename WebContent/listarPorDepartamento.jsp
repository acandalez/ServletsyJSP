<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.beans.Department"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Department> departamentos = (ArrayList<Department>) request
			.getAttribute("departamentos");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" type='text/css' />

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
h1 {
	font-size: 50px;
}

body {
	width: 100%;
	text-align: center;
}
</style>
<title>Empleados por departamento</title>
</head>
<body class="form-control">
	<form class="form-control" method="GET" action="ListarEmpleadosServlet">
		<select name="departamento">
			<c:forEach items="${departamentos}" var="item">
				<option name="${item.departmentId}">${item.departmentName}</option>
			</c:forEach>
		</select> <input type="submit" value="Obtener Empleados" />
	</form>
</body>
</html>

<%-- 			<% --%>
<!-- // 			 	for (int i = 0; i < departamentos.size(); i++) { -->
<%-- 			%> --%>
<%-- 			<option name="<%=departamentos.get(i).getDepartmentId()%>"><%=departamentos.get(i).getDepartmentName()%></option> --%>
<%-- 			<% --%>
<!--  				} -->
<%-- 			%> --%>