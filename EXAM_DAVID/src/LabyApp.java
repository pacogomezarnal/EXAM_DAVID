import Controlador.ControladorPrincipal;
import Model.ConexionDB;


public class LabyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean conectado = ConexionDB.getInstance().connectDB();
		//Comprovamos si estamos conectados o no, y si lo estamos, inciamos la aplicaci�n
		if(conectado == true){
			System.out.println("Te has conectado correctamente");
			ControladorPrincipal cp = ControladorPrincipal.getInstance();
		}else{
			System.out.println("Error de conexion");
		}
	}

}
