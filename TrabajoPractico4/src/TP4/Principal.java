package TP4;

public class Principal {

	public static void main(String[] args) {
		 javax.swing.SwingUtilities.invokeLater(() -> {
	            VentanaPrincipal ventana = new VentanaPrincipal();
	            ventana.setVisible(true);
		 });

	}

}
