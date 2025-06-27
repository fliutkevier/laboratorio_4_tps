package negocio;

import java.util.ArrayList;

import Entidad.Seguro;
import Entidad.TipoSeguro;
import dao.SeguroDao;
import dao.TipoSeguroDao;

public class SeguroNegocio {
	
	static SeguroDao seguroDao = new SeguroDao();
	static TipoSeguroDao Tiposegurodao = new TipoSeguroDao();
	
	public boolean AgregarNegocio(Seguro seguro)
	{
		return seguroDao.agregarSeguro(seguro);
	}
	
	public ArrayList<Seguro> FiltrarPorTipoSeguro(int id){
		return seguroDao.filtrarPorTipoSeguro(id);
	}
	
	public static int UltimoId() {
		return seguroDao.ultimoId();
	}
	
	public ArrayList<Seguro> ObtenerSeguros()
	{
		return seguroDao.obtenerTodos();
	}
	public ArrayList<TipoSeguro> mostrarTiposSeguro()
	{
		return Tiposegurodao.obtenerTipoSeguros();
	}
}
