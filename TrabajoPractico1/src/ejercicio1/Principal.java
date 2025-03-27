package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		
		Empleado[] empleados = new Empleado[5];
		
		empleados[0] = new Empleado("Sara", 27);
		empleados[1] = new Empleado("Guillermo", 60);
		empleados[2] = new Empleado("Sergio", 30);
		empleados[3] = new Empleado();
		empleados[4] = new Empleado();
		
		for (Empleado item : empleados) {
			System.out.println(item.toString());
		}
		//System.out.println(empleado1.toString());
		
		System.out.println( "El próximo ID será el " + Empleado.devuelveProximoID() + ".");
		
	}

}
