package ejercicio2;

public class ProductoCongelado extends Producto{
	
	private String TempCongelacionReco;
	
	public ProductoCongelado() {
		super();
		this.TempCongelacionReco = "0";
	}
	
	public ProductoCongelado(String fecha, int lote, String tempCR) {
		super(fecha,lote);
		this.TempCongelacionReco = tempCR;
	}

}
