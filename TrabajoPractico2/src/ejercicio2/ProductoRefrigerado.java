package ejercicio2;

public class ProductoRefrigerado extends Producto{
	
	// Atributos ---------------------
	private String codOrgSupervisor;
	
	// Constructores -----------------
	public ProductoRefrigerado() {
		super();
		this.codOrgSupervisor = "Sin especificar";
	}
	
	// Getters y setters -------------
	
	public String toString() {
		return "Producto refrigerado, código del organismo de supervisión alimentaria: " + codOrgSupervisor + ". " + super.toString();
	}

}
