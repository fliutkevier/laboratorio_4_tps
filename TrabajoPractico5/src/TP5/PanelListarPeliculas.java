package TP5;

import javax.swing.JPanel;
import java.awt.Font;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;

public class PanelListarPeliculas extends JPanel{
	
	private JList lista;
	private DefaultListModel<Peliculas> listaModel;	
	
	public PanelListarPeliculas() {		
		
		setLayout(null);
		lista = new JList();
		lista.setFont(new Font("Tahoma", Font.PLAIN, 14));
							
		lista.setBounds(81, 43, 350, 222);
		add(lista);
		
		JLabel lblNewLabel = new JLabel("Peliculas");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 114, 61, 14);
		add(lblNewLabel);
	}
	public void setDefaultListModel(DefaultListModel<Peliculas> listModel2)
	{
		this.listaModel = listModel2;
		lista.setModel(this.listaModel);
	}
	public void ordenarAlfabeticamente() {
		
        if (listaModel != null && listaModel.size() > 0) {            
            List<Peliculas> elementos = Collections.list(listaModel.elements());
            
            
            Collections.sort(elementos, new Comparator<Peliculas>() {
                @Override
                public int compare(Peliculas p1, Peliculas p2) {
                    return p1.getNombre().compareToIgnoreCase(p2.getNombre());
                }
            });
            
            
            listaModel.clear();
            for (Peliculas pelicula : elementos) {
                listaModel.addElement(pelicula);
            }
        }
    }
}
