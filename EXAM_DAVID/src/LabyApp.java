import Controlador.ControladorPrincipal;
import Model.ConexionDB;


public class LabyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean conectado = ConexionDB.getInstance().connectDB();
		if(conectado == true){
			System.out.println("Te has conectado correctamente");
			ControladorPrincipal cp = ControladorPrincipal.getInstance();
		}else{
			System.out.println("Error de conexion");
		}
	}

}
