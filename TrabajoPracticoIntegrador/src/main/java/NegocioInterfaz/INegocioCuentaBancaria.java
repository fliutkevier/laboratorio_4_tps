package NegocioInterfaz;

import java.util.ArrayList;

import Entidades.CuentaBancaria;

public interface INegocioCuentaBancaria {
	public ArrayList<CuentaBancaria> buscarCuentasBancariasPorClienteAsignado(String cliente);
	public ArrayList<CuentaBancaria> buscarCuentasBancariasPorTipo(char tipo);
	public ArrayList<CuentaBancaria> buscarCuentasFiltradas(String codigoCliente, String tipoCuenta, String estado);
	public boolean darBajaCuenta(int numeroCuenta);
	public boolean darAltaCuenta(int numeroCuenta);
	public boolean asignarCuenta(int codigoCliente, char tipoDeCuenta);
	public CuentaBancaria ObtenerporID(int id);
}
