package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.MutableComboBoxModel;

import Controlador.ControladorPrincipal;
import Model.Cadete;

public class VistaEquipo extends JPanel{
	
	private JTextField textNombre;
	private JTextField textId;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNacionalidad;
	private JComboBox<Cadete> comboBox;
	
	public VistaEquipo() {
		
		Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) dimPantalla.getWidth()/2, (int) (dimPantalla.getHeight()/1.5));
		setLayout(null);
		
		componentes();
		
		setVisible(true);
	}
	
	public void componentes(){
		comboBox = new JComboBox<Cadete>();
		comboBox.setBounds(70, 71, 128, 20);
		add(comboBox);
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {		
					if(comboBox.getSelectedIndex() > 0){
						ControladorPrincipal.getInstance().cargarDatosCadete();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(357, 74, 46, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(357, 99, 86, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(502, 74, 46, 14);
		add(lblNewLabel);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(502, 99, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(357, 130, 70, 14);
		add(lblerApellido);
		
		textApellido1 = new JTextField();
		textApellido1.setEditable(false);
		textApellido1.setBounds(357, 155, 86, 20);
		add(textApellido1);
		textApellido1.setColumns(10);
		
		JLabel lblApellido = new JLabel("2\u00BA Apellido");
		lblApellido.setBounds(357, 186, 86, 14);
		add(lblApellido);
		
		textApellido2 = new JTextField();
		textApellido2.setEditable(false);
		textApellido2.setBounds(357, 211, 86, 20);
		add(textApellido2);
		textApellido2.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(357, 242, 110, 14);
		add(lblNacionalidad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setEditable(false);
		textNacionalidad.setBounds(357, 267, 86, 20);
		add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		JButton btnAtras = new JButton("<< Atr\u00E1s");
		btnAtras.setBounds(70, 427, 128, 23);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControladorPrincipal.getInstance().mostrarPerfil();
			}
		});
		add(btnAtras);
		
		JButton btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.setBounds(431, 427, 128, 23);
		btnSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControladorPrincipal.getInstance().mostrarComprobacion();
			}
		});
		add(btnSiguiente);
	}

	public void cargarDatosEquipo(ArrayList<Cadete> cadetes) {
		// TODO Auto-generated method stub
		for(int i = 0; i < cadetes.size(); i++){
			comboBox.addItem(cadetes.get(i));
		}
	}
	
	public JTextField getTextApellido1() {
		return textApellido1;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public JTextField getTextId() {
		return textId;
	}

	public JTextField getTextApellido2() {
		return textApellido2;
	}

	public JTextField getTextNacionalidad() {
		return textNacionalidad;
	}

	public JComboBox<Cadete> getComboBox() {
		return comboBox;
	}
}
