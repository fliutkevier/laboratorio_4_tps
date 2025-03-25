package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		Empleado empleado1 = new Empleado("Sara", 27);
		Empleado empleado2 = new Empleado();
		
		System.out.println(empleado1.toString());
		
		System.out.println( Empleado.devuelveProximoID() + ".");
		
	}

}
