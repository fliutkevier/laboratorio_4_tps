package ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class mainEjercicio1_b {

	public static void main(String[] args) {
		
		TreeSet<Profesor> listProf = new TreeSet<Profesor>();
		listProf.add(new Profesor("Lucas", 45, "Secundario", 18));
		listProf.add(new Profesor("Sabrina", 43, "Primario", 19));
		listProf.add(new Profesor("Lara", 35, "Primario", 10));
		listProf.add(new Profesor("Fabricio", 27, "Secundario", 3));
		listProf.add(new Profesor("Carla", 39, "Secundario", 13));
		
		Iterator<Profesor>it = listProf.iterator();
		while (it.hasNext()) {
			Profesor prof = (Profesor) it.next();
			System.out.println(prof.toString());
		}
		
		
	}
	

}
