package ejercicio1;
import java.util.ArrayList;
import java.util.ListIterator;
public class mainEjercicio1_a {
	
	public static void main(String[] args) {
		ArrayList<Profesor> ListProf = new ArrayList<Profesor>(5);
		ListProf.add(new Profesor("Marcos", 42, "Secundario", 15));
		ListProf.add(new Profesor("Silvina", 30, "Primario", 6));
		ListProf.add(new Profesor("Florencia", 35, "Secundario", 12));
		ListProf.add(new Profesor("Nicolas", 33, "Primario", 10));
		ListProf.add(new Profesor("Emilse", 38, "Secundario", 13));
		
		System.out.println("Listado de profesores \n");
		ListIterator<Profesor> it = ListProf.listIterator();
		while(it.hasNext())
		{
			Profesor p = (Profesor) it.next();
			System.out.println(p.toString());
		}
		
	}

}
