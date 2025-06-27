package negocio;

import java.util.ArrayList;

import entidad.Persona;

public interface PersonaNegocio {
	public boolean Agregar(Persona persona);
	public boolean Modificar(Persona persona);
    public boolean Eliminar(String dni);
	public ArrayList<Persona> Listar();
}
