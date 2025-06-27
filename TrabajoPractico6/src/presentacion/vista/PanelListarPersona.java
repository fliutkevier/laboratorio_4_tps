package presentacion.vista;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelListarPersona extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTable tabla;
	private DefaultTableModel dtm;

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
		this.tabla.setModel(dtm);
	}

	public PanelListarPersona()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 116, 135, 134, 77, 0};
		gridBagLayout.rowHeights = new int[]{16, 15, 214, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		dtm = new DefaultTableModel();
		tabla = new JTable(dtm);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 2;
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(tabla, gbc_table);
	}
	
	
}
