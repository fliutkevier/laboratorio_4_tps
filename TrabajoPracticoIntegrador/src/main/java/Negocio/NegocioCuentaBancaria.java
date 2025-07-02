package Negocio;

import NegocioInterfaz.INegocioCuentaBancaria;

import java.util.ArrayList;
import java.util.Random;

import Dao.DaoCuentaBancaria;
import DaoInterfaz.IDaoCuentaBancaria;
import Entidades.CuentaBancaria;

public class NegocioCuentaBancaria implements INegocioCuentaBancaria{
	
	private IDaoCuentaBancaria cuentaDao = new DaoCuentaBancaria();
	
	public boolean darBajaCuenta(int numeroCuenta)
	{
		return cuentaDao.darBajaCuenta(numeroCuenta);
	}
	
	public ArrayList<CuentaBancaria> buscarCuentasBancariasPorClienteAsignado(String codCliente)
	{
		if (codCliente == null) {
			return new ArrayList<>();
		}
		
		return cuentaDao.obtenerCuentaPorCliente(codCliente);
	}
	
	public ArrayList<CuentaBancaria> buscarCuentasBancariasPorTipo(char tipo)
	{
		return cuentaDao.obtenerCuentasPorTipo(tipo);
	}

	
	public ArrayList<CuentaBancaria> buscarCuentasFiltradas(String codigoCliente, String tipoCuenta, String estado) {
		
		 return cuentaDao.buscarCuentasFiltradas(codigoCliente, tipoCuenta, estado);
	}
	
	public boolean asignarCuenta(int codigoCliente, char tipoDeCuenta)
	{
		String cbu = generarCbuUnico();
		
		return cuentaDao.asignarCuenta(codigoCliente, tipoDeCuenta, cbu);
	}
	
	private String generarCbuUnico()
	{
		ArrayList<String> cbuExistentes = cuentaDao.obtenerCbuExistentes();
		
		String cbuUnico;
		
		do
		{
			cbuUnico = generarCBU();
	    } while (cbuExistentes.contains(cbuUnico));
		
		return cbuUnico;
	}
	
	private String generarCBU() {
		
	    StringBuilder cbu = new StringBuilder();
	    Random random = new Random();

	    for (int i = 0; i < 22; i++) 
	    {
	        cbu.append(random.nextInt(10));
	    }

	    return cbu.toString();
	}
	
	public boolean darAltaCuenta(int numeroCuenta)
	{
		return cuentaDao.darAltaCuenta(numeroCuenta);
	}
	public CuentaBancaria ObtenerporID(int id)
	{
		return cuentaDao.ObtenerCuentaporID(id);
	}
	
}
