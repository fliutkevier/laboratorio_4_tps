package presentacion.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.JTextField;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;

public class PanelModificarPersona extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	DefaultListModel<Persona> dlmPersonas;
	private JList<Persona> jList;
	
	JButton btnModificar;
	
	public PanelModificarPersona() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 116, 135, 134, 77, 0};
		gridBagLayout.rowHeights = new int[]{16, 15, 214, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Seleccione la persona que desea modificar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jList = new JList<Persona>();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridwidth = 4;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		add(jList, gbc_list);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 0, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.insets = new Insets(0, 0, 0, 5);
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 3;
		add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNI.insets = new Insets(0, 0, 0, 5);
		gbc_txtDNI.gridx = 3;
		gbc_txtDNI.gridy = 3;
		txtDNI.setEditable(false);
		add(txtDNI, gbc_txtDNI);
		txtDNI.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.gridx = 4;
		gbc_btnModificar.gridy = 3;
		add(btnModificar, gbc_btnModificar);
		
		
		jList.addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        Persona personaSeleccionada = jList.getSelectedValue();
		        
		        if (personaSeleccionada != null) {
		            txtNombre.setText(personaSeleccionada.getNombre());
		            txtApellido.setText(personaSeleccionada.getApellido());
		            txtDNI.setText(personaSeleccionada.getDNI());
		        }
		    }
		});
			
	
	}
	
	public void setDefaultListModel(DefaultListModel<Persona> dlm)
	{
		this.dlmPersonas = dlm;
		this.jList.setModel(this.dlmPersonas);
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public JTextField getTxtApellido() {
		return txtApellido;
	}
	public JTextField getTxtDNI() {
		return txtDNI;
	}
	public JList<Persona> getjList() {
		return jList;
	}
	
	
	
}
