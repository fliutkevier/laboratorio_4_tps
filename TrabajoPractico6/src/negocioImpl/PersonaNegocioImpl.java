package negocioImpl;

import java.util.ArrayList;
import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	ArrayList<Persona> personasAlmacenadas;
	
	@Override
	public boolean Agregar(Persona persona) {
		personasAlmacenadas = Listar();
		if(EsValido(persona))
		{
			if (!personasAlmacenadas.contains(persona))
				return pdao.Agregar(persona);
		}
		return false;
	}

	@Override
	public boolean Modificar(Persona persona) {
		if(EsValido(persona))
		{
			return pdao.Modificar(persona);
		}
		return false;
	}

	@Override
	public boolean Eliminar(String dni) {
		return pdao.Eliminar(dni);
	}

	@Override
	public ArrayList<Persona> Listar() {
		return pdao.Listar();
	}
	
	public boolean EsValido(Persona persona)
	{
		if(SoloTexto(persona.getNombre()) && SoloTexto(persona.getApellido()) && persona.getDNI().trim().length()>0)
		{
			return true;
		}
		return false;
	}
	
	private boolean SoloTexto(String texto) {
	    if (texto == null || texto.trim().isEmpty())
	        return false;

	    for (char caracter : texto.toCharArray()) {
	        if (!Character.isLetter(caracter) && caracter != ' ')
	            return false;
	    }

	    return true;
	}

}
