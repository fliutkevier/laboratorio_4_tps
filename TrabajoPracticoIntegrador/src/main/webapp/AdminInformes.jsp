<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Entidades.Cliente" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminInformes</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<h2 class="mb-3 mt-3 text-center">Generador de Informes</h2>


<form action="servletAdminClientes" method="post">
	<div class="row justify-content-center mt-2">
		<div class="col-md-12 mt-3 text-center">
			<label for="dtpFechaInicial" class="form-label ms-4">Fecha Inicial:</label>
		    <input required type="date" class="ms-2"id="dtpFechaInicial" name="dtpFechaInicial">
		    
		    <label for="dtpFechaFinal" class="form-label ms-4">Fecha Final:</label>
		    <input required type="date" class="form-label ms-2"id="dtpFechaFinal" name="dtpFechaFinal">
	    </div>
		    <input type="submit" class="btn btn-primary mt-2 w-25" name="btnGenerarInforme" value="Generar informe">
    </div>

	<% if (request.getAttribute("fechaInicio") != null)
	{ %>
		<div class="container mt-4 text-center">
			<div class="row">
				<div class="col">
					<b>Fecha Inicial Seleccionada: <label>${fechaInicio}</label></b>
				</div>
				<div class="col">
					<b>Fecha Final Seleccionada: <label>${fechaFinal}</label></b>
				</div>
			</div>
		</div>

		<div class="container mt-4 text-center">
			<div class="row justify-content-center">
				<div class="col">
					<p class="fw-medium text-primary-emphasis">Cantidad de Cuentas Dadas de Alta: ${cuentasDadasAlta}</p>
					<table class="table table-bordered table-hover">
						<thead class="table-light">
						<tr>
							<th>Caja de ahorro</th>
							<th>Cuenta corriente</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>${cuentasAltaCajaAhorro}</td>
							<td>${cuentasAltaCorriente}</td>
						</tr>
						</tbody>
					</table>
				</div>
				<div class="col">
					<p class="fw-medium text-primary-emphasis">Cantidad de cuentas dadas de baja: ${cuentasDadasBaja}</p>
					<table class="table table-bordered table-hover">
						<thead class="table-light">
						<tr>
							<th>Caja de ahorro</th>
							<th>Cuenta corriente</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>${cuentasBajaCajaAhorro}</td>
							<td>${cuentasBajaCorriente}</td>
						</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row mt-4 justify-content-center">
					<%
						ArrayList<Cliente> clientes = (ArrayList<Cliente>)request.getAttribute("clientesNuevosLista");

						if (clientes != null && !clientes.isEmpty()) {	%>
					<div class="col">
						<p class="fw-semibold text-primary-emphasis">Clientes nuevos asociados: <%= clientes.size() %></p>
						<table class="table mt-3 text-center">
							<thead class="table-light">
							<tr>
								<th>Código cliente</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Fecha de alta</th>
							</tr>
							</thead>
							<tbody>
							<% for (Cliente c : clientes) { %>
							<tr>
								<td><%= c.getCodCliente() %></td>
								<td><%= c.getNombre() %></td>
								<td><%= c.getApellido() %></td>
								<td><%= c.getFechaDadoAlta() != null ? c.getFechaDadoAlta().toLocalDate() : "-" %></td>
							</tr>
							<% } %>
							<% } else { %>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<% } %>
							</tbody>
						</table>
					</div>


					<div class="row justify-content-center mt-3">
						<div class="col-md-12">
							<hr class="my-4">
						</div>
						<div class="col-md-4  mt-3">
							Préstamos activos: <label>${prestamosActivos}</label><br>
							Préstamos atrasados: <label>${prestamosAtrasados}</label><br>
							Préstamos saldados: <label>${prestamosSaldados}</label><br>
							Cumplibilidad de préstamos: <label>${cumplibilidad}</label>%<br>

						</div>
						<div class="col-md-4  mt-5">
							Saldo promedio por cuenta: <label>${saldoPromedio}</label><br>
							Saldo total en el banco: <label>${saldoBanco}</label><br>

						</div>
						<div class="col-md-4  mt-5">
							Transferencias realizadas:  <label>${transferencias}</label><br>
							<br>
							Movimientos totales realizados:  <label>${movimientos}</label><br>
							<br>
						</div>
					</div>
					<div class="col-md-12">
						<hr class="my-4">
					</div>
				</div>
			</div>
		</div>

	<%}%>


</form>

</body>
</html>