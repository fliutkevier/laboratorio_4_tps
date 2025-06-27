package TP5;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelAgregarPelicula panelAgregarPelicula;
	private PanelListarPeliculas panelListarPelicula;
	
	private static DefaultListModel<Peliculas> dlmPeliculas;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					dlmPeliculas = new DefaultListModel<Peliculas>();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPeliculas = new JMenu("Peliculas");
		menuBar.add(mnPeliculas);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mnPeliculas.add(mntmAgregar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnPeliculas.add(mntmListar);
		
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				panelAgregarPelicula = new PanelAgregarPelicula();
				panelAgregarPelicula.setDlm(dlmPeliculas);
				panelAgregarPelicula.setBounds(10, 10, 400, 200); 
				panelAgregarPelicula.setVisible(true); 
				contentPane.add(panelAgregarPelicula);
				contentPane.repaint();
				contentPane.revalidate();
			}
			
		});
		
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				panelListarPelicula = new PanelListarPeliculas();
				panelListarPelicula.setDefaultListModel(dlmPeliculas);
				panelListarPelicula.ordenarAlfabeticamente();
				panelListarPelicula.setBounds(10, 10, 400, 200); 
				panelListarPelicula.setVisible(true); 
				contentPane.add(panelListarPelicula);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
			
		});
	}
	
}
