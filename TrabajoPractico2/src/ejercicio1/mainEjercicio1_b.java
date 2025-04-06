package ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class mainEjercicio1_b {

	public static void main(String[] args) {
		
		TreeSet<Profesor> listProf = new TreeSet<Profesor>();
		listProf.add(new Profesor());
		listProf.add(new Profesor());
		listProf.add(new Profesor());
		listProf.add(new Profesor());
		listProf.add(new Profesor());
		
		Iterator<Profesor>it = listProf.iterator();
		while (it.hasNext()) {
			Profesor prof = (Profesor) it.next();
			System.out.println(prof.toString());
		}
		
		
	}
	

}
