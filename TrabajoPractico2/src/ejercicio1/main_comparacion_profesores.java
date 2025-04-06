package ejercicio1;

public class main_comparacion_profesores {

	public static void main(String[] args) {
		
		Profesor profe1 = new Profesor("Guillermo", 50, "Titular", 20);
		Profesor profe2 = new Profesor("Guillermo", 50, "Titular", 10);
		
		if(profe1.equals(profe2))	System.out.println("Es el mismo profesor");			
		
		else System.out.println("NO es el mismo profesor");
			
	}

}
