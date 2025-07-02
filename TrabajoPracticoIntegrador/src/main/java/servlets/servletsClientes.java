package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Negocio.*;
import NegocioInterfaz.INegocioCuentaBancaria;
import Entidades.*;
import NegocioInterfaz.INegocioMovimientos;
import Negocio.NegocioMovimiento;
import NegocioInterfaz.INegocioPrestamo;

/**
 * Servlet implementation class servletsClientes
 */
@WebServlet("/servletsClientes")
public class servletsClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Cliente cliente = new Cliente();
       CuentaBancaria cuenta;
       INegocioCuentaBancaria negcuentaBancaria = new NegocioCuentaBancaria();
       INegocioMovimientos movimiento = new NegocioMovimiento();
       INegocioPrestamo negPrestamo = new NegocioPrestamo();
  
   
    public servletsClientes() {
        super();      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        if (request.getParameter("btnSeleccionCuenta") != null) {
        	cargarSeleccionCuenta(request, response);
        }
        
        if (request.getParameter("btnCalcularCuota") != null)  {
        	calcularCuota(request, response);
        }
        
        if (request.getParameter("btnSolicitarPrestamo") != null)  {
        	solicitarPrestamo(request, response);
        }
        
        if (request.getParameter("btnseleccionPrestamo") != null)  {
        	cargarPrestamosActuales(request, response);
        }
        
	}
	
	private void cargarSeleccionCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    	if(request.getParameter("numeroCuenta") != null)
		  {
    		int idCuenta = Integer.parseInt(request.getParameter("numeroCuenta"));
    		cuenta = negcuentaBancaria.ObtenerporID(idCuenta);
    		request.getSession().setAttribute("cuentaElegida", cuenta);
    		int nroCuenta = cuenta.getNroCuenta();
            ArrayList<Movimiento> movimientos = movimiento.obtenerMovimientosPorCuenta(nroCuenta);
            request.setAttribute("listaMovimientos", movimientos);
            request.getRequestDispatcher("/ClienteDashboard.jsp").forward(request, response);
            return;
		  }
    	
    	request.getRequestDispatcher("/ClienteDashboard.jsp").forward(request, response);
    	
    }
	
	
	private void mostrarHistorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
		    if (session == null || session.getAttribute("cuentaElegida") == null) {
		        response.sendRedirect("iniciocliente.jsp");
		        return;
		    }
		    CuentaBancaria cuentaElegida = (CuentaBancaria) session.getAttribute("cuentaElegida");
		    int nroCuenta = cuentaElegida.getNroCuenta();
		    ArrayList<Movimiento> movimientos = movimiento.obtenerMovimientosPorCuenta(nroCuenta);

		    request.setAttribute("listaMovimientos", movimientos);
		    request.getRequestDispatcher("ClienteHistorial.jsp").forward(request, response);
    }
	
	private void calcularCuota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if((request.getParameter("plazoMeses") != null) && (request.getParameter("montoDeseado") != null))
		  {
			int cuota = Integer.parseInt(request.getParameter("plazoMeses"));  	
			double montoPedido = Double.parseDouble(request.getParameter("montoDeseado"));  
			double valorCuota =(double)( montoPedido * 1.20 ) / cuota;
			HttpSession session = request.getSession();
	        session.setAttribute("montoCuota", valorCuota);
	        session.setAttribute("totalPedido", montoPedido);
	        session.setAttribute("cuotas", cuota);
		  }
		request.getRequestDispatcher("/ClientePrestamos.jsp").forward(request, response);
	}
	
	private void solicitarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	

		agregarPrestamo(request, response);
		sumarPrestamoAaCuenta(request, response);
		pagarPrestamo(request, response);
		
	}
	
	private void sumarPrestamoAaCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
	    HttpSession session = request.getSession();
		double cantidadPedida = (double)session.getAttribute("totalPedido");			
		CuentaBancaria cuenta = (CuentaBancaria) session.getAttribute("cuentaElegida");		
		double nuevoSaldo = cantidadPedida + Double.parseDouble(String.valueOf(cuenta.getSaldo()));
		BigDecimal BDnuevoSaldo = new BigDecimal(String.valueOf(nuevoSaldo));
		
		
		cuenta.setSaldo(BDnuevoSaldo);
		
	}
	
	private void pagarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
	private void agregarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{	
		HttpSession session = request.getSession();
		if (session.getAttribute("clienteSesion") != null) {
			    cliente = (Cliente) session.getAttribute("clienteSesion");
		}
		Prestamo prestamo = new Prestamo();
		prestamo.setClienteAsociado(cliente);			
		
		CuentaBancaria cuenta = (CuentaBancaria)session.getAttribute("cuentaElegida");
		prestamo.setCuentaAsociada(cuenta);
		
		double importeSolicitado = (double)session.getAttribute("totalPedido");
		BigDecimal BDtotalpedido = new BigDecimal(String.valueOf(importeSolicitado));
		prestamo.setImporteSolicitado(BDtotalpedido);
		
		int plazoMeses = (int)session.getAttribute("cuotas");
		prestamo.setPlazoMeses(plazoMeses);
		
		double pagoMensual = (double)session.getAttribute("montoCuota");
		BigDecimal BDpagoMensual = new BigDecimal(String.valueOf(pagoMensual));
		prestamo.setPagoMensual(BDpagoMensual);
		
		int cuotasTotales = (int)session.getAttribute("cuotas");
		prestamo.setCuotasTotales(cuotasTotales);
		
		float importeAaPagar = (float) pagoMensual * plazoMeses;
		BigDecimal BDimporteAaPagar = new BigDecimal(String.valueOf(importeAaPagar));
		prestamo.setImportePagar(BDimporteAaPagar);
		
		int confirmar = negPrestamo.agregarNuevoPrestamo(prestamo);
		request.setAttribute("prestamoAgregado", confirmar);
		request.getRequestDispatcher("/ClientePrestamos.jsp").forward(request, response);
	}
	private void cargarPrestamosActuales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if (session.getAttribute("clienteSesion") != null) {
			    cliente = (Cliente) session.getAttribute("clienteSesion");
		}
		
		int idCuentaActual = cuenta.getNroCuenta();
		ArrayList<Prestamo> prestamosCuenta = new ArrayList<Prestamo>();
		ArrayList<Prestamo> todosLosPrestamosVigentes = negPrestamo.obtenerPrestamosAceptados();
		for(Prestamo prestamo : todosLosPrestamosVigentes)
		{
			if(prestamo.getCuentaAsociada().getNroCuenta()==idCuentaActual && prestamo.isDeuda())
				prestamosCuenta.add(prestamo);
		}
		request.setAttribute("prestamosActuales", prestamosCuenta);
		request.getRequestDispatcher("/ClientePrestamos.jsp").forward(request, response);
		
	}
}


