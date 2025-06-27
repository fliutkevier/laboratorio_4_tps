package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidad.TipoSeguro;

public class TipoSeguroDao {
	
	public ArrayList<TipoSeguro> obtenerTipoSeguros() {
		ArrayList<TipoSeguro> lTipos = new ArrayList<TipoSeguro>();
		Connection cn = null;
		
		try{
		   cn = Conexion.getConexion().getSQLConexion();
		   String query = "SELECT * FROM tiposeguros";
		   Statement st = cn.createStatement();
		   ResultSet rs = st.executeQuery(query);
		   while(rs.next()){
		      TipoSeguro t = new TipoSeguro();
		      t.setIdTipo(rs.getInt("idTipo"));
		      t.setDescripcion(rs.getString("descripcion"));
		      lTipos.add(t);
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
		return lTipos;
	}
}
