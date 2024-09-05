package org.konikapp.konikapp.controller;

import java.util.List;

import org.konikapp.konikapp.exceptions.EmailNotFoundException;
import org.konikapp.konikapp.model.Usuario;
import org.konikapp.konikapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/kapp") //valor del endpoint
//CORS
@CrossOrigin(origins ="*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UsuarioController {
	// Llamar al service
	private UsuarioService usuarioService;
	
	// Inyeccion de dependencias en el constructor
		@Autowired
		public UsuarioController(UsuarioService usuarioService) {
			super();
			this.usuarioService = usuarioService;
		}
	
		
		// Mapear métodos (get, post, put, delete)
		@GetMapping("/konikappers")
		public List<Usuario> getMappingAll(){
			return usuarioService.getAll();
		}
		
		// Mapear método Post que reciba un nuevo objeto y el body del mismo
		@PostMapping
		public Usuario newUser(@RequestBody Usuario usuario) {
			return usuarioService.createUsuario(usuario);
		}
		
		
		// Mapear método Delete que apunte a un id específico. Para ello, debemos pemitir que el Id sea varibale en el endoint (@PathVariable).
	    @DeleteMapping ("/konikappers/{id}") // Las llaves significan que solo se tomara el valor del id
	    public void deleteUsuario(@PathVariable (name = "id") Long id) {
	        usuarioService.deleteUsuario(id);
	    }
		
	    
	  //Mapear método get by ID que apunte a un Id específico
	    @GetMapping ("/konikappers/{id}")
	    public Usuario getById (@PathVariable(name = "id") Long id) {
	        return usuarioService.getById(id);
	    }

	    // Mapear método getByEmail aplicando la Query (JPQL) y la excepción
	    // --- ResponseEntity<Entity> Es una clase de SpringBoot que me permite representar respuestas HTTP personalizables.
	    // --- @RequestParam (parámetros) permite recibir parámetros y valores.
	    // Creamos clase EmailNotFoundException y su clase controller EmailNotFoundController
	    @GetMapping ("konikappers/email")
	    public ResponseEntity<Usuario> getByEmail(@RequestParam(name = "konikmail") String email) {
	        Usuario usuarioByEmail = usuarioService.getByEmail(email);
	        if(usuarioByEmail == null) {
	            throw new EmailNotFoundException(email);//Exception
	        }
	        return new ResponseEntity<Usuario>(usuarioByEmail, HttpStatus.OK);
	    }
		
		
	 // Mapear método updateUser utilizando PUT. Necesitamos acceder al user mediante id (findById) y definir el nuevo valor.
	    @PutMapping("konikappers/{id}")
	    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable(name="id") Long id) {
	        return usuarioService.updateUsuario(usuario, id);
	    }
		
	    
		
		
		
		
		
		
		
		
	
}
