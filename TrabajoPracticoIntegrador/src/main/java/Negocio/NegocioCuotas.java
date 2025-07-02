package Negocio;

import java.util.ArrayList;

import Dao.DaoCuotas;
import DaoInterfaz.IDaoCuotas;
import Entidades.Cuotas;
import Entidades.Prestamo;
import NegocioInterfaz.INegocioCuotas;

public class NegocioCuotas implements INegocioCuotas{
	IDaoCuotas dao = new DaoCuotas();
	
	public ArrayList<Cuotas >listarCuotasPorIdPrestamo (int num)
	{
		return dao.obtenerCuotasDelPrestamo(num);
	}
	public int CrearCuotasdePrestamo (int Codprestamo, int numeroCuota, int montoCuota)
	{
		return dao.creacionCuotas (Codprestamo, numeroCuota, montoCuota);
	}
		

}
