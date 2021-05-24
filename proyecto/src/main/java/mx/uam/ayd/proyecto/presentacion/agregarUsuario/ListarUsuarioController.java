package mx.uam.ayd.proyecto.presentacion.agregarUsuario;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;


@Controller
@Slf4j
public class ListarUsuarioController {
	@Autowired
	private ServicioUsuario servicioUsuario;
	


	/**
	 * 
	 * Método invocado cuando se hace una petición GET a la ruta
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listarUsuario", method = RequestMethod.GET)
    public String recuperaUsuarios(Model model) {
		
    		log.info("Iniciando Historia de usuario: Listar usuario");
			List<Usuario> usuarios = servicioUsuario.recuperaUsuarios();

  		  for(int i = 0; i < usuarios.size(); i++) {
  	            System.out.println(usuarios.get(i));
  	        }
  		  
			model.addAttribute("usuarios", usuarios);

    		// Redirige a esta vista
    		return "vistaListarUsuario/FormaListarUsuario";
    	
    }

	
    	
    
}
