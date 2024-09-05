package org.konikapp.konikapp.service;

import java.util.List;

import org.konikapp.konikapp.exceptions.UsuarioNotFoundException;
import org.konikapp.konikapp.model.Usuario;
import org.konikapp.konikapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class UsuarioService {
	private UsuarioRepository usuarioRepository;

	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	
	// Método para obtener todos los usuarios
		public List<Usuario> getAll() {
			return usuarioRepository.findAll();
		}
	
	// Método para crear un nuevo usuario
		public Usuario createUsuario(Usuario newUsuario) {
			return usuarioRepository.save(newUsuario);
		}
		
		// Método para eliminar un usuario mediante id con Exception
		public void deleteUsuario(Long id) {
			if (usuarioRepository.existsById(id)) {
				usuarioRepository.deleteById(id);
			} else {
				throw new UsuarioNotFoundException(id);
			}
		}
		
		// Método para recuperar usuarios por Id (validar si existe)
		public Usuario getById(Long id) {
			return usuarioRepository.findById(id)
					.orElseThrow(() -> new UsuarioNotFoundException(id));
		}
		
		// Método para recuperar usuario por Id (sin excepción, de tipo Optional)
		/*
		public Optional<Usuario> getById(Long id) {
			return usuarioRepository.findById(id);
		}
		*/
		
		// Método para recuperar usuarios por email 
		public Usuario getByEmail(String email) {
			return usuarioRepository.findByEmail(email);
		}
		
		// Metodo para actualizar informacion de usuarios permitiendo modificar el password
		public Usuario updateUsuario(Usuario usuario, Long id) {
			return usuarioRepository.findById(id)
					.map(userMap -> {
						userMap.setContraseña(usuario.getContraseña());
						return usuarioRepository.save(userMap);
					})
					.orElseThrow(()-> new UsuarioNotFoundException(id));
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
	

