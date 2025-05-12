package TP5;

public class Peliculas{
	
	// Atributos -------------------------
	private int id;
	private String nombre;
	private Generos genero;
	static int contid = 1;

	// Constructor -----------------------
	public Peliculas(String nombre, Generos genero) {
		this.id = contid;
		this.nombre = nombre;
		this.setGenero(genero);
		contid++;
	}

	// Gets n setters --------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static int getContid() {
		return contid;
	}

	public static void setContid(int contid) {
		Peliculas.contid = contid;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Nombre: " + nombre + ", Genero: " + genero.getNombreGenero();
	}

	
	

}
