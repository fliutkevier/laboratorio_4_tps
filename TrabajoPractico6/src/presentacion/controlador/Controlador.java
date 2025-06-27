package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersona;
import presentacion.vista.PanelEliminarPersona;
import presentacion.vista.PanelListarPersona;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.VentanaPrincipal;


public class Controlador implements ActionListener {
	
	private VentanaPrincipal ventanaMain;
	private PanelAgregarPersona panelAgregarPersona;
	private PanelModificarPersona panelModificarPersona;
	private PanelEliminarPersona panelEliminarPersona;
	private PanelListarPersona panelListarPersona;
	private PersonaNegocio pNeg;
	
	public Controlador (VentanaPrincipal ventanaPrincipal, PersonaNegocio pNeg)
	{
		ventanaMain = ventanaPrincipal;
		this.pNeg = pNeg;
		this.panelAgregarPersona = new PanelAgregarPersona();
		this.panelModificarPersona = new PanelModificarPersona();
		this.panelEliminarPersona = new PanelEliminarPersona();
		this.panelListarPersona = new PanelListarPersona();
		
		
		//Eventos de Principal
		this.ventanaMain.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaMain.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaMain.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaMain.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));

		
		//Eventos de AgregarPersona
		this.panelAgregarPersona.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		
		//Eventos de ModificarPersona
		this.panelModificarPersona.getBtnModificar().addActionListener(a->EventoClickBoton_ModificarPersona_panelModificarPersona(a));
		
		//Eventos de EliminarPersona
		this.panelEliminarPersona.getBtnEliminar().addActionListener(a->EventoClickBoton_EliminarPersona_panelEliminarPersona(a));
		
		//Eventos de Listar
	}
	
	private void setLista()
	{
		ArrayList<Persona> personas = pNeg.Listar();
		DefaultListModel<Persona> dlm = new DefaultListModel<Persona>();

		for (Persona p : personas) {
		    dlm.addElement(p);
		}
		
		panelModificarPersona.setDefaultListModel(dlm);
		panelEliminarPersona.setDefaultListModel(dlm);
	}
	
	private void setTabla()
	{
		ArrayList<Persona> personas = pNeg.Listar();
		DefaultTableModel dtm = new DefaultTableModel();

		dtm.addColumn("DNI");
		dtm.addColumn("Nombre");
		dtm.addColumn("Apellido");
		
		for (Persona p : personas) {
			dtm.addRow(new Object[]{p.getDNI(), p.getNombre(), p.getApellido()});
		}
		
		panelListarPersona.setDtm(dtm);
	}
	
	private void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a) {
		ventanaMain.getContentPane().removeAll();
		ventanaMain.getContentPane().add(panelEliminarPersona);
		ventanaMain.getContentPane().repaint();
		ventanaMain.getContentPane().revalidate();
		setLista();
	}

	private void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{
		ventanaMain.getContentPane().removeAll();
		ventanaMain.getContentPane().add(panelAgregarPersona);
		ventanaMain.getContentPane().repaint();
		ventanaMain.getContentPane().revalidate();
	}
	
	private void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{
		ventanaMain.getContentPane().removeAll();
		ventanaMain.getContentPane().add(panelModificarPersona);
		ventanaMain.getContentPane().repaint();
		ventanaMain.getContentPane().revalidate();
		setLista();
	}
	
	private void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a)
	{
		ventanaMain.getContentPane().removeAll();
		ventanaMain.getContentPane().add(panelListarPersona);
		ventanaMain.getContentPane().repaint();
		ventanaMain.getContentPane().revalidate();
		setTabla();
	}
	
	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		
		String nombre = this.panelAgregarPersona.getTxtNombre().getText();
		String apellido = this.panelAgregarPersona.getTxtApellido().getText();
		String dni = this.panelAgregarPersona.getTxtDNI().getText();
		Persona nuevaPersona = new Persona(dni, nombre, apellido);
		
		boolean estado = pNeg.Agregar(nuevaPersona);
		String mensaje;
		if(estado==true)
		{
			mensaje="Persona agregada con exito";
			this.panelAgregarPersona.getTxtNombre().setText("");
			this.panelAgregarPersona.getTxtApellido().setText("");
			this.panelAgregarPersona.getTxtDNI().setText("");
		}
		else {
			mensaje="Persona no agregada, campos no validos.";
		}
		JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
	
	}
	
	private void EventoClickBoton_ModificarPersona_panelModificarPersona(ActionEvent a)
	{
		String nombre = this.panelModificarPersona.getTxtNombre().getText();
		String apellido = this.panelModificarPersona.getTxtApellido().getText();
		String dni = this.panelModificarPersona.getTxtDNI().getText();
		Persona Pmodificada = new Persona(dni, nombre, apellido);
		
		boolean estado = pNeg.Modificar(Pmodificada);
		String mensaje;
		if(estado==true)
		{
			mensaje="Persona modificada con exito!";
			this.panelModificarPersona.getTxtNombre().setText("");
			this.panelModificarPersona.getTxtApellido().setText("");
			this.panelModificarPersona.getTxtDNI().setText("");
			DefaultListModel<Persona> modelo = (DefaultListModel<Persona>) panelModificarPersona.getjList().getModel();
	        int indiceSeleccionado = panelModificarPersona.getjList().getSelectedIndex();
	        
	        if(indiceSeleccionado != -1) {
	            modelo.set(indiceSeleccionado, Pmodificada);
	        }
            
		}
		else {
			mensaje="No se pudo realizar la accion.";
		}
		JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void EventoClickBoton_EliminarPersona_panelEliminarPersona(ActionEvent a)
	{
		Persona personaSeleccionada = this.panelEliminarPersona.getJList().getSelectedValue();
		boolean eliminado = false;
		
		if(personaSeleccionada != null)
		{
			String dni = personaSeleccionada.getDNI();
			
			eliminado = pNeg.Eliminar(dni);
		}
		
		if(eliminado)
		{
			JOptionPane.showMessageDialog(null, "Persona eliminada correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
			setLista();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No se pudo eliminar.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void inicializar()
	{
		this.ventanaMain.setVisible(true);
	}
}
