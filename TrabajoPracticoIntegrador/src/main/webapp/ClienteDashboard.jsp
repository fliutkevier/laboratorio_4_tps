<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	
</head>
<body>
<jsp:include page="ClienteNavBar.jsp"></jsp:include>
<div class="container mt-4">
<div class="row justify-content-center">
		<div class="col-md-4">
    
    <label class="h5 form-label d-block fw-bold border-bottom pb-2">Mis datos personales</label>
    
    <div class="mb-2">
        <label class="form-label text-secondary mb-1">Nombre:</label>
        <label id="lblNombreCompleto" class="form-control bg-light">Juan Pérez</label>
    </div>    
    <div class="mb-2">
        <label class="form-label text-secondary mb-1">DNI:</label>
        <label id="lblDNI" class="form-control bg-light">35.678.901</label>
    </div>
    <div class="mb-2">
        <label class="form-label text-secondary mb-1">Ubicacion</label>
        <label id="lblUbicacion" class="form-control bg-light">Mar del Plata, Bs As</label>
    </div>
    <div class="mb-2">
        <label class="form-label text-secondary mb-1">Telefono:</label>
        <label id="lblTelefono" class="form-control bg-light">2235478475</label>
    </div>
    <div class="mb-2">
        <label class="form-label text-secondary mb-1">Correo electronico:</label>
        <label id="lblCorreoElectronico" class="form-control bg-light">juanp@hotmail.com</label>
    </div>
    
   
</div>
		<div class="col-md-7">
		 <label class="h5 form-label d-block text-end fw-bold border-bottom pb-2">Ultimos Movimientos</label>
			
			 <div class="table-responsive mt-4">
      <table  class="table table-bordered table-hover">
        <thead >
          <tr>
            <th scope="col">Fecha</th>
            <th scope="col">Detalle / Concepto</th>
            <th scope="col">Importe</th>
            <th scope="col">Movimiento</th>
          </tr>
        </thead>
        <tbody>
       
          <tr>
            <td>2025-06-15</td>
            <td>Alta de cuenta - depósito inicial</td>
            <td class="text-success">+$10,000</td>
            <td>Alta de cuenta</td>
          </tr>
          <tr>
            <td>2025-06-20</td>
            <td>Transferencia recibida de CBU 1098765432109876543210</td>
            <td class="text-success">+$2,500</td>
            <td>Transferencia</td>
          </tr>
          <tr>
            <td>2025-06-22</td>
            <td>Pago de cuota préstamo #1234</td>
            <td class="text-danger">-$1,200</td>
            <td>Pago de préstamo</td>
          </tr>
          <tr>
            <td>2025-06-25</td>
            <td>Transferencia enviada a CBU 5555555555555555555555</td>
            <td class="text-danger">-$3,000</td>
            <td>Transferencia</td>
          </tr>
          <tr>
            <td>2025-06-28</td>
            <td>Alta de préstamo aprobado</td>
            <td class="text-success">+$15,000</td>
            <td>Alta de préstamo</td>
          </tr>
        </tbody>
     	</table>
      	</div>
		
		
	
		<div class="row justify-content-center g-4 py-4">		    
		    <div class="col-md-4 position-relative pe-md-3">
		        <div class="card h-100 border-primary ">
		            <a href="ClienteTransferencias.jsp" class="text-decoration-none">
		                <div class="card-body text-center py-4 bg-primary bg-opacity-10">
						<h5 class="card-title text-primary">Transferir</h5>
		                    <p class="card-text text-muted">Transferi en el acto hasta $500000</p>
		                </div>
		            </a>
		        </div>
		    </div>			 
		    <div class="col-md-4 position-relative px-md-3">
		        <div class="card h-100 border-success ">
		            <a href="ClientePrestamos.jsp" class="text-decoration-none">
		                <div class="card-body text-center py-4 bg-success bg-opacity-10">
		                  <h5 class="card-title text-success">Prestamos</h5>
		                    <p class="card-text text-muted">Solicita tu prestamo personal!</p>
		                </div>
		            </a>
		        </div>
		    </div>
		</div>
	   
</div>
</div>
</div>
</body>
</html>