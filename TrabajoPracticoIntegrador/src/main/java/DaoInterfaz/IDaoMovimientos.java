package DaoInterfaz;

import java.util.ArrayList;

import Entidades.Movimiento;


public interface IDaoMovimientos {
	public ArrayList<Movimiento> obtenerMovimientosPorCuenta(int nroCuenta);
}
