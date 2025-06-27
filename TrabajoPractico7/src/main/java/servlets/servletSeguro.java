package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.*;
import negocio.SeguroNegocio;



@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public boolean estado;
	SeguroNegocio negocio = new SeguroNegocio();
    
    public servletSeguro() {
        super();
       
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        ArrayList<TipoSeguro> tiposSeguro = negocio.mostrarTiposSeguro();
        request.setAttribute("tiposSeguro", tiposSeguro);
     
        String param = request.getParameter("Param");
        String tipoSeguro = request.getParameter("tipoSeguro");
        String accion = request.getParameter("accion");
        
        if ("agregar".equals(accion) || "1".equals(param)) {
            int nuevoId = SeguroNegocio.UltimoId();
            cargarTiposSeguro(request);
            request.setAttribute("nuevoId", nuevoId);
            request.setAttribute("mensaje", "");
            request.getRequestDispatcher("/AgregarSeguro.jsp").forward(request, response);
            return;
        }
        else if ("listar".equals(accion) || "2".equals(param) || tipoSeguro != null) {
            ArrayList<Seguro> listaSeguros;
            
            if (tipoSeguro != null && !tipoSeguro.isEmpty()) {
                listaSeguros = negocio.FiltrarPorTipoSeguro(Integer.parseInt(tipoSeguro));
            } else {
                listaSeguros = negocio.ObtenerSeguros();
            }
            
            request.setAttribute("listaS", listaSeguros);
            request.getRequestDispatcher("/ListarSeguros.jsp").forward(request, response);
            return;
        }
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar") != null)
		{
			int nuevoId = SeguroNegocio.UltimoId();
			String descripcion = request.getParameter("txtDescripcion");
		    String tipo = request.getParameter("tipoSeguro");
		    String costoCont = request.getParameter("txtCostoContratacion");
		    String costoMax = request.getParameter("txtCostoMax");
		    
		    if (!validarCampos(descripcion, tipo, costoCont, costoMax)) {
		    	request.setAttribute("nuevoId", nuevoId);
		    	request.setAttribute("mensaje", "SEGURO NO AGREGADO --- ¡ Todos los campos deben estar completos y los costos deben ser números válidos !");
		    }
		    else {
		    	Seguro seguro = new Seguro();
				seguro.setDescripcion(descripcion);
				seguro.setIdTipo(Integer.parseInt(tipo));
				seguro.setCostoContratacion(Double.parseDouble(costoCont));
				seguro.setCostoAsegurado(Double.parseDouble(costoMax));
				
				SeguroNegocio seguroNegocio = new SeguroNegocio();
				seguroNegocio.AgregarNegocio(seguro);
				request.setAttribute("mensaje", "¡ Seguro agregado con éxito !");
				
				nuevoId = SeguroNegocio.UltimoId();
				request.setAttribute("nuevoId", nuevoId);
		    }
		    cargarTiposSeguro(request);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");   
	        rd.forward(request, response);
		}
		
	}
	
	public boolean validarCampos(String descripcion, String tipo, String costoCont, String costoMax) {
	    if (descripcion == null ||tipo == null ||costoCont == null  ||costoMax == null){
	    	return false;
	    }

	    try {
	        if(Integer.parseInt(tipo) == 0) {return false;}
	        Double.parseDouble(costoCont);
	        Double.parseDouble(costoMax);
	    } catch (NumberFormatException e) {
	        return false;
	    }

	    return true;
	}
	
	private void cargarTiposSeguro(HttpServletRequest request) {
		 SeguroNegocio negocio = new SeguroNegocio();
		 ArrayList<TipoSeguro> tiposSeguro = negocio.mostrarTiposSeguro();
		    
		 String opcionesTipoSeguro = "";
		    for (TipoSeguro tipo : tiposSeguro) {
		        opcionesTipoSeguro += "<option value='" + tipo.getIdTipo() + "'>" + tipo.getDescripcion() + "</option>";
		    }
	    
	    request.setAttribute("segurosExistentes", opcionesTipoSeguro.toString());
	}

}
