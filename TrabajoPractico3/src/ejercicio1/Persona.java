package ejercicio1;

import java.util.Set;
import java.util.TreeSet;

public class Persona implements Comparable<Persona>{
	private String _nombre;
	private String _apellido;
	private String _dni;
	
	public Persona (String nombre, String apellido, String dni)
	{
		_nombre = nombre;
		_apellido = apellido;
		_dni = dni;
	}
	
	@Override
	public String toString() {
		return  _nombre + " " + _apellido + " " + _dni;
	}

	public static boolean verificarDniInvalido(String dni) throws DniInvalido
	{
		for (int i = 0; i < dni.length(); i++) {
	        if (!Character.isDigit(dni.charAt(i))) {
	            throw new DniInvalido();
	        }
	    }
	    return true;
	}
	
	public static Persona convertirPersona(String linea) throws DniInvalido {
        String[] partes = linea.split("-");
        if (partes.length != 3) {
            throw new IllegalArgumentException("Formato incorrecto: " + linea);
        }
        
        String nombre = partes[0].trim();
        String apellido = partes[1].trim();
        String dni = partes[2].trim();
        
        verificarDniInvalido(dni);
        
        return new Persona(nombre, apellido, dni);
    }
	
	@Override
	public int compareTo(Persona o) {
		return this._apellido.compareTo(o._apellido);
	}
}
