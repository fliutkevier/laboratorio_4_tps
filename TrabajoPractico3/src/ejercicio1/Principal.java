package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {	

		Archivo archivo = new Archivo("Personas.txt");
		
		Set<Persona> personas = new TreeSet<>();
		
		if (archivo.existe()) {
			
			for (String linea : archivo.leer()) {
				if(linea.trim().isEmpty())
				{
					continue;
				}
				try {
					Persona persona = Persona.convertirPersona(linea);
					personas.add(persona);
				} catch (Exception e)
				{
					//no lo agrega a la lista.
				}
			}
		}
		
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}
	}
}
