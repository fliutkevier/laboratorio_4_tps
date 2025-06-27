package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.PersonaDao;
import entidad.Persona;


public class PersonaDaoImpl implements PersonaDao {
	
	public boolean Agregar(Persona persona) {
		PreparedStatement pst;
		String query = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES (?, ?, ?)";
		Connection cn = null;
	    int filas = 0;

	    try {
	    	cn = Conexion.getConexion().getSQLConexion();
	        pst = cn.prepareStatement(query);
	        pst.setString(1, persona.getDNI());
	        pst.setString(2, persona.getNombre());
	        pst.setString(3, persona.getApellido());
	        filas = pst.executeUpdate();
	        cn.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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

	public boolean Modificar(Persona persona) {
		String query = "UPDATE personas SET Nombre = ?, Apellido = ? WHERE Dni = ?";
		Connection cn = null;
	    int filas = 0;

	    try {
	    	cn = Conexion.getConexion().getSQLConexion();
	        PreparedStatement pst = cn.prepareStatement(query);
	        pst.setString(1, persona.getNombre());
	        pst.setString(2, persona.getApellido());
	        pst.setString(3, persona.getDNI());
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

	public boolean Eliminar(String dni) {
		String query = "DELETE FROM personas WHERE Dni = ?";
		Connection cn = null;
		boolean eliminarExito = false;

	    try {
	        cn = Conexion.getConexion().getSQLConexion();
	        PreparedStatement pst = cn.prepareStatement(query);
	        pst.setString(1, dni);
	        
	        if(pst.executeUpdate() > 0)
	        {
	        	cn.commit();
	        	eliminarExito = true;
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

	    return eliminarExito;
	}

	public ArrayList<Persona> Listar() {
		ArrayList<Persona> lPersonas = new ArrayList<Persona>();
		Connection cn = null;
		
		try{
		   cn = Conexion.getConexion().getSQLConexion();
		   String query = "SELECT * FROM personas";
		   Statement st = cn.createStatement();
		   ResultSet rs = st.executeQuery(query);
		   while(rs.next()){
		      Persona p = new Persona();
		      p.setDNI(rs.getString("Dni"));
		      p.setNombre(rs.getString("Nombre"));
		      p.setApellido(rs.getString("Apellido"));
		      lPersonas.add(p);
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
		return lPersonas;
	}
	

}
