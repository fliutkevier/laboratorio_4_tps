package DaoInterfaz;

import java.util.ArrayList;

import Entidades.Movimiento;


public interface IDaoMovimientos {
	public ArrayList<Movimiento> obtenerMovimientosPorCuenta(int nroCuenta);
	public ArrayList<Movimiento> obtenerMovimientosPorTipo(int nroCuenta, String codTipoMovimiento);
}
