package TP4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaContactos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextFieldNombre;
	private JTextField TextFieldApellido;
	private JTextField TextFieldTelefono;
	private JTextField TextFieldFechaNacimiento;
	private JLabel lblMostrar;
	private JLabel lblDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaContactos frame = new VentanaContactos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean SoloNumeros(String texto) {
	    for (char c : texto.toCharArray()) {
	        if (!Character.isDigit(c)) {
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * Create the frame.
	 */
	public VentanaContactos() {
		setTitle("Contactos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 32, 46, 14);
		contentPane.add(lblNombre);
		
		TextFieldNombre = new JTextField();
		TextFieldNombre.setBounds(162, 29, 209, 20);
		contentPane.add(TextFieldNombre);
		TextFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(28, 65, 46, 14);
		contentPane.add(lblApellido);
		
		TextFieldApellido = new JTextField();
		TextFieldApellido.setBounds(162, 62, 209, 20);
		contentPane.add(TextFieldApellido);
		TextFieldApellido.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(28, 99, 50, 14);
		contentPane.add(lblTelefono);
		
		TextFieldTelefono = new JTextField();
		TextFieldTelefono.setBounds(162, 95, 209, 20);
		contentPane.add(TextFieldTelefono);
		TextFieldTelefono.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nac.");
		lblFechaNacimiento.setBounds(28, 129, 70, 14);
		contentPane.add(lblFechaNacimiento);
		
		TextFieldFechaNacimiento = new JTextField();
		TextFieldFechaNacimiento.setBounds(162, 127, 209, 20);
		contentPane.add(TextFieldFechaNacimiento);
		TextFieldFechaNacimiento.setColumns(10);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addMouseListener(new MouseAdapter()
		{			
			public void mouseClicked(MouseEvent e) {
				boolean campos_llenos= true;
				if(TextFieldNombre.getText().trim().isEmpty()) {
				TextFieldNombre.setBackground(Color.RED);
				campos_llenos = false;
				}else {
			        TextFieldNombre.setBackground(Color.WHITE);
			        }
				
				if(TextFieldApellido.getText().trim().isEmpty()) {
					TextFieldApellido.setBackground(Color.RED);
					campos_llenos = false;
					}else {
				        TextFieldApellido.setBackground(Color.WHITE);				        
				    }
				
				String txtTelefono = TextFieldTelefono.getText().trim();
				if(txtTelefono.isEmpty() || !SoloNumeros(txtTelefono)){
					TextFieldTelefono.setBackground(Color.RED);
					campos_llenos = false;
					}else {
				        TextFieldTelefono.setBackground(Color.WHITE);				        
				    }
				if(TextFieldFechaNacimiento.getText().trim().isEmpty())
				{
					TextFieldFechaNacimiento.setBackground(Color.RED);
					campos_llenos = false;
				}
				else {
					TextFieldFechaNacimiento.setBackground(Color.WHITE);					
				}
				if(campos_llenos)
				{
					lblDatos.setText("Los datos ingresados fueron: ");
					lblMostrar.setText( TextFieldNombre.getText() + " - " + TextFieldApellido.getText()
					+ " - " + TextFieldTelefono.getText() + " - " + TextFieldFechaNacimiento.getText());
				    TextFieldNombre.setText("");
				    TextFieldApellido.setText("");
				    TextFieldTelefono.setText("");
				    TextFieldFechaNacimiento.setText("");
				}
				
				
			}
		} );
		
		btnMostrar.setBounds(218, 216, 116, 34);
		contentPane.add(btnMostrar);
		
		lblMostrar = new JLabel("");
		lblMostrar.setBounds(28, 185, 343, 20);
		contentPane.add(lblMostrar);
		
		lblDatos = new JLabel("");
		lblDatos.setBounds(28, 154, 209, 31);
		contentPane.add(lblDatos);
	}
}
