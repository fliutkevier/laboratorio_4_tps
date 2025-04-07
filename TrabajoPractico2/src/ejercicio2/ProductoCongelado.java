package ejercicio2;

public class ProductoCongelado extends Producto{
	
	// Atributos ------------------
	private String TempCongelacionReco;
	
	// Constructores  ------------------
	public ProductoCongelado() {
		super();
		this.TempCongelacionReco = "0";
	}
	
	public ProductoCongelado(String fecha, int lote, String tempCR) {
		super(fecha,lote);
		this.TempCongelacionReco = tempCR;
	}

	// Getters y setters ------------------
	public String getTempCongelacionReco() {
		return TempCongelacionReco;
	}

	public void setTempCongelacionReco(String tempCongelacionReco) {
		TempCongelacionReco = tempCongelacionReco;
	}
}
