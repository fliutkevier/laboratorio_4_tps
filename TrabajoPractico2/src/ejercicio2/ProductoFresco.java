package ejercicio2;

public class ProductoFresco extends Producto{
	private String Fecha_Envasado;
	private String Pais_Origen;

	public ProductoFresco(String Fecha, int Nro_lote, String Fecha_Envasado, String Pais_Origen) {
		super(Fecha, Nro_lote);
		this.Pais_Origen = Pais_Origen;
		this.Fecha_Envasado = Fecha_Envasado;
	}

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
		return "Producto Fresco Fecha de envasado:" + Fecha_Envasado + ", su pais de origen es" + Pais_Origen + ". "
				+ super.toString();
	}	
}
