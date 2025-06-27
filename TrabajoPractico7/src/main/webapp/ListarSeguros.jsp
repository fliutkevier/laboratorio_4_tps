<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Entidad.*"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Seguros</title>
</head>
<body>

	<a href="Inicio.jsp">Inicio</a>
	<a href="servletSeguro?Param=1">Agregar Seguro</a>
	<a href="servletSeguro?Param=2">Listar Seguros</a>
	<br>
	
	<h2>"Tipo de seguros en la base de datos"</h2>
	
	
<form method="get" action="servletSeguro">
    <input type="hidden" name="accion" value="listar">
    Busqueda por tipo de seguros: 
    <select name="tipoSeguro">
        <option value="">Todos los tipos</option>
        <% 
        ArrayList<TipoSeguro> tiposSeguro = (ArrayList<TipoSeguro>) request.getAttribute("tiposSeguro");
        String tipoSeleccionado = request.getParameter("tipoSeguro");
        if(tiposSeguro != null) {
            for(TipoSeguro tipo : tiposSeguro) { 
        %>
            <option value="<%= tipo.getIdTipo() %>"
                <%= (tipoSeleccionado != null && tipoSeleccionado.equals(String.valueOf(tipo.getIdTipo()))) ? "selected" : "" %>>
                <%= tipo.getDescripcion() %>
            </option>
        <% 
            }
        } 
        %>
    </select>
    <input type="submit" value="Filtrar">
</form>
  <br> <br>
  
  
 <% 
ArrayList<Seguro> listaSeguros = null;
if(request.getAttribute("listaS") != null) {
    listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaS");
    // Mensaje de diagnóstico
    out.println("<!-- Cantidad de seguros: " + listaSeguros.size() + " -->");
}
%>
  <table border="1" style="max-width: 800px; width: 100%;">>
    <tr>
        <th>ID Seguro</th>
        <th>Descripción Seguro</th>
        <th>Descripción Tipo Seguro</th>
        <th>Costo Contratación</th>
        <th>Costo Máximo Asegurado</th>
    </tr>
    <% if(listaSeguros != null && !listaSeguros.isEmpty()) {
        for(Seguro seg : listaSeguros) { %>
    <tr>  
        <td><%= seg.getIdSeguro() %></td>   
        <td><%= seg.getDescripcion() %></td>   
        <td><%= seg.getTipo() != null ? seg.getTipo().getDescripcion() : "N/A" %></td>
        <td><%= seg.getCostoContratacion() %></td>   
        <td><%= seg.getCostoAsegurado() %></td>    
    </tr>
    <% }
    } else { %>
    <tr>
        <td colspan="5">No hay seguros registrados</td>
    </tr>
    <% } %>
</table>

	

</body>
</html>
