package ejercicio1;

	//constructores
public class Empleado {
	
	public Empleado() {
		contid ++;
		id = contid;
		edad = 99;
		nombre = "Sin nombre";	
	}
	
	public Empleado(String nombre, int edad) {
		   contid++;
		   this.id = contid;
		   this.nombre = nombre;
		   this.edad = edad;
	}

	public static int devuelveProximoID(){
		
		   return contid+1;
	}
	
	//getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//atributos	
	private int id;
	private String nombre;
	private int edad;
	
	static int contid = 999;
	
	//toString
	public String toString() {
		return "Empleado: " + nombre + ", Edad: " + edad + ", Legajo:" + id;
	}
}
