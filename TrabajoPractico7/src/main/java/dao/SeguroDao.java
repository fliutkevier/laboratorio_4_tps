package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Seguro;
import Entidad.TipoSeguro;



public class SeguroDao {
	
	public boolean agregarSeguro(Seguro seguro)
	{
		
		PreparedStatement pst;
		String query = "INSERT INTO seguros(descripcion,idTipo,costoContratacion,costoAsegurado) VALUES (?, ?, ?, ?)";
		Connection cn = null;
	    int filas = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
	    	cn = Conexion.getConexion().getSQLConexion();
	        pst = cn.prepareStatement(query);
	        pst.setString(1, seguro.getDescripcion());
	        pst.setInt(2, seguro.getIdTipo());
	        pst.setDouble(3, seguro.getCostoContratacion());
	        pst.setDouble(4, seguro.getCostoAsegurado());
	        filas = pst.executeUpdate();
	        cn.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    finally {
	    	try {
				cn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	    return filas>0;
	}
	

	public int ultimoId() {
		int idMax, idProximo=0;
		PreparedStatement pst;
		String query = "SELECT MAX(idSeguro) AS max_id FROM seguros";
		Connection cn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
	    	cn = Conexion.getConexion().getSQLConexion();
	        pst = cn.prepareStatement(query);
	        ResultSet rs = pst.executeQuery(query);
	        if (rs.next()) {
	            idMax = rs.getInt("max_id");
	            idProximo = idMax + 1;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    finally {
	    	try {
				cn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return idProximo;
	}	

	
	
	public ArrayList<Seguro> filtrarPorTipoSeguro(int id) {
		ArrayList<Seguro> lSeguros = new ArrayList<Seguro>();
		Connection cn = null;
		
		try{
		   cn = Conexion.getConexion().getSQLConexion();
		   String query = "SELECT S.idSeguro, S.descripcion, S.idTipo, " +
	                 "T.descripcion AS descripcionTipo, S.costoContratacion, " +
	                 "S.costoAsegurado FROM seguros S " +
	                 "INNER JOIN tiposeguros T ON S.idTipo = T.idTipo " +
	                 "WHERE S.idTipo = ?";
		   PreparedStatement pst = cn.prepareStatement(query);
	       pst.setInt(1, id);
		   ResultSet rs = pst.executeQuery();
		   
		   while(rs.next()){
			   Seguro s = new Seguro();
				s.setIdSeguro(rs.getInt("idSeguro"));
			    s.setDescripcion(rs.getString("descripcion"));
			    TipoSeguro tipo = new TipoSeguro();
			    tipo.setIdTipo(rs.getInt("idTipo"));
			    tipo.setDescripcion(rs.getString("descripcionTipo")); 			   
			    s.setTipo(tipo);
			    s.setCostoContratacion(rs.getDouble("costoContratacion"));
			    s.setCostoAsegurado(rs.getDouble("costoAsegurado"));
				
			    lSeguros.add(s);
		    }
		}
		catch (Exception e){
		 e.printStackTrace();
	}
		finally {
	    	try {
				cn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lSeguros;
	}
	
	public ArrayList<Seguro> obtenerTodos()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection cn = null;
		try{
			cn = Conexion.getConexion().getSQLConexion();
			String query = "SELECT S.idSeguro, S.descripcion, S.idTipo, T.descripcion AS descripcionTipo, S.costoContratacion, S.costoAsegurado FROM seguros S INNER JOIN tiposeguros T ON S.idTipo = T.idTipo";
			PreparedStatement pst = cn.prepareStatement(query);		       
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next()){
				
				Seguro s = new Seguro();
				s.setIdSeguro(rs.getInt("idSeguro"));
			    s.setDescripcion(rs.getString("descripcion"));
			    TipoSeguro tipo = new TipoSeguro();
			    tipo.setIdTipo(rs.getInt("idTipo"));
			    tipo.setDescripcion(rs.getString("descripcionTipo")); 			   
			    s.setTipo(tipo);
			    s.setCostoContratacion(rs.getDouble("costoContratacion"));
			    s.setCostoAsegurado(rs.getDouble("costoAsegurado"));
				
				lista.add(s);
			}
			cn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
}
}
