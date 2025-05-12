package TP5;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.awt.event.ActionEvent;

public class PanelAgregarPelicula extends JPanel {
	private DefaultListModel<Peliculas> dlmPeliculas;
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	
	public void setDlm(DefaultListModel<Peliculas> dlmPeliculas)
	{
		this.dlmPeliculas = dlmPeliculas;
	}
	
	public PanelAgregarPelicula() {
		JComboBox<String> cboGenero;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 3;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		JLabel lbl_id = new JLabel(Integer.toString(Peliculas.getContid()));
		GridBagConstraints gbc_lbl_id = new GridBagConstraints();
		gbc_lbl_id.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_id.gridx = 5;
		gbc_lbl_id.gridy = 1;
		add(lbl_id, gbc_lbl_id);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 5;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Genero");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 5;
		add(lblNewLabel, gbc_lblNewLabel);
		
		cboGenero = new JComboBox<String>();
		cboGenero.setToolTipText("");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 5;
		add(cboGenero, gbc_comboBox);
		cboGenero.addItem("Seleccione un género");
		cboGenero.addItem(new Generos("Terror").getNombreGenero());
		cboGenero.addItem(new Generos("Acción").getNombreGenero());
		cboGenero.addItem(new Generos("Suspenso").getNombreGenero());
		cboGenero.addItem(new Generos("Romantica").getNombreGenero());
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtNombre.getText().isEmpty() && !cboGenero.getSelectedItem().equals("Seleccione un género")) {
					String nombre = txtNombre.getText();
					String generoSeleccionado = (String) cboGenero.getSelectedItem();
					Peliculas p = new Peliculas(nombre, new Generos(generoSeleccionado));
					txtNombre.setText("");
					cboGenero.setSelectedIndex(0);
					dlmPeliculas.addElement(p);
					lbl_id.setText(String.valueOf(Peliculas.getContid()));
				} else { JOptionPane.showMessageDialog(null,"Se debe escribir un nombre y seleccionar un género", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
				
				}
			}
		});
		
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 3;
		gbc_btnAceptar.gridy = 7;
		add(btnAceptar, gbc_btnAceptar);
	}
	
}
