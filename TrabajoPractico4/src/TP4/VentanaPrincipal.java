package TP4;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNroGrupo = new JLabel("GRUPO NRO: 10");
		lblNroGrupo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNroGrupo.setBounds(32, 27, 200, 20); 
		contentPane.add(lblNroGrupo);
		
		JButton btnEj1 = new JButton("Ejercicio 1");
		btnEj1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				 VentanaContactos ventana = new VentanaContactos();
			     ventana.setVisible(true);
			}
		});
		btnEj1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEj1.setBounds(153, 72, 127, 23);
		contentPane.add(btnEj1);
		
		JButton btnEj2 = new JButton("Ejercicio 2");
		btnEj2.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				VentanaPromedio ventana = new VentanaPromedio();
			     ventana.setVisible(true);
			}
		});
		btnEj2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEj2.setBounds(153, 106, 127, 23);
		contentPane.add(btnEj2);
		
		JButton btnEj3 = new JButton("Ejercicio 3");
		btnEj3.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				VentanaSeleccionMultiple ventana = new VentanaSeleccionMultiple();
			     ventana.setVisible(true);
			}
		});
		btnEj3.setBounds(153, 140, 127, 23);
		contentPane.add(btnEj3);
	}
}
