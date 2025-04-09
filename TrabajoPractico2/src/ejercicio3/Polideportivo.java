package ejercicio3;

public class Polideportivo {
	
	private String Nombre;
	private double Superficie;
	
	public String getNombre() {
		return Nombre;
	}		
	public double getSuperficie() {
		return Superficie;
	}
	
	public Polideportivo() {
		Nombre = "Sin nombre";
		Superficie = 0;
	}
	
	public Polideportivo(String nombre, double superficie) {
		Nombre = nombre;
		Superficie = superficie;
	}
		
}
