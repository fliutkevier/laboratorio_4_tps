package ejercicio2;

public class ProductoFresco extends Producto{
	
	// Atributos ------------------
	private String Fecha_Envasado;
	private String Pais_Origen;
	
	// Constructores ------------------
	public ProductoFresco(String Fecha, int Nro_lote, String Fecha_Envasado, String Pais_Origen) {
		super(Fecha, Nro_lote);
		this.Pais_Origen = Pais_Origen;
		this.Fecha_Envasado = Fecha_Envasado;
	}
	
	// Getters y setters ------------------
	public String getFecha_Envasado() {
		return Fecha_Envasado;
	}

	public void setFecha_Envasado(String fecha_Envasado) {
		Fecha_Envasado = fecha_Envasado;
	}

	public String getPais_Origen() {
		return Pais_Origen;
	}

	public void setPais_Origen(String pais_Origen) {
		Pais_Origen = pais_Origen;
	}

	@Override
	public String toString() {
		return "Producto Fresco, Fecha de envasado:" + Fecha_Envasado + ", pais de origen: " + Pais_Origen + ". "
				+ super.toString();
	}	
}
