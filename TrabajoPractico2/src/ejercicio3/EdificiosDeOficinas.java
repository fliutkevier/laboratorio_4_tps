package ejercicio3;

public class EdificiosDeOficinas implements IEdificio {

	// Atributos -----------------------	
	private int NumeroOficinas;
	private double Superficie;
	
	// Constructores -----------------------
	public EdificiosDeOficinas()
	{
		NumeroOficinas = 0;
		Superficie = 0;
	}
	
	public EdificiosDeOficinas(int numeroOficinas, double superficie)
	{
		this.NumeroOficinas = numeroOficinas;
		this.Superficie = superficie;
	}

	// Gets n setters -----------------------
	public int getNumeroOficinas() {
		return NumeroOficinas;
	}

	public void setNumeroOficinas(int numeroOficinas) {
		NumeroOficinas = numeroOficinas;
	}
	
	public double getSuperficieEdificio()
	{
		return Superficie;
	}

	// To string -----------------------

}
