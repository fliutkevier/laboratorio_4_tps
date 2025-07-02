package DaoInterfaz;

import java.util.ArrayList;

import Entidades.CuentaBancaria;

public interface IDaoCuentaBancaria {
	public ArrayList<CuentaBancaria> obtenerCuentaPorCliente(String CodigoCliente);
	public ArrayList<CuentaBancaria> obtenerCuentasPorTipo(char tipoCuenta);
	public ArrayList<CuentaBancaria> buscarCuentasFiltradas(String codigoCliente, String tipoCuenta, String estado);
	public boolean darBajaCuenta(int numeroCuenta);
	public boolean asignarCuenta(int codigoCliente, char tipoDeCuenta, String cbu);
	public ArrayList<String> obtenerCbuExistentes();
	public boolean darAltaCuenta(int numeroCuenta);
	public CuentaBancaria ObtenerCuentaporID(int id);
}
