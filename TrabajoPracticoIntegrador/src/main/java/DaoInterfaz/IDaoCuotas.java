package DaoInterfaz;

import java.util.ArrayList;

import Entidades.Cuotas;
import Entidades.Prestamo;

public interface IDaoCuotas {
	public ArrayList<Cuotas> obtenerCuotasDelPrestamo (int idPrestamo);
	public int creacionCuotas (int Codprestamo, int numeroCuota, int montoCuota);


}
