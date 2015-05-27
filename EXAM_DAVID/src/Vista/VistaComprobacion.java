package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controlador.ControladorPrincipal;

public class VistaComprobacion extends JPanel{
	
	private JTextField textId;
	private JTextField textApellido1;
	private JTextField textMensaje;
	
	public VistaComprobacion(){
		
		Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) dimPantalla.getWidth()/2, (int) (dimPantalla.getHeight()/1.5));
		setLayout(null);
		
		componentes();
		
		setVisible(true);
	}
	
	public void componentes(){

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(138, 135, 46, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setBounds(138, 160, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(423, 135, 100, 14);
		add(lblerApellido);
		
		textApellido1 = new JTextField();
		textApellido1.setBounds(423, 160, 86, 20);
		add(textApellido1);
		textApellido1.setColumns(10);
		
		JButton btnComprobar = new JButton("COMPROBAR");
		btnComprobar.setBounds(138, 216, 371, 23);
		btnComprobar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControladorPrincipal.getInstance().comprobar();
			}
		});
		add(btnComprobar);
		
		textMensaje = new JTextField();
		textMensaje.setBounds(138, 250, 371, 20);
		add(textMensaje);
		textMensaje.setColumns(10);
		
		JButton btnAtras = new JButton("<< Atr\u00E1s");
		btnAtras.setBounds(53, 427, 89, 23);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControladorPrincipal.getInstance().mostrarEquipo();
			}
		});
		add(btnAtras);
	}

	public JTextField getTextId() {
		return textId;
	}

	public JTextField getTextApellido1() {
		return textApellido1;
	}

	public JTextField getTextMensaje() {
		return textMensaje;
	}
}
