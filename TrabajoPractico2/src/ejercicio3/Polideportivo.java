package ejercicio3;

public class Polideportivo implements IInstalacionDeportiva, IEdificio{
	
	private String Nombre;
	private double Superficie;
	private int tipoInstalacion;
	
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
	
	@Override
	public int getTipoDeInstalacion() {
		return tipoInstalacion;
	}
		
}
