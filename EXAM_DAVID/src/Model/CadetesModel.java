package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class CadetesModel {

	private static CadetesModel instance = new CadetesModel();
	private Connection conexion = null;// maneja la conexió
	private Statement instruccion = null;
	private ResultSet conjuntoResultados = null;

	private CadetesModel(){
		conexion=ConexionDB.getConexion();
	}

	public Cadete perfil() throws SQLException{

		Cadete cadete = null;
		instruccion = this.conexion.createStatement();
		conjuntoResultados = instruccion.executeQuery("SELECT * FROM cadetes WHERE id = 2");

		try {
			while (conjuntoResultados.next()) {
				String nombre = conjuntoResultados.getString("nombre");
				String apellidos = conjuntoResultados.getString("apellidos");
				int edad = conjuntoResultados.getInt("edad");
				String nacionalidad = conjuntoResultados.getString("nacionalidad");
				int equipo = conjuntoResultados.getInt("equipo");
				cadete = new Cadete(2, nombre, apellidos, edad, nacionalidad, equipo);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return cadete;
	}

	public ArrayList<Cadete> equipo() throws SQLException{
		Cadete cadete = null;
		ArrayList<Cadete> cadetes = new ArrayList<Cadete>();
		instruccion = this.conexion.createStatement();
		conjuntoResultados = instruccion.executeQuery("SELECT * FROM cadetes WHERE equipo = 2");

		try {
			while (conjuntoResultados.next()) {
				int id = conjuntoResultados.getInt("id");
				String nombre = conjuntoResultados.getString("nombre");
				String apellidos = conjuntoResultados.getString("apellidos");
				int edad = conjuntoResultados.getInt("edad");
				String nacionalidad = conjuntoResultados.getString("nacionalidad");
				int equipo = conjuntoResultados.getInt("equipo");
				cadete = new Cadete(id, nombre, apellidos, edad, nacionalidad, equipo);
				cadetes.add(cadete);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return cadetes;
	}

	public Cadete equipo(String nombre) throws SQLException{

		Cadete cadete = null;
		instruccion = this.conexion.createStatement();
		conjuntoResultados = instruccion.executeQuery("SELECT * FROM cadetes WHERE nombre = '"+nombre+"';");

		try {
			while (conjuntoResultados.next()) {
				int id = conjuntoResultados.getInt("id");
				String apellidos = conjuntoResultados.getString("apellidos");
				int edad = conjuntoResultados.getInt("edad");
				String nacionalidad = conjuntoResultados.getString("nacionalidad");
				int equipo = conjuntoResultados.getInt("equipo");
				cadete = new Cadete(id, nombre, apellidos, edad, nacionalidad, equipo);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return cadete;
	}

	public static CadetesModel getInstance() {
		return instance;
	}
}
