package TareasAdimistracion.Proyecto;
import java.util.List;

import TareasAdimistracion.Proyecto.UserService;

public class App 
{
    public static void main(String[] args) {
    	
    	//--------------USUARIOS API------------------
    	 new UserController(new UserService());
        //--------------TAREAS API------------------
    	 new TareaController(new TareaService());
    	//--------------RESTTEMPLATE - AUTENTIFICACION API------------------ 
    	 AutenticacionController ac = new AutenticacionController();
    	 Token token = ac.getToken();
    	 List<User> UsuariosApi = ac.getUserFromApi(token.getToken());
    	 
    	 System.out.println("Token: "+token.getToken());
    	 System.out.println("expires_in: "+token.getExpires_in());
    	 for (int i=0; i< UsuariosApi.size(); i++) {
        	 System.out.println("usuarios: "+ UsuariosApi.get(i).getFirstName());

    	 }
    	 


    }
}
