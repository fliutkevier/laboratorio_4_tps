package daoImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import dao.PersonaDao;
import entidad.Persona;


public class PersonaDaoImpl implements PersonaDao {
	 private String host = "jdbc:mysql://localhost:3306/";
	 private String user = "root";
	 private String pass = "root";
	 private String dbName = "bdPersonas";
	
	public boolean Agregar(Persona persona) {
		String query = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES (?, ?, ?)";
		Connection cn = null;
	    int filas = 0;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        PreparedStatement pst = cn.prepareStatement(query);
	        pst.setString(1, persona.getDNI());
	        pst.setString(2, persona.getNombre());
	        pst.setString(3, persona.getApellido());
	        filas = pst.executeUpdate();
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

	public boolean Modificar(Persona persona) {
		String query = "UPDATE personas SET Nombre = ?, Apellido = ? WHERE Dni = ?";
		Connection cn = null;
	    int filas = 0;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        PreparedStatement pst = cn.prepareStatement(query);
	        pst.setString(1, persona.getNombre());
	        pst.setString(2, persona.getApellido());
	        pst.setString(3, persona.getDNI());
	        filas = pst.executeUpdate();
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

	public boolean Eliminar(int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Persona> Listar() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
