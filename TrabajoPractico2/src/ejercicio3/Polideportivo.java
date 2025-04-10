package ejercicio3;

public class Polideportivo implements IInstalacionDeportiva, IEdificio{
	
	// Atributos -----------------------
	private String Nombre;
	private double Superficie;
	private int tipoInstalacion;
	
	// Constructores -----------------------
	public Polideportivo() {
		Nombre = "Sin nombre";
		Superficie = 0;
	}
	
	public Polideportivo(String nombre, double superficie, int tipoInstalacion) {
		Nombre = nombre;
		Superficie = superficie;
		this.tipoInstalacion = tipoInstalacion;
	}
	
	// Gets -----------------------
	public String getNombre() {
		return Nombre;
	}		
	public double getSuperficie() {
		return Superficie;
	}
	
	@Override
	public int getTipoDeInstalacion() {
		return tipoInstalacion;
	}
	
	@Override
	public double getSuperficieEdificio() {
		return Superficie;
	}
	
	// To string -----------------------
	@Override
	public String toString() {
		return "Polideportivo " + Nombre + ", con superficie de" + Superficie + " mts2. Instalacion de tipo " + tipoInstalacion;
	}
	
}
