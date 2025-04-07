package ejercicio2;

public class Producto {

	// Atributos ------------------
	private String Fecha_Caducidad;
	private int Nro_Lote;

	// Constructores ------------------
	public Producto() {
		this.Fecha_Caducidad = "0-0-0";
		this.Nro_Lote = 00000;
	}
	
	public Producto(String Fecha, int Nro_lote)
	{
		this.Fecha_Caducidad = Fecha;
		this.Nro_Lote = Nro_lote;
		
	}

	// Getters y setters ------------------
	public String getFecha_Caducidad() {
		return Fecha_Caducidad;
	}

	public void setFecha_Caducidad(String fecha_Caducidad) {
		Fecha_Caducidad = fecha_Caducidad;
	}

	public int getNro_Lote() {
		return Nro_Lote;
	}

	public void setNro_Lote(int nro_Lote) {
		Nro_Lote = nro_Lote;
	}

	@Override
	public String toString() {
		return "Posee un fecha de caducidad: " + Fecha_Caducidad + " y su numero de lote es"  + Nro_Lote;
	}
	
}
