package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEliminarPersona extends JPanel{
	
	private DefaultListModel<Persona> dlmPersonas;
	private JList<Persona> list;
	JButton btnEliminar;
	
	public PanelEliminarPersona() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 116, 135, 134, 77, 0};
		gridBagLayout.rowHeights = new int[]{16, 15, 214, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblEliminar = new JLabel("Eliminar usuarios");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblEliminar = new GridBagConstraints();
		gbc_lblEliminar.gridwidth = 3;
		gbc_lblEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_lblEliminar.gridx = 1;
		gbc_lblEliminar.gridy = 1;
		add(lblEliminar, gbc_lblEliminar);
		
		list = new JList<Persona>();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 4;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		add(list, gbc_list);
		
		btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.gridwidth = 3;
		gbc_btnEliminar.anchor = GridBagConstraints.NORTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 3;
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnEliminar, gbc_btnEliminar);
	}
	private static final long serialVersionUID = 1L;
	
	public JList<Persona> getJList()
	{
		return this.list;
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	public void setDefaultListModel(DefaultListModel<Persona> dlm)
	{
		this.dlmPersonas = dlm;
		this.list.setModel(this.dlmPersonas);
	}

}
