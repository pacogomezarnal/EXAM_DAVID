package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controlador.ControladorPrincipal;

public class VistaPerfil extends JPanel{
	private JTextField textNombre;
	private JTextField textId;
	private JTextField textApellidos;
	private JTextField textEdad;
	private JTextField textNacionalidad;
	
	public VistaPerfil() {
		
		Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) dimPantalla.getWidth()/2, (int) (dimPantalla.getHeight()/1.5));
		setLayout(null);
		
		componentes();
		
		setVisible(true);
	}
	
	public void componentes(){
		
		JLabel logo = new JLabel(new ImageIcon((this.getClass().getResource("/images/user-default.jpg"))));
		logo.setBounds(56, 40, logo.getIcon().getIconWidth(), logo.getIcon().getIconHeight());
		add(logo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(344, 40, 46, 14);
		add(lblNombre);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(490, 40, 46, 14);
		add(lblId);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(344, 64, 86, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(490, 65, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(344, 95, 67, 14);
		add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setBounds(344, 120, 86, 20);
		add(textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(344, 151, 46, 14);
		add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setEditable(false);
		textEdad.setBounds(344, 176, 86, 20);
		add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(344, 207, 103, 14);
		add(lblNacionalidad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setEditable(false);
		textNacionalidad.setBounds(344, 232, 86, 20);
		add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		JButton btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.setBounds(344, 353, 128, 23);
		btnSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControladorPrincipal.getInstance().mostrarEquipo();
			}
		});
		add(btnSiguiente);
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public JTextField getTextId() {
		return textId;
	}

	public JTextField getTextApellidos() {
		return textApellidos;
	}

	public JTextField getTextEdad() {
		return textEdad;
	}

	public JTextField getTextNacionalidad() {
		return textNacionalidad;
	}
}
