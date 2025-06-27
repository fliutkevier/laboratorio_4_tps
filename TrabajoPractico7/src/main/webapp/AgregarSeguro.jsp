<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Seguro</title>
</head>
<body>


    <a href="Inicio.jsp">Inicio</a>
	<a href="servletSeguro?Param=1">Agregar Seguro</a>
	<a href="servletSeguro?Param=2">Listar Seguros</a>
	<br>
	
	<h2>Agregar Seguros</h2>
	
	<form action="servletSeguro" method="post">
		<br> Id Seguro: <label>${nuevoId}</label><br>
		<br> Descripción: <input type="text" name="txtDescripcion"> <br>
		<br> Tipo de Seguro: <select name="tipoSeguro">
			<option value="0" disabled selected>Elija un tipo de seguro</option>
			${segurosExistentes}
		</select> <br>
		<br> Costo contratación: <input type="text" name="txtCostoContratacion"> <br>
		<br> Costo Máximo Asegurado: <input type="text" name="txtCostoMax"> <br>
		<input type="submit" value="Aceptar" name="btnAceptar" style="height: 34px; "><br>
	</form>
	<br>
	<label>${mensaje}</label><br>
</body>
</html>