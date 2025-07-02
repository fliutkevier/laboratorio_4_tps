package Negocio;
import Entidades.Movimiento;
import java.util.ArrayList;

import Dao.DaoMovimientos;
import NegocioInterfaz.INegocioMovimientos;


public class NegocioMovimiento implements INegocioMovimientos {

	 private DaoMovimientos daoMovimientos = new DaoMovimientos();

	    public ArrayList<Movimiento> obtenerMovimientosPorCuenta(int nroCuenta) {
	        return daoMovimientos.obtenerMovimientosPorCuenta(nroCuenta);
	    }
		

}