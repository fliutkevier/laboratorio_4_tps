<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Entidades.CuentaBancaria" %>
    <%@ page import="Entidades.Movimiento" %>
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>ClienteHistorial</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<header>
    	<jsp:include page="ClienteNavBar.jsp"></jsp:include>
	</header>
	<main class="container mt-5">
    <h1 class="mb-4">Historial de Movimientos</h1>
    
    
    
    <%
    CuentaBancaria cuentaElegida = (CuentaBancaria) session.getAttribute("cuentaElegida");
    int nroCuenta = cuentaElegida != null ? cuentaElegida.getNroCuenta() : -1;
	%>
    
    <div class="table-responsive mt-4">
      <table  class="table table-bordered table-hover">
      
     
      
        <thead >
          <tr>
            <th scope="col">Fecha</th>
            <th scope="col">Detalle / Concepto</th>
            <th scope="col">Importe</th>
            <th scope="col">Tipo de movimiento</th>
          </tr>
        </thead>
        <tbody>
       
         <%
                        ArrayList<Movimiento> listaMovimientos = (ArrayList<Movimiento>) request.getAttribute("listaMovimientos");
                        if (listaMovimientos != null && !listaMovimientos.isEmpty()) {
                            for (Movimiento mov : listaMovimientos) {
                    %>
                                <tr>
                                    <td><%= mov.getFecha() %></td>
                                    <td><%= mov.getDetalle() %></td>
                                    <td class="<%= mov.getImporte().compareTo(new java.math.BigDecimal("0")) > 0 ? "text-success" : "text-danger" %>">
                                        <%= (mov.getImporte().compareTo(new java.math.BigDecimal("0")) > 0 ? "+" : "") + mov.getImporte() %>
                                    </td>
                                    <td><%= mov.getTipoMovimiento().getDescripcion() %></td>
                                </tr>
                    <%
                            }
                        } else {
                    %>
                            <tr>
                                <td colspan="4" class="text-center">No hay movimientos para mostrar</td>
                            </tr>
                    <%
                        }
                    %>
        </tbody>
     	</table>
     	
     	
	
     	
      </div>
    </main>


</body>
</html>