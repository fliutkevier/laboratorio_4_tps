package ejercicio1;

public class Persona {
	private String _nombre;
	private String _Apellido;
	private String _dni;
	
	public static boolean verificarDniInvalido(String dni) throws DniInvalido
	{
		for (int i = 0; i < dni.length(); i++) {
	        if (!Character.isDigit(dni.charAt(i))) {
	            throw new DniInvalido();
	        }
	    }
	    return true;
	}

	@Override
	public String toString() {
		return _nombre + ", " + _Apellido + ", " + _dni;
	}
	
	
}
