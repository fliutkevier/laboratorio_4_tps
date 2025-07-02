package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DaoInterfaz.IDaoCuotas;
import Entidades.Cliente;
import Entidades.CuentaBancaria;
import Entidades.Cuotas;
import Entidades.Prestamo;
import Entidades.TipoCuenta;
import Negocio.NegocioCliente;
import Negocio.NegocioTipoCuenta;
import NegocioInterfaz.INegocioCliente;
import NegocioInterfaz.INegocioTipoCuenta;

public class DaoCuotas implements IDaoCuotas {
	
	public ArrayList<Cuotas> obtenerCuotasDelPrestamo (int idPrestamo){
		
		ArrayList<Cuotas> cuentas = new ArrayList<Cuotas>();
		Connection cn = null;
		
		try {			
			cn = Conexion.getConexion().getSQLConexion();
			String query = "SELECT CodCuota, NumeroCuota, MontoCuota, EstadoPago FROM Cuotas WHERE CodPrestamo = ?";
			
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setInt(1, idPrestamo);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
											
				Cuotas cuota = new Cuotas();
				cuota.setCodigoCuota(rs.getInt("CodCuota"));
				cuota.setNumeroCuota(rs.getInt("NumeroCuota"));
				cuota.setMontoCuota(rs.getDouble("MontoCuota"));
				cuota.setEstado(rs.getBoolean("EstadoPago"));		
				
				cuentas.add(cuota);
			}
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null)
                    cn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
		return cuentas;
		
	}
	public int creacionCuotas (int Codprestamo, int numeroCuota, int montoCuota)
	{
		Connection cn = null;
		int filas=0;

        try {
        	
            cn = Conexion.getConexion().getSQLConexion();
            String query = "INSERT INTO Cuotas (CodPrestamo, NumeroCuota, MontoCuota) values (?,?,?)";
            PreparedStatement pst = cn.prepareStatement(query);
                    
            	pst.setInt(1, Codprestamo);
            	pst.setInt(2, numeroCuota);
            	pst.setInt(3, montoCuota);
            	filas = pst.executeUpdate();
    	        cn.commit();
            	          

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null)
                    cn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        return filas;
		
	}

}
