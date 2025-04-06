package ejercicio1;

import java.util.Objects;

public class Profesor extends Empleado implements Comparable <Profesor> {
	
	// Atributos -------------------------
	private String cargo;
	private int antiguedadDocente;
	
	//constructores
	public Profesor()
	{
		super();
		cargo = "";
		antiguedadDocente = 0;
	}
	
	public Profesor(String nombre, int edad, String cargo, int antiguedadDocente)
	{
		super(nombre, edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}
	
	@Override
	public String toString()
	{
		return "ID: " + getId() + ", Nombre: " + getNombre() + ", Edad: " + getEdad() + ", Cargo: " + cargo + ", Antiguedad del docente: " + antiguedadDocente + ".";
	}

	@Override
	public int compareTo(Profesor o) {
		if(o.antiguedadDocente == this.antiguedadDocente)
		return 0;
		
		if(o.antiguedadDocente>this.antiguedadDocente)
		{
			return -1;
		}
		return 1;
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return antiguedadDocente == other.antiguedadDocente && Objects.equals(cargo, other.cargo);
	}
	
	
}
