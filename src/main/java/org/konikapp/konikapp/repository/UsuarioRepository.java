package org.konikapp.konikapp.repository;

import org.konikapp.konikapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1")
	Usuario findByEmail(String email);
}
