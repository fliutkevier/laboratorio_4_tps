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
		
		Archivo archivoResultado = new Archivo("Resultado.txt");
		
		for (Persona persona : personas) {
			archivoResultado.escribe(persona.toString() ,"Resultado.txt");
			System.out.println(persona.toString());
		}
		System.out.println("Resultado creado exitosamente");
	}
}
