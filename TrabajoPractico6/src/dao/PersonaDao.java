package dao;
import java.util.ArrayList;

import entidad.Persona;

public interface PersonaDao {
	public boolean Agregar(Persona persona);
	public boolean Modificar(Persona persona);
	public boolean Eliminar(int dni);
	public ArrayList<Persona> Listar();
}
