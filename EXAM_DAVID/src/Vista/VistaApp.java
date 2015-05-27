package Vista;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VistaApp extends JFrame{
	
	private VistaPerfil vp;
	private VistaEquipo ve;
	private VistaComprobacion vc;
	
	public VistaApp(){
		
		vp = new VistaPerfil();
		ve = new VistaEquipo();
		vc = new VistaComprobacion();
		setLayout(new CardLayout(0, 0));
		getContentPane().add(vp, "VistaPerfil");
		getContentPane().add(ve, "VistaEquipo");
		getContentPane().add(vc, "VistaComprobacion");
		
		setTitle("THE LABY");
		Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) dimPantalla.getWidth()/2, (int) (dimPantalla.getHeight()/1.5));
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

	public VistaPerfil getVistaPerfil() {
		return vp;
	}

	public VistaEquipo getVistaEquipo() {
		return ve;
	}

	public VistaComprobacion getVistaComprobacion() {
		return vc;
	}
}
