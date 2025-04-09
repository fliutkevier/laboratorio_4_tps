package ejercicio2;

public class ProductoRefrigerado extends Producto{
	
	// Atributos ---------------------
	private String codOrgSupervisor;
	
	// Constructores -----------------
	public ProductoRefrigerado() {
		super();
		this.codOrgSupervisor = "Sin especificar";
	}
	
	public ProductoRefrigerado(String fecha, int lote, String codOrgSupervisor) {
		super(fecha,lote);
		this.codOrgSupervisor = codOrgSupervisor;
	}
	
	// Getters y setters -------------
	
	public String getCodOrgSupervisor() {
		return codOrgSupervisor;
	}

	public void setCodOrgSupervisor(String codOrgSupervisor) {
		this.codOrgSupervisor = codOrgSupervisor;
	}
	
	public String toString() {
		return "Producto refrigerado, código del organismo de supervisión alimentaria: " + codOrgSupervisor + ". " + super.toString();
	}

	

}
