package NegocioInterfaz;
import java.util.ArrayList;

import Entidades.Movimiento;

public interface INegocioMovimientos {
	ArrayList<Movimiento> obtenerMovimientosPorCuenta(int nroCuenta);
}
