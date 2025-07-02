<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ClienteTransferencias</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<header>
    	<jsp:include page="ClienteNavBar.jsp"></jsp:include>
	</header>
	
	<main class="container mt-5">
		<h1 class="mb-4">Transferencias</h1>
		<form>
			<div class="mb-3">
       			<label for="SeleccionarCuenta" class="form-label">Seleccione cuenta de origen</label>
       			<select id="SeleccionarCuenta" name="idCuenta" class="form-select">
          			<option value="1">Caja de ahorro - Nº 123456789 (CBU: 0123456789012345678901)</option>
          			<option value="2">Cuenta corriente - Nº 987654321 (CBU: 1098765432109876543210)</option>
          			<option value="3">Caja de ahorro - Nº 555555555 (CBU: 5555555555555555555555)</option>
        		</select>
      		</div>
      		<div class="mb-3">
				<label id="cbuDestino" class="form-label">CBU destino</label>
				<input type="text" class="form-control" id="cbuDestino" name="cbuDestino" maxlength="22" placeholder="Ingrese el CBU de la cuenta destino">
			</div>
			<div class="mb-3">
				<label id="Monto" class="form-label">Monto a transferir</label>
				<input type="text" class="form-control" id="Monto" maxlength="22" placeholder="Ingrese el monto a transferir">
			</div>
      		<button type="submit" class="btn btn-primary mt-2" >Confirmar transferencia</button>
		</form>
	</main>

</body>
</html>