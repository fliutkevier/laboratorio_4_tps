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
import NegocioInterfaz.INegocioCuotas;
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
       INegocioCuotas negCuotas = new NegocioCuotas();
  
   
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
        	agregarPrestamo(request, response);
        }
        
        if (request.getParameter("btnCargarPrestamos") != null)  {
        	cargarPrestamosActuales(request, response);
        }
        
        if (request.getParameter("btnVerHistorial") != null) {
            mostrarHistorial(request, response);
        }
        if (request.getParameter("btnGeneraCuotas") != null) {
            cargarCuotas(request, response);
        }
        
        if (request.getParameter("btnPagarCuota") != null) {
            pagarPrestamo(request, response);
        }
        
        if (request.getParameter("btnHistorialFiltrado") != null) {
    	    String tipoMovimiento = request.getParameter("tipoMovimiento");

    	    if (tipoMovimiento == null || tipoMovimiento.isEmpty()) {
    	        mostrarHistorial(request, response);
    	    } else {
    	        mostrarHistorialFiltrado(request, response, tipoMovimiento); 
    	    }
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

        CuentaBancaria cuentaElegida = (CuentaBancaria) request.getSession().getAttribute("cuentaElegida");

        int nroCuenta = cuentaElegida.getNroCuenta();
        ArrayList<Movimiento> movimientos = movimiento.obtenerMovimientosPorCuenta(nroCuenta);
        request.setAttribute("listaMovimientos", movimientos);
        request.getRequestDispatcher("ClienteHistorial.jsp").forward(request, response);
		}

		private void mostrarHistorialFiltrado(HttpServletRequest request, HttpServletResponse response, String tipoMovimiento) throws ServletException, IOException {
         CuentaBancaria cuentaElegida = (CuentaBancaria) request.getSession().getAttribute("cuentaElegida");
        int nroCuenta = cuentaElegida.getNroCuenta();
        ArrayList<Movimiento> movimientosFiltrados = movimiento.obtenerMovimientosPorTipo(nroCuenta, tipoMovimiento);


        request.setAttribute("listaMovimientos", movimientosFiltrados);
        request.setAttribute("tipoMovimientoSeleccionado", tipoMovimiento);
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
	
	
	
	private void sumarPrestamoAaCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
	    HttpSession session = request.getSession();
		double cantidadPedida = (double)session.getAttribute("totalPedido");			
		CuentaBancaria cuenta = (CuentaBancaria) session.getAttribute("cuentaElegida");		
		double nuevoSaldo = cantidadPedida + Double.parseDouble(String.valueOf(cuenta.getSaldo()));
		BigDecimal BDnuevoSaldo = new BigDecimal(String.valueOf(nuevoSaldo));
		
		
		cuenta.setSaldo(BDnuevoSaldo);
		
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
		crearCuotas(prestamo);
		request.setAttribute("prestamoAgregado", confirmar);
		request.getRequestDispatcher("/ClientePrestamos.jsp").forward(request, response);
	}
	private void crearCuotas(Prestamo prestamo)
	{	
		int Codprestamo = prestamo.getCodPrestamo();
		int cuotas = prestamo.getCuotasTotales();
		int montoCuota = prestamo.getPagoMensual().intValue();
		for (int i = 0; i<cuotas ; i++)			
			negCuotas.CrearCuotasdePrestamo (Codprestamo, (i+1), montoCuota);
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
		session.setAttribute("prestamosActuales", prestamosCuenta);
		request.getRequestDispatcher("/ClientePrestamos.jsp").forward(request, response);
		
	}
	
	private void cargarCuotas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String prestamoId = request.getParameter("seleccionPrestamo");
		    String cuentaId = request.getParameter("seleccionCuentaPago");

		    if (prestamoId != null && cuentaId != null) {
	            int cuentaPago = Integer.parseInt(cuentaId);
	            int prestamoAaPagar = Integer.parseInt(prestamoId);
	            CuentaBancaria cuentaAaCobrar = negcuentaBancaria.ObtenerporID(cuentaPago);		            
	            double saldoAntesdeDescontar = cuentaAaCobrar.getSaldo().doubleValue();
			HttpSession session = request.getSession();
			session.setAttribute("IdprestamoSeleccionado", prestamoId);
	        session.setAttribute("cuentaPagoCuota", cuentaAaCobrar);
						
			ArrayList <Cuotas> cuotas = new ArrayList<Cuotas>();
			cuotas = negCuotas.listarCuotasPorIdPrestamo(prestamoAaPagar);	
			
			session.setAttribute("saldoAntesdeDescontar", saldoAntesdeDescontar);
			session.setAttribute("listadoCuotas", cuotas);
			
		}
		request.getRequestDispatcher("/ClientePrestamos.jsp").forward(request, response);
		
	}
	///TERMINAR
	
		private void pagarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			//generar movimiento - solo pagar estado = 0 - marcar cuota como 1 - restar saldo en cuenta
			int cuotaElegida = Integer.parseInt(request.getParameter("seleccionCuota"));
			
			HttpSession session = request.getSession();
			CuentaBancaria cuenta = (CuentaBancaria)session.getAttribute("cuentaPagoCuota");
			//negcuentaBancaria.actualizarSaldo()
		}
}


