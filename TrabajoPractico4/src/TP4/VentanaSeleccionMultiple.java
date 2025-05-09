package TP4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSeleccionMultiple extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHoras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSeleccionMultiple frame = new VentanaSeleccionMultiple();
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
	public VentanaSeleccionMultiple() {
		setType(Type.POPUP);
		setTitle("Seleccion Multiple");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSO = new JPanel();
		panelSO.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelSO.setBounds(20, 28, 390, 45);
		contentPane.add(panelSO);
		panelSO.setLayout(null);
		
		JLabel lblSO = new JLabel("Elije un Sistema Operativo");
		lblSO.setBounds(10, 11, 158, 23);
		panelSO.add(lblSO);
		lblSO.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBounds(311, 11, 66, 23);
		panelSO.add(rdbtnLinux);
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBounds(255, 11, 54, 23);
		panelSO.add(rdbtnMac);
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setBounds(174, 11, 85, 23);
		panelSO.add(rdbtnWindows);
		
		ButtonGroup grupoSO = new ButtonGroup();
		grupoSO.add(rdbtnLinux);
		grupoSO.add(rdbtnMac);
		grupoSO.add(rdbtnWindows);
		
		JPanel panelEspecialdiad = new JPanel();
		panelEspecialdiad.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelEspecialdiad.setBounds(20, 84, 390, 98);
		contentPane.add(panelEspecialdiad);
		panelEspecialdiad.setLayout(null);
		
		JCheckBox chckbxAdministracion = new JCheckBox("Administración");
		chckbxAdministracion.setBounds(172, 33, 97, 23);
		panelEspecialdiad.add(chckbxAdministracion);
		
		JCheckBox chckbxProgramacion = new JCheckBox("Programación");
		chckbxProgramacion.setBounds(172, 7, 97, 23);
		panelEspecialdiad.add(chckbxProgramacion);
		
		JCheckBox chckbxDisenoGrafico = new JCheckBox("Diseño Gráfico");
		chckbxDisenoGrafico.setBounds(172, 59, 111, 23);
		panelEspecialdiad.add(chckbxDisenoGrafico);
		
		JLabel lblNewLabel = new JLabel("Elije una especialidad");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 37, 139, 19);
		panelEspecialdiad.add(lblNewLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sistemaOperativo = "Ninguno Seleccionado";
				String horas = txtHoras.getText();
				
				if(rdbtnLinux.isSelected())
				{
					sistemaOperativo = "Linux";
				}
				else if (rdbtnWindows.isSelected())
				{
					sistemaOperativo = "Windows";
				}
				else if(rdbtnMac.isSelected()){
					sistemaOperativo = "Mac";
				}
				
				JCheckBox[] cbxGrupo = {chckbxAdministracion, chckbxProgramacion, chckbxDisenoGrafico};
				var seleccionados = new StringBuilder();
				
				for (JCheckBox jCheckBox : cbxGrupo) {
					if(jCheckBox.isSelected())
					{
						seleccionados.append(jCheckBox.getText()).append(" - ");
					}
				}
				
				JOptionPane.showMessageDialog(null, sistemaOperativo + " - "+ seleccionados.toString() + horas + " Hs", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAceptar.setBounds(322, 245, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblHoras = new JLabel("Cantidad de horas en el computador:");
		lblHoras.setBounds(20, 206, 234, 14);
		contentPane.add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numero = key >= 48 && key <= 57;
				if(!numero) {
					e.consume();
				}
			}
		});
		txtHoras.setBounds(250, 203, 113, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
	}
}
