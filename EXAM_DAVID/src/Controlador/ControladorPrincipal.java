package Controlador;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cadete;
import Model.CadetesModel;
import Model.IngresoLaby;
import Vista.VistaApp;

public class ControladorPrincipal {

	private static ControladorPrincipal instance = new ControladorPrincipal();

	private VistaApp va;
	private CadetesModel cm;
	private Cadete cadete;
	private IngresoLaby il;
	
	private ControladorPrincipal(){
		va = new VistaApp();
		cm = CadetesModel.getInstance();
		il = IngresoLaby.getInstance();
		try {
			cargarDatosPerfil();
			cargarDatosEquipo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ControladorPrincipal getInstance() {
		return instance;
	}
	
	public void mostrarPerfil() {
		// TODO Auto-generated method stub
		CardLayout c = (CardLayout) va.getContentPane().getLayout();
		c.show(va.getContentPane(), "VistaPerfil");
	}

	public void mostrarEquipo() {
		// TODO Auto-generated method stub
		CardLayout c = (CardLayout) va.getContentPane().getLayout();
		c.show(va.getContentPane(), "VistaEquipo");
	}
	
	public void mostrarComprobacion() {
		// TODO Auto-generated method stub
		CardLayout c = (CardLayout) va.getContentPane().getLayout();
		c.show(va.getContentPane(), "VistaComprobacion");
	}
	
	public void cargarDatosPerfil() throws SQLException{
		cadete = cm.perfil();
		va.getVistaPerfil().getTextNombre().setText(cadete.getNombre());
		va.getVistaPerfil().getTextId().setText(Integer.toString(cadete.getId()));
		va.getVistaPerfil().getTextApellidos().setText(cadete.getApellidos());
		va.getVistaPerfil().getTextEdad().setText(Integer.toString(cadete.getEdad()));
		va.getVistaPerfil().getTextNacionalidad().setText(cadete.getNacionalidad());
	}
	
	public void cargarDatosEquipo() throws SQLException{
		ArrayList<Cadete> cadetes = cm.equipo();
		va.getVistaEquipo().cargarDatosEquipo(cadetes);
	}
	
	public void cargarDatosCadete() throws SQLException{
		cadete = (Cadete) va.getVistaEquipo().getComboBox().getSelectedItem();
		String nombre = cadete.getNombre();
		cadete = cm.equipo(nombre);
		va.getVistaEquipo().getTextNombre().setText(nombre);
		int espacio = cadete.getApellidos().lastIndexOf(" ");
		va.getVistaEquipo().getTextApellido1().setText(cadete.getApellidos().substring(0, espacio));
		va.getVistaEquipo().getTextApellido2().setText(cadete.getApellidos().substring(espacio));
		va.getVistaEquipo().getTextId().setText(Integer.toString(cadete.getId()));
		va.getVistaEquipo().getTextNacionalidad().setText(cadete.getNacionalidad());
	}
	
	public void comprobar(){
		int index = Integer.parseInt(va.getVistaComprobacion().getTextId().getText());
		String apellido = va.getVistaComprobacion().getTextApellido1().getText();
		String mensaje = il.checkCod(index, apellido);
		va.getVistaComprobacion().getTextMensaje().setText(mensaje);
	}
}
