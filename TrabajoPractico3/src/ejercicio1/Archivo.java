package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo {
	
	private String ruta = "Personas.txt";
	
	public List<String> lecturaPersonas() {
		
		List<String> lista = new ArrayList<>();
		return lista;
	}
	
	public boolean existe()
	{
	  File archivo = new File(ruta);
	  if(archivo.exists())
	       return true;
	  return false;
	}
}
