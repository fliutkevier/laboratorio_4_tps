package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {
	
	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		PersonaNegocio personaNegocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(ventanaPrincipal, personaNegocio);
		controlador.inicializar();
	}
	
}
