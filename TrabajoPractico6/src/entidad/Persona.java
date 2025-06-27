package entidad;

import java.util.Objects;

public class Persona {
	
	private String DNI;
	private String nombre;
	private String apellido;
	
	public Persona() {
		
	}
	
	public Persona(String dni, String Nombre, String Apellido)
	{
		this.DNI = dni;
		this.nombre = Nombre;
		this.apellido = Apellido;
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dni) {
		DNI = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(DNI, other.DNI);
	}

	@Override
	public String toString() {
		return nombre + " " + apellido + " " + DNI;
	}

}
