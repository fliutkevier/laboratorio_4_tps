package NegocioInterfaz;
import java.util.ArrayList;

import Entidades.*;

public interface INegocioCuotas {
	public ArrayList<Cuotas>listarCuotasPorIdPrestamo (int num);
	public int CrearCuotasdePrestamo (int Codprestamo, int numeroCuota, int montoCuota);

}
