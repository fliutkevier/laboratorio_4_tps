package ejercicio3;

import java.util.ArrayList;

public class MainEjercicio3 {
	public static void main(String[] args) {
		
		ArrayList<Object> edificios = new ArrayList<>();
		edificios.add(new Polideportivo("UVVA", 4500, 5));
		edificios.add(new Polideportivo("Los Magios", 5100, 3));
		edificios.add(new Polideportivo("Hellfish", 3950, 2));
		edificios.add(new EdificiosDeOficinas(100, 3800));
		edificios.add(new EdificiosDeOficinas(270, 4200));
	}
}
