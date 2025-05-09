package TP4;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Dimension2D;
import java.security.PrivateKey;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class VentanaPromedio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextFieldNotaUno;
	private JTextField TextFieldNotaDos;
	private JTextField TextFieldNotaTres;
	private JTextField TextFieldPromedio;
	private JTextField TextFieldCondicion;
	private JLabel lblAdvertencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPromedio frame = new VentanaPromedio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean numeroCorrecto(double numero) {
	    if( numero >= 1 && numero <= 10) {
	    	return true;
	    }
	    return false;
	}
	
	private boolean NotasEntre6y8(double... notas)
	{
		for (double n : notas) {
			if (n < 6 || n > 8)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Create the frame.
	 */
	public VentanaPromedio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNotas = new JPanel();
		panelNotas.setBounds(21, 11, 289, 170);
		contentPane.add(panelNotas);
		panelNotas.setLayout(null);
		
		panelNotas.setBorder(javax.swing.BorderFactory.createTitledBorder(
			    javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)), 
			    "Notas del estudiante"
			));
		
		JComboBox<String> comboBoxTps = new JComboBox<String>();
		comboBoxTps.addItem("Aprobado");
		comboBoxTps.addItem("Desaprobado");
		comboBoxTps.setBounds(98, 130, 156, 22);
		panelNotas.add(comboBoxTps);
		
		JLabel lblTPS = new JLabel("TPS");
		lblTPS.setBounds(42, 130, 46, 14);
		panelNotas.add(lblTPS);
		
		JLabel lblNotaUno = new JLabel("Nota 1:");
		lblNotaUno.setBounds(42, 30, 46, 14);
		panelNotas.add(lblNotaUno);
		
		TextFieldNotaUno = new JTextField();
		TextFieldNotaUno.setBounds(98, 30, 156, 22);
		TextFieldNotaUno.setColumns(10);
		panelNotas.add(TextFieldNotaUno);
		
		JLabel lblNotaDos = new JLabel("Nota 2:");
		lblNotaDos.setBounds(42, 63, 46, 14);
		panelNotas.add(lblNotaDos);
		
		TextFieldNotaDos = new JTextField();
		TextFieldNotaDos.setBounds(98, 60, 156, 22);
		TextFieldNotaDos.setColumns(2);
		panelNotas.add(TextFieldNotaDos);
		
		JLabel lblNotaTres = new JLabel("Nota 3:");
		lblNotaTres.setBounds(42, 96, 46, 14);
		panelNotas.add(lblNotaTres);
		
		TextFieldNotaTres = new JTextField();
		TextFieldNotaTres.setBounds(98, 93, 156, 22);
		TextFieldNotaTres.setColumns(2);
		panelNotas.add(TextFieldNotaTres);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addMouseListener(new MouseAdapter() {	
			
			public void mouseClicked(MouseEvent e) {
				
				TextFieldNotaUno.setText("");
				TextFieldNotaDos.setText("");
				TextFieldNotaTres.setText("");
				TextFieldPromedio.setText("");
				TextFieldCondicion.setText("");
				lblAdvertencia.setVisible(false);

			}
		});
		btnNuevo.setBounds(325, 82, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnCALCULAR = new JButton("CALCULAR");
		btnCALCULAR.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				double N1= Double.parseDouble(TextFieldNotaUno.getText());
				double N2= Double.parseDouble(TextFieldNotaDos.getText());
				double N3= Double.parseDouble(TextFieldNotaTres.getText());
				
				if (numeroCorrecto(N1) && numeroCorrecto(N2) && numeroCorrecto(N3)) {
					double Promedio = (N1 + N2 + N3)/3;
					TextFieldPromedio.setText(String.format("%.2f", Promedio));
					lblAdvertencia.setVisible(false);
					String condicionTP = (String)comboBoxTps.getSelectedItem();
					if(condicionTP.equals("Desaprobado") || (N1 < 6 || N2 < 6 || N3 < 6))
					{
						TextFieldCondicion.setText("Libre");
					}
					else if(NotasEntre6y8(N1,N2,N3) && condicionTP.equals("Aprobado"))
					{
						TextFieldCondicion.setText("Regular");
					}
					else if(condicionTP.equals("Aprobado") && (N1 >= 8 || N2 >= 8 || N3 >= 8))
					{
						TextFieldCondicion.setText("Promoción");
					}
				}
				else {lblAdvertencia.setVisible(true);};
				
			}
		});
		
		btnCALCULAR.setBounds(325, 48, 89, 23);
		contentPane.add(btnCALCULAR);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(325, 116, 89, 23);
		contentPane.add(btnSalir);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(153, 204, 255)), "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0 , 0)));
		panel2.setBounds(21, 211, 289, 141);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		TextFieldPromedio = new JTextField();
		TextFieldPromedio.setBounds(101, 47, 151, 20);
		panel2.add(TextFieldPromedio);
		TextFieldPromedio.setColumns(2);
		
		TextFieldCondicion = new JTextField();
		TextFieldCondicion.setBounds(101, 78, 151, 20);
		panel2.add(TextFieldCondicion);
		TextFieldCondicion.setColumns(10);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setBounds(33, 49, 64, 17);
		panel2.add(lblPromedio);
		
		JLabel lblCondicion = new JLabel("Condicion:");
		lblCondicion.setBounds(33, 81, 64, 14);
		panel2.add(lblCondicion);
		
		lblAdvertencia = new JLabel("Las notas ingresadas deben estar entre 1 y 10");
		lblAdvertencia.setForeground(Color.RED);
		lblAdvertencia.setBounds(31, 177, 289, 23);
		lblAdvertencia.setVisible(false);
		contentPane.add(lblAdvertencia);
	}
}
