package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	
	private String dbName = "segurosgroup";
	
	private Conexion()
	{
		try
		{
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName,"root","root");
			this.connection.setAutoCommit(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		try {
			Connection nuevaConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName,"root","root");
			nuevaConexion.setAutoCommit(false);
			return nuevaConexion;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
