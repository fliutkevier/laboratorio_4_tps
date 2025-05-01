package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Archivo {
	
	private String ruta;
	
	public Archivo(String rutaSolicitada)
	{
		ruta = rutaSolicitada;
	}
	
	public Set<String> lecturaPersonas() {
		
		Set<String> lista = new TreeSet<>();
		return lista;
	}
	
	public boolean existe()
	{
	  File archivo = new File(ruta);
	  if(archivo.exists())
	       return true;
	  return false;
	}
	
	public ArrayList<String> leer()
	{
		FileReader input;
		String linea = "";
		ArrayList<String> lineas = new ArrayList<String>();
		try {
			input = new FileReader(ruta);
			BufferedReader buffer = new BufferedReader(input);
			
			while (linea != null)
			{
				lineas.add(linea);
				linea = buffer.readLine();
			}
			
			input.close();
			
			
		} catch (IOException e) {
			System.out.println("No existe el archivo.");
		}
		
		return lineas;
	}

	public void escribe(String persona, String ruta) {
		try
		{
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(persona + "\n");
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public void leer_archivo(List<Persona> lista) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(ruta));
			String linea = "";
			while((linea = lector.readLine()) != null) {
				String[] partes = linea.split("-");
				if(partes.length == 3) {
					String nombre = partes[0];
					String apellido = partes[1];
					String dni = partes[2];
					lista.add(new Persona(nombre, apellido, dni));
				}
			}
			lector.close();
		}
		catch(IOException e) {
			System.out.println("Error al leer archivo");
		}
	}*/
}

