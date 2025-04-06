package ejercicio1;

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
		// TODO Auto-generated method stub
		return 0;
	}
	

}
