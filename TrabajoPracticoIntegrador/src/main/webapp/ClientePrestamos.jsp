
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <%@ page import="Entidades.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ClientePrestamos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<header>
    	<jsp:include page="ClienteNavBar.jsp"></jsp:include>
	</header>
	<main class="container mt-3">
	
	<% 	ArrayList<CuentaBancaria> cuentas;
	double cuota= 0;%>
	<h1 class="mb-3 text-center">Sección Prestamos</h1>

		
		<div class="row">
		<div class="col-md-8">		
		
		 <div class="card card-body bg-light">
		 <form method="post" action="servletsClientes">
                    <h5 class="fw-semibold fst-italic mb-3">Solicitá un nuevo prestamo </h5>                    
                    
                <label id="cbuDestino" class="form-label">Monto deseado</label>
               <% Double valor = (Double) session.getAttribute("totalPedido");%>
    			<input type="text" name="montoDeseado"  class="form-control mb-2" value="<%= valor != null ? valor : "" %>" required  placeholder="Ingrese el monto deseado">
				
				<select class="form-select mb-2"  name="plazoMeses">
				<%Integer cuotas = (Integer) session.getAttribute("cuotas");%>
				    <option value="3" <%= (cuotas != null && cuotas == 3) ? "selected" : "" %>>3 cuotas</option>
				    <option value="6" <%= (cuotas != null && cuotas == 6) ? "selected" : "" %>>6 cuotas</option>
				    <option value="12" <%= (cuotas != null && cuotas == 12) ? "selected" : "" %>>12 cuotas</option>
				    <option value="18" <%= (cuotas != null && cuotas == 18) ? "selected" : "" %>>18 cuotas</option>
				    <option value="24" <%= (cuotas != null && cuotas == 24) ? "selected" : "" %>>24 cuotas</option>
				    </select>
				<input type="submit" name="btnCalcularCuota" class="btn btn-primary py-0 w-100 mb-4 mt-3" value="Calcular valor de las cuotas">
		</form>
		<hr class="border border-secondary opacity-50"> 

			<form method="post" action="servletsClientes">
		<label id="cbuDestino" class="form-label">Valor de la cuota</label>
		<% if(session.getAttribute("montoCuota") != null)
			{cuota = (double)(session.getAttribute("montoCuota")) ;}%>
		<input type="text" class="form-control mb-2" id="cuota" value="<%= cuota %>" readonly>
				
      	<label for="CuentaDestino" class="form-label">Cuenta a depositar</label>
		<% CuentaBancaria cuenta = (CuentaBancaria)session.getAttribute("cuentaElegida"); %>
		<input type="text" class="form-control mb-5" value="<%= cuenta != null ? cuenta.toString() : "No seleccionada" %>" readonly>
		       		
		       		 
      	<div class="d-inline-flex align-items-center gap-2">
      	<button type="button" class="btn btn-outline-primary py-3" data-bs-toggle="modal" data-bs-target="#confirmarCambioModal"> Solicitar préstamo</button>
      	
      	<div class="modal fade" id="confirmarCambioModal" tabindex="-1" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <h5 class="modal-title">¿Confirmar solicitud?</h5>
		                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		            </div>
		            <div class="modal-body">
		               ¿Estás seguro de solicitar este préstamo? Esta acción no se puede deshacer.
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
		               <input type="submit" class="btn btn-outline-primary" name="btnSolicitarPrestamo" value=" Sí, solicitar">		                
		            </div>
		        </div>		
		    </div>
		</div>
        
        <%	if(request.getAttribute("prestamoAgregado") != null) {			
		%>
		<div class="alert alert-success mt-3" role="alert">
            <i class="bi bi-check-circle-fill"></i> ¡Solicitud de Prestamo enviada! Una ves aprobado, podras verlo reflejado en Historial"
        </div><%
		}
		%>
        
		</div>
		</form></div>
		</div>	
		
		<div class="col-md-4">
		<form method="post" action="servletsClientes ">
		
			  <button class="btn btn-outline-success w-100 py-4" type="button" data-bs-toggle="collapse" data-bs-target="#seccionEdicion" name="btnEditarContraseña">
                <i class="bi bi-pencil-square me-2 "></i>Pagar cuotas de tu prestamo existente
            </button>            
           
            <div class="collapse mt-3" id="seccionEdicion">
                <div class="card card-body bg-light">
                <input type="submit" name="btnseleccionPrestamo" class="btn btn-primary py-0 w-100 mb-4 mt-3" value="Actualizar">
                
                    <h5 class="fw-semibold fst-italic mb-3">Seleccionar prestamo </h5>
                    
				<select name="seleccionPrestamo" class="form-select">
			    <% 
			        ArrayList<Prestamo> prestamos = (ArrayList<Prestamo>) request.getAttribute("prestamosActuales");
			        //String cuentaSeleccionada = request.getParameter("numeroCuenta");
			        
			        if(prestamos != null && !prestamos.isEmpty()) {
			            for(Prestamo pres : prestamos) { 
			            	String descripcion = String.valueOf(pres.getImporteSolicitado());
			            	String descripcion2 = String.valueOf(pres.getFechaSolicitado());
			            	String valorOption = String.valueOf(pres.getCodPrestamo());
			                %>
			                <option value="<%= valorOption %>"
		                    <%= (pres != null && pres.equals(valorOption)) ? "selected" : "" %>>
		                    <%= descripcion + descripcion2 %>
                </option>
			    <% 
			            }
			        } else {
			    %>
			            <option disabled selected>No hay prestamos vigentes</option>
			    <% 
			        } 
			    %>
			</select>
			
			<input type="button" class="btn btn-secondary " value="Seleccionar" name="btnPagoPrestamo"
                   data-bs-toggle="modal" data-bs-target="#confirmarCambioModal">
               </div>
    		</div>
   
    <div class="modal fade" id="confirmarCambioModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">¿Estás seguro?</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <i class="bi bi-exclamation-triangle-fill text-warning me-2"></i>
                    Esta acción no se puede deshacer.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                 
                    <input type="submit" class="btn btn-warning" name="btnCambioContra" value="Sí, actualizar">
						</div>
            </div>		
       	 </div>
		</div>
		</form>
	</div>
	
		</div>
			
	</main>
	

</body>
</html>