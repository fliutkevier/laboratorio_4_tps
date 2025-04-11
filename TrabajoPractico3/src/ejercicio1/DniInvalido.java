package ejercicio1;
import java.io.IOException;

public class DniInvalido extends IOException{
	
	public DniInvalido() {
		
	}

	public String getMessage() {
	
		return "El DNI contiene caracteres no numericos";
	}

}
